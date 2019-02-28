package com.hzcf.shoes.constant;

public class FinancingConstants {
	/**
	 * 融资 日指标 列表显示 F-融资  A/B/C/D-行数   FB4_1 融资第二行第四列的 第一个值
	 */

	// 融资 日指标 列表 计划达成率
	public static final String FA1 = "计划达成率";
	public static final String FA2 = "时间进度-计划达成率";
	public static final String FA3 = "时间进度-计划达成率>";
	public static final String FA4 = "≥时间进度-计划达成率≥";
	public static final String FA5 = "时间进度-计划达成率<";

	// 融资 日指标 列表 人均进件
	public static final String FB1 = "人均进件";
	public static final String FB2 = "日人均进件目标";
	public static final String FB3 = "X日人均进件<日人均进件目标*";
	public static final String FB4_1 = "日人均进件目标*";
	public static final String FB4_2 = "≤X日人均进件≤日人均进件目标*";
	public static final String FB5 = "X日人均进件>日人均进件目标*";

	// 融资 日指标 列表 批核率
	public static final String FC1 = "批核率";
	public static final String FC2 = "批核率";
	public static final String FC3_1 = "批核率<";
	public static final String FC3_2 = "or 批核率>";
	public static final String FC4_1 = "≤批核率<";
	public static final String FC4_2 = " or ";
	public static final String FC4_3 = "<批核率≤";
	public static final String FC5 = "≤批核率≤";

	// 融资 日指标 列表 批核件均
	public static final String FD1 = "批核件均";
	public static final String FD2 = "批核件均";
	public static final String FD3_1 = "批核件均<";
	public static final String FD3_2 = " or 批核件均";
	public static final String FD4_1 = "≤批核件均";
	public static final String FD4_2 = " or ";
	public static final String FD4_3 = "<批核件均≤";
	public static final String FD5 = "≤批核件均≤";

	/**
	 * 融资 月指标 列表显示
	 */

	// 融资 月指标 列表 计划达成率
	public static final String FE1 = "计划达成率";
	public static final String FE2 = "计划达成率";
	public static final String FE3 = "计划达成率<";
	public static final String FE4 = "≤计划达成率≤";
	public static final String FE5 = "计划达成率>";

	// 融资 月指标 列表 C-M1回款率
	public static final String FF1 = "C-M1回款率";
	public static final String FF2 = "C-M1回款率";
	public static final String FF3 = "C-M1回款率<";
	public static final String FF4 = "≤C-M1回款率≤";
	public static final String FF5 = "C-M1回款率>";

	// 融资 月指标 列表 年化新增损失率
	public static final String FG1 = "年化新增损失率";
	public static final String FG2 = "年化新增损失率";
	public static final String FG3 = "年化新增损失率>";
	public static final String FG4 = "≤年化新增损失率≤";
	public static final String FG5 = "年化新增损失率<";

	// 融资 月指标 列表 全员人均产能
	public static final String FH1 = "全员人均产能";
	public static final String FH2 = "全员人均产能";
	public static final String FH3 = "全员人均产能<";
	public static final String FH4 = "≤全员人均产能≤";
	public static final String FH5 = "全员人均产能>";

	// 融资 月指标 列表 咨询师人均产能
	public static final String FI1 = "咨询师人均产能";
	public static final String FI2 = "咨询师人均产能";
	public static final String FI3 = "咨询师人均产能>";
	public static final String FI4 = "≤咨询师人均产能≤";
	public static final String FI5 = "咨询师人均产能>";

	// 融资 月指标 列表 批核率
	public static final String FJ1 = "批核率";
	public static final String FJ2 = "批核率";
	public static final String FJ3_1 = "批核率";
	public static final String FJ3_2 = "or 批核率>";
	public static final String FJ4_1 = "批核率";
	public static final String FJ4_2 = " or ";
	public static final String FJ4_3 = "<批核率≤";
	public static final String FJ5 = "≤批核率≤";

	// 融资 月指标 列表 批核件均
	public static final String FK1 = "批核件均";
	public static final String FK2 = "批核件均";
	public static final String FK3_1 = "批核件均";
	public static final String FK3_2 = " or 批核件均>";
	public static final String FK4_1 = "≤批核件均<";
	public static final String FK4_2 = " or ";
	public static final String FK4_3 = "<批核件均≤";
	public static final String FK5 = "≤批核件均≤";

