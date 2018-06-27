package com.account.domain;


import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AccountFX {

	StringProperty content;
	StringProperty category_name;
	IntegerProperty input_nn;
	IntegerProperty inout;
	IntegerProperty money;
	Date input_date;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd");
	public AccountFX(Account next) {
		this.content = new SimpleStringProperty(next.getContents());
		this.input_nn = new SimpleIntegerProperty(next.getInput_nn());
		this.money = new SimpleIntegerProperty(next.getMoney());
		this.inout = new SimpleIntegerProperty(next.getInout_type());
		this.category_name = new SimpleStringProperty(next.getCategory());
		this.input_date = next.getInput_date();

	}
	public String getContent() {
		return content.get();

	}
	public int getMoney()
	{
		return money.get();
	}
	public int getInput_nn()
	{
		return input_nn.get();
	}
	public void setMoney(int money)
	{
		this.money.set(money);
	}
	public void setInput_nn(int input_nn)
	{
		this.input_nn.set(input_nn);
	}
	public void setContent(String content)
	{
		this.content.set(content);
	}
	public Date getInput_date() {
		return input_date;
	}
	public void setInput_date(Date input_date) {
		this.input_date=input_date;
	}
	
	public int getInout()
	{
		return inout.get();
	}
	public void setInout(int inout)
	{
		this.inout.set(inout);
	}
	public String getCategory_name()
	{
		return category_name.get();
	}
	public void setCategory(String category_name)
	{
		this.category_name.set(category_name);
	}

}
