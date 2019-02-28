package com.hzcf.shoes.enmu;

import java.io.File;

public class TemplateConstants {

	//文件上传文件夹
	public static final String UPLOAD=File.separator+"upload";
	//文件下载文件夹
	public static final String DOWNLOAD=File.separator+"download";
	
	//理财人力花名册 导入 是否转正字段  1:已转正,0:未转正
	
	public static final String YES = "是";
	public static final String YESISONE="1";
	public static final String NO = "否";
	public static final String NOISZERO="0";
	
	//理财业绩排除表  排除类型字段 1:客户经理营业部,2:投资产品,3:投资状态
	public static final String 	SALESDEPARTMENT  = "客户经理营业部";
	public static final String 	SALESDEPARTMENTONE  = "1";
	public static final String INVESTMENTPRODUCT = "投资产品";
	public static final String INVESTMENTPRODUCTTWO = "2";
	public static final String INVESTMENTSTATE = "投资状态";
	public static final String INVESTMENTSTATETHREE = "3";
	
	//验证上传文件名 错误提示信息
	public static final String FILENAMEERRORMESSAGE = "上传信息不符！请检查！";
	//上传文件内容错误提示信息
	public static final String CONTENTERRORMESSAGE = "行数据格式错误，上传失败";
	//系统错误提示信息
	public static final String SYSTEMERRORMESSAGE = "系统异常！";
	//数据库报唯一索引异常提示信息
	public static final String DUPLICATE_KEY_EXCEPTION_MESSAGE = "%s 字段重复！重复值为：%s！";

	//理财/融资指标表  M-理财 1-对应数据库第一个值
	public static final String M1 = "moneyMgr_daily_perform_warning";//理财日业绩警戒线(红黄中间值)比例
	public static final String M2 = "moneyMgr_daily_perform_well";////理财日业绩良好线(黄绿中间值)比例
	public static final String M3 = "moneyMgr_daily_accumu_warning";//理财当月累计业绩警戒线(红黄中间值)比例
	public static final String M4 = "moneyMgr_daily_accumu_well";//理财当月累计业绩良好线(黄绿中间值)比例
	public static final String M5 = "moneyMgr_month_perform_warning";//理财月达成率警戒线(红黄中间值)比例
	public static final String M6 = "moneyMgr_month_perform_well";//理财月达成率良好线(黄绿中间值)比例
   //融资/融资指标表 F-理财 1-对应数据库融资的第一个值
	public static final String F1 = "financeMgr_daily_planYieldRate_warning";//融资日指标计划达成率警戒线(红黄中间值)比例
	public static final String F2 = "financeMgr_daily_planYieldRate_well";//融资日指标计划达成率良好线(黄绿中间值)比例
	public static final String F3 = "financeMgr_daily_perCapitaEntry_warning";//融资日指标人均进件警戒线(红黄中间值)比例
	public static final String F4 = "financeMgr_daily_perCapitaEntry_well";//融资日指标人均进件良好线(黄绿中间值)比例
	public static final String F5 = "financeMgr_daily_approvalRate_one";//融资日指标批核率第一个比例
	public static final String F6 = "financeMgr_daily_approvalRate_two";//融资日指标批核率第二个比例
	public static final String F7 = "financeMgr_daily_approvalRate_three";//融资日指标批核率第三个比例
	public static final String F8 = "financeMgr_daily_approvalRate_four";//融资日指标批核率第四个比例
	public static final String F9 = "financeMgr_daily_batchParts_one";//融资日指标批核件均第一个值（万）
	public static final String F10 = "financeMgr_daily_batchParts_two";//融资日指标批核件均第二个值（万）
	public static final String F11 = "financeMgr_daily_batchParts_three";//融资日指标批核件均第三个值（万）
	public static final String F12= "financeMgr_daily_batchParts_four";//融资日指标批核件均第四个值（万）
	
	public static final String F13 = "financeMgr_month_planYieldRate_warning";//融资月指标计划达成率警戒线(红黄中间值)比例
	public static final String F14 = "financeMgr_month_planYieldRate_well";//融资月指标计划达成率良好线(黄绿中间值)比例
	public static final String F15 = "financeMgr_month_CM1Rate_warning";//融资月指标C-M1回款率警戒线(红黄中间值)比例
	public static final String F16 = "financeMgr_month_CM1Rate_well";//融资月指标C-M1回款率良好线(黄绿中间值)比例
	public static final String F17 = "financeMgr_month_lossRate_warning";//融资月指标年化新增损失率警戒线(红黄中间值)比例
	public static final String F18 = "financeMgr_month_lossRate_well";//融资月指标年化新增损失率良好线(黄绿中间值)比例
	public static final String F19 = "financeMgr_month_totalAvg_warning";//融资月指标全员人均产能警戒线(红黄中间值)
	public static final String F20 = "financeMgr_month_totalAvg_well";//融资月指标全员人均产能良好线(黄绿中间值)
	public static final String F21 ="financeMgr_month_consultantsAvg_warning";//融资月指标咨询师人均产能警戒线(红黄中间值)
	public static final String F22 ="financeMgr_month_consultantsAvg_well";//融资月指标咨询师人均产能良好线(黄绿中间值)
	public static final String F23 ="financeMgr_monthapprovalRate_one";//融资月指标批核率第一个比例
	public static final String F24 ="financeMgr_month_approvalRate_two";//融资月指标批核率第二个比例
	public static final String F25 ="financeMgr_month_approvalRate_three";//融资月指标批核率第三个比例
	public static final String F26 ="financeMgr_month_approvalRate_four";//融资月指标批核率第四个比例
	public static final String F27 ="financeMgr_month_batchParts_one";//融资月指标批核件均第一个值（万）
	public static final String F28 ="financeMgr_month_batchParts_two";//融资月指标批核件均第二个值（万）
	public static final String F29 ="financeMgr_month_batchParts_three";//融资月指标批核件均第三个值（万）
	public static final String F30 ="financeMgr_month_batchParts_four";//融资月指标批核件均第四个值（万）
	
	public static final String F31 ="financeMgr_month_CM1Rate_minValue";//融资月指标C-M1回款率最小值 	
	public static final String F32 ="financeMgr_month_lossRate_maxValue";//融资月指标年化新增损失率最大值
	
	//融资月业绩表 排序code
	public static final String SERVIRATE="service_charge_rate";//服务费比例 
	public static final String ARBITRATIONRATE ="arbitration_charge_rate";//仲裁费比例
	public static final String INSURANCERATE ="insurance_rate";//意外险比例


	/**
	 * 文件上传-成功
	 */
	public static final int UPLOAD_SUCCESS = 0;
	/**
	 * 文件上传-失败
	 */
	public static final int UPLOAD_FAILURE = 1;

}
