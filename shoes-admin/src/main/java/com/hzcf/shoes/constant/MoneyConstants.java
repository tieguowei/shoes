package com.hzcf.shoes.constant;

public class MoneyConstants {

	/**
	 * 理财 日指标 列表显示 M-理财 A/B/C/D-行数   MA4_1 理财第一行第四列的 第一个值
	 */
	
	//理财 日指标 列表 日业绩
	public static final String MA1="日业绩";
	public static final String MA2="X日业绩（即t-1日）";
	public static final String MA3="日业绩<日计划规模业绩*";
	public static final String MA4_1="日计划规模业绩*";
	public static final String MA4_2="≤日业绩<日计划规模业绩*";
	public static final String MA5="日业绩≥日计划规模业绩*";
	
	//理财 日指标 列表 累计达成率
	public static final String MB1 = "累计达成率";
	public static final String MB2 = "X月累计达成率";
	public static final String MB3 = "X月累计达成率<当前时间进度*";
	public static final String MB4_1 = "当前时间进度*";
	public static final String MB4_2 = "≤累计达成率<当前时间进度*";
	public static final String MB5 = "累计达成率≥当前时间进度*";
	
	//理财 日指标 列表 计划达成率
	public static final String MC1 = "计划达成率";
	public static final String MC2 = "计划达成率";
	public static final String MC3 = "达成率<";
	public static final String MC4 = "≤达成率<";
	public static final String MC5 = "达成率≥";
	
	/**
	 * 理财 理财日指标 修改页面 R1/R2/R3-行数   R-红线 Y-黄线 B-绿线   R1_Y1-第一行黄色规则第一个值
	 */
	// 理财 理财日指标 日业绩 公式
	public static final String R1_R = "红线：日业绩<日计划规模业绩*";
	public static final String R1_Y1 = "黄线:日计划规模业绩*";
	public static final String R1_Y2 = "<=日业绩<日计划规模业绩*";
	public static final String R1_B = "绿线:日业绩≥日计划规模业绩*";

	// 理财 理财日指标 累计达成率公式
	public static final String R2_R = "红线：累计业绩<月计划*当前时间进度*";
	public static final String R2_Y1 = "黄线:月计划*当前时间进度*";
	public static final String R2_Y2 = "累计业绩<月计划*当前时间进度*";
	public static final String R2_B = "绿线:累计业绩≥月计划*当前时间进度*";
	
	/**
	 * 理财 理财月指标 修改页面
	 */
	// 理财 理财月指标 计划达成率公式
	public static final String R3_R = "红线：达成率<";
	public static final String R3_Y1 = "黄线:";
	public static final String R3_Y2= "≤达成率<";
	public static final String R3_B = "绿线:达成率≥";

}
