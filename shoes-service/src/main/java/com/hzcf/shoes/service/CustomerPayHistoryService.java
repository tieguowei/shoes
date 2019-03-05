
package com.hzcf.shoes.service;

import java.util.List;
import java.util.Map;

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
	
}
