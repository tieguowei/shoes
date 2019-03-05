<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>后台属性信息列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
<script type="text/javascript">
		var datagrid;
		$(function(){
			datagrid = $('#datagrid').datagrid({
				url : '${app}/properties/propertiesesPages',
				title : '',
				pagination : true,
				pageSize : <%=Constants.PAGE_SIZE%>,
				pageList : [10,20,30,40,50],
				fit : true,
				toolbar:"#toolbar",
				border : false,
				idField : 'id',
				singleSelect:true,
				columns : [[{
					field:'ck',
					checkbox:true
				},{
					field : 'property_name',
					title : '属性名称',
					width : 160
				},{
					field : 'property_string_value',
					title : 'string类型的属性值',
					width : 200
				},{
					field : 'property_figure_value',
					title : '数字类型的属性值',
					width : 210
				},{
					field : 'property_desc',
					title : '属性描述',
					width : 140
				},{
					field : 'update_time',
					title : '最后修改时间',
					width : 140
				}]]
			});
		});
		// 搜索
		function searchFun() {
			datagrid.datagrid('load',serializeObject($("#searchForm")));
			datagrid.datagrid('clearSelections');
			datagrid.datagrid('clearChecked');
		}
		
		// 跳转到添加新页面页面
		function toAddPage(){
			parent.createTab('${app}/properties/toAddPropertieses','添加页面');
		}
		
		// 跳转到修改页面信息页面
		function toUpdatePage(){
			var selectRow = datagrid.datagrid('getSelected');
			if(null == selectRow){
				$.messager.show({
					title:'信息提示',
					msg:'请选择一个要修改的页面!',
					timeout:5000,
					showType:'slide'
				});
			}else if(null != selectRow){
				parent.createTab('${app}/properties/toUpdateProperties/' + selectRow.id,'修改属性页面');
			}
		}
		
		
	</script>
  </head>
  
  <body class="easyui-layout" fit="true" style="width: 100%;height: 100%;">
  	<div region="north" border="false" style="height:36px; overflow:hidden;">
  		<form id="searchForm">
	  		<table  border="0" class="searchForm datagrid-toolbar" width="100%">
				<tr>
					<td class="tdR" width="10%">属性名称:</td>
					<td width="35%">
						<input id="propertyName" name="propertyName" class='easyui-textbox' style="width: 150px;height: 24px;"/>
					</td>
					<td class="tdR" width="10%">属性值:</td>
					<td width="25%">
						<input id="propertyStringValue" name="propertyStringValue" class='easyui-textbox' style="width: 150px;height: 24px;"/>
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
 	<div id="toolbar" style="display: none;">
  		<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="toAddPage();">添加</a>
		<img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
  		<a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="toUpdatePage();">修改</a>
		<img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
  	
	</div>
  </body>
</html>
