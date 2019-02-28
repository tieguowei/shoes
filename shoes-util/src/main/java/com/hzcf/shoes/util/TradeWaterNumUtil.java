package com.hzcf.shoes.util;

import java.util.Random;

/** 
 *
 * Description: 生成交易流水号
 *
 * @author lijie
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2015年1月15日      lijie       1.0         1.0 Version 
 * </pre>
 */

public class TradeWaterNumUtil {
	
	/**
	 * 
	 * Description: 生成交易流水号  
	 * 			格式：例    交易类型编码-100034000-566034000-平台唯一编码
	 *
	 * @param TradeType 交易类型编码
	 * @param busPlatform 平台唯一编码
	 * @return String 返回交易流水号
	 * @Author lijie
	 * @Create Date: 2015年1月16日 上午10:05:00
	 */
	public static String genTradeWaterNum(TradeTypesEnum TradeType, String busPlatform){
		
		StringBuffer sb = new StringBuffer();

		if (StringUtil.isNotBlank(TradeType.name()) && StringUtil.isNotBlank(busPlatform)) {
			sb.append(TradeType)
			  .append("-")
			  .append(getRandom())
			  .append("-")
			  .append(getRandom())
			  .append("-")
			  .append(busPlatform);
		}

		return sb.toString();
	}
	
	/**
	 * 
	 * Description: 生成100000000到999999999之间的随机数
	 *
	 * @param 
	 * @return int
	 * @throws 
	 * @Author yaodawei
	 * Create Date: 2015年1月22日 下午2:23:14
	 */
	private static int getRandom(){
		int max = 999999999;
        int min = 100000000;
        Random random = new Random();
        int randomInt = random.nextInt(max)%(max-min+1) + min;
        return randomInt;
	}
	
	public static void main(String[] args) {
//		System.out.println(genTradeWaterNum(TradeTypesEnum.LCHB, PlatformCodeConstants.ONLINE_PLATFORM_CODE));
		
	}
}
