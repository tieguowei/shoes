package com.hzcf.shoes.util;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.Region;
import org.springframework.ldap.core.AuthenticationErrorCallback;
@SuppressWarnings("all")
public class CustomHeaderExport {

	/** 
     * 遍历树创建表头 
     * 规则： 1、 以二维数组的形式保存树节点  
     *      1:表头名称  2：表头索引 3：表头层级   4：父表头索引 
     *  	{ "NO","0","1","-1"}
     *     2、表头存放的顺序必须按照空间顺序从左到右存储   
     * @param header  表头
     * @param sheetName 
     * @param titleName  文件名
     * @param index 指示表头从第几行开始创建 
     * @param dataList 数据源
     */ 
	public static void createHeaderAndExport(String[][] header,String sheetName,String titleName,int index,List<Object[]> dataList,HttpServletResponse response){  
    	
    	try {
    		HSSFWorkbook wb = new HSSFWorkbook();
        	HSSFSheet sheet = wb.createSheet(sheetName);
        	//创建header  
            //获取树深度  
            int deep = getDeep(header); 
            //根据树的深度创建行  
            List<HSSFRow> headerRows = new ArrayList<HSSFRow>();  
            for(int i =0;i<deep;i++){  
                HSSFRow headerRow = sheet.createRow((short) index+i);  
                headerRow.setHeight((short) 300);//设置行高  
                headerRows.add(headerRow);  
            }  
            List<HeaderNode> headerNodes = arrayToList(header);
            //获取叶子节点数量，根据此数量创建列  
			int allOverNodeCount = getAllOverNodeCount(header); 
            
            //设置字体居中显示
            HSSFCellStyle style = wb.createCellStyle();
        	style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平
        	style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直 
        	HSSFFont font = wb.createFont(); 
        	font.setFontName("宋体");
            font.setFontHeightInPoints((short) 10);// 设置字体大小
            /*font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  */       //字体增粗
            style.setFont(font);
            //创建单元格  
            for(int i=0;i<headerNodes.size();i++){  
                HeaderNode headerNode = headerNodes.get(i);  
                int level = Integer.parseInt(headerNode.getLevel()); 
                int overNodeCount = headerNode.getAllOverNodeCount(); 
                int frontCount = headerNode.getFrontCount();  
                sheet.setColumnWidth((short)frontCount, (short)5000);//设置列宽 
                HSSFCell headerCell =   
                    headerRows.get(level-1).createCell((short)frontCount);  
                headerCell.setCellStyle(style);
             headerCell.setCellValue(new HSSFRichTextString(headerNode.getHeaderName()));  
                if(headerNode.isoverNode){  
                    //为叶子节点  
                    //向下合并单元格  
                    Region region = new Region();  
                    region.setRowFrom(index+level-1);  
                    region.setRowTo(index+deep-1);  
                    region.setColumnFrom((short)frontCount) ;  
                    region.setColumnTo((short)frontCount) ;  
                    sheet.addMergedRegion(region);  
                }else{  
                    //为非叶子节点  
                    //向右合并单元格  
                    Region region = new Region();  
                    region.setRowFrom(index+level-1);  
                    region.setRowTo(index+level-1);  
                    region.setColumnFrom((short)frontCount) ;  
                    region.setColumnTo((short)(frontCount + overNodeCount-1)) ;  
                    sheet.addMergedRegion(region);  
                } 
            }  
            
            //填充数据
          //将查询出的数据设置到sheet对应的单元格中
            int start = deep;
            for(int i=0;i<dataList.size();i++){
                Object[] obj = dataList.get(i);//遍历每个对象
                HSSFRow row = sheet.createRow(deep);//创建所需的行数
                for(int j=0; j<obj.length; j++){
                	Cell cells = row.createCell(j);
    				String cellLiString = String.valueOf(obj[j].toString());
    				cells.setCellValue(new HSSFRichTextString(cellLiString));
    				/*cells.setCellStyle(style); */
    				sheet.setColumnWidth(j, 7000);// 设置excel每列宽度   
                }
                deep += 1;
            }
            if(wb !=null){
                try{
                    String fileName =  titleName + ".xls";
                    String headStr = "attachment; filename=\""+
                    new String( fileName.getBytes( "utf-8" ), "ISO8859-1" ) + "\"";
                    response.setContentType("APPLICATION/OCTET-STREAM;charset=utf-8");
                    response.setHeader("Content-Disposition", headStr);
                    OutputStream out = response.getOutputStream();
                    wb .write(out);
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
		} catch (Exception e) {
			e.printStackTrace();
		}
    }  
      
    static class HeaderNode{  
        private String index;  
        private String headerName;  
        private String level;  
        private String parentIndex;  
        private int allOverNodeCount;  
        private boolean isoverNode;  
        private int frontCount;  
        public HeaderNode(String headerName,String index,  String level,  
                String parentIndex, int allOverNodeCount, boolean isoverNode,int frontCount) {  
            super();  
            this.index = index;  
            this.headerName = headerName;  
            this.level = level;  
            this.parentIndex = parentIndex;  
            this.allOverNodeCount = allOverNodeCount;  
            this.isoverNode = isoverNode;  
            this.frontCount = frontCount;  
        }  
        public String getIndex() {  
            return index;  
        }  
        public void setIndex(String index) {  
            this.index = index;  
        }  
        public String getHeaderName() {  
            return headerName;  
        }  
        public void setHeaderName(String headerName) {  
            this.headerName = headerName;  
        }  
        public String getLevel() {  
            return level;  
        }  
        public void setLevel(String level) {  
            this.level = level;  
        }  
        public String getParentIndex() {  
            return parentIndex;  
        }  
        public void setParentIndex(String parentIndex) {  
            this.parentIndex = parentIndex;  
        }  
        public int getAllOverNodeCount() {  
            return allOverNodeCount;  
        }  
        public void setAllOverNodeCount(int allOverNodeCount) {  
            this.allOverNodeCount = allOverNodeCount;  
        }  
        public boolean isIsoverNode() {  
            return isoverNode;  
        }  
        public void setIsoverNode(boolean isoverNode) {  
            this.isoverNode = isoverNode;  
        }  
        public int getFrontCount() {  
            return frontCount;  
        }  
        public void setFrontCount(int frontCount) {  
            this.frontCount = frontCount;  
        }  
    }  
      
      
    /** 
     * 数组转化list集合 
     * @param header 
     * @return 
     */  
    private static List<HeaderNode> arrayToList(String[][] header){  
        List<HeaderNode> headerNodes = new ArrayList<HeaderNode>();  
        for(String[] headernode : header){  
            //获取此节点下的所有叶子节点数量  
            int count = getOverNodeCount(headernode,header);  
            int frontCount = getFrontOverNodeCount(headernode,header);  
            headerNodes.add(new HeaderNode(headernode[0], headernode[1], headernode[2], headernode[3],count,isOverNode(headernode,header),frontCount));  
        }  
        return headerNodes;  
    }  
    /** 
     * 获取level层级下的所有表头节点 
     * @param header 
     * @param level 
     * @return 
     */  
    private static List<HeaderNode> arrayToListByLevel(String[][] header,int level){  
        List<HeaderNode> headerNodes = new ArrayList<HeaderNode>();  
        for(String[] headernode : header){  
            if(headernode[2].equals(level+"")){  
                //获取此节点下的所有叶子节点数量  
                int count = getOverNodeCount(headernode,header);  
                int frontCount = getFrontOverNodeCount(headernode,header);  
                headerNodes.add(new HeaderNode(headernode[0], headernode[1], headernode[2], headernode[3],count,isOverNode(headernode,header),frontCount));  
            }  
        }  
        return headerNodes;  
    }  
      
    /** 
     * 获取总叶子节点的数量，根据此数量创建表头列数 
     * @param header 
     * @return 
     */  
    public static int getAllOverNodeCount(String[][] header){  
        int count = 0;  
        //获取表深度  
        int deep = Integer.parseInt(header[header.length-1][2]);  
        for(int i=0;i<header.length;i++){  
            if(isOverNode(header[i], header)){  
                count++;  
            }  
        }  
        return count;  
    }  
      
    /** 
     * 获取当前节点下的所有叶子节点数量 
     * @param headerNode 
     * @param header 
     * @return 
     */  
    public static int getOverNodeCount(String[] headerNode,String[][] header){  
        int count = 0;  
        for(int i=0;i<header.length;i++){  
            if(header[i][3].equals(headerNode[1])){  
                if(isOverNode(header[i], header)){  
                    count++;  
                }else{  
                    count += getOverNodeCount(header[i], header);  
                }  
            }  
        }  
        return count;  
    }  
      
    /** 
     * 判断是否为叶子节点 
     * @param headerNode 
     * @param header 
     * @return 
     */  
    private static boolean isOverNode(String[] headerNode,String[][] header){  
        for(int i=0;i<header.length;i++){  
            if(header[i][3].equals(headerNode[1])){  
                return false;  
            }  
        }  
        return true;  
    }  
      
      
    /** 
     * 获取当前节点空间顺序之前的所有叶子节点数量 
     * @param headerNode 
     * @param header 
     * @return 
     */  
    private static int getFrontOverNodeCount(String[] headerNode,String[][] header){  
        int count = 0 ;  
        for(int i=0;i<header.length;i++){  
            if(header[i].equals(headerNode)){  
                break;  
            }  
            if(isOverNode(header[i], header)){  
                count++;  
            }  
        }  
        return count;  
    }  
      
    private static int getDeep(String[][] header){  
        int deep = 0;  
        for(int i=0;i<header.length;i++){  
            if(Integer.parseInt(header[i][2])>deep){  
                deep = Integer.parseInt(header[i][2]);  
            }  
        }  
        return deep;  
    }  
}
