package com.hzcf.shoes.enmu;

public class UserConstants {

	public static final String  MOBILE_PATTERN = "0?1[3|4|5|7|8][0-9]\\d{8}";//手机号正则表达式
	public static final String  LOGIN_ERROR_TIMES = "LOGINERRORTIMES";//redis中存储用户连续错误登陆的次数前缀
	public static final String  USER_TOKEN = "USERTOKEN";//redis中存储用户token的前缀
	public static final int REDIS_TOKEN_DELAY = 60*60*24*30;//redis中存储token的时间(30天)
	public static final int REDIS_VERIFICATIONCODE_TIME = 5*60;//redis中存储短信验证码的时间(5分钟)
	public static final String GET_CODE_TIMES = "GETCODETIMES";//redis中存储用户获取验证码次数的前缀
	public static final String USER_VERIFICATIONCODE = "USERVERIFICATIONCODE";//redis中存储用户获取的验证码
	public static final String CHECK_USER_TOKEN = "CHECKUSERTOKEN";//redis中存储检查数据的用户token
	public static final int REDIS_CHECK_TOKEN_DELAY = 60*60*24*7;//redis中存储检查数据的用户token

}
