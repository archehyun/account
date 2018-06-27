package com.account.mapper;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.account.domain.Account;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountMapperTest {
	
	@Autowired
	AccountMapper mapper;

	@Test
	public void testInsertAccount() {
		Account account = new Account();
		account.setCategory("test");
		account.setContents("testContent");
		account.setMoney(123);
		account.setInout_type(1);
		account.setInput_date(new Date());
		
		try {
			mapper.insertAccount(account);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	@Test
	public void testUpdateAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteAccount() {
		fail("Not yet implemented");
	}



	@Test
	public void testSelectAccount()  {
		/*try {
		List li=mapper.selectAccount(new Account());
		assertNotNull(li);
		}catch(Exception e)
		{
			e.printStackTrace();
		}*/
	}

}
