package com.example.quiz.vo;

public class FillinRecordVo {

	private Integer questionId;
	
	private String question;
	
	private String type;
	
	private Boolean required;
	
	private String answer;

	public FillinRecordVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public FillinRecordVo(Integer questionId, String question, String type, Boolean required, String answer) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.type = type;
		this.required = required;
		this.answer = answer;
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
