<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>订单管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<script type="text/javascript">
        var datagrid;
        $(function(){
            datagrid = $('#datagrid').datagrid({
                url : '${app}/item/getItemList',
				title : '',
				pagination : true,
				pageSize : <%=Constants.PAGE_SIZE%>,
				pageList : [10,20,30,40,50],
				fit : true,
				toolbar: '#toolbar',
				border : false,
				singleSelect : false,
				idField : 'id',
				columns : [[{
					field:'id',
					checkbox:true
				},{
					field:'rowNumbers',
				    title: '序号',
				    align: 'center',
				    width: 50,
				    formatter: function(val,rec,index){
						var op = $('#datagrid').datagrid('options');
					    return op.pageSize * (op.pageNumber - 1) + (index + 1);
					}
				},{
					field : 'pay_time',
					title : '发货时间',
					width : 100
				},{
					field : 'customer_name',
					title : '客户姓名',
					width : 100
				},{
					field : 'factory_name',
					title : '鞋厂名称',
					width : 100
				},{
					field : 'item_no',
					title : '货号',
					width : 100
				},{
					field : 'number_packages',
					title : '件数',
					width : 100
				},{
					field : 'shoe_dual',
					title : '每件双数',
					width : 100
				},{
					field : 'sale_price',
					title : '单价(元)',
					width : 100
				},{
					field : 'price_spread',
					title : '差价(元)',
					width : 110
				},{
					field : 'difference_number',
					title : '差价双数',
					width : 110
				},{
					field : 'returns_number',
					title : '退货双数',
					width : 100
				},{
					field : 'totalMoney',
					title : '合计(元)',
					width : 100
				},{
					field : 'customer_is_defective_goods',
					title : '客户是否减次',
					width : 100
				},{
					field : 'factory_is_defective_goods',
					title : '鞋厂是否减次',
					width : 100
				},{
					field : 'season',
					title : '季节',
					width : 100
				},{
					field : 'remark',
					title : '备注',
					width : 200
				}
				]],
			});
            
            //限制输入发货时间 结束时间 >= 开始时间
            $("#minCreateTime").datebox({  
                onSelect : function(beginDate){  
                    $('#maxCreateTime').datebox().datebox('calendar').calendar({  
                        validator: function(date){
                        	var now = new Date();
                            return beginDate<=date && date <= now &&  beginDate <=now ;  
                        }  
                    });  
                }  
            });  
            	//结束时间<= 当前时间
            $('#maxCreateTime').datebox().datebox('calendar').calendar({  
                validator: function(date){
                	var now = new Date();
                	return date <= now; 
                }  
            });  
            
          //开始时间<= 当前时间
            $('#minCreateTime').datebox().datebox('calendar').calendar({  
                validator: function(date){
                	var now = new Date();
                	return date <= now; 
                }  
            });  	
            	
            
            
		});
        
        // 跳转到添加新页面页面
   		function toAddItem(){
   			parent.createTab('${app}/item/toAddItem','添加订单');
   		}
   		
        
    	//搜索
		function searchFun() {
			datagrid.datagrid('load',serializeObject($("#searchForm")));
			datagrid.datagrid('clearSelections');
			datagrid.datagrid('clearChecked');
		}
    	
		//清空
		function clearFromFun(datagrid){
			clearForm(datagrid);
            $('#season').combobox('clear');//清空选中项
            $('#factory_is_defective_goods').combobox('clear');
            $('#customer_is_defective_goods').combobox('clear');
            
		}
		
		//修改订单
		function toEditItem(){
			var rows = datagrid.datagrid('getSelections');
			if(rows.length > 0){
				if(rows.length > 1){
					$.messager.show({
						title:'信息提示',
						msg:'该操作只能选择一条记录!',
						timeout:5000,
						showType:'slide'
					});
					return;
				}
				parent.createTab('${app}/item/toEditItem/' + rows[0].id,'修改订单');
			}else{
				$.messager.show({
					title:'信息提示',
					msg:'请选择要修改的记录!',
					timeout:5000,
					showType:'slide'
				});
			}
		}
		
		//客户账单导出
		function doCustomerExport(){
			//客户姓名
			var customerName = $("#customer_name").textbox("getValue")
			if (customerName == ""|| typeof (customerName) == "undefined") {
				$.messager.alert('提示信息', '请在左上方搜索框输入客户姓名！', 'info');
				return false;
			}  
			 //发货时间
			var minCreateTime =$("#minCreateTime").datebox('getValue');
			var maxCreateTime =$("#maxCreateTime").datebox('getValue');
			 if (minCreateTime == "" || maxCreateTime == "") {
				$.messager.alert('提示信息', '请输入发货起止时间！', 'info');
				return false;
			}  
			 $.ajax({
	   				url : "${app}/item/checkCustomerItemIsOver",
					type : "post",
					dataType : "json",
					data:{
						"customerName" : customerName,
						"minCreateTime" : minCreateTime,
						"maxCreateTime":maxCreateTime
					},
					success : function(data){
						if(data){
							$.messager.confirm("请确认", "您确定要导出【"+customerName+"】在此时间段的账单吗？", function(b){
								if(b){
									$("#searchForm").attr("action", "${app}/item/doCustomerExport");
									$("#searchForm").attr("method", "POST");
									$("#searchForm").submit();
								}
							});
						}else{
							$.messager.alert('提示信息', '客户【'+customerName+" 】在此时间段内订单已处理完毕！", 'info');
						}
					},		
					});
		}
	</script>
