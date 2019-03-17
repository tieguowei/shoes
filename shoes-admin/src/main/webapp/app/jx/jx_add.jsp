<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>添加预约记录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<%@ include file="/common/header.jsp"%>
	<script type="text/javascript">
	//添加
		function submitForm(){
			var jxAddForm = $("#jxAddForm");
			jxAddForm.form('submit',{
				url:'${app}/jx/doAddJx',
				onSubmit:function(){
						return true;
				},
				success:function(data){
					closeMask();
					var obj = eval("(" + data + ")");
					parent.refreshTab("${app}/jx/toJxList?messageCode=" + obj.messageCode,"驾校约车管理");
					parent.closeTab("添加预约记录");
				}
			});
		}
		
		//取消
		function resetForm(){
			parent.closeTab("添加预约记录");
		}
		 
	</script>
</head>

 <body style="background: white;">
  	<form id="jxAddForm" class="easyui-form" method="post" modelAttribute="employee">
		<table class="tableForm" border="1" width="100%" >
			<tr>
				<td width="15%" class="tdR"><span style="color: red">*</span>账号:</td>
				<td width="35%">
					<input type="text" id="account" name="account" class="easyui-textbox"  style="width: 150px;height: 24px;"/>
				</td>
				<td class="tdR"><span style="color: red">*</span>密码:</td>
				<td>
				   <input type="text"  id="password" name="password" class="easyui-textbox"   style="width: 150px;height: 24px;"  />
				</td>
			</tr>
			<tr>
				<td class="tdR"><span style="color: red">*</span>所学班型:</td>
				<td>
				   <input type="text"  id="class_type" name="classType" class="easyui-textbox"  style="width: 150px;height: 24px;"  />
				</td>
				<td class="tdR"><span style="color: red">*</span>学车时间:</td>
				<td>
				   <input type="text"  id="study_time" name="studyTime" class="easyui-textbox"  style="width: 150px;height: 24px;"  />
				</td>
			</tr>
			<tr>
				<td class="tdR"><span style="color: red">*</span>驾校名称:</td>
				<td>
				   <input type="text"  id="jx_name" name="jxName" class="easyui-textbox"  style="width: 150px;height: 24px;"  />
				</td>
				<td class="tdR">备注:</td>
				<td colspan="3">
					<input id="remark" name="remark" class='easyui-textbox' data-options="multiline:true,validType:['length[0,50]']" style="width:180px;height:30px"/>
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
