<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更多课程内容页</title>
</head>
<body style="background-color:#F0F0F0;">
	<%@ include file="fixedPage.jsp" %>
	<script>
		window.onload=function(){
			// 修改导航栏上的登入状态
			if (document.getElementById('ngbarEnterSuccess').innerHTML != "") {
				document.getElementById('ngbarEnterid').style.display = 'none';
				document.getElementById('specialid').style.display = 'none';
				document.getElementById('ngbarRegisterid').style.display = 'none';
				document.getElementById('ngbarEnterSuccess').style.display = 'block';
			}
			moreCoursePageAtFirstRequest();
		}
	</script>
	<!-- 类标签容器 -->
	<div id="classTagContainer">
		<!--一类标签选择-->
		<div id="classOneTagContanier" style="border:1px solid whiteeen;background-color:white;overflow: hidden;float:left;width:100%;padding:10px;">
			
		</div>
		
		<!--二类标签选择-->
		<div id="classTwoTagContainer" style="float:left;border:1px solid whiteeen;background-color:white;margin-top:0px;width:100%;padding:10px;">
			
		</div>		
			
	</div>
	
	<!--课程列表显示-->
	<div id="showMoreCourseContainer" style="border:1px solid white ;background-color:white;;overflow: hidden;">
		
	</div>
	
	
	<!-- 下拉刷新查看更多视频容器 -->
	<div></div>
	<div></div>
	<div></div>
</body>
</html>