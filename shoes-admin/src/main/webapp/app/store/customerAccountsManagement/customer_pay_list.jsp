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
                url : '${app}/customerPay/getCustomerList',
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
        
        // 跳转到添加新页面页面
   		function toAddFactory(){
   			parent.createTab('${app}/zly/shoeFactory/toAddFactory','123');
   		}
        
   		
        // 跳转到修改控件信息页面
        function toUpdateFactory(rowId) {
            var selectRow = datagrid.datagrid('getSelected');
            if (null == rowId) {
                $.messager.show({
                    title: '信息提示',
                    msg: '请选择一条要修改的记录!',
                    timeout: 5000,
                    showType: 'slide'
                });
            } else if (null != rowId) {
                parent.createTab('${app}/zly/shoeFactory/toUpdateFactory/' + rowId, '修改鞋厂');
            }
        }
	</script>
</head>

<body class="easyui-layout" fit="true" style="width: 100%;height: 100%;">
<div region="center" border="false" style="overflow: hidden;">
	<table id="datagrid"></table>
</div>
<div id="toolbar">
	<table border="0" class="searchForm datagrid-toolbar" width="100%">
		<tr>
			<td width="10%"  id="toolbars" class="tdL">
			  		<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="toAddFactory();">添加</a>
		            <img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
			</td>
		</tr>
	</table>
</div>
</body>
</html>
