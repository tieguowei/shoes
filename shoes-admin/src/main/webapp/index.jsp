<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>鞋业管理系统</title>
		<%@ include file="/common/header.jsp"%>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script src="${app}/js/common/js/tabCommon.js" charset="UTF-8" type="text/javascript"></script>
		<style type="text/css">
		.cs-south {
			height:25px;background:url('${app}/js/jquery-easyui-1.4.1/themes/default/images/ui-bg_fine-grain_15_ffffff_60x60.png') repeat-x;padding:0px;text-align:center;vertical-align: middle;
		}
		</style>
		<script type="text/javascript" charset="utf-8">
			$(function() {
				//加载右键菜单事件
				tabCloseEven();
			});
			
			// 退出系统
			function logout() {
				$.messager.confirm('提示', '您确定要退出当前系统?', function(btn){
					if(btn) {
						window.location.href = "${app}/admin/j_spring_security_logout";
					}
				});
			}
			
			function showHelp(){
				helpDialog.dialog('restore');
				helpDialog.dialog('open');
			}
			
			var helpDialog;
			$(function(){
				helpDialog = $("#helpModel").dialog({
					modal : true,
					iconCls:'icon-help',
					title : '系统帮助',
					width : 450,
					height: 250,
					closable:true,
					border:false
				}).dialog('close');
			});
			
			//修改密码
			function modifyPassword(){
				$('#empPwdWin')[0].style.display = "block";
				$('#empPwdWin').window('open');
			}
			
			function empPwdReset(){
				var empPwdForm = $("#empPwdForm");
				empPwdForm.form('submit',{
					url:'${app}/employee/doUpdatePwd',
					onSubmit:function(){
						if(empPwdForm.form("validate")){
							if(validateBasePwd()){
								if($("#empPwd").val() == $("#basePwd").val()){
									$.messager.alert('提示','新密码不能与原密码一致!');
									return false;
								}else{
									openMask();
									return true;
								}
							}else {
								return false;
							}
						}else{
							return false;
						}
					},
					success:function(data){
						closeMask();
						var obj = eval("(" + data + ")");
						if(obj.requestState == 'true') {
							$.messager.show({
								title:'信息提示',
								msg:'密码修改成功!',
								timeout:5000,
								showType:'slide'
							});
						}else if (obj.requestState=='error'){
							$.messager.show({
								title:'信息提示',
								msg:'系统异常,请与管理员联系!',
								timeout:5000,
								showType:'slide'
							});
						}
						$('#empPwdForm')[0].reset();
						$('#empPwdWin').window('close');
					}
				});
			}
			
			/**
			 * 校验原始密码
			 */
			function validateBasePwd(){
				var retTag = true;
				var basePwd = $("#basePwd").val();
				$.ajax({
					async:false,
					type:'post',
					url:"${app}/employee/validateBasePwd",
					dataType:'json',
					data:{"password":basePwd},
					success:function(obj){
						if(obj.requestState == 'false'){
							$.messager.alert("信息提示", "输入的原密码不正确，请重新输入!", "warning",function(){
								setTimeout(function(){$("#basePwd").focus();},0);
								$("#basePwd").focus();
							});
							retTag = false;
						}else if (obj.requestState == 'error'){
							$.messager.alert("提示信息",'系统繁忙,请稍后再试!');
							retTag = false;
						}
					},
					error:function(){
						$.messager.alert("提示信息",'系统错误');
						retTag = false;
					}
				});
				return retTag;
			}
			
			//取消修改
			function empCancelReset() {
				$('#empPwdForm')[0].reset();
				$('#empPwdWin').window('close');
			}
		</script>
	</head>

	<body class="easyui-layout" style="width: 100%; height: 100%;">
		<div id="head" region="north"  style="width: 100%;height: 12%;">
			<img style="padding-top: 4px" src="${app}/images/shoes.png" />
			 <div style="display: inline-block">
            <h2 style="margin-left: 10px;font-size:22px; font-weight: normal";>鞋业管理系统</h2>
            <p style="padding-left: 6px;font-size: 12px;">一站式管理平台</p>
        </div>
			<ul id="contact">   
		      <li class="dot1">欢迎您，<font  color="dodgerblue"><b>${SystemUser.name}</b></font></li>
		      <li class="dot1"><a href="#" onclick="modifyPassword()">修改密码</a></li>
		      <li class="dot1"><a href="#" onclick="showHelp()">系统帮助</a></li>
		      <li class="dot1"><a href="#" onclick="logout()">退出系统</a></li>
		    </ul>		
		</div>
		<div region="west" split="false" title="导航菜单" border="true" 
			style="width: 13%;height:84%;overflow: auto;" href="${app }/layout/west.jsp"></div>
		<div region="center" border="true" href="${app }/layout/center.jsp" 
			style="overflow:width: 87%;height:84% hidden;"></div>
		<div region="south" border="false" class="cs-south" style="width: 100%;height: 4%"> </div>
		<div id="mm" class="easyui-menu" style="display: none;">  
		    <div id="mm-tabUpdate">刷新</div>
		    <div class="menu-sep"></div>
		    <div id="mm-tabClose">关闭</div>
		    <div id="mm-tabCloseAll">全部关闭</div>
			<div id="mm-tabCloseOther">关闭其他</div>
			<div class="menu-sep"></div>
			<div id="mm-tabLeftCloseAll">当前页左侧全部关闭</div>
			<div id="mm-tabRightCloseAll">当前页右侧全部关闭</div>
		</div>  
		<div id="helpModel">
			<ul>
				<li style="margin-top: 10px;">
					本系统支持火狐、谷歌（Chrome）等浏览器，<font color="red">强烈推荐使用谷歌（Chrome）浏览器</font>，推荐分辨率为1366×768。
				</li>
				<li style="margin-top: 10px;">
					<a style="text-decoration: none;" target="_blank" href="https://www.google.cn/chrome/">谷歌(Chrome)浏览器点击完成下载</a>
				</li> 
			</ul>
  		</div>
  		<!-- 修改密码 -->
  		<div id="empPwdWin" class="easyui-window" closed="true" collapsible="false" minimizable="false" draggable="false" maximizable="false" modal="true" title="修改密码" style="overflow:hidden;padding:10px;width:450px;height:190px;display:none">
  			<form id="empPwdForm" class="easyui-form" method="post">
  				<input type="hidden" id="password" >
  				<input type="hidden" id="newpassword" >
  				<table class="tableForForm" width="100%" border="0">
  					<tr>
  						<td colspan="2" align="center">
  							<label style="color: red;">&nbsp;<b>提示：密码区分大小写，6～20位，可以是字母、数字以及特殊字符。</b></label>
  						</td>
  					</tr>
  					<tr>
  						<td width="20%" align="right"><span style="color: red">*</span>原始密码：</td>
  						<td width="80%">
  							<input class="easyui-validatebox textbox" id="basePwd" name="basePwd" style="width:175px;" onfocus="this.type='password'" maxlength="20" required="true" autocomplete="off" disableautocomplete value=""/>
  						</td>
  					</tr>
  					<tr>
  						<td align="right"><span style="color: red">*</span>新密码：</td>
  						<td>
  							<input class="easyui-validatebox textbox" id="empPwd" name="empPwd" style="width:175px;" onfocus="this.type='password'" autocomplete="off" disableautocomplete required="true" validType="length[6, 20]" maxLength="20" />
  						</td>
  					</tr>
  					<tr>
  						<td align="right"><span style="color: red">*</span>重复密码：</td>
  						<td>
  							<input class="easyui-validatebox textbox" id="empRepeatPwd" name="empRepeatPwd" validType="equalsTo['#empPwd']" style="width:175px;" onfocus="this.type='password'" autocomplete="off" disableautocomplete required="true" maxLength="20"/>
  						</td>
  					</tr>
  					<tr align="center">
						<td colspan="2">
							<a class="easyui-linkbutton" onclick="empPwdReset()">确&nbsp;&nbsp;&nbsp;&nbsp;定</a>&nbsp;&nbsp;&nbsp;&nbsp;
							<a class="easyui-linkbutton" onclick="empCancelReset()">取&nbsp;&nbsp;&nbsp;&nbsp;消</a>
						</td>
					</tr>
  				</table>
  			</form>
  		</div>
	</body>
</html>
