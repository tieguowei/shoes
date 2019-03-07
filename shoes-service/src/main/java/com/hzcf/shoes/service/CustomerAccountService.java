
package com.hzcf.shoes.service;

import java.util.List;
import java.util.Map;

import com.hzcf.shoes.model.CustomerPayHistory;
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

	
}
