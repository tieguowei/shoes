package com.hzcf.shoes.dao;

import com.hzcf.shoes.model.FactoryRate;
import com.hzcf.shoes.model.FactoryRateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FactoryRateMapper {
    int countByExample(FactoryRateExample example);

    int deleteByExample(FactoryRateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FactoryRate record);

    int insertSelective(FactoryRate record);

    List<FactoryRate> selectByExample(FactoryRateExample example);

    FactoryRate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FactoryRate record, @Param("example") FactoryRateExample example);

    int updateByExample(@Param("record") FactoryRate record, @Param("example") FactoryRateExample example);

    int updateByPrimaryKeySelective(FactoryRate record);

    int updateByPrimaryKey(FactoryRate record);
}