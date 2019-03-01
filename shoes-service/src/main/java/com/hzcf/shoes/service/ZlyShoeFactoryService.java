
package com.hzcf.shoes.service;

import java.util.Map;

import com.hzcf.shoes.model.Employee;
import com.hzcf.shoes.model.EmployeePermissionRelation;
import com.hzcf.shoes.model.ZlyShoeBrand;
import com.hzcf.shoes.model.ZlyShoeFactory;
import com.hzcf.shoes.util.PageModel;


/** 
 *
 * Description: 张龙宇鞋厂service
 */

public interface ZlyShoeFactoryService {
	
	
	/**
	 * 
	 * Description: 户列表分页查询
	 */
	public PageModel findAllByPage(Map<String, Object> condition);

	/**
	 * 校验名称是否存在
	 * @param params
	 * @return
	 */
	public int checkName(Map<String, Object> params);

	/**
	 * 新增鞋厂
	 * @param zlyShoeFactory
	 */
	public void addGoldProduct(ZlyShoeFactory zlyShoeFactory);

	/**
	 * 查询最新添加的
	 * @return
	 */
	public Map<String, Object> selectLastOne();

	/**
	 * 添加货号
	 * @param shoeBrand
	 */
	public void insertBrand(ZlyShoeBrand shoeBrand);
	
}
