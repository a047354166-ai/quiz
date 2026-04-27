package com.example.quiz.respomse;

import java.util.List;

import com.example.quiz.vo.QuizListVo;

public class GetAllQuizRes {

	private int code;
	
	private String message;
	
	private List<QuizListVo> quizList;

	public GetAllQuizRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetAllQuizRes(int code, String message, List<QuizListVo> quizList) {
		super();
		this.code = code;
		this.message = message;
		this.quizList = quizList;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<QuizListVo> getQuizList() {
		return quizList;
	}

	public void setQuizList(List<QuizListVo> quizList) {
		this.quizList = quizList;
	}
	
	
}
