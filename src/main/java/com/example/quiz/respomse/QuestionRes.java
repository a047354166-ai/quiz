package com.example.quiz.respomse;

public class QuestionRes {

	private Integer questionId;
	
	private String question;
	
	private String type;
	
	private Boolean required;
	
	private String options;

	public QuestionRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionRes(Integer questionId, String question, String type, Boolean required, String options) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.type = type;
		this.required = required;
		this.options = options;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}
	
	
}
