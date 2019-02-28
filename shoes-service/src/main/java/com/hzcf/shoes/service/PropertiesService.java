package com.hzcf.shoes.service;

import java.util.Map;

import com.hzcf.shoes.model.Properties;
import com.hzcf.shoes.util.PageModel;


/**
 *<dl>
 *<dt>类名：PropertiesService.java</dt>
 *<dd>描述:系统属性配置</dd> 
 *<dd>创建时间： 2017年7月4日 下午3:43:16</dd>
 *<dd>创建人： TieGuowei </dd>
 *<dt>版本历史: </dt>
 * <pre>
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2017年7月4日 下午3:43:16    TieGuowei       1.0        1.0 Version 
 * </pre>
 *</dl>
 */
public interface PropertiesService {

	/**
	 * 理财机构名称对应表分页查询
	 */
	public PageModel findAllByPage(Map<String, Object> paramsCondition);

	public Properties selectByPrimaryKey(Integer id);

	public void doUpdateProperty(Properties properties, Integer id);

}
