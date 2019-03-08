package com.hzcf.shoes.web.store;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzcf.shoes.baseweb.BaseController;
import com.hzcf.shoes.baseweb.DataMsg;
import com.hzcf.shoes.service.FactoryBillService;
import com.hzcf.shoes.util.PageModel;
import com.hzcf.shoes.util.StringUtil;


/** 
*
* Description: 鞋厂管理
*
*/
@Controller
@RequestMapping("/factory")
public class FactoryController extends BaseController{

	@Autowired
	private FactoryBillService factoryBillService;
	
	
	
	/**
	 * 
	 * Description: 跳转到客户分组列表页面
	 */
	@RequestMapping("/toPageList")
	public String toEmpList(String refreshTag,String messageCode,Model model) {
		showMessageAlert(refreshTag,messageCode,model);
		return "/app/store/factoryManage/factory_sum_list";
	}
	
	/**
	 * 
	 * Description: 查询鞋厂分组列表
	 */
	@ResponseBody
	@RequestMapping(value="/getFactoryList")
	public DataMsg getFactoryList(HttpServletRequest request,DataMsg dataMsg) {
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("page")));
			paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("rows")));
			String factoryName = StringUtil.trim(request.getParameter("factoryName"));// 客户姓名
			if (StringUtil.isNotBlank(factoryName)) {
				paramsCondition.put("factoryName", factoryName);
			}
			PageModel pageModel = factoryBillService.findAllByPage(paramsCondition);
			dataMsg.setTotal(pageModel.getTotalRecords());
			dataMsg.setRows(pageModel.getList());
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return dataMsg;
	}
}
