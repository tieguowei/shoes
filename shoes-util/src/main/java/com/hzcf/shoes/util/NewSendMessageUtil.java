package com.hzcf.shoes.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;

public class NewSendMessageUtil {		
	 
	/*public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<>();
		String systemSourceId = "shoes";
		String telephone = "13313440299";
		String message = "您的验证码是23540,请勿告诉他人。";
		String key = "278e60fc68fd967b106e7fd9f081ba8f";
		String sendmessage_path = "http://hzdispatch.p2phz.com:8080/app/dispatch/sendBill.do";
		map.put("systemSourceId", systemSourceId);
		map.put("telephone", telephone);
		map.put("message", message);
		map.put("key", key);
		map.put("sendmessage_path", sendmessage_path);
		boolean sendSmsProduct = new NewSendMessageUtil().sendSmsProduct(map);
		System.out.println(sendSmsProduct);
	}*/
	
	public static boolean sendSmsProduct(Map<String, String> map){
		 String bizId=new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date())+new Random().nextInt(10); 
				String systemSourceId = map.get("systemSourceId");
				String telephone = map.get("telephone");
				String message = map.get("message");
				String key = map.get("key");
				String sendmessage_path = map.get("sendmessage_path");
				try {
					//短信接口传递参数
					Map<String, Object> dataMap = new HashMap<String, Object>(); 
					dataMap.put("bizId", bizId);
					dataMap.put("sendType", "1");
					dataMap.put("systemSourceId", systemSourceId);
					
					List<Map<String, Object>> sendBillList = new ArrayList<Map<String, Object>>();
					Map<String, Object> dm = new HashMap<String, Object>();
					Map<String, Object> cont = new HashMap<String, Object>();
					cont.put("content", message);
					String jsonString = JSON.toJSONString(cont);
					//System.out.println(jsonString);
					dm.put("bizId", new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date())+new Random().nextInt(10));
					dm.put("addr", telephone);
					dm.put("content", jsonString);
					sendBillList.add(dm);
					
					dataMap.put("sendBillList", sendBillList);
					// 生成签名信息
					String signature = Md5Util2.getMD5String(StringUtils.join(new String[] { systemSourceId, bizId }, ","), key);
					dataMap.put("signature", signature);
					// 这里将map用json工具转换为json串
					String str = JSON.toJSONString(dataMap);
					//System.out.println("加密前,str=" + str);
					// 这一步对json串进行加密，便于传输
					
					//System.err.println(str);
					str = AESUtil.enCrypt(str, key);
				 
					String result = HttpRequestUtil.sendPost(sendmessage_path, "billParms="+str); 
					//System.out.println("接口返回信息:" + result);
					//System.out.println("接口调用完毕");
				}catch (Exception e) {
					e.printStackTrace(); 
					return false;
				}
				return true;
	}
	
	/*public void sendSms(Map<String, String> map){
		 String bizId=new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date())+new Random().nextInt(10); 
				String systemSourceId = "shoes";
				String telephone = "18513926332";
				String message = "您的验证码是23540 ";
				String key = "01b503cf15f16f5e9c95938d09ef1219";
				String sendmessage_path = "http://10.10.10.61:8080/Dispatch/app/dispatch/sendBill.do";
				try {
					//短信接口传递参数
					Map<String, Object> dataMap = new HashMap<String, Object>(); 
					dataMap.put("bizId", bizId);
					dataMap.put("sendType", "1");
					dataMap.put("systemSourceId", systemSourceId);
					
					List<Map<String, Object>> sendBillList = new ArrayList<Map<String, Object>>();
					Map<String, Object> dm = new HashMap<String, Object>();
					dm.put("bizId", bizId);
					dm.put("addr", telephone);
					dm.put("content", message);
					sendBillList.add(dm);
					
					dataMap.put("sendBillList", sendBillList);
					// 生成签名信息
					String signature = Md5Util2.getMD5String(StringUtils.join(new String[] { systemSourceId, bizId }, ","), key);
					dataMap.put("signature", signature);
					// 这里将map用json工具转换为json串
					String str = JSON.toJSONString(dataMap);
					//System.out.println("加密前,str=" + str);
					// 这一步对json串进行加密，便于传输
					str = AESUtil.enCrypt(str, key);
				 
					String result = HttpRequestUtil.sendPost(sendmessage_path, "billParms="+str); 
					System.out.println("接口返回信息:" + result);
					//System.out.println("接口调用完毕");
				}catch (Exception e) {
					e.printStackTrace(); 
				}
	}
	
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
	}*/
}
