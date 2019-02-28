<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>图片上传测试</title>  
  </head>  
    
  <body>  
    
   <%--  <form action="${pageContext.request.contextPath }/user/imageUpload" method="post">
    	文字上传
    	<input type="text" name="na" value="你好"></input>
    	<input type="submit" value="提交"/>
    </form> --%>
    
    <form id="itemForm" 
    action="${pageContext.request.contextPath }/image/imageUpload"
	method="post" enctype="multipart/form-data">
	<input type="file" name="pictFile" />
	<input type="submit" value="提交"/>
	
	<img src='/shoes-api/system/showImage/1501639426378868822.jpg'>
  </body>  
</html>  