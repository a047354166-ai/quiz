package com.example.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quiz.request.SubmitFillinReq;
import com.example.quiz.respomse.BasicInfoRes;
import com.example.quiz.respomse.FilledQuizIdsRes;
import com.example.quiz.respomse.FillinRecordRes;
import com.example.quiz.service.FillinService;

@RestController
@RequestMapping("/fillin")
@CrossOrigin(origins = "http://localhost:4200")
public class FillinController {

	@Autowired
	private FillinService fillinService;

	// 填問卷者送出答案
	@PostMapping("/submit")
	public BasicInfoRes submit(@RequestBody SubmitFillinReq req) {
		return fillinService.submit(req);
	}
	
	// 查詢某位填問卷者已填過哪些問卷
	@GetMapping("/filledQuizIds/{email}")
	public FilledQuizIdsRes getFilledQuizIds(@PathVariable("email") String email) {
		return fillinService.getFilledQuizIds(email);
	}
	
	// 查詢填問卷者自己的填寫紀錄
	@GetMapping("/record/{quizId}/{email}")
	public FillinRecordRes getRecord(
			@PathVariable("quizId") Integer quizId,
			@PathVariable("email") String email) {
		return fillinService.getRecord(quizId, email);
	}
}