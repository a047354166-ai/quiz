package com.example.quiz.entity;

import java.io.Serializable;
import java.util.Objects;

public class QuestionId implements Serializable{

	private Integer quizId;
	
	private Integer questionId;

	public QuestionId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionId(Integer quizId, Integer questionId) {
		super();
		this.quizId = quizId;
		this.questionId = questionId;
	}

	public Integer getQuizId() {
		return quizId;
	}

	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof QuestionId)) {
			return false;
		}
		QuestionId other = (QuestionId) obj;
		return Objects.equals(quizId, other.quizId)
				&& Objects.equals(questionId, other.questionId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(quizId, questionId);
	}
	
	
}
