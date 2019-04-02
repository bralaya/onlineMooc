//js文件结构
/*
 * 1.	页面加载函数
 * 2.	一些不涉及ajax请求的操作页面函数
 * 3.	ajax请求函数和request，response函数
 * 4.	排列都按照 首页，更多课程页，详细课程页，播发页来区分各个板块
 */




//页面加载时
window.onload = function() {
	
	//轮播图
	A();
	
	// 修改导航栏上的登入状态
	if (document.getElementById('ngbarEnterSuccess').innerHTML != "") {
		document.getElementById('ngbarEnterid').style.display = 'none';
		document.getElementById('specialid').style.display = 'none';
		document.getElementById('ngbarRegisterid').style.display = 'none';
		document.getElementById('ngbarEnterSuccess').style.display = 'block';
	}

	// 课程详细内容显示页 加载时 执行查询课程详细信息函数
	// checkCeParamemter();

	// 首页加载时发起请求返回查询最新免费课程
	AjaxSend(4, 1);
	// 首页加载时发起请求返回查询最新付费课程
	AjaxSend(4, 2);
	// 查询免费热门课程
	AjaxSend(4, 3);
	// 查询付费热门课程
	AjaxSend(4, 4);
	// 查询评价最高免费课程
	AjaxSend(4,9);
	// 查询评价最高付费课程
	AjaxSend(4,10);
	
	
}

//----------------无限循环执行和停止函数（临时）---------------------------

//测试无限循环请求查询	老师是否接单句柄
var stopIt;

//测试无限循环请求查询	老师是否接单句柄
function startCheckOrderEffective(){
	var s = setInterval(function(){
		AjaxSend(19);
	},2000)
	//alert("开始无限循环请求查询	老师是否接单句柄值："+s);
	return s;
}

//测试执行停止无限循环请求查询	老师是否接单
function stopCheckOrderEffective(){
	//alert("提问者停止无限循环请求查询老师是否接单终止前的句柄值："+stopAskerQueryChatRecordItem);
	clearInterval(stopIt);
}

//测试开始提问者循环查询聊天记录句柄变量
var stopAskerQueryChatRecordItem;

//测试开始提问者循环查询聊天记录
function startAskerQueryChatRecord(){
	var itemd = setInterval(function(){
		AjaxSend(20);
	},2000)
	//alert("提问者开始提问者循环查询聊天记录句柄值："+itemd);
	return itemd;
}

//测试停止提问者查询聊天记录请求
function stopAskerQueryChatReocrd(){
	//alert("提问者停止查询聊天记录终止前的句柄值："+stopAskerQueryChatRecordItem);
	alert("停止提问者查询聊天记录请求");
	clearInterval(stopAskerQueryChatRecordItem);
	
	//变回原来样式
	alert("变回原来样式");
	
	//显示聊天界面
	document.getElementById('askerInterlocutionContainer').style.display='none';
	//隐藏评论问答板块
	document.getElementById('courseInteractContainer').style.display='block';
	//改变按钮
	document.getElementById('payquestionButton').innerHTML="付费问答";
	
}



//测试开始开课者循环查询聊天记录句柄变量
var stopTeacherQueryChatRecordItem;

//测试开始开课者循环查询聊天记录
function startTeacherQueryChatRecord(){
	var stop = setInterval(function(){
		AjaxSend(16);
	},2000)
	//alert("开始开课者循环查询聊天记录柄值："+stop);
	return stop;
}

//测试开课者停止查询聊天记录
function stopTeacherQueryChatReocrd(){
	
	alert("开课者停止查询聊天记录终止前的句柄值："+stopTeacherQueryChatRecordItem);
	clearInterval(stopTeacherQueryChatRecordItem);
	alert("停止查询聊天记录请求");
	
	//变回原来样式
	alert("变回原来样式");
	//隐藏列表，显示xx
	document.getElementById('askerListContainer').style.display="block";
	document.getElementById('teacherChatContainer').style.display="none";
	
	//重新请求查询一次订单列表
	AjaxSend(12);
	
}

//--------------------------一些不涉及ajax请求的操作页面函数---------------------------

//-----------一些不涉及ajax请求的操作页面函数-------导航栏------------------

//登入判断通用函数
function checkUserLogin(){
	if(document.getElementById('ngbarEnterSuccess').innerHTML != ""){
		alert("账号已经登入！");
		return 1;
	}else{
		alert("账号未登入！");
		return 0;
	}

}

//点击跳转到开课页
/*
 * 这里顺便做判断，其实判断属于边界内容的,那要不要提取出来，把这个函数的check单独去掉
 * 判断账号是否登入了
 * 判断账号是否绑定了手机号
 * 都达到了就跳转，否则就弹窗或者更高级
 * 
 */
function jumpToBeTeacherPageCheck(){
	//alert("呵呵");
	if(document.getElementById('ngbarEnterSuccess').innerHTML != ""){
			alert(document.getElementById('ngbarEnterSuccess').innerHTML);
		if(document.getElementById('fixedPageUserPhone').innerHTML != ""){
			alert(document.getElementById('fixedPageUserPhone').innerHTML);
			window.open("ToBeTeacher.jsp");
		}else{
			alert("账号未绑定手机号！");
		}
	}else{
		alert("账号未登入！");
	}
	
}


//导航栏点击登入/注册---》弹出登入注册框和遮罩层
function popRegisterEnter() {
	// 实际就是将隐藏的div显示出来
	document.getElementById('enterRegisterDiv').style.display = 'block';
	document.getElementById('enterRegisterMask').style.display = 'block';
}

//点击遮罩层隐藏遮罩层和登入注册弹窗
function hide() {
	document.getElementById('enterRegisterDiv').style.display = 'none';
	document.getElementById('enterRegisterMask').style.display = 'none';
}

//登入注册框里小导航栏上的选择显示登入还是注册
/*
* @参数 ==1 为选择登入,否则为选择注册
*/
function enterOrRegister(choise) {
	//alert("sb");
	if (choise == 1) {
		document.getElementById('enterDiv').style.display = 'block';
		document.getElementById('registerDiv').style.display = 'none';
	} else {
		document.getElementById('enterDiv').style.display = 'none';
		document.getElementById('registerDiv').style.display = 'block';
	}

}

//登入注册框里点击显示或隐藏邮箱注册或手机注册
/*
* 默认显示手机注册，下面显示邮箱注册，点击邮箱注册，显示邮箱注册信息，隐藏手机注册信息，同时下面的字段变为手机注册
* 参数传递1 显示邮箱注册，0显示手机注册
*/
function phoneOrMailRegist(choise){
	if(choise==1){
		//切换到邮箱注册
		document.getElementById('phoneRegistUl').style.display = 'none';
		document.getElementById('mailRegistUl').style.display = 'block';
		//alert("切换到邮箱注册");
		document.getElementById('tabPhoneOrMailRegistLi').innerHTML = "<a onclick=\"phoneOrMailRegist(0);\" style=\"font-size:small;float:right;margin-right:68px;color:grey;\">切换到手机注册</a>";
		
		
	}else{
		//切换到手机注册
		document.getElementById('mailRegistUl').style.display = 'none';
		document.getElementById('phoneRegistUl').style.display = 'block';
		//alert("切换到手机注册");
		document.getElementById('tabPhoneOrMailRegistLi').innerHTML = "<a onclick=\"phoneOrMailRegist(1);\" style=\"font-size:small;float:right;margin-right:68px;color:grey;\">切换到邮箱注册</a>";
	}
}

