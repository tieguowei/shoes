package com.hzcf.shoes.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import com.hzcf.shoes.model.SsmProperties;
import com.hzcf.shoes.service.PropertiesService;
import com.hzcf.shoes.util.PageModel;
import com.hzcf.shoes.util.StringUtil;

/**
 * @Description属性信息
 * @author stm
 */
@Controller
@RequestMapping("/properties")
public class PropertiesController extends BaseController {

	@Autowired
	private PropertiesService ssmPropertiesService;

	/**
	 * Description: 跳转到列表页面
	 * 
	 * @return
	 */
	@RequestMapping("/toPropList")
	public String toEmpList(String refreshTag, String messageCode, Model model) {
		showMessageAlert(refreshTag, messageCode, model);
		return "app/properties/properties_list";
	}

	/**
	 * @Description： 属性分页
	 * @param request
	 * @param dataMsg
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/propertiesesPages")
	public DataMsg findPropertiesList(HttpServletRequest request,
			DataMsg dataMsg) {

		try {

			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("page")));
			paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("rows")));

			String propertyName = request.getParameter("propertyName");// 属性名称
			if (StringUtil.isNotBlank(propertyName)) {
				paramsCondition.put("propertyName", propertyName.trim());
			}
			String propertyStringValue = request.getParameter("propertyStringValue");// 属性值
			if (StringUtil.isNotBlank(propertyStringValue)) {
				paramsCondition.put("propertyStringValue",propertyStringValue.trim());
			}

			PageModel pageModel = ssmPropertiesService.findAllByPage(paramsCondition);
			dataMsg.setTotal(pageModel.getTotalRecords());
			dataMsg.setRows(pageModel.getList());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return dataMsg;
	}

	/**
	 * 
	 * Description: 跳转到添加页面
	 *
	 * @param
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/toAddPropertieses")
	public String toAddPage() {
		return "app/properties/properties_add";
	}

	/**
	 * 
	 * Description: 保存添加页面
	 *
	 * @param
	 * @return DataMsg
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/doAddPropertieses")
	public DataMsg doAddPropertieses(
			@ModelAttribute SsmProperties ssmProperties, DataMsg dataMsg,HttpSession session) {
		try {
			Integer updateUserId=getSystemCurrentUser(session).getEmployeeId();
			ssmProperties.setUpdateUserId(updateUserId);
			ssmProperties.setUpdateTime(new Date());
			ssmPropertiesService.addProperties(ssmProperties);
			dataMsg.setMessageCode("0001");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			dataMsg.setMessageCode("0002");
		}
		return dataMsg;
	}

	/**
	 * 
	 * Description: 跳转到修改页面
	 *
	 * @param
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/toUpdateProperties/{id}")
	public String toUpdateProperties(@PathVariable Integer id, Model model) {
		try {
			SsmProperties ssmProperties = ssmPropertiesService.selectByPrimaryKey(id);
		
			model.addAttribute("ssmProperties", ssmProperties);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return "common/exception";
		}
		return "app/properties/properties_edit";
	}

	/**
	 * 
	 * Description: 修改
	 *
	 * @param
	 * @return DataMsg
	 * @Author stm
	 */
	@ResponseBody
	@RequestMapping(value = "/doUpdateProperties")
	public DataMsg doUpdateProperties(@ModelAttribute SsmProperties ssmProperties, DataMsg dataMsg,HttpSession session) {
		try {
			
			Integer updateUserId=getSystemCurrentUser(session).getEmployeeId();
			ssmProperties.setUpdateUserId(updateUserId);
			ssmProperties.setUpdateTime(new Date());
			ssmPropertiesService.updateProperties(ssmProperties);
			dataMsg.setMessageCode("0003");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			dataMsg.setMessageCode("0004");
		}
		return dataMsg;
	}

}
