<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>客户取货列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<script type="text/javascript">
        var datagrid;
        $(function(){
            datagrid = $('#datagrid').datagrid({
                url : '${app}/factory/getFactoryPcikList',
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
					field : 'factory_name',
					title : '鞋厂名称',
					align: 'center',
					width : 120
				},{
					field : 'money',
					title : '取货总额（元）',
					align: 'center',
					width : 120
				},{
					field : 'time',
					title : '取货时间',
					align: 'center',
					width : 120
				},{
					field : 'statusZH',
					title : '是否结清',
					align: 'center',
					width : 120
				},{
					field : 'remark',
					title : '备注',
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

        //修改取货记录
        function toEditPick(){
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
                if(rows[0].status == '0'){
                    $.messager.show({
                        title:'信息提示',
                        msg:'已结算账单不能修改!',
                        timeout:5000,
                        showType:'slide'
                    });
                    return;
                }
                parent.createTab('${app}/factory/toEditPick/'+rows[0].id ,'修改取货记录');
            }else{
                $.messager.show({
                    title:'信息提示',
                    msg:'请选择要查看的客户!',
                    timeout:5000,
                    showType:'slide'
                });
            }
        }
        
        // 跳转到添加新页面
   		function toAddPick(){
   			parent.createTab('${app}/factory/toAddPick','添加取货记录');
   		}
   		
	</script>
</head>
<body class="easyui-layout" fit="true" style="width: 100%;height: 100%;">

<div region="north" border="false" style="height:36px; overflow:hidden;">
  		<form id="searchForm">
	  		<table  border="0" class="searchForm datagrid-toolbar" width="100%">
				<tr>
					<td class="tdR" width="10%">鞋厂名称:</td>
					<td width="35%">
						<input id="factory_name" name="factoryName" class='easyui-textbox' style="width: 150px;height: 24px;"/>
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
			  		<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="toAddPick();">添加</a>
		            <img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
			  		<a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="toEditPick();">修改</a>
					<img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
			</td>
		</tr>
	</table>
</div>
</body>
</html>