//跳转到我的后台
function transitionToAdmin() {
	window.location.replace("/OnlineMooc/admin/userAdmin.jsp");
}



//-------一些不涉及ajax请求的操作页面函数------首页---------------------


//首页轮播 点击一张图片隐藏其他图片
function displayOneHideOther(num){
	var rotationChartPhoto;
//	console.log(num);
	for(var a =1;a<=5;a++){
		//图片的id
		rotationChartPhoto = 'rotationChartPhoto'+a;
		//按钮的id
		rotationChartDotLi = 'rotationChartDotLi'+a;
		//console.log(linum);
		if(a == num){
			document.getElementById(rotationChartPhoto).style.display='block';
			document.getElementById(rotationChartDotLi).style.backgroundColor='#1CB177';
		}
		//喜欢装逼不写{}	
		else{
//			console.log(photonum);
			document.getElementById(rotationChartPhoto).style.display='none';
			document.getElementById(rotationChartDotLi).style.backgroundColor='white';
		}	
	}
}


//轮播图 循环轮播图片
/*每隔8秒重新调用一次函数
* 
*/
function A(){
		var a = 1;//这个要写在外头
		setInterval(function(){
		if(a > 5)
			a=1;
		//改变样式
		displayOneHideOther(a);
		a++;
		},2000);
}


//-------一些不涉及ajax请求的操作页面函数------后台管理页---------------------


//改到这里


// ---------------------------------------------------------课程详细信息页操作

// 判断是否携带了参数跳转来课程详细内容页
/*
 * 携带了参数发起ajax请求 未携带则表示无法进入此页面
 */
// 截取url
function GetRequest() {
	var url = location.search; // 获取url中"?"符后的字串
	var theRequest = new Object();
	if (url.indexOf("?") != -1) {
		var str = url.substr(1);
		strs = str.split("&");
		for (var i = 0; i < strs.length; i++) {
			theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
		}
	}
	return theRequest;
}
// 调用截取url函数并执行后续操作--------------保留的导致bug的函数
function checkCeParamemter() {
	var Request = new Object();
	Request = GetRequest();
	var sb = Request['course'];
	if (sb != null) {
		// 发起ajax请求
		AjaxSend(3);

	} else {
		// 跳转回首页
		// 我怀疑这里变成死循环，每个页面都执行那个函数判断是否有参数，没有跳转到homepage，homepage又判断....
		// 那我单独把这个写在课程页？onload时执行js？？
		alert("请勿修改url参数，不存在这个课程");
		window.location.replace("/OnlineMooc/homePage.jsp");
	}
}



// 现在先重复下这个获取参数的，后面补上课程再考虑合并优化
//播放页的检查url参数
function PlayPageGetUrl() {
	// alert("呵呵");
	var Request = new Object();
	Request = GetRequest();
	var sb = Request['mc'];
	var courseid = Request['course'];
	var loginResult = checkUserLogin();
	if (sb != null&&courseid!=null&&loginResult!=0) {
		// 发起ajax请求
		// AjaxSend(5);
		// 修改video的url
		document.getElementById('videoPlayContainer').innerHTML = "<span style=\"background-color: black;opacity: 0.7;color:white;float:left;width: 100%;padding: 10px;\">正在学习：Spring技术内幕精讲</span><video width=\"100%\" height=\"450px\" controls autoplay><source id=\"videoUrl\" src=\"course/freeCourse/"+sb+"\" type=\"video/ogg\"></video>";
		//alert(document.getElementById('videoPlayContainer').innerHTML);
		//alert("获取到的课程id:"+courseid);
		//发起请求详细课程数据的请求...未来可以和详细课程页合并
		AjaxSend(14,courseid);
		
		
	} else {
		window.location.replace("/OnlineMooc/homePage.jsp");
	}
	
}

//展示课程信息或者课程列表（播放页）
function playPageShowInformation(choise){
	if(choise==1){
		//展示课程信息
		document.getElementById('courseListForPlayContainer').style.display='none';
		document.getElementById('courseBasicInformationForPlayContainer').style.display='block';

		
	}else{
		//展示课程列表
		document.getElementById('courseBasicInformationForPlayContainer').style.display='none';
		document.getElementById('courseListForPlayContainer').style.display='block';
	}
}



// 点击购买课程链接跳转到付款页界面
/* 要先判断用户是否登入
 * 携带课程id
 */
function toPayPage() {
	//alert("跳转到购买页");
	var userid = document.getElementById('fixedPageUserid').innerHTML;
	if(userid!=""){
		var getCourseid = document.getElementById('toPayPageCourseid').innerHTML;
		alert("跳转到购买页："+getCourseid);
		window.open("/OnlineMooc/pay.jsp?mc=" + getCourseid);
	}else{
		alert("还未登入请先登入");
	}
	

}

// ----------------------------------------------------------------更多课程内容页

// 页面跳转到更多课程页时发起的查询
/*
 * 显示出1类标签，默认的更多课程查询结果，付费/免费 的所有课程
 */
function moreCoursePageAtFirstRequest() {
	var Request = new Object();
	Request = GetRequest();
	var sb = Request['payOrFree'];// 获取付费还是免费的查询条件
	if (sb != null) {
		// 发起ajax请求获取课程列表
		AjaxSend(7);

	} else {
		// 没获得参数
		window.location.replace("/OnlineMooc/homePage.jsp");
	}
}

// ---------------------------------------------------------------付款页操作

// 现在先重复下这个获取参数的，后面补上课程再考虑合并优化,这里为 付款页获取课程数据
function payCoursePageRequest() {
	// alert("呵呵");
	var Request = new Object();
	Request = GetRequest();
	var sb = Request['mc'];// 获取课程id
	//alert("传递过来的课程id:" + sb);
	if (sb != null) {
		// 发起ajax请求获取课程数据
		AjaxSend(5);

	} else {
		// 没获得参数
		window.location.replace("/OnlineMooc/homePage.jsp");
	}
}

// ----------------------------------------------------------后台用户操作

// 用户后台是否为我的课程按钮检查
/*
 * 判断按钮的内容为我开课的课程还是成为开课者然后选择相应的函数 为成为开课者直接跳转就行了，为我开课的课程则执行发起查询自己的课程的ajax请求
 */
function ifIsMyCourseButton() {
	if (document.getElementById('ifIsMyCourseButton').innerHTML == '成为开课者') {
		window.location.href = "/OnlineMooc/ToBeTeacher.jsp";
	} else {
		AjaxSend(1);
	}

}

//点击切换后台列表按钮，如账号绑定
/*
 * 命名也不知道怎么命名....
 * 
 * 后期优化，加上发起ajax请求真实数据
 */
