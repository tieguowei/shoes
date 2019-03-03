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

	/*
	 *查询客户还款记录  
	 */
	List<Map<String, Object>> getCustomerPaymentHistory(String customerName);
}