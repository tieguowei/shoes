
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
	public Map<String, Object> selectById(Integer id);

	/**
	 * 修改订单信息
	 * @param order
	 */
	public void updateById(Order order);

	/**
	 *查询是否有账单
	 * @param paramsCondition
	 * @return
	 */
	public List<Map<String, Object>> checkBillByCustomerAndPayTime(Map<String, Object> paramsCondition);

	/**
	 * 查询客户在固定时间段的账单
	 * @param paramsCondition
	 * @return
	 */
	public Map<String, Object> getTotalMoneyByParam(Map<String, Object> paramsCondition);



	/**
	 * 查询历史账单中订单的差价和退货
	 * @param paramsCondition
	 * @return
	 */
	public List<Map<String, Object>> getBillPrice(Map<String, Object> paramsCondition) throws Exception ;


	/**
	 * 查询客户历史账单时间内(差价和退货)汇总
	 * @param valueOf
	 * @return
	 */
	public String getBillPriceSum(Map<String, Object> paramsCondition);

	/**
	 * 修改订单（客户或者鞋厂 是否减次状态）
	 * @param paramsCondition
	 */
	public void updateItemStatus(Map<String, Object> paramsCondition);

	/**
	 * 查询客户有无未处理订单
	 * @param paramsCondition
	 * @return
	 */
	public List<Map<String, Object>> checkCustomerItemIsOver(Map<String, Object> paramsCondition);

	/**
	 * 修改此账单中差价和退货的订单状态
	 * @param paramsCondition
	 * @param paramsCondition2 
	 */
	public void updatePriceAndReturnStatus(Map<String, Object> reqMap, Map<String, Object> paramsCondition);


	
}
