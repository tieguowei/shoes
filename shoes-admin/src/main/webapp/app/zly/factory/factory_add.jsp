<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>添加鞋厂</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<%@ include file="/common/header.jsp"%>
	<script type="text/javascript">
	//添加
   function submitForm(){
		//校验名称是否存在
	   	var name =$("#name").val(); 
		$.ajax({
			url : "${app}/zly/shoeFactory/checkName",
			type : "post",
			dataType : "json",
			data : {
				name : name
			},
			success : function(msg) {
				if (msg != 0) {
					$.messager.alert('提示信息', '该产品已存在!', 'info');
				}else {
					 var name =$("#name").val(); 
					   var factoryForm = $("#factoryForm");
					   factoryForm.form('submit',{
							url:'${app}/zly/shoeFactory/doAddFactory',
							success:function(data){
								closeMask();
								var obj = eval("(" + data + ")");
								parent.refreshTab("${app}/zly/shoeFactory/toPageList?messageCode=" + obj.messageCode,"添加鞋厂");
								parent.closeTab("添加鞋厂");
							}
						});
			   }
			}
		});
			 
	}
		
		//取消
		function resetForm(){
			parent.closeTab("添加信息");
		}
		 //动态增加表格
	   		var index = 2;//添加tr索引
			function addRow() {
				var listIndex = index - 1;
				var $tr = $("<tr id='entourage"+index+"'>"
						  + "<td class='tdR' width='10%'>货号:</td>"
						  + "<td width='15%'><span>"
						  +"<input  style='width: 175px; height: 18px;'  id='itemNo"+listIndex+"' name='itemNo' class='easyui-textbox'"
						+"</span></td>"
					   + +"</tr>");
					var trIndex = index - 1;
					var entourage = '#entourage' + trIndex;
					$(entourage).after($tr);
					index = index + 1;
					$.parser.parse();
	   }
	</script>
</head>

  <body style="background: white;" >
  	<form id="factoryForm" class="easyui-form" method="post" modelAttribute="goldProduct" >
		<table class="tableForm" border="0" width="100%" height: 530px;>
			<tr>
			    <td class="tdR"><span style="color: red">*</span>鞋厂名称:</td>
				<td>
				   <input id="name" name="name"  class="easyui-textbox" prompt="请输入鞋厂名称" data-options="required:true,validType:['name','length[0,30]']" style="width: 175px;height: 24px;"/>&nbsp;&nbsp;
				</td>
			</tr>
			<tr>
			    <td class="tdR">固定电话:</td>
				<td>
				   <input id="telephone" name="telephone"  class="easyui-textbox" prompt="请输入固定电话"  style="width: 175px;height: 24px;"/>&nbsp;&nbsp;
				</td>
			</tr>
			<tr>
			    <td class="tdR">手机号:</td>
				<td>
				   <input id="mobile" name="mobile"  class="easyui-textbox" prompt="请输入手机号" style="width: 175px;height: 24px;"/>&nbsp;&nbsp;
				</td>
			</tr>
			<tr id="entourage1">
					<td class="tdR" width="10%">货号:</td>
					<td width="15%">
					<input id="itemNo" name="itemNo" class='easyui-textbox' style="width: 175px; height: 20px;" prompt="请输入货号"/>
				    </td>
					<td width="5%"><a class="easyui-linkbutton" style="min-width: 15px;" data-options="iconCls:'l-btn-icon icon-add'" onclick="addRow();">新增货号</a>
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
