
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

	/**
	 * 查询客户在固定时间段的账单
	 * @param paramsCondition
	 * @return
	 */
	public Map<String, Object> getTotalMoneyByParam(Map<String, Object> paramsCondition);

	/**
	 * 查询客户总欠款
	 * @param customerName
	 * @return
	 */
	public Map<String, Object> getTotaMoneyOwed(String customerName);

	/**
	 * 查询客户还款记录
	 * @param customerName
	 * @return
	 */
	public List<Map<String, Object>> getCustomerPaymentHistory(String customerName);

	/**
	 * 查询历史账单中订单的差价和退货
	 * @param customerName
	 * @return
	 */
	public List<Map<String, Object>> getBillPrice(String customerName);

	/**
	 * 查询客户最新一笔账单时间
	 * @param customerName
	 * @return
	 */
	public Map<String, Object> getLastOneTime(String customerName);

	/**
	 * 查询客户历史账单时间内(差价和退货)汇总
	 * @param valueOf
	 * @return
	 */
	public String getBillPriceSum(Map<String, Object> paramsCondition);

	
}
