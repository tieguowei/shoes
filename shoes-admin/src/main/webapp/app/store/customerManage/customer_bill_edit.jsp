<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>修改账单修改页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="/common/header.jsp"%>
	<script type="text/javascript">
		
		//提交
		function submitForm(){
			var billEditForm = $("#billEditForm");
			billEditForm.form('submit',{
				url:'${app}/customer/updateBill',
				onSubmit:function(){
					if(billEditForm.form("validate")){
						return true;
					}else{
						return false;
					}
				},
				success:function(data){
					var customer_name = $("#customer_name").val();
					closeMask();
					var obj = eval("(" + data + ")");
 	                parent.refreshTab('${app}/customer/toCustomerBillList/'+customer_name ,'账单列表');
 	               parent.closeTab("修改账单");
				}
			});
		}
		
		//取消
		function resetForm(){
			parent.closeTab("修改账单");
		}
		
	function changeMoney(){
		//欠款额 和应还金额 都减去 抹零
		 var small_change = $("#small_change").numberbox("getValue");
		 var balance_due = $("#balance_due").numberbox("getValue");
		 var customary_dues = $("#customary_dues").numberbox("getValue");
		 $("#balance_due").numberbox("setValue",balance_due-small_change);
		 $("#customary_dues").numberbox("setValue",customary_dues-small_change);
	}
		

	</script>
  </head>
  
  <body style="background: white;">
  	<form id="billEditForm" class="easyui-form" method="post" modelAttribute="record">
  		<input type="hidden" id="id" name="id" value="${record.id}"/>
  		  <input type="hidden" id="customer_name" name="customerName" value="${record.customerName}"/>
  		
		<table class="tableForm" border="1" width="100%" >
			<tr>
				<td width="15%" class="tdR">账单时间:</td>
				<td width="35%">
					<input type="text" id="create_time" name="createTime" value="${record.create_time}" class="easyui-textbox" readonly="readonly" style="width: 175px;height: 24px;"/>
				</td>
				<td width="15%" class="tdR">订单开始时间:</td>
				<td width="35%">
					<input type="text" id="bill_start_time" name="billStartTime" value="${record.bill_start_time}" class="easyui-textbox" readonly="readonly" style="width: 175px;height: 24px;"/>
				</td>
			</tr>
			<tr>
				<td width="15%" class="tdR">订单结束时间:</td>
				<td width="35%">
					<input type="text" id="bill_end_time" name="billEndTime" value="${record.bill_end_time}" class="easyui-textbox" readonly="readonly" style="width: 175px;height: 24px;"/>
				</td>
				<td width="15%" class="tdR">抹零（元）:</td>
				<td width="35%">
					<input type="text" data-options="events:{blur:changeMoney}"  min="0"  precision="2"  id="small_change"  name="smallChange" value="${record.small_change}" class="easyui-numberbox"  style="width: 175px;height: 24px;"/>
				</td>
			</tr>
			<tr>
				<td width="15%" class="tdR">欠款额（元）:</td>
				<td width="35%">
					<input type="text" id="balance_due"  precision="2" name="balanceDue" value="${record.balance_due}" class="easyui-numberbox" readonly="readonly" style="width: 175px;height: 24px;"/>
				</td>
				<td width="15%" class="tdR">应还金额（元）:</td>
				<td width="35%">
					<input type="text" id="customary_dues"  precision="2" name="customaryDues" value="${record.customary_dues}" class="easyui-numberbox" readonly="readonly" style="width: 175px;height: 24px;"/>
				</td>
			</tr>
			<tr>
				<td class="tdR">备注:</td>
				<td colspan="3">
					<input id="remark" name="remark" class='easyui-textbox' value="${record.remark}" data-options="multiline:true,validType:['length[0,100]']" style="width:330px;height:60px"/>
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
