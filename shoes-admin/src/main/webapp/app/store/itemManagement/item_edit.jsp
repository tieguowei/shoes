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
	//添加
   //提交
		function submitForm(){
			var itemAddForm = $("#itemAddForm");
			itemAddForm.form('submit',{
				url:'${app}/item/doEditItem',
				onSubmit:function(){
					if(itemAddForm.form("validate")){
						 //发货时间
						var pay_time =$("#pay_time").datebox('getValue');
						if (pay_time == ""|| typeof (pay_time) == "undefined") {
							$.messager.alert('提示信息', '发货时间不能为空！', 'info');
							return false;
						}  
						//客户姓名
						var customer_name = $("#customer_name").textbox("getValue")
						if (customer_name == ""|| typeof (customer_name) == "undefined") {
							$.messager.alert('提示信息', '客户姓名不能为空！', 'info');
							return false;
						}  
						//鞋厂名称
						var factory_name = $("#factory_name").textbox("getValue")
						if (factory_name == "" || typeof (factory_name) == "undefined") {
							$.messager.alert('提示信息', '鞋厂名称不能为空！', 'info');
							return false;
						} 
						
						//货号
						var item_no = $("#item_no").textbox("getValue")
						if (item_no == "" || typeof (item_no) == "undefined") {
							$.messager.alert('提示信息', '货号不能为空！', 'info');
							return false;
						} 
						
						//件数
						var number_packages = $("#number_packages").numberbox("getValue")
						if (number_packages == "" || typeof (number_packages) == "undefined") {
							$.messager.alert('提示信息', '件数不能为空！', 'info');
							return false;
						} 
						
						//双数
						var shoe_dual = $("#shoe_dual").numberbox("getValue")
						if (shoe_dual == "" || typeof (shoe_dual) == "undefined") {
							$.messager.alert('提示信息', '双数不能为空！', 'info');
							return false;
						} 
						
						//单价
						var sale_price = $("#sale_price").numberbox("getValue")
						if (sale_price == "" || typeof (sale_price) == "undefined") {
							$.messager.alert('提示信息', '单价不能为空！', 'info');
							return false;
						}  
						
						var item = $(":radio:checked"); 
						var len=item.length; 
						if (len == 0) {
							$.messager.alert('提示信息', '季节不能为空！', 'info');
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
					parent.refreshTab("${app}/item/toPageList?messageCode=" + obj.messageCode,"修改订单");
					parent.closeTab("修改订单");
				}
			});
		}
		
		//取消
		function resetForm(){
			parent.closeTab("修改订单");
		}
		 
	</script>
</head>

 <body style="background: white;">
  	<form id="itemAddForm" class="easyui-form" method="post" modelAttribute="order">
		<table class="tableForm" border="1" width="100%" >
		  		<input type="hidden" id="id" name="id" value="${order.id}"/>
			<tr>
				<td width="15%" class="tdR"><span style="color: red">*</span>发货时间:</td>
                <td>
                    <input id="pay_time" name="payTime" value="${order.payTime}"  maxlength="30"
                     class='easyui-datebox' style="width: 150px;height: 24px;" data-options="prompt:'请选择发货日期',editable:false"/>
                </td>
				<td width="15%" class="tdR"><span style="color: red">*</span>客户姓名:</td>
				<td width="35%">
					<input type="text" value="${order.customerName}"  id="customer_name" name="customerName" class="easyui-textbox"  style="width: 150px;height: 24px;"/>
				</td>
			</tr>
			<tr>
				<td class="tdR"><span style="color: red">*</span>鞋厂名称:</td>
				<td>
				   <input type="text"  id="factory_name" name="factoryName" value="${order.factoryName}"  class="easyui-textbox"   style="width: 150px;height: 24px;"  />
				</td>
				<td class="tdR"><span style="color: red">*</span>货号:</td>
				<td>
				   <input type="text"  id="item_no" name="itemNo"  value="${order.itemNo}" class="easyui-textbox"  style="width: 150px;height: 24px;"  />
				</td>
			</tr>
			<tr>
				<td class="tdR"><span style="color: red">*</span>件数:</td>
				<td>
				   <input type="text"  id="number_packages" min="0" name="numberPackages" value="${order.numberPackages}" class="easyui-numberbox"   style="width: 150px;height: 24px;"  />
				</td>
				<td class="tdR"><span style="color: red">*</span>每件双数:</td>
				<td>
				   <input type="text"  id="shoe_dual" min="0" name="shoeDual"  value="${order.shoeDual}" class="easyui-numberbox"  style="width: 150px;height: 24px;"  />
				</td>
			</tr>
			<tr>
			<td class="tdR"><span style="color: red">*</span>单价（元）:</td>
				<td>
				   <input type="text"  id="sale_price" min="0" name="salePrice" precision="2" value="${order.salePrice}" class="easyui-numberbox"   style="width: 150px;height: 24px;"  />
				</td>
				<td class="tdR"><span style="color: red">*</span>季节:</td>
				<td>
					  <input type="radio" name="season" <c:if test="${order.season== '0'}">checked="checked"</c:if>>冬季
  					  <input type="radio" name="season" <c:if test="${order.season== '1'}">checked="checked"</c:if>>其他季节
				</td>
			</tr>
			<tr>
				    <td class="tdR">差价（元）:</td>
					<td>
					   <input type="text"  id="price_spread"  min="0" precision="2"  name="priceSpread" value="${order.priceSpread}" class="easyui-numberbox"   style="width: 150px;height: 24px;"  />
					</td>
					<td class="tdR">差价双数:</td>
					<td>
						<input type="text"  id="difference_number" min="0" name="differenceNumber" value="${order.differenceNumber}" class="easyui-numberbox"   style="width: 150px;height: 24px;"  />
					</td>
			</tr>
			<tr>
				    <td class="tdR">退货双数:</td>
					<td>
					   <input type="text"  id="returns_number"  min="0" name="returnsNumber" value="${order.returnsNumber}" class="easyui-numberbox"   style="width: 150px;height: 24px;"  />
					</td>
			</tr>
			<tr>
				<td class="tdR">备注:</td>
				<td colspan="3">
					<input id="remark" value="${order.remark}" name="remark" class='easyui-textbox' data-options="multiline:true,validType:['length[0,50]']" style="width:375px;height:40px"/>
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
