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
import com.hzcf.shoes.model.CustomerPayHistory;
import com.hzcf.shoes.model.CustomerPaymentRecord;
import com.hzcf.shoes.service.CustomerAccountService;
import com.hzcf.shoes.service.CustomerPayHistoryService;
import com.hzcf.shoes.service.CustomerService;
import com.hzcf.shoes.util.PageModel;
import com.hzcf.shoes.util.StringUtil;


/** 
*
* Description: 客户管理
*
*/
@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController{

	@Autowired
	private CustomerService customerService;
	@Autowired
	private CustomerPayHistoryService customerPayHistoryService;
	@Autowired
	private CustomerAccountService customerAccountService;
	/**
	 * 
	 * Description: 跳转到客户分组列表页面
	 */
	@RequestMapping("/toPageList")
	public String toPageList(String refreshTag,String messageCode,Model model) {
		showMessageAlert(refreshTag,messageCode,model);
		return "/app/store/customerManage/customer_sum_list";
	}
	
	/**
	 * 
	 * Description: 查询客户分组列表
	 */
	@ResponseBody
	@RequestMapping(value="/getCustomerList")
	public DataMsg getCustomerList(HttpServletRequest request,DataMsg dataMsg) {
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("page")));
			paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("rows")));
			String customerName = StringUtil.trim(request.getParameter("customerName"));// 客户姓名
			if (StringUtil.isNotBlank(customerName)) {
				paramsCondition.put("customerName", customerName);
			}
			PageModel pageModel = this.customerService.findAllByPage(paramsCondition);
			dataMsg.setTotal(pageModel.getTotalRecords());
			dataMsg.setRows(pageModel.getList());
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return dataMsg;
	}

    /**
     * 跳转到 账单列表 页面
     * @param customerName
     * @param model
     * @return
     */
	 @RequestMapping(value="/toCustomerBillList/{customerName}")
	    public String toUpdateFactory(@PathVariable String customerName ,Model model){
		 model.addAttribute("customerName", customerName);
	        return "/app/store/customerManage/customer_bill_list";
	    }

    /**
     * 账单列表详情查询
     * @return
     */
    @RequestMapping(value = "/getCustomerBillList")
    @ResponseBody
	public DataMsg getCustomerBillList(HttpServletRequest request,DataMsg dataMsg){
          try {
              Map<String, Object> paramsCondition = new HashMap<String, Object>();
              paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("page")));
              paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("rows")));
              paramsCondition.put("customerName", request.getParameter("customerName"));
             
              PageModel pageModel = this.customerService.getCustomerBillList(paramsCondition);
              dataMsg.setTotal(pageModel.getTotalRecords());
              dataMsg.setRows(pageModel.getList());
          } catch (Exception e) {
              logger.error(e.getMessage(),e);
          }
          return dataMsg;
      }
    /**
	 * 
	 * Description: 跳转到账单抹零页面
	 */
	@RequestMapping(value="/updateML/{id}")
	public String updateML(@PathVariable Integer id,Model model) {
		try {
			Map<String,Object> record =  customerService.selectById(id);
			model.addAttribute("record", record);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return "common/exception";
		}
		return "app/store/customerManage/customer_bill_edit_ml";
	}
	
	 /**
	 * 
	 * Description: 跳转到修改已付款页面
	 */
	@RequestMapping(value="/updateYFK/{id}")
	public String updateYFK(@PathVariable Integer id,Model model) {
		try {
			Map<String,Object> record =  customerService.selectById(id);
			model.addAttribute("record", record);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return "common/exception";
		}
		return "app/store/customerManage/customer_bill_edit_yfk";
	}
		
	/**
	 * 
	 * Description: 修改账单信息
	 */
	@ResponseBody
	@RequestMapping("/updateBill")
	public DataMsg updateBill(@ModelAttribute CustomerPaymentRecord record,HttpSession session,DataMsg dataMsg){
		try {
			record.setOperator(getSystemCurrentUser(session).getEmployeeId());
			record.setUpdateTime(new Date());
			customerService.updateById(record);
			dataMsg.setMessageCode("0003");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			dataMsg.setMessageCode("0004");
		}
		return dataMsg;
	}
	
	
	
	/**
	 * 
	 * Description: 跳转到客户付款列表页面
	 */
	@RequestMapping("/toCustomerPayList")
	public String toCustomerPayList(String refreshTag,String messageCode,Model model) {
		showMessageAlert(refreshTag,messageCode,model);
		return "/app/store/customerManage/customer_pay_list";
	}
	
	/**
	 * 
	 * Description: 查询客户付款列表
	 */
	@ResponseBody
	@RequestMapping(value="/getCustomerPayList")
	public DataMsg getCustomerPayList(HttpServletRequest request,DataMsg dataMsg) {
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("page")));
			paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("rows")));
			String customerName = StringUtil.trim(request.getParameter("customerName"));// 客户姓名
			if (StringUtil.isNotBlank(customerName)) {
				paramsCondition.put("customerName", customerName);
			}
			PageModel pageModel = customerPayHistoryService.findAllByPage(paramsCondition);
			dataMsg.setTotal(pageModel.getTotalRecords());
			dataMsg.setRows(pageModel.getList());
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return dataMsg;
	}
	
	 /**
     * 跳转到添加付款流水页面
     * @return
     */
    @RequestMapping(value="/toAddPay")
	public String toAddPay() {
    	
		return "/app/store/customerManage/customer_pay_add";
	}
    
    /**
     * 添加客户付款流水
     * @return
     */
    @ResponseBody
	@RequestMapping(value="/doAddPay")
	public DataMsg doAddPay(@ModelAttribute CustomerPayHistory payHistory,HttpSession session,DataMsg dataMsg,String oauth) {
		try {
			payHistory.setCreateTime(new Date());
			payHistory.setOperator(getSystemCurrentUser(session).getEmployeeId());
			customerPayHistoryService.insertSelective(payHistory);
			dataMsg.setMessageCode("0001");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			dataMsg.setMessageCode("0002");
		}
		return dataMsg;
	}
    
    
	
	/**
	 * 
	 * Description: 跳转到客户账户列表页面
	 */
	@RequestMapping("/toCustomerAccountList")
	public String toCustomerAccountList(String refreshTag,String messageCode,Model model) {
		showMessageAlert(refreshTag,messageCode,model);
		return "/app/store/customerManage/customer_account_list";
	}
	
	/**
	 * 
	 * Description: 查询客户账户列表
	 */
	@ResponseBody
	@RequestMapping(value="/getCustomerAccountList")
	public DataMsg getCustomerAccountList(HttpServletRequest request,DataMsg dataMsg) {
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("page")));
			paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("rows")));
			String customerName = StringUtil.trim(request.getParameter("customerName"));// 客户姓名
			if (StringUtil.isNotBlank(customerName)) {
				paramsCondition.put("customerName", customerName);
			}
			PageModel pageModel = customerAccountService.findAllByPage(paramsCondition);
			dataMsg.setTotal(pageModel.getTotalRecords());
			dataMsg.setRows(pageModel.getList());
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return dataMsg;
	}
	
    
}
