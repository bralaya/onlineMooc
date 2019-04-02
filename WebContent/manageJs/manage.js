//页面加载时
window.onload = function() {
	
	//默认显示用户数据管理
	AjaxSend(0);
	
	
	
}

//-------------------------------------------页面上的操作----------------------------Begin

//点击按钮切换内容
/*
 * 0切换到用户管理
 * 1切换到课程管理
 * 2切换到购买订单管理
 * 3切换到付费问答订单管理
 */
function switchingManageContent(choise){
	switch (choise) {
	//切换到用户管理
	case 0:
		document.getElementById('manageUserInformationContainer').style.display='block';//用户管理
		document.getElementById('manageCourseInformationContainer').style.display='none';//课程管理
		document.getElementById('manageUserPayOrderRecordContainer').style.display='none';//购买订单管理
		document.getElementById('managePayQuestionOrderRecordContainer').style.display='none';//付费问答订单管理
		document.getElementById('systemTestContainer').style.display='none';//系统测试
		break;
	//切换到课程管理
	case 1:
		document.getElementById('manageUserInformationContainer').style.display='none';//用户管理
		document.getElementById('manageCourseInformationContainer').style.display='block';//课程管理
		document.getElementById('manageUserPayOrderRecordContainer').style.display='none';//购买订单管理
		document.getElementById('managePayQuestionOrderRecordContainer').style.display='none';//付费问答订单管理
		document.getElementById('systemTestContainer').style.display='none';//系统测试

		AjaxSend(1);
		break;
	//切换到购买订单管理
	case 2:
		document.getElementById('manageUserInformationContainer').style.display='none';//用户管理
		document.getElementById('manageCourseInformationContainer').style.display='none';//课程管理
		document.getElementById('manageUserPayOrderRecordContainer').style.display='block';//购买订单管理
		document.getElementById('managePayQuestionOrderRecordContainer').style.display='none';//付费问答订单管理
		document.getElementById('systemTestContainer').style.display='none';//系统测试

		break;
	//切换到付费问答订单管理
	case 3:
		document.getElementById('manageUserInformationContainer').style.display='none';//用户管理
		document.getElementById('manageCourseInformationContainer').style.display='none';//课程管理
		document.getElementById('manageUserPayOrderRecordContainer').style.display='none';//购买订单管理
		document.getElementById('managePayQuestionOrderRecordContainer').style.display='block';//付费问答订单管理
		document.getElementById('systemTestContainer').style.display='none';//系统测试

		break;
	case 4:
		document.getElementById('manageUserInformationContainer').style.display='none';//用户管理
		document.getElementById('manageCourseInformationContainer').style.display='none';//课程管理
		document.getElementById('manageUserPayOrderRecordContainer').style.display='none';//购买订单管理
		document.getElementById('managePayQuestionOrderRecordContainer').style.display='none';//付费问答订单管理
		document.getElementById('systemTestContainer').style.display='block';//系统测试

		break;
	}
}

// -------------------------------------------Ajax----------------------------Begin

// 初始化Ajax
function initAjax() {
	var xmlHttp = false;
	// Mozilla等现代浏览器
	if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
		return xmlHttp;
	}
	// IE浏览器
	else if (window.ActiveXObject) {
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			return xmlHttp;
		} catch (e) {
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				return xmlHttp;
			} catch (e) {
				window.alert("浏览器不支持Ajax");
				return null;
			}
		}
	}
}

// Ajax固定发起请求步骤
/*
 * 参数n为选择发起什么请求，参数m为，参数h为
 */
function AjaxSend(n,m,h) {
	// alert(n);
	var xmlHttp = initAjax();
	var url = null;
	switch (n) {
		case 0:url = userInformationManageRequest();// 发起用户数据管理请求
			break;
		case 1:url = courseInformationManageRequest();// 发起课程数据管理请求
			break;
		case 2:url = testCreateCourseDataRequest();// 发起批量添加课程请求
			break;
			
		
	}
	// 开启ajax异步
	xmlHttp.open("post", url, true);
	
	
	// 开始执行
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			var result = xmlHttp.responseText;
			// alert(xmlHttp.responseText);
			switch (n) {
			case 0:userInformationManageResponse(result);
				break;
			case 1:courseInformationManageResponse(result);
				break;
			case 2:testCreateCourseDataResponse(result);
				break;
			}
		}
	}
	xmlHttp.send();
}


//发起用户数据管理请求
function userInformationManageRequest(){
	//alert("发起用户数据管理请求");
	return url="/OnlineMooc/MoocManageServlet?functionChoise=queryUserInformationManage";
}

