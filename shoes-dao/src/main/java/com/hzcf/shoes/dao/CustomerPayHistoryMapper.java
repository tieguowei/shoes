package com.hzcf.shoes.dao;

import com.hzcf.shoes.model.CustomerPayHistory;
import com.hzcf.shoes.model.CustomerPayHistoryExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CustomerPayHistoryMapper {
    long countByExample(CustomerPayHistoryExample example);

    int deleteByExample(CustomerPayHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerPayHistory record);

    int insertSelective(CustomerPayHistory record);

    List<CustomerPayHistory> selectByExample(CustomerPayHistoryExample example);

    CustomerPayHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerPayHistory record, @Param("example") CustomerPayHistoryExample example);

    int updateByExample(@Param("record") CustomerPayHistory record, @Param("example") CustomerPayHistoryExample example);

    int updateByPrimaryKeySelective(CustomerPayHistory record);

    int updateByPrimaryKey(CustomerPayHistory record);

    /**
     * 查看客户还款明细
     * @param customerName
     * @return
     */
	List<Map<String, Object>> getCustomerPaymentHistory(String customerName);

	List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);

	Long findAllByPageCount(Map<String, Object> paramsCondition);}