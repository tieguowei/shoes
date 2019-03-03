package com.hzcf.shoes.dao;

import com.hzcf.shoes.model.CustomerPaymentRecord;
import com.hzcf.shoes.model.CustomerPaymentRecordExample;
import java.util.List;
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
}