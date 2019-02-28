package com.hzcf.shoes.dao;

import com.hzcf.shoes.model.EmployeePermissionRelation;
import com.hzcf.shoes.model.EmployeePermissionRelationExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface EmployeePermissionRelationMapper {
    int countByExample(EmployeePermissionRelationExample example);

    int deleteByExample(EmployeePermissionRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmployeePermissionRelation record);

    int insertSelective(EmployeePermissionRelation record);

    List<EmployeePermissionRelation> selectByExample(EmployeePermissionRelationExample example);

    EmployeePermissionRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmployeePermissionRelation record, @Param("example") EmployeePermissionRelationExample example);

    int updateByExample(@Param("record") EmployeePermissionRelation record, @Param("example") EmployeePermissionRelationExample example);

    int updateByPrimaryKeySelective(EmployeePermissionRelation record);

    int updateByPrimaryKey(EmployeePermissionRelation record);


	void updatePermissionByEmpId(Map<String, Object> map);

	Map<String, Object> findPermissionByEmpId(Integer employeeId);
	
	void deleteByEmpId(Integer employeeId);
	
	/**
	 * 根据用户id查询用户权限 
	 */
	Map<String, Object> getPermissionByEmployee(int employeeId);
}