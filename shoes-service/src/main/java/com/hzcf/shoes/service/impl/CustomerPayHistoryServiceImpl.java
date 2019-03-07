
package com.hzcf.shoes.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzcf.shoes.dao.CustomerPayHistoryMapper;
import com.hzcf.shoes.model.CustomerPayHistory;
import com.hzcf.shoes.service.CustomerPayHistoryService;
import com.hzcf.shoes.util.PageModel;

@Service
public class CustomerPayHistoryServiceImpl implements CustomerPayHistoryService{

	@Autowired
	private CustomerPayHistoryMapper  customerPayHistoryMapper;

	@Override
	public List<Map<String, Object>> getCustomerPaymentHistory(String customerName) {
		return customerPayHistoryMapper.getCustomerPaymentHistory(customerName);
	}

		@Override
		public PageModel findAllByPage(Map<String, Object> paramsCondition) {
			PageModel pageModel = new PageModel();
			pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
			pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
			paramsCondition.put("startIndex", pageModel.getStartIndex());
			paramsCondition.put("endIndex", pageModel.getEndIndex());
			List<Map<String, Object>> data = customerPayHistoryMapper.findAllRetMapByPage(paramsCondition);
			Long totalRecords = customerPayHistoryMapper.findAllByPageCount(paramsCondition);
			pageModel.setList(data);
			pageModel.setTotalRecords(totalRecords);
			return pageModel;
		}

		@Override
		public void insertSelective(CustomerPayHistory payHistory) {
			customerPayHistoryMapper.insertSelective(payHistory);			
		}


}
