<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>客户付款列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<script type="text/javascript">
        var datagrid;
        $(function(){
            datagrid = $('#datagrid').datagrid({
                url : '${app}/customer/getCustomerPayList',
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
					field : 'customer_name',
					title : '客户姓名',
					width : 200
				},{
					field : 'pay_time',
					title : '付款时间',
					width : 200
				},{
					field : 'bank',
					title : '银行名称',
					width : 200
				},{
					field : 'pay_money',
					title : '付款金额',
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
   		function toAddPay(){
   			parent.createTab('${app}/customer/toAddPay','添加付款流水');
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
		
	</script>
</head>

<body class="easyui-layout" fit="true" style="width: 100%;height: 100%;">
	
<div region="north" border="false" style="height:36px; overflow:hidden;">
  		<form id="searchForm">
	  		<table  border="0" class="searchForm datagrid-toolbar" width="100%">
				<tr>
					<td class="tdR" width="10%">客户姓名:</td>
					<td width="35%">
						<input id="customer_name" name="customerName" class='easyui-textbox' style="width: 150px;height: 24px;"/>
					</td>
					<td width="*%">
						<a class="easyui-linkbutton" iconCls="icon-search" onclick="searchFun()">查询</a>
						<a class="easyui-linkbutton" iconCls="icon-clear" onclick="clearForm(datagrid);">清空</a>
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
			  		<a class="easyui-linkbutton"  data-options="iconCls:'icon-add',plain:true" onclick="toAddPay();">新增付款流水</a>
                    <img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
			</td>
		</tr>
	</table>
</div>
</body>
</html>
