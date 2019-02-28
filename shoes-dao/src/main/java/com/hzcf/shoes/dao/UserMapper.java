package com.hzcf.shoes.dao;

import java.util.List;

import com.hzcf.shoes.model.Control;

public interface UserMapper extends BaseMapper<Control>{
	
	/**
	 * 
	 * Description: 数据上传
	 *
	 * @param 
	 * @return Map<String,Object>
	 * @throws 
	 * @Author ydw
	 * Create Date: 2014-12-9 下午02:57:31
	 */
	public void dataUpload(List resultList);
	
	
}