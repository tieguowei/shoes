package com.hzcf.shoes.service;

import java.util.Map;

import com.hzcf.shoes.model.FactoryPaymentRecord;
import com.hzcf.shoes.util.PageModel;

public interface FactoryBillService {

    /**
     *
     * Description: 鞋厂分组列表
     */
	public PageModel findAllByPage(Map<String, Object> paramsCondition);

	/**
	 * 查询鞋厂账单列表
	 * @param paramsCondition
	 * @return
	 */
	public PageModel getFactoryBillList(Map<String, Object> paramsCondition);

	/**
	 * 鞋厂账单入库
	 * @param record
	 */
	public void insertFactoryBill(FactoryPaymentRecord record);



}
