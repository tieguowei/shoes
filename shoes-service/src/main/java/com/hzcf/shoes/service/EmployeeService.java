/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: EmployeeService.java 
 *
 * Created: [2014-11-17 下午04:23:15] by ydw 
 *
 * $Id$
 * 
 * $Revision$
 *
 * $Author$
 *
 * $Date$
 *
 * ============================================================ 
 * 
 * ProjectName: sping-mvc 
 * 
 * Description: 
 * 
 * ==========================================================*/

package com.hzcf.shoes.service;

import java.util.Map;

import com.hzcf.shoes.model.Employee;
import com.hzcf.shoes.model.EmployeePermissionRelation;
import com.hzcf.shoes.util.PageModel;


/** 
 *
 * Description: 员工管理service
 *
 * @author ydw
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-11-17    ydw       1.0        1.0 Version 
 * </pre>
 */

public interface EmployeeService {
	
	/**
	 * 
	 * Description: 验证用户登录
	 *
	 * @param 
	 * @return Employee
	 * @throws 
	 * @Author ydw
	 * Create Date: 2014-12-1 下午06:07:39
	 */
	public Employee selectUsers(Employee employee);

	/**
	 * 
	 * Description: 后台用户管理用户列表分页查询
	 *
	 * @param 
	 * @return PageModel
	 * @throws 
	 * @Author ydw
	 * Create Date: 2014-12-1 下午01:29:17
	 */
	public PageModel findAllByPage(Map<String, Object> condition);
	
	/**
	 * 
	 * Description: 修改
	 *
	 * @param 
	 * @return int
	 * @throws 
	 * @Author ydw
	 * Create Date: 2014-12-1 下午07:09:31
	 */
	public int updateByPrimaryKeySelective(Employee employee);
	
	/**
	 * 
	 * Description: 添加
	 *
	 * @param 
	 * @return int
	 * @throws 
	 * @Author ydw
	 * Create Date: 2014-12-2 上午11:48:34
	 */
	public int insertSelective(Employee employee);
	
	/**
	 * 
	 * Description: 通过主键查询
	 *
	 * @param 
	 * @return Employee
	 * @throws 
	 * @Author ydw
	 * Create Date: 2014-12-2 下午01:18:09
	 */
    public Employee selectByPrimaryKey(Integer employeeId);	
   /**
    * Description: 插入员工权限
    * @param oauth
    * @param employeeNo
    * @param creatorId
    * @author guodong
    */
	public void insertEmpPermission(String oauth, String employeeNo, Integer creatorId);
	/**
	 * Description: 修改员工权限
	 * @param employeeId
	 * @author guodong
	 * @param oauth 
	 */
	public void updatePermissionByEmpId(Integer employeeId, String oauth);
	/**
	 * Description: 插入员工权限
	 * @param employeePermissionRelation
	 * @author guodong
	 */
	public void insertEmpPermission(EmployeePermissionRelation employeePermissionRelation);
	/**
	 * Description: 删除
	 * @param employeeId
	 * @author guodong
	 */
	public void deletePermissionByEmpId(Integer employeeId);
	
	/**
	 * 根据用户id查询用户权限 
	 * @param employeeId
	 * @return
	 */
	public Map<String, Object> getPermissionByEmployee(int employeeId);
}
