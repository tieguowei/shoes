package com.hzcf.shoes.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzcf.shoes.vo.ReturnMsgData;

/**
 * 
 *<dl>
 *<dt>类名：UserController.java</dt>
 *<dd>描述: ~用户模块</dd> 
 *<dd>创建时间： 2017年5月22日 下午9:18:45</dd>
 *<dd>创建人： GuoDong</dd>
 *<dt>版本历史: </dt>
 * <pre>
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2017年5月22日 下午9:18:45    GuoDong       1.0        1.0 Version 
 * </pre>
 *</dl>
 */
@Controller
@RequestMapping("/user")
public class UserController{
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public ReturnMsgData login( ){
		logger.info("------------------进入用户登录接口--------------------");
		return null;
	}
	
}
