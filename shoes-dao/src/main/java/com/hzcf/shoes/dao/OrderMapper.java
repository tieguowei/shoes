package com.hzcf.shoes.dao;

import com.hzcf.shoes.model.Order;
import com.hzcf.shoes.model.OrderExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    int countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

	List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);

	Long findAllByPageCount(Map<String, Object> paramsCondition);

	List<Map<String, Object>> checkBillByCustomerAndPayTime(Map<String, Object> paramsCondition);

	Map<String, Object> getTotalMoneyByParam(Map<String, Object> paramsCondition);



	/**
	 * 查询客户历史账单时间内有无差价和退货
	 * @param reqMap
	 * @return
	 */
	List<Map<String, Object>> getOrderByStartAndEndTime(Map<String, Object> reqMap);


	/**
	 * 查询客户历史账单时间内(差价和退货)汇总
	 * @param paramsCondition
	 * @return
	 */

	String getBillPriceSum(Map<String, Object> paramsCondition);

	/**
	 * 修改订单（客户或者鞋厂 是否减次状态）
	 * @param paramsCondition
	 */
	void updateItemStatus(Map<String, Object> paramsCondition);

	/**
	 * 查询客户有无未处理订单
	 * @param paramsCondition
	 * @return
	 */
	List<Map<String, Object>> checkCustomerItemIsOver(Map<String, Object> paramsCondition);

	/**
	 * 根据主键查询
	 */
	Map<String, Object> selectById(Integer id);

	/**
	 * 自定义修改方法
	 * @param order
	 */
	void updateById(Order order);

	/**
	 * 修改此账单中差价的订单状态
	 * @param paramsCondition
	 */
	void updatePriceStatus(Map<String, Object> paramsCondition);
	/**
	 * 修改此账单中退货的订单状态
	 * @param paramsCondition
	 */
	void updateReturnStatus(Map<String, Object> paramsCondition);

	/**
	 * 校验鞋厂是否能导出
	 * @param paramsCondition
	 * @return
	 */
	List<Map<String, Object>> checkFactoryItemIsOver(Map<String, Object> paramsCondition);

	/**
	 * 查询鞋厂发货记录
	 * @param paramsCondition
	 * @return
	 */
	List<Map<String, Object>> getFactoryItemList(Map<String, Object> paramsCondition);
	/**
	 * 查询鞋厂汇总
	 * @param paramsCondition
	 * @return
	 */
	Map<String, Object> getFactoryTotalMoneyByParam(Map<String, Object> paramsCondition);
}