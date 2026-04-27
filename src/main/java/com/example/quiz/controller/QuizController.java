package com.example.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quiz.request.CreateQuizReq;
import com.example.quiz.request.UpdateQuizReq;
import com.example.quiz.respomse.BasicInfoRes;
import com.example.quiz.respomse.CreateQuizRes;
import com.example.quiz.respomse.GetAllQuizRes;
import com.example.quiz.respomse.GetQuizDetailRes;
import com.example.quiz.service.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin(origins = "http://localhost:4200")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	//新增問卷
	@PostMapping("/create")
	public CreateQuizRes createQuiz(@RequestBody CreateQuizReq req) {
		return quizService.createQuiz(req);
	}
	
	//刪除問卷
	@DeleteMapping("/delete/{quizId}")
	public BasicInfoRes deleteQuiz(@PathVariable("quizId") Integer quizId) {
		return quizService.deleteQuiz(quizId);
		
		
	}
	
	//更新問卷
	@PutMapping("/update")
	public BasicInfoRes updateQuiz(@RequestBody UpdateQuizReq req) {
		return quizService.updateQuiz(req);
	}
	
	//取得所有問卷
	@GetMapping("/getAll/{userId}")
	public GetAllQuizRes getAllQuiz(@PathVariable("userId") Integer userId) {
	    return quizService.getAllQuiz(userId);
	}
	
	@GetMapping("/get/{quizId}")
	public GetQuizDetailRes getQuizById(@PathVariable("quizId") Integer quizId) {
		return quizService.getQuizById(quizId);
	}
}
