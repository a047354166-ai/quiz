package com.example.quiz.respomse;

import java.util.List;

import com.example.quiz.vo.FrontQuizVo;

public class FrontQuizListRes {

	private int code;
	
	private String message;
	
	private List<FrontQuizVo> quizList;

	public FrontQuizListRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FrontQuizListRes(int code, String message, List<FrontQuizVo> quizList) {
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

	public List<FrontQuizVo> getQuizList() {
		return quizList;
	}

	public void setQuizList(List<FrontQuizVo> quizList) {
		this.quizList = quizList;
	}
	
	
}
