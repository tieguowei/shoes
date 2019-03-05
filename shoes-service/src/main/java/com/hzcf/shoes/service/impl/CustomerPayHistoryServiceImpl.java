
package com.hzcf.shoes.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzcf.shoes.dao.CustomerPayHistoryMapper;
import com.hzcf.shoes.service.CustomerPayHistoryService;

@Service
public class CustomerPayHistoryServiceImpl implements CustomerPayHistoryService{

	@Autowired
	private CustomerPayHistoryMapper  customerPayHistoryMapper;

	@Override
	public List<Map<String, Object>> getCustomerPaymentHistory(String customerName) {
		return customerPayHistoryMapper.getCustomerPaymentHistory(customerName);
	}






}
