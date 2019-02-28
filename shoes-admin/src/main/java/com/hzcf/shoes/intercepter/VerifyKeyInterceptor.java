package com.hzcf.shoes.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hzcf.shoes.util.NewMD5Util;


/**
 * 拦截所有请求,校验签名
 * 
 * @author xuhao
 * 
 */
public class VerifyKeyInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(VerifyKeyInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*Map<String, String[]> parameterMap = request.getParameterMap();
		Map<String, String> params = MapParamUtil.paramsMapToMap(parameterMap);
		String sign = request.getParameter("sign");
		boolean result = RSASignUtil.verifyParams(params, sign, CacheManager.getGeneralText("publiKey"));
		if (!result) {
			logger.info("参数" + params.toString() + "的签名错误");
			ReturnMsgData returnMsg = new ReturnMsgData(ReturnStateCode.SIGN_ERROR.getStateCode(),
					ReturnStateCode.SIGN_ERROR.getStateDesc(), null);
			response.getWriter().println(JSON.toJSON(returnMsg));
			return false;
		}*/
		
		/*Controller controller = inv.getController();
		String sessionSearchKey = (String)controller.getSessionAttr("searchKey");
		String searchKey = controller.getPara("searchKey");
		if (StrKit.notBlank(sessionSearchKey) && MD5Util.MD5(PropKit.get("OrderKey")).equals(sessionSearchKey)) {
			inv.invoke();
		}else if (StrKit.notBlank(searchKey) && MD5Util.MD5(PropKit.get("OrderKey")).equals(searchKey)) {
			controller.setSessionAttr("searchKey", searchKey);
			inv.invoke();
		}else {
			controller.renderText("禁止登陆!");
			return;
		}*/
		
		String sessionSearchKey = (String)request.getSession().getAttribute("searchKey");
		String searchKey = request.getParameter("searchKey");
		String md5 = NewMD5Util.MD5("TNDBBbLFD*m1");
		System.out.println(md5);
		System.out.println(request.getRequestURL());
		if (sessionSearchKey!=null && NewMD5Util.MD5("TNDBBbLFD*m1").equals(sessionSearchKey)) {
			return true;
		}else if (searchKey!=null && NewMD5Util.MD5("TNDBBbLFD*m1").equals(searchKey)){
			request.getSession().setAttribute("searchKey", searchKey);
			return true;
		}else {
			response.getWriter().print("禁止登陆!");
			return false;
		}
		
	}
}
