<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>修改客户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="/common/header.jsp"%>
	<script type="text/javascript">
		$(document).ready(function(){
			limit_textarea_input();//统计文本域输入字数
			<!-- 2018-03-08版本 -->
		 	var names = "${empPermission.name}";
			$("#permissionName").html(names); 
		});
		
		//选择部门
		var deptDialog = null;
		function selectDept(){
			deptDialog = $('#deptDialog').dialog({  
				top:100,
				title: "选择部门",   
				width: 450,   
				height: 320,  
				closed: false,   
				cache: false,   
				href: "${app}/department/toSelectDept?deptId=" + $("#deptId").val(),   
				modal: true,
				buttons:[{
					text:'确定',
					iconCls:'icon-ok',
					handler:function(){
						$("#deptId").val($("#selectDeptId").val());//选择部门赋值
						deptDialog.dialog('close');
						getLevelDeptInfo();
					}
				},{
					text:'取消',
					iconCls:'icon-cancel',
					handler:function(){
						deptDialog.dialog('close');
					}
				}]
			}); 
		}
		
		//获得层级部门信息
		function getLevelDeptInfo(){
			$.ajax({
				async:false,
				type:'post',
				url:"${app}/department/getLevelDeptInfo/" + $("#deptId").val(),
				dataType:'html',
				success:function(msg){
					$("#deptName").html(msg);
				}
			});
		}
		
		//提交
		function submitForm(){
			var empEditForm = $("#empEditForm");
			empEditForm.form('submit',{
				url:'${app}/employee/doEditEmp',
				onSubmit:function(){
					if(empEditForm.form("validate")){

						var employeeNo = $("#employeeNo").textbox("getValue")
						if (employeeNo == "" || typeof (employeeNo) == "undefined") {
							$.messager.alert('提示信息', '请输入客户编号', 'info');
							return false;
						} 
							
						openMask();
						return true;
					}else{
						return false;
					}
				},
				success:function(data){
					closeMask();
					var obj = eval("(" + data + ")");
					parent.refreshTab("${app}/employee/toEmpList?messageCode=" + obj.messageCode,"客户管理");
					parent.closeTab("修改客户");
				}
			});
		}
		
		//取消
		function resetForm(){
			parent.closeTab("修改员工");
			$('#searchPrincipal').dialog('close');
		}
		

		//选择权限
		var deptDialog = null;
		function selectPermission(){
			str = $("#permissionIds").val();
			deptDialog = $('#deptDialog').dialog({  
				top:100,
				title: "选择权限",   
				width: 450,   
				height: 320,  
				closed: false,   
				cache: false,   
				href: "${app}/employee/toSelectPermission",   
				modal: true,
				 buttons:[{
					text:'确定',
					iconCls:'icon-ok',
					handler:function(){
						var treeObj = $.fn.zTree.getZTreeObj("treePermission");
						var nodes = treeObj.getCheckedNodes(true);
						var ids = "";
						var names = "";
						for(var i in nodes){
							names+=nodes[i].name+",";
							ids+=nodes[i].id+",";
						}
						var node = treeObj.getNodeByParam("id", 3, null); 
						var flag =false;
						/* flag = getAllChildrenNodes(node,flag);
						if(flag){
							ids+=3;
							ids+=",";
						} */
						var ids=ids.substring(0,ids.length-1);
						var names=names.substring(0,names.length-1);
						initParamsInfo(names);
						$("#permissionIds").val('');
						$("#permissionIds").val(ids);
					}
				},{
					text:'取消',
					iconCls:'icon-cancel',
					handler:function(){
						deptDialog.dialog('close');
					}
				}] ,
				 onLoad: function () {
					 //得到所有的节点
					 var treeObj = $.fn.zTree.getZTreeObj("treePermission");
					 var nodes = treeObj.getNodes();
					 var act=treeObj.transformToArray(nodes);
					 if(str != null && str != ''){
						 var array = str.split(",");
						 //遍历所有选中的节点
						 for(var i=0;i<array.length;i++){
							//遍历所有的节点
							  for(var j=0;j<act.length;j++){
								   if(array[i] == act[j].id){
									   //回显
									   treeObj.checkNode(act[j],true,true);
								  } 
						 	}  
						 }
						
					 }
					 
                 }
			}); 
		}
		
		 //赋值
		function initParamsInfo(names){
			$("#permissionName").html(names);
			$('#deptDialog').dialog('close');
		}
	</script>
  </head>
  
  <body style="background: white;">
  	<form id="empEditForm" class="easyui-form" method="post" modelAttribute="employee">
  		<input type="hidden" id="employeeId" name="employeeId" value="${employee.employeeId}"/>
  		<input type="hidden" id="empOldDeptId" name="empOldDeptId" value="${employee.deptId}"/>
		<table class="tableForm" border="1" width="100%" >
			<tr>
				<td width="15%" class="tdR"><span style="color: red">*</span>姓名:</td>
				<td width="35%">
					<input type="text" id="name" name="name" value="${employee.name}" class="easyui-textbox" data-options="required:true,validType:['length[0,10]']" style="width: 175px;height: 24px;"/>
				</td>
				<td width="15%" class="tdR"><span style="color: red">*</span>性别:</td>
				<td width="35%">
					<input type="radio" id="sex_1" name="sex" value="0" <c:if test="${employee.sex == '0'}">checked</c:if>/><label for="sex_1">男</label>
					<input type="radio" id="sex_2" name="sex" value="1" <c:if test="${employee.sex == '1'}">checked</c:if>/><label for="sex_2">女</label>
				</td>
			</tr>
			<tr>
				<td class="tdR"><span style="color: red">*</span>客户编号:</td>
				<td>
					<input type="text"  id="employeeNo" name="employeeNo" value="${employee.employeeNo}" class='easyui-textbox' data-options="required:true,validType:['length[0,20]']" style="width: 175px;height: 24px;"/>
				</td>
				<td class="tdR">移动电话:</td>
				<td>
					<input type="text" id="mobile" name="mobile" value="${employee.mobile}" class="easyui-numberbox" data-options="validType:['length[0,11]','mobileIsValid']" style="width: 175px;height: 24px;"/>
				</td>
			</tr>
			<tr>
				<td class="tdR"><span style="color: red">*</span>所属部门团队:</td>
				<td >
					<input type="hidden" id="deptId" name="deptId" value="${employee.deptId}"/>
					<span id="deptName" style="padding-left: 5px;">${deptInfo}</span>
					<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="selectDept();">选择部门</a>
				</td>
				<td class="tdR">固定电话:</td>
				<td>
					<input type="text" id="telephone" name="telephone" value="${employee.telephone}" class="easyui-textbox" data-options="validType:['length[0,13]','telephoneIsValid']" style="width: 175px;height: 24px;"/>
					<label style="color: red;">格式：010-56408888</label>
				</td>
			</tr>
			<tr>
				<td class="tdR">备注:</td>
				<td colspan="3">
					<input id="remark" name="remark" class='easyui-textbox' value="${employee.remark}" data-options="multiline:true,validType:['length[0,50]']" style="width:330px;height:60px"/>
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
		<div id="deptDialog"></div>
	</form>
	
  </body>
</html>
