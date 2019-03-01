
package com.hzcf.shoes.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzcf.shoes.dao.ZlyShoeBrandMapper;
import com.hzcf.shoes.dao.ZlyShoeFactoryMapper;
import com.hzcf.shoes.model.ZlyShoeBrand;
import com.hzcf.shoes.model.ZlyShoeFactory;
import com.hzcf.shoes.service.ZlyShoeFactoryService;
import com.hzcf.shoes.util.PageModel;

@Service
public class ZlyShoeFactoryServiceImpl implements ZlyShoeFactoryService{

	@Autowired
	private ZlyShoeFactoryMapper zlyShoeFactoryMapper;
	@Autowired
	private ZlyShoeBrandMapper zlyShoeBrandMapper;


	@Override
	public PageModel findAllByPage(Map<String, Object> paramsCondition) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = zlyShoeFactoryMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = zlyShoeFactoryMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}

	@Override
	public int checkName(Map<String, Object> params) {
		return zlyShoeFactoryMapper.checkName(params);
	}

	@Override
	public void addGoldProduct(ZlyShoeFactory zlyShoeFactory) {
		zlyShoeFactoryMapper.insert(zlyShoeFactory);
	}

	@Override
	public Map<String, Object> selectLastOne() {
		return zlyShoeFactoryMapper.selectLastOne();
	}

	@Override
	public void insertBrand(ZlyShoeBrand shoeBrand) {
		zlyShoeBrandMapper.insert(shoeBrand);	
	}

	@Override
	public Map<String, Object> findFactoryById(Integer id) {
		return zlyShoeFactoryMapper.findFactoryById(id);
	}

	@Override
	public List<ZlyShoeBrand> getBrandListById(Integer id) {
		return zlyShoeBrandMapper.getBrandListById(id);
	}

	@Override
	public void updateFactory(ZlyShoeFactory zlyShoeFactory) {
		zlyShoeFactoryMapper.updateByPrimaryKey(zlyShoeFactory);	
	}

	@Override
	public void delBrandByFactoryId(Integer id) {
		zlyShoeBrandMapper.delBrandByFactoryId(id);
		
	}
	


}
