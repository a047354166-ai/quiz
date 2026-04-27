package com.example.quiz.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.quiz.dao.QuestionDao;
import com.example.quiz.dao.QuizDao;
import com.example.quiz.entity.Question;
import com.example.quiz.entity.Quiz;
import com.example.quiz.request.CreateQuizReq;
import com.example.quiz.request.UpdateQuizReq;
import com.example.quiz.respomse.BasicInfoRes;
import com.example.quiz.respomse.CreateQuizRes;
import com.example.quiz.respomse.FrontQuizListRes;
import com.example.quiz.respomse.GetAllQuizRes;
import com.example.quiz.respomse.GetQuizDetailRes;
import com.example.quiz.respomse.QuestionRes;
import com.example.quiz.vo.FrontQuizVo;
import com.example.quiz.vo.QuestionVo;
import com.example.quiz.vo.QuizListVo;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuestionDao questionDao;

    // 新增問卷
    @Transactional
    public CreateQuizRes createQuiz(CreateQuizReq req) {

        if (req == null) {
            return new CreateQuizRes(400, "request不可為空", null);
        }

        if (req.getTitle() == null || req.getTitle().isBlank()) {
            return new CreateQuizRes(400, "問卷標題不可為空", null);
        }

        if (req.getStartDate() == null || req.getEndDate() == null) {
            return new CreateQuizRes(400, "開始日期與結束日期不可為空", null);
        }

        if (req.getStartDate().isAfter(req.getEndDate())) {
            return new CreateQuizRes(400, "開始日期不可大於結束日期", null);
        }

        quizDao.insertQuiz(
                req.getTitle(),
                req.getDescription(),
                req.getStartDate(),
                req.getEndDate(),
                req.getPublished(),
                req.getUserId()
        );

        Integer quizId = quizDao.getLastInsertId();

        List<QuestionVo> questionList = req.getQuestionList();
        if (questionList != null && !questionList.isEmpty()) {
            for (int i = 0; i < questionList.size(); i++) {
                QuestionVo q = questionList.get(i);

                questionDao.insertQuestion(
                        quizId,
                        i + 1,
                        q.getQuestion(),
                        q.getType(),
                        q.getRequired(),
                        q.getOptions()
                );
            }
        }

        return new CreateQuizRes(200, "新增問卷成功", quizId);
    }

    // 刪除問卷
    @Transactional
    public BasicInfoRes deleteQuiz(Integer quizId) {
        if (quizId == null) {
            return new BasicInfoRes(400, "quizId不可為空");
        }

        if (!quizDao.existsById(quizId)) {
            return new BasicInfoRes(404, "問卷不存在");
        }

        questionDao.deleteQuestionsByQuizId(quizId);
        quizDao.deleteQuizById(quizId);

        return new BasicInfoRes(200, "問卷刪除成功");
    }

    // 判斷是否在進行中
    private boolean isOngoing(LocalDate today, LocalDate startDate, LocalDate endDate) {
        return !today.isBefore(startDate) && !today.isAfter(endDate);
    }

    // 判斷是否已結束
    private boolean isFinished(LocalDate today, LocalDate endDate) {
        return today.isAfter(endDate);
    }

    // 更新問卷
    @Transactional
    public BasicInfoRes updateQuiz(UpdateQuizReq req) {

        if (req == null) {
            return new BasicInfoRes(400, "request不可為空");
        }

        if (req.getQuizId() == null) {
            return new BasicInfoRes(400, "quizId不可為空");
        }

        if (req.getTitle() == null || req.getTitle().isBlank()) {
            return new BasicInfoRes(400, "問卷標題不可為空");
        }

        if (req.getStartDate() == null || req.getEndDate() == null) {
            return new BasicInfoRes(400, "開始日期與結束日期不可為空");
        }

        Quiz oldQuiz = quizDao.getQuizById(req.getQuizId());
        if (oldQuiz == null) {
            return new BasicInfoRes(404, "問卷不存在");
        }

        // 檢查新資料的開始日期和結束日期
        if (req.getStartDate().isAfter(req.getEndDate())) {
            return new BasicInfoRes(400, "開始日期不能在結束日期之後");
        }

        // 用資料庫原本的資料判斷是否可以修改
        LocalDate today = LocalDate.now();
        boolean isPublished = Boolean.TRUE.equals(oldQuiz.getPublished());

        if (isPublished && (
                isOngoing(today, oldQuiz.getStartDate(), oldQuiz.getEndDate()) ||
                isFinished(today, oldQuiz.getEndDate())
        )) {
            return new BasicInfoRes(400, "問卷已發布且為進行中或已完成，不能修改");
        }

        quizDao.updateQuiz(
                req.getTitle(),
                req.getDescription(),
                req.getStartDate(),
                req.getEndDate(),
                req.getPublished(),
                req.getQuizId()
        );

        questionDao.deleteQuestionsByQuizId(req.getQuizId());

        List<QuestionVo> questionList = req.getQuestionList();
        if (questionList != null && !questionList.isEmpty()) {
            for (int i = 0; i < questionList.size(); i++) {
                QuestionVo q = questionList.get(i);
                questionDao.insertQuestion(
                        req.getQuizId(),
                        i + 1,
                        q.getQuestion(),
                        q.getType(),
                        q.getRequired(),
                        q.getOptions()
                );
            }
        }

        return new BasicInfoRes(200, "修改成功");
    }

    // 查全部問卷
    public GetAllQuizRes getAllQuiz(Integer userId) {
        List<Quiz> quizList = quizDao.getAllQuizByUserId(userId);
        List<QuizListVo> resList = new ArrayList<>();

        for (Quiz quiz : quizList) {
            QuizListVo vo = new QuizListVo(
                    quiz.getId(),
                    quiz.getTitle(),
                    quiz.getDescription(),
                    quiz.getStartDate(),
                    quiz.getEndDate(),
                    quiz.getPublished()
            );
            resList.add(vo);
        }

        return new GetAllQuizRes(200, "查詢成功", resList);
    }

    // 查單筆問卷
    public GetQuizDetailRes getQuizById(Integer quizId) {
        if (quizId == null) {
            return new GetQuizDetailRes(400, "quizId不可為空");
        }

        Quiz quiz = quizDao.getQuizById(quizId);
        if (quiz == null) {
            return new GetQuizDetailRes(404, "問卷不存在");
        }

        List<Question> questionList = questionDao.getQuestionsByQuizId(quizId);
        List<QuestionRes> questionResList = new ArrayList<>();

        for (Question q : questionList) {
            QuestionRes questionRes = new QuestionRes(
                    q.getQuestionId(),
                    q.getQuestion(),
                    q.getType(),
                    q.getRequired(),
                    q.getOptions()
            );
            questionResList.add(questionRes);
        }

        GetQuizDetailRes res = new GetQuizDetailRes(200, "查詢成功");
        res.setQuizId(quiz.getId());
        res.setTitle(quiz.getTitle());
        res.setDescription(quiz.getDescription());
        res.setStartDate(quiz.getStartDate());
        res.setEndDate(quiz.getEndDate());
        res.setPublished(quiz.getPublished());
        res.setQuestionList(questionResList);

        return res;
    }
    
 // 查詢給填問卷者看的問卷列表
    public FrontQuizListRes getFrontQuizList() {

    	// 從資料庫查 published = true 的問卷
    	List<Quiz> quizList = quizDao.getPublishedQuizList();

    	// 準備回傳給前端的資料
    	List<FrontQuizVo> voList = new ArrayList<>();

    	for (Quiz quiz : quizList) {
    		FrontQuizVo vo = new FrontQuizVo(
    				quiz.getId(),
    				quiz.getTitle(),
    				quiz.getStartDate(),
    				quiz.getEndDate()
    		);

    		voList.add(vo);
    	}

    	return new FrontQuizListRes(200, "查詢成功", voList);
    }
}