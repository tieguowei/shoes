<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>驾校预约车管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<script type="text/javascript">
        var datagrid;
        $(function(){
            datagrid = $('#datagrid').datagrid({
                url : '${app}/jx/getJxList',
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
					field : 'account',
					title : '账号',
					width : 100
				},{
					field : 'password',
					title : '密码',
					width : 100
				},{
					field : 'class_type',
					title : '所学班型',
					width : 100
				},{
					field : 'jx_name',
					title : '预约驾校',
					width : 100
				},{
					field : 'study_time',
					title : '学车时间',
					width : 200
				},{
					field : 'remark',
					title : '备注',
					width : 100
				},{
					field : 'create_time',
					title : '创建时间',
					width : 100
				}
				]],
			});
            
		});
        
        // 跳转到添加新页面页面
   		function toAddJx(){
   			parent.createTab('${app}/jx/toAddJx','添加预约记录');
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
		}
		
		//修改订单
		function toEditJx(){
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
				parent.createTab('${app}/jx/toEditJx/' + rows[0].id,'修改预约记录');
			}else{
				$.messager.show({
					title:'信息提示',
					msg:'请选择要修改的记录!',
					timeout:5000,
					showType:'slide'
				});
			}
		}
		
		//导出预约记录
		function dojxExport(){
				$("#searchForm").attr("action", "${app}/jx/jxDataExport");
	            $("#searchForm").attr("method", "POST");
	            $("#searchForm").submit();
		}
		
	</script>
</head>

<body class="easyui-layout" fit="true" style="width: 100%;height: 100%;">
	<div region="north" border="false" style="height:61px; overflow:hidden;">
  	<form id="searchForm">
		<table border="0" class="searchForm datagrid-toolbar" width="100%">
			<tr>
				<td class="tdR">账号:</td>
				<td>
					<input id="account" name="account" maxlength="28" class='easyui-textbox' style="width: 150px;height: 24px;"/>
				</td>
				<td class="tdR">驾校名称:</td>
				<td>
					<input id="jx_name" name="jxName" maxlength="30" class='easyui-textbox' style="width: 150px;height: 24px;"/>
				</td>
				<td class="tdR">所学班型:</td>
					<td>
						<input id="class_type" name="classType" maxlength="30" class='easyui-textbox' style="width: 150px;height: 24px;"/>
					</td>
				 <td class="tdR">创建时间:</td>
				   <td colspan="3">
					<input id="minCreateTime" name="minCreateTime" editable='false' maxlength="30" class='easyui-datebox' style="width: 105px;height: 24px;" data-options="required:false" placeholder ="--起始时间--"/>
					至
					<input id="maxCreateTime" name="maxCreateTime" editable='false' maxlength="30" class='easyui-datebox' style="width: 105px;height: 24px;" data-options="required:false" placeholder ="--终止时间--"/>
				</td>
			 
			</tr>
			<tr>
				<td colspan="5">
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
			  		<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="toAddJx();">添加</a>
		            <img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
			  		<a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="toEditJx();">修改</a>
					<img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
					<a class="easyui-linkbutton" data-options="iconCls:'icon-redo',plain:true" onclick="dojxExport();"><span style="color: red">导出</span></a>
					<img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
			</td>
		</tr>
	</table>
</div>
</body>
</html>
