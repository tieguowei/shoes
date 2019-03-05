<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>修改页面信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<%@ include file="/common/header.jsp"%>
	<script type="text/javascript">
		//提交
		function submitForm(){
			var pageFrom = $("#pageFrom");
			pageFrom.form('submit',{
				url:'${app}/properties/doUpdateProperties',
				onSubmit:function(){
					if(pageFrom.form("validate")){
						openMask();
						return true;
					}else{
						return false;
					}
				},
				success:function(data){
					closeMask();
					var obj = eval("(" + data + ")");
					parent.refreshTab("${app}/properties/toPropList?messageCode=" + obj.messageCode,"页面管理");
					parent.closeTab("修改页面");
				}
			});
		}
		
		//取消
		function resetForm(){
			parent.closeTab("修改属性页面");
		}
		
	</script>
  </head>
  
  <body style="background: white;">
  	<form id="pageFrom" class="easyui-form" method="post" modelAttribute=ssmProperties>
  		<input type="hidden" name="id" value="${ssmProperties.id}">
		<table class="tableForm" border="0" width="100%">
			<tr>
			    <td class="tdR"><span style="color: red">*</span>属性名称:</td>
				<td align="left">
					<input id="propertyName" name="propertyName" class="easyui-textbox" value="${ssmProperties.propertyName}"  style="width: 175px;height: 24px;"/>&nbsp;&nbsp;
					
				</td>
			</tr>
			<tr>
			    <td class="tdR"><span style="color: red">*</span>属性值(string):</td>
				<td align="left">
					<input id="propertyStringValue" name="propertyStringValue" class="easyui-textbox" value="${ssmProperties.propertyStringValue}"  style="width: 175px;height: 24px;"/>&nbsp;&nbsp;
					
				</td>
			</tr>
			
			<tr>
			    <td class="tdR"><span style="color: red">*</span>属性值(数字):</td>
				<td>
					<input id="propertyFigureValue" name="propertyFigureValue" class="easyui-textbox" value="${ssmProperties.propertyFigureValue}"  style="width: 175px;height: 24px;"/>&nbsp;&nbsp;
					
				</td>
			</tr>
			<tr>
				<td class="tdR"><span style="color: red">*</span>属性描述:</td>
				<td valign="middle">
					<input id="propertyDesc" name="propertyDesc" class='easyui-textbox'  value="${ssmProperties.propertyDesc}"  style="width:330px;height:60px"/>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<a class="easyui-linkbutton" id="submitButton"  iconCls="icon-ok" onclick="submitForm();">提交</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:resetForm();">取消</a>
				</td>
			</tr>
		</table>
	</form>
  </body>
</html>
