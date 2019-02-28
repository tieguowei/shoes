<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/zTree.jsp"%>
	<script type="text/javascript">
		var zTreeObj = null;
		$(document).ready(function(){
			var setting = {
					data: {
						key:{name: 'name'},
						simpleData: {
							enable: true,
							idKey: 'no',
							pIdKey: 'parent_no'
						}
					},
					view: {
						showTitle: false,
						expandSpeed: 0
					},
					 check : {
				            enable : true,
				            chkboxType : {
				                "Y" : "",
				                "N" : ""
				            },
				            chkStyle: "radio",
				            radioType: "all"
				        },
					callback: {onClick:zTreeOnClick}
			};
			
			var zTreeNodes = null;
			//查询树节点
			$.ajax({
				url : "${app}/app/permissions",
				type : "post",
				dataType : "json",
				async : false,
				success : function(msg){
					if(msg != null && msg.length != 0){
						zTreeNodes = msg;
					}
				},		
				error : function(){
					$.messager.alert("提示信息","系统错误！","info");
				}
			});
			
			zTreeObj = $.fn.zTree.init($("#treePermission"), setting, zTreeNodes);
			 var node = zTreeObj.getNodeByParam("id", 3, null); //将风控设置为不可选中状态
			zTreeObj.setChkDisabled(node, true); 
			zTreeObj.expandAll(false);//全部不展开
			var node = zTreeObj.getNodeByParam("no", "${no}", null);
			zTreeObj.selectNode(node);//选中节点
		});
		
		//节点选中事件
		function zTreeOnClick(event, treeId, treeNode){
			$("#selectDeptId").val(treeNode.no);
		}
	</script>
	<ul id="treePermission" class="ztree"></ul>