function tabUserAdminManageList(choise){
	
	if(choise==1){
		//个人资料	
		document.getElementById('userInformationContainer').style.display = 'block';//个人资料
		document.getElementById('userContactContainer').style.display = 'none';//账号绑定
		document.getElementById('userStudyRecord').style.display = 'none';//学习课程记录
		document.getElementById('payCourseOrderRecord').style.display = 'none';//购买课程记录
		document.getElementById('courseContentContainer').style.display = 'none';//我开的课程最外层容器
		
		
	}else if(choise==2){
		//账号绑定
		document.getElementById('userInformationContainer').style.display = 'none';//个人资料
		document.getElementById('userContactContainer').style.display = 'block';//账号绑定
		document.getElementById('userStudyRecord').style.display = 'none';//学习课程记录
		document.getElementById('payCourseOrderRecord').style.display = 'none';//购买课程记录
		document.getElementById('courseContentContainer').style.display = 'none';//我开的课程最外层容器
		
	}else if(choise==3){
		//学习记录
		document.getElementById('userInformationContainer').style.display = 'none';//个人资料
		document.getElementById('userContactContainer').style.display = 'none';//账号绑定
		document.getElementById('userStudyRecord').style.display = 'block';//学习课程记录
		document.getElementById('payCourseOrderRecord').style.display = 'none';//购买课程记录
		document.getElementById('courseContentContainer').style.display = 'none';//我开的课程最外层容器
	}else if(choise==4){
		//我开的课程
		document.getElementById('userInformationContainer').style.display = 'none';//个人资料
		document.getElementById('userContactContainer').style.display = 'none';//账号绑定
		document.getElementById('userStudyRecord').style.display = 'none';//学习课程记录
		document.getElementById('payCourseOrderRecord').style.display = 'none';//购买课程记录
		document.getElementById('courseContentContainer').style.display = 'block';//我开的课程最外层容器
	}
	else{
		//购买课程记录
		document.getElementById('userInformationContainer').style.display = 'none';//个人资料
		document.getElementById('userContactContainer').style.display = 'none';//账号绑定
		document.getElementById('userStudyRecord').style.display = 'none';//学习课程记录
		document.getElementById('payCourseOrderRecord').style.display = 'block';//购买课程记录
		document.getElementById('courseContentContainer').style.display = 'none';//我开的课程最外层容器
	}
}

// 点击开新课显示开新课的div
function showNewCourseDiv() {
	document.getElementById('newCourseDiv').style.display = 'block';
}

// 章节选择后js生成课程填写内容的表单提交
/*
 * 点击章节选择，然后点击确定，直接点击确定，有默认的1个章节 点击确定后，获取章节数，在下面的div生成章节和小节选择
 * 小节选择点击确定后，再在子级生成小节数和文件上传input 暂时先做出来再考虑优化吧，暂时想不出来
 * **这里的i指的是章节数，在小节那个函数里就变成了n,而在小节里的i则是小节数
 */
function generateCourseFormPost() {

	// 扩充，获取fixedpage上的用户id
	var mUserid = document.getElementById("fixedPageUserid").innerHTML;

	// 获取章节选择结果数并提取出数字来做循环生成
	var Sel = document.getElementById("chapterSelect");
	var index = Sel.selectedIndex; // 获取选中项的索引
	// alert(Sel.options[index].value); //选中项的value值
	// 提取出选中值id的数字,,这里不影响啊，我就是从chapter1开始的，不过循环还是也从1开始吧，避免忘记++
	var chapterid = Sel.options[index].value;
	// 那连值都不需要了，直接获取index的值不就好了。
	var chapterNum = index + 1;
	// alert(chapterNum);
	// 构造课程内容填写表单，再赋值给CourseFormPostContainer的div的innerHTML
	// *这种构造其实有点蠢
	// 表单开头
	var CourseFormPostString = "<form action=\"/OnlineMooc/MoocUploadServlet\" method=\"post\" enctype=\"multipart/form-data\"><span style=\"display:none;\">用户id</span>&nbsp;<input style=\"display:none;\" type=\"text\" id=\"userid\" name=\"userid\" value=\""
			+ mUserid
			+ "\" /><br><span>课程名称</span>&nbsp;<input type=\"text\" id=\"courseName\" name=\"courseName\"><br>"
			+ "<span>课程介绍</span><br><textarea  name=\"courseIntroduce\"></textarea><br><span>课程基础要求</span><br><textarea name=\"courseRequire\" ></textarea><br>"
			+ "<div id=\"classSelectResultContainer\">"
			+ " <select id=\"courseIsFreeSelect\"><option value=\"courseIsFree1\">付费</option><option value=\"courseIsFree2\">免费</option></select><input type=\"button\" onclick=\"ifCourseFree();\" value=\"确定\" style=\"border:1px solid #1CB177; background-color:#1CB177;color:white;width:60px;height:20px;margin-left:5px; \"><input type=\"button\" onclick=\"cancelCourseifFreeChoise()\" value=\"重选\" style=\"border:1px solid #1CB177; background-color:#1CB177;color:white;width:60px;height:20px;margin-left:5px; \"><br>"
			+ "	<div id=\"payCourseContent\" style=\"display:none;\"><span>价格</span>&nbsp;<input type=\"text\" id=\"coursePrice\" name=\"coursePrice\"><br><span>课程专享服务</span>&nbsp;<textarea name=\"exclusiveService\"></textarea><br></div>"
			// 在这里添加个分类标签的div，然后点击上传课程的时候就发起ajax请求获取分类标签选择列表
			+"<div id=\"upCourseTagOneSelectContainer\"></div>"
			+"<div id=\"upCourseTagTwoSelectContainer\"></div>"
			//点击选择列表某元素后显示到下面的显示结果
			+"<div id=\"classSelectResultContainer\" style=\"display:block\">"
			+ "	<span>一级选择结果</span><input id=\"upCourseClasOneTagResult\" type=\"text\" value=\"d\" name=\"classOneResult\" readonly=\"readonly\" />"
			+ "	<span>二级选择结果</span><input id=\"upCourseClassTwoTagResult\" type=\"text\" value=\"s\" name=\"classTwoResult\" readonly=\"readonly\" />";
			+"</div>";
	

	// 中间章节块
	for (var i = 1; i <= chapterNum; i++) {
		CourseFormPostString = CourseFormPostString
				+ "<div id=\"chapter"
				+ i
				+ "Div\">"
				+ "<span>章节"
				+ i
				+ "</span>&nbsp;<input type=\"text\" name=\"chap"
				+ i
				+ "\"><br>"
				+ "<span>小节数选择</span>&nbsp;<select id=\"sectionSelect"
				+ i
				+ "\">"
				+ "<option value=\"section1\">1个小节</option><option value=\"section2\">2个小节</option><option value=\"section3\">3个小节</option><option value=\"section4\">4个小节</option><option value=\"section5\">5个小节</option><option value=\"section6\">6个小节</option><option value=\"section7\">7个小节</option><option value=\"section8\">8个小节</option></select>"
				+ "<input type=\"button\" onclick=\"generateCourseSection("
				+ i
				+ ");\" value=\"确定\" style=\"border:1px solid #1CB177; background-color:#1CB177;color:white;width:60px;height:20px;margin-left:5px;\"><input type=\"button\" onclick=\"cancleCourseSection("
				+ i + ");\" value=\"重选\" style=\"border:1px solid #1CB177; background-color:#1CB177;color:white;width:60px;height:20px;margin-left:5px;\"><br><div id=\"sectionContainer" + i
				+ "\" style=\"\"></div></div><hr>";
	}
	// 表单结尾
	CourseFormPostString = CourseFormPostString
			+ "<input type=\"submit\" value=\"提交\" style=\"border:1px solid #1CB177; background-color:#1CB177;color:white;width:60px;height:20px;\" /></form>";
	// alert(CourseFormPostString);
	document.getElementById("CourseFormPostContainer").innerHTML = CourseFormPostString;
}

