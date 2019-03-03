package com.hzcf.shoes.web.store;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzcf.shoes.baseweb.BaseController;
import com.hzcf.shoes.baseweb.DataMsg;
import com.hzcf.shoes.model.Order;
import com.hzcf.shoes.service.ItemService;
import com.hzcf.shoes.util.DateTimeUtil;
import com.hzcf.shoes.util.ExportExcel;
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
			Order order = itemService.selectByPrimaryKey(id);
			model.addAttribute("order", order);
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
			itemService.updateByPrimaryKeySelective(order);
			dataMsg.setMessageCode("0003");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			dataMsg.setMessageCode("0004");
		}
		return dataMsg;
	}
	
	/**
	 * 
	 * Description: 订单分页查询列表
	 */
	@ResponseBody
	@RequestMapping(value="/checkBillByCustomerAndPayTime")
	public  boolean checkBillByCustomerAndPayTime(HttpServletRequest request,DataMsg dataMsg) {
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			customerParm(request, paramsCondition);
			List<Map<String,Object>> list = itemService.checkBillByCustomerAndPayTime(paramsCondition);
			if(null != list && list.size()>0){
				return true;
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
	public void doCustomerExport(HttpServletRequest request, HttpServletResponse response) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy年M月d日");
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("sheet1");
			//首行背景颜色 和 字体颜色
	        HSSFCellStyle firstStyle = wb.createCellStyle();
		    firstStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中  
		    firstStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中  
		    HSSFFont font=wb.createFont();
	        font.setColor(HSSFColor.BLACK.index);//HSSFColor.VIOLET.index //字体颜色
	        font.setFontHeightInPoints((short)13);
	        firstStyle.setFont(font);
	        
	         //列表首行样式
	         HSSFCellStyle listTitleStyle = wb.createCellStyle();
	         listTitleStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	         listTitleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	         listTitleStyle.setWrapText(true);
	         listTitleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中  
	         listTitleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中 
	         
	        //列表中字体样式
	    	HSSFCellStyle cellStyle = wb.createCellStyle();
		    cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中  
		    cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中 
		    
			//还款记录 发货记录样式
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
			
	        HSSFRow row = sheet.createRow(0);
		    row.setHeightInPoints(50);
			HSSFCell cell = row.createCell(0);
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,8));//首行合并多少格
			String customerName = StringUtil.trim(request.getParameter("customerName"));
			cell.setCellValue("客户："+customerName+"    账单日期："+format.format(new Date()));
			cell.setCellStyle(firstStyle);
			
			HSSFRow firstRow = sheet.createRow(1);
			firstRow.setHeightInPoints(30);
			HSSFCell firstCell = firstRow.createCell(0);
			firstCell.setCellValue("发货记录");
			firstCell.setCellStyle(secondStyle);
			sheet.addMergedRegion(new CellRangeAddress(1, 1, 0,8));//发货记录合并多少格

			
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			customerParm(request,paramsCondition);
			//设置第一个表头
			List<Map<String,Object>> dataList = itemService.checkBillByCustomerAndPayTime(paramsCondition);
			LinkedHashMap<String,Object> likedHashMap = new LinkedHashMap<String,Object>();
			likedHashMap.put("出货时间", "出货时间");
			likedHashMap.put("客户", "客户"); 
			likedHashMap.put("鞋厂", "鞋厂"); 
			likedHashMap.put("货号", "货号"); 
			likedHashMap.put("件数", "件数"); 
			likedHashMap.put("双数", "双数"); 
			likedHashMap.put("单价", "单价"); 
			likedHashMap.put("总计", "总计"); 
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
			
			//展示还款记录
			//从第 3+dataList.size() 开始创建行
			int size = 3 +dataList.size();
			HSSFRow nextRow = sheet.createRow(size);
			nextRow.setHeightInPoints(30);
			HSSFCell nextCell = nextRow.createCell(0);
			nextCell.setCellValue("还款记录");
			nextCell.setCellStyle(secondStyle);
			sheet.addMergedRegion(new CellRangeAddress(size, size, 0, 8));
			LinkedHashMap<String,Object> nextLikedHashMap = new LinkedHashMap<String,Object>();
			List<Map<String,Object>> nextList = itemService.checkBillByCustomerAndPayTime(paramsCondition);

			nextLikedHashMap.put("出货时间", "出货时间");
			nextLikedHashMap.put("客户", "客户"); 
			nextLikedHashMap.put("鞋厂", "鞋厂"); 
			nextLikedHashMap.put("货号", "货号"); 
			nextLikedHashMap.put("件数", "件数"); 
			nextLikedHashMap.put("双数", "双数"); 
			nextLikedHashMap.put("单价", "单价"); 
			nextLikedHashMap.put("总计", "总计"); 
			nextLikedHashMap.put("备注", "备注"); 
			nextList.add(0,nextLikedHashMap);
			int nextStart = 4+ dataList.size();
			for (int i = 0; i < nextList.size(); i++) {
				Row rows = sheet.createRow(nextStart);
				//为首行设置样式
				HSSFCellStyle str;
				if(i == 0 ){
					str = listTitleStyle;
					rows.setHeightInPoints(20);
				}else{
					str = cellStyle;
				}
				
				Map<String, Object> map2 = nextList.get(i);
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
						sheet.setColumnWidth(j, 3000);// 设置excel每列宽度
					
				}
				nextStart += 1;
			}
			  if(wb !=null){
                  try{
                      String fileName = format.format(new Date())+"【"+customerName+"】" + ".xlsx";
                      String headStr = "attachment; filename=\""+
                      new String( fileName.getBytes( "utf-8" ), "ISO8859-1" ) + "\"";
                      response.setContentType("APPLICATION/OCTET-STREAM;charset=utf-8");
                      response.setHeader("Content-Disposition", headStr);
                      OutputStream out = response.getOutputStream();
                      wb.write(out);
                  }catch (IOException e){
                      e.printStackTrace();
                  }

              }
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

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
}
