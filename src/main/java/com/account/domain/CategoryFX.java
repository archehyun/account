package com.account.domain;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CategoryFX {
	StringProperty category_name;
	IntegerProperty category_id;
	IntegerProperty category_type;
	public String getCategory_name() {
		return category_name.get();
	}
	public void setCategory_name(String category_name) {
		this.category_name.set(category_name);
	}
	public void setCategory_id(int category_id) {
		this.category_id.set(category_id);
	}
	public CategoryFX(Category item) {
		this.category_id = new SimpleIntegerProperty(item.getCategory_id());
		this.category_name = new SimpleStringProperty(item.getCategory_name());
		this.category_type = new SimpleIntegerProperty(item.getCategory_type());
	}
	public int getCategory_id()
	{
		return category_id.get();
	}
	public int getCategory_type()
	{
		return category_type.get();
	}
	public void setCategory_type(int category_type)
	{
		this.category_type.set(category_type);
	}
	public String toString() {
		return category_name.get();
	}
}
