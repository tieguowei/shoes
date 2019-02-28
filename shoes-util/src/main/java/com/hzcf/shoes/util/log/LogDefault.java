package com.hzcf.shoes.util.log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
/**
 * 
 *
 * Description: 
 *
 * @author yaodawei
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-1-7    yaodawei       1.0        1.0 Version 
 * </pre>
 */
public class LogDefault extends Logger {
	
	public static final boolean ENABLE_PRINT_EXCEPTION = true;//开启打印异常的标识
	
	private Logger log;
	
	/**
	 * 
	 * Description: log初始化
	 *
	 * @param 
	 * @return void
	 * @throws 
	 * @Author yaodawei
	 * Create Date: 2014-1-7 下午03:37:32
	 */
	private static void initLog() {
		String s = "/log4j.properties";
		InputStream inputstream = null;
		try
		{
			Properties properties = new Properties();
			inputstream = LogDefault.class.getResourceAsStream(s);
			properties.load(inputstream);
			PropertyConfigurator.configure(properties);
			properties.clear();
		}catch (Exception exception){
			exception.printStackTrace();
		}finally{
			if(inputstream != null){
				try {
					inputstream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 
	 * Description: 获取Logger对象
	 *
	 * @param s 
	 * @return Logger
	 * @throws 
	 * @Author yaodawei
	 * Create Date: 2014-1-7 下午03:37:47
	 */
	public static Logger getLogger(String s) {
		return new LogDefault(s);
	}
	
	/**
	 * 
	 * Description: 获取Logger对象
	 *
	 * @param class1 
	 * @return Logger
	 * @throws 
	 * @Author yaodawei
	 * Create Date: 2014-1-7 下午03:38:06
	 */
	@SuppressWarnings("unchecked")
	public static Logger getLogger(Class class1) {
		return new LogDefault(class1);
	}
	
	public LogDefault(String s) {
		super(s);
		log = null;
		log = Logger.getLogger(s);
	}
	
	public LogDefault(Class class1) {
		super(class1.toString());
		log = null;
		log = Logger.getLogger(class1);
	}
	
	/**
	 * @param obj 
	 * @return 
	 */
	public void info(Object obj) {
		log.info(obj);
		performException(obj);
	}
	
	/**
	 * @param obj 
	 * @return 
	 */
	public void debug(Object obj) {
		log.debug(obj);
		performException(obj);
	}
	
	/**
	 * @param obj 
	 * @return 
	 */
	public void error(Object obj) {
		log.error(obj);
		performException(obj);
	}
	
	/**
	 * @param obj 
	 * @return 
	 */
	public void fatal(Object obj) {
		log.fatal(obj);
		performException(obj);
	}
	
	/**
	 * @param obj 
	 * @return 
	 */
	public void warn(Object obj) {
		log.warn(obj);
		performException(obj);
	}
	
	/**
	 * 
	 * Description: 打印错误、异常信息
	 *
	 * @param obj 
	 * @return String
	 * @throws 
	 * @Author yaodawei
	 * Create Date: 2014-1-7 下午03:42:07
	 */
	private String performException(Object obj) {
		if (!(obj instanceof Exception)){
			return null;
		}
		Exception exception = (Exception)obj;
		String s = exception.getMessage();
		if (s != null){
			System.err.println(s);
		}
		exception.printStackTrace();
		return s;
	}

	static {
		initLog();
	}
}
