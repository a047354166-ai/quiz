package com.example.quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.quiz.dao.FillinDao;
import com.example.quiz.dao.QuestionDao;
import com.example.quiz.dao.QuizDao;
import com.example.quiz.entity.Fillin;
import com.example.quiz.entity.Question;
import com.example.quiz.entity.Quiz;
import com.example.quiz.request.FillinAnswerReq;
import com.example.quiz.request.SubmitFillinReq;
import com.example.quiz.respomse.BasicInfoRes;
import com.example.quiz.respomse.FilledQuizIdsRes;
import com.example.quiz.respomse.FillinRecordRes;
import com.example.quiz.vo.FillinRecordVo;

@Service
public class FillinService {

	@Autowired
	private FillinDao fillinDao;
	
	@Autowired
	private QuizDao quizDao;
	
	@Autowired
	private QuestionDao questionDao;
	
	
	// 送出填答
		public BasicInfoRes submit(SubmitFillinReq req) {

			// 檢查問卷 id
			if (req.getQuizId() == null) {
				return new BasicInfoRes(400, "問卷編號不可為空");
			}

			// 檢查 email
			if (!StringUtils.hasText(req.getEmail())) {
				return new BasicInfoRes(400, "Email 不可為空");
			}

			// 檢查電話
			if (!StringUtils.hasText(req.getPhone())) {
				return new BasicInfoRes(400, "電話不可為空");
			}

			// 檢查答案
			if (CollectionUtils.isEmpty(req.getAnswerList())) {
				return new BasicInfoRes(400, "答案不可為空");
			}

			// 檢查是否已經填過
			if (fillinDao.countByQuizIdAndEmail(req.getQuizId(), req.getEmail()) > 0) {
				return new BasicInfoRes(400, "您已經填寫過此問卷");
			}

			// 逐題寫入 fillin
			for (FillinAnswerReq answer : req.getAnswerList()) {
				fillinDao.insertFillin(
						req.getQuizId(),
						answer.getQuestionId(),
						req.getEmail(),
						req.getPhone(),
						answer.getAnswer()
				);
			}

			return new BasicInfoRes(200, "送出成功");
		}
		
		// 查詢目前登入者已經填過的問卷編號
		public FilledQuizIdsRes getFilledQuizIds(String email) {
			if (!StringUtils.hasText(email)) {
				return new FilledQuizIdsRes(400, "Email 不可為空", null);
			}

			List<Integer> quizIds = fillinDao.getFilledQuizIds(email);

			return new FilledQuizIdsRes(200, "查詢成功", quizIds);
		}
	
		public FillinRecordRes getRecord(Integer quizId, String email) {
			if(quizId == null) {
				return new FillinRecordRes(400, "問卷編號不可為空");
			}
			
			if(!StringUtils.hasText(email)) {
				return new FillinRecordRes(400, "email 不可為空");
			}
			
			//查詢問卷基本資料
			Quiz quiz = quizDao.findById(quizId).orElse(null);
			if(quiz == null) {
				return new FillinRecordRes(404, "問卷不存在");
			}
			// 查詢這個使用者的填答紀錄
			List<Fillin> fillinList = fillinDao.getRecord(quizId, email);

			if (fillinList == null || fillinList.isEmpty()) {
				return new FillinRecordRes(404, "尚未填寫此問卷");
			}

			// 轉換成前端要看的格式
			List<FillinRecordVo> recordVoList = new ArrayList<>();

			for (Fillin fillin : fillinList) {

				// 依 quizId + questionId 查題目內容
				Question question = questionDao.getQuestionById(quizId, fillin.getQuestionId());

				if (question == null) {
					continue;
				}

				FillinRecordVo vo = new FillinRecordVo(
						fillin.getQuestionId(),
						question.getQuestion(),
						question.getType(),
						question.getRequired(),
						fillin.getAnswers()
				);

				recordVoList.add(vo);
			}

			// 取第一筆取得 phone / fillinDate，因為同一份問卷每題都會存一樣的 email、phone、date
			Fillin first = fillinList.get(0);

			return new FillinRecordRes(
					200,
					"查詢成功",
					quiz.getId(),
					quiz.getTitle(),
					quiz.getDescription(),
					quiz.getStartDate(),
					quiz.getEndDate(),
					first.getEmail(),
					first.getPhone(),
					first.getFillinDate(),
					recordVoList
			);
			
		}
}
