package com.account.mapper;

import java.sql.SQLException;
import java.util.List;

import com.account.domain.Category;

public interface CategoryMapper {

	public void insertCategory(Category vo) throws SQLException;

	public void deleteCategory(Category vo)throws Exception;

	public void updateCategory(Category vo)throws Exception;
	
	public List selectCategory(Category vo)throws Exception;
}
