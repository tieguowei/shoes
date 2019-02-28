/* 
 * Copyright (C) 2011-2013 亿谱汇财富投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: Constants.java 
 *
 * Created: [2014-1-7 下午01:15:47] by yaodawei 
 *
 * $Id$
 * 
 * $Revision$
 *
 * $Author$
 *
 * $Date$
 *
 * ============================================================ 
 * 
 * ProjectName: crm
 * 
 * Description: 
 * 
 * ==========================================================*/

package com.hzcf.shoes.constant;

/** 
 *
 * Description: 系统常量
 *
 * @author yaodawei
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-1-7    yaodawei       1.0        1.0 Version 
 * </pre>
 */
public class Constants {
	
	public static final int PAGE_SIZE = 10;
	
	public static final String SYSTEM_USER = "SystemUser";//后台管理系统登录用户session的key值
	
	public static final String WORK_DEPT_IDS = "workDeptIds";//当前登录人拥有的数据权限
	
	public static final String SYSTEM_USER_ROLES = "SystemUserRoles";//当前登录人拥有的角色
	
	public static final String UPLOAD_FILE_TYPE = "*.pdf;*.jpg;*.png;*.jpeg;*.gif;*.tif;*.TIF;*.tiff;*.TIFF;*.PDF;*.JPG;*.PNG;*.JPEG;*.GIF;*.rar;*.RAR;*.zip;*.ZIP;*.txt;*.doc;*.docx;*.xls;*.xlsx;";//上传的文件类型
	
	public static final String CHECK_CODE ="check_code";//验证码key值
	
	public static final String CTRL_NAME = "ctrl"; //按钮权限key值
	
	public static final String ACTIVATED_STATE_DISABLE = "0";//员工用户使用状态：0:停用
	
	public static final String ACTIVATED_STATE_ENABLED = "1";//员工用户使用状态：1:启用
	
}