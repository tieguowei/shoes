
package com.hzcf.shoes.baseweb;

import java.util.List;

/** 
 *
 * Description: 响应给前台的数据、消息封装
 *
 * @author ydw
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-11-18    ydw       1.0        1.0 Version 
 * </pre>
 */

public class DataMsg {
	
	//总记录数
	private Long total;
	
	//结果集
	private List rows;

    /**
     * 信息提示代码
     * {@link property/message_code.properties}
     */
	private String messageCode;
	
	//请求状态
	private String requestState;
	
	//是否重复
	private String isRepeat;
	
	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getRequestState() {
		return requestState;
	}

	public void setRequestState(String requestState) {
		this.requestState = requestState;
	}

	public String getIsRepeat() {
		return isRepeat;
	}

	public void setIsRepeat(String isRepeat) {
		this.isRepeat = isRepeat;
	}
}
