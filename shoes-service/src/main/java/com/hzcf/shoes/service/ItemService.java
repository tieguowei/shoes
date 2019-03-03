
package com.hzcf.shoes.service;

import java.util.List;
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

	/**
	 * 根据主键查询订单信息
	 * @param id
	 * @return
	 */
	public Order selectByPrimaryKey(Integer id);

	/**
	 * 修改订单信息
	 * @param order
	 */
	public void updateByPrimaryKeySelective(Order order);

	/**
	 *查询是否有账单
	 * @param paramsCondition
	 * @return
	 */
	public List<Map<String, Object>> checkBillByCustomerAndPayTime(Map<String, Object> paramsCondition);

	
}
