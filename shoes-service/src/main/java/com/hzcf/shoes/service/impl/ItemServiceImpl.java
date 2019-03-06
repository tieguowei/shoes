
package com.hzcf.shoes.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzcf.shoes.dao.CustomerPaymentRecordMapper;
import com.hzcf.shoes.dao.OrderMapper;
import com.hzcf.shoes.model.Order;
import com.hzcf.shoes.service.ItemService;
import com.hzcf.shoes.util.PageModel;

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
		Map<String,Object> reqMap = new HashMap<String,Object>();
		reqMap = getStartAndEndTime(reqMap,paramsCondition);
		return orderMapper.getTotalMoneyByParam(reqMap);
	}



	@Override
	public List<Map<String, Object>> getBillPrice(Map<String,Object> paramsCondition ) throws Exception {
		Map<String,Object> reqMap = new HashMap<String,Object>();
		reqMap= getStartAndEndTime(reqMap,paramsCondition);
		return  orderMapper.getOrderByStartAndEndTime(reqMap);
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
	public void updatePriceAndReturnStatus(Map<String, Object> reqMap, Map<String, Object> paramsCondition) {
		//修改本账单退货和差价状态
		reqMap = getStartAndEndTime(reqMap,paramsCondition);
		orderMapper.updatePriceStatus(reqMap);
		orderMapper.updateReturnStatus(reqMap);
	}
	
	/**
	 * 查询客户 历史账单和本次账单的 起止时间
	 * @param paramsCondition
	 */
	public Map<String,Object> getStartAndEndTime(Map<String, Object> reqMap,Map<String, Object> paramsCondition) {
		Map<String,Object> smap = customerPaymentRecordMapper.getBillStartTime(String.valueOf(paramsCondition.get("customerName")));
		Map<String,Object> emap = customerPaymentRecordMapper.getBillEndTime(String.valueOf(paramsCondition.get("customerName")));
		/**
		 * 比较历史账单和输入时间 的起止大小，确定查询 差价和退货订单范围
			 * <0时，开始时间小于结束时间 
			 * =0时，开始时间=结束时间 
			 * >0 开始时间大于结束时间 
		 */
		String  minCreateTime = String.valueOf(paramsCondition.get("minCreateTime"));
		String  maxCreateTime = String.valueOf( paramsCondition.get("maxCreateTime"));
		
		if(null != smap){
			String  billStartTime =String.valueOf(smap.get("bill_start_time"));
			if(billStartTime.compareTo(minCreateTime)<=0){
				reqMap.put("minCreateTime",billStartTime);
			}else{
				reqMap.put("minCreateTime",minCreateTime);
			}
		}else{
			reqMap.put("minCreateTime",minCreateTime);
		}
		
		if(null != emap){
			String  billEndTime =String.valueOf(emap.get("bill_end_time"));
			if(billEndTime.compareTo(maxCreateTime) >= 0){
				reqMap.put("maxCreateTime",billEndTime);
			}else{
				reqMap.put("maxCreateTime",maxCreateTime);
			}
		}else{
			reqMap.put("maxCreateTime",maxCreateTime);
		}
		reqMap.put("customerName", String.valueOf(paramsCondition.get("customerName")));
	   return reqMap;
	}

}
