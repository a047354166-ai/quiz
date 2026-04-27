package com.example.quiz.constants;

public enum ReplyMessage {

	SUCCESS(200, "Success!!"), //
	LOGIN_SUCCESS(200, "Login is success!!"),//
	PARAM_EMAIL_ERROW(400, "Param email error!!"), //
	PARAM_PASSWORD_ERROW(400, "Parm password error!!");
	
	private int code;
	
	private String message;

	private ReplyMessage(int code, String message) {
		this.code = code;
		this.message = message;
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
	
	
	
	
}
