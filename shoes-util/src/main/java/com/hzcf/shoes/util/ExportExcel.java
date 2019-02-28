package com.hzcf.shoes.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created by lx916 on 2016/2/3.
 */
public class ExportExcel {
    //显示的导出表的标题
    private String title;
    //导出表的列名
    private String[] rowName ;

    private List<Object[]> dataList = new ArrayList<Object[]>();

    HttpServletResponse response;

    //构造方法，传入要导出的数据
    public ExportExcel(String title,String[] rowName,List<Object[]>  dataList){
        this.dataList = dataList;
        this.rowName = rowName;
        this.title = title;
    }

    /*
     * 导出数据
     * */
    public void export(HttpServletResponse response){
        try{
        	  XSSFWorkbook workbook = new XSSFWorkbook();
        	// 在内存中保持100行，超过100行将被刷新到磁盘  
        	  SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook(workbook, 100);  
        	  Sheet sheet = sxssfWorkbook.createSheet(title);
        	 //设置列头样式
        	 CellStyle columnTopStyle = getBigDataColumnTopStyle(sxssfWorkbook);//列头单元格样式
        	 CellStyle style = this.getBigDataStyle(sxssfWorkbook); 
        	 
        	 // 定义所需列数
             int columnNum = rowName.length;
             Row rowRowName = sheet.createRow(0);
              
           // 将列头设置到sheet的单元格中
              for(int n=0;n<columnNum;n++){
                   Cell cellRowName = rowRowName.createCell(n);
                   //创建列头对应个数的单元格
                  cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING);             //设置列头单元格的数据类型
                  HSSFRichTextString text = new HSSFRichTextString(rowName[n]);
                  cellRowName.setCellValue(text);                                 //设置列头单元格的值
                  cellRowName.setCellStyle(columnTopStyle);                       //设置列头单元格样式

                  int length = (rowName[n].getBytes().length+6) * 256;
                  sheet.setColumnWidth(n, length);
              }
              
              
              //将查询出的数据设置到sheet对应的单元格中
              for(int i=0;i<dataList.size();i++){

                  Object[] obj = dataList.get(i);//遍历每个对象
                  Row row = sheet.createRow(i+1);//创建所需的行数

                  for(int j=0; j<obj.length; j++){
                      Cell  cell = null;   //设置单元格的数据类型
                          cell = row.createCell(j,HSSFCell.CELL_TYPE_STRING);
                          if(!"".equals(obj[j]) && obj[j] != null){
                              cell.setCellValue(obj[j].toString());                       //设置单元格的值
                          }
                      cell.setCellStyle(style);                                   //设置单元格样式
                  }
              }
              
              
              if(workbook !=null){
                  try{
                      String fileName =  title + ".xlsx";
                      String headStr = "attachment; filename=\""+
                      new String( fileName.getBytes( "utf-8" ), "ISO8859-1" ) + "\"";
                      response.setContentType("APPLICATION/OCTET-STREAM;charset=utf-8");
                      response.setHeader("Content-Disposition", headStr);
                      OutputStream out = response.getOutputStream();
                      sxssfWorkbook.write(out);
                  }catch (IOException e){
                      e.printStackTrace();
                  }

              }

          }catch(Exception e){
              e.printStackTrace();
          } finally {
  		}

    }

    
    //解决大数据导出问题
    
    /**
     * 列头单元格样式
     * @param sxssfWorkbook
     * @return
     */
     private CellStyle getBigDataColumnTopStyle(SXSSFWorkbook sxssfWorkbook){
    	// 设置字体
    	  Font font = sxssfWorkbook.createFont();
    	 //设置字体大小
         font.setFontHeightInPoints((short)11);
         //字体加粗
         font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
         //设置字体名字
         font.setFontName("宋体");
          
         //设置样式;
         CellStyle style = sxssfWorkbook.createCellStyle();
         //设置底边框;
         style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
         //设置底边框颜色;
         style.setBottomBorderColor(HSSFColor.BLACK.index);
         //设置左边框;
         style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
         //设置左边框颜色;
         style.setLeftBorderColor(HSSFColor.BLACK.index);
         //设置右边框;
         style.setBorderRight(HSSFCellStyle.BORDER_THIN);
         //设置右边框颜色;
         style.setRightBorderColor(HSSFColor.BLACK.index);
         //设置顶边框;
         style.setBorderTop(HSSFCellStyle.BORDER_THIN);
         //设置顶边框颜色;
         style.setTopBorderColor(HSSFColor.BLACK.index);
         //在样式用应用设置的字体;
         style.setFont(font);
         //设置自动换行;
         style.setWrapText(false);
         //设置水平对齐的样式为居中对齐;
         style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
         //设置垂直对齐的样式为居中对齐;
         style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
         //设置背景色
         style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
         style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);

         return style;
     }
     
     public CellStyle getBigDataStyle(SXSSFWorkbook sxssfWorkbook) {
         // 设置字体
         Font font = sxssfWorkbook.createFont();
         //设置字体大小
         //font.setFontHeightInPoints((short)10);
         //字体加粗
         //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
         //设置字体名字
         font.setFontName("宋体");
         //设置样式;
         CellStyle style = sxssfWorkbook.createCellStyle();
         //设置底边框;
         style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
         //设置底边框颜色;
         style.setBottomBorderColor(HSSFColor.BLACK.index);
         //设置左边框;
         style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
         //设置左边框颜色;
         style.setLeftBorderColor(HSSFColor.BLACK.index);
         //设置右边框;
         style.setBorderRight(HSSFCellStyle.BORDER_THIN);
         //设置右边框颜色;
         style.setRightBorderColor(HSSFColor.BLACK.index);
         //设置顶边框;
         style.setBorderTop(HSSFCellStyle.BORDER_THIN);
         //设置顶边框颜色;
         style.setTopBorderColor(HSSFColor.BLACK.index);
         //在样式用应用设置的字体;
         style.setFont(font);
         //设置自动换行;
         style.setWrapText(false);
         //设置水平对齐的样式为居中对齐;
         style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
         //设置垂直对齐的样式为居中对齐;
         style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

         return style;

     }
     
     
     //适用于十万以下数据导出
     
    /*
     * 列头单元格样式
     */
    public HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short)11);
        //字体加粗
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("宋体");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        //设置背景色
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);

        return style;

    }
    
 

    /*
     * 列数据信息单元格样式
     */
    public HSSFCellStyle getStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        //font.setFontHeightInPoints((short)10);
        //字体加粗
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("宋体");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;

    }

    /*
     * 导出数据
     * */
    public void write(OutputStream outputStream){
        try{
            HSSFWorkbook workbook = new HSSFWorkbook();                     // 创建工作簿对象
            HSSFSheet sheet = workbook.createSheet(title);                  // 创建工作表

            //sheet样式定义【getColumnTopStyle()/getStyle()均为自定义方法 - 在下面  - 可扩展】
            HSSFCellStyle columnTopStyle = this.getColumnTopStyle(workbook);//获取列头样式对象
            HSSFCellStyle style = this.getStyle(workbook);                  //单元格样式对象

            // 定义所需列数
            int columnNum = rowName.length;
            HSSFRow rowRowName = sheet.createRow(0);                // 在索引2的位置创建行(最顶端的行开始的第二行)

            // 将列头设置到sheet的单元格中
            for(int n=0;n<columnNum;n++){
                HSSFCell  cellRowName = rowRowName.createCell(n);               //创建列头对应个数的单元格
                cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING);             //设置列头单元格的数据类型
                HSSFRichTextString text = new HSSFRichTextString(rowName[n]);
                cellRowName.setCellValue(text);                                 //设置列头单元格的值
                cellRowName.setCellStyle(columnTopStyle);                       //设置列头单元格样式

                int length = (rowName[n].getBytes().length+6) * 256;
                sheet.setColumnWidth(n, length);
            }

            //将查询出的数据设置到sheet对应的单元格中
            for(int i=0;i<dataList.size();i++){

                Object[] obj = dataList.get(i);//遍历每个对象
                HSSFRow row = sheet.createRow(i+1);//创建所需的行数

                for(int j=0; j<obj.length; j++){
                    HSSFCell  cell = null;   //设置单元格的数据类型
                        cell = row.createCell(j,HSSFCell.CELL_TYPE_STRING);
                        if(!"".equals(obj[j]) && obj[j] != null){
                            cell.setCellValue(obj[j].toString());                       //设置单元格的值
                        }
                    cell.setCellStyle(style);                                   //设置单元格样式
                }
            }

            if(workbook !=null){
                try{
                    workbook.write(outputStream);
                }catch (IOException e){
                    e.printStackTrace();
                }

            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }


}
