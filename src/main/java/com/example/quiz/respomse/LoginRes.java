package com.example.quiz.respomse;

public class LoginRes {

	private int code;
	
	private String message;
	
	private Integer userId;

	public LoginRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginRes(int code, String message, Integer userId) {
		super();
		this.code = code;
		this.message = message;
		this.userId = userId;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
