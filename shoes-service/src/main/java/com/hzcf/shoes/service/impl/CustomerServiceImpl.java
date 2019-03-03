package com.hzcf.shoes.service.impl;

import com.hzcf.shoes.dao.CustomerPaymentRecordMapper;
import com.hzcf.shoes.service.CustomerService;
import com.hzcf.shoes.util.BigDecimalUtil;
import com.hzcf.shoes.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerPaymentRecordMapper customerPaymentRecordMapper ;

    @Override
    public PageModel getCustomerAccountList(Map<String, Object> paramsCondition) {
        PageModel pageModel = new PageModel();
        pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
        pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
        paramsCondition.put("startIndex", pageModel.getStartIndex());
        paramsCondition.put("endIndex", pageModel.getEndIndex());
        paramsCondition.put("customerName", paramsCondition.get("customerName"));
        List<Map<String,Object>> ret = new ArrayList<>();
        //查询 客户姓名 , 总货款 ,
        List<Map<String, Object>> data = this.customerPaymentRecordMapper.getCustomerAccountList(paramsCondition);
        //查询客户的欠款
        if ( data != null && data.size() > 0 ){
            for (Map<String, Object> datum : data) {
                Map<String,Object> retMap = new HashMap<>();
                //根据用户名只能查询出一条真实还款的记录 , 为 查询所有的用户的真实还款记录保留一个接口
                retMap.put("id",datum.get("id"));
                retMap.put("customerName",datum.get("customerName"));
                retMap.put("totalGoodsMoney",datum.get("totalGoodsMoney"));
                List<Map<String,Object>> realBackRecord = this.customerPaymentRecordMapper.selectWaitBackMoney(datum);
                if (realBackRecord != null && realBackRecord.size() > 0){
                    BigDecimal waitBackMoney = BigDecimalUtil.sub(datum.get("totalGoodsMoney").toString(), realBackRecord.get(0).get("realBackMoney").toString());
                    retMap.put("waitBackMoney", waitBackMoney ) ;
                }else{
                    //没有查询到账单的还款记录 , 所以有多少货款就有多少欠款
                    retMap.put("waitBackMoney", datum.get("totalGoodsMoney") ) ;
                }
                ret.add(retMap);
            }
        }
        Long totalRecords = this.customerPaymentRecordMapper.getCustomerAccountListTotal(paramsCondition);
        pageModel.setList(ret);
        pageModel.setTotalRecords(totalRecords);
        return pageModel;
    }

    /**
     *  用户的回款记录列表
     * @param paramsCondition
     * @return
     */
    @Override
    public PageModel selectBackRecordList(Map<String, Object> paramsCondition) {
        PageModel pageModel = new PageModel();
        pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
        pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
        paramsCondition.put("startIndex", pageModel.getStartIndex());
        paramsCondition.put("endIndex", pageModel.getEndIndex());
        paramsCondition.put("customerName", paramsCondition.get("customerName"));
        //查询回款记录列表
        List<Map<String,Object>> list = this.customerPaymentRecordMapper.getCustomerBackRecordList(paramsCondition);
        Long totalRecords = this.customerPaymentRecordMapper.getCustomerBackRecordListTotal(paramsCondition);
        pageModel.setList(list);
        pageModel.setTotalRecords(totalRecords);
        return pageModel;
    }
}
