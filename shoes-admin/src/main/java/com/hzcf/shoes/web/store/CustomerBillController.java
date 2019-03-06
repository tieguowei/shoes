package com.hzcf.shoes.web.store;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzcf.shoes.baseweb.BaseController;
import com.hzcf.shoes.baseweb.DataMsg;
import com.hzcf.shoes.service.CustomerService;
import com.hzcf.shoes.util.PageModel;
import com.hzcf.shoes.util.StringUtil;


/** 
*
* Description: 客户账单管理
*
*/
@Controller
@RequestMapping("/customerBill")
public class CustomerBillController extends BaseController{

	@Autowired
	private CustomerService customerService;

	
	/**
	 * 
	 * Description: 跳转到客户分组列表页面
	 */
	@RequestMapping("/toPageList")
	public String toEmpList(String refreshTag,String messageCode,Model model) {
		showMessageAlert(refreshTag,messageCode,model);
		return "/app/store/customerBill/customer_sum_list";
	}
	
	/**
	 * 
	 * Description: 查询客户分组列表
	 */
	@ResponseBody
	@RequestMapping(value="/getCustomerList")
	public DataMsg getFactoryList(HttpServletRequest request,DataMsg dataMsg) {
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
     * 跳转到 回款记录查询 页面
     * @param customerName
     * @param model
     * @return
     */
	 @RequestMapping(value="/toCustomerBillList/{customerName}")
	    public String toUpdateFactory(@PathVariable String customerName ,Model model){
		 try {
			customerName = new String(customerName.getBytes("ISO-8859-1"), "utf8");
		} catch (Exception e) {
			e.printStackTrace();
		}   
		 model.addAttribute("customerName", customerName);
	        return "/app/store/customerBill/customer_bill_list";
	    }

    /**
     *  客户账单详情查询
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
     
}
