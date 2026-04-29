package com.example.quiz.respomse;

import java.util.List;

public class FilledQuizIdsRes {


	private int code;
	
	private String message;
	
	private List<Integer> quizIds;

	public FilledQuizIdsRes(int code, String message, List<Integer> quizIds) {
		super();
		this.code = code;
		this.message = message;
		this.quizIds = quizIds;
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

	public List<Integer> getQuizIds() {
		return quizIds;
	}

	public void setQuizIds(List<Integer> quizIds) {
		this.quizIds = quizIds;
	}
	
	
}
