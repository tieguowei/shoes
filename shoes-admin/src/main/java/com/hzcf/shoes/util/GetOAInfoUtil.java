package com.hzcf.shoes.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

import com.alibaba.fastjson.JSON;
import com.hzcf.shoes.util.HttpUtil;

public class GetOAInfoUtil {

	private static String MD5Key = "8934e7d15453e97507ef794cf7b0519d";
	private static String OaUrl = "http://alc.zhonghuirt.com/personinfo/findPersion";
	
	public static void main(String[] args) {
		Map<String, Object> p = new HashMap<>();
		try {
			getOaInfo(p);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getOaInfo(Map<String, Object> p) throws UnsupportedEncodingException{
		
		Map<String, String> map = new HashMap<>();
		
		Map<String, Object> params = new HashMap<>();
		params.put("name", "刘芳");
		
		/*Map<String, Object> pageInfo = new HashMap<>();
		pageInfo.put("page", 1);
		pageInfo.put("pageSize", 2);
		params.put("pageInfo", pageInfo);*/
		
		/*Map<String, Object> operInfo = new HashMap<>();
		operInfo.put("operName", "测试人员");
		operInfo.put("operAccount", "mml");
		params.put("operInfo", operInfo);*/
		
		String sign = MD5(JSON.toJSONString(params) + "&key=" + MD5Key);
		String encode = URLEncoder.encode(JSON.toJSONString(params),"UTF-8");
		map.put("params", encode);
		map.put("sign", sign);
		String doPost = HttpUtil.doPost(OaUrl, map);
		return doPost;
	}
	
	/**
	 * md5 加密
	 * @param sourceStr
	 * @return
	 */
	public static String MD5(String sourceStr) {
        String result = "";
        try {
            result = DigestUtils.md5Hex(sourceStr);
        } catch (Exception e) {
            System.out.println(e);
        }
        result = result.toUpperCase();
        return result;
    }
}
