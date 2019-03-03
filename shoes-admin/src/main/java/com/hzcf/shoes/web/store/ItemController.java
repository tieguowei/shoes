package com.hzcf.shoes.web.store;

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
import com.hzcf.shoes.model.Employee;
import com.hzcf.shoes.model.Order;
import com.hzcf.shoes.service.ItemService;
import com.hzcf.shoes.util.PageModel;
import com.hzcf.shoes.util.StringUtil;


/** 
*
* Description: 订单管理
*
*/
@Controller
@RequestMapping("/item")
public class ItemController extends BaseController{

	@Autowired
	private ItemService itemService;
	
	
	
	/**
	 * 
	 * Description: 跳转到订单列表页面
	 */
	@RequestMapping("/toPageList")
	public String toEmpList(String refreshTag,String messageCode,Model model) {
		showMessageAlert(refreshTag,messageCode,model);
		return "app/store/itemManagement/item_list";
	}
	
	/**
	 * 
	 * Description: 订单分页查询列表
	 */
	@ResponseBody
	@RequestMapping(value="/getItemList")
	public DataMsg getItemList(HttpServletRequest request,DataMsg dataMsg) {
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("page")));
			paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("rows")));
			String customerName = StringUtil.trim(request.getParameter("customerName"));// 客户姓名
			if (StringUtil.isNotBlank(customerName)) {
				paramsCondition.put("customerName", customerName);
			}
			String factoryName = StringUtil.trim(request.getParameter("factoryName"));// 鞋厂名称
			if (StringUtil.isNotBlank(factoryName)) {
				paramsCondition.put("factoryName", factoryName);
			}
			String factoryIsDefectiveGoods = StringUtil.trim(request.getParameter("factoryIsDefectiveGoods"));// 鞋厂是否减次
			if (StringUtil.isNotBlank(factoryIsDefectiveGoods)) {
				paramsCondition.put("factoryIsDefectiveGoods", factoryIsDefectiveGoods);
			}
			String customerIsDefectiveGoods = request.getParameter("customerIsDefectiveGoods");//客户是否减次
			if (StringUtil.isNumeric(customerIsDefectiveGoods)) {
				paramsCondition.put("customerIsDefectiveGoods", customerIsDefectiveGoods);
			}
			String season = request.getParameter("season");//季节
			if (StringUtil.isNumeric(season)) {
				paramsCondition.put("season", season);
			}
			
			//发货开始时间
			String minCreateTime = request.getParameter("minCreateTime");
			if(StringUtil.isNotBlank(minCreateTime)){
				paramsCondition.put("minCreateTime", minCreateTime.trim());
			}
			//发货结束时间
			String maxCreateTime = request.getParameter("maxCreateTime");
			if(StringUtil.isNotBlank(maxCreateTime)){
				paramsCondition.put("maxCreateTime", maxCreateTime.trim());
			}
			PageModel pageModel = itemService.findAllByPage(paramsCondition);
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
    @RequestMapping(value="/toAddItem")
	public String toAddItem() {
		return "/app/store/itemManagement/item_add";
	}
	
    /**
     * 添加订单
     * @param order
     * @param session
     * @param dataMsg
     * @param oauth
     * @return
     */
    @ResponseBody
	@RequestMapping(value="/doAddItem")
	public DataMsg doAddItem(@ModelAttribute Order order,HttpSession session,DataMsg dataMsg,String oauth) {
		try {
			order.setCreateTime(new Date());
			order.setOperator(getSystemCurrentUser(session).getEmployeeId());
			itemService.insertSelective(order);
			dataMsg.setMessageCode("0001");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			dataMsg.setMessageCode("0002");
		}
		return dataMsg;
	}
   
    /**
	 * 
	 * Description: 跳转到修改订单页面
	 */
	@RequestMapping(value="/toEditItem/{id}")
	public String toEditItem(@PathVariable Integer id,Model model) {
		try {
			Order order = itemService.selectByPrimaryKey(id);
			model.addAttribute("order", order);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return "common/exception";
		}
		return "app/store/itemManagement/item_edit";
	}
	

	/**
	 * 
	 * Description: 修改订单信息
	 */
	@ResponseBody
	@RequestMapping("/doEditItem")
	public DataMsg doEditItem(@ModelAttribute Order order,HttpSession session,DataMsg dataMsg){
		try {
			order.setOperator(getSystemCurrentUser(session).getEmployeeId());
			order.setUpdateTime(new Date());
			itemService.updateByPrimaryKeySelective(order);
			dataMsg.setMessageCode("0003");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			dataMsg.setMessageCode("0004");
		}
		return dataMsg;
	}
}
