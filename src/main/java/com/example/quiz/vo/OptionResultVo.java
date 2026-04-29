package com.example.quiz.vo;

public class OptionResultVo {

	private String option;
	
	private int count;
	
	private double percent;

	public OptionResultVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OptionResultVo(String option, int count, double percent) {
		super();
		this.option = option;
		this.count = count;
		this.percent = percent;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}
	
	
}
