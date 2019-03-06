package com.hzcf.shoes.service;

import com.hzcf.shoes.util.PageModel;

import java.util.Map;

public interface CustomerService {

    /**
     *
     * Description: 客户分组列表
     */
	public PageModel findAllByPage(Map<String, Object> paramsCondition);

    public PageModel selectBackRecordList(Map<String, Object> condition);


}
