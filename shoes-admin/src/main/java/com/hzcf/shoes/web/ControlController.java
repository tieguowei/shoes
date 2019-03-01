
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzcf.shoes.baseweb.BaseController;
import com.hzcf.shoes.baseweb.DataMsg;
import com.hzcf.shoes.model.Control;
import com.hzcf.shoes.model.ControlRoleRelation;
import com.hzcf.shoes.service.ControlRoleRelationService;
import com.hzcf.shoes.service.ControlService;
import com.hzcf.shoes.util.StringUtil;

/** 
 *
 * Description: 页面控件Controller
 *
 */
@Controller
@RequestMapping(value="/control")
public class ControlController extends BaseController{

	@Autowired
	private ControlService controlService;
	
	@Autowired
	private ControlRoleRelationService controlRoleRelationService;
	
	/**
	 * 
	 * Description: 跳转到控件列表页面
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author ydw
	 * Create Date: 2014-12-8 下午04:51:59
	 */
	@RequestMapping(value="/toCtrlList/{pageId}")
	public String toCtrlList(@PathVariable Integer pageId,String refreshTag,String messageCode,Model model){
		showMessageAlert(refreshTag,messageCode,model);
		return "app/control/control_list";
	}
	
	/**
	 * 
	 * Description: 当前页面控件列表
	 *
	 * @param 
	 * @return DataMsg
	 * @throws 
	 * @Author ydw
	 * Create Date: 2014-12-8 下午05:01:44
	 */
	@ResponseBody
	@RequestMapping(value="/controls/{pageId}")
	public DataMsg contList(@PathVariable Integer pageId,HttpServletRequest request,DataMsg dataMsg) {
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			paramsCondition.put("pageId", pageId);//所属页面id
			String controlName = request.getParameter("controlName");//控件中文名
			if(StringUtil.isNotBlank(controlName)){
				paramsCondition.put("controlName", controlName.trim());
			}
			String controlMark = request.getParameter("controlMark");//控件唯一标识
			if(StringUtil.isNotBlank(controlMark)){
				paramsCondition.put("controlMark", controlMark.trim());
			}
			dataMsg.setRows(controlService.findAllNoPage(paramsCondition));
		} catch (NumberFormatException e) {
			logger.error(e.getMessage(),e);
		}
		return dataMsg;
	}
	
	/**
	 * 
	 * Description: 跳转到添加新控件页面
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author ydw
	 * Create Date: 2014-12-9 上午11:25:58
	 */
	@RequestMapping(value="/toAddCtrl/{pageId}")
	public String toAddCtrl(@PathVariable Integer pageId) {
		return "app/control/control_add";
	}
	
	/**
	 * 
	 * Description: 添加控件
	 *
	 * @param 
	 * @return DataMsg
	 * @throws 
	 * @Author ydw
	 * Create Date: 2014-12-9 下午01:53:51
	 */
	@ResponseBody
	@RequestMapping(value="/doAddCtrl")
	public DataMsg doAddCtrl(@ModelAttribute Control control,DataMsg dataMsg,HttpSession session) {
		try {
			control.setCreator(getSystemCurrentUser(session).getEmployeeId());
			control.setCreateTime(new Date());
			controlService.addControl(control);
			dataMsg.setMessageCode("0001");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			dataMsg.setMessageCode("0002");
		}
		return dataMsg;
	}
	
	/**
	 * 
	 * Description: 跳转到控件修改页面
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author ydw
	 * Create Date: 2014-12-9 下午02:05:09
	 */
	@RequestMapping(value="/toUpdateCtrl/{controlId}")
	public String toUpdateCtrl(@PathVariable Integer controlId,Model model){
		try {
			Control control = controlService.getControlByControlId(controlId);
			model.addAttribute("control", control);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return "common/exception";
		}
		return "app/control/control_edit";
	}
	
	/**
	 * 
	 * Description: 修改控件
	 *
	 * @param 
	 * @return DataMsg
	 * @throws 
	 * @Author ydw
	 * Create Date: 2014-12-9 下午02:11:56
	 */
	@ResponseBody
	@RequestMapping(value="/doUpdateCtrl")
	public DataMsg doUpdateCtrl(@ModelAttribute Control control,DataMsg dataMsg) {
		try {
			controlService.editControl(control);
			dataMsg.setMessageCode("0003");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			dataMsg.setMessageCode("0004");
		}
		return dataMsg;
	}
	
	/**
	 * 
	 * Description: 跳转到控件授权页面
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author ydw
	 * Create Date: 2014-12-9 下午02:52:42
	 */
	@RequestMapping(value="/toAuthorization/{controlId}")
	public String toAuthorization(@PathVariable Integer controlId,Model model) {
		try {
			Map<String, Object> pageControlInfo = controlService.findPageControlInfoByContolId(controlId);
			model.addAttribute("pageControlInfo", pageControlInfo);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return "common/exception";
		}
		return "app/control/control_authorization";
	}
	
	/**
	 * 
	 * Description: 给控件按钮授权
	 *
	 * @param 
	 * @return DataMsg
	 * @throws 
	 * @Author ydw
	 * Create Date: 2014-12-9 下午04:22:48
	 */
	@ResponseBody
	@RequestMapping(value="/doAuthorizationControl")
	public DataMsg doAuthorizationControl(@ModelAttribute ControlRoleRelation controlRoleRelation,@RequestParam String roleIds,DataMsg dataMsg,HttpSession session){
		try {
			controlRoleRelation.setCreator(getSystemCurrentUser(session).getEmployeeId());
			controlRoleRelation.setCreateTime(new Date());
			controlRoleRelationService.addCtrlRoleRelation(controlRoleRelation, roleIds.split(","));
			dataMsg.setMessageCode("0014");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			dataMsg.setMessageCode("0015");
		}
		return dataMsg;
	}
}

