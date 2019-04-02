<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户个人主页</title>
	<script src="<%=request.getContextPath() %>/js/OnlineMoc.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/OnlineMoc.css">
</head>
<body style="background-color:#F0F0F0;">
	<%@ include file="/fixedPage.jsp" %>
	
	<%
		//这里到时估计要做优化
		//判断是否登入了
		//页面加载时判断session里是否存有登入信息
		//这里可以直接使用拼接过来的fixePage创建的对象
		if(userMessage==null){
//			out.println("未登入！无权限访问！");
			//重定向到首页
			response.sendRedirect("/OnlineMooc/homePage.jsp");
			
		}
	%>
	
	

	<div id="userAdminLeftSideContainer" style="background-color:white;width:250px;">
		<!--用户头像  -->
		<div style="margin-top:30px;margin-left:80px">
			<img src="<%=request.getContextPath() %>/img/defaultUserImg.png" style="border-radius:50%;"></img>
			
		</div>
		
			<button style="background-color:white;width:250px;height:40px;border:1px solid white;" onclick="tabUserAdminManageList(1);">个人资料</button>
		
			<button style="background-color:white;width:250px;height:40px;border:1px solid white;" onclick="tabUserAdminManageList(2);">账号绑定</button>
		
			<button style="background-color:white;width:250px;height:40px;border:1px solid white;" onclick="tabUserAdminManageList(3);">学习课程记录</button>
			
			<button style="background-color:white;width:250px;height:40px;border:1px solid white;" onclick="tabUserAdminManageList(5);">购买课程记录</button>
			
			<button id="ifIsMyCourseButton" onclick="ifIsMyCourseButton();tabUserAdminManageList(4);" style="background-color:white;width:250px;height:40px;border:1px solid white;">我开的课程</button>
		
		
	</div>
	
	
	<!-- 右侧内容显示页容器 -->
	<div id="contentContainer">
		
		<!-- 个人资料 -->
		<div id="userInformationContainer" style="border:1px solid #1CB177;">
			<div style="width:100%;border:1px solid white;overflow: hidden;">
				<span style="float:left;font-weight:bold;padding: 8px;;">个人信息</span>
				<span style="float:right;font-size: smaller;padding: 8px;;">编辑</span>
				
			</div>
			
			<div style="margin:20px;">
				<ul style="list-style: none;">
					<li ><span style="border:1px solid #1CB177;background-color:#F9F9F9;padding: 10px ;margin: 10px;">用户名</span> <span style="padding: 8px;">赵虎</span></li>
					<li style="margin-top:20px;;"><span style="border:1px solid #1CB177;background-color:#F9F9F9;padding: 10px ;margin: 10px;">个性签名</span><span style="padding: 8px;">努力！奋斗！</span></li>
					<li style="margin-top:20px;;"><span style="border:1px solid #1CB177;background-color:#F9F9F9;padding: 10px ;margin: 10px;">是否有教师资格</span><span style="padding: 8px;">有</span></li>
				</ul>
				
				
			</div>
		</div>
		
		<!-- 账号绑定 -->
		<div id="userContactContainer" style="display:none;border:1px solid #1CB177;">
			<!--标题-->
			<div style="border:1px solid white;padding: 10px;;">
				<span style="font-weight:bold;padding: 8px 0px 8px 4px;">账号绑定&nbsp;</span> <span>完成0/2</span> <span style="float:right;font-size: smaller;">有问题点我</span><br>
			</div>
			<!--手机-->
			<div style="border:1px solid white;padding: 10px;;">
				<span style="padding: 8px 0px 8px 4px;">手机：</span> <span>15980933652</span> <span style="display:none;">未绑定</span> <button style="border:1px solid #1CB177;background-color:#1CB177;color:white;display:none;">立即绑定</button> <button style="border:1px solid #1CB177;background-color:#1CB177;color:white;">更改</button> <br>
				<span style="padding: 8px 0px 8px 4px;font-size: smaller;">可用手机号找回密码</span>
			</div>
			<!--密码-->
			<div></div>
			<!--邮箱-->
			<div style="border:1px solid white;padding: 10px;;">
				<span style="padding: 8px 0px 8px 4px;">邮箱：</span> <span>1163986255@qq.com</span> <span style="display:none;">未绑定</span>  <button style="display:none;">立即绑定</button> <button style="border:1px solid #1CB177;background-color:#1CB177;color:white;">更改</button> <br>
				<span style="padding: 8px 0px 8px 4px;font-size: smaller;">可用手机号找回密码</span>
			</div>
			<!--第三方账号-->
			<div>
				
			</div>
		</div>
		
		<!-- 学习课程记录 -->
		<div id="userStudyRecord" style="display:none;border:1px solid #1CB177;">
			
			<!--标题-->
			<div style="border:1px solid white;padding: 10px;;">
				<span style="font-weight:bold;border:1px white bisque;margin: 10px;padding: 10px;;">课程学习记录</span><br>

			</div>
			
			<!--内容-->
			<div style="border:1px solid white;padding: 20px;margin: 10px;margin-top: 0px;padding-top: 10px;">
		
				<!---->
				<table border="1" style="border:1px solid white;">
				  <tr>
				    <th>课程名称</th>
				    <th>开课者名称</th>
				    <th>课程分类1</th>
				    <th>课程分类2</th>
				    <th>课程价格</th>
				    <th>管理</th>
				  </tr>
				  <tr>
				    <td>Spring实战教学</td>
				    <td>Mj史密斯</td>
				    <td>后端</td>
				 	<td>java</td>
				 	<td>免费</td>
				    <td><button style="border:1px solid #1CB177; background-color:#1CB177;color:white;width:60px;height:20px;">删除</button></td>
				  </tr>
				  <tr>
				     <td>Spring实战教学</td>
				    <td>Mj史密斯</td>
				    <td>后端</td>
				 	<td>java</td>
				 	<td>免费</td>
				    <td><button style="border:1px solid #1CB177; background-color:#1CB177;color:white;width:60px;height:20px;">删除</button></td>
				  </tr>
				</table>
				
				
			</div>
		</div>
		
		<!-- 购买课程记录 -->
		<div id="payCourseOrderRecord" style="display:none;border:1px solid #1CB177;">
			
			<!--标题-->
			<div style="border:1px solid white;padding: 10px;;">
				<span style="font-weight:bold;border:1px white bisque;margin: 10px;padding: 10px;;">购买课程记录</span><br>

			</div>
			
			<table border="1" style="border:1px solid white;margin: 20px;padding: 10px;margin-top: 0px;">
			  <tr>
			    <th>订单id</th>
			    <th>购买者id</th>
			    <th>购买价格</th>
			    <th>购买时间</th>
			    <th>删除</th>
			  </tr>
			  <tr>
			   <td>M2d2dwahui2hui3</td>
			    <td>小程序开发</td>
			    <td>233</td>
			 	<td>2019-03-05 09:02:19</td>
			    <td><button style="border:1px solid #1CB177; background-color:#1CB177;color:white;width:60px;height:20px;">删除</button></td>
			  </tr>
			  <tr>
			    <td>M2dwahui2hui3</td>
			    <td>Spring项目实战</td>
			    <td>233</td>
			 	<td>2019-03-05 09:02:19</td>
			    <td><button style="border:1px solid #1CB177; background-color:#1CB177;color:white;width:60px;height:20px;">删除</button></td>
			  </tr>
			</table>
		</div>
		
	
		<!-- 我开的课程最外层容器 -->
		<div id="courseContentContainer" >
		
			<!--我的课程列表返回结果  -->
			<div id="myCourseDiv" style="">
				
				
			</div>
			<hr>
			
			<!-- 开新课div -->
			<div id="newCourseDiv">
				
				<!-- 选择章节div -->
				<div>
					<span>选择章节数</span>
					<select id="chapterSelect" name="">
					<option value="chapter1">1个章节</option>
					<option value="chapter2">2个章节</option>
					<option value="chapter3">3个章节</option>
					<option value="chapter4">4个章节</option>
					<option value="chapter5">5个章节</option>
					<option value="chapter6">6个章节</option>
					<option value="chapter7">7个章节</option>
					<option value="chapter8">8个章节</option>
					</select>
					<button onclick="generateCourseFormPost();AjaxSend(21);" style="border:1px solid #1CB177; background-color:#1CB177;color:white;width:60px;height:20px;">确定</button>
					<button onclick="cancelCourseFormPost()" style="border:1px solid #1CB177; background-color:#1CB177;color:white;width:60px;height:20px;">重选</button>
					</span>
				</div>
				
				<!-- js生成的课程填写内容表单容器 -->
				<div id="CourseFormPostContainer" >
					
				</div>
				
			</div>
		
		</div><!-- 我开的课程最外层容器 -->
		
		
		
	</div><!-- 右侧内容显示页容器 -->
	
	
	
</body>
</html>