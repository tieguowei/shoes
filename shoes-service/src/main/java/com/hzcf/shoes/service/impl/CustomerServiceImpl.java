package com.hzcf.shoes.service.impl;

import com.hzcf.shoes.dao.CustomerPaymentRecordMapper;
import com.hzcf.shoes.service.CustomerService;
import com.hzcf.shoes.util.BigDecimalUtil;
import com.hzcf.shoes.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerPaymentRecordMapper customerPaymentRecordMapper ;

    @Override
    public PageModel findAllByPage(Map<String, Object> paramsCondition) {
    	PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = customerPaymentRecordMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = customerPaymentRecordMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
    }


	@Override
	public PageModel getCustomerBillList(Map<String, Object> paramsCondition) {
		 PageModel pageModel = new PageModel();
	        pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
	        pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
	        paramsCondition.put("startIndex", pageModel.getStartIndex());
	        paramsCondition.put("endIndex", pageModel.getEndIndex());
	        paramsCondition.put("customerName", paramsCondition.get("customerName"));
	        //查询回款记录列表
	        List<Map<String,Object>> list = this.customerPaymentRecordMapper.getCustomerBackRecordList(paramsCondition);
	        Long totalRecords = this.customerPaymentRecordMapper.getCustomerBackRecordListTotal(paramsCondition);
	        pageModel.setList(list);
	        pageModel.setTotalRecords(totalRecords);
	        return pageModel;
	}
}
