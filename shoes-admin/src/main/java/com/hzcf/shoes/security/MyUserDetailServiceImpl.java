
package com.hzcf.shoes.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hzcf.shoes.dao.EmployeeMapper;
import com.hzcf.shoes.dao.MenuMapper;
import com.hzcf.shoes.dao.RoleMapper;
import com.hzcf.shoes.model.Employee;
import com.hzcf.shoes.model.Menu;
import com.hzcf.shoes.model.Role;
import com.hzcf.shoes.util.log.LogDefault;


public class MyUserDetailServiceImpl implements UserDetailsService {
	
	private Logger logger = LogDefault.getLogger(getClass());
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private RoleMapper roleMapper; 
	
	@Autowired
	private MenuMapper menuMapper;
	
	//登录验证
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = null;
		employee = employeeMapper.findByUsername(username);
		if(employee == null){  
			throw new UsernameNotFoundException("用户名"+username+"不存在");  
	    }  
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(employee);
		boolean enables = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		//封装成spring security的user
		User userdetail = new User(username, employee.getPassword(), enables, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);
		return userdetail;
	}
	
	//取得用户的权限
	@SuppressWarnings("deprecation")
	private Set<GrantedAuthority> obtionGrantedAuthorities(Employee employee) {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		List<Menu> menus = new ArrayList<Menu>();
		try {
			List<Role> roles = roleMapper.findRoleByUserId(employee.getEmployeeId());
			StringBuffer roleCodes = new StringBuffer();
			StringBuffer menuUrls = new StringBuffer();
			List<Integer> menuIdList = new ArrayList<Integer>();
			for(Role role : roles) {
				roleCodes.append(role.getRoleCode());
				roleCodes.append(",");
				menus.addAll(menuMapper.findMenuByRoleId(role.getRoleId()));
				authSet.add(new SimpleGrantedAuthority(role.getRoleCode()));
			}
			for(Menu menu : menus) {
				authSet.add(new SimpleGrantedAuthority(menu.getNameEn()));
				menuIdList.add(menu.getMenuId());
				menuUrls.append(menu.getMenuUrl());
				menuUrls.append(",");
			}
			logger.info("用户名：" + employee.getEmail());
			logger.info("用户角色：" + roleCodes.toString());
			logger.info("用户权限：" + menuUrls.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return authSet;
	}
}

