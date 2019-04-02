<%@ page language="java"  import="java.util.ArrayList" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "MoocData.MoocUserData" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>慕课MOOC</title>
<script src="<%=request.getContextPath() %>/js/OnlineMoc.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/OnlineMoc.css">
</head>
<body>
	<%
		//用户名
		String loginName = "";
		//用户id
		String fixedPageUserid="";
		//用户手机号
		String fixedPageUserPhone="";
		
		//页面加载时判断session里是否存有登入信息
		ArrayList userMessage = (ArrayList)session.getAttribute("userList");
		if(userMessage!=null){
			MoocUserData userData = new MoocUserData();
			userData = (MoocUserData)userMessage.get(0);//不懂为什么还要强制转换为VO类
			loginName = "<span>你好,</span> <span id=\"fixedPageUserName\">"+userData.getmUsername()+"</span>";
			//out.println(loginName);
			fixedPageUserid = userData.getmUserid();
			if(userData.getmPhone()!=null){
				fixedPageUserPhone = userData.getmPhone();
			}else{
				fixedPageUserPhone ="";
			}
			
			
		}
	%>
	
	<!-- 导航栏 -->
	<div id="navigationBar" style="background-color:#1CB177;color:white;font-weight:bold;" >
		<!-- 网站标志 -->
		<div style="float:left;">
			<a href="/OnlineMooc/homePage.jsp" ><img src="<%=request.getContextPath() %>/img/fixe2.png" style="max-height:50px;"></a>
		</div>
		<ul style="float:left;width:67%;">
			<li><a href="/OnlineMooc/moreCoursePage.jsp?payOrFree=free" style="text-decoration:none;color:white;";>免费课程</a></li>
			<li><a href="/OnlineMooc/moreCoursePage.jsp?payOrFree=pay"  style="text-decoration:none;color:white;";>付费课程</a></li>
			<!-- <li>搜索框</li> -->
			<li id="ngbarRegisterid" onclick="popRegisterEnter();enterOrRegister(0);" style="float:right;">注册</li>
			<li id="specialid" style="float:right;">|</li>
			<li id="ngbarEnterid" onclick="popRegisterEnter();enterOrRegister(1);" style="float:right;">登入</li>
			
			<li id="ngbarEnterSuccess" style="float:right;" style="float:right;" onmouseover="mOver(this)" onmouseout="mOut(this)" ><%=loginName %></li>
			<li style="float:right;" onclick="jumpToBeTeacherPageCheck();">开课</li>
		</ul>
		
	</div>
	
	<script>
		function mOver(obj){
			document.getElementById("floatUserNavBar").style.display="block";
		}
		function mOut(obj){
			document.getElementById("floatUserNavBar").style.display="none";
		}
	</script>
	
	<!-- 导航栏上的用户悬浮框 -->
	<div id="floatUserNavBar" style="display:none;position:absolute;width:150px;border:1px solid white;z-index:999;margin-left:950px;" onmouseover="mOver(this)" onmouseout="mOut(this)" >
		<ul style="list-style:none;">
			<li><button id="floatUsernavBarLi1" onclick="transitionToAdmin()" style="background-color:white;border:1px solid white;width:150px;height:30px;">我的后台</button></li>
			<li><button id="floatUsernavBarLi2" onclick="AjaxSend(2);" style="background-color:white;border:1px solid white;width:150px;height:30px;">安全退出</button></li>
			<li><button id="fixedPageUserid" style="display:none;"><%=fixedPageUserid %></button></li>
			<li><button id="fixedPageUserPhone" style="display:none;"><%=fixedPageUserPhone %></button></li>
			
		</ul>
	</div>
	<!-- 登入注册遮罩层 -->
	<div id="enterRegisterMask" onclick="hide()" style="opacity:0.7;">
		
	</div>
	<!-- 登入注册框 -->
	<div id="enterRegisterDiv">
		
		<div id="enterRegisterChoiseBar" style="background-color:#1CB177;color:white;height:35px;">
			<div id="enterChoise" onclick="enterOrRegister(1);">
				<h2 style="padding:4px;">登入|</h2>
			</div>
			<div id="registerChoise" onclick="enterOrRegister(0);">
				<h2 style="padding:4px;">注册</h2>
			</div>
		</div>
		<!-- 登入 -->
		<div id="enterDiv">
				<ul style="list-style:none;">
					<li><input id="phoneid" type="text" value="" placeholder="请输入手机号或邮箱登入"  style="width:200px;height:30px;margin-left:30px;margin-top:10px;" /></li>
					<li style="display:none;">报错信息</li>
					<li><input id="passwdid" type="password" value="" placeholder="请输入密码" style="width:200px;height:30px;margin-left:30px;margin-top:10px;" /></li>
					<li style="display:none;">报错信息</li>
					<li><input type="text" value="" placeholder="请输入验证码"  style="width:120px;height:30px;margin-left:30px;margin-top:10px;" /><button style="border:1px solid #1CB177; background-color:white;color:grey;width:70px;height:30px;margin-left:8px;">获取验证码</button></li>
					<li style="display:none;">报错信息</li>
					<li><input type="button" value="登入" style="border:1px solid #1CB177; background-color:#1CB177;color:white;width:200px;height:30px;margin-left:30px;margin-top:10px;" onclick="AjaxSend(0)" /></li>	
					<li><a href="#" style="font-size:small;float:right;margin-right:68px;">忘记密码?</a></li>	
				</ul>
			
		</div>

		
		<!-- 注册 -->
		<div id="registerDiv">
				
				<!-- 手机注册 -->
				<ul id="phoneRegistUl" style="list-style:none;">
					<li><input id="registerPhone" type="text" value="" placeholder="请输入要注册的手机号" style="width:200px;height:30px;margin-left:30px;margin-top:10px;" /></li>
					<li style="display:none;">报错信息</li>
					<li><input type="text" value="" placeholder="请输入短信验证码,等待实现"  style="width:120px;height:30px;margin-left:30px;margin-top:10px;" /><button style="border:1px solid #1CB177; background-color:#1CB177;color:white;width:70px;height:30px;margin-left:8px;">获取验证码</button></li>
					<li style="display:none;">报错信息</li>
					<li><input id="registerPhonePasswd" type="password" value="" placeholder="请输入登入密码" style="width:200px;height:30px;margin-left:30px;margin-top:10px;" /></li>
					<li style="display:none;">报错信息</li>
				</ul>
				<!-- 邮箱注册 -->	
				<ul id="mailRegistUl" style="list-style:none;display:none;">
					<li><input type="text" value="" placeholder="请输入要注册的邮箱" style="width:200px;height:30px;margin-left:30px;margin-top:10px;" /></li>
					<li style="display:none;">报错信息</li>
					<li><input type="passwd" value="" placeholder="请输入邮件里的随机字串"  style="width:200px;height:30px;margin-left:30px;margin-top:10px;" /></li>
					<li style="display:none;">报错信息</li>
					
				</ul>
				<!-- 发起注册请求和第三方注册 -->
				<ul style="list-style:none;">
					
					<li><input type="button" value="注册" onclick="AjaxSend(11);"  style="border:1px solid #1CB177; background-color:#1CB177;color:white;width:200px;height:30px;margin-left:30px;margin-top:10px;" /></li>	
					<li id="tabPhoneOrMailRegistLi"><a onclick="phoneOrMailRegist(1);" style="font-size:small;float:right;margin-right:68px;color:grey;">切换到邮箱注册</a></li>
					<li></li>
				</ul>
			
		</div>
	</div>
	
	<!-- 侧边栏 -->
	<div id="sideBar">
		
	</div>
</body>
</html>