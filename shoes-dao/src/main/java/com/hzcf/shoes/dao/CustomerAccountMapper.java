package com.hzcf.shoes.dao;

import com.hzcf.shoes.model.CustomerAccount;
import com.hzcf.shoes.model.CustomerAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerAccountMapper {
    long countByExample(CustomerAccountExample example);

    int deleteByExample(CustomerAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerAccount record);

    int insertSelective(CustomerAccount record);

    List<CustomerAccount> selectByExample(CustomerAccountExample example);

    CustomerAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerAccount record, @Param("example") CustomerAccountExample example);

    int updateByExample(@Param("record") CustomerAccount record, @Param("example") CustomerAccountExample example);

    int updateByPrimaryKeySelective(CustomerAccount record);

    int updateByPrimaryKey(CustomerAccount record);
}