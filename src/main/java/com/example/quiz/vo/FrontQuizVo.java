package com.example.quiz.vo;

import java.time.LocalDate;

public class FrontQuizVo {

	private Integer id;
	
	private String title;
	
	private LocalDate startDate;
	
	private LocalDate endDate;

	public FrontQuizVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FrontQuizVo(Integer id, String title, LocalDate startDate, LocalDate endDate) {
		super();
		this.id = id;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	
	
}
