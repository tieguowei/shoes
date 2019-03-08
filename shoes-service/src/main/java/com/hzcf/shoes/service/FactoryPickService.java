package com.hzcf.shoes.service;

import java.util.Map;

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



}
