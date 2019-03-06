package com.hzcf.shoes.dao;

import com.hzcf.shoes.model.CustomerPaymentRecord;
import com.hzcf.shoes.model.CustomerPaymentRecordExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CustomerPaymentRecordMapper {
    int countByExample(CustomerPaymentRecordExample example);

    int deleteByExample(CustomerPaymentRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerPaymentRecord record);

    int insertSelective(CustomerPaymentRecord record);

    List<CustomerPaymentRecord> selectByExample(CustomerPaymentRecordExample example);

    CustomerPaymentRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerPaymentRecord record, @Param("example") CustomerPaymentRecordExample example);

    int updateByExample(@Param("record") CustomerPaymentRecord record, @Param("example") CustomerPaymentRecordExample example);

    int updateByPrimaryKeySelective(CustomerPaymentRecord record);

    int updateByPrimaryKey(CustomerPaymentRecord record);

    Long getCustomerBackRecordListTotal(Map<String,Object> param);

    List<Map<String,Object>> getCustomerBackRecordList(Map<String,Object> map);

	Map<String, Object> getBillStartTime(String customerName);

	Map<String, Object> getBillEndTime(String customerName);
	/**
	 * 查询客户历史账单总欠款
	 * @param customerName
	 * @return
	 */
	Map<String, Object> getTotaMoneyOwed(String customerName);
	/**
	 * 查询客户最新一笔账单时间
	 * @param customerName
	 * @return
	 */
	Map<String, Object> getLastOneTime(String customerName);

	List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);

	Long findAllByPageCount(Map<String, Object> paramsCondition);
}