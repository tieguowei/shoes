package com.hzcf.shoes.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzcf.shoes.dao.JxStudentMapper;
import com.hzcf.shoes.model.CustomerPaymentRecord;
import com.hzcf.shoes.model.JxStudent;
import com.hzcf.shoes.service.CustomerService;
import com.hzcf.shoes.service.JxService;
import com.hzcf.shoes.util.DateTimeUtil;
import com.hzcf.shoes.util.ExportExcel;
import com.hzcf.shoes.util.PageModel;

@Service
public class JxServiceImpl implements JxService {

    @Autowired
    private JxStudentMapper jxStudentMapper;

    @Override
    public PageModel findAllByPage(Map<String, Object> paramsCondition) {
    	PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = jxStudentMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = jxStudentMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
    }

	@Override
	public void insertSelective(JxStudent student) {
		jxStudentMapper.insertSelective(student);
	}

	@Override
	public JxStudent selectById(Integer id) {
		return jxStudentMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateById(JxStudent student) {
		jxStudentMapper.updateByPrimaryKeySelective(student);
	}

	@Override
	public void jxDataExport(Map<String, Object> paramsCondition, HttpServletResponse response) {
		List<Map<String, Object>> result = jxStudentMapper.findAllRetMapByPage(paramsCondition);
		List<Object[]> dataList = new ArrayList<Object[]>();
		String title = DateTimeUtil.getNowDateChinaString() +"约车名单";
		Object[] objs = null;
		Map<String, Object> map = null;
		String[] rowsName = new String[]{"序号","账号", "密码", "所学班型", "学车时间", "预约驾校","备注"};
		for (int i = 0; i < result.size(); i++) {
			map = result.get(i);
			objs = new Object[rowsName.length];
			objs[0] = i + 1;
			objs[1] = map.get("account");
			objs[2] = map.get("password");
			objs[3] = map.get("class_type");
			objs[4] = map.get("study_time");
			objs[5] = map.get("jx_name");
			objs[6] = map.get("remark");
			dataList.add(objs);
		}
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		ex.export(response);
	}


}
