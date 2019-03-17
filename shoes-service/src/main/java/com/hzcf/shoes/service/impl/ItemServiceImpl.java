
package com.hzcf.shoes.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzcf.shoes.dao.CustomerPaymentRecordMapper;
import com.hzcf.shoes.dao.OrderMapper;
import com.hzcf.shoes.dao.PropertiesMapper;
import com.hzcf.shoes.model.Order;
import com.hzcf.shoes.service.ItemService;
import com.hzcf.shoes.util.PageModel;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private CustomerPaymentRecordMapper  customerPaymentRecordMapper;
	@Autowired
	private PropertiesMapper propertiesMapper;

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
		Order oldOrder = orderMapper.selectByPrimaryKey(order.getId());
		if((oldOrder.getPriceSpread().compareTo(order.getPriceSpread()) != 0 ) || (oldOrder.getDifferenceNumber().compareTo(order.getDifferenceNumber())!= 0)){
			order.setSpredStatus("1");
		}else{
			order.setSpredStatus(oldOrder.getSpredStatus());
			
		}
		if(oldOrder.getReturnsNumber() != order.getReturnsNumber()){
			order.setReturnStatus("1");
		}else{
			order.setReturnStatus(oldOrder.getReturnStatus());
		}
		orderMapper.updateById(order);
	}


	@Override
	public List<Map<String, Object>> checkBillByCustomerAndPayTime(Map<String, Object> paramsCondition) {
		return orderMapper.checkBillByCustomerAndPayTime(paramsCondition);
	}


	@Override
	public Map<String, Object> getTotalMoneyByParam(Map<String, Object> paramsCondition) {
		BigDecimal CustomerJianci = propertiesMapper.selectVersion("CustomerJianci");
		paramsCondition.put("CustomerJianci", CustomerJianci);
		return orderMapper.getTotalMoneyByParam(paramsCondition);
	}



	@Override
	public List<Map<String, Object>> getBillPrice(Map<String,Object> paramsCondition ) throws Exception {
		return  orderMapper.getOrderByStartAndEndTime(paramsCondition);
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
	 

	@Override
	public List<Map<String, Object>> checkFactoryItemIsOver(Map<String, Object> paramsCondition) {
		return orderMapper.checkFactoryItemIsOver(paramsCondition);
	}


	@Override
	public List<Map<String, Object>> getFactoryItemList(Map<String, Object> paramsCondition) {
		return orderMapper.getFactoryItemList(paramsCondition);
	}


	@Override
	public Map<String, Object> getFactoryTotalMoneyByParam(Map<String, Object> paramsCondition) {
		return orderMapper.getFactoryTotalMoneyByParam(paramsCondition);
	}

}
