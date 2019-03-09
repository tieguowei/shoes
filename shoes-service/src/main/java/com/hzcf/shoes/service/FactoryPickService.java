package com.hzcf.shoes.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.hzcf.shoes.model.FactoryGetGoods;
import com.hzcf.shoes.util.PageModel;

public interface FactoryPickService {

    /**
     *
     * Description: 鞋厂取货记录列表
     */
	public PageModel findAllByPage(Map<String, Object> paramsCondition);

	

	/**
	 * 添加取货记录
	 * @param paramsCondition
	 * @return
	 */
	public void insertSelective(FactoryGetGoods goods);

	public Map<String, Object> selectById(Integer id);

	public void updateByPrimaryKeySelective(FactoryGetGoods goods);

	/**
	 * 根据鞋厂名称查询未处理的记录
	 * @param paramsCondition
	 * @return
	 */
	public List<Map<String, Object>> getPickListByFactory(Map<String, Object> paramsCondition);
	
	/**
	 * 查询动态利率
	 * @param winterRate
	 * @return
	 */
	public BigDecimal getProperties(String winterRate);

	/**
	 * 查询取货记录汇总
	 * @param paramsCondition
	 * @return
	 */
	public Map getPickSum(Map<String, Object> paramsCondition);

	/**
	 * 修改取货记录状态
	 * @param paramsCondition
	 */
	public void updatePickStatus(Map<String, Object> paramsCondition);



}
