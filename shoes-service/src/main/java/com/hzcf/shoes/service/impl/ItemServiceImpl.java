
package com.hzcf.shoes.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzcf.shoes.dao.OrderMapper;
import com.hzcf.shoes.dao.ZlyShoeBrandMapper;
import com.hzcf.shoes.dao.ZlyShoeFactoryMapper;
import com.hzcf.shoes.model.Order;
import com.hzcf.shoes.model.ZlyShoeBrand;
import com.hzcf.shoes.model.ZlyShoeFactory;
import com.hzcf.shoes.service.ItemService;
import com.hzcf.shoes.util.PageModel;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private OrderMapper orderMapper;


	@Override
	public PageModel findAllByPage(Map<String, Object> paramsCondition) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = orderMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = orderMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}


	@Override
	public void insertSelective(Order order) {
		orderMapper.insertSelective(order);
	}




}
