<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>修改鞋厂取货记录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<%@ include file="/common/header.jsp"%>
	<script type="text/javascript">
	 $(function(){
         //取货时间<= 当前时间
           $('#time').datebox().datebox('calendar').calendar({  
               validator: function(date){
               	var now = new Date();
               	return date <= now; 
               }  
           });  	
           
		});
	//修改
		function submitForm(){
			var pickAddForm = $("#pickAddForm");
			pickAddForm.form('submit',{
				url:'${app}/factory/doEditPick',
				onSubmit:function(){
					if(pickAddForm.form("validate")){
						//鞋厂名称
						var factory_name = $("#factory_name").textbox("getValue")
						if (factory_name == "" || typeof (factory_name) == "undefined") {
							$.messager.alert('提示信息', '鞋厂名称不能为空！', 'info');
							return false;
						} 
						 //取货时间
						var time =$("#time").datebox('getValue');
						if (time == ""|| typeof (time) == "undefined") {
							$.messager.alert('提示信息', '取货时间不能为空！', 'info');
							return false;
						}  
						//金额
						var money = $("#money").numberbox("getValue")
						if (money == "" || typeof (money) == "undefined") {
							$.messager.alert('提示信息', '取货金额不能为空！', 'info');
							return false;
						}  
						return true;
					}else{
						return false;
					}
				},
				success:function(data){
					closeMask();
					var obj = eval("(" + data + ")");
					parent.refreshTab("${app}/factory/toFactoryPickList?messageCode=" + obj.messageCode,"鞋厂取货记录");
					parent.closeTab("修改取货记录");
				}
			});
		}
		
		//取消
		function resetForm(){
			parent.closeTab("修改取货记录");
		}
		 
	</script>
</head>

 <body style="background: white;">
  	<form id="pickAddForm" class="easyui-form" method="post" modelAttribute="employee">
		<table class="tableForm" border="1" width="100%" >
							<input type="text" id="id" name="id" value="${goods.id}"/>
			<tr>
			<td width="15%" class="tdR"><span style="color: red">*</span>鞋厂名称:</td>
				<td width="35%">
					<input type="text" id="factory_name" name="factoryName" value="${goods.factory_name}" class="easyui-textbox"  style="width: 150px;height: 24px;"/>
				</td>
				<td width="15%" class="tdR"><span style="color: red">*</span>取货时间:</td>
                <td>
                    <input id="time" name="time"   maxlength="30"
                     class='easyui-datebox' style="width: 150px;height: 24px;" value="${goods.time}" data-options="prompt:'请选择取货日期',editable:false"/>
                </td>
			</tr>
			<tr>
			<td class="tdR"><span style="color: red">*</span>金额（元）:</td>
				<td>
				   <input type="text"  id="money" precision="2" name="money"  value="${goods.money}" class="easyui-numberbox"  min="0" style="width: 150px;height: 24px;"  />
				</td>
				<td class="tdR">备注:</td>
				<td>
					<input id="remark" name="remark" class='easyui-textbox'value="${goods.remark}"  data-options="multiline:true,validType:['length[0,100]']" style="width:375px;height:30px"/>
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
