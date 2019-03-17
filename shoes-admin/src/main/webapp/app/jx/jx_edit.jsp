<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>修改订单</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<%@ include file="/common/header.jsp"%>
	<script type="text/javascript">
   //提交
		function submitForm(){
			var jxEditForm = $("#jxEditForm");
			jxEditForm.form('submit',{
				url:'${app}/jx/doEditJx',
				onSubmit:function(){
						return true;
				},
				success:function(data){
					closeMask();
					var obj = eval("(" + data + ")");
					parent.refreshTab("${app}/jx/toJxList?messageCode=" + obj.messageCode,"驾校约车管理");
					parent.closeTab("修改预约记录");
				}
			});
		}
		
		//取消
		function resetForm(){
			parent.closeTab("修改预约记录");
		}
		 
	</script>
</head>

  <body style="background: white;">
  	<form id="jxEditForm" class="easyui-form" method="post" modelAttribute="student">
		<table class="tableForm" border="1" width="100%" >
				<input type="hidden" id="id" name="id" value="${student.id}"/>
			<tr>
				<td width="15%" class="tdR"><span style="color: red">*</span>账号:</td>
				<td width="35%">
					<input type="text" id="account" name="account" value="${student.account }" class="easyui-textbox"  style="width: 150px;height: 24px;"/>
				</td>
				<td class="tdR"><span style="color: red">*</span>密码:</td>
				<td>
				   <input type="text"  id="password" name="password" value="${student.password }" class="easyui-textbox"   style="width: 150px;height: 24px;"  />
				</td>
			</tr>
			<tr>
				<td class="tdR"><span style="color: red">*</span>所学班型:</td>
				<td>
				   <input type="text"  id="class_type" name="classType" value="${student.classType}" class="easyui-textbox"  style="width: 150px;height: 24px;"  />
				</td>
				<td class="tdR"><span style="color: red">*</span>学车时间:</td>
				<td>
				   <input type="text"  id="study_time" name="studyTime" value="${student.studyTime}" class="easyui-textbox"  style="width: 150px;height: 24px;"  />
				</td>
			</tr>
			<tr>
				<td class="tdR"><span style="color: red">*</span>驾校名称:</td>
				<td>
				   <input type="text"  id="jx_name" name="jxName" class="easyui-textbox" value="${student.jxName }" style="width: 150px;height: 24px;"  />
				</td>
				<td class="tdR">备注:</td>
				<td colspan="3">
					<input id="remark" name="remark" value="${student.remark }" class='easyui-textbox' data-options="multiline:true,validType:['length[0,50]']" style="width:180px;height:30px"/>
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