// 小节选择后生成小节名称填写和文件上传
/*
 * 也是构造到字符串，然后赋值给小节div的innerHTML 具体看模板
 */
function generateCourseSection(n) {
	// alert("测试");
	// 同章节生成
	// alert("章节:"+n);
	var Sel = document.getElementById("sectionSelect" + n);
	var index = Sel.selectedIndex; // 获取选中项的索引
	var sectionNum = index + 1;
	var sectionFormPostString = "";
	for (var i = 1; i <= sectionNum; i++) {
		sectionFormPostString = sectionFormPostString + "小节名称" + i
				+ ":<input type=\"text\" name=" + "\"chap" + n + "sect" + i
				+ "\" /><br>小节" + i
				+ "视频上传<input type=\"file\" name=\"upload\" /><br>";
	}
	// alert("小节生成的内容"+sectionFormPostString);
	document.getElementById("sectionContainer" + n).innerHTML = sectionFormPostString;
}

// 增加的字段，选择付费还是免费后的执行操作
/*
 * 点击确定按钮，获取选择结果，付费显示div，并填写两条内容字段 免费则不显示div，在价格字段里填上0
 */
function ifCourseFree() {
	// 获取选择结果
	var Sel = document.getElementById("courseIsFreeSelect");
	var index = Sel.selectedIndex; // 获取选中项的索引
	// alert(Sel.options[index].innerHTML);
	if (Sel.options[index].value == "courseIsFree1") {
		// alert("付费啊");
		document.getElementById("payCourseContent").style.display = 'block';
	} else {
		document.getElementById("coursePrice").value = 0;
		//alert("价格：" + document.getElementById("coursePrice").value);
	}

}

// 撤销选择付费还是免费
/*
 * 清空价格和专享服务字段内容，然后隐藏div
 */
function cancelCourseifFreeChoise() {
	document.getElementById("payCourseContent").style.display = 'none';
	document.getElementById("coursePrice").value = '';

}

// 撤销章节选择后生成的课程表单内容
/*
 * 直接清空内容
 */
function cancelCourseFormPost() {
	document.getElementById("CourseFormPostContainer").innerHTML = "";
}

// 撤销小节选择后生成的小节表单内容
/*
 * 直接清空内容
 */
function cancleCourseSection(n) {
	document.getElementById("sectionContainer" + n).innerHTML = "";
}

//增加的字段，选择完一级列表后的操作
/*
 * 获取1级列表的选中项并显示到那个input里等待表单一起提交
 * 发起查询2级列表并显示出来二级列表选择
 */
function choiseTagOneSelect(){
	// 获取选择结果
	var Sel = document.getElementById("classoneSelect");
	var index = Sel.selectedIndex; // 获取选中项的索引
	//alert("获取结果："+Sel.options[index].innerHTML);
	document.getElementById("upCourseClasOneTagResult").value = Sel.options[index].innerHTML;
	AjaxSend(22);
	//alert("完结1级选择");
}


//增加的字段，选择完二级列表后的操作
/*
 * 获取2级列表选中项并显示到那个input里等待表单一起提交
 */
function choiseTagTwoSelect(){
	// 获取选择结果
	//alert("2级选择");
	var Sel = document.getElementById("classtwoSelect");
	var index = Sel.selectedIndex; // 获取选中项的索引
	//alert(Sel.options[index].innerHTML);
	document.getElementById("upCourseClassTwoTagResult").value =Sel.options[index].innerHTML;
	//alert("2级选择完结");
}

// ***Ajax*************Begin

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


//function AjaxSend(n,m,h) {
//	// alert(n);
//	var xmlHttp = initAjax();//初始化Ajax
//	var url = null;
//	switch (n) {
//		case 0:url = enterRequest();// 发起登入请求
//	}
//	if(url!=null){
//		// 开启ajax异步
//		xmlHttp.open("post", url, true);
//		// 开始执行
//		xmlHttp.onreadystatechange = function() {
//		if (xmlHttp.readyState == 4) {
//			var result = xmlHttp.responseText;
//			
//			switch (n) {
//			case 0:enterResponse(result);// 返回登入请求结果
//				break;	
//			}
//		}
//	}
//	xmlHttp.send();
//	}
//}	
		
		

// Ajax固定发起请求步骤
/*
 * 参数n为选择发起什么请求，参数m为，参数h为
 */
function AjaxSend(n,m,h) {
	// alert(n);
	var xmlHttp = initAjax();
	var url = null;
	switch (n) {
		case 0:url = enterRequest();// 发起登入请求
			break;
		case 1:url = queryMyCourseRequest();// 发起查询我开的课程请求
			break;
		case 2:url = quitRequest();// 发起登出请求
			break;
		case 3:url = courseDetailRequest();// 发起课程详细内容请求
			break;
		case 4:url = CourseListRequest(m);// 首页发起查询特定课程请求
			break;
		case 5:url = coursePayRequest();// 发起查询付款课程的信息请求
			break;
		case 6:url = payRequest();// 发起购买课程请求
			break;
		case 7:url = moreCoursePageTagOneRequest();//发起更多课程页1类标签内容请求
			break;
		case 8:url = moreCoursePageTagTwoRequest(m);//发起更多课程页2类标签内容请求
			break;
		case 9:url = moreCourseListRequest(m,h);//发起更多课程页的课程列表请求
			break;
		case 10:url = queryCourseCommentRequest();//发起课程评论查询请求
			break;
		case 11:url = registerRequest();//发起注册用户请求
			break;
		case 12:url = queryAskerListRequest();//开课者发起查询 提问者列表 请求
			break;
		case 13:url = questionAskRequest();//提问者发起 提问 请求 
			break;
		case 14:url = courseDetailForPlayPageRequest(m);//播放页发起 课程详情 请求
			break;
		case 15:url = acceptOrderRequest(m,h);//开课者 发起 接单请求
			break;
		case 16:url = queryUpToDataMessageRequest();//开课者 发起的查询聊天列表请求
			break;
		case 17:url = askerSendMessageRequest();//提问者发送消息请求
			break;
		case 18:url = teacherSendMessageRequest();//开课者发送消息请求
			break;
		case 19:url = queryifTeacherHasTakingOrderRequest();//提问者 查询开课者是否接单的请求
			break;
		case 20:url = askerQueryUpToDataMessageRequest();// 提问者 发起的查询聊天列表请求
			break;
		case 21:url = queryTagOneListForUpCourseRequest();//发起查询1类标签列表给上传课程
			break;
		case 22:url = queryTagTwoListForUpCourseRequest()//发起查询2类标签列表给上传课程
			break;
		case 23:url = studyAtOnceRequest();//发起 立即 开始学习请求
			break;
		
	}
	
	
	if(url!=null){
		// 开启ajax异步
		xmlHttp.open("post", url, true);
		// 开始执行
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				var result = xmlHttp.responseText;
				// alert(xmlHttp.responseText);
				switch (n) {
				case 0:enterResponse(result);
					break;
				case 1:queryMyCourseResponse(result);
					break;
				case 2:quitResponse(result);
					break;
				case 3:courseDetailResponse(result);
					break;
				case 4:CourseListResponse(result, m);
					break;
				case 5:coursePayResponse(result);
					break;
				case 6:	payResponse(result);
					break;
				case 7:moreCoursePageTagOneResponse(result);
					break;
				case 8:moreCoursePageTagTwoResponse(result);
					break;
				case 9:moreCourseListResponse(result);
					break;
				case 10:queryCourseCommentResponse(result);
					break;
				case 11:registerResponse(result);
					break;
				case 12:queryAskerListResponse(result);
					break;
				case 13:questionAskResponse(result);
					break;
				case 14:courseDetailForPlayPageResponse(result);
					break;
				case 15:acceptOrderResponse(result);
					break;
				case 16:queryUpToDataMessageResponse(result);
					break;
				case 17:askerSendMessageResponse(result);
					break;
				case 18:teacherSendMessageResponse(result);
					break;
				case 19:queryifTeacherHasTakingOrderResponse(result);
					break;
				case 20:askerQueryUpToDataMessageResponse(result);
					break;
				case 21:queryTagOneListForUpCourseResponse(result);
					break;
				case 22:queryTagTwoListForUpCourseResponse(result);
					break;
				case 23:studyAtOnceResponse(result);
					break;
				}
			}
		}
		xmlHttp.send();
	}
	
	
	
	
	
}

