package com.hzcf.shoes.dao;

import com.hzcf.shoes.model.ZlyShoeFactory;
import com.hzcf.shoes.model.ZlyShoeFactoryExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ZlyShoeFactoryMapper {
    int countByExample(ZlyShoeFactoryExample example);

    int deleteByExample(ZlyShoeFactoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZlyShoeFactory record);

    int insertSelective(ZlyShoeFactory record);

    List<ZlyShoeFactory> selectByExample(ZlyShoeFactoryExample example);

    ZlyShoeFactory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZlyShoeFactory record, @Param("example") ZlyShoeFactoryExample example);

    int updateByExample(@Param("record") ZlyShoeFactory record, @Param("example") ZlyShoeFactoryExample example);

    int updateByPrimaryKeySelective(ZlyShoeFactory record);

    int updateByPrimaryKey(ZlyShoeFactory record);

	List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);

	Long findAllByPageCount(Map<String, Object> paramsCondition);

	int checkName(Map<String, Object> params);

	Map<String, Object> selectLastOne();
}