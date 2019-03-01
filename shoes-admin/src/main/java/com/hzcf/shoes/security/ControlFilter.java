package com.hzcf.shoes.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.hzcf.shoes.constant.Constants;
import com.hzcf.shoes.service.ControlService;

public class ControlFilter implements Filter{

	@Autowired
	private ControlService controlService; 

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest _request = (HttpServletRequest)request;
		HttpServletResponse _response = (HttpServletResponse)response;
		HttpSession session = _request.getSession(false);
		if(null != session){
			Object o = session.getAttribute(Constants.CTRL_NAME);
			if(null == o){
				session.setAttribute(Constants.CTRL_NAME, controlService.findRoleByCtrl());
			}
		}
		chain.doFilter(_request, _response);
	}

	public void init(FilterConfig arg0) throws ServletException {}

	public void destroy() {}
}
