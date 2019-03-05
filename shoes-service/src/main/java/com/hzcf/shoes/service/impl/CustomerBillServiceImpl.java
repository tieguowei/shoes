
package com.hzcf.shoes.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzcf.shoes.dao.CustomerPaymentRecordMapper;
import com.hzcf.shoes.model.CustomerPaymentRecord;
import com.hzcf.shoes.service.CustomerBillService;

@Service
public class CustomerBillServiceImpl implements CustomerBillService{

	@Autowired
	private CustomerPaymentRecordMapper  customerPaymentRecordMapper;

	@Override
	public void insertCustomerBill(CustomerPaymentRecord customerbill) {
		customerPaymentRecordMapper.insertSelective(customerbill);	
	}

	

	@Override
	public Map<String, Object> getTotaMoneyOwed(String customerName) {
		return customerPaymentRecordMapper.getTotaMoneyOwed(customerName);
	}

	@Override
	public Map<String, Object> getLastOneTime(String customerName) {
		return customerPaymentRecordMapper.getLastOneTime(customerName);
	}




}
