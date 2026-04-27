package com.example.quiz.respomse;

import java.time.LocalDate;
import java.util.List;

public class GetQuizDetailRes {

	private int code;
	
	private String message;

	private Integer quizId;
	
	private String title;
	
	private String description;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private Boolean published;
	
	private List<QuestionRes> questionList;

	public GetQuizDetailRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetQuizDetailRes(int code, String message) {
		super();
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

	public Integer getQuizId() {
		return quizId;
	}

	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	public List<QuestionRes> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<QuestionRes> questionList) {
		this.questionList = questionList;
	}
	
	
	
	
}
