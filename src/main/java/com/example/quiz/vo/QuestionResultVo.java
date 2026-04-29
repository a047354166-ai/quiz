package com.example.quiz.vo;

import java.util.List;

public class QuestionResultVo {

	private Integer questionId;
	private String question;
	private String type;
	private List<OptionResultVo> optionResultList;
	private List<String> text;

	public QuestionResultVo(Integer questionId, String question, String type,
			List<OptionResultVo> optionResultList, List<String> text) {
		this.questionId = questionId;
		this.question = question;
		this.type = type;
		this.optionResultList = optionResultList;
		this.text = text;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public String getQuestion() {
		return question;
	}

	public String getType() {
		return type;
	}

	public List<OptionResultVo> getOptionResultList() {
		return optionResultList;
	}

	public List<String> getText() {
		return text;
	}
}
	
	
	

