<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>添加鞋厂取货记录</title>
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
			var itemAddForm = $("#itemAddForm");
			itemAddForm.form('submit',{
				url:'${app}/item/doAddItem',
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
					parent.refreshTab("${app}/item/toPageList?messageCode=" + obj.messageCode,"订单流水");
					parent.closeTab("添加订单");
				}
			});
		}
		
		//取消
		function resetForm(){
			parent.closeTab("添加订单");
		}
		 
	</script>
</head>

 <body style="background: white;">
  	<form id="itemAddForm" class="easyui-form" method="post" modelAttribute="employee">
		<table class="tableForm" border="1" width="100%" >
			<tr>
				<td width="15%" class="tdR"><span style="color: red">*</span>发货时间:</td>
                <td>
                    <input id="pay_time" name="payTime"   maxlength="30"
                     class='easyui-datebox' style="width: 150px;height: 24px;" data-options="prompt:'请选择发货日期',editable:false"/>
                </td>
				<td width="15%" class="tdR"><span style="color: red">*</span>客户姓名:</td>
				<td width="35%">
					<input type="text" id="customer_name" name="customerName" class="easyui-textbox"  style="width: 150px;height: 24px;"/>
				   <span style="color: red">如客户重名 请仿照： 张三-13678909090</span>
				</td>
			</tr>
			<tr>
				<td class="tdR"><span style="color: red">*</span>鞋厂名称:</td>
				<td>
				   <input type="text"  id="factory_name" name="factoryName" class="easyui-textbox"   style="width: 150px;height: 24px;"  />
				</td>
				<td class="tdR"><span style="color: red">*</span>货号:</td>
				<td>
				   <input type="text"  id="item_no" name="itemNo" class="easyui-textbox"  style="width: 150px;height: 24px;"  />
				</td>
			</tr>
			<tr>
				<td class="tdR"><span style="color: red">*</span>件数:</td>
				<td>
				   <input type="text"  id="number_packages" name="numberPackages" min="0" class="easyui-numberbox"   style="width: 150px;height: 24px;"  />
				</td>
				<td class="tdR"><span style="color: red">*</span>每件双数:</td>
				<td>
				   <input type="text"  id="shoe_dual" name="shoeDual" class="easyui-numberbox" min="0" style="width: 150px;height: 24px;"  />
				</td>
			</tr>
			<tr>
			<td class="tdR"><span style="color: red">*</span>单价（元）:</td>
				<td>
				   <input type="text"  id="sale_price" precision="2" name="salePrice" class="easyui-numberbox"  min="0" style="width: 150px;height: 24px;"  />
				</td>
				<td class="tdR"><span style="color: red">*</span>季节:</td>
				<td >
					<input type="radio"  name="season" value="0"/>冬季
					<input type="radio"  name="season" value="1"/>其他季节
				</td>
			</tr>
			<tr>
				<td class="tdR">备注:</td>
				<td colspan="3">
					<input id="remark" name="remark" class='easyui-textbox' data-options="multiline:true,validType:['length[0,50]']" style="width:375px;height:40px"/>
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
