package com.hzcf.shoes.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;


/**
 * 解析xml字符串
 * @author bhj
 *
 */
public class XmlUtil {

	private static final Logger log = LoggerFactory.getLogger(XmlUtil.class);

	private Document doc = null;

	public XmlUtil(String xmlStr) {
		try {
			this.doc = DocumentHelper.parseText(xmlStr);
		} catch (Exception e) {
			log.error("", e);
		}
	}

	public XmlUtil(InputStream xml) {
		SAXReader reader = new SAXReader();
		try {
			this.doc = reader.read(xml);
		} catch (DocumentException e) {
			log.error("", e);
		}
	}


	public Element getRootElement(){
		return this.doc.getRootElement();
	}

	/**
	 * 获取根节点下的所有子节点
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Element> findAllElements(){
		List<Element> elements = getRootElement().elements();
		return elements;
	}


	/**
	 * xml 转  json 对象
	 * @param xmlStr
	 * @return
	 * @throws DocumentException
	 */
	public String Dom2Json(){ 
		Map<String, Object> map = new HashMap<String, Object>(); 
		Element root = doc.getRootElement(); 
		for (Iterator iterator = root.elementIterator(); iterator.hasNext();) { 
			Element e = (Element) iterator.next(); 
			List list = e.elements(); 
			if(list.size() > 0){ 
				map.put(e.getName(), Dom2Map(e)); 
			}else 
				map.put(e.getName(), e.getText()); 
		} 
		return JSON.toJSONString(map); 
	} 
	
	@SuppressWarnings("unchecked")
	private Map Dom2Map(Element e){ 
		Map map = new HashMap(); 
		List list = e.elements(); 
		if(list.size() > 0){ 
			for (int i = 0;i < list.size(); i++) { 
				Element iter = (Element) list.get(i); 
				List mapList = new ArrayList(); 

				if(iter.elements().size() > 0){ 
					Map m = Dom2Map(iter); 
					if(map.get(iter.getName()) != null){ 
						Object obj = map.get(iter.getName()); 
						if(!obj.getClass().getName().equals("java.util.ArrayList")){ 
							mapList = new ArrayList(); 
							mapList.add(obj); 
							mapList.add(m); 
						} 
						if(obj.getClass().getName().equals("java.util.ArrayList")){ 
							mapList = (List) obj; 
							mapList.add(m); 
						} 
						map.put(iter.getName(), mapList); 
					}else 
						map.put(iter.getName(), m); 
				} 
				else{ 
					if(map.get(iter.getName()) != null){ 
						Object obj = map.get(iter.getName()); 
						if(!obj.getClass().getName().equals("java.util.ArrayList")){ 
							mapList = new ArrayList(); 
							mapList.add(obj); 
							mapList.add(iter.getText()); 
						} 
						if(obj.getClass().getName().equals("java.util.ArrayList")){ 
							mapList = (List) obj; 
							mapList.add(iter.getText()); 
						} 
						map.put(iter.getName(), mapList); 
					}else 
						map.put(iter.getName(), iter.getText()); 
				} 
			} 
		}else 
			map.put(e.getName(), e.getText()); 
		return map; 
	} 

	public String toString(){
		if(this.doc == null){
			return null;
		}
		return this.doc.asXML();
	}



}
