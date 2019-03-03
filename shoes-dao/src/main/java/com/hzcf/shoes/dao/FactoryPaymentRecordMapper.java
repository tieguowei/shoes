package com.hzcf.shoes.dao;

import com.hzcf.shoes.model.FactoryPaymentRecord;
import com.hzcf.shoes.model.FactoryPaymentRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FactoryPaymentRecordMapper {
    int countByExample(FactoryPaymentRecordExample example);

    int deleteByExample(FactoryPaymentRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FactoryPaymentRecord record);

    int insertSelective(FactoryPaymentRecord record);

    List<FactoryPaymentRecord> selectByExample(FactoryPaymentRecordExample example);

    FactoryPaymentRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FactoryPaymentRecord record, @Param("example") FactoryPaymentRecordExample example);

    int updateByExample(@Param("record") FactoryPaymentRecord record, @Param("example") FactoryPaymentRecordExample example);

    int updateByPrimaryKeySelective(FactoryPaymentRecord record);

    int updateByPrimaryKey(FactoryPaymentRecord record);
}