
package com.hzcf.shoes.service;

import java.util.Map;

import com.hzcf.shoes.model.Order;
import com.hzcf.shoes.util.PageModel;


/** 
 *
 * Description: 订单service
 */

public interface ItemService {
	
	
	/**
	 * 
	 * Description: 订单列表分页查询
	 */
	public PageModel findAllByPage(Map<String, Object> condition);

	/**
	 *添加订单
	 * @param order
	 */
	public void insertSelective(Order order);

	
}
