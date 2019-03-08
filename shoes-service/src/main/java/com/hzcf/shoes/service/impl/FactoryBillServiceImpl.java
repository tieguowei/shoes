package com.hzcf.shoes.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzcf.shoes.dao.FactoryPaymentRecordMapper;
import com.hzcf.shoes.service.FactoryBillService;
import com.hzcf.shoes.util.PageModel;

@Service
public class FactoryBillServiceImpl implements FactoryBillService {

    @Autowired
    private FactoryPaymentRecordMapper factoryPaymentRecordMapper;

    @Override
    public PageModel findAllByPage(Map<String, Object> paramsCondition) {
    	PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = factoryPaymentRecordMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = factoryPaymentRecordMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
    }


	@Override
	public PageModel getFactoryBillList(Map<String, Object> paramsCondition) {
		 PageModel pageModel = new PageModel();
	      /*  pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
	        pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
	        paramsCondition.put("startIndex", pageModel.getStartIndex());
	        paramsCondition.put("endIndex", pageModel.getEndIndex());
	        paramsCondition.put("factoryName", paramsCondition.get("factoryName"));
	        List<Map<String,Object>> list = factoryPaymentRecordMapper.getCustomerBackRecordList(paramsCondition);
	        Long totalRecords = factoryPaymentRecordMapper.getCustomerBackRecordListTotal(paramsCondition);
	        pageModel.setList(list);
	        pageModel.setTotalRecords(totalRecords);*/
	        return pageModel;
	}

}
