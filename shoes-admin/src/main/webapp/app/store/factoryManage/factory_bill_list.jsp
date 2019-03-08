<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>鞋厂账单列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<script type="text/javascript">
        var datagrid;
        $(function(){
            datagrid = $('#datagrid').datagrid({
                url : '${app}/customer/getCustomerBillList',
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
					field : 'createTime',
					title : '账单时间',
					align: 'center',
					width : 120
				},{
					field : 'billStartTime',
					title : '订单开始时间',
					align: 'center',
					width : 120
				},{
					field : 'billEndTime',
					title : '订单结束时间',
					align: 'center',
					width : 120
				},{
					field : 'customaryDues',
					title : '应还金额（元）',
					align: 'center',
					width : 120
				}
				,{
                    field : 'actualPayment',
                    title : '实还金额（元）',
                    align: 'center',
                    width : 120
                }
                ,{
                    field : 'balanceDue',
                    title : '欠款（元）',
                    align: 'center',
                    width : 120
                }
                ,{
                    field : 'smallChange',
                    title : '抹零（元）',
                    align: 'center',
                    width : 120
                },{
                    field : 'defectiveGoods',
                    title : '减次（元）',
                    align: 'center',
                    width : 120
                },{
                    field : 'spredReturnMoney',
                    title : '差价/退货（元）',
                    align: 'center',
                    width : 120
                },{
                    field : 'billStatusZH',
                    title : '是否结清',
                    align: 'center',
                    width : 120
                },{
                    field : 'remark',
                    title : '备注',
                    align: 'center',
                    width : 120,
                    formatter: function(value,row,index){
						if(null == value){
							 return "";
						}
                   return "<span title='"+ value +"'>"+value+"</span>";
                }}
				]],
			});
		});

		 //账单抹零
        function updateML(){
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
                if(rows[0].billStatus == '0'){
                	  $.messager.show({
                          title:'信息提示',
                          msg:'账单已结清 无法修改!',
                          timeout:5000,
                          showType:'slide'
                      });
                      return;
                }
                if(rows[0].smallChange != '0'){
              	  $.messager.show({
                        title:'信息提示',
                        msg:'账单已 有抹零 不能再次抹零!',
                        timeout:5000,
                        showType:'slide'
                    });
                    return;
              }
                parent.createTab('${app}/customer/updateML/' + rows[0].id,'账单抹零');
            }else{
                $.messager.show({
                    title:'信息提示',
                    msg:'请选择要抹零的账单!',
                    timeout:5000,
                    showType:'slide'
                });
            }
        }
		 
		 //修改已付款
        function updateYFK(){
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
                if(rows[0].billStatus == '0'){
                	  $.messager.show({
                          title:'信息提示',
                          msg:'账单已结清 无法修改!',
                          timeout:5000,
                          showType:'slide'
                      });
                      return;
                }
            	$.messager.confirm("请确认", "您确定客户多打款了吗？", function(b){
					if(b){
               			 parent.createTab('${app}/customer/updateYFK/' + rows[0].id,'修改已付款');
					}
				});
            }else{
                $.messager.show({
                    title:'信息提示',
                    msg:'请选择要修改已付款的账单!',
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
			  		<a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="updateML();">账单抹零</a>
                    <img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
			</td>
			<td width="10%"  id="toolbars" class="tdL">
			  		<a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="updateYFK();">修改已付款</a>
                    <img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
			</td>
			<td>
				<span style="color: red">客户：${customerName}</span>
			</td>
		</tr>
	</table>
</div>
</body>
</html>
