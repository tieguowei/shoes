
package com.hzcf.shoes.service;

import java.util.Map;

import com.hzcf.shoes.model.CustomerAccount;
import com.hzcf.shoes.util.PageModel;

/** 
 *
 * Description:客户账户service
 */

public interface CustomerAccountService {

	

	/**
	 * 查询客户账户列表 分页
	 * @param paramsCondition
	 * @return
	 */
	public PageModel findAllByPage(Map<String, Object> paramsCondition);

	public CustomerAccount selectById(Integer id);

	public void doEditRemark(CustomerAccount account);

	
}
