package com.hzcf.shoes.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzcf.shoes.dao.FactoryGetGoodsMapper;
import com.hzcf.shoes.dao.PropertiesMapper;
import com.hzcf.shoes.model.FactoryGetGoods;
import com.hzcf.shoes.service.FactoryPickService;
import com.hzcf.shoes.util.PageModel;

@Service
public class FactoryPickServiceImpl implements FactoryPickService {

    @Autowired
    private FactoryGetGoodsMapper factoryGetGoodsMapper;
    @Autowired
    private PropertiesMapper propertiesMapper;

    @Override
    public PageModel findAllByPage(Map<String, Object> paramsCondition) {
    	PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = factoryGetGoodsMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = factoryGetGoodsMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
    }

	@Override
	public void insertSelective(FactoryGetGoods goods) {
		factoryGetGoodsMapper.insertSelective(goods);		
	}

	@Override
	public Map<String, Object> selectById(Integer id) {
		return factoryGetGoodsMapper.selectById(id);
	}

	@Override
	public void updateByPrimaryKeySelective(FactoryGetGoods goods) {
		factoryGetGoodsMapper.updateByPrimaryKeySelective(goods);		
	}

	@Override
	public List<Map<String, Object>> getPickListByFactory(Map<String, Object> paramsCondition) {
		return factoryGetGoodsMapper.getPickListByFactory(paramsCondition);
	}

	@Override
	public BigDecimal getProperties(String winterRate) {
		return propertiesMapper.selectVersion(winterRate);
	}

	@Override
	public Map getPickSum(Map<String, Object> paramsCondition) {
		return factoryGetGoodsMapper.getPickSum(paramsCondition);
	}

	@Override
	public void updatePickStatus(Map<String, Object> paramsCondition) {
		factoryGetGoodsMapper.updatePickStatus(paramsCondition);	
	}




}
