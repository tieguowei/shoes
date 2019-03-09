package com.hzcf.shoes.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hzcf.shoes.model.SsmProperties;
import com.hzcf.shoes.model.SsmPropertiesExample;


public interface PropertiesMapper{


    int countByExample(SsmPropertiesExample example);

    int deleteByExample(SsmPropertiesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsmProperties record);

    int insertSelective(SsmProperties record);

    List<SsmProperties> selectByExample(SsmPropertiesExample example);

    SsmProperties selectByPrimaryKey(Integer id);
    

    int updateByExampleSelective(@Param("record") SsmProperties record, @Param("example") SsmPropertiesExample example);

    int updateByExample(@Param("record") SsmProperties record, @Param("example") SsmPropertiesExample example);

    int updateByPrimaryKeySelective(SsmProperties record);

    int updateByPrimaryKey(SsmProperties record);
    

	List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);

	Long findAllByPageCount(Map<String, Object> paramsCondition);
	
    //根据属性配置表中的属性名称查询相应的属性值
	BigDecimal selectVersion(String propertyName);

    List<Map<String,Object>> getDeptDeptNameList(@Param("list") List<Integer> deptIdList);
}
