package com.hzcf.shoes.util;

import java.security.MessageDigest;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class MD5Util {
	
	private static final String encryModel="MD5";
	
	private static final String PRIVATE_KEY = "dafyonline9527"; //spring MD5加密私钥
	
	/**
     * 32位md5.
     * @param str
     * @return
     */
    public  static String md5(String str) {
        return encrypt(encryModel, str);
    }

    //得到加密后的字符
    public static String encrypt(String algorithm, String str) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(str.getBytes());
            StringBuffer sb = new StringBuffer();
            byte[] bytes = md.digest();
            for (int i = 0; i < bytes.length; i++) {
                int b = bytes[i] & 0xFF;
                if (b < 0x10) {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(b));
            }
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }
    
    /**
     * 
     * Description: MD5加密
     * @param str 
     * @return String
     * @Author leichunlai
     * @Create Date: 2013-3-1 上午10:28:01
     */
    public static String encrypt(String str){
    	Md5PasswordEncoder md5pe = new Md5PasswordEncoder();
    	if(StringUtil.isNotBlank(str)){
    		return md5pe.encodePassword(PRIVATE_KEY, str);
    	}
    	return null;
    }
    
    public static void main(String args[]){
    	
    	System.out.println(MD5Util.md5("123@abc"+"hzcf*)(bxdxa?a^%#)"));;
    	
//    	String merId = "6927";
//    	if (merId == null) return;
//
//    	String moneyType ="0";
//    
//    	
//    	String actionUrl="http://pay.beijing.com.cn/customer/gb/pay_bank.jsp";//取得支付提交地址  
//    	String returnUrl = "http://192.168.6.224:8080/dafei/WebRoot/payorder_back.jsp";//接收地址
//    	
//    	
//    	
//    	String thetime = "";
//    	java.text.DateFormat df = new SimpleDateFormat("yyyyMMdd");
//        java.util.Date date = new java.util.Date();   
//        thetime = df.format(date);
//    	
//    	String orderId=thetime+"-"+merId+"-"+123;
//    	String rcvName=merId;
//    		
//    		
//    	String payMoney="89.01";
//    		
//    	String	md5Src=moneyType+thetime+payMoney+rcvName+orderId+merId+returnUrl;
//    	String	md5Key = "test";
//   
//    	String md5Info = md5.MD5Digest(md5Src,md5Key);	
    	System.out.println(encrypt("111111"));
    }
}