// --------------------付费问答模块---------------------

//学习者发起 提问 请求
/*
 * 要传递来开课者id，提问者id，课程id,开课者姓名，提问者姓名，课程名称，
 * 课程名称，开课者姓名到servlet那边再查询
 */
function questionAskRequest(){
	alert("发起 付费提问 请求");
	//获取提问者id,登入的用户
	var askerid  = document.getElementById('fixedPageUserid').innerHTML;
	//alert("获取提问者id"+askerid);
	//获取提问者姓名
	var askerName = document.getElementById('fixedPageUserName').innerHTML;
	//alert("获取提问者姓名"+askerName);
	//获取课程id
	var courseid  = document.getElementById('playPageCourseid').innerHTML;
	//alert("获取课程id"+courseid);
	//获取课程名称
	var courseName = document.getElementById('playPageCourseName').innerHTML;
	//alert("获取课程名称"+courseName);
	//获取开课者id
	var teacherid = document.getElementById('playPageTeacherid').innerHTML;
	//alert("获取开课者id"+teacherid);
	//获取开课者姓名
	var teacherName = document.getElementById('playPageTeacherName').innerHTML;
//	alert("获取开课者姓名"+teacherName);
	var url = "/OnlineMooc/MoocServlet?functionChoise=questionAsk&&askerid="+askerid+"&&askerName="+askerName+"&&courseid="+courseid+"&&courseName="+courseName+"&&teacherid="+teacherid+"&&teacherName="+teacherName;
	//alert(encodeURI(url));
	return encodeURI(url);
}




//返回学习者 提问请求 结果
function questionAskResponse(result){
	// 将内容转为json对象
	var jsonResponse = eval("(" + result + ")");
	// alert("用户id:"+jsonResponse.mUserid);
	if (jsonResponse.success == 1) {
		//改变按钮样式为等待老师接单回复
		
		document.getElementById('payquestionButton').innerHTML="等待老师接单回复";
		//保存返回的订单，执行无限循环请求检查老师是否接单
		
		//alert("返回的订单id:"+jsonResponse.orderid);
		

		//将返回的订单保存到某个位置
		document.getElementById('returnPayQuestionOrderid').innerHTML=jsonResponse.orderid;
		
		//alert("准备进入无限循环执行检察老师是否接单");
		
		//执行无限循环请求 检查老师 是否 接单
		stopIt = startCheckOrderEffective();
		
		
	} else {
		// 返回错误信息
		alert("发起提问出错");
	}
}

//发起提问者查询 开课者是否接单了 的请求
/*
 * 传递的参数：获取返回的订单id，
 * 然后发起查询请求,查询对应数据的生效值是否为true不是就继续发起那就不用写定时执行了用递归？？？
 */
function queryifTeacherHasTakingOrderRequest(){
	//alert("发起提问者查询 开课者是否接单了 的请求");
	var orderid= document.getElementById('returnPayQuestionOrderid').innerHTML;
	//alert(orderid);
	return url ="/OnlineMooc/MoocServlet?functionChoise=queryOrderCondition&&payquestionOrderid="+orderid;
}




//返回提问者查询 开课者是否接单了  的结果
function queryifTeacherHasTakingOrderResponse(result){
	
	//alert("返回提问者查询 开课者是否接单了  的结果");
	
	// 将内容转为json对象
	var jsonResponse = eval("(" + result + ")");
	// alert("用户id:"+jsonResponse.mUserid);
	if (jsonResponse.success == 1) {
		//跳转到交流界面
		alert("教师已接单，进入问答界面");	
		//显示聊天界面
		document.getElementById('askerInterlocutionContainer').style.display='block';
		//隐藏评论问答板块
		document.getElementById('courseInteractContainer').style.display='none';
		//改变按钮
		document.getElementById('payquestionButton').innerHTML="付费问答进行中";
		
		
		//终止循环发起查询接单请求函数
		stopCheckOrderEffective();
		//alert("终止了循环发起查询接单请求操作");
		
		//开始循环执行查询聊天记录函数和是否结束订单函数
		
		stopAskerQueryChatRecordItem = startAskerQueryChatRecord();
		//alert("开始循环执行查询聊天记录函数和是否结束订单函数");
		
		
	} else {
		//继续发送AjaxSend
		alert("教师还未接单");
	}
}

//开课者发起 查询付费提问订单请求列表 请求
/*
 * 传递这个密钥串（开课者id），在servlet那里获取课程id，再去记录表里查询这个课程当前提问者的数量，且值为false
 */
function queryAskerListRequest(){
	//这里暂时写死001的id，要从url上获取
	var teacherid = "26791e89-82a1-45c0-800f-f709f20f";
//	alert("开课者发起 查询提问者请求列表 请求");
	return url = "/OnlineMooc/MoocServlet?functionChoise=queryAskerList&&teacherid="+teacherid;
}

//返回开课者发起 查询付费提问订单请求列表 请求结果
function queryAskerListResponse(result){
//	alert("返回开课者发起 查询提问者请求列表 请求");
	document.getElementById('askerListContainer').innerHTML=result;
}



//开课者发起 接单 请求
/*
 * 这里要传递开课者id，提问者id，课程id，然后到表里修改值为true
 * 那之前的订单列表上就要有这些值了。
 */
function acceptOrderRequest(Orderid,num){
	var payquestionOrderid = Orderid;
//	alert(payquestionOrderid);
	//顺便把订单数据保存到一个div里
	var questionAskerid = "questionAskerid"+num;
    var questionCourseid= "questionCourseid"+num;
    var questionAskerName = "questionAskerName"+num;
	//这里把对应的数据保存到js里.
    //其实这里应该写在result那里的返回成功结果再保存，，，未来优化
	document.getElementById('saveAskerid').innerHTML =document.getElementById(questionAskerid).innerHTML;
	document.getElementById('saveCourseid').innerHTML =document.getElementById(questionCourseid).innerHTML;
	document.getElementById('saveAskerName').innerHTML =document.getElementById(questionAskerName).innerHTML;
	return url = "/OnlineMooc/MoocServlet?functionChoise=acceptOrder&&payquestionOrderid="+payquestionOrderid;
}

//返回开课者接单请求结果
/*
 * 成功后返回结果，并跳转到交流界面
 */
