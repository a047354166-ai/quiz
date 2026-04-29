package com.example.quiz.request;

import java.util.List;

public class SubmitFillinReq {

	private Integer quizId;
	
	private String email;
	
	private String phone;
	
	private List<FillinAnswerReq> answerList;

	public Integer getQuizId() {
		return quizId;
	}

	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<FillinAnswerReq> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<FillinAnswerReq> answerList) {
		this.answerList = answerList;
	}

}
