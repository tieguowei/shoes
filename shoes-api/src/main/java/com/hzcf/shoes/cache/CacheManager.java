package com.hzcf.shoes.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.util.ResourceUtils;

import com.hzcf.shoes.util.FileUtil;
import com.hzcf.shoes.util.XmlUtil;


/**
 * 内存管理
 * 
 */

public class CacheManager implements ApplicationListener<ContextRefreshedEvent>{

	private static Logger log = LoggerFactory.getLogger(CacheManager.class); 

	private static String generalFilePath = "classpath:GeneralConfig.xml";
	private static Map<String,String> generalCache = new HashMap<String,String>();

	private void init(){
		//加载GeneralConfig.xml
		loadGeneralConfig();
	}

	/**
	 * 加载 参数配置文件GeneralConfig.xml 文件
	 */
	private static void loadGeneralConfig(){
		try {
			String generalPath = ResourceUtils.getFile(generalFilePath).getPath();
			String xml = FileUtil.readFileByLines(generalPath);
			XmlUtil xmlObj = new XmlUtil(xml);
			List<Element> errorlist = xmlObj.findAllElements();
			for(Element el : errorlist){
				String name = el.getName();
				String msg = el.getText();
				log.info("name:"+name+";msg:"+msg);
				generalCache.put(name, msg);
			}
		} catch (Exception e) {
			log.error("", e);
		}
	}

	public static String getGeneralText(String nodeName){
		String nodeText = null;
		if(generalCache.size() > 0){
			nodeText = generalCache.get(nodeName);
		}else{
			loadGeneralConfig();
			nodeText = generalCache.get(nodeName);
		}
		return nodeText;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		init();
	}


}