function acceptOrderResponse(result){
	// 将内容转为json对象
	var jsonResponse = eval("(" + result + ")");
	// alert("用户id:"+jsonResponse.mUserid);
	if (jsonResponse.success == 1) {
		//跳转到交流界面
		alert("接单成功，现在开始和学生进行答疑");
		
		//隐藏列表，显示xx
		document.getElementById('askerListContainer').style.display="none";
		document.getElementById('teacherChatContainer').style.display="block";
		
		
		//发起不断刷新显示聊天记录的请求
		
		stopTeacherQueryChatRecordItem = startTeacherQueryChatRecord();
		
	//	alert("发起不断刷新显示聊天记录的请求");
		
	} else {
		// 返回错误信息
		alert("接单失败");
	}
}

//发起 老师 【查询最新所有聊天记录】 请求请求
/*
 * 需要传递的参数：开课者id,提问者id,课程id,
 * 
 */
function queryUpToDataMessageRequest(){
//	alert("发起 老师 【查询最新所有聊天记录】 请求");
	
//	var teacherid ="26791e89-82a1-45c0-800f-f709f20f";
//	var askerid = document.getElementById('saveAskerid').innerHTML;
//	var courseid =document.getElementById('saveCourseid').innerHTML;
	
	//增加获取本次订单id
	var thistimeOrder = document.getElementById('askerListOrderid').innerHTML;
//	alert("开课者接单的订单id:"+thistimeOrder);
	
	var url = "/OnlineMooc/MoocServlet?functionChoise=queryUpToDataMessage&&thisTimeOrderid="+thistimeOrder;
	
//	alert("发起 老师 【查询最新所有聊天记录】 请求请求url:"+url);
	return url;
}


//返回 老师 【查询最新所有聊天记录】 请求结果
/*
 * 返回的消息里有：发送者姓名：消息
 * 发送者姓名和当前页面的用户名一样的话，改颜色为蓝色
 */
function queryUpToDataMessageResponse(result){
//	alert("返回 老师 【查询最新所有聊天记录】 请求结果");
	document.getElementById('teacherChatMessageListContainer').innerHTML="";
	document.getElementById('teacherChatMessageListContainer').innerHTML=result;
}


//发起 学生【查询最新所有聊天记录】 请求
/*
 * 传递的参数:开课者id,提问者id,课程id,
 */
function askerQueryUpToDataMessageRequest(){
//	alert("发起 学生【查询最新所有聊天记录】 请求");
	
	//var teacherid ="26791e89-82a1-45c0-800f-f709f20f";
	//var askerid = document.getElementById('fixedPageUserid').innerHTML;//从用户导航栏获取
	//var courseid =document.getElementById('playPageCourseid').innerHTML;//
	

	//增加获取提问者本次订单id
	var thistimeOrder = document.getElementById('returnPayQuestionOrderid').innerHTML;
	
	var url = "/OnlineMooc/MoocServlet?functionChoise=queryUpToDataMessage&&thisTimeOrderid="+thistimeOrder;
//	alert("发起 学生【查询最新所有聊天记录】 请求url:"+url);
	return url;
}

//返回 学生【查询最新所有聊天记录】 请求结果
function askerQueryUpToDataMessageResponse(result){
//	alert("返回提问者发起查询最新的消息（聊天所有记录）的请求");
	document.getElementById('askerChatMessageListContainer').innerHTML="";
	document.getElementById('askerChatMessageListContainer').innerHTML=result;
}




//提问者发起消息 请求
/*
 * 需要传递的参数：消息内容，发送者id,发送者姓名，所属课程id，接收者id,接收者姓名
 * 播放页这里的话参数全都在页面上 了不需要到servlet里再获取了
 * 
 */
function askerSendMessageRequest(){
//	alert("提问者发送消息");
	
	var message = document.getElementById('askerSendMessageContent').value;
//	alert("消息"+message);
	
	if(message!=""){
		var askerid = document.getElementById('fixedPageUserid').innerHTML;
	//	alert("提问者id"+askerid);
		
		var askerName = document.getElementById('fixedPageUserName').innerHTML;
	//	alert("提问者名称"+askerName);
		
		var teacherid = document.getElementById('playPageTeacherid').innerHTML;
	//	alert("老师id"+teacherid);
		
		var teacherName = document.getElementById('playPageTeacherName').innerHTML;
	//	alert("老师名称"+teacherName);
		
		var courseid = document.getElementById('playPageCourseid').innerHTML;
	//	alert("课程id"+courseid);

		//新增订单id
		var payQuestionOrderid = document.getElementById('returnPayQuestionOrderid').innerHTML;
	//	alert("订单id"+payQuestionOrderid);
		
		var url = "/OnlineMooc/MoocServlet?functionChoise=payQuestionAskerSendMessage&&senderid="+askerid
				+"&&receiverid="+teacherid+"&&senderName="+askerName+"&&receiverName="+teacherName+"&&courseid="+courseid
				+"&&payQuestionOrderid="+payQuestionOrderid+"&&message="+message;
	//	alert(url);
	//	alert(encodeURI(url));
		return encodeURI(url); 
	}else{
		return null;
		
	}
	
	
}

//返回提问者发起消息 结果
/*
 * 1成功 0失败
 */
function askerSendMessageResponse(result){
	// 将内容转为json对象
	var jsonResponse = eval("(" + result + ")");
	// alert("用户id:"+jsonResponse.mUserid);
	if (jsonResponse.success == 1) {
	//	alert("发送成功");
		//清空发送框消息
		document.getElementById('askerSendMessageContent').value="";
	} else {
		// 返回错误信息
		alert("发送失败");
		
	}
}

//开课者 发起消息 请求
/*
 * 获取的参数:开课者id,课程id,提问者id,提问者名称,消息内容
 * 到servlet里查询开课者名称
 */
function teacherSendMessageRequest(){
	
//	alert("开课者发送消息");
	
	//对消息进行空内容判断
	if(message!=""){
		//增加获取本次订单id
		var thistimeOrder = document.getElementById('askerListOrderid').innerHTML;
	//	alert("开课者接单的订单id:"+thistimeOrder);
		
		var teacherid = "26791e89-82a1-45c0-800f-f709f20f";//暂时写死
	//	alert("老师id"+teacherid);
		
		var courseid = document.getElementById('saveCourseid').innerHTML;
	//	alert("课程id"+courseid);
		
		var askerid = document.getElementById('saveAskerid').innerHTML;
	//	alert("提问者id"+askerid);
		
		var askerName = document.getElementById('saveAskerName').innerHTML;
	//	alert("提问者姓名"+askerName);
		
		var message = document.getElementById('teacherSendMessageContent').value;
	//	alert("消息"+message);
		
		var url = "/OnlineMooc/MoocServlet?functionChoise=payQuestionTeacherSendMessage&&senderid="+teacherid+"&&receiverid="+askerid+"&&receiverName="+askerName+"&&courseid="+courseid+"&&payQuestionOrderid="+thistimeOrder+"&&message="+message;
	//	alert(url);
	//	alert(encodeURI(url));
		return encodeURI(url); 
		
	}else{
		alert("不允许发生空内容");
		return null;
	}
	
	
	
	
	
	
	
}

//返回开课者 发起消息 请求结果
function teacherSendMessageResponse(result){
	// 将内容转为json对象
	var jsonResponse = eval("(" + result + ")");
	// alert("用户id:"+jsonResponse.mUserid);
	if (jsonResponse.success == 1) {
	//	alert("发送成功");
		//清空消息
		document.getElementById('teacherSendMessageContent').value="";
	} else {
		// 返回错误信息
		alert("发送失败");
		
	}
}

