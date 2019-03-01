
package com.hzcf.shoes.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzcf.shoes.baseweb.BaseController;
import com.hzcf.shoes.baseweb.DataMsg;
import com.hzcf.shoes.model.WorkGroup;
import com.hzcf.shoes.service.WorkGroupService;
import com.hzcf.shoes.util.StringUtil;


/** 
 *
 * Description: 员工工作组Controller
 *
 * @author ydw
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-12-2    ydw       1.0        1.0 Version 
 * </pre>
 */
@Controller
@RequestMapping("/workGroup")
public class WorkGroupController extends BaseController{

	@Autowired
	private WorkGroupService workGroupService;
	
	/**
	 * 
	 * Description: 添加工作组
	 *
	 * @param 
	 * @return DataMsg
	 * @throws 
	 * @Author ydw
	 * Create Date: 2014-12-2 下午05:13:24
	 */
	@ResponseBody
	@RequestMapping("/addWorkGroup")
	public DataMsg addWorkGroup(@RequestParam Integer employeeId,@RequestParam String deptIds,DataMsg dataMsg) {
		try {
			String[] deptIdsArray = {};
			if(StringUtil.isNotBlank(deptIds)){
				deptIdsArray = deptIds.split(",");
			}
			List<WorkGroup> workGroups = new ArrayList<WorkGroup>();
			WorkGroup workGroup = null;
			for (int i = 0; i < deptIdsArray.length; i++) {
				workGroup = new WorkGroup();
				workGroup.setEmployeeId(employeeId);
				workGroup.setDeptId(Integer.parseInt(deptIdsArray[i]));
				workGroups.add(workGroup);
			}
			workGroupService.insertWorkGroups(workGroups,employeeId);
			dataMsg.setMessageCode("0012");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			dataMsg.setMessageCode("0013");
		}
		return dataMsg;
	}
}
