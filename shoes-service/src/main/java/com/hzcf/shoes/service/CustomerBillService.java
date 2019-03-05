
package com.hzcf.shoes.service;

import java.util.Map;

import com.hzcf.shoes.model.CustomerPaymentRecord;

/** 
 *
 * Description: 客户账单service
 */

public interface CustomerBillService {

	/**
	 * 添加客户账单
	 * @param customerbill
	 */
	void insertCustomerBill(CustomerPaymentRecord customerbill);
	
	
	/**
	 * 查询客户账单总欠款
	 * @param customerName
	 * @return
	 */
	public Map<String, Object> getTotaMoneyOwed(String customerName);
	
	/**
	 * 查询客户最新一笔账单时间
	 * @param customerName
	 * @return
	 */
	public Map<String, Object> getLastOneTime(String customerName);
}