	/**
	 * 融资 融资日指标 修改页面 R1/R2/R3-行数   R-红线 Y-黄线 B-绿线   R1_Y1-第一行黄色规则第一个值
	 */
	// 融资 融资日指标 计划达成率 公式
	public static final String R1_R = "红线：时间进度-计划达成率>";
	public static final String R1_Y1 = "黄线：";
	public static final String R1_Y2 = "≥时间进度-计划达成率≥";
	public static final String R1_B = "绿线:时间进度-计划达成率<";

	// 融资 融资日指标 人均进件 公式
	public static final String R2_R = "红线：X日人均进件<日人均进件目标*";
	public static final String R2_Y1 = "黄线:日人均进件目标*";
	public static final String R2_Y2 = "≤X日人均进件≤日人均进件目标*";
	public static final String R2_B = "绿线:X日人均进件>日人均进件目标*";
	
	// 融资 融资日指标 批核率 公式
	public static final String R3_R1 = "红线：批核率<";
	public static final String R3_R2 = "or 批核率>";
	public static final String R3_Y1 = "黄线:";
	public static final String R3_Y2 = "≤批核率<";
	public static final String R3_Y3 = " or ";
	public static final String R3_Y4 = "<批核率≤";
	public static final String R3_B1 = "绿线:";
	public static final String R3_B2 = "≤批核率≤";

	// 融资 融资日指标 批核件均 公式
	public static final String R4_R1 = "红线：批核件均<";
	public static final String R4_R2 = " or 批核件均>";
	public static final String R4_Y1 = "黄线:";
	public static final String R4_Y2 = "≤批核件均<";
	public static final String R4_Y3 = " or ";
	public static final String R4_Y4= "<批核件均≤";
	public static final String R4_B1 = "绿线:";
	public static final String R4_B2 = "≤批核件均≤";

	/**
	 * 融资 融资月指标 修改页面
	 */
	// 理财 理财月指标 计划达成率公式
	public static final String R5_R = "红线：计划达成率<";
	public static final String R5_Y1 = "黄线：";
	public static final String R5_Y2 = "≤计划达成率≤";
	public static final String R5_B = "绿线:计划达成率>";
	// 理财 理财月指标 C-M1回款率 公式
	public static final String R6_R = "红线：C-M1回款率<";
	public static final String R6_Y1 = "黄线：";
	public static final String R6_Y2 = "≤C-M1回款率≤";
	public static final String R6_B = "绿线:C-M1回款率>";
	// 理财 理财月指标 年化新增损失率 公式
	public static final String R7_R = "红线：年化新增损失率>";
	public static final String R7_Y1 = "黄线：";
	public static final String R7_Y2 = "≤年化新增损失率≤";
	public static final String R7_B = "绿线:年化新增损失率<";
	// 理财 理财月指标 全员人均产能 公式
	public static final String R8_R = "红线：全员人均产能<";
	public static final String R8_Y1 = "黄线：";
	public static final String R8_Y2 = "≤全员人均产能≤";
	public static final String R8_B = "绿线:全员人均产能>";
	// 理财 理财月指标 咨询师人均产能 公式
	public static final String R9_R = "红线：咨询师人均产能>";
	public static final String R9_Y1 = "黄线：";
	public static final String R9_Y2 = "≤咨询师人均产能≤";
	public static final String R9_B = "绿线:咨询师人均产能>";
	
	// 融资 融资月指标 批核率 公式
	public static final String R10_R1 = "红线：批核率<";
	public static final String R10_R2 = "or 批核率>";
	public static final String R10_Y1 = "黄线:";
	public static final String R10_Y2 = "≤批核率<";
	public static final String R10_Y3 = " or ";
	public static final String R10_Y4 = "<批核率≤";
	public static final String R10_B1 = "绿线:";
	public static final String R10_B2 = "≤批核率≤";

	// 融资 融资月指标 批核件均 公式
	public static final String R11_R1 = "红线：批核件均<";
	public static final String R11_R2 = " or 批核件均>";
	public static final String R11_Y1 = "黄线:";
	public static final String R11_Y2 = "≤批核件均<";
	public static final String R11_Y3 = " or ";
	public static final String R11_Y4 = "<批核件均≤";
	public static final String R11_B1 = "绿线:";
	public static final String R11_B2 = "≤批核件均≤";

}
