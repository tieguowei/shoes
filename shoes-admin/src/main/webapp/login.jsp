<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/header.jsp"%>
<%@ page import="org.springframework.security.web.WebAttributes" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html >
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <title>鞋业管理系统</title>
    <meta name="keywords" content="">
    <meta name="description" content="鞋业管理系统">
    <link rel="icon" href="${app}/images/favicon.ico">
    <link rel="stylesheet" href="${app}/css/common/base.css">
    <link rel="stylesheet" href="${app}/css/login.css">
    
    
    <script type="text/javascript">
			function validate(){
				var flag=true;
				var username=$("#username").val();
				var password=$("#password").val();
				var chkcode=$("#chkcode").val();
				if(username.length==0){
					flag=false;
					return flag;
				}
			if(password.length==0){
				flag=false;
				return flag;
			}
			if(chkcode.length==0){
				flag=false;
				return flag;
			}
			return flag;
		}
	
		function login(){
			$("#checkError").html("");
			if(validate()){
				$("#userlogin").submit();
			}
		}
		
		function resets(){
			$("#username").textbox('setValue','');
			$("#password").textbox('setValue','');
			$("#chkcode").val("");
		}
		//回车登录
		$(document).keydown(function(event){ 
			if(event.keyCode==13){
				login();
			}
		}); 
		
		function changeCheckIMG(){
			$("#loginimg").attr("src","${app }/checkimg.jsp?timestamp=" + new Date());
		}
		function showerror(id,info){
			$("#"+id).html("<font color='red'>× "+info+"</font>");
		} 
	</script>
    
</head>
<body>
<div class="top">
    <div class="logoBox">
        <img src="${app}/images/shoes.png" alt="">
        <div style="display: inline-block">
            <h3>鞋业管理系统</h3>
            <p>一站式管理平台</p>
        </div>
    </div>
</div>
<div class="container">
<div class="loginBox">
    <form id="userlogin"  method="post" action="${app }/admin/j_spring_security_check">
        <h6>登录</h6>
        <ul class="login">
            <li>
                <div class="user">
                    <input id="username" name="username" type="text" placeholder="请输入用户名">
                    <span class="del rR"></span>
                </div>
            </li>
            <li>
                <div class="password">
	                    <input id="password" name="password" type="password" placeholder="请输入密码">
	                   <!--  <input id="showpassword"  style="display:none;"
	                    name="showpassword" type="text" placeholder="请输入密码"> -->
	                    <span class="eye rR"></span>
                </div>
            </li>
            <li>
                <div class="code lL">
                    <input name="check_code" id="chkcode" type="text" placeholder="输入验证码">
                </div>
                <span >
                	<img class="verification"  id="loginimg" name="loginimg"  src="${app}/checkimg.jsp" 
                	 alt="" >
                </span>
                 <span class="refresh"><img src="${app}/images/refresh.png"
                  style="margin-top: 10px;alt="" onclick="changeCheckIMG()">刷新</span>
            </li>
            <li>
            	<label id="checkError" style="color: red">
		            ${SPRING_SECURITY_LAST_EXCEPTION.message}
		         </label> 
            </li>
            <li>
                <input type="button" value="登录" class="loginBtn" onclick="login()">
            </li>
        </ul>
    </form>
</div>
</div>
<div class="bottom">
    <p>版权所有：铁小二 </p>
</div>
</body>
<script src="${app}/js/login.js"></script>
</html>