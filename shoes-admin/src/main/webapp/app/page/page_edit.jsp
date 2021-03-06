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
				url:'${app}/page/doUpdatePage',
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
					parent.refreshTab("${app}/page/toPageList?messageCode=" + obj.messageCode,"页面管理");
					parent.closeTab("修改页面");
				}
			});
		}
		
		//取消
		function resetForm(){
			parent.closeTab("修改页面");
		}
		
	</script>
  </head>
  
  <body style="background: white;">
  	<form id="pageFrom" class="easyui-form" method="post" modelAttribute="page">
  		<input type="hidden" name="pageId" value="${page.pageId}">
		<table class="tableForm" border="0" width="100%">
			<tr>
			    <td class="tdR"><span style="color: red">*</span>页面中文名:</td>
				<td align="left">
					<input id="pageName" name="pageName" class="easyui-textbox" value="${page.pageName}" data-options="required:true" style="width: 175px;height: 24px;"/>&nbsp;&nbsp;
					<span style="color: red;">页面中文名，请输入汉字！</span>
				</td>
			</tr>
			<tr>
			    <td class="tdR"><span style="color: red">*</span>页面唯一标识:</td>
				<td align="left">
					<input id="pageMark" name="pageMark" class="easyui-textbox" value="${page.pageMark}" data-options="required:true,validType:['length[0,30]','letterNumUnderlineRule']" style="width: 175px;height: 24px;"/>&nbsp;&nbsp;
					<span style="color: red;">页面唯一标识必须是由字母、数字、下划线组成的字符串！</span>
				</td>
			</tr>
			<tr>
				<td class="tdR"><span style="color: red">*</span>页面描述:</td>
				<td valign="middle">
					<input id="remark" name="remark" class='easyui-textbox' value="${page.remark}" data-options="required:true,multiline:true,validType:['length[0,100]']" style="width:330px;height:60px"/>
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
