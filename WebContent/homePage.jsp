<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>高效课堂|让在线学习更有效率</title>
</head>
<body style="background-color: #F0F0F0;">
	<%@ include file="fixedPage.jsp" %>
	<!-- 轮播图上的原点，一气之下搬到了外面，位置问题， -->
		<div id="rotationChartDotContainer" style="position:absolute;z-index:200;left:48%;top:50%;">
			<ul>
				<li id="rotationChartDotLi1" onclick="displayOneHideOther(1)" style="float:left;display:block;margin-left: 0px;color:green;padding: 4px 4px;border:2px solid white;border-radius: 120px;background-color:white;"></li>
				<li id="rotationChartDotLi2" onclick="displayOneHideOther(2)" style="float:left;display:block;margin-left: 4px;color:green;padding: 4px 4px;border:2px solid white;border-radius: 120px;background-color:white;"></li>
				<li id="rotationChartDotLi3" onclick="displayOneHideOther(3)" style="float:left;display:block;margin-left: 4px;color:green;padding: 4px 4px;border:2px solid white;border-radius: 120px;background-color:white;"></li>
				<li id="rotationChartDotLi4" onclick="displayOneHideOther(4)" style="float:left;display:block;margin-left: 4px;color:green;padding: 4px 4px;border:2px solid white;border-radius: 120px;background-color:white;"></li>
				<li id="rotationChartDotLi5" onclick="displayOneHideOther(5)" style="float:left;display:block;margin-left: 4px;color:green;padding: 4px 4px;border:2px solid white;border-radius: 120px;background-color:white;"></li>
			</ul>
			
		</div>
	<!-- 轮播图（大类细类标签选择不做了） -->
	<div id="rotationChartContainer" >
		<!-- 轮播图上的图片 -->
		<div id="rotationChartPhotoContainer" >
				<div id="rotationChartPhoto1" style="display:block;" ><img src="img/daohang1.png" style="width:100%;height:280px;" /></div>
				<div id="rotationChartPhoto2" style="display:none;" ><img src="img/daohang2.png" style="width:100%;height:280px;" /></div>
				<div id="rotationChartPhoto3" style="display:none;" ><img src="img/daohang3.png" style="width:100%;height:280px;" /></div>
				<div id="rotationChartPhoto4" style="display:none;" ><img src="img/daohang4.png" style="width:100%;height:280px;" /></div>
				<div id="rotationChartPhoto5" style="display:none;" ><img src="img/daohang5.png" style="width:100%;height:280px;" /></div>
		</div>
		
		<!-- 灰色条没什么用，距离下面内容20px -->
		<div>
			<hr style="border:20px solid #F0F0F0;">
		</div>
	</div>
	

	<!-- 免费热门课程 -->
	<div id="freeHotCourseContainer" style="border:1px solid #F0F0F0;overflow: hidden;">
		
	</div>
	<br>
	
	<!-- 付费热门课程 -->
	<div id="payHotCourseContainer" style="border:1px solid #F0F0F0;overflow: hidden;">
		
	</div>
	<br>
	
	<!-- 最新免费课程 -->
	<div id="newFreeCourseContainer" style="border:1px solid #F0F0F0;overflow: hidden;">
		
		
	</div>
	<br>
	
	<!-- 最新付费课程 -->
	<div id="newPayCourseContainer" style="border:1px solid #F0F0F0;overflow: hidden;">
		
	</div>
	<br>
	
	<!-- 评价最高的免费课程 -->
	<div id="qualityHighFreepayCourseContainer" style="border:1px solid #F0F0F0;overflow: hidden;">
		
	</div>
	<br>
	
	<!-- 评价最高的付费课程 -->
	<div id="qualityHighPayCourseContainer" style="border:1px solid #F0F0F0;overflow: hidden;">
		
	</div>
	<br>
	
	
</body>
</html>