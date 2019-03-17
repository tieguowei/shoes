package com.hzcf.shoes.web.store;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzcf.shoes.baseweb.BaseController;
import com.hzcf.shoes.baseweb.DataMsg;
import com.hzcf.shoes.model.CustomerAccount;
import com.hzcf.shoes.model.CustomerPayHistory;
import com.hzcf.shoes.model.CustomerPaymentRecord;
import com.hzcf.shoes.model.JxStudent;
import com.hzcf.shoes.model.Order;
import com.hzcf.shoes.service.CustomerAccountService;
import com.hzcf.shoes.service.CustomerPayHistoryService;
import com.hzcf.shoes.service.CustomerService;
import com.hzcf.shoes.service.JxService;
import com.hzcf.shoes.util.PageModel;
import com.hzcf.shoes.util.StringUtil;


/** 
*
* Description:驾校预约车管理
*
*/
@Controller
@RequestMapping("/jx")
public class JxController extends BaseController{

	@Autowired
	private JxService jxService;
	/**
	 * 
	 * Description: 跳转到驾校约车列表页面
	 */
	@RequestMapping("/toJxList")
	public String toPageList(String refreshTag,String messageCode,Model model) {
		showMessageAlert(refreshTag,messageCode,model);
		return "/app/jx/jx_list";
	}
	
	/**
	 * 
	 * Description: 查询驾校组列表
	 */
	@ResponseBody
	@RequestMapping(value="/getJxList")
	public DataMsg getCustomerList(HttpServletRequest request,DataMsg dataMsg) {
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("page")));
			paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("rows")));
			String account = StringUtil.trim(request.getParameter("account"));// 账号
			if (StringUtil.isNotBlank(account)) {
				paramsCondition.put("account", account);
			}
			String classType = StringUtil.trim(request.getParameter("classType"));//班型
			if (StringUtil.isNotBlank(classType)) {
				paramsCondition.put("classType", classType);
			}
			String jxName = StringUtil.trim(request.getParameter("jxName"));
			if (StringUtil.isNotBlank(jxName)) {
				paramsCondition.put("jxName", jxName);
			}
			//开始时间
			String minCreateTime = request.getParameter("minCreateTime");
			if(StringUtil.isNotBlank(minCreateTime)){
				paramsCondition.put("minCreateTime", minCreateTime.trim());
			}
			//结束时间
			String maxCreateTime = request.getParameter("maxCreateTime");
			if(StringUtil.isNotBlank(maxCreateTime)){
				paramsCondition.put("maxCreateTime", maxCreateTime.trim());
			}
			PageModel pageModel = jxService.findAllByPage(paramsCondition);
			dataMsg.setTotal(pageModel.getTotalRecords());
			dataMsg.setRows(pageModel.getList());
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return dataMsg;
	}

	  /**
     * 跳转添加页面
     * @return
     */
    @RequestMapping(value="/toAddJx")
	public String toAddJx() {
		return "/app/jx/jx_add";
	}
    
    
    /**
     * 添加预约记录
     * @return
     */
    @ResponseBody
	@RequestMapping(value="/doAddJx")
	public DataMsg doAddItem(@ModelAttribute JxStudent student,DataMsg dataMsg,String oauth) {
		try {
			student.setCreateTime(new Date());
			jxService.insertSelective(student);
			dataMsg.setMessageCode("0001");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			dataMsg.setMessageCode("0002");
		}
		return dataMsg;
	}
    
    /**
   	 * 
   	 * Description: 跳转到修改预约记录
   	 */
   	@RequestMapping(value="/toEditJx/{id}")
   	public String toEditJx(@PathVariable Integer id,Model model) {
   		try {
   			JxStudent student = jxService.selectById(id);
   			model.addAttribute("student", student);
   		} catch (Exception e) {
   			logger.error(e.getMessage(),e);
   			return "common/exception";
   		}
   		return "app/jx/jx_edit";
   	}
   	
   	/**
	 * 
	 * Description: 修改预约记录
	 */
	@ResponseBody
	@RequestMapping("/doEditJx")
	public DataMsg doEditJx(@ModelAttribute JxStudent student,DataMsg dataMsg){
		try {
			jxService.updateById(student);
			dataMsg.setMessageCode("0003");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			dataMsg.setMessageCode("0004");
		}
		return dataMsg;
	}
	
	/**
	 * 导出预约记录
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/jxDataExport")
	public void jxDataExport(HttpServletRequest request, HttpServletResponse response) {
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			String account = StringUtil.trim(request.getParameter("account"));// 账号
			if (StringUtil.isNotBlank(account)) {
				paramsCondition.put("account", account);
			}
			String classType = StringUtil.trim(request.getParameter("classType"));//班型
			if (StringUtil.isNotBlank(classType)) {
				paramsCondition.put("classType", classType);
			}
			String jxName = StringUtil.trim(request.getParameter("jxName"));
			if (StringUtil.isNotBlank(jxName)) {
				paramsCondition.put("jxName", jxName);
			}
			//开始时间
			String minCreateTime = request.getParameter("minCreateTime");
			if(StringUtil.isNotBlank(minCreateTime)){
				paramsCondition.put("minCreateTime", minCreateTime.trim());
			}
			//结束时间
			String maxCreateTime = request.getParameter("maxCreateTime");
			if(StringUtil.isNotBlank(maxCreateTime)){
				paramsCondition.put("maxCreateTime", maxCreateTime.trim());
			}
			jxService.jxDataExport(paramsCondition,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
