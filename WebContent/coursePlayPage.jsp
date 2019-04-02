<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户播放页</title>
	<script src="<%=request.getContextPath() %>/js/OnlineMoc.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/OnlineMoc.css">
</head>
<body>

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
				PlayPageGetUrl();
			}
	</script>
	<!--课程播发页最外层容器-->
	<div id="coursePlayContainer" style="">
	
		<!-- 课程信息和视频播放外层容器 -->
		<div id="coursePlayAndMessageContainer">
			
			<!--视频播放左侧容器-->
			<div id="videoPlayContainer" style="border:1px solid white;float:left;width:78%;height:500px;background-color: black;overflow: hidden;">
			
			<!--  <video width="" height="" controls autoplay>
	 					<source id="videoUrl" src="course/freeCourse/video.ogg" type="video/ogg">
				</video>-->	
			</div>
			
			<!--课程信息右侧容器-->
			<div id="courseMessageContainer"  style="background-color:#191919;height:550px;border:1px solid white;float:left;width:21%;overflow: scroll;">
				<button id="payquestionButton" onclick="AjaxSend(13);" style="width:100%;background-color: black;height: 45px;color:white;">付费提问</button>
				<!--<button onclick="AjaxSend(19);">查询开课者是否接单（临时）</button>-->
				<button id="returnPayQuestionOrderid" style="display:none;"></button>
				<button onclick="playPageShowInformation(1)" style="width:100%;background-color: black;height: 45px;color:white;">课程信息</button>
				<button onclick="playPageShowInformation(0)" style="width:100%;background-color: black;height: 45px;color:white;">目录</button>
				
				<!--课程信息显示容器，显示章节小节列表，课程id，课程名称-->
				<div id="courseInformationContainer">
					
					
				</div>
				
				
			</div><!--课程信息右侧容器-->
		
		</div><!-- 课程信息和视频播放外层容器 -->
		
		
		
		<!--评论问答板块区最外层容器-->
		<div id="courseInteractContainer" style="border: 1px solid white;width:100%;float:left;margin: 0px;display:block;">
			
			<!--评论问答板块导航栏容器-->
			<div id="commentInterlocutionBarContainer" style="border:1px solid black;font-weight: 700;overflow: hidden;">
				<ul style="list-style: none;">
					<li style="float:left;padding: 4px;;margin: 4px 4px 12px 4px;"><button onclick="" style="background-color:white;border:1px solid white;">评论</button></li>
					<li style="float:left;padding: 4px;margin: 4px;;"><button onclick="" style="background-color:white;border:1px solid white">问答</button></li>
				</ul> 
				
			</div>
			
			<!--评论板块最外层容器-->
			<div id="commentContainer" style="border:1px solid black;">
				<div id="user1">
					<p><span style="font-size: larger;color:cornflowerblue;padding: 10px;margin:10px;border:1px solid white;">天空让我这么说：</span><span style="padding: 10px;margin:0px;border:1px solid white;">课程还是很不错的</p>
					<p style="padding: 0px 0px 0px 10px;margin:10px;border:1px solid white;font-size: smaller;">2019年2月12日20:03:55</p>
				</div>
				<hr>
				<div id="user1">
					<p><span style="font-size: larger;color:cornflowerblue;padding: 10px;margin:10px;border:1px solid white;">天空让我这么说：</span><span style="padding: 10px;margin:0px;border:1px solid white;">课程还是很不错的</p>
					<p style="padding: 0px 0px 0px 10px;margin:10px;border:1px solid white;font-size: smaller;">2019年2月12日20:03:55</p>
				</div>
				<hr>
				<div id="user1">
					<p><span style="font-size: larger;color:cornflowerblue;padding: 10px;margin:10px;border:1px solid white;">天空让我这么说：</span><span style="padding: 10px;margin:0px;border:1px solid white;">课程还是很不错的</p>
					<p style="padding: 0px 0px 0px 10px;margin:10px;border:1px solid white;font-size: smaller;">2019年2月12日20:03:55</p>
				</div>
				<hr>
				<div id="user1">
					<p><span style="font-size: larger;color:cornflowerblue;padding: 10px;margin:10px;border:1px solid white;">天空让我这么说：</span><span style="padding: 10px;margin:0px;border:1px solid white;">课程还是很不错的</p>
					<p style="padding: 0px 0px 0px 10px;margin:10px;border:1px solid white;font-size: smaller;">2019年2月12日20:03:55</p>
				</div>
				<hr>
				<div id="user1">
					<p><span style="font-size: larger;color:cornflowerblue;padding: 10px;margin:10px;border:1px solid white;">天空让我这么说：</span><span style="padding: 10px;margin:0px;border:1px solid white;">课程还是很不错的</p>
					<p style="padding: 0px 0px 0px 10px;margin:10px;border:1px solid white;font-size: smaller;">2019年2月12日20:03:55</p>
				</div>
				<hr>
				<div id="user1">
					<p><span style="font-size: larger;color:cornflowerblue;padding: 10px;margin:10px;border:1px solid white;">天空让我这么说：</span><span style="padding: 10px;margin:0px;border:1px solid white;">课程还是很不错的</p>
					<p style="padding: 0px 0px 0px 10px;margin:10px;border:1px solid white;font-size: smaller;">2019年2月12日20:03:55</p>
				</div>
				<hr>
				
			</div><!--评论板块最外层容器-->
			
			
			
		</div><!--评论问答板块区最外层容器-->
		
		
		<!--付费问答板块最外层容器-->
		<div id="askerInterlocutionContainer" style="display:none;width:420px;height:260px;background-color: #1CB177;border:1px solid black;">
			<!--<button onclick="AjaxSend(20);">查看聊天列表，临时</button>-->
			<!--头部 -->
			<div style="width: 400px;overflow: hidden;background-color:  #1CB177;">
				<button onclick="stopAskerQueryChatReocrd();" style="padding: 10px;height:100%;background-color: whitesmoke;border:1px solid darkblue;float:right;">点击结束付费提问</button>
			</div>
				
			<!-- 问答聊天列表容器 -->
			<div id="askerChatMessageListContainer" style="width:400px;height:260px;;border:1px solid grey;overflow:auto;background-color: white;">
				
			</div>
			
			<!-- 发送消息最外层容器 -->
			<div id="askerSendMessageContainer" style="overflow: hidden;background-color: white;">
				<textarea id="askerSendMessageContent" style="width: 400px;height:80px;"></textarea>
				<br>
				<button onclick="AjaxSend(17);" style="float:right;margin-right: 8px;margin-bottom: 8px;margin-top: 0px;padding: 4px;background-color: white;">发送消息</button>
				<br>
				
			</div>
			
		</div>
		
	</div><!-- 最外层容器 -->
	
</body>
</html>