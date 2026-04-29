package com.example.quiz.respomse;

import java.util.List;

import com.example.quiz.vo.QuestionResultVo;

public class QuizResultRes {

	private int code;
	
	private String message;
	
	private Integer quizId;
	
	private String title;
	
	private int totalCount;
	
	private List<QuestionResultVo> resultList;

	
	public QuizResultRes(int code, String message) {
		super();
		this.code = code;
		this.message = message;
		
	}
	public QuizResultRes(int code, String message, Integer quizId, String title, int totalCount,
			List<QuestionResultVo> resultList) {
		super();
		this.code = code;
		this.message = message;
		this.quizId = quizId;
		this.title = title;
		this.totalCount = totalCount;
		this.resultList = resultList;
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

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<QuestionResultVo> getResultList() {
		return resultList;
	}

	public void setResultList(List<QuestionResultVo> resultList) {
		this.resultList = resultList;
	}
	
	
}
