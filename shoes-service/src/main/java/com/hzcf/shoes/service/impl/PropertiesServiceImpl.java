package com.hzcf.shoes.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzcf.shoes.dao.PropertiesMapper;
import com.hzcf.shoes.model.SsmProperties;
import com.hzcf.shoes.service.PropertiesService;
import com.hzcf.shoes.util.PageModel;

@Service
public class PropertiesServiceImpl implements PropertiesService {

	private static final Logger logger = Logger.getLogger(PropertiesServiceImpl.class);

	@Autowired
	private PropertiesMapper PropertiesMapper;

	@Override
	public SsmProperties selectByPrimaryKey(Integer id) {

		return PropertiesMapper.selectByPrimaryKey(id);
	}


	@Override
	public PageModel findAllByPage(Map<String, Object> paramsCondition) {
		
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = PropertiesMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = PropertiesMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}

	@Override
	public Integer updateProperties(SsmProperties ssmProperties) {
		
		return PropertiesMapper.updateByPrimaryKeySelective(ssmProperties);
	}

	@Override
	public Integer addProperties(SsmProperties ssmProperties) {
		
		return PropertiesMapper.insert(ssmProperties);
	}

}
