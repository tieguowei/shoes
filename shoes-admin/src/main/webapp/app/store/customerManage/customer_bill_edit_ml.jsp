<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>账单抹零修改页面</title>
    
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
 	               parent.closeTab("账单抹零");
				}
			});
		}
		
		//取消
		function resetForm(){
			parent.closeTab("账单抹零");
		}
		
	
	//抹零逻辑
	function changeMoney(){
		var old_balance_due = $("#old_balance_due").val();//原欠款值
		var  old_customary_dues = $("#old_customary_dues").val();//原应还值
		 var small_change = $("#small_change").numberbox("getValue");//抹零金额
		
		//如果抹零金额 大于原欠款值
		if(parseFloat(small_change) > parseFloat(old_balance_due)){
			$.messager.alert('提示信息', '抹零金额不能超过欠款金额！', 'info');
			 var small_change = $("#small_change").numberbox("setValue",0);//抹零金额清零
			return ;
		}
		//如果抹零金额 等于 原欠款值 账单状态改为 已结清
		if(parseFloat(small_change) == parseFloat(old_balance_due)){
			$("#bill_status").val("0");
		}else{
			$("#bill_status").val("1");
		}
		
		//欠款金额 = 原欠款金额 - 抹零金额
		var newBalanceDue =  old_balance_due-small_change;
		//应还金额 = 原应还金额 -  抹零金额
		var newCustomaryDue = old_customary_dues-small_change
		 $("#balance_due").numberbox("setValue",newBalanceDue);
		 $("#customary_dues").numberbox("setValue",newCustomaryDue);
	}
	</script>
  </head>
  
  <body style="background: white;">
  	<form id="billEditForm" class="easyui-form" method="post" modelAttribute="record">
  		<input type="hidden" id="id" name="id" value="${record.id}"/>
  		  <input type="hidden" id="customer_name" name="customerName" value="${record.customerName}"/>
  		  <!-- 账单状态 -->
  		  <input type="hidden" id="bill_status" name="billStatus" value="${record.billStatus}"/>
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
				<!-- 原欠款额  修改抹零逻辑使用-->
					<input type="hidden" id="old_balance_due"  value="${record.balance_due}"/>
					<input type="text" id="balance_due"  precision="2" name="balanceDue"  value="${record.balance_due}" class="easyui-numberbox"  style="width: 175px;height: 24px;"/>
				</td>
				<td width="15%" class="tdR">应还金额（元）:</td>
				<td width="35%">
				<!-- 原应还金额 -->
					<input type="hidden" id="old_customary_dues" value="${record.customary_dues}" />
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
