package com.example.quiz.respomse;

public class UserFillenLoginRes {

	private int code;

	private String message;

	private Integer userId;

	private String email;

	private String name;

	public UserFillenLoginRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserFillenLoginRes(int code, String message, Integer userId, String email, String name) {
		super();
		this.code = code;
		this.message = message;
		this.userId = userId;
		this.email = email;
		this.name = name;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
