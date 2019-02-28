<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
    <title>帮助</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <script src="${pageContext.request.contextPath }/echarts/js/jquery-1.8.3.min.js"></script>
    <link rel="icon" href="${pageContext.request.contextPath }/images/favicon.ico">
    <meta content="yes" name="apple-mobile-web-app-capable"/>
    <meta content="yes" name="apple-touch-fullscreen"/>
    <meta content="telephone=no,email=no" name="format-detection"/>
    <meta name="App-Config" content="fullscreen=yes,useHistoryState=yes,transition=yes"/>
    <meta name="viewport" content="target-densitydpi=320,width=640,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/help/css/base.css">
    <style>
        html,body {
            background: #f0f1f8;
        }
    </style>
    
    <script type="text/javascript">
	$(function(){
		$.ajax({
			url:'${pageContext.request.contextPath }/help/getHelpInfo',
			type:'post',
			data:{
				'id':'${id}'
			},
			success:function(jsonMap){
				if(jsonMap.success){
					$('#ques').text(jsonMap.question);
					$('#answer').html(jsonMap.answer);
				}else{
					alert("调用失败")
				}
			}
		})
	})
</script>
    
</head>


<body>
<div class="cockpitAll">
        <div class="container">
            <div class="content">
                <div class="question">
                    <p id="ques"></p>
                </div>
                <div class="answer" id="answer">
                </div>
            </div>
        </div>
    </div>
</body>
</html>