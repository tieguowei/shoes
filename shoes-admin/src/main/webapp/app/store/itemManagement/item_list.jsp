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
					title : '双数',
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
					title : '差价件数',
					width : 110
				},{
					field : 'returns_number',
					title : '退货件数',
					width : 100
				},{
					field : 'totalMoney',
					title : '合计(元)',
					width : 100
				}
				]],
			});
            
		});
        
        // 跳转到添加新页面页面
   		function toAddItem(){
   			parent.createTab('${app}/item/toAddItem','添加订单');
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
			  		<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="toAddItem();">添加订单</a>
		            <img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
			</td>
		</tr>
	</table>
</div>
</body>
</html>
