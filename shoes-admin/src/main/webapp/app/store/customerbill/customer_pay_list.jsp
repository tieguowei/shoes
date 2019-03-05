<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>客户账单管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<script type="text/javascript">
        var datagrid;
        $(function(){
            datagrid = $('#datagrid').datagrid({
                url : '${app}/customerBill/getCustomerList',
				title : '',
				pagination : true,
				pageSize : <%=Constants.PAGE_SIZE%>,
				pageList : [10,20,30,40,50],
				fit : true,
				toolbar: '#toolbar',
				border : false,
				singleSelect : false,
				idField : 'id',
				columns : [[
				{
					field:'id',
					checkbox:true
				},{
					field:'rowNumbers',
				    title: '序号',
				    align: 'center',
				    width: 150,
				    formatter: function(val,rec,index){
						var op = $('#datagrid').datagrid('options');
					    return op.pageSize * (op.pageNumber - 1) + (index + 1);
					}
				},{
					field : 'customerName',
					title : '客户姓名',
					align: 'center',
					width : 200
				},{
					field : 'totalGoodsMoney',
					title : '总货款',
					align: 'center',
					width : 200
				},{
					field : 'waitBackMoney',
					title : '欠款',
					align: 'center',
					width : 200
				}
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
        }

        //回款记录查询
        function backRecordSelect(){
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
                parent.createTab('${app}/customerBill/customerBackRecordSelectPage/' + rows[0].customerName,'回款记录查询');
            }else{
                $.messager.show({
                    title:'信息提示',
                    msg:'请选择要查询的记录!',
                    timeout:5000,
                    showType:'slide'
                });
            }
        }
	</script>
</head>
<body class="easyui-layout" fit="true" style="width: 100%;height: 100%;">
<div region="north" border="false" align="left" style="height:61px; overflow:hidden; " >
    <form id="searchForm">
    		<table border="0" class="searchForm datagrid-toolbar" width="100%">
    			<tr>
    				<td class="tdR" >客户姓名:</td>
    				<td>
    					<input id="customer_name" name="customerName" maxlength="28" class='easyui-textbox' style="width: 150px;height: 24px;"/>
    				</td>
    			</tr>
    			<tr>
    				<td align="center" colspan="5" >
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
			  		<a class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="backRecordSelect();">回款记录查询</a>
                    <img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
			</td>
		</tr>
	</table>
</div>
</body>
</html>
