<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>慕课系统数据管理</title>
<script src="manageJs/manage.js"></script>
</head>
<body>
	<!--侧边目录容器-->
	<div id="manageSideBarContainer" style="width:20%;border:1px solid #F9F9F9;background-color: #F9F9F9;height:700px;float:left;">
		 
		 <!--登入后的用户信息头像，数据-->
		 <div id="manageUserContainer" style="border:1px solid border:1px solid white;background-color:#F9F9F9;;padding: 20px;">
		 	<img src="img/manageDefaultImg.png" style="margin-left:45px;border:1px solid white;background-color:white;">
		 	<br><span style="margin-left: 42px;;">管理员姓名:<span>李毅</span></span><br>
		 	<span style="margin-left: 42px;;">员工id:<span>MC002</span></span><br>
		 	<span style="margin-left: 42px;font-size: small;">登入时间:<span>19-03-03 15:04:39</span></sapn><br>
		 </div>
		 
		 <!--管理栏管理内容目录容器-->
		 <div id="manageSideBarListContainer" style="border:1px solid white;">
		 	<button onclick="switchingManageContent(0);" style="border:1px solid white;background-color:#F0F0F0;width:100%;height:45px;">用户管理</button>
		 	<button onclick="switchingManageContent(1);" style="border:1px solid white;background-color:#F0F0F0;width:100%;height:45px;">课程管理</button>
		 	<button onclick="switchingManageContent(2);"style="border:1px solid white;background-color:#F0F0F0;width:100%;height:45px;">用户购买订单记录</button>
		 	<button onclick="switchingManageContent(3);"style="border:1px solid white;background-color:#F0F0F0;width:100%;height:45px;">付费问答订单记录</button>
		 	<button onclick="switchingManageContent(4);" style="border:1px solid white;background-color:#F0F0F0;width:100%;height:45px;">系统测试</button>
		 </div>
		 
	</div>
	<!--右侧显示数据容器-->
	<div id="manageRightInformationOutestContainer" style="width:79%;height:700px;border:1px solid white;float:left;">
		<!--最新消息显示条-->
		<div>
			<hr style="border:20px solid #1CB177;margin-top: 0px;">
			
		</div>
		
		<!--右侧显示左侧点击后显示的内容容器-->
		<div id="manageInformationRealShowContainer" style="">
			
			<!--用户管理-->
			<div id="manageUserInformationContainer" style="padding: 20px;margin:20px;;">
				

			</div>
			
			<!--课程管理-->
			<div id="manageCourseInformationContainer" style="padding: 10px;margin: 10px;display:none;">
					
			</div>
			
			<!--用户购买订单记录-->
			<div id="manageUserPayOrderRecordContainer" style="padding: 10px;margin: 10px;display:none;">
				<!--标题-->
				<div style="border:1px solid white;padding: 10px;;">
					<span style="font-weight:bold;border:1px white bisque;margin: 10px;padding: 10px;;">用户购买课程订单记录</span><br>

				</div>
				
				<table border="1" style="border:1px solid white;margin: 20px;padding: 10px;margin-top: 0px;">
				  <tr>
				    <th>订单id(实际是课程id)</th>
				    <th>购买者id</th>
				    <th>购买价格</th>
				    <th>购买时间</th>
				    <th>删除</th>
				  </tr>
				  <tr>
				    <td>M2dwahui2hui3</td>
				    <td>26791e89-82a1-45c0-800f-f709f20f</td>
				    <td>233</td>
				 	<td>2019-03-05 09:02:19</td>
				    <td><button style="border:1px solid #1CB177; background-color:#1CB177;color:white;width:60px;height:20px;">删除</button></td>
				  </tr>
				  <tr>
				    <td>M2dwahui2hui3</td>
				    <td>26791e89-82a1-45c0-800f-f709f20f</td>
				    <td>233</td>
				 	<td>2019-03-05 09:02:19</td>
				    <td><button style="border:1px solid #1CB177; background-color:#1CB177;color:white;width:60px;height:20px;">删除</button></td>
				  </tr>
				</table>
			</div>
			
			<!--用户付费提问记录-->
			<div id="managePayQuestionOrderRecordContainer" style="padding: 10px;margin: 10px;display:none;">
				<!--标题-->
				<div style="border:1px solid white;padding: 10px;;">
					<span style="font-weight:bold;border:1px white bisque;margin: 10px;padding: 10px;;">付费问答订单记录</span><br>

				</div>
				
				<table border="1" style="border:1px solid white;margin: 20px;padding: 10px;margin-top: 0px;">
				  <tr>
				    <th>订单id</th>
				    <th>课程id</th>
				    <th>提问者id</th>
				    <th>开课者id</th>
				    <th>提问时间</th>
				    <th>接单时间</th>
				    <th>提问时间</th>
				    <th>订单情况</th>
				    <th>删除</th>
				  </tr>
				  <tr>
				    <td>M2dwahui2hui3</td>
				    <td>26791e89-82a1-45c0-800f-f709f20f</td>
				    <td>233</td>
				 	<td>2019-03-05 09:02:19</td>
				 	<td>M2dwahui2hui3</td>
				    <td>26791e89-82a1-45c0-800f-f709f20f</td>
				    <td>233</td>
				 	<td>2019-03-05 09:02:19</td>
				    <td><button style="border:1px solid #1CB177; background-color:#1CB177;color:white;width:60px;height:20px;">删除</button></td>
				  </tr>
				  <tr>
				    <td>M2dwahui2hui3</td>
				    <td>26791e89-82a1-45c0-800f-f709f20f</td>
				    <td>233</td>
				 	<td>2019-03-05 09:02:19</td>
				 	<td>M2dwahui2hui3</td>
				    <td>26791e89-82a1-45c0-800f-f709f20f</td>
				    <td>233</td>
				 	<td>2019-03-05 09:02:19</td>
				    <td><button style="border:1px solid #1CB177; background-color:#1CB177;color:white;width:60px;height:20px;">删除</button></td>
				  </tr>
				</table>
			</div>
			
			<!--系统测试-->
			<div id="systemTestContainer" style="display:none;">
				
				<!--添加按钮-->
				<div>
				课程名称<input id="courseNameForBatch" type="text" name="" id="" value="" /><br />
				是否免费<input id="isFreeForBatch"type="text" name="" id="" value="" /><br />
				章节名称<input id="chapterNameForBatch"type="text" name="" id="" value="" /><br />
				小节名称<input id="sectionNameForBatch"type="text" name="" id="" value="" /><br />
				
				选择添加几个课程
					<select id="generateCourseNumSelect">
					<option value="1">1个</option>
					<option value="2">2个</option>
					<option value="3">3个</option>
					<option value="4">4个</option>
					<option value="5">5个</option>
					<option value="6">6个</option>
					<option value="7">7个</option>
					<option value="8">8个</option>
					</select>
					<button onclick="AjaxSend(2);">确定并开始</button>
				</div>
				
				
			</div>
		</div>
	</div>
</body>
</html>