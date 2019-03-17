package com.hzcf.shoes.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.hzcf.shoes.model.JxStudent;
import com.hzcf.shoes.util.PageModel;

public interface JxService {

    /**
     *
     * Description:驾校预约车列表
     */
	public PageModel findAllByPage(Map<String, Object> paramsCondition);

	public void insertSelective(JxStudent student);

	public JxStudent selectById(Integer id);

	public void updateById(JxStudent student);

	public void jxDataExport(Map<String, Object> paramsCondition, HttpServletResponse response);



}