// -------------------登入注册模块------------------

// 发起用户登入请求
/*
 * 请求发起前，已经对手机号进行判断了，到时还有个邮箱号到时再修改，增加一个判断值就行了
 */
function enterRequest() {
	// 这里到时再修改，先弄为手机的
	var phoneGet = document.getElementById("phoneid").value;
	var passwdGet = document.getElementById("passwdid").value;
	var url = "/OnlineMooc/MoocServlet?functionChoise=moocEnterCheck&&phone="
			+ phoneGet + "&&passwd=" + passwdGet;
	return url;
}

// 返回登入请求的结果
/*
 * 返回json结果，成功登入返回用户名，头像，等，成功值，失败返回失败值，失败原因，然后这里显示登入失败和原因 成功则刷新首页，失败则显示错误信息
 */
function enterResponse(result) {
	// 将内容转为json对象
	var jsonResponse = eval("(" + result + ")");
	// alert("用户id:"+jsonResponse.mUserid);
	if (jsonResponse.success == 1) {
		// 刷新页面
		location.reload();
	} else {
		// 返回错误信息
		alert("登入失败");
	}
}

//发起注册请求
/*
 * 
 */
function registerRequest(){
	var registerPhoneGet = document.getElementById("registerPhone").value;
	var registerPasswdGet = document.getElementById("registerPhonePasswd").value;
	var url = "/OnlineMooc/MoocServlet?functionChoise=moocRegister&&registerPhone="
			+ registerPhoneGet + "&&registerPasswd=" + registerPasswdGet;
//	alert(url);
	return url;
	
}

//返回注册请求结果
function registerResponse(result){
	// 将内容转为json对象
	var jsonResponse = eval("(" + result + ")");
	// alert("用户id:"+jsonResponse.mUserid);
	if (jsonResponse.success == 1) {
		alert("注册成功");
		//跳转到首页
		window.location.replace("/OnlineMooc/homePage.jsp");
		
		
	} else {
		// 返回错误信息...到时优化为显示错误信息在input下面
		alert("注册失败");
	}
}

// 发起安全退出用户账户请求
/*
 * 这里也不用传什么用户的id过去吧，直接清空session就行了。
 */
function quitRequest() {
	return url = "/OnlineMooc/MoocServlet?functionChoise=moocUserQuit";
}

// 返回安全退出请求结果
/*
 * 成功退出刷新跳转到首页
 */
function quitResponse(result) {
	// 将内容转为json对象
	var jsonResponse = eval("(" + result + ")");
	// alert(jsonResponse.mUserName+jsonResponse.mUserid);
	if (jsonResponse.success == 1) {
		// 跳转到首页
		alert("安全退出！");
		window.location.replace("/OnlineMooc/homePage.jsp");
	} else {
		// 返回错误信息
		alert("退出失败");
	}
}

// -------------------用户后台模块------------

// 发起查询我开的课程内容的请求（用户后台）
/*
 * 
 */
function queryMyCourseRequest() {
	var userid = null;
	var url = "/OnlineMooc/MoocServlet?functionChoise=queryMyCourse&&userid="+ userid;
	return url;
}

// 返回我开的课程内容请求结果（用户后台）
/*
 * 直接输出到页面上就行了
 */
function queryMyCourseResponse(result) {
	document.getElementById('myCourseDiv').innerHTML = result;
}


// 发起查询分类标签1级列表
function queryTagOneListForUpCourseRequest(){
	return url  = "/OnlineMooc/MoocServlet?functionChoise=queryTagOneListForUpCourse";
}

//返回发起查询分类标签1级列表结果
function queryTagOneListForUpCourseResponse(result){
	document.getElementById('upCourseTagOneSelectContainer').innerHTML = result;
}


//发起查询分类标签2级列表
function queryTagTwoListForUpCourseRequest(){
	var tagOneName = document.getElementById("upCourseClasOneTagResult").value ;
	return url  = "/OnlineMooc/MoocServlet?functionChoise=queryTagTwoListForUpCourse&&tagOneName="+tagOneName;
}

//返回发起查询分类标签2级列表结果
function queryTagTwoListForUpCourseResponse(result){
//	alert("返回发起查询分类标签2级列表结果");
	document.getElementById('upCourseTagTwoSelectContainer').innerHTML = result;
}

// -------------------慕课首页模块------------

// 发起查询特定课程请求
function CourseListRequest(courseListChoise) {
	return url = "/OnlineMooc/MoocServlet?functionChoise=queryCourseList&&courseTypeChoise="
			+ courseListChoise;
}

// 获取查询特定课程结果
function CourseListResponse(result, courseListChoise) {
	var showDiv = "";
	switch (courseListChoise) {
	case 1:
		showDiv = "newFreeCourseContainer";
		break;
	case 2:
		showDiv = "newPayCourseContainer";
		break;
	case 3:
		showDiv = "freeHotCourseContainer";
		break;
	case 4:
		showDiv = "payHotCourseContainer";
		break;
	case 9:
		showDiv = "qualityHighFreepayCourseContainer";
		break;
	case 10:
		showDiv = "qualityHighPayCourseContainer";
		break;
	}
	// 输出到对应课程容器
	document.getElementById(showDiv).innerHTML = result;

}

// ------------------更多课程页---------------

//页面跳转到更多课程页时发起的	获取1类标签按钮的请求
function moreCoursePageTagOneRequest(){

	return url = "/OnlineMooc/MoocServlet?functionChoise=queryClassOneTag";
	
}

//返回上面的结果
function moreCoursePageTagOneResponse(result){
	//输出返回结果，1类标签
	document.getElementById('classOneTagContanier').innerHTML = result;	
}

//页面跳转到更多课程页时发起的	获取2类标签按钮的请求
function moreCoursePageTagTwoRequest(classOneTag){
//	alert("发起了2类标签请求");
//	alert(typeof(classOneTag));
//	alert(classOneTag);
//	alert("/OnlineMooc/MoocServlet?functionChoise=queryClassTwoTag&&classOneTag="+classOneTag	);
	return url = "/OnlineMooc/MoocServlet?functionChoise=queryClassTwoTag&&classOneTag="+encodeURI(classOneTag);
}

//返回上面的结果
function moreCoursePageTagTwoResponse(result){
	//输出返回结果,2类标签
	document.getElementById('classTwoTagContainer').innerHTML = result;	
}


//页面跳转到更多课程页和点击标签按钮时 发起特定条件的课程列表查询请求
function moreCourseListRequest(tagName,isTagOne){
//	alert("测试");
	//获取付费还是免费的参数
	var Request = new Object();
	Request = GetRequest();
	var sb = Request['payOrFree'];// 获取付费还是免费的查询条件
	if (sb != null) {
		//获取类别查询的参数,点击onclick时获取传递来的参数然后构造url
	//	alert("/OnlineMooc/MoocServlet?functionChoise=queryMoreCourseList&&tagName="+encodeURI(tagName)+"&&payOrFree="+sb+"&&isTagOne="+isTagOne);
		return url = "/OnlineMooc/MoocServlet?functionChoise=queryMoreCourseList&&tagName="+encodeURI(tagName)+"&&payOrFree="+sb+"&&isTagOne="+isTagOne;
		
	}
	
	
}

