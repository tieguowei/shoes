package com.hzcf.shoes.web.store;

import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzcf.shoes.baseweb.BaseController;
import com.hzcf.shoes.baseweb.DataMsg;
import com.hzcf.shoes.model.CustomerPaymentRecord;
import com.hzcf.shoes.model.Order;
import com.hzcf.shoes.service.CustomerBillService;
import com.hzcf.shoes.service.CustomerPayHistoryService;
import com.hzcf.shoes.service.ItemService;
import com.hzcf.shoes.util.PageModel;
import com.hzcf.shoes.util.StringUtil;


/** 
*
* Description: 订单管理
*
*/
@Controller
@RequestMapping("/item")
public class ItemController extends BaseController{

	@Autowired
	private ItemService itemService;
	@Autowired
	private CustomerBillService customerBillService;
	@Autowired
	private CustomerPayHistoryService customerPayHistoryService;
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy年M月d日");
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	
	/**
	 * 
	 * Description: 跳转到订单列表页面
	 */
	@RequestMapping("/toPageList")
	public String toEmpList(String refreshTag,String messageCode,Model model) {
		showMessageAlert(refreshTag,messageCode,model);
		return "app/store/itemManagement/item_list";
	}
	
	/**
	 * 
	 * Description: 订单分页查询列表
	 */
	@ResponseBody
	@RequestMapping(value="/getItemList")
	public DataMsg getItemList(HttpServletRequest request,DataMsg dataMsg) {
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("page")));
			paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("rows")));
			String customerName = StringUtil.trim(request.getParameter("customerName"));// 客户姓名
			if (StringUtil.isNotBlank(customerName)) {
				paramsCondition.put("customerName", customerName);
			}
			String factoryName = StringUtil.trim(request.getParameter("factoryName"));// 鞋厂名称
			if (StringUtil.isNotBlank(factoryName)) {
				paramsCondition.put("factoryName", factoryName);
			}
			String factoryIsDefectiveGoods = StringUtil.trim(request.getParameter("factoryIsDefectiveGoods"));// 鞋厂是否减次
			if (StringUtil.isNotBlank(factoryIsDefectiveGoods)) {
				paramsCondition.put("factoryIsDefectiveGoods", factoryIsDefectiveGoods);
			}
			String customerIsDefectiveGoods = request.getParameter("customerIsDefectiveGoods");//客户是否减次
			if (StringUtil.isNumeric(customerIsDefectiveGoods)) {
				paramsCondition.put("customerIsDefectiveGoods", customerIsDefectiveGoods);
			}
			String season = request.getParameter("season");//季节
			if (StringUtil.isNumeric(season)) {
				paramsCondition.put("season", season);
			}
			
			//发货开始时间
			String minCreateTime = request.getParameter("minCreateTime");
			if(StringUtil.isNotBlank(minCreateTime)){
				paramsCondition.put("minCreateTime", minCreateTime.trim());
			}
			//发货结束时间
			String maxCreateTime = request.getParameter("maxCreateTime");
			if(StringUtil.isNotBlank(maxCreateTime)){
				paramsCondition.put("maxCreateTime", maxCreateTime.trim());
			}
			PageModel pageModel = itemService.findAllByPage(paramsCondition);
			dataMsg.setTotal(pageModel.getTotalRecords());
			dataMsg.setRows(pageModel.getList());
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return dataMsg;
	}
	
	  /**
     * 跳转添加页面
     * @return
     */
    @RequestMapping(value="/toAddItem")
	public String toAddItem() {
		return "/app/store/itemManagement/item_add";
	}
	
    /**
     * 添加订单
     * @param order
     * @param session
     * @param dataMsg
     * @param oauth
     * @return
     */
    @ResponseBody
	@RequestMapping(value="/doAddItem")
	public DataMsg doAddItem(@ModelAttribute Order order,HttpSession session,DataMsg dataMsg,String oauth) {
		try {
			order.setCustomerIsDefectiveGoods("1");
			order.setFactoryIsDefectiveGoods("1");
			order.setCreateTime(new Date());
			order.setOperator(getSystemCurrentUser(session).getEmployeeId());
			itemService.insertSelective(order);
			dataMsg.setMessageCode("0001");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			dataMsg.setMessageCode("0002");
		}
		return dataMsg;
	}
   
    /**
	 * 
	 * Description: 跳转到修改订单页面
	 */
	@RequestMapping(value="/toEditItem/{id}")
	public String toEditItem(@PathVariable Integer id,Model model) {
		try {
			Map<String,Object> map = itemService.selectById(id);
			model.addAttribute("order", map);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return "common/exception";
		}
		return "app/store/itemManagement/item_edit";
	}
	

	/**
	 * 
	 * Description: 修改订单信息
	 */
	@ResponseBody
	@RequestMapping("/doEditItem")
	public DataMsg doEditItem(@ModelAttribute Order order,HttpSession session,DataMsg dataMsg){
		try {
			order.setOperator(getSystemCurrentUser(session).getEmployeeId());
			order.setUpdateTime(new Date());
			itemService.updateById(order);
			dataMsg.setMessageCode("0003");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			dataMsg.setMessageCode("0004");
		}
		return dataMsg;
	}
	
	/**
	 * 
	 * Description: 查询客户有无未处理订单
	 */
	@ResponseBody
	@RequestMapping(value="/checkCustomerItemIsOver")
	public  boolean checkCustomerItemIsOver(HttpServletRequest request,DataMsg dataMsg) {
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			customerParm(request, paramsCondition);
			//先判断此时间内有没有订单（有：直接导出   无：判断有没有差价 和退货）
			List<Map<String,Object>> itemList = itemService.checkBillByCustomerAndPayTime(paramsCondition);
			if(null != itemList && itemList.size()>0){
				return true;
			}else{
				List<Map<String,Object>> list = itemService.checkCustomerItemIsOver(paramsCondition);
				if(null != list && list.size()>0){
					return true;
				}
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return false;
	}

	/**
	 * 客户账单导出
	 * @param request
	 * @param response
	 */
	@RequestMapping("/doCustomerExport")
	public void doCustomerExport(HttpSession session,HttpServletRequest request, HttpServletResponse response) {
			String customerName = StringUtil.trim(request.getParameter("customerName"));
			//组装请求参数
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			customerParm(request,paramsCondition);
			List<Map<String, Object>> itemList = new ArrayList<Map<String, Object>>();
			//修改订单是否减次组装参数
			Map<String,Object> updateItemStatus = new HashMap<String,Object>();

		try {
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("sheet1");
	         //列表首行标题样式
	        HSSFCellStyle listTitleStyle = setListTitleStyle(wb);
	        //列表中字体样式
	    	HSSFCellStyle cellStyle = wb.createCellStyle();
		    cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中  
		    cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中 
			//发货记录  还款记录 差价和退货 本次账单详情样式
			HSSFCellStyle secondStyle = setStyleForItemAndPay(wb);
			//设置表头
	        setTitle(customerName, wb,sheet);
	       
	        /**
	         * 1.组装发货记录
	         */
			 itemList = setItemRecord(paramsCondition, sheet, listTitleStyle, cellStyle,secondStyle);
			
			/**
			 * 2.组装还款记录
			 */
			int size =2+itemList.size();
			List<Map<String,Object> >payList =setPayRecord(customerName, sheet, listTitleStyle, cellStyle, secondStyle, size);
			
			/**
			 * 3.组装历史账单中有差价和退货的订单
			 */
			int startSize = 4 + itemList.size() + payList.size();
			List<Map<String,Object>> priceList  = setPriceSpread(paramsCondition, sheet, listTitleStyle, cellStyle, secondStyle,startSize);
			
			/**
			 * 4.组装账单汇总数据
			 */
			int dataSize =6+ itemList.size() + priceList.size()+payList.size();
			//查询客户此时间段的订单汇总
			Map<String,Object> totalMap = itemService.getTotalMoneyByParam(paramsCondition);
			//查询客户历史账单时间 + 本次账单(差价和退货)汇总
			String sumMap = itemService.getBillPriceSum(paramsCondition);
			setTotalData(sumMap,totalMap,customerName, sheet, listTitleStyle, cellStyle,secondStyle,dataSize);
			
			/**
			 * 5.修改此账单中差价和退货的订单状态（改为已处理）
			 *  参数：差价和退货是否处理状态  0：是 1：否
			 */
			updatePriceAndReturnStatus("1","0",session, paramsCondition);
			if (wb != null) {
				//此账单有发货记录才入库账单 并且修改此账单中订单的标记
				if(null != itemList && itemList.size() >0){
					/**
					 * 6.修改此账单中的订单标记（客户已减次）
					 *  参数一：客户是否减次状态 0：是 1：否
					 */
					updateItemStatus.put("minCreateTime", itemList.get(1).get("pay_time"));//本次账单中订单开始时间
					updateItemStatus.put("maxCreateTime", itemList.get(itemList.size()-1).get("pay_time"));//本次账单中订单开始时间
					updateItemStatus.put("customerName", paramsCondition.get("customerName"));
					updateItemStatus("0",session, updateItemStatus);
					/**
					 * 7.客户账单入库
					 */
					insertCustomerBill(session, customerName, itemList, totalMap, sumMap);
				}
				String fileName = format.format(new Date()) + "【" + customerName + "】账单" + ".xlsx";
				String headStr = "attachment; filename=\"" + new String(fileName.getBytes("utf-8"), "ISO8859-1")
						+ "\"";
				response.setContentType("APPLICATION/OCTET-STREAM;charset=utf-8");
				response.setHeader("Content-Disposition", headStr);
				OutputStream out = response.getOutputStream();
				wb.write(out);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			try {
				/**
				 * 异常情况  还原此账单中差价和退货的订单状态
				 */
				updatePriceAndReturnStatus("0","1",session, paramsCondition);
				/**
				 * 异常情况 还原此账单中的订单标记状态
				 * 年底最后一次无发货记录的账单 失败不回滚此状态
				 */
				if(null != itemList && itemList.size()>0){
					updateItemStatus("1",session, updateItemStatus);
				}
			} catch (Exception e2) {
				logger.error(e.getMessage(), e);
			}
		}

	}

	public void updateItemStatus(String status,HttpSession session, Map<String, Object> paramsCondition) {
		paramsCondition.put("customerIsDefectiveGoods", status);
		paramsCondition.put("updateTime", new Date());
		paramsCondition.put("operator", getSystemCurrentUser(session).getEmployeeId());
		itemService.updateItemStatus(paramsCondition);
	}

	public void updatePriceAndReturnStatus(String before,String after,HttpSession session, Map<String, Object> paramsCondition) {
		Map<String,Object> reqMap = new HashMap<String,Object>();
		reqMap.put("before", before);
		reqMap.put("after", after);
		reqMap.put("updateTime", new Date());
		reqMap.put("operator", getSystemCurrentUser(session).getEmployeeId());
		itemService.updatePriceAndReturnStatus(reqMap,paramsCondition);
	}

	public void insertCustomerBill(HttpSession session, String customerName, List<Map<String, Object>> itemList,
			Map<String, Object> totalMap, String sumMap) throws ParseException {
		CustomerPaymentRecord customerbill = new CustomerPaymentRecord();
		customerbill.setCustomerName(customerName); //客户姓名
		customerbill.setBillStartTime(dateFormat.parse(itemList.get(1).get("pay_time").toString()));//本次账单中订单开始时间
		customerbill.setBillEndTime(dateFormat.parse(itemList.get(itemList.size()-1).get("pay_time").toString()));//本次账单中订单结束时间
		String  object = String.valueOf(totalMap.get("blanceDue"));//此金额已经减次
	  	BigDecimal qke = new BigDecimal(object).subtract(new BigDecimal(sumMap));
		customerbill.setCustomaryDues(qke);//本次账单应还金额
		customerbill.setSpredReturnMoney(new BigDecimal(sumMap));//本次账单（总差价+总退货价）
		customerbill.setCreateTime(new Date());
		customerbill.setBalanceDue(qke);//本次账单欠款
		customerbill.setOperator(getSystemCurrentUser(session).getEmployeeId());
		customerBillService.insertCustomerBill(customerbill);
	}

	private void setTotalData(String sumMap, Map<String, Object> totalMap, String customerName,HSSFSheet sheet, HSSFCellStyle listTitleStyle, HSSFCellStyle cellStyle, HSSFCellStyle secondStyle, int dataSize) {
		  //查询客户历史账单总欠款
		  Map<String,Object> data = customerBillService.getTotaMoneyOwed(customerName);
		  //查询客户最新账单时间
		  Map<String,Object> time = customerBillService.getLastOneTime(customerName);
		  HSSFRow nextRow = sheet.createRow(dataSize);
			nextRow.setHeightInPoints(30);
			HSSFCell nextCell = nextRow.createCell(0);
			nextCell.setCellValue("本次账单详情");
			nextCell.setCellStyle(secondStyle);
			sheet.addMergedRegion(new CellRangeAddress(dataSize, dataSize, 0, 7));
			
		  List<Map<Object,Object>> dataList = new ArrayList<Map<Object,Object>>();
		  	LinkedHashMap<Object,Object> nextLikedHashMap = new LinkedHashMap<Object,Object>();
			nextLikedHashMap.put("货单时间", "货单时间");
			nextLikedHashMap.put("总件", "总件"); 
			nextLikedHashMap.put("总计金额（元）", "总计金额（元）"); 
			nextLikedHashMap.put("减次（元）", "减次（元）");
			if(!"0.00".equals(sumMap)){
				 nextLikedHashMap.put("历史账单差价和退货（元）", "历史账单差价和退货（元）");
			 }
			nextLikedHashMap.put("欠款额（元）", "欠款额（元）");
			if(null != time){
				nextLikedHashMap.put(time.get("create_time")+"账单欠款（元）",time.get("create_time")+"账单欠款（元）");
			}
			nextLikedHashMap.put("累计欠款（元）", "累计欠款（元）");
			dataList.add(0,nextLikedHashMap);
		  	LinkedHashMap<Object,Object> dataMap = new LinkedHashMap<Object,Object>();
		  	dataMap.put(format.format(new Date()),format.format(new Date()));
		  	String totalNum = String.valueOf(totalMap.get("totalNum"));
		  	dataMap.put("tn",totalNum);//本次账单总件
		  	dataMap.put("tm",totalMap.get("totalGoodsMoney"));//本次账单总计金额
		  	dataMap.put("jc",totalMap.get("jianci"));//本次账单减次
		  	
		  	if(!"0.00".equals(sumMap)){
		    	dataMap.put("returnPrice",sumMap);//本次账单(历史账单差价和退货)
            }
		  	
		  	/**
		  	 * 本次账单 应还金额(欠款额)
		  	 * 算法：总计金额 - 减次 - 历史账单差价和退货
		  	 */
		  	String  object = String.valueOf(totalMap.get("blanceDue"));//此金额已经减次
		  	BigDecimal qke = new BigDecimal(object).subtract(new BigDecimal(sumMap));
		  	if("0".equals(totalNum)){//表明是年后最后一次账单后的减差价和退货
		  		dataMap.put("qke",0);
		  	}else{
		  		dataMap.put("qke",qke);
		  	}
		  	
		  	if(null != time){
		  		dataMap.put("hb",data.get("balanceDue"));//历史账单总欠款
		  	}
           
		  	 
		  	/**
		  	 * 有差价并且是年底最后一个账单
		  	 * 
		  	 *  累计欠款算法：= 历史账单总欠款 -差价
		  	 *  
		  	 *  差价手动填平账单即可
		  	 */
		  	if(!"0.00".equals(sumMap) && "0.00".equals(String.valueOf(totalMap.get("totalGoodsMoney")))){
		  		BigDecimal add =new BigDecimal(String.valueOf(data.get("balanceDue"))).subtract(new BigDecimal(sumMap));
		  		if(null == time && "0".equals(totalNum) && "0.00".equals(sumMap)){//如果没有历史账单 本次欠款额又为0 时  累计欠款直接为0
		  			dataMap.put("累计欠款",0);
		  		}else{
		  			dataMap.put("累计欠款",add);
		  		}
		  		
		  	}else{
		  		 //无差价 累计欠款= 本次欠款额 + 历史账单总欠款 
			  	BigDecimal add = qke.add(new BigDecimal(String.valueOf(data.get("balanceDue"))));
			  	dataMap.put("累计欠款",add);
		  	}
		  	
		  	
		  	dataList.add(1,dataMap);
		  	int nextStart = 1 + dataSize;
		  	for (int i = 0; i < dataList.size(); i++) {
				Row rows = sheet.createRow(nextStart);
				//为首行设置样式
				HSSFCellStyle str;
				if(i == 0 ){
					str = listTitleStyle;
					rows.setHeightInPoints(20);
				}else{
					str = cellStyle;
				}
				Map<Object, Object> map2 = dataList.get(i);
				List list = new ArrayList();
				Iterator iter = map2.entrySet().iterator(); // 获得map的Iterator
				while (iter.hasNext()) {
					Entry entry = (Entry) iter.next();
					list.add(entry.getValue());
				}
				for (int j = 0; j < list.size(); j++) {
						Cell cells = rows.createCell(j);
						String cellLiString = String.valueOf(list.get(j));
						cells.setCellValue(new HSSFRichTextString(cellLiString));
						cells.setCellStyle(str); 
						sheet.setColumnWidth(j, 6000);// 设置excel每列宽度
					
				}
				nextStart += 1;
			}
	}

	private List<Map<String, Object>> setPriceSpread(Map<String, Object> paramsCondition, HSSFSheet sheet, HSSFCellStyle listTitleStyle, HSSFCellStyle cellStyle, HSSFCellStyle secondStyle, int startSize) throws Exception {
		List<Map<String,Object>> priceList = new  ArrayList<Map<String,Object>>();
		priceList =  itemService.getBillPrice(paramsCondition);
		if(null != priceList && priceList.size()>0){
			HSSFRow nextRow = sheet.createRow(startSize);
			nextRow.setHeightInPoints(30);
			HSSFCell nextCell = nextRow.createCell(0);
			nextCell.setCellValue("差价和退货");
			nextCell.setCellStyle(secondStyle);
			sheet.addMergedRegion(new CellRangeAddress(startSize, startSize, 0, 7));
			LinkedHashMap<String,Object> map = new LinkedHashMap<String,Object>();
			map.put("发货时间", "发货时间");
			map.put("鞋厂", "鞋厂"); 
			map.put("货号", "货号"); 
			map.put("差价金额（元）", "差价金额（元）");
			map.put("退货金额（元）", "退货金额（元）");
			map.put("总计（元）", "总计（元）");
			priceList.add(0,map);
			int nextStart = 1 + startSize;
			for (int i = 0; i < priceList.size(); i++) {
				Row rows = sheet.createRow(nextStart);
				//为首行设置样式
				HSSFCellStyle str;
				if(i == 0 ){
					str = listTitleStyle;
					rows.setHeightInPoints(20);
				}else{
					str = cellStyle;
				}
				Map<String, Object> map2 = priceList.get(i);
				List list = new ArrayList();
				Iterator iter = map2.entrySet().iterator(); // 获得map的Iterator
				while (iter.hasNext()) {
					Entry entry = (Entry) iter.next();
					list.add(entry.getValue());
				}
				for (int j = 0; j < list.size(); j++) {
						Cell cells = rows.createCell(j);
						String cellLiString = String.valueOf(list.get(j));
						cells.setCellValue(new HSSFRichTextString(cellLiString));
						cells.setCellStyle(str); 
						sheet.setColumnWidth(j, 5000);// 设置excel每列宽度
					
				}
				nextStart += 1;
			}
		}
		return priceList;
	}

	public List<Map<String, Object>> setPayRecord(String customerName, HSSFSheet sheet, HSSFCellStyle listTitleStyle,
			HSSFCellStyle cellStyle, HSSFCellStyle secondStyle, int size) {
			List<Map<String,Object>> payList = new  ArrayList<Map<String,Object>>();
			payList =  customerPayHistoryService.getCustomerPaymentHistory(customerName);
		    if(null != payList && payList.size()>0){
			HSSFRow nextRow = sheet.createRow(size);
			nextRow.setHeightInPoints(30);
			HSSFCell nextCell = nextRow.createCell(0);
			nextCell.setCellValue("还款记录");
			nextCell.setCellStyle(secondStyle);
			sheet.addMergedRegion(new CellRangeAddress(size, size, 0, 7));
			LinkedHashMap<String,Object> map = new LinkedHashMap<String,Object>();

			map.put("还款时间", "还款时间");
			map.put("银行名称", "银行名称"); 
			map.put("还款金额(元)", "还款金额(元)"); 
			payList.add(0,map);
			int nextStart = 1+ size;
			for (int i = 0; i < payList.size(); i++) {
				Row rows = sheet.createRow(nextStart);
				//为首行设置样式
				HSSFCellStyle str;
				if(i == 0 ){
					str = listTitleStyle;
					rows.setHeightInPoints(20);
				}else{
					str = cellStyle;
				}
				Map<String, Object> map2 = payList.get(i);
				List list = new ArrayList();
				Iterator iter = map2.entrySet().iterator(); // 获得map的Iterator
				while (iter.hasNext()) {
					Entry entry = (Entry) iter.next();
					list.add(entry.getValue());
				}
				for (int j = 0; j < list.size(); j++) {
						Cell cells = rows.createCell(j);
						String cellLiString = String.valueOf(list.get(j));
						cells.setCellValue(new HSSFRichTextString(cellLiString));
						cells.setCellStyle(str); 
						sheet.setColumnWidth(j, 5000);// 设置excel每列宽度
					
				}
				nextStart += 1;
			}
		}
		return payList;
	}

	

	public List<Map<String, Object>> setItemRecord(Map<String, Object> paramsCondition, HSSFSheet sheet,
		HSSFCellStyle listTitleStyle, HSSFCellStyle cellStyle, HSSFCellStyle secondStyle) {
		List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();
		 dataList = itemService.checkBillByCustomerAndPayTime(paramsCondition);
		 if(null != dataList && dataList.size()>0){
			 HSSFRow firstRow = sheet.createRow(1);
			firstRow.setHeightInPoints(30);
			HSSFCell firstCell = firstRow.createCell(0);
			firstCell.setCellValue("发货记录");
			firstCell.setCellStyle(secondStyle);
			sheet.addMergedRegion(new CellRangeAddress(1, 1, 0,7));
			
			LinkedHashMap<String,Object> likedHashMap = new LinkedHashMap<String,Object>();
			likedHashMap.put("发货时间", "发货时间");
			likedHashMap.put("鞋厂", "鞋厂"); 
			likedHashMap.put("货号", "货号"); 
			likedHashMap.put("件数", "件数"); 
			likedHashMap.put("双数", "双数"); 
			likedHashMap.put("单价(元)", "单价(元)"); 
			likedHashMap.put("总计(元)", "总计(元)"); 
			likedHashMap.put("备注", "备注"); 
			dataList.add(0,likedHashMap);
			int start = 2;
			for (int i = 0; i < dataList.size(); i++) {
				Row rows = sheet.createRow(start);
				//为首行设置样式
				HSSFCellStyle str;
				if(i == 0 ){
					rows.setHeightInPoints(20);
					str = listTitleStyle;
				}else{
					str = cellStyle;
				}
				Map<String, Object> map2 = dataList.get(i);//遍历每个对象
			     List list = new ArrayList();
				 Iterator iter = map2.entrySet().iterator(); // 获得map的Iterator
				while (iter.hasNext()) {
					Entry entry = (Entry) iter.next();
					list.add(entry.getValue());
				}
			    
				for (int j = 0; j < list.size(); j++) {
					Cell cells = rows.createCell(j);
					String cellLiString = String.valueOf(list.get(j));
					cells.setCellValue(new HSSFRichTextString(cellLiString));
					sheet.setColumnWidth(j, 3000);// 设置excel每列宽度
					cells.setCellStyle(str); 
				}
				start += 1;
			}
		 }
		return dataList;
	}

	public void setTitle(String customerName,HSSFWorkbook wb, HSSFSheet sheet) {
		HSSFCellStyle firstStyle = wb.createCellStyle();
	    firstStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中  
	    firstStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中  
	    HSSFFont font=wb.createFont();
        font.setColor(HSSFColor.BLACK.index);//HSSFColor.VIOLET.index //字体颜色
        font.setFontHeightInPoints((short)13);
        firstStyle.setFont(font);
        
		HSSFRow row = sheet.createRow(0);
		row.setHeightInPoints(50);
		HSSFCell cell = row.createCell(0);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,7));//首行合并多少格
		cell.setCellValue("客户："+customerName+"    账单日期："+format.format(new Date()));
		cell.setCellStyle(firstStyle);
	}
	
	/**
	 * 客户查询参数封装
	 * @param request
	 * @param paramsCondition
	 */
	private void customerParm(HttpServletRequest request, Map<String, Object> paramsCondition) {
		String customerName = StringUtil.trim(request.getParameter("customerName"));
		if (StringUtil.isNotBlank(customerName)) {
			paramsCondition.put("customerName", customerName);
		}
		String minCreateTime = StringUtil.trim(request.getParameter("minCreateTime"));
		if (StringUtil.isNotBlank(minCreateTime)) {
			paramsCondition.put("minCreateTime", minCreateTime);
		}
		String maxCreateTime = StringUtil.trim(request.getParameter("maxCreateTime"));
		if (StringUtil.isNotBlank(maxCreateTime)) {
			paramsCondition.put("maxCreateTime", maxCreateTime);
		}
	}
	
	public HSSFCellStyle setListTitleStyle(HSSFWorkbook wb) {
		HSSFCellStyle listTitleStyle = wb.createCellStyle();
		 listTitleStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());//浅灰色
		 listTitleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		 listTitleStyle.setWrapText(true);
		 listTitleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中  
		 listTitleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中 
		return listTitleStyle;
	}

	public HSSFCellStyle setStyleForItemAndPay(HSSFWorkbook wb) {
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
		HSSFCellStyle secondStyle = wb.createCellStyle();
		secondStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中  
		secondStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中  
		HSSFFont secondFont=wb.createFont(); 
		secondFont.setColor(HSSFColor.BLACK.index);//HSSFColor.VIOLET.index //字体颜色
		secondFont.setFontHeightInPoints((short)13);
		secondStyle.setFont(secondFont);
		return secondStyle;
	}
}
