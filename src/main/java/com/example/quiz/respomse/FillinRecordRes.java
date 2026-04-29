package com.example.quiz.respomse;

import java.time.LocalDate;
import java.util.List;

import com.example.quiz.vo.FillinRecordVo;

public class FillinRecordRes {

	private int code;
	private String message;

	private Integer quizId;
	private String title;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;

	private String email;
	private String phone;
	private LocalDate fillinDate;

	private List<FillinRecordVo> recordList;

	public FillinRecordRes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FillinRecordRes(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public FillinRecordRes(int code, String message, Integer quizId, String title, String description,
			LocalDate startDate, LocalDate endDate, String email, String phone, LocalDate fillinDate,
			List<FillinRecordVo> recordList) {
		super();
		this.code = code;
		this.message = message;
		this.quizId = quizId;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.email = email;
		this.phone = phone;
		this.fillinDate = fillinDate;
		this.recordList = recordList;
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

	public LocalDate getFillinDate() {
		return fillinDate;
	}

	public void setFillinDate(LocalDate fillinDate) {
		this.fillinDate = fillinDate;
	}

	public List<FillinRecordVo> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<FillinRecordVo> recordList) {
		this.recordList = recordList;
	}
	
	

}
