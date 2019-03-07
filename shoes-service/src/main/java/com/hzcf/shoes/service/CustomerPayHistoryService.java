
package com.hzcf.shoes.service;

import java.util.List;
import java.util.Map;

import com.hzcf.shoes.model.CustomerPayHistory;
import com.hzcf.shoes.util.PageModel;

/** 
 *
 * Description:客户付款记录service
 */

public interface CustomerPayHistoryService {

	
	/**
	 * 查询客户还款流水
	 * @param customerName
	 * @return
	 */
	public List<Map<String, Object>> getCustomerPaymentHistory(String customerName);

	/**
	 * 查询客户还款流水列表 分页
	 * @param paramsCondition
	 * @return
	 */
	public PageModel findAllByPage(Map<String, Object> paramsCondition);

	public void insertSelective(CustomerPayHistory payHistory);
	
}
