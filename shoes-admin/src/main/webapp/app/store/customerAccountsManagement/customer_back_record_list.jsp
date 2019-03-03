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
                url : '${app}/customerPay/customerBackRecordSelect',
                queryParams: { 'customerName': '${customerName}' },
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
				    width: 80,
				    formatter: function(val,rec,index){
						var op = $('#datagrid').datagrid('options');
					    return op.pageSize * (op.pageNumber - 1) + (index + 1);
					}
				},{
					field : 'billStartTime',
					title : '账单开始时间',
					align: 'center',
					width : 150
				},{
					field : 'billEndTime',
					title : '账单结束时间',
					align: 'center',
					width : 150
				},{
					field : 'customaryDues',
					title : '本次账单应还金额（元）',
					align: 'center',
					width : 150
				}
				,{
                    field : 'actualPayment',
                    title : '本次账单实还金额（元）',
                    align: 'center',
                    width : 150
                }
                ,{
                    field : 'balanceDue',
                    title : '本次账单欠款（元）',
                    align: 'center',
                    width : 150
                }
                ,{
                    field : 'snallChange',
                    title : '本次账单抹零（元）',
                    align: 'center',
                    width : 150
                }
                ,{
                    field : 'defectiveGoods',
                    title : '本次账单减次（元）',
                    align: 'center',
                    width : 150
                }
				]],
			});
		});

		 //修改回款记录
        function updateBackRecord(){
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
                parent.createTab('${app}/customerPay/updateCustomerBackRecorde/' + rows[0].id,'回款记录更新');
            }else{
                $.messager.show({
                    title:'信息提示',
                    msg:'请选择要更新的记录!',
                    timeout:5000,
                    showType:'slide'
                });
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
			  		<a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="updateBackRecord();">回款记录更新</a>
                    <img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
			</td>
		</tr>
	</table>
</div>
</body>
</html>
