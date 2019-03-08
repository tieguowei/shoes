
package com.hzcf.shoes.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.CustomSQLExceptionTranslatorRegistrar;
import org.springframework.stereotype.Service;

import com.hzcf.shoes.dao.CustomerAccountMapper;
import com.hzcf.shoes.dao.CustomerPayHistoryMapper;
import com.hzcf.shoes.dao.CustomerPaymentRecordMapper;
import com.hzcf.shoes.model.CustomerAccount;
import com.hzcf.shoes.model.CustomerPayHistory;
import com.hzcf.shoes.model.CustomerPaymentRecord;
import com.hzcf.shoes.service.CustomerPayHistoryService;
import com.hzcf.shoes.util.PageModel;

@Service
public class CustomerPayHistoryServiceImpl implements CustomerPayHistoryService{

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private CustomerPayHistoryMapper  customerPayHistoryMapper;
	@Autowired
	private CustomerPaymentRecordMapper  customerPaymentRecordMapper;
	@Autowired
	private CustomerAccountMapper customerAccountMapper;
	@Override
	public List<Map<String, Object>> getCustomerPaymentHistory(String customerName) {
		return customerPayHistoryMapper.getCustomerPaymentHistory(customerName);
	}

		@Override
		public PageModel findAllByPage(Map<String, Object> paramsCondition) {
			PageModel pageModel = new PageModel();
			pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
			pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
			paramsCondition.put("startIndex", pageModel.getStartIndex());
			paramsCondition.put("endIndex", pageModel.getEndIndex());
			List<Map<String, Object>> data = customerPayHistoryMapper.findAllRetMapByPage(paramsCondition);
			Long totalRecords = customerPayHistoryMapper.findAllByPageCount(paramsCondition);
			pageModel.setList(data);
			pageModel.setTotalRecords(totalRecords);
			return pageModel;
		}

		@Override
		public void insertSelective(CustomerPayHistory payHistory) {
			/**
			 * 付款流水入库
			 */
			customerPayHistoryMapper.insertSelective(payHistory);
			/**
			 *  自动填平账单逻辑
				1.如果还款金额大于 欠款金额。修改还款金额和欠款金额后。修改账单状态为已结清 进入下一次循环。
				2.如果还款金额 小于欠款金额。修改还款金额和欠款金额。终止for循环
				3.如果还款金额等于 欠款金额。修改还款金额和欠款金额并修改账单状态后。终止for循环
				a = -1,表示A小于B；
				a = 0,表示A等于B；
				a = 1,表示A大于B；
			 */
				BigDecimal payMoney = payHistory.getPayMoney();// 用户还款金额
				BigDecimal zero = new BigDecimal(0);
				List<CustomerPaymentRecord> list = customerPaymentRecordMapper.getCustomerBillListByCustomerName(payHistory.getCustomerName());
				if(null != list && list.size()>0){
					ListSort(list);
					for (CustomerPaymentRecord record : list) {
						// 还款金额 > 0 再进入循环
						if (payMoney.compareTo(zero) == 1) {
							BigDecimal balanceDue = record.getBalanceDue();// 账单欠款金额
							if (payMoney.compareTo(balanceDue) == 1) {
								payMoney = payMoney.subtract(record.getBalanceDue());// 客户还款剩余金额
								record.setActualPayment( record.getActualPayment().add(record.getBalanceDue()));
								record.setBalanceDue(zero);
								record.setBillStatus("0");// 已结清
								customerPaymentRecordMapper.updateByPrimaryKeySelective(record);
								continue;
							} else if (payMoney.compareTo(record.getBalanceDue()) == -1) {
								record.setActualPayment(payMoney.add( record.getActualPayment()));//实还金额
								record.setBalanceDue(record.getBalanceDue().subtract(payMoney));
								customerPaymentRecordMapper.updateByPrimaryKeySelective(record);
								payMoney = zero;// 客户还款剩余金额
								break;
							} else {
								record.setActualPayment(payMoney.add( record.getActualPayment()));
								record.setBalanceDue(record.getBalanceDue().subtract(payMoney));
								record.setBillStatus("0");// 已结清
								customerPaymentRecordMapper.updateByPrimaryKeySelective(record);
								payMoney = zero;// 客户还款剩余金额
								break;
							}
						}
						break;
				}
				}
				
			logger.info("填平账单完毕，客户:"+payHistory.getCustomerName()+" 剩余"+payMoney+"元");
			/**
			 * 填平账单后 还有钱 存进账户余额表中 下次生成账单扣除
			 */
			if(payMoney.compareTo(zero) == 1){
				CustomerAccount account  = new CustomerAccount();
				account.setBalance(payMoney);
				account.setCreateTime(new Date());
				account.setCustomerName(payHistory.getCustomerName());
				account.setRemark("客户打款超出总欠款。请在账单列表 手动处理！");
				customerAccountMapper.insertSelective(account);
			}
		
		}

		
		
		/**
	     * 根据时间排序
	     * @param list
	     */
	    private static void ListSort(List<CustomerPaymentRecord> list) {
	        Collections.sort(list, new Comparator<CustomerPaymentRecord>() {
	            @Override
	            public int compare(CustomerPaymentRecord o1, CustomerPaymentRecord o2) {
	                try {
	                    Date dt1 = o1.getCreateTime();
	                    Date dt2 = o2.getCreateTime();
	                    if (dt1.getTime() > dt2.getTime()) {
	                        return 1;
	                    } else if (dt1.getTime() < dt2.getTime()) {
	                        return -1;
	                    } else {
	                        return 0;
	                    }
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                return 0;
	            }
	        });
	    }
}
