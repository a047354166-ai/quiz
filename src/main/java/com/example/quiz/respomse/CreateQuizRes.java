package com.example.quiz.respomse;

public class CreateQuizRes {

	private int code;
	
	private String message;
	
	private Integer quizId;
	
	private Integer userId;

	
	public CreateQuizRes() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CreateQuizRes(int code, String message, Integer quizId) {
		super();
		this.code = code;
		this.message = message;
		this.quizId = quizId;
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


	public Integer getQuizId() {
		return quizId;
	}


	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
