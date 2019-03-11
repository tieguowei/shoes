
package com.hzcf.shoes.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzcf.shoes.dao.CustomerAccountMapper;
import com.hzcf.shoes.model.CustomerAccount;
import com.hzcf.shoes.service.CustomerAccountService;
import com.hzcf.shoes.util.PageModel;

@Service
public class CustomerAccountServiceImpl implements CustomerAccountService {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private CustomerAccountMapper customerAccountMapper;

	@Override
	public PageModel findAllByPage(Map<String, Object> paramsCondition) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = customerAccountMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = customerAccountMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}

	@Override
	public CustomerAccount selectById(Integer id) {
		return customerAccountMapper.selectByPrimaryKey(id);
	}

	@Override
	public void doEditRemark(CustomerAccount account) {
		customerAccountMapper.updateByPrimaryKeySelective(account);		
	}
}
