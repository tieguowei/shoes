package com.hzcf.shoes.service;

import com.hzcf.shoes.util.PageModel;

import java.util.Map;

public interface CustomerService {

    /**
     *
     * Description: 客户分组列表
     */
	public PageModel findAllByPage(Map<String, Object> paramsCondition);

	/**
	 * 查询客户账单列表
	 * @param paramsCondition
	 * @return
	 */
	public PageModel getCustomerBillList(Map<String, Object> paramsCondition);


}
