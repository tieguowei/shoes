<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>鞋厂汇总页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<script type="text/javascript">
        var datagrid;
        $(function(){
            datagrid = $('#datagrid').datagrid({
                url : '${app}/customer/getCustomerList',
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
					field : 'customer_name',
					title : '客户姓名',
					align: 'center',
					width : 120
				},{
					field : 'customary_dues',
					title : '应还总额（元）',
					align: 'center',
					width : 120
				},{
					field : 'actual_payment',
					title : '实还总额（元）',
					align: 'center',
					width : 120
				},{
					field : 'balance_due',
					title : '欠款总额（元）',
					align: 'center',
					width : 120
				},{
					field : 'small_change',
					title : '抹零总额（元）',
					align: 'center',
					width : 120
				},{
					field : 'defective_goods',
					title : '减次总额（元）',
					align: 'center',
					width : 120
				},{
					field : 'spred_return_money',
					title : '差价/退货总额（元）',
					align: 'center',
					width : 120
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
                parent.createTab('${app}/customer/toCustomerBillList/'+rows[0].customer_name ,'账单列表');
            }else{
                $.messager.show({
                    title:'信息提示',
                    msg:'请选择要查看的客户!',
                    timeout:5000,
                    showType:'slide'
                });
            }
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
			  		<a class="easyui-linkbutton"  data-options="iconCls:'icon-ok',plain:true" onclick="backRecordSelect();">查看账单详情</a>
                    <img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
			</td>
		</tr>
	</table>
</div>
</body>
</html>
