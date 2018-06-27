package com.account.mapper;

import java.sql.SQLException;
import java.util.List;

import com.account.domain.Account;

public interface AccountMapper {

	public void insertAccount(Account vo) throws SQLException;

	public void deleteAccount(Account vo)throws Exception;

	public void updateAccount(Account vo)throws Exception;
	
	public List selectAccount(Account vo)throws Exception;
	
	
}
