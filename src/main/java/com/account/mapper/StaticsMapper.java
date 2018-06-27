package com.account.mapper;

import java.util.List;

import com.account.domain.Account;

public interface StaticsMapper {

	
	/**
	 * 1. 당월 수입 내역 비율
	 * 2. 당월 지출 내역 비율
	 * 3. 월별 지출 목록별 합계 
	 * 4. 월별 수입 목록별 합계
	 */
	
	public List selectCurentMonthSpandingRate(Account param);
	

}
