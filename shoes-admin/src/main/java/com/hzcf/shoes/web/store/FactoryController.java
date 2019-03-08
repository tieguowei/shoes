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
import com.hzcf.shoes.dao.FactoryGetGoodsMapper;
import com.hzcf.shoes.model.FactoryGetGoods;
import com.hzcf.shoes.model.Order;
import com.hzcf.shoes.service.FactoryBillService;
import com.hzcf.shoes.service.FactoryPickService;
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
	@Autowired
	private FactoryPickService factoryPickService;
	
	
	/**
	 * 
	 * Description: 跳转到鞋厂分组列表页面
	 */
	@RequestMapping("/toPageList")
	public String toPageList(String refreshTag,String messageCode,Model model) {
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
	/**
	 * 
	 * Description: 跳转到鞋厂取货列表页面
	 */
	@RequestMapping("/toFactoryPickList")
	public String toFactoryPickList(String refreshTag,String messageCode,Model model) {
		showMessageAlert(refreshTag,messageCode,model);
		return "/app/store/factoryManage/factory_pick_list";
	}
	/**
	 * 
	 * Description: 查询鞋厂分组列表
	 */
	@ResponseBody
	@RequestMapping(value="/getFactoryPcikList")
	public DataMsg getFactoryPcikList(HttpServletRequest request,DataMsg dataMsg) {
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("page")));
			paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("rows")));
			String factoryName = StringUtil.trim(request.getParameter("factoryName"));// 客户姓名
			if (StringUtil.isNotBlank(factoryName)) {
				paramsCondition.put("factoryName", factoryName);
			}
			PageModel pageModel = factoryPickService.findAllByPage(paramsCondition);
			dataMsg.setTotal(pageModel.getTotalRecords());
			dataMsg.setRows(pageModel.getList());
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return dataMsg;
	}
	
	  /**
     * 跳转添加取货记录页面
     * @return
     */
    @RequestMapping(value="/toAddPick")
	public String toAddPick() {
		return "/app/store/factoryManage/factory_pick_add";
	}
	
    /**
     * 添加取货记录
     * @return
     */
    @ResponseBody
	@RequestMapping(value="/doAddPick")
	public DataMsg doAddPick(@ModelAttribute FactoryGetGoods goods,HttpSession session,DataMsg dataMsg,String oauth) {
		try {
			goods.setCreateTime(new Date());
			goods.setStatus("1");
			goods.setOperator(getSystemCurrentUser(session).getEmployeeId());
			factoryPickService.insertSelective(goods);
			dataMsg.setMessageCode("0001");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			dataMsg.setMessageCode("0002");
		}
		return dataMsg;
	}
   
    /**
	 * 
	 * Description: 跳转到修改取货记录页面
	 */
	@RequestMapping(value="/toEditPick/{id}")
	public String toEditPick(@PathVariable Integer id,Model model) {
		try {
			Map<String,Object> map = factoryPickService.selectById(id);
			model.addAttribute("goods", map);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return "common/exception";
		}
		return "app/store/factoryManage/factory_pick_edit";
	}
	

	/**
	 * 
	 * Description: 修改取货记录信息
	 */
	@ResponseBody
	@RequestMapping("/doEditPick")
	public DataMsg doEditPick(@ModelAttribute FactoryGetGoods goods,HttpSession session,DataMsg dataMsg){
		try {
			goods.setOperator(getSystemCurrentUser(session).getEmployeeId());
			goods.setUpdateTime(new Date());
			factoryPickService.updateByPrimaryKeySelective(goods);
			dataMsg.setMessageCode("0003");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			dataMsg.setMessageCode("0004");
		}
		return dataMsg;
	}
}
