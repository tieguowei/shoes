<?php 
/*echo $_POST['days'];
die();*/

header('Content-type: application/json');
$data = 
/*array(*/
   array(
       "returnCode"=>"0000",
	   "returnMsg"=>"调用成功",
	   "data"=> array(
	       "performanceOrgCurrentDay"=> array(
			   "performanceCurrentDay"=>75,
			   "warningIndex"=>50,
			   "wellIndex"=>80,
			   "accumuWarningLine"=>20,
			   "accumuWellLine"=>40
		   ),
		   "allOrgMonthList"=> array(
		        array(
		              "counselorManagerRatio"=>18.00,  
				      "accumuCompleteRate"=>5.00,
					  "perCapitaNewClient"=>23.23,
					  "lgt"=>"121.15",
					  "principal"=>"闵春实",
					  "accumuPerformance"=>12.12,
					  "managerNum"=>5,
					  "perCapitaCapacity"=>34.34,
					  "record_date"=>"2017-04-05",
					  "counselorNum"=>5,
					  "orgName"=>"哈尔滨",
					  "ranking"=>4,
					  "lat"=>"31.89"
			    ),
		        array(
		              "counselorManagerRatio"=>18.00,  
				      "accumuCompleteRate"=>51.00,
					  "perCapitaNewClient"=>123.23,
					  "lgt"=>"116.1",
					  "principal"=>"刘新艳",
					  "accumuPerformance"=>22.12,
					  "managerNum"=>8,
					  "perCapitaCapacity"=>134.34,
					  "record_date"=>"2017-04-05",
					  "counselorNum"=>8,
					  "orgName"=>"淄博",
					  "ranking"=>2,
					  "lat"=>"24.55"
			    ),
		        /*array("name"=>"营口", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"75%", "key1"=> 78, "key2"=> 78),
				array("name"=>"惠州", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"65%", "key1"=> 78, "key2"=> 78),
				array("name"=>"江阴", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"50%", "key1"=> 78, "key2"=> 78),
				array("name"=>"广州", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"55%", "key1"=> 78, "key2"=> 78),
				array("name"=>"延安", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"65%", "key1"=> 78, "key2"=> 78),
				array("name"=>"太原", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"30%", "key1"=> 78, "key2"=> 78),
				array("name"=>"清远", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"45%", "key1"=> 78, "key2"=> 78),
				array("name"=>"中山", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"56%", "key1"=> 78, "key2"=> 78),
				array("name"=>"昆明", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"78%", "key1"=> 78, "key2"=> 78),
				array("name"=>"临汾", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"88%", "key1"=> 78, "key2"=> 78),
				array("name"=>"吴江", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"85%", "key1"=> 78, "key2"=> 78),
				array("name"=>"石嘴山", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"65%", "key1"=> 78, "key2"=> 78),
				array("name"=>"沈阳", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"45%", "key1"=> 78, "key2"=> 78),
				array("name"=>"苏州", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"95%", "key1"=> 78, "key2"=> 78),
				array("name"=>"茂名", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"90%", "key1"=> 78, "key2"=> 78),
				array("name"=>"张家港", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"80%", "key1"=> 78, "key2"=> 78),
				array("name"=>"三门峡", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"68%", "key1"=> 78, "key2"=> 78),
				array("name"=>"锦州", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"70%", "key1"=> 78, "key2"=> 78),
				array("name"=>"南昌", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"72%", "key1"=> 78, "key2"=> 78),
				array("name"=>"柳州", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"76%", "key1"=> 78, "key2"=> 78),
				array("name"=>"三亚", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"79%", "key1"=> 78, "key2"=> 78),
				array("name"=>"自贡", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"52%", "key1"=> 78, "key2"=> 78),
				array("name"=>"吉林", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"35%", "key1"=> 78, "key2"=> 78),
				array("name"=>"阳江", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"89%", "key1"=> 78, "key2"=> 78),
				array("name"=>"泸州", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"80%", "key1"=> 78, "key2"=> 78),
				array("name"=>"西宁", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"83%", "key1"=> 78, "key2"=> 78),
				array("name"=>"宜宾", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"83%", "key1"=> 78, "key2"=> 78),
				array("name"=>"呼和浩特", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"87%", "key1"=> 78, "key2"=> 78),
				array("name"=>"成都", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"80%", "key1"=> 78, "key2"=> 78),
				array("name"=>"大同", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"80%", "key1"=> 78, "key2"=> 78),
				array("name"=>"镇江", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"70%", "key1"=> 78, "key2"=> 78),
				array("name"=>"贵阳", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"75%", "key1"=> 78, "key2"=> 78),
				array("name"=>"无锡", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"60%", "key1"=> 78, "key2"=> 78),
				array("name"=>"本溪", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"66%", "key1"=> 78, "key2"=> 78),
				array("name"=>"焦作", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"67%", "key1"=> 78, "key2"=> 78),
				array("name"=>"北京", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"85%", "key1"=> 78, "key2"=> 78 ),
				array("name"=>"徐州", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"85%", "key1"=> 78, "key2"=> 78),
				array("name"=>"衡水", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"77%", "key1"=> 78, "key2"=> 78),
				array("name"=>"济南", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"66%", "key1"=> 78, "key2"=> 78),
				array("name"=>"邯郸", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"55%", "key1"=> 78, "key2"=> 78),
			    array("name"=>"长沙", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"58%", "key1"=> 78, "key2"=> 78),
				array("name"=>"合肥", "lgt"=> 117.27, "lat"=> 31.86, "value"=>"68%", "lgt"=> 116.46, "lat"=> 39.92, "key1"=> 78, "key2"=> 78),
				array("name"=>"武汉", "lgt"=> 116.46, "lat"=> 39.92, "value"=>"68%", "key1"=> 78, "key2"=> 78)*/
			)

	   )
    )
/*)*/;
echo json_encode($data,JSON_UNESCAPED_UNICODE);
?>