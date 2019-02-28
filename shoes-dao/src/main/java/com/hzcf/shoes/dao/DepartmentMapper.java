package com.hzcf.shoes.dao;

import java.util.List;
import java.util.Map;

import com.hzcf.shoes.model.Department;

public interface DepartmentMapper extends BaseMapper<Department>{
	
	/**
	 * 
	 * Description: 查询部门列表，用于部门管理页面
	 *
	 * @param 
	 * @return List<Map<String,Object>>
	 * @throws 
	 * @Author ydw
	 * Create Date: 2014-11-28 下午06:09:33
	 */
	public List<Map<String, Object>> findDepartmentList();
	
	/**
	 * 
	 * Description: 查找员工列表    一级部门 财富管理部
	 *
	 * @param 
	 * @return List<Map<String,Object>>
	 * @throws 
	 * @Author ydw
	 * Create Date: 2014-12-1 下午01:51:08
	 */
	public List<Map<String, Object>> findFirstDeptInfo();
	
	/**
	 * 
	 * Description: 查找所在团队 三级级联的第二级(营业部)或第三级(团队)
	 *
	 * @param 
	 * @return List<Map<String,Object>>
	 * @throws 
	 * @Author ydw
	 * Create Date: 2014-12-1 下午02:03:38
	 */
	public List<Map<String, Object>> findSubWorkDeptInfoByDeptId(Integer deptId);
	
	/**
	 * 
	 * Description: 获得层级部门信息名称
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author ydw
	 * Create Date: 2014-12-2 上午11:59:56
	 */
	public String getLevelDeptInfo(Integer deptId);
	
	/**
	 * 
	 * Description: 查询部门信息用于给员工设置工作组 
	 *
	 * @param 
	 * @return List<Map<String,Object>>
	 * @throws 
	 * @Author ydw
	 * Create Date: 2014-12-2 下午04:41:51
	 */
	public List<Map<String, Object>> findDepartmentGroupList(Integer employeeId);
}