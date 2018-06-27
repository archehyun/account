package com.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.mapper.AccountMapper;

@RestController
public class MainController {
	
	@Autowired
	AccountMapper mapper;	
	
	
	@RequestMapping("/")
	public String home()
	{
		try {
			List li=mapper.selectAccount(null);
			
			System.out.println("size:"+li.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "account test";
	} 
}