//返回特定条件的课程列表查询结果
function moreCourseListResponse(result){
	document.getElementById('showMoreCourseContainer').innerHTML = result;	
	
}

//发起课程评论提交请求
function courseCommentSubmitRequest(){
	var userid = "";
	var courseid = "";
	return url = "/OnlineMooc/MoocServlet?functionChoise=courseCommentSubmit&&userid="+userid+"&&courseid="+courseid;
}

//返回课程评论提交请求结果
function courseCommentSubmitResponse(result){
	// 将内容转为json对象
	var jsonResponse = eval("(" + result + ")");
	// alert(jsonResponse.mUserName+jsonResponse.mUserid);
	if (jsonResponse.success == 1) {
		// 跳转到首页
		alert("成功发表评论！");
		//刷新当前页面
		// window.location.replace("/OnlineMooc/homePage.jsp");
	} else {
		// 返回错误信息
		alert("发表评论失败！");
	}
}

//发起课程评论内容查询
function queryCourseCommentRequest(){
//	alert("课程");
	var courseid = document.getElementById('toPayPageCourseid').innerHTML;
//	alert("课程id：" + courseid);
	return url = "/OnlineMooc/MoocServlet?functionChoise=queryCourseComment&&courseid="+courseid;
}

//返回课程评论内容查询
function queryCourseCommentResponse(result){
	document.getElementById('courseCommentContainer').innerHTML = result;
}

// -------------------课程详细内容页模块------------

// 发起课程详细内容页请求
function courseDetailRequest() {
	var Request = new Object();
	Request = GetRequest();
	var sb = Request['course'];
	// alert("sb:"+sb);
	
		return url = "/OnlineMooc/MoocServlet?functionChoise=queryCourseDetail&&courseid="
			+ sb;
}

// 获取课程详细内容返回结果
function courseDetailResponse(result) {
//	alert(result);
	document.getElementById('courseDetailContainer').innerHTML = result;
}

// 发起学习课程请求
/*
 * 先判断用户是否登入（这里可以考虑提取出去共用）
 * 要写入到课程学习记录表，课程表人数字段，需要课程id，用户id
 * 
 */
function studyAtOnceRequest() {
//	alert("发起学习课程请求");
	var userid = document.getElementById('fixedPageUserid').innerHTML;
	if(userid!=""){
		var courseid = document.getElementById('toPayPageCourseid').innerHTML;
	//	alert("发起学习课程请求的用户id:"+userid );
	//	alert("发起学习课程请求的课程id:"+courseid );
		return url = "/OnlineMooc/MoocServlet?functionChoise=studyBeginRecord&&userid="
				+ userid + "&&courseid=" + courseid;
	}else{
		alert("用户还未登入");
		return url = null;
	}
	
}



// 返回学习课程请求结果
function studyAtOnceResponse(result) {
//	alert(result);
//	alert("返回学习课程请求");
//	alert("返回学习课程请求2");
	// 将内容转为json对象
	var jsonResponse = eval("(" + result + ")");
//	alert("返回学习课程请求3");
//	alert("返回学习课程请求结果值："+jsonResponse.success);
	if (jsonResponse.success == 1) {
		// 跳转刷新课程详细内容页
		alert("获得学习课程资格！");
		//跳转刷新原页面
		var courseid = document.getElementById('toPayPageCourseid').innerHTML;
	//	alert("跳转回原页面的课程id:"+courseid);
		window.location.replace("/OnlineMooc/courseContentPage.jsp?course="+courseid);
		
	}else {
		// 返回错误信息
		alert("未获得学习课程资格！请重试");
	}

}

//--------------------课程播放页模块---------

//发起查询课程详细内容请求（播发页）
/*
 * 要传入课程id
 */
function courseDetailForPlayPageRequest(m){
//	alert("传入的课程id:"+m);
	return url = "/OnlineMooc/MoocServlet?functionChoise=queryCourseDetailForPlayPage&&courseid="+m;
}

//返回查询课程详细内容请求（播发页）
function courseDetailForPlayPageResponse(result){
	document.getElementById('courseInformationContainer').innerHTML = result;
}

// -------------------课程付款页模块------------

// 发起付款页的查询课程信息请求
function coursePayRequest() {
	var Request = new Object();
	Request = GetRequest();
	var sb = Request['mc'];
//	alert("sb:" + sb);
	return url = "/OnlineMooc/MoocServlet?functionChoise=queryPayCourseMessage&&courseid="
			+ sb;
}

// 返回付款页查询的信息结果
function coursePayResponse(result) {
//	alert(result);
	document.getElementById('payCourseContainer').innerHTML = result;
}

// 发起购买课程请求
/*
 * @传递参数，课程id,用户id，保存到课程购买记录表里
 */
function payRequest() {
//	 alert("发起购买课程请求");
	 
	// 获取课程id，用户id，课程价格
	// alert(document.getElementById('fixedPageUserid').innerHTML);
	 //alert(document.getElementById('payCourseid').innerHTML);
	var userid = document.getElementById('fixedPageUserid').innerHTML;
	if(userid!=""){
		var courseid = document.getElementById('payCourseid').innerHTML;
		var courseprice = document.getElementById('payCoursePrice').innerHTML;
		// alert("发起购买课程时获取的课程价格："+document.getElementById('payCoursePrice').innerHTML);//
		// alert("呵呵");
	//	alert("发起购买课程时要传递的url:"
	//			+ "/OnlineMooc/MoocServlet?functionChoise=payCourse&&userid="
	//			+ userid + "&&courseid=" + courseid + "&&courseprice="
	//			+ courseprice);

		return url = "/OnlineMooc/MoocServlet?functionChoise=payCourse&&userid="
				+ userid + "&&courseid=" + courseid + "&&courseprice="
				+ courseprice;
	}else{
		alert("用户未登入！");
		return url = null;
	}
	
}

// 得到购买课程返回结果
/*
 * 购买成功跳转回课程详细内容页，并修改状态，修改状态为另外的操作，这里不用管 失败显示失败呗
 */
function payResponse(result) {
	// 将内容转为json对象
	var jsonResponse = eval("(" + result + ")");
	// alert(jsonResponse.mUserName+jsonResponse.mUserid);
	if (jsonResponse.success == 1) {
		
		alert("购买成功！");
		//跳转..获取页面的课程id..跳转回详细课程页
		var courseid = document.getElementById('payCourseid').innerHTML;
	//	alert("付款页的购买课程id:"+courseid);
		window.location.replace("/OnlineMooc/courseContentPage.jsp?course="+courseid);
	} else {
		// 返回错误信息...然后用户要怎么办？
		alert("购买失败！");
	}
}

//------------------课程播放页模块------------

//发起查询当前用户和对应开课者的消息查询请求
/*
 * 需要知道提问者id，各种作为一次发送者和接收者
 * 
 */
function queryPayQuestionMessageRecordRequest(){
	var userid = document.getElementById('fixedPageUserid').innerHTML;
	return url = "/OnlineMooc/MoocServlet?functionChoise=queryPayQuestionMessageRecord&&userid="+ userid;
	
}

//返回查询当前用户和对应开课者的消息查询结果
function queryPayQuestionMessageRecordResponse(){
	document.getElementById('payCourseContainer').innerHTML = result;

}


//  ***Ajax*************END 

