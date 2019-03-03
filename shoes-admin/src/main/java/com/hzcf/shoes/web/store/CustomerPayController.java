package com.hzcf.shoes.web.store;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hzcf.shoes.service.CustomerService;
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
import com.hzcf.shoes.model.ZlyShoeBrand;
import com.hzcf.shoes.model.ZlyShoeFactory;
import com.hzcf.shoes.service.ZlyShoeFactoryService;
import com.hzcf.shoes.util.PageModel;
import com.hzcf.shoes.util.StringUtil;


/** 
*
* Description: 客户账单管理
*
*/
@Controller
@RequestMapping("/customerPay")
public class CustomerPayController extends BaseController{

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ZlyShoeFactoryService zlyShoeFactoryService ;
	
	/**
	 * 
	 * Description: 跳转到列表页面
	 */
	@RequestMapping("/toPageList")
	public String toEmpList(String refreshTag,String messageCode,Model model) {
		showMessageAlert(refreshTag,messageCode,model);
		return "/app/store/customerAccountsManagement/customer_pay_list";
	}
	
	/**
	 * 
	 * Description: 查询客户账单列表
	 */
	@ResponseBody
	@RequestMapping(value="/getCustomerList")
	public DataMsg getFactoryList(HttpServletRequest request,DataMsg dataMsg) {
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("page")));
			paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("rows")));
			paramsCondition.put("customerName", request.getParameter("customerName"));
			PageModel pageModel = this.customerService.getCustomerAccountList(paramsCondition);
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
    @RequestMapping(value="/customerBackRecordSelectPage/{customerName}")
    public String toUpdateFactory(@PathVariable String customerName ,Model model){
        model.addAttribute("customerName", customerName);
        return "/app/store/customerAccountsManagement/customer_back_record_list";
    }

    /**
     *  客户回款记录查询
     * @return
     */
    @RequestMapping(value = "/customerBackRecordSelect")
    @ResponseBody
	public DataMsg getBackRecordSelect(HttpServletRequest request,DataMsg dataMsg){
          try {
              Map<String, Object> paramsCondition = new HashMap<String, Object>();
              paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("page")));
              paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("rows")));
              paramsCondition.put("customerName", request.getParameter("customerName"));
              PageModel pageModel = this.customerService.selectBackRecordList(paramsCondition);
              dataMsg.setTotal(pageModel.getTotalRecords());
              dataMsg.setRows(pageModel.getList());
          } catch (Exception e) {
              logger.error(e.getMessage(),e);
          }
          return dataMsg;
      }
     
     /**
      * 跳转到修改页面
      * @param id
      * @param model
      * @return
      */
     @RequestMapping(value="/updateCustomerBackRecorde/{id}")
 	public String toUpdateFactory(@PathVariable Integer id,Model model){
     	  	Map<String, Object> map = zlyShoeFactoryService.findFactoryById(id);
     	   List <ZlyShoeBrand> list = zlyShoeFactoryService.getBrandListById(id);
			model.addAttribute("factory", map);
			model.addAttribute("list", list);
			return "/app/zly/factory/factory_edit";
 	}
     
     
     /**
      * 修改保存
      * @param dataMsg
      * @return
      */
   	@ResponseBody
   	@RequestMapping(value="/doUpdateFactory")
   	public DataMsg doUpdateFactory(@ModelAttribute ZlyShoeFactory zlyShoeFactory,DataMsg dataMsg,@RequestParam(value = "itemNo", required = true) String[]  itemNo,HttpSession session ){
   		try {
   			//去空格
   			zlyShoeFactory.setUpdateTime(new Date());
   			zlyShoeFactory.setOperator(getSystemCurrentUser(session).getEmployeeId());
   			zlyShoeFactoryService.updateFactory(zlyShoeFactory);
   			zlyShoeFactoryService.delBrandByFactoryId(zlyShoeFactory.getId());
   			//添加货号表
				for (int i=0;i<itemNo.length;i++){
					ZlyShoeBrand shoeBrand = new ZlyShoeBrand();
					shoeBrand.setFactoryId(zlyShoeFactory.getId());
					shoeBrand.setCreateTime(new Date());
					shoeBrand.setItemNo(itemNo[i]);
					shoeBrand.setOperator(getSystemCurrentUser(session).getEmployeeId());
					if(StringUtil.isNotBlank(itemNo[i])){
						zlyShoeFactoryService.insertBrand(shoeBrand);
					}
				}
   			dataMsg.setMessageCode("0003");
   		} catch (Exception e) {
   			logger.error(e.getMessage(),e);
   			dataMsg.setMessageCode("0004");
   		}
   		return dataMsg;
   	}
}
