<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>添加订单</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<%@ include file="/common/header.jsp"%>
	<script type="text/javascript">
	 $(function(){
         //发货时间<= 当前时间
           $('#pay_time').datebox().datebox('calendar').calendar({  
               validator: function(date){
               	var now = new Date();
               	return date <= now; 
               }  
           });  	
           
		});
	//添加
		function submitForm(){
			var payAddForm = $("#payAddForm");
			payAddForm.form('submit',{
				url:'${app}/customer/doAddPay',
				onSubmit:function(){
					if(itemAddForm.form("validate")){
						 //发货时间
						var pay_time =$("#pay_time").datebox('getValue');
						if (pay_time == ""|| typeof (pay_time) == "undefined") {
							$.messager.alert('提示信息', '付款时间不能为空！', 'info');
							return false;
						}  
						//银行名称
						var bank = $("#bank").textbox("getValue")
						if (bank == ""|| typeof (bank) == "undefined") {
							$.messager.alert('提示信息', '银行名称不能为空！', 'info');
							return false;
						}  
						
						//付款金额
						var pay_money = $("#pay_money").numberbox("getValue")
						if (pay_money == "" || typeof (pay_money) == "undefined") {
							$.messager.alert('提示信息', '付款金额不能为空！', 'info');
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
					parent.refreshTab("${app}/customer/toCustomerPayList?messageCode=" + obj.messageCode,"添加付款流水");
					parent.closeTab("添加付款流水");
				}
			});
		}
		
		//取消
		function resetForm(){
			parent.closeTab("添加付款流水");
		}
		 
	</script>
</head>

 <body style="background: white;">
  	<form id="payAddForm" class="easyui-form" method="post" modelAttribute="pay">
		<table class="tableForm" border="1" width="100%" >
			<tr>
				<td width="15%" class="tdR"><span style="color: red">*</span>付款时间:</td>
                <td>
                    <input id="pay_time" name="payTime"   maxlength="30"
                     class='easyui-datebox' style="width: 150px;height: 24px;" data-options="prompt:'请选择付款日期',editable:false"/>
                </td>
				<td width="15%" class="tdR"><span style="color: red">*</span>银行名称:</td>
				<td width="35%">
					<input type="text" id="bank" name="bank" class="easyui-textbox"  style="width: 150px;height: 24px;"/>
				</td>
			</tr>
			<tr>
			<td class="tdR"><span style="color: red">*</span>付款金额（元）:</td>
				<td>
				   <input type="text"  id="pay_money" precision="2" name="payMoney" class="easyui-numberbox"  min="0" style="width: 150px;height: 24px;"  />
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
