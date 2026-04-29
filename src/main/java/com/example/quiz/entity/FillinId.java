package com.example.quiz.entity;

import java.io.Serializable;
import java.util.Objects;

public class FillinId implements Serializable {

	private Integer quizId;
	private Integer questionId;
	private String email;

	public FillinId() {
	}

	public FillinId(Integer quizId, Integer questionId, String email) {
		this.quizId = quizId;
		this.questionId = questionId;
		this.email = email;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FillinId)) {
			return false;
		}

		FillinId other = (FillinId) obj;

		return Objects.equals(quizId, other.quizId)
				&& Objects.equals(questionId, other.questionId)
				&& Objects.equals(email, other.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(quizId, questionId, email);
	}
}