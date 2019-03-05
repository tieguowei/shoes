package com.hzcf.shoes.service;

import java.util.Map;

import com.hzcf.shoes.model.SsmProperties;
import com.hzcf.shoes.util.PageModel;

public interface PropertiesService {

	/**
	 * 用主键查询
	 * 
	 * @param id
	 * @return
	 */
	SsmProperties selectByPrimaryKey(Integer id);

	/**
	 * 查询所有属性值
	 * 
	 * @param paramMap
	 * @return
	 */
/*	public List<SsmProperties> selectProperties(Map paramMap);*/

	/**
	 * 后台用于分页查询
	 * 
	 * @param condition
	 * @return
	 */
	public PageModel findAllByPage(Map<String, Object> condition);

	/**
	 * 
	 * Description: 修改
	 *
	 * @param
	 * @return Integer
	 * @throws
	 * @Author ydw Create Date: 2014-12-8 下午03:21:01
	 */
	public Integer updateProperties(SsmProperties ssmProperties);
	
	/**
	 * 
	 * Description: 保存添加页面
	 *
	 * @param 
	 * @return Integer
	 * @throws 
	 * @Author ydw
	 * Create Date: 2014-12-8 下午02:11:39
	 */
	public Integer addProperties(SsmProperties ssmProperties);

}
