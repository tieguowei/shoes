package com.hzcf.shoes.dao;

import com.hzcf.shoes.model.JxStudent;
import com.hzcf.shoes.model.JxStudentExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface JxStudentMapper {
    int countByExample(JxStudentExample example);

    int deleteByExample(JxStudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JxStudent record);

    int insertSelective(JxStudent record);

    List<JxStudent> selectByExample(JxStudentExample example);

    JxStudent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JxStudent record, @Param("example") JxStudentExample example);

    int updateByExample(@Param("record") JxStudent record, @Param("example") JxStudentExample example);

    int updateByPrimaryKeySelective(JxStudent record);

    int updateByPrimaryKey(JxStudent record);

	List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);

	Long findAllByPageCount(Map<String, Object> paramsCondition);
}