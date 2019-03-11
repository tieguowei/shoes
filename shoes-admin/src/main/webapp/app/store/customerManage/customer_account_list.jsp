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
		
		//修改备注
		function toEditAccount(){
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
				
				//获取账户信息
				$.ajax({
					url : "${app}/customer/getAccountById",
					type : "post",
					dataType : "json",
					data:{"id":rows[0].id},
					success : function(data){
							$("#id").val(data.id);
							$("#remark").textbox("setValue",data.remark);
							document.getElementById("updateRemark").style.display = "block";
					        $('#updateRemark').dialog({
					            title: '修改备注',
					            width: 400,
					            height: 150,
					            closed: false,
					            left:300,
					            top: 95
					        });
					}
				});
			}else{
				$.messager.show({
					title:'信息提示',
					msg:'请选择要修改的记录!',
					timeout:5000,
					showType:'slide'
				});
			}
		}
		function doEditRemark(){
			var id = $("#id").val();
			var remark =  $("#remark").textbox("getValue");
			$.ajax({
				url : "${app}/customer/doEditRemark",
				type : "post",
				dataType : "json",
				data:{"id":id,"remark":remark},
				success : function(data){
					if(data){
						location.href="${app}/customer/toCustomerAccountList";
					}else{
						$.messager.alert('提示信息', '修改失败！', 'info');
					}
			 }
			});
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
			  		<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="toEditAccount();">修改备注</a>
		            <img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
			</td>
		</tr>
	</table>
</div>

<!-- 修改备注 -->
 		<div id="updateRemark"  style="display: none;overflow: hidden;" >
 			 	<input type="hidden" id="id" name="id"/>
	 			<input id="remark" name="remark" class='easyui-textbox' data-options="multiline:true,validType:['length[0,100]']" style="width:380px;height:60px;margin-top: 50px;"/>
  				<a style="margin-left: 120px;margin-top: 20px;" class="easyui-linkbutton" iconCls="icon-ok" onclick="doEditRemark()">提交</a>
 		</div>
</body>
</html>
