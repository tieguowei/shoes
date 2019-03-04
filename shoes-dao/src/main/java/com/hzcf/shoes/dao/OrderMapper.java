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
	 * 查询客户历史账单总欠款
	 * @param customerName
	 * @return
	 */
	Map<String, Object> getTotaMoneyOwed(String customerName);


	/**
	 * 查询客户历史账单时间内有无差价和退货
	 * @param reqMap
	 * @return
	 */
	List<Map<String, Object>> getOrderByStartAndEndTime(Map<String, Object> reqMap);

	/**
	 * 查询客户最新一笔账单时间
	 * @param customerName
	 * @return
	 */
	Map<String, Object> getLastOneTime(String customerName);

	/**
	 * 查询客户历史账单时间内(差价和退货)汇总
	 * @param paramsCondition
	 * @return
	 */

	String getBillPriceSum(Map<String, Object> paramsCondition);
}