package com.hzcf.shoes.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;

public class SendMessageUtil {		
	public static boolean sendMessage(Map<String, String> map) {
		// key这个写成死的
		String companyKey = map.get("companyKey");
		// 来源系统
		String systemSourceId = map.get("sendmessage_systemresource");
		String telephone = map.get("telephone");
		String message = map.get("message");
		String key = map.get("key");
		String sendmessage_path = map.get("sendmessage_path");
		try {
			//短信接口传递参数
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("mobile", telephone);
			dataMap.put("content", message);
			dataMap.put("sendTime","");//实时发送短信,时间设置为""
			dataMap.put("isVerify", 0);
			dataMap.put("companyKey", companyKey);
			dataMap.put("systemSourceId", systemSourceId);
			// 生成签名信息
			String signature = Md5Util2.getMD5String(StringUtils.join(new String[] { systemSourceId, telephone }, ","), key);
			dataMap.put("signature", signature);
			// 这里将map用json工具转换为json串
			String str = JSON.toJSONString(dataMap);
			//System.out.println("加密前,str=" + str);
			// 这一步对json串进行加密，便于传输
			str = AESUtil.enCrypt(str, key);
			//System.out.println("加密后,str=" + str);
			//System.out.println("地址:" + PropKit.get("sendmessage_path"));
			//System.out.println("系统来源：" + systemSourceId);
			//System.out.println("key:" + companyKey);
			//System.out.println("调用接口传输str:" + str);
			//String restult = HttpRequestUtil.sendPost(PropKit.get("PATH"), str);
			//System.out.println(str);
			//str="sendMsgParams="+str;
			//System.out.println(str);
			// 调用接口传参
			String result = HttpRequestUtil.sendPost(sendmessage_path, "sendMsgParams="+str);
			//String restult = HttpUtils.post(PropKit.get("sendmessage_path"), str);
			System.out.println("接口返回信息:" + result);
			//System.out.println("接口调用完毕");
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
