
package com.hzcf.shoes.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzcf.shoes.dao.CustomerPayHistoryMapper;
import com.hzcf.shoes.dao.CustomerPaymentRecordMapper;
import com.hzcf.shoes.dao.OrderMapper;
import com.hzcf.shoes.model.Order;
import com.hzcf.shoes.service.ItemService;
import com.hzcf.shoes.util.PageModel;
import com.hzcf.shoes.util.StringUtil;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private CustomerPaymentRecordMapper  customerPaymentRecordMapper;

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


	@Override
	public Map<String,Object> selectById(Integer id) {
		return orderMapper.selectById(id);
	}


	@Override
	public void updateById(Order order) {
		orderMapper.updateById(order);
	}


	@Override
	public List<Map<String, Object>> checkBillByCustomerAndPayTime(Map<String, Object> paramsCondition) {
		return orderMapper.checkBillByCustomerAndPayTime(paramsCondition);
	}


	@Override
	public Map<String, Object> getTotalMoneyByParam(Map<String, Object> paramsCondition) {
		return orderMapper.getTotalMoneyByParam(paramsCondition);
	}

	

	@Override
	public List<Map<String, Object>> getBillPrice(Map<String,Object> paramsCondition ) {
		List<Map<String,Object>> list =  new ArrayList<Map<String,Object>>();
		//查询此客户历史账单的起始时间
		Map<String,Object> reqMap = new HashMap<String,Object>();
		Map<String,Object> smap = customerPaymentRecordMapper.getBillStartTime(String.valueOf(paramsCondition.get("customerName")));
		Map<String,Object> emap = customerPaymentRecordMapper.getBillEndTime(String.valueOf(paramsCondition.get("customerName")));
		if(null != smap){
			//查询订单表中历史账单内有没有差价或者退货
			reqMap.put("minCreateTime", smap.get("bill_start_time"));
			reqMap.put("maxCreateTime", emap.get("bill_end_time"));
			reqMap.put("customerName", String.valueOf(paramsCondition.get("customerName")));
			list = orderMapper.getOrderByStartAndEndTime(reqMap);
			//查询订单表中此时间段内有没有差价或者退货
			reqMap.put("minCreateTime", paramsCondition.get("minCreateTime"));
			reqMap.put("maxCreateTime", paramsCondition.get("maxCreateTime"));
			reqMap.put("customerName", String.valueOf(paramsCondition.get("customerName")));
			List<Map<String, Object>> list2 = orderMapper.getOrderByStartAndEndTime(reqMap);
			list.addAll(list2);
		}
		return list;
	}




	@Override
	public String getBillPriceSum(Map<String, Object> paramsCondition) {
		return orderMapper.getBillPriceSum(paramsCondition);
	}


	@Override
	public void updateItemStatus(Map<String, Object> paramsCondition) {
		orderMapper.updateItemStatus(paramsCondition);
	}


	@Override
	public List<Map<String, Object>> checkCustomerItemIsOver(Map<String, Object> paramsCondition) {
		return orderMapper.checkCustomerItemIsOver(paramsCondition);
	}


	@Override
	public void updatePriceAndReturnStatus(Map<String, Object> paramsCondition) {
		orderMapper.updatePriceStatus(paramsCondition);
		orderMapper.updateReturnStatus(paramsCondition);
	}






}
