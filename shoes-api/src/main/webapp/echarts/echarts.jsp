<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0, user-scalable=no">
<title>各机构当月累计业绩</title>

<script src="echarts/js/echarts.min.js"></script>
<script src="echarts/js/china.js"></script>
<style type="text/css">
*{ margin:0; padding:0;}
ul,li{list-style:none}

body{ background:#281c62}
#main a{ color:#fff}
/*update 20170525*/
#main div:nth-of-type(2){ left:40px; right:40px;opacity:0.9;}
.map_title{ font-size:16px; color:#fff; font-family:"微软雅黑"; text-align:center; margin:12px 0; }
.map_title cite{ display:block; width:50px; margin:8px auto 0; height:2px; background:#56d7ee; line-height:2; font-size:2px;}
.modal_title{ width:100%; height:32px; text-align:center; line-height:32px; font-size:13px; color:#7a69ea; position:relative; z-index:11;}
.modal_line{ width:100%; height:1px;background:#4d3eb8;}
.modal_title .close{ width:18px; height:18px; position:absolute; right:-8px; top:-8px; background:url(echarts/images/close.png) no-repeat center center; background-size:100%; cursor:pointer}

.pop{
	font-size:14px; line-height:18px; font-family:"微软雅黑"; color:#555; width:100%; height:18px; overflow:hidden;-webkit-overflow-scrolling: touch;padding:8px 0 3px;
}

/*20170518*/
.pop::-webkit-scrollbar{ display:none}
/**/
.pop p{
  height:21px;
  padding:0 15px;
  margin:0;
  line-height:21px;
  font-size:13px;
  color:#d3ccff;
  overflow:hidden;
  zoom:1;	
}
.pop p span{ float:left;}
.pop p samp{ font-style:normal; float:right}
.toggle{ text-align:center; width:100%; height:8px; margin:0 0 15px 0; background:url(echarts/images/arrow_down.png) no-repeat center center; background-size:contain; cursor:pointer}
.toggle.up{  background:url(echarts/images/arrow_up.png) no-repeat center center; background-size:contain;}
.map_bottom{ font-size:11px; color:#cdcde6; line-height:36px; text-align:left; overflow:hidden; zoom:1; padding:12px; border-top:1px solid #483e79; }
.leiji{ float:left; margin:12px 20px 0 0;}
.leiji h4{ font-size:22px; font-weight:normal; color:#41baff}
.legend{ float:left}
.legend li{ padding-left:5px}
.legend li:nth-child(2){line-height:20px;}
.legend li:nth-child(2) span{margin-left:10px;}
.legend li::before{ display:inline-block; width:10px; height:10px; border-radius:100%; content:''; position:relative; top:1px; left:-5px}
.legend li:nth-child(1)::before{ background:#4effae;}
.legend li:nth-child(2)::before{ background:#e4df4a;}
.legend li:nth-child(3)::before{ background:#ef385b;}
.legend em{ font-style:normal}

.bgModal{ width:100%; height:100%; background:#fff; position:absolute; left:0; top:0; z-index:99999999; display:none; opacity:0}
.shadeModal{ width:100%; height:100%; background:#fff; position:absolute; left:0; top:0; z-index:100; display:none; opacity:0}
</style>
</head>

<body>
<div id="main" style="width: 100%; height:300px;"></div>

<div class="bgModal"></div>
<div class="shadeModal"></div>
<script src="echarts/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">

//客户端提交参数
var params = {
		 "token": '${token}',
		"days": '${days}'
};
//展示数据
showInfo(params);
function showInfo(params){
	  
//alert("来自客户端的信息："+params);
var orgNames = '${orgNames}';
if(orgNames==null || orgNames == ''){
	
	$.post('licai/performanceOrgMapForDays', params, function(data){

	    if(data.returnCode == '0000'&& data!=undefined){
			console.log(data.data);
			var data = typeof data == "string" ? eval('('+data+')') : data;
	        resetOptions(data.data);
		}	
	}); 
}else{
	var params2 = {
			 "token": '${token}',
			"days": '${days}',
			"orgNames":'${orgNames}'
	};

	$.post('licai/areaCompleteRateForMap', params2, function(data){
	    if(data.returnCode == '0000'&& data!=undefined){
			console.log(data.data);
			var data = typeof data == "string" ? eval('('+data+')') : data;
	        resetOptions(data.data);
		}	
	}); 
}



}
//渲染地图函数
function resetOptions(data){

// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('main'));

var params={
    componentType: 'series',
    // 系列类型
    seriesType: 'string',
    // 系列在传入的 option.series 中的 index
    seriesIndex: 'number',
    // 系列名称
    seriesName: 'string',
    // 数据名，类目名
    name: 'string',
    // 数据在传入的 data 数组中的 index
    dataIndex: 'number',
    // 传入的原始数据项
    data: Object,
    // 传入的数据值
    value: 'number|Array',
    // 数据图形的颜色
    color: 'string',

}
//分级区间			
var warningIndex = data.performanceOrgCurrentDay.warningIndex==undefined?'--' +'%':data.performanceOrgCurrentDay.warningIndex +'%',
    wellIndex = data.performanceOrgCurrentDay.wellIndex==undefined? '--' +'%':data.performanceOrgCurrentDay.wellIndex +'%',
	accumuWarningLine = data.performanceOrgCurrentDay.accumuWarningLine==undefined?'--':data.performanceOrgCurrentDay.accumuWarningLine,
	accumuWellLine = data.performanceOrgCurrentDay.accumuWellLine == undefined? '--':data.performanceOrgCurrentDay.accumuWellLine;
var performanceCurrentDay = data.performanceOrgCurrentDay.performanceCurrentDay==undefined?'--'+ '万元':data.performanceOrgCurrentDay.performanceCurrentDay+ '万元';

var convertData = function (data) {
    var res = [];
	var allOrgMonthList = data.allOrgMonthList;
    for (var i = 0; i < allOrgMonthList.length; i++) {
		var geoCoord = allOrgMonthList[i].lgt+','+allOrgMonthList[i].lat,
			geoCoord = geoCoord.split(',');
		var accumuCompleteRate = allOrgMonthList[i].accumuCompleteRate;  //月累计达成率
        if (geoCoord) {
        	
			allOrgMonthList[i].value = geoCoord.concat(accumuCompleteRate);
			res = data.allOrgMonthList;
        }
    }
	console.log(res);
    return res;
};
	
var option = {
    title: {
		show: false,
        text: '各机构当月累计业绩',
        subtext: '',
        left: 'center'
    },
    tooltip: {
        trigger: 'item',
		triggerOn: 'click',
		enterable: true,
		alwaysShowContent: true,
		confine: true,
		borderColor: '#4d3eb8',
		backgroundColor: 'rgba(42,33,109,0.95)',
		borderWidth: 1,
		position: ['40px', '5%'],
		padding:0,
		formatter: function (params, ticket, callback) {  
            //x轴名称  
            var name = params.name  
			console.log(params);
 		   $('.shadeModal').show();
           var orgName = params.data.orgName==undefined?'--':params.data.orgName;
           var accumuPerformance = params.data.accumuPerformance==undefined?'--':params.data.accumuPerformance;
           if(-1 == accumuPerformance){
        	   accumuPerformance = '--'
           }else{
        	   accumuPerformance += '万元';
           }
           var principal = params.data.districtPrincipal==undefined?'--':params.data.districtPrincipal;
           var color = params.color==undefined?'--':params.color;
           var accumuCompleteRate = params.data.accumuCompleteRate==undefined?'--':params.data.accumuCompleteRate;
           if(-1 == accumuCompleteRate){
        	   accumuCompleteRate = '--';
           }else{
        	   accumuCompleteRate += '%';
           }
           var perCapitaCapacity = params.data.perCapitaCapacity==undefined?'--':params.data.perCapitaCapacity;
           if(-1 == perCapitaCapacity){
        	   perCapitaCapacity = '--';
           }else {
        	   perCapitaCapacity += '万元';
           }
           var perCapitaNewClient = params.data.perCapitaNewClient==undefined?'--':params.data.perCapitaNewClient;
           if(-1 == perCapitaNewClient){
        	   perCapitaNewClient = '--';
           }else{
        	   perCapitaNewClient += '人';
           }
           var counselorManagerRatio = params.data.counselorManagerRatio==undefined?'--':params.data.counselorManagerRatio;
           if(-1 == counselorManagerRatio){
        	   counselorManagerRatio = '--';
           }
           var counselorNum = params.data.counselorNum==undefined?'--':params.data.counselorNum;
           if(-1 == counselorNum){
        	   counselorNum = '--';
           }
           var managerNum = params.data.managerNum==undefined?'--':params.data.managerNum;
           if(-1 == managerNum){
        	   managerNum = '--';
           }
           var ranking = params.data.ranking==undefined?'--':params.data.ranking;
           if(-1 == ranking){
        	   ranking = '--';
           }
           
			return '<div class="modal_title">'+ orgName +'<p class="close" onclick="closeFun(this)">&nbsp;</p></div><div class="modal_line"></div><div class="pop"><p><span>月累计业绩</span><samp>'+ accumuPerformance +'</samp></p><p><span>区域负责人</span><samp>'+ principal +'</samp></p><p><span>月累计达成率</span><samp style="color:'+ color +'">'+ accumuCompleteRate +'</samp></p><p><span>月人均产能</span><samp>'+ perCapitaCapacity +'</samp></p><p><span>人均新客户数</span><samp>'+ perCapitaNewClient +'</samp></p><p><span>咨询师/管理人员</span><samp>'+ counselorManagerRatio +'</samp></p><p><span>咨询师人数</span><samp>'+ counselorNum +'</samp></p><p><span>管理人数</span><samp>'+ managerNum +'</samp></p><p><span>所属区间</span><samp style="color:'+ color +'"><span style="display:inline-block;border-radius:10px;width:10px;height:10px;margin-top:5px;background-color:'+ color +'"></span></samp></p><p><span>全国排名</span><samp>第'+ ranking +'名</samp></p></div><p class="toggle" onclick="slideFun(this)">&nbsp;</p>';
        }
    },
	geo: {
		map: 'china',
		roam: true,
		scaleLimit: {
			min: 1,
			max: 20	
		},
		label: {
			normal: {
				show: false,
			},
			emphasis: {
				show: false
			}
		},
		itemStyle: {
			normal: {
				areaColor: '#34288d',
				borderColor: '#624fef'
			},
			emphasis: {
				areaColor: '#34288d'
			}
		},
		layoutCenter: ['50%', '50%'],
		layoutSize: '100%'
	},
    visualMap: {
		type: 'piecewise',
        min: 0,
        max: 200,
        right: 'right',
        top: 'bottom',
		pieces: [
			{gte: 0, lt: accumuWarningLine, color: '#ef385b',  symbol: 'circle', label: '累计达成率<当前时间进度*'+warningIndex },
			{gte: -1, lt: accumuWarningLine, color: '#ef385b',  symbol: 'circle', label: '累计达成率<当前时间进度*'+warningIndex },
			{gte: accumuWarningLine, lt: accumuWellLine, color: '#efe83d', symbol: 'circle', label: '累计达成率<当前时间进度*'+wellIndex},
			{gte: accumuWellLine, color: '#4effae', symbol: 'circle', label: '累计达成率≥当前时间进度*'+wellIndex},
		
		],
		show: false,
        calculable: true,
    },
    series: [
        {
            name: '全国机构月累计业绩平均数',
			type: 'scatter', 
            coordinateSystem: 'geo',
            label: {
                normal: {
                    show: false
                },
                emphasis: {
                    show: false
                }
            },
			symbol: 'circle',
			symbolSize: 14,
            data:convertData(data)
        }
    ]
};

// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);

$('#main').find('div:first').on('touchend', function(e){
  $('.bgModal').show();
  setTimeout(function(){
  $('.bgModal').hide();
  }, 300);  
})	

	
}

function slideFun(obj){
  if(event.target.className!='toggle' && event.target.className!='toggle up'){return;}
  var msgBox = obj.previousSibling,
	  objclass = obj.className;
  if(objclass=='toggle'){
	  msgBox.style.height = 'auto';
	  obj.className = 'toggle up';
  }else{
	  msgBox.style.height = '18px';
	  obj.className = 'toggle';
  }
  
  
}
function closeFun(obj){
  var msgBox = obj.parentNode.parentNode;
  msgBox.style.display = 'none';
  $('.shadeModal').hide();
}

    </script>
</body>
</html>