//返回发起用户数据管理请求结果
function userInformationManageResponse(result){
	//alert("返回发起用户数据管理请求结果");
	// 将内容转为json对象
	var jsonResponse = eval("(" + result + ")");
	// alert(jsonResponse.mUserName+jsonResponse.mUserid);
	if (jsonResponse.success == 1) {
		
		//alert("收到数据有："+jsonResponse.resultNum);
		//构造输出页面
		var page = "<table border=\"1\" style=\"border:1px solid white;\">";
		page = page + "<tr> <th>用户id</th><th>用户名</th> <th>用户密码</th>";
		page = page + "<th>绑定手机号</th><th>绑定邮箱</th><th>是否为开课者</th>";
		page = page + "<th>编辑</th><th>删除</th> </tr> ";
		for(var i=0;i<jsonResponse.resultNum;i++){
			var num = i+1;
			var userNum = "user"+num;
			//alert(num);
			//alert(jsonResponse[userNum][0]);
			page = page + " <tr> <td style=\"font-size: small;\">"+jsonResponse[userNum][0]+"</td>";
			page = page + "<td style=\"font-size: small;\">"+jsonResponse[userNum][1]+"</td>";
			page = page + "<td style=\"font-size: small;\">"+jsonResponse[userNum][2]+"</td>";
			page = page + "<td style=\"font-size: small;\">"+jsonResponse[userNum][3]+"</td>";
			page = page + "<td style=\"font-size: small;\">"+jsonResponse[userNum][4]+"</td>";
			page = page + "<td style=\"font-size: small;\">"+jsonResponse[userNum][5]+"</td>";	
			page = page + "<td><button style=\"border:1px solid #1CB177; background-color:#1CB177;color:white;width:100%;height:100%;\">编辑</button></th>";
			page = page + "<td><button style=\"border:1px solid #1CB177; background-color:#1CB177;color:white;width:100%;height:100%;\">删除</button></th>";
			
		}
		page = page + "</table>";
	//	alert(page);
		document.getElementById('manageUserInformationContainer').innerHTML=page;
		
		
	} else {
		// 返回错误信息
		alert("没查到数据");
	}
	
	
}

//发起课程数据管理请求
function courseInformationManageRequest(){
	//alert("发起课程数据管理请求");
	return url="/OnlineMooc/MoocManageServlet?functionChoise=queryCourseInformationManage";
}

//返回发起课程数据管理请求
function courseInformationManageResponse(result){
	//alert("返回发起课程数据管理请求:"+result);
	// 将内容转为json对象
	var jsonResponse = eval("(" + result + ")");
	// alert(jsonResponse.mUserName+jsonResponse.mUserid);
	if (jsonResponse.success == 1) {
		
		//alert("收到数据有："+jsonResponse.resultNum);
		//构造输出页面
		var page = "<table border=\"1\" style=\"border:1px solid white;\">";
		page = page + "<tr> <th>课程id</th><th>课程名称</th> <th>分类1级标签</th>";
		page = page + "<th>分类2级标签</th><th>课程价格</th><th>开课者id</th><th>开课时间</th>";
		page = page + "<th>编辑</th><th>删除</th> </tr> ";
		for(var i=0;i<jsonResponse.resultNum;i++){
			var num = i+1;
			var courseNum = "course"+num;
			//alert(num);
			//alert(jsonResponse[courseNum][0]);
			page = page + " <tr> <td style=\"font-size: small;\">"+jsonResponse[courseNum][0]+"</td>";
			page = page + "<td style=\"font-size: small;\">"+jsonResponse[courseNum][1]+"</td>";
			page = page + "<td style=\"font-size: small;\">"+jsonResponse[courseNum][2]+"</td>";
			page = page + "<td style=\"font-size: small;\">"+jsonResponse[courseNum][3]+"</td>";
			page = page + "<td style=\"font-size: small;\">"+jsonResponse[courseNum][4]+"</td>";
			page = page + "<td style=\"font-size: small;\">"+jsonResponse[courseNum][5]+"</td>";	
			page = page + "<td style=\"font-size: small;\">"+jsonResponse[courseNum][6]+"</td>";
			page = page + "<td><button style=\"border:1px solid #1CB177; background-color:#1CB177;color:white;width:100%;height:100%;\">编辑</button></th>";
			page = page + "<td><button style=\"border:1px solid #1CB177; background-color:#1CB177;color:white;width:100%;height:100%;\">删除</button></th>";
			
		}
		page = page + "</table>";
	//	alert(page);
		document.getElementById('manageCourseInformationContainer').innerHTML=page;
		
		
	} else {
		// 返回错误信息
		alert("没查到数据");
	}
	
	
}

//发起编辑单个用户数据请求

//返回编辑单个用户数据请求

//发起删除单个用户数据请求

//返回删除单个用户数据请求



//发起批量添加课程请求
/*
 * 获取选择数，课程名称，章节名称，小节名称样板
 */
function testCreateCourseDataRequest(){
//	alert("发起批量添加课程请求");
	//获取选择数
	var Sel = document.getElementById("generateCourseNumSelect");
	var index = Sel.selectedIndex; // 获取选中项的索引
	alert(Sel.options[index].value); //选中项的value值
	var courseChoise = Sel.options[index].value;
	//获取其他参数
	var courseNameForBatch = document.getElementById("courseNameForBatch").value;
	var isFreeForBatch = document.getElementById("isFreeForBatch").value;
	var sectionNameForBatch = document.getElementById("sectionNameForBatch").value;
	var chapterNameForBatch = document.getElementById("chapterNameForBatch").value;
	var url = "/OnlineMooc/MoocManageServlet?functionChoise=testCreateCourseData&&courseChoise="+courseChoise
		+"&&courseNameForBatch="+courseNameForBatch+"&&isFreeForBatch="+isFreeForBatch
		+"&&sectionNameForBatch="+sectionNameForBatch+"&&chapterNameForBatch="+chapterNameForBatch;
	//alert(url);
	
	return url = "/OnlineMooc/MoocManageServlet?functionChoise=testCreateCourseData&&courseChoise="+courseChoise;
}

//返回发起批量添加课程请求结果
function testCreateCourseDataResponse(result){
	//alert("返回发起批量添加课程请求结果");
	// 将内容转为json对象
	var jsonResponse = eval("(" + result + ")");
	// alert(jsonResponse.mUserName+jsonResponse.mUserid);
	if (jsonResponse.success == 3) {
		alert("批量创建课程成功");
	}else{
		alert("批量创建课程失败");
	}
}


// -------------------------------------------Ajax----------------------------End



