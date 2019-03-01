package com.hzcf.shoes.web.zly;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
* Description: 鞋厂管理
*
*/
@Controller
@RequestMapping("/zly/shoeFactory")
public class ZLYShoeFactoryController extends BaseController{

	@Autowired
	private ZlyShoeFactoryService zlyShoeFactoryService;
	
	
	
	/**
	 * 
	 * Description: 跳转到列表页面
	 */
	@RequestMapping("/toPageList")
	public String toEmpList(String refreshTag,String messageCode,Model model) {
		showMessageAlert(refreshTag,messageCode,model);
		return "app/zly/factory/factory_list";
	}
	
	/**
	 * 
	 * Description: 鞋厂分页查询列表
	 */
	@ResponseBody
	@RequestMapping(value="/getFactoryList")
	public DataMsg getFactoryList(HttpServletRequest request,DataMsg dataMsg) {
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("page")));
			paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("rows")));
			PageModel pageModel = zlyShoeFactoryService.findAllByPage(paramsCondition);
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
    @RequestMapping(value="/toAddFactory")
	public String toAddGoldProduct() {
		return "/app/zly/factory/factory_add";
	}
	
    /**
  	 * 校验名称是否存在
  	 * @return
  	 */
     @RequestMapping(value = "/checkName")
     @ResponseBody
     public int checkName(@RequestParam(value = "name", required = true)String name,@RequestParam(value = "id", required = false)String id) {
         try {
         		Map<String, Object> params = new HashMap<String, Object>();
         		params.put("name", name);
         		params.put("id", id);
            	return zlyShoeFactoryService.checkName(params);
         } catch (Exception e) {
             logger.error(e.getMessage(), e);
             return 0;
         }
     }
     
     /**
      * 添加
      * @param goldProduct
      * @param dataMsg
      * @param session
      * @return
      */
     @ResponseBody
 	@RequestMapping(value="/doAddFactory")
 	public DataMsg doAddFactory(@ModelAttribute ZlyShoeFactory zlyShoeFactory,HttpSession session,@RequestParam(value = "itemNo", required = true) String[]  itemNo,DataMsg dataMsg){
 		try {
 			zlyShoeFactory.setOperator(getSystemCurrentUser(session).getEmployeeId());
 			zlyShoeFactory.setCreateTime(new Date());
 			zlyShoeFactoryService.addGoldProduct(zlyShoeFactory);
 			//查询出最新添加的记录
 			Map<String,Object> map = zlyShoeFactoryService.selectLastOne();
 			if(null != map){
 				//添加货号表
 				for (int i=0;i<itemNo.length;i++){
 					ZlyShoeBrand shoeBrand = new ZlyShoeBrand();
 					Integer factoryId  = Integer.valueOf(String.valueOf(map.get("id")));
 					shoeBrand.setFactoryId(factoryId);
 					shoeBrand.setCreateTime(new Date());
 					shoeBrand.setItemNo(itemNo[i]);
 					shoeBrand.setOperator(getSystemCurrentUser(session).getEmployeeId());
 					if(StringUtil.isNotBlank(itemNo[i])){
 						zlyShoeFactoryService.insertBrand(shoeBrand);
 					}
 				}
 			}
 			dataMsg.setMessageCode("0001");
 		} catch (Exception e) {
 			logger.error(e.getMessage(),e);
 			dataMsg.setMessageCode("0002");
 		}
 		return dataMsg;
 	}
}
