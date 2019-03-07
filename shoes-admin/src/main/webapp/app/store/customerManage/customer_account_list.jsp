<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>客户账户列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<script type="text/javascript">
        var datagrid;
        $(function(){
            datagrid = $('#datagrid').datagrid({
                url : '${app}/customer/getCustomerAccountList',
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
					field : 'balance',
					title : '账户余额',
					width : 200
				},{
					field : 'create_time',
					title : '创建时间',
					width : 200
				},{
                    field : 'remark',
                    title : '备注',
                    align: 'center',
                    width : 300,
                    formatter: function(value,row,index){
						if(null == value){
							 return "";
						}
                   return "<span title='"+ value +"'>"+value+"</span>";
                }}
				]],
			});
            
            
            
		});
        
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
</body>
</html>