</head>

<body class="easyui-layout" fit="true" style="width: 100%;height: 100%;">
	<div region="north" border="false" style="height:61px; overflow:hidden;">
  	<form id="searchForm">
		<table border="0" class="searchForm datagrid-toolbar" width="100%">
			<tr>
				<td class="tdR">客户姓名:</td>
				<td>
					<input id="customer_name" name="customerName" maxlength="28" class='easyui-textbox' style="width: 150px;height: 24px;"/>
				</td>
				<td class="tdR">鞋厂名称:</td>
				<td>
					<input id="factory_name" name="factoryName" maxlength="30" class='easyui-textbox' style="width: 150px;height: 24px;"/>
				</td>
				
				 <td class="tdR">发货时间:</td>
				   <td colspan="3">
					<input id="minCreateTime" name="minCreateTime" editable='false' maxlength="30" class='easyui-datebox' style="width: 105px;height: 24px;" data-options="required:false" placeholder ="--起始时间--"/>
					至
					<input id="maxCreateTime" name="maxCreateTime" editable='false' maxlength="30" class='easyui-datebox' style="width: 105px;height: 24px;" data-options="required:false" placeholder ="--终止时间--"/>
				</td>
			
			 <td class="tdR">季节:</td>
				<td>
					<select id="season" name="season" class="easyui-combobox"  panelHeight="130px" editable="false" style="width: 130px;">
						    <option value="">全部</option>
							<option value="0">冬季</option>
							<option value="1">其他季节</option>
					</select>
				</td>
			</tr>
			<tr>
			  
				<td class="tdR">客户是否减次:</td>
				<td>
					<select id="customer_is_defective_goods" name="customerIsDefectiveGoods" class="easyui-combobox"  panelHeight="130px" editable="false" style="width: 150px;">
						    <option value="">全部</option>
							<option value="0">是</option>
							<option value="1">否</option>
					</select>
				</td>
				
				<td class="tdR">厂家是否减次:</td>
				<td>
					<select id="factory_is_defective_goods" name="factoryIsDefectiveGoods" class="easyui-combobox"  panelHeight="130px" editable="false" style="width: 150px;">
						    <option value="">全部</option>
							<option value="0">是</option>
							<option value="1">否</option>
					</select>
				</td>
				<td colspan="5" style="padding-left: 60px;">
						<a class="easyui-linkbutton" iconCls="icon-search" onclick="searchFun()">查询</a>
						<a class="easyui-linkbutton" iconCls="icon-clear" onclick="clearFromFun(datagrid);">清空</a>
				</td>
			</tr>
		</table>
	</form>
	</div>
<div region="center" border="false" style="overflow: hidden;">
	<table id="datagrid"></table>
</div>
<div id="toolbar">
	<table border="0" class="searchForm datagrid-toolbar" width="100%">
		<tr>
			<td width="10%"  id="toolbars" class="tdL">
			  		<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="toAddItem();">添加订单</a>
		            <img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
			  		<a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="toEditItem();">修改订单</a>
					<img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
					<a class="easyui-linkbutton" data-options="iconCls:'icon-redo',plain:true" onclick="doCustomerExport();"><span style="color: red">客户账单导出</span></a>
					<img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
					<a class="easyui-linkbutton" data-options="iconCls:'icon-redo',plain:true" onclick="doFactoryExport();">鞋厂账单导出</a>
					<img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
			</td>
		</tr>
	</table>
</div>
</body>
</html>
