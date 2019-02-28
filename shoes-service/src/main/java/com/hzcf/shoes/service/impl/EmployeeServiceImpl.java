/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: EmployeeServiceImpl.java 
 *
 * Created: [2014-11-17 下午04:23:29] by ydw 
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

package com.hzcf.shoes.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzcf.shoes.dao.EmployeeMapper;
import com.hzcf.shoes.dao.EmployeePermissionRelationMapper;
import com.hzcf.shoes.model.Employee;
import com.hzcf.shoes.model.EmployeePermissionRelation;
import com.hzcf.shoes.service.EmployeeService;
import com.hzcf.shoes.util.PageModel;
import com.hzcf.shoes.util.StringUtil;

/** 
 *
 * Description: 
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
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private EmployeePermissionRelationMapper employeePermissionRelationMapper;
	
	@Override
	public Employee selectUsers(Employee employee) {
		return employeeMapper.checkUsers(employee);
	}

	@Override
	public PageModel findAllByPage(Map<String, Object> paramsCondition) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = employeeMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = employeeMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}

	@Override
	public int updateByPrimaryKeySelective(Employee employee) {
		return employeeMapper.updateByPrimaryKeySelective(employee);
	}

	@Override
	public int insertSelective(Employee employee) {
		return employeeMapper.insertSelective(employee);
	}

	@Override
	public Employee selectByPrimaryKey(Integer employeeId) {
		return employeeMapper.selectByPrimaryKey(employeeId);
	}
	/**
	 * Description: 新增员工权限
	 * @param oauth
	 * @param employeeNo
	 * @param creatorId
	 * @author guodong
	 */
	@Override
	public void insertEmpPermission(String oauth, String employeeNo, Integer creatorId) {
		Employee employee= employeeMapper.findByUsername(employeeNo);
		EmployeePermissionRelation empPermission = new EmployeePermissionRelation();
		empPermission.setEmployeeId(employee.getEmployeeId());
		empPermission.setPermissionId(Integer.valueOf(oauth));
		empPermission.setCreateTime(new Date());
		empPermission.setCreatorId(creatorId);
		employeePermissionRelationMapper.insertSelective(empPermission);
	}
	/**
	 * Description: 修改员工权限
	 * @param employeeId
	 * @param oauth
	 * @author guodong
	 */
	@Override
	public void updatePermissionByEmpId(Integer employeeId,String oauth) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtil.isBlank(oauth)){
			oauth="";
		}
		map.put("empId", employeeId);
		map.put("oauth", oauth);
		employeePermissionRelationMapper.updatePermissionByEmpId(map);
	}

	@Override
	public void insertEmpPermission(EmployeePermissionRelation employeePermissionRelation) {
		employeePermissionRelationMapper.insertSelective(employeePermissionRelation);
	}

	@Override
	public void deletePermissionByEmpId(Integer employeeId) {
		employeePermissionRelationMapper.deleteByEmpId(employeeId);
	}

	@Override
	public Map<String, Object> getPermissionByEmployee(int employeeId) {
		return employeePermissionRelationMapper.getPermissionByEmployee(employeeId);
	}
}
