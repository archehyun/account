package com.account.domain;

import java.util.Date;

public class Account {
	
	public static final int INCOME=2;
	public static final int SPADING=1;
	
	public String breakdown;// 내역	
	
	public int getInout_type() {
		return inout_type;
	}
	public void setInout_type(int inout_type) {
		this.inout_type = inout_type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	//지출, 수입 구분 : 1, 2
	private int inout_type;
	
	//분류
	private String category;
	
	//입력ID
	private int input_nn;
	
	public int getInput_nn() {
		return input_nn;
	}
	public void setInput_nn(int input_nn) {
		this.input_nn = input_nn;
	}
	
	//날짜
	public Date getInput_date() {
		return input_date;
	}
	public void setInput_date(Date input_date) {
		this.input_date = input_date;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	private Date input_date;
	
	//금액
	private int money;
	
	private String contents;	

}
