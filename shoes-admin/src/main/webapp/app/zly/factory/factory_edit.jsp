<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>修改信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<%@ include file="/common/header.jsp"%>
	<script type="text/javascript">
	//提交
	function submitForm(){
	   var name =$("#name").val(); 
	   var id ='${factory.id}';
	 	 $.ajax({
				url : "${app}/zly/shoeFactory/checkName",
				type : "post",
				dataType : "json",
				data : {
					name : name,
					id:id
				},
				success : function(msg) {
					if (msg != 0) {
						$.messager.alert('提示信息', '该产品已存在!', 'info');
						return false;
					} else {  
						var factoryFrom = $("#factoryFrom");
						factoryFrom.form('submit', {
							url : '${app}/zly/shoeFactory/doUpdateFactory',
							success : function(data) {
								var obj = eval("(" + data + ")");
								parent.refreshTab(
										"${app}//zly/shoeFactory/toPageList?messageCode="+ obj.messageCode, "修改信息");
								parent.closeTab("修改鞋厂");
							}
						});		
					}
				},
				error : function() {
					$.messager.show({
						title : '提示',
						msg : '系统错误，请联系管理员------'
					});
				}
			}); 
		}
	//取消
	function resetForm() {
		parent.closeTab("修改鞋厂");
	}
	 
	 
	 //动态增加表格
	   		var index = 2;//添加tr索引
			function addRow() {
				var listIndex = index - 1;
				var $tr = $("<tr id='entourage"+index+"'>"
						  + "<td class='tdR' width='10%'>货号:</td>"
						  + "<td width='15%'><span>"
						  +"<input  style='width: 175px; height: 18px;'  id='itemNo"+listIndex+"' name='itemNo' class='easyui-textbox'"
						+"</span></td>"
					   + +"</tr>");
					var trIndex = index - 1;
					var entourage = '#entourage' + trIndex;
					$(entourage).after($tr);
					index = index + 1;
					$.parser.parse();
	   }

</script>
 </head>
  
  <body style="background: white;">
  	   <form id="factoryFrom" class="easyui-form" method="post" modelAttribute="goldProduct" enctype="multipart/form-data">
  		<input type="hidden"  name="id" value="${factory.id}">
		<table class="tableForm" border="0" width="100%"> 
  	         <tr>
			    <td class="tdR"><span style="color: red">*</span>鞋厂名称:</td>
				<td>
					<input id="name" name="name" value="${factory.name}"   class="easyui-textbox" prompt="请输入鞋厂名称" data-options="required:true" style="width: 175px;height: 24px;"/>&nbsp;&nbsp;
				</td>
			</tr>
			 <tr>
			    <td class="tdR">固定电话:</td>
				<td>
					<input id="telephone" name="telephone" value="${factory.telephone}"   class="easyui-textbox" prompt="请输入固定电话"  style="width: 175px;height: 24px;"/>&nbsp;&nbsp;
				</td>
			</tr>
			 <tr>
			    <td class="tdR">手机号:</td>
				<td>
					<input id="mobile" name="mobile" value="${factory.mobile}"   class="easyui-textbox" prompt="请输入手机号"  style="width: 175px;height: 24px;"/>&nbsp;&nbsp;
				</td>
				 </td>
					<td width="5%"  width='15%'><a class="easyui-linkbutton" style="min-width: 35px;" data-options="iconCls:'l-btn-icon icon-add'" onclick="addRow();">新增</a>
			     </td>
			</tr>
			
		<tbody>
	        <c:forEach items="${list}" var="base"> 
              <tr >
       			 <td class='tdR'  width='15%'>货号:</td>
					<td >
				   <input type="text" value='${base.itemNo}' id='itemNo"+listIndex+"' name='itemNo'  class="easyui-numbox"   style="width: 150px;height: 20px;"   placeholder='请输入huoha'/>
					</td>
					<td >
            		 	<input type="hidden" value='${base.id}' id='id' name='id' />
            		</td>
			</tr> 
            </c:forEach>
            
          <tr id="entourage1">
           </tr> 
          <tr>
				<td colspan="4" align="center">
					<a class="easyui-linkbutton" id="submitButton"  iconCls="icon-ok" onclick="submitForm();">提交</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:resetForm();">取消</a>
				</td>
			</tr>
          </tbody>
	</table>
	
  </form>
  </body>
</html>
