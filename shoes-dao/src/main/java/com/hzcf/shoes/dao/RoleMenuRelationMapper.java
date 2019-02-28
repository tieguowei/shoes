package com.hzcf.shoes.dao;

import com.hzcf.shoes.model.RoleMenuRelation;

public interface RoleMenuRelationMapper extends BaseMapper<RoleMenuRelation>{
    
	/**
	 * 
	 * Description: 根据菜单id删除该菜单相关的角色信息
	 *
	 * @param 
	 * @return int
	 * @throws 
	 * @Author ydw
	 * Create Date: 2014-12-10 上午11:17:25
	 */
    public int deleteMenuRoleRelationByMenuId(Integer menuId);
}