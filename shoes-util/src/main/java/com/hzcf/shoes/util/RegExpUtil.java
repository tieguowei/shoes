package com.hzcf.shoes.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 *
 * Description:正则表达式工具类
 *
 * @author yubin
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2012-9-12    Administrator       1.0        1.0 Version 
 * </pre>
 */
public class RegExpUtil {
	
	/** Email表达式 */
	//private static final String EXP_EMAIL = "[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+";
	private static final String EXP_EMAIL = "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";
	
	/** 正整数表达式 */
	private static final String EXP_POSITIVE_INTEGER = "^\\d+$";
	
	/** 整数 */
	private static final String EXP_INTEGER = "^-?\\d+$";

	/** 金钱 */
	private static final String EXP_MONTY = "^\\d+(\\.\\d{0,2})?$";

	/** 非负浮点数*/
	private static final String EXP_NOT_NEGATIVE_FLOAT = "^\\d+(\\.\\d+)?$";
	
	/** 正浮点数 */
	private static final String EXP_POSITIVE_FLOAT = "^((\\[0-9\\]+\\.\\[0-9\\]*\\[1-9\\]\\[0-9\\]*)\\|(\\[0-9\\]*\\[1-9\\]\\[0-9\\]*\\.\\[0-9\\]+)\\|(\\[0-9\\]*\\[1-9\\]\\[0-9\\]*))$";
	
	/** 由26个英文字母组成的字符串 */
	private static final String EXP_ENGLIS_CHAR_STRING = "^\\[A-Za-z\\]+$";
	
	/** 由26个英文字母的大写组成的字符串 */
	private static final String EXP_ENGLIS_UPPER_CHAR_STRING = "^\\[A-Z\\]+$";
	
	/**由26个英文字母的小写组成的字符串*/
	private static final String EXP_ENGLIS_LOWER_CHAR_STRING = "^\\[a-z\\]+$";
	
	/**由数字和26个英文字母组成的字符串*/
	private static final String EXP_NUMBER_AND_EN_STRING = "^\\[A-Za-z0-9\\]+$";
	
	/**由数字、26个英文字母或者下划线组成的字符串*/
	private static final String EXP_COMMON_EN_STRING = "^\\w+$";
	
	/**手机号*/
	private static final String EXP_MOBILE = "^0?1[3|4|5|7|8][0-9]\\d{8}$";
	
	private static boolean isRight(String input, String regExp) {
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(input);
		return matcher.find();
	}
	
	/**
	 * 邮箱校验
	 * @param input
	 * @return
	 */
	public static boolean isEmail(String input) {
		return isRight(input, EXP_EMAIL);
	}
	
	/**
	 * 正整数校验
	 * @param input
	 * @return
	 */
	public static boolean isPositiveInteger(String input) {
		return isRight(input, EXP_POSITIVE_INTEGER);
	}
	
	/**
	 * 整数校验
	 * @param input
	 * @return
	 */
	public static boolean isInteger(String input) {
		return isRight(input, EXP_INTEGER);
	}

	/**
	 * 金钱校验<br/>
	 * RegExpUtil.isMoney("2.00")      = true<br/>
	 * RegExpUtil.isMoney("2.")        = true<br/>
	 * RegExpUtil.isMoney("2.000")     = false<br/>
	 * RegExpUtil.isMoney("2,222")     = false<br/>
	 * @param input
	 * @return
	 */
	public static boolean isMoney(String input) {
		return isRight(input, EXP_MONTY);
	}

	/**
	 * 非负浮点数校验
	 * @param input
	 * @return
	 */
	public static boolean isNotNegativeFloat(String input) {
		return isRight(input, EXP_NOT_NEGATIVE_FLOAT);
	}
	
	/**
	 * 正浮点数校验
	 * @param input
	 * @return
	 */
	public static boolean isPositiveFloat(String input) {
		return isRight(input, EXP_POSITIVE_FLOAT);
	} 
	
	/**
	 * 校验 由26个英文字母组成的字符串
	 * @param input
	 * @return
	 */
	public static boolean isEnglisCharString(String input) {
		return isRight(input, EXP_ENGLIS_CHAR_STRING);
	}
	
	/**
	 * 校验 由26个大写英文字母组成的字符串
	 * @param input
	 * @return
	 */
	public static boolean isEnglisUpperCharString(String input) {
		return isRight(input, EXP_ENGLIS_UPPER_CHAR_STRING);
	}
	
	/**
	 * 校验 由26个小写英文字母组成的字符串
	 * @param input
	 * @return
	 */
	public static boolean isEnglisLowerCharString(String input) {
		return isRight(input, EXP_ENGLIS_LOWER_CHAR_STRING);
	}

	/**
	 * 校验 由数字和26个英文字母组成的字符串
	 * @param input
	 * @return
	 */
	public static boolean isNumberAndEnString(String input) {
		return isRight(input, EXP_NUMBER_AND_EN_STRING);
	}

	/**
	 * 校验 由数字、26个英文字母或者下划线组成的字符串
	 * @param input
	 * @return
	 */
	public static boolean isCommonEnString(String input) {
		return isRight(input, EXP_COMMON_EN_STRING);
	}
	
	/**
	 * 校验 手机号码
	 * @param input
	 * @return
	 */
	public static boolean isMobile(String input){
		return isRight(input, EXP_MOBILE);
	}
	
	public static void main(String[] args) {
		System.out.println(isEmail("12@a.com"));
	}
	
	/**
	 * 验证是否为小数或整数
	 * 
	 * @param value
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkIsDecimalsOrInt(String value) {
		String regex = "^[+-]?\\d+(\\.\\d+)?$";
		return value.matches(regex);
	}

	/**
	 * 验证是否为整数
	 * 
	 * @param value
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkIsInt(String value) {
		String regex = "^[0-9]*$";
		return value.matches(regex);
	}

	/**
	 * 验证时间格式 及 数值
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkIsDate(String value) {
		String regex = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(value);
		return m.matches();
	}
	
	/**
	 * 验证 ID card
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkIdCard(String value) {
		String regex = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
		return value.matches(regex);
	}
}
