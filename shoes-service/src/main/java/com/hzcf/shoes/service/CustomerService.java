package com.hzcf.shoes.service;

import com.hzcf.shoes.util.PageModel;

import java.util.Map;

public interface CustomerService {

    /**
     *
     * Description: 用户账单列表
     */
    public PageModel getCustomerAccountList(Map<String, Object> condition);

}
