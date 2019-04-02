package MoocServlet;


//begin
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//end,这些我都没手写，只是把下面的继承写下上面就自动补充了HttpServlet,把doGet和doPost写下就自动补充了上面这些
import javax.servlet.http.HttpSession;


import MoocDAO.MoocExtendDao;
import MoocData.MoocCommentData;
import MoocData.MoocCourseData;
import MoocData.MoocPayQuestionCommunicateData;
import MoocData.MoocPayQuestionOrderData;
import MoocData.MoocRecordData;
import MoocData.MoocTagData;
import MoocData.MoocUserData;

@WebServlet("/MoocServlet")
public class MoocServlet extends HttpServlet {
	
	public static void main(String[] args) {
		//测试
		MoocExtendDao extendDao = new MoocExtendDao();
		try {
			//为什么这里加了true参数后就要放在try catch块里否则报错?
			ArrayList<MoocUserData> userList = extendDao.LoginCheck("22222222222", "ddddd",true);
			if(userList==null) {
				System.out.println("没有查询到结果");
			}
			else {
				System.out.println("查询到结果为:"+userList.size()+":"+userList.get(0).getmUsername());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html;charset  = UTF-8");
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset  = UTF-8");//这里不写会如何？
		//获取传递过来的方法选择参数
		String functionChoise = request.getParameter("functionChoise");
		//执行登入校验方法
		if (functionChoise.equals("moocEnterCheck")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				
				moocEnterCheck(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//执行退出登入方法
		if (functionChoise.equals("moocUserQuit")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				moocUserQuit(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		//执行注册请求
		if (functionChoise.equals("moocRegister")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				moocRegister(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//执行查询课程详细内容方法(课程详细内容页)
		if (functionChoise.equals("queryCourseDetail")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				queryCourseDetail(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		//执行查询课程对应的所有评论（课程详细内容页）
		if (functionChoise.equals("queryCourseComment")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				queryCourseComment(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		//发起开始学习请求（课程详细内容页）
		if (functionChoise.equals("studyBeginRecord")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				studyBeginRecord(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//查询课程详情（课程播发页）
		if (functionChoise.equals("queryCourseDetailForPlayPage")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				queryCourseDetailForPlayPage(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		//查询1级标签列表给课程上传（用户后台）
		if (functionChoise.equals("queryTagOneListForUpCourse")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				queryTagOneListForUpCourse(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//查询2级标签列表给课程上传（用户后台）
		if (functionChoise.equals("queryTagTwoListForUpCourse")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				queryTagTwoListForUpCourse(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//查询我开的课程（用户后台）
		if (functionChoise.equals("queryMyCourse")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				
				queryMyCourse(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//课程上传完跳转到这个Servlet进行数据库写入并返回处理结果到后台页（用户后台）
		if (functionChoise.equals("CourseMessageHandle")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				
				CourseMessageHandle(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//查询免费课程列表（慕课首页）
		if (functionChoise.equals("queryCourseList")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				
				queryCourseList(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//查询显示出标签按钮（更多课程页）
		if (functionChoise.equals("queryClassOneTag")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				
				queryClassOneTag(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//查询显示出标签按钮（更多课程页）
				if (functionChoise.equals("queryClassTwoTag")) {
					//there (try..catch) i remember copy from teacher,didn't know why
					try {
						
						queryClassTwoTag(request, response);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
		//查询特定条件的课程列表（更多课程页）
		if (functionChoise.equals("queryMoreCourseList")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				
				queryMoreCourseList(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//查询购买课程需要的课程信息（课程购买页）
		if (functionChoise.equals("queryPayCourseMessage")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				
				queryPayCourseMessage(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		//执行购买课程请求（购买课程页）
		if (functionChoise.equals("payCourse")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				payCourse(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//执行学习者发起提问请求（付费问答）
		if (functionChoise.equals("questionAsk")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				questionAsk(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//执行提问者发起提问者请求列表查询（付费问答）
		if (functionChoise.equals("queryAskerList")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				queryAskerList(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//执行提问者 接收订单 请求（付费问答）
		if (functionChoise.equals("acceptOrder")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				acceptOrder(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//执行 提问者|开课者 聊天信息显示 请求 （付费问答）
		if (functionChoise.equals("queryUpToDataMessage")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				queryUpToDataMessage(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//开课者发送消息请求（付费问答）
		if (functionChoise.equals("payQuestionTeacherSendMessage")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				payQuestionTeacherSendMessage(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//提问者发送消息请求（付费问答）
		if (functionChoise.equals("payQuestionAskerSendMessage")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				payQuestionAskerSendMessage(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//提问者 查询开课者是否接单了的请求（付费问答）
		if (functionChoise.equals("queryOrderCondition")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				queryOrderCondition(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	//function need to write out there ，and don't know why should write (HttpServletRequest request, HttpServletResponse response)
	//登入校验方法
	public void moocEnterCheck(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//session声明
		HttpSession session = request.getSession();
		
		//获取传入的参数:账号,密码,是否为手机号
		String accountParameter = request.getParameter("phone");
		String passwdParameter = request.getParameter("passwd");
		String isPhoneParameter = request.getParameter("isPhone");
		boolean isPhone = false;
		//if(isPhoneParameter=="true") {
			isPhone = true;
		//}
		System.out.println("测试isPhoneParameter:"+isPhoneParameter);
		//调用DAO进行判断
		MoocExtendDao extendDao = new MoocExtendDao();
		
		//先检测账号是否存在，再检测密码是否正确
		/*
		 * 其实可以直接检测账号和密码是否都有，没有就是密码错误，账号是否存在可以提前ajax检查边界问题
		 */
		ArrayList<MoocUserData> userList = extendDao.LoginCheck(accountParameter,passwdParameter,isPhone);
		
		//得出结果并返回，这里不使用重定向跳转直接输出结果，然后js那边获取来决定跳转还是显示错误信息
		/*
		 * 
		 */
		PrintWriter out = response.getWriter();
		MoocUserData userData = new MoocUserData();
		if(userList == null) {
			//System.out.println("DAO那边执行出错");
		}else if(userList.size()==0) {
			//未找到，说明密码错误，以json格式返回
			//System.out.println("查询结果为空，未找到数据");
			out.println("{\"success\":0}");
			
		}else {
			//找到了，读出数据{"success":1,"mUserName":"andy","mUserid":"aaad"}打印检查并以json格式返回
			for(int i = 0; i < userList.size(); i++) {
				userData =(MoocUserData)userList.get(i);
				//这里其实很容易错的，这样构造json，而且不好理解。
				out.println("{\"success\":1,\"mUserName\":\""+userData.getmUsername()+"\",\"mUserid\":\""+userData.getmUserid()+"\"}");
				//out.println("{\"success\":1,\"mUserName\":\"andy\",\"mUserid\":\"aaad\"}");
			}
			//添加到session
			session.setAttribute("userList",userList);
			
		}
	}
	
	//注册功能
	public void moocRegister(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//session声明
		HttpSession session = request.getSession();
		
		//获取传入的参数:注册的账号,注册的密码,是否为手机号
		String accountParameter = request.getParameter("registerPhone");
		String passwdParameter = request.getParameter("registerPasswd");
		String isPhoneParameter = request.getParameter("isPhone");
		boolean isPhone = false;
		//if(isPhoneParameter=="true") {
			isPhone = true;
		//}
		System.out.println("测试isPhoneParameter:"+isPhoneParameter);
		
		//生成用户id
		String userid = UUID.randomUUID().toString().substring(0,32);
		//生成用户名
		String userName = "MJ"+userid.substring(0,4);
		System.out.println("测试userid:userName:"+userid+":"+userName);
		
		//调用DAO进行判断
		MoocExtendDao extendDao = new MoocExtendDao();
		//直接进行注册，边界检测由前端完成
		int result = extendDao.insertMoocUserTable(userid, userName, accountParameter, passwdParameter);
		PrintWriter out = response.getWriter();
		if(result>0) {
			out.println("{\"success\":1}");
			//直接添加到session
			//。。没做
			
			
		}else {
			out.println("{\"success\":0}");
		}
	}
	
	//安全退出方法
	public void moocUserQuit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//清空session
		HttpSession session = request.getSession();
		session.invalidate();
		//返回json数据
		PrintWriter out = response.getWriter();
		out.println("{\"success\":1}");
	}
	
	//学习者发起 提问请求（付费问答）
	public void questionAsk(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取传来的参数
		System.out.println("学习者发起 提问请求（付费问答）");
		String askerid = request.getParameter("askerid");
		String askerName = request.getParameter("askerName");
		System.out.println("askerName:"+askerName);
		String teacherid = request.getParameter("teacherid");
		String teacherName = request.getParameter("teacherName");
		String courseName = request.getParameter("courseName");
		String courseid = request.getParameter("courseid");
		//生成订单id,,,我弄18把
		String orderid = UUID.randomUUID().toString().substring(0,18);
		//订单是否被教师接单了
		boolean orderEffective = false;
		//执行插入DAO
		int i = MoocExtendDao.insertPayQuestionOrderRecord(orderid, askerid,askerName, courseid, courseName,teacherid,teacherName,orderEffective);
		PrintWriter out = response.getWriter();
		if(i>0) {
			out.println("{\"success\":1,\"orderid\":\""+orderid+"\"}");
		}else {
			out.println("发起提问失败！");
		}
	}
	
	//开课者发起查询  [提问者请求列表]   请求（付费问答）
	/*
	 * 获取密钥参数，即开课者id，然后去查询订单表有开课者id的所有数据
	 * 然后用开课者id去查询课程id，然后显示出当前有的提问者请求队列
	 */
	public void queryAskerList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String teacherid = request.getParameter("teacherid");
		System.out.println("查询提问者请求列表:"+teacherid);
		MoocExtendDao extendDao = new MoocExtendDao();
		ArrayList<MoocPayQuestionOrderData> askerList = extendDao.queryAskerList(teacherid);
		PrintWriter out = response.getWriter();
		if(askerList == null) {
			//System.out.println("DAO那边执行出错");
		}else if(askerList.size()==0) {
			//数据库里没有课程
			//System.out.println("查询结果为空，未找到数据");
			out.println("暂时没人发起付费提问！");
			
		}else {
			//找到了，构造提问者div结构输出到html
			MoocPayQuestionOrderData MoocPayQuestionOrderData = new MoocPayQuestionOrderData();
			String outputPage = "";
			for(int i=0;i<askerList.size();i++) {
				MoocPayQuestionOrderData = (MoocPayQuestionOrderData)askerList.get(i);
				//每个提问者
				int num = i+1;
				outputPage = outputPage + "<div id=\"asker"+num+"\" style=\"border:1px solid grey;width:400px;overflow: hidden;\">"
						+"<span>订单id:<span id=\"askerListOrderid\">"+MoocPayQuestionOrderData.getPayQuestionOrderid()+"</span></span><br>"
						+"<span>提问者名称：<span id=\"questionAskerName"+num+"\">"+MoocPayQuestionOrderData.getAskerName()+"</span></span><br>"
						+"<span>提问者id：<span id=\"questionAskerid"+num+"\">"+MoocPayQuestionOrderData.getAskerid()+"</span></span><br>"
						+"<span>提问的课程：<span>"+MoocPayQuestionOrderData.getCourseName()+"</span></span><br>"
						+"<span>提问的课程id：<span id=\"questionCourseid"+num+"\">"+MoocPayQuestionOrderData.getCourseid()+"</span></span><br>"
						+"<span>提问时间</span><br>"
						+"<span>"+MoocPayQuestionOrderData.getAskTime()+"</span>"
						+"<button onclick=\"AjaxSend(15,'"+MoocPayQuestionOrderData.getPayQuestionOrderid()+"',"+num+");\" style=\"float:right;margin: 10px;padding: 10px;\">接单</button>"
						+"</div>";
			}
			out.println(outputPage);
			
		}
	}
	
	//提问者查询 [订单是否生效] 请求（付费问答）
	/*
	 * 传入订单值发起dao查询返回结果，js那边获取结果为true跳转到聊天界面
	 */
	public void queryOrderCondition(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String payquestionOrderid = request.getParameter("payquestionOrderid");
		System.out.println("进入了提问者查询 [订单是否生效] 请求的servlet");
		MoocExtendDao extendDao = new MoocExtendDao();
		PrintWriter out = response.getWriter();
		MoocPayQuestionOrderData MoocPayQuestionOrderData = new MoocPayQuestionOrderData();
		ArrayList<MoocPayQuestionOrderData> orderCondition = extendDao.queryOrderCondition(payquestionOrderid);
		if(orderCondition == null) {
			//System.out.println("DAO那边执行出错");
		}else if(orderCondition.size()==0) {
			//数据库里没有课程
			//System.out.println("查询结果为空，未找到数据");
			out.println("{\"success\":0}");
			
		}else {
			
			MoocPayQuestionOrderData = orderCondition.get(0);
			System.out.println("订单生效值："+MoocPayQuestionOrderData.isOrderEffective());
			if(MoocPayQuestionOrderData.isOrderEffective()==true) {
				out.println("{\"success\":1}");
			}else {
				out.println("{\"success\":3}");
			}
		}
		
		
	}
	
	//提问者 [发送消息] 请求（付费问答）
	/*
	 * 获取传来的参数：发送者(提问者）
	 * 
	 */
	public void payQuestionAskerSendMessage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("进入提问者发送消息Servlet");
		
		String senderid = request.getParameter("senderid");
		String senderName = request.getParameter("senderName");
		String receiverid = request.getParameter("receiverid");
		String receiverName = request.getParameter("receiverName");
		String message = request.getParameter("message");
		String courseid = request.getParameter("courseid");
		
		//获取订单id
		String payQuestionOrderid = request.getParameter("payQuestionOrderid");
		
		int i =  MoocExtendDao.insertSenderidMessage(senderid, senderName, receiverid, receiverName, message, courseid,payQuestionOrderid);
		PrintWriter out = response.getWriter();
		if(i>0) {
			out.println("{\"success\":1}");
			System.out.println("成功发送一条消息");
		}else {
			out.println("{\"success\":0}");
			System.out.println("发送一条消息失败");
		}
		
	}
	//开课者 [发送消息] 请求（付费问答）
	/*
	 * 获取传来的参数：发送者（开课者)id，发送者名称，接收者姓名，接收者id,课程id
	 * 开课者的名称再在dao里查询下，然后执行插入dao
	 * 
	 */
	public void payQuestionTeacherSendMessage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("进入（开课者）发送者发送消息Servlet");
		
		String senderid = request.getParameter("senderid");
		String receiverid = request.getParameter("receiverid");
		
		//查询发送者（开课者姓名）
		MoocExtendDao extendDao =  new MoocExtendDao();
		String senderName = extendDao.queryUserName(senderid);
		System.out.println("查询出来的开课者姓名："+senderName);
		
		String receiverName = request.getParameter("receiverName");
		String message = request.getParameter("message");
		String courseid = request.getParameter("courseid");
		
		//获取订单id
		String payQuestionOrderid = request.getParameter("payQuestionOrderid");
		
		
		
		int i =  MoocExtendDao.insertSenderidMessage(senderid, senderName, receiverid, receiverName, message,courseid,payQuestionOrderid);
		PrintWriter out = response.getWriter();
		if(i>0) {
			out.println("{\"success\":1}");
			System.out.println("成功发送一条消息");
		}else {
			out.println("{\"success\":0}");
			System.out.println("发送一条消息失败");
		}
		
	}	
	
	//开课者，提问者发起 [当前最新聊天记录] 查询（付费问答）
	/*
	 * 传入参数：提问者id,开课者id,课程id
	 * 查出：发送者姓名，消息
	 * 这里传入都是这三个参数，然后执行逻辑查询，具体看DAO那边解释
	 */
	public void queryUpToDataMessage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("开课者|提问者发起 [当前最新聊天记录] 查询（付费问答）");
		
		//新增订单id
		String payQuestionOrderid = request.getParameter("thisTimeOrderid");
		System.out.println("订单id是"+payQuestionOrderid);
		
		if(payQuestionOrderid!=null) {
			
			
			MoocExtendDao extendDao = new MoocExtendDao();
			ArrayList<MoocPayQuestionCommunicateData> messageList = extendDao.queryMesageList(payQuestionOrderid);
			PrintWriter out = response.getWriter();
			MoocPayQuestionCommunicateData MoocPayQuestionCommunicateData = new MoocPayQuestionCommunicateData();
			if(messageList == null) {
				//System.out.println("DAO那边执行出错");
			}else if(messageList.size()==0) {
				//数据库里没有课程
				//System.out.println("查询结果为空，未找到数据");
				out.println("还没聊天，赶紧开始吧");
				
			}else {
				//构造输出页面...很简单
				//发送者昵称：消息
				String outputPage = "";
				for(int i=0;i<messageList.size();i++) {
					MoocPayQuestionCommunicateData = messageList.get(i);
					int Number = i+1;
					outputPage = outputPage + "<div id=\"message"+Number+"\">"
							+"<p>"+MoocPayQuestionCommunicateData.getMessageSenderName()+"说：<span>"+MoocPayQuestionCommunicateData.getCommunicationMessage()
							+"</span></p></div>";
				}
				out.println(outputPage);
				
			}
		}else {
			System.out.println("未获取到订单id");
		}
		
		
		
		
		
	}
	
	//开课者发起 接受订单 请求(付费问答)
	/*
	 * 获取传来的参数找到那条订单，然后修改值为true，表示订单生效，然后返回success:1然后进入聊天界面
	 * 参数:订单id
	 */
	public void acceptOrder(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String payquestionOrderid = request.getParameter("payquestionOrderid");
		//执行修改DAO
		int i = MoocExtendDao.makePayQuestionOrderEffective(payquestionOrderid);
		PrintWriter out = response.getWriter();
		if(i>0) {
			out.println("{\"success\":1}");
		}else {
			out.println("接受订单失败！");
		}
		
	}
	
	//查询各种特定条件的课程列表（课程首页）
	/*
	 * 这里要查询前20条最新数据然后构造为html页面输出
	 * 有几条数据就输出几个div，反正页面写死的，不会出错
	 * 根据返回的条数来输出div
	 * 这里构造就是一个循环构造一个div出来就行
	 * 这里当课程数量少于5的时候则不弄两行div，大于5弄两行div，详细看模板页结构
	 * 这里到时再看看能否优化，做两层循环，第一行结束后，到二层循环里输出第二行，如果没有>5就不用执行二层循环
	 */
	public void queryCourseList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取传递来的参数选择
		String courseTypeChoise = request.getParameter("courseTypeChoise");
		int courseTypeChoiseInt = Integer.parseInt(courseTypeChoise);
		//调用查询dao
		MoocExtendDao extendDao = new MoocExtendDao();
		ArrayList<MoocCourseData> courseList = extendDao.queryCourseList(courseTypeChoiseInt,null);
		String courseType = "<h1>最新免费课程</h1>";
		switch(courseTypeChoiseInt) {
			case 1:courseType = "<div><h2 style=\"margin:0px;padding: 10px;margin-left: 100px;background-color:#F9F9F9 ;margin-right: 110px;font-weight: 400;\">最新免费课程</h2></div>";
				break;
			case 2:courseType ="<div><h2 style=\"margin:0px;padding: 10px;margin-left: 100px;background-color:#F9F9F9 ;margin-right: 110px;font-weight: 400;\">最新付费课程</h2></div>";
				break;
			case 3:courseType = "<div><h2 style=\"margin:0px;padding: 10px;margin-left: 100px;background-color:#F9F9F9 ;margin-right: 110px;font-weight: 400;\">免费热门课程</h2></div>";
				break;
			case 4:courseType = "<div><h2 style=\"margin:0px;padding: 10px;margin-left: 100px;background-color:#F9F9F9 ;margin-right: 110px;font-weight: 400;\">付费热门课程</h2></div>";
				break;
			//5,6,7,8被更多课程页占用了。
			case 9:courseType = "<div><h2 style=\"margin:0px;padding: 10px;margin-left: 100px;background-color:#F9F9F9 ;margin-right: 110px;font-weight: 400;\">评价最高免费课程</h2></div>";
				break;
			case 10:courseType = "<div><h2 style=\"margin:0px;padding: 10px;margin-left: 100px;background-color:#F9F9F9 ;margin-right: 110px;font-weight: 400;\">评价最高付费课程</h2></div>";
				break;
		
		}
		
		//判断返回结果决定如何操作
		PrintWriter out = response.getWriter();
		MoocCourseData courseData = new MoocCourseData();
		if(courseList == null) {
			//System.out.println("DAO那边执行出错");
		}else if(courseList.size()==0) {
			//数据库里没有课程
			//System.out.println("查询结果为空，未找到数据");
			out.println("{\"success\":0}");
			
		}else {
			//找到了，构造结构输出到html
			
			//标题行div
			String outputFreeCourseHtml = courseType;
			//第一行div
			outputFreeCourseHtml = outputFreeCourseHtml + "<div id=\"\" style=\"border:1px solid white;margin-left: 100px;margin-right:110px;border:1px solid white;background-color:white;overflow: hidden;\" >";
			for(int i = 0; i < courseList.size(); i++) {
				courseData =(MoocCourseData)courseList.get(i);
				if(courseList.size()==5) {
					//先给第一行结尾
					outputFreeCourseHtml = outputFreeCourseHtml +"</div>";
					//构造第二行的div容器
					outputFreeCourseHtml = outputFreeCourseHtml + "<div id=\"\" style=\"border:1px solid white;margin-left: 100px;margin-right:110px;border:1px solid white;background-color:white;overflow: hidden;\" >";
				}
				if(courseList.size()>=5) {
					//课程数>5,构造第二行里的每列
					outputFreeCourseHtml = outputFreeCourseHtml + "<div style=\"width:200px;float:left;margin-left: 20px;background-color: white;margin-top: 20px;\" onclick=\"window.location.replace(\'/OnlineMooc/courseContentPage.jsp?course="+courseData.getmCourseid()+"\');\" >";
					outputFreeCourseHtml = outputFreeCourseHtml + "<img src=\"img/courseImg.jpg\" style=\"max-width: 100%;\" />";
					outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"font-weight: 500;\">"+courseData.getmCourseName()+"</span><br>";
					outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"font-size: small;\">学习人数：2000人</span><br>";
					outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"font-size: small;\">课程质量：优</span><br>";
					if(courseData.getCoursePrice()==0) {
						outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"color:red;\">免费</span></div>";
					}else {
						outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"color:red;\">￥"+courseData.getCoursePrice()+"</span></div>";
					}
					
					
				}else {
					//正常构造第一行里的5列
					outputFreeCourseHtml = outputFreeCourseHtml + "<div style=\"width:200px;float:left;margin-left: 20px;background-color: white;margin-top: 20px;\" onclick=\"window.location.replace(\'/OnlineMooc/courseContentPage.jsp?course="+courseData.getmCourseid()+"\');\" >";
					outputFreeCourseHtml = outputFreeCourseHtml + "<img src=\"img/courseImg.jpg\" style=\"max-width: 100%;\" />";
					outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"font-weight: 500;\">"+courseData.getmCourseName()+"</span><br>";
					outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"font-size: small;\">学习人数：2000人</span><br>";
					outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"font-size: small;\">课程质量：优</span><br>";
					System.out.println("价格"+courseData.getCoursePrice());
					if(courseData.getCoursePrice()==0) {
						outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"color:red;\">免费</span></div>";
					}else {
						outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"color:red;\">￥"+courseData.getCoursePrice()+"</span></div>";
					}
				}
				
				
				
				
//				System.out.println(courseData.getmUserid());
//				System.out.println(courseData.getmCourseName());
//				System.out.println(courseData.getmCourseid());
				
				
				
				
			}
			//构造完4列，补充下结尾,这个的bug是如果只有1个课程那也达不到...
			if(courseList.size()<=4) {
				outputFreeCourseHtml = outputFreeCourseHtml +"</div>";
			}
			
			//如果有两行，则结束循环在这里给第二行容器补充完尾部div
			if(courseList.size()>=5) {
				outputFreeCourseHtml = outputFreeCourseHtml + "</div>";
			}
			out.println(outputFreeCourseHtml);
			
		}
		
	}
	
	//查询课程对应的所有评论（课程详细内容页）
	/*
	 * 这里获取的是Userid所以还需要再临时发起查询查询出UserName
	 */
	public void queryCourseComment(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取课程id
		String courseid = request.getParameter("courseid");
		MoocExtendDao extendDao = new MoocExtendDao();
		MoocCommentData commentData = new MoocCommentData();
		ArrayList<MoocCommentData> commentList = extendDao.queryCourseComment(courseid);
		PrintWriter out = response.getWriter();
		if(commentList.size()>0) {
			//开始构造页面
			String outputCommentContent = "";
			for(int i=0;i<commentList.size();i++) {
				commentData = commentList.get(i);
				
				outputCommentContent = "<div><p><span style=\"font-size: larger;color:cornflowerblue\">"+commentData.getmCommentUserName()+"</span><span>："+commentData.getmComment()+"</p>\r\n" + 
						"				<p>"+commentData.getmCommentPTime()+"</p>\r\n" + 
						"			</div>\r\n" + 
						"			<hr>";
				
			}
			
			out.println(outputCommentContent);
		}else {
			out.println("查询结果为空，没有查到数据");
		}	
		
		
	}
	
	//更多课程内容1类标签显示（更多课程页）
	/*
	 * 显示出类标签
	 * 直接发起dao查询然后构造输出页面然后输出
	 * 
	 */
	public void queryClassOneTag(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MoocExtendDao extendDao = new MoocExtendDao();
		MoocTagData tagData = new MoocTagData();
		ArrayList<MoocTagData> tagList = extendDao.queryClassOneTag();
		if(tagList.size()>0) {
			String outputTagOneHTML = "<ul style=\"list-style: none;\"><li style=\"float:left;margin-left: 120px;\">方向：</li>";
			for(int i=0;i<tagList.size();i++) {
				tagData = tagList.get(i);
				outputTagOneHTML = outputTagOneHTML +"<li><a style=\"float:left;margin-left: 50px;\" onclick=\"AjaxSend(8,'"+tagData.getClassOneTag()+"');AjaxSend(9,'"+tagData.getClassOneTag()+"','true');\" >"+tagData.getClassOneTag()+"<a></li>";
				System.out.println("<li><a style=\"float:left;margin-left: 50px;\" onclick=\"AjaxSend(8,'"+tagData.getClassOneTag()+"');AjaxSend(9,'"+tagData.getClassOneTag()+"','true');\" >"+tagData.getClassOneTag()+"<a></li>");
			}
			outputTagOneHTML = outputTagOneHTML +"</ul>";
			PrintWriter out = response.getWriter();
			out.println(outputTagOneHTML);
		}
	}
	
	//更多课程内容2类标签显示（更多课程页）
	/*
	 * 显示出类标签
	 * 直接发起dao查询然后构造输出页面然后输出
	 * 
	 */
	public void queryClassTwoTag(HttpServletRequest request, HttpServletResponse response)
			throws Exception {	
		//获取传递过来的1类标签参数
		//System.out.println("sb");
		String classOneTagGet = request.getParameter("classOneTag");
		System.out.println("获取到的classOneTag："+classOneTagGet);
		//查询dao返回结果处理输出页面
		MoocExtendDao extendDao = new MoocExtendDao();
		MoocTagData tagData = new MoocTagData();
		ArrayList<MoocTagData> tagList = extendDao.queryClassTwoTag(classOneTagGet);
		if(tagList.size()>0) {
			String outputTagOneHTML = "<div id=\"\" style=\"border:1px solid white;overflow: hidden;\"><ul style=\"list-style: none;\"><li style=\"float:left;margin-left: 150px;\">分类：</li>";
			for(int i=0;i<tagList.size();i++) {
				tagData = tagList.get(i);
				outputTagOneHTML = outputTagOneHTML +"<li><a style=\"float:left;margin-left: 50px;\" onclick=\"AjaxSend(9,'"+tagData.getClassTwoTag()+"','false');\" >"+tagData.getClassTwoTag()+"<a></li>";
				System.out.println("<li><a style=\"float:left;margin-left: 50px;\" onclick=\"AjaxSend(9,'"+tagData.getClassTwoTag()+"','false');\" >"+tagData.getClassTwoTag()+"<a></li>");
			}
			outputTagOneHTML = outputTagOneHTML +"</ul></div>";
			PrintWriter out = response.getWriter();
			out.println(outputTagOneHTML);
		}
	}
	
	//更多课程内容 特定 课程列表（更多课程页）
	/*
	 * 按照传递来的条件（付费，Java)来查询课程列表
	 */
	public void queryMoreCourseList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取传递过来的付费还是免费参数
		String payOrFree = request.getParameter("payOrFree");
		System.out.println(payOrFree);
		//获取传递过来的类标签参数
		String tagName = request.getParameter("tagName");
		System.out.println(tagName);
		//获取传递过来的类别判断参数
		String isTagOne = request.getParameter("isTagOne");
		System.out.println(isTagOne);
		
		//dao查询获取返回集，需要判断条件
		MoocExtendDao extendDao = new MoocExtendDao();
		ArrayList<MoocCourseData> courseList = null;
		//如果是付费的
		if(payOrFree.equals("pay")) {
			//如果是类别1
			if(isTagOne.equals("true")) {
				//付费，类别1
				courseList = extendDao.queryCourseList(5,tagName);
			}else {
				//付费，类别2
				courseList = extendDao.queryCourseList(7,tagName);
			}
		}else {
			
			//如果是类别1
			if(isTagOne.equals("true")) {
				//免费，类别1
				courseList = extendDao.queryCourseList(6,tagName);
			}else {
				//免费，类别2
				courseList = extendDao.queryCourseList(8,tagName);
			}
		}
		//开始构造输出页面
		PrintWriter out = response.getWriter();
		MoocCourseData courseData = new MoocCourseData();
		if(courseList == null) {
			//System.out.println("DAO那边执行出错");
		}else if(courseList.size()==0) {
			//数据库里没有课程
			System.out.println("查询结果为空，未找到数据");
			//out.println("查询结果为空，没有查到数据");
			
		}else {
			//找到了，构造结构输出到html
			String outputFreeCourseHtml = "";
			//这里直接输出所有，不需要1行5列
			//行div，其实可以不要
			outputFreeCourseHtml = outputFreeCourseHtml + "<div style=\"border:1px solid white;margin-top:20px;\">";
			for(int i = 0; i < courseList.size(); i++) {
				courseData =(MoocCourseData)courseList.get(i);
				//正常构造第一行里的5列
				outputFreeCourseHtml = outputFreeCourseHtml + "<div style=\"width:200px;float:left;margin-left: 20px;\" onclick=\"window.open(\'/OnlineMooc/courseContentPage.jsp?course="+courseData.getmCourseid()+"\');\" >";
				outputFreeCourseHtml = outputFreeCourseHtml + "<img src=\"img/courseImg.jpg\" style=\"max-width: 100%;\" />";
				outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"font-weight: 500;\">"+courseData.getmCourseName()+"</span><br>";
				outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"font-size: small;\">学习人数：2000人</span><br>";
				outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"font-size: small;\">课程质量：优</span><br>";
				//System.out.println("价格"+courseData.getCoursePrice());
				if(courseData.getCoursePrice()==0) {
					outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"color:red;\">免费</span></div>";
				}else {
					outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"color:red;\">￥"+courseData.getCoursePrice()+"</span></div>";
				}
				outputFreeCourseHtml = outputFreeCourseHtml + "</div>";
			}
			//给行结尾的/div
			outputFreeCourseHtml = outputFreeCourseHtml + "</div>";
			out.println(outputFreeCourseHtml);	
		}
	}
	
	//课程详细内容查询（课程详细内容页）
	/*
	 * 就是从数据库里读取出对应的信息然后构造为json格式传递回去
	 * 查课程表里的某个课程，章节表里的某些章节，小节表里的某些小节
	 * 三层结构查询，
	 * 
	 * 
	 *
	 *  
	 * 植入课程学习状况的判断：要传递参数：用户id，
	 * 判断用户是否登入了
	 * 没登入的，付费课程显示购买按钮，免费课程显示立即学习
	 * 已经登入，判断学习记录表里【这个用户】的课程id是否和这个页面的课程id匹配，匹配则说明已经点击过立即学习这里修改按钮为继续学习
	 * 否则判断付费课程还是免费课程，免费的直接显示立即学习
	 * 付费的
	 * 判断购买记录表里这个用户的课程id是否和这个页面的课程id匹配，匹配则说明已经购买了，但是还未学习，直接显示立即学习按钮，否则显示购买课程按钮		
	 */
	public void queryCourseDetail(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//发起dao查询获取返回结果
		MoocExtendDao extendDao = new MoocExtendDao();
		
		//返回结果存储字符串
		//String chapterid = null;
		
		//获取传来的课程id参数
		String courseid = request.getParameter("courseid");
		System.out.println("获取到的课程id:"+courseid);
		//获取课程表的，有的话继续获取章节表
		//判断返回结果决定如何操作
		ArrayList<MoocCourseData> courseList = extendDao.querySingleCourse(courseid);
		PrintWriter out = response.getWriter();
		MoocCourseData courseData = new MoocCourseData();
		if(courseList == null) {
			System.out.println("DAO那边执行出错");
		}else if(courseList.size()==0) {
			//数据库里没有查到对应课程的id
			System.out.println("查询结果为空，未找到数据");
			out.println("{\"success\":0}");
			
		}else {
			//查到了课程表获取出结果，并继续发起章节表查询.....这里直接调用之前创建arraylist就行了。
			MoocCourseData courseChapterData = new MoocCourseData();
			ArrayList<MoocCourseData> courseChapterList = extendDao.queryCourseChapter(courseid);
			if(courseChapterList == null) {
				//System.out.println("DAO那边执行出错");
			}else if(courseChapterList.size()==0) {
				//章节表里没有查到课程id对应的数据
				//System.out.println("查询结果为空，未找到数据");
				out.println("{\"success\":-1}");
				
			}else {
				//获取了课程的所有章节开始构造输出
				//二层循环，边输出章节边再查询章节对应的小节然后再输出
				//获取小节表里的数据...然后开始构造输出页面内容到详细课程内容页
				MoocCourseData courseSectionData = new MoocCourseData();
				ArrayList<MoocCourseData> courseSectionList = null;
				String outputDetailCourseHtml = "";
				
				//输出课程导航块
				courseData =(MoocCourseData)courseList.get(0);
				outputDetailCourseHtml = outputDetailCourseHtml + "<div id=\"courseDetailNavContainer\" style=\"border:1px solid black;background-color:black;overflow: hidden;\">";
				
				//<!-- 课程头部内容div -->
				outputDetailCourseHtml = outputDetailCourseHtml + "<div style=\"float:left;border: 1px solid black;width: 100%;height: 150px;margin: 20px;\">";
				
				//加入分类目录
				
				//课程名称和课程id(隐藏)
				outputDetailCourseHtml = outputDetailCourseHtml + "<h1 style=\"margin-top: 30px;margin-left: 30px;color:white;\">课程名称&nbsp;" +courseData.getmCourseName()+ "</h1><h1 id=\"toPayPageCourseid\" style=\"display:none;\" >"+courseData.getmCourseid()+"</h1>";
				
				//教师名称获取并构造进页面
				String teacherid = courseData.getmUserid();
				String teacherName = extendDao.queryUserName(teacherid);
				
				outputDetailCourseHtml = outputDetailCourseHtml + "<div id=\"\" style=\"margin: 20px;padding: 10px;\">";
				
				//分类标签
				outputDetailCourseHtml = outputDetailCourseHtml + "<span style=\"border:0px solid palegreen;color:darkgrey;\">		<span >后端开发&nbsp;|&nbsp;</span>		<span >Java&nbsp;&nbsp;</span></span>";
				//老师，学习人数
				outputDetailCourseHtml = outputDetailCourseHtml + "<span style=\"border:0px solid palegreen;color:darkgrey\">教师："+teacherName+"&nbsp;</span>";
				outputDetailCourseHtml = outputDetailCourseHtml +"<span style=\"border:0px solid palegreen;color:darkgrey\">学习人数："+courseData.getStudyNum()+"&nbsp;</span>";
				outputDetailCourseHtml = outputDetailCourseHtml +"<span style=\"border:0px solid palegreen;color:darkgrey\">课程评价：暂时无可靠评价</span>&nbsp;";
				//课程质量课程价格
				
				
				
				//课程价格和状况判断
				/*
				 * 这里如果课程为付费的话，显示价格：xxx元，否则显示价格免费
				 * 然后判断用户是否登入了，登入了继续下面的判断，未登入付费课程显示购买课程，免费课程显示开始学习
				 * 
				 */
				String isFreeOrPay = "免费";	
				if(courseData.getCoursePrice()!=0) {
					isFreeOrPay = Integer.toString(courseData.getCoursePrice());
				}
				
				//session声明
				HttpSession session = request.getSession();
				ArrayList userMessage = (ArrayList)session.getAttribute("userList");
				
				//按钮的显示选择
				if(userMessage!=null){
					//说明已经登入，开始登入的逻辑判断
					System.out.println("用户已经登入");
					MoocUserData userData = new MoocUserData();
					userData = (MoocUserData)userMessage.get(0);//不懂为什么还要强制转换为VO类
					String userid = userData.getmUserid();
					System.out.println("登入的用户名:"+userData.getmUsername());
					System.out.println("登入的用户id:"+userData.getmUserid());
					//判断是否已经学习该课程,学习了显示继续学习，没学往下判断
					
					MoocRecordData studyRecordData = new MoocRecordData();
					ArrayList<MoocRecordData> studyRecordList = extendDao.queryStudyRecord(userid, courseid);
					
					if(studyRecordList.size()>0) {
						
						//说明查询到数据，已经记录过这个用户学习过这个课程，所以按钮为继续学习							
						outputDetailCourseHtml = outputDetailCourseHtml + "<span style=\"border:0px solid palegreen;color:darkgrey\">价格："+isFreeOrPay+"</span>&nbsp;<button style=\"border:1px solid #1CB177;background-color:#1CB177;color:white;padding: 8px;\">用户已经登入，继续学习</button></div></div></div>";
					
					}else {
						//否则判断付费课程/免费课程
						if(courseData.getCoursePrice()==0) {
							
							//免费课程直接显示立即学习
							outputDetailCourseHtml = outputDetailCourseHtml + "<span style=\"border:0px solid palegreen;color:darkgrey\">价格：免费</span>&nbsp;<button onclick=\"AjaxSend(23);\" style=\"border:1px solid #1CB177;background-color:#1CB177;color:white;padding: 8px;\">用户已经登入，立即学习</button></div></div></div>";
						}else {
							//付费课程继续判断,,判断是否已经购买该课程，购买显示您已购买，立即开始学习！，未购买显示您还未购买，立即购买！
							MoocRecordData payRecordData = new MoocRecordData();
							ArrayList<MoocRecordData> payRecordList = extendDao.queryPayRecord(userid, courseid);
							
							if(payRecordList.size()>0) {
								//说明表里存在购买记录，这个用户已经购买过，所以按钮为立即学习
								outputDetailCourseHtml = outputDetailCourseHtml + "<span style=\"border:0px solid palegreen;color:darkgrey\">价格："+isFreeOrPay+"</span>&nbsp;<button onclick=\"AjaxSend(23);\" style=\"border:1px solid #1CB177;background-color:#1CB177;color:white;padding: 8px;\">您已购买，立即开始学习！</button></div></div></div>";
								
							}else {
								//不存在，还未购买
								outputDetailCourseHtml = outputDetailCourseHtml + "<span style=\"border:0px solid palegreen;color:darkgrey\">价格："+isFreeOrPay+"</span>&nbsp;<button onclick=\"toPayPage();\" style=\"border:1px solid #1CB177;background-color:#1CB177;color:white;padding: 8px;\">您还未购买，立即购买！</button></div></div></div>";
								
							}
						}
					}
					
				}else {
					System.out.println("用户未登入");
					//未登入，正常输出按照价格显示的按钮
					if(courseData.getCoursePrice()==0) {
						
						outputDetailCourseHtml = outputDetailCourseHtml + "<span style=\"border:0px solid palegreen;color:darkgrey\">价格：免费</span>&nbsp;<button onclick=\"AjaxSend(23);\" style=\"border:1px solid #1CB177;background-color:#1CB177;color:white;padding: 8px;\">未登入下的开始学习</button></div></div></div>";
					}else {
						outputDetailCourseHtml = outputDetailCourseHtml + "<span style=\"border:0px solid palegreen;color:darkgrey\">价格："+courseData.getCoursePrice()+"</span>&nbsp;<button onclick=\"toPayPage()\" style=\"border:1px solid #1CB177;background-color:#1CB177;color:white;padding: 8px;\">未登入下的购买课程</button></div></div></div>";
					}	
				}
		
				
				//输出课程内容容器
				outputDetailCourseHtml = outputDetailCourseHtml + "<div id=\"courseDetailContentContainer\"><div id=\"courseDetailLeftContainer \" style=\"border:1px solid black;float:left;width:70%;\"><div id=\"courseChapSectListContainer\">";
				//外层获取章节
				for(int i=0;i<courseChapterList.size();i++) {
					courseChapterData =(MoocCourseData)courseChapterList.get(i);
					outputDetailCourseHtml = outputDetailCourseHtml + "<h3 style=\"margin-top: 30px;margin-left: 30px;color:black;\">"+courseChapterData.getmChapterName()+"</h3><ul style=\"list-style: none;margin-left:40px;\">";
					//内层获取对应的小节
					courseSectionList = extendDao.queryCourseSection(courseChapterData.getmChapterid());
					for(int j=0;j<courseSectionList.size();j++) {
						//若为付费课程不添加a href标签
						courseSectionData =(MoocCourseData)courseSectionList.get(j);
						int numxxx = j+1;
						
						
						//对视频存放在数据库里的进行下判断是否为 空
						if(courseSectionData.getmVideoUrl().length()>5) {
							System.out.println("测试输出详细内容页Servlet下的视频路径："+courseSectionData.getmVideoUrl());
							outputDetailCourseHtml = outputDetailCourseHtml + "<li style=\"padding: 8px;color:black;\">小节"+numxxx+":<a href=\"coursePlayPage.jsp?mc="+courseSectionData.getmVideoUrl().substring(courseSectionData.getmVideoUrl().length()-30, courseSectionData.getmVideoUrl().length())+"&&course="+courseData.getmCourseid()+" \" style=\"text-decoration: none;color:black\">"+courseSectionData.getmSectionName()+"</a></li>";
						}else {
							System.out.println("测试输出详细内容页Servlet下的视频路径NULL时："+courseSectionData.getmVideoUrl());
							outputDetailCourseHtml = outputDetailCourseHtml + "<li style=\"padding: 8px;color:black;\">小节"+numxxx+":<a href=\"coursePlayPage.jsp?mc=video.ogg&&course="+courseData.getmCourseid()+" \" style=\"text-decoration: none;color:black\">"+courseSectionData.getmSectionName()+"</a></li>";						
						}
						
						
					}
					outputDetailCourseHtml = outputDetailCourseHtml +"</ul>";
				}
				outputDetailCourseHtml = outputDetailCourseHtml + "</div></div>";
				
				
				//课程右侧导航栏容器
				outputDetailCourseHtml = outputDetailCourseHtml + "<div id=\"courseDetailRightNavContainer\"  style=\"border:1px solid white;float:left;width:29%;\">";
				//<!-- 课程要求基础 --><!-- 课程将学到什么 -->
				outputDetailCourseHtml = outputDetailCourseHtml + "<div style=\"margin: 10px;;\"><p style=\"font-weight: bold;\">课程要求基础</p><p>内容</p></div><div style=\"margin: 10px;;\">";
				outputDetailCourseHtml = outputDetailCourseHtml + "<p style=\"font-weight: bold;\">课程将学到什么</p><p>内容</p></div></div>";

				//结尾给courseDetailContentContainer
				outputDetailCourseHtml = outputDetailCourseHtml + "</div>";
				
				
				//本身这些内容是要给课程详细内容页上的一个div的，然后这里再分为导航块和内容块
				
				
				
				
				//最后返回这个HTML
				out.println(outputDetailCourseHtml);
			
				
			}
			
		}
	}
	
	//发起开始学习请求（课程详细内容页）
	/*
	 * 获取来课程id，用户id，然后通过dao插入到数据库的两张表，课程表学习人数字段+1，学习记录表xxxx
	 */
	public void studyBeginRecord(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("发起开始学习请求（课程详细内容页）");
		String courseid = request.getParameter("courseid");
		String userid = request.getParameter("userid");
		System.out.println("传递来的发起学习的:"+courseid+":"+userid);
		//dao操作执行课程表学习人数字段+1
		int i  = MoocExtendDao.addMoocStudyNum(courseid);
		System.out.println("课程学习人数+1执行结果："+i);
		PrintWriter out = response.getWriter();
		if(i>0) {
			
			//dao操作学习记录表添加这次这次学习记录
			int j = MoocExtendDao.insertMoocStudyRecord(userid, courseid);
			System.out.println("插入课程学习记录执行结果："+j);
			
			if(j>0) {
				
				System.out.println("插入课程学习记录表执行结果成功"+"{\"success\":1}");
				out.println("{\"success\":1}");
				
			}else {
				
				System.out.println("插入课程学习记录表执行结果失败："+i);
			}
		}else {
			out.println("{\"success\":0}");
			System.out.println("课程学习人数+1执行结果失败："+i);
		}
		

		
		
		
	}
	
	//执行课程详情查询请求（课程播放页）
	/*
	 * 
	 */
	public void queryCourseDetailForPlayPage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//发起dao查询获取返回结果
		MoocExtendDao extendDao = new MoocExtendDao();
		
		//返回结果存储字符串
		//String chapterid = null;
		
		//获取传来的课程id参数
		String courseid = request.getParameter("courseid");
		System.out.println("获取到的课程id:"+courseid);
		//获取课程表的，有的话继续获取章节表
		//判断返回结果决定如何操作
		ArrayList<MoocCourseData> courseList = extendDao.querySingleCourse(courseid);
		PrintWriter out = response.getWriter();
		MoocCourseData courseData = new MoocCourseData();
		if(courseList == null) {
			System.out.println("DAO那边执行出错");
		}else if(courseList.size()==0) {
			//数据库里没有查到对应课程的id
			//System.out.println("查询结果为空，未找到数据");
			out.println("{\"success\":0}");
			
		}else {
			//查到了课程表获取出结果，并继续发起章节表查询.....这里直接调用之前创建arraylist就行了。
			MoocCourseData courseChapterData = new MoocCourseData();
			ArrayList<MoocCourseData> courseChapterList = extendDao.queryCourseChapter(courseid);
			if(courseChapterList == null) {
				//System.out.println("DAO那边执行出错");
			}else if(courseChapterList.size()==0) {
				//章节表里没有查到课程id对应的数据
				//System.out.println("查询结果为空，未找到数据");
				out.println("{\"success\":-1}");
				
			}else {
				//获取了课程的所有章节开始构造输出
				//二层循环，边输出章节边再查询章节对应的小节然后再输出
				//获取小节表里的数据...然后开始构造输出页面内容到详细课程内容页
				MoocCourseData courseSectionData = new MoocCourseData();
				ArrayList<MoocCourseData> courseSectionList = null;
				String outputDetailCourseHtml = "";
				
				//输出课程-课程基础信息
				courseData =(MoocCourseData)courseList.get(0);
				outputDetailCourseHtml = outputDetailCourseHtml + "<div id=\"courseBasicInformationForPlayContainer\" style=\"display: none;\">";
				outputDetailCourseHtml = outputDetailCourseHtml + "<span>课程id:</span><span id=\"playPageCourseid\">"+courseData.getmCourseid()+"</span><br>";
				outputDetailCourseHtml = outputDetailCourseHtml + "<span>课程名：</span><span id=\"playPageCourseName\">"+courseData.getmCourseName()+"</span><br>";
				//通过课程里的userid查询对应的用户表里的老师名
				
				String UserName = extendDao.queryUserName(courseData.getmUserid());
				outputDetailCourseHtml = outputDetailCourseHtml + "<span>老师：<span id=\"playPageTeacherName\">"+UserName+"</span></span><br>";
				outputDetailCourseHtml = outputDetailCourseHtml + "<span>老师id：</span><span></span><span id=\"playPageTeacherid\">"+courseData.getmUserid()+"</span><br></div>";
				//输出课程目录
				outputDetailCourseHtml = outputDetailCourseHtml + "<div id=\"courseListForPlayContainer\">";
				//外层获取章节
				for(int i=0;i<courseChapterList.size();i++) {
					courseChapterData =(MoocCourseData)courseChapterList.get(i);
					
					outputDetailCourseHtml = outputDetailCourseHtml + "<ul style=\"list-style: none;margin-top: 24px;\">";
					outputDetailCourseHtml = outputDetailCourseHtml + "<li style=\"color:white;margin-left: 12px;;\">"+courseChapterData.getmChapterName()+"</li><ul style=\"list-style: none;\">";
					//内层获取对应的小节
					courseSectionList = extendDao.queryCourseSection(courseChapterData.getmChapterid());
					for(int j=0;j<courseSectionList.size();j++) {
						//若为付费课程不添加a href标签????没判断吧
						courseSectionData =(MoocCourseData)courseSectionList.get(j);
						int numxxx = j+1;
						//outputDetailCourseHtml = outputDetailCourseHtml + "<li>小节"+numxxx+":<a href=\"coursePlayPage.jsp?mc="+courseSectionData.getmVideoUrl().substring(courseSectionData.getmVideoUrl().length()-30, courseSectionData.getmVideoUrl().length())+"&&course="+courseData.getmCourseid()+" \">"+courseSectionData.getmSectionName()+"</a></li>";
						//System.out.println(courseSectionData.getmVideoUrl().substring(courseSectionData.getmVideoUrl().length()-30, courseSectionData.getmVideoUrl().length()));
						
						//对视频存放在数据库里的进行下判断是否为 空
						if(courseSectionData.getmVideoUrl().length()>5) {
							System.out.println("测试输出详细内容页Servlet下的视频路径："+courseSectionData.getmVideoUrl());
							outputDetailCourseHtml = outputDetailCourseHtml + "<li style=\"color:gainsboro;margin-left:12px;padding:8px;\">"+numxxx+":<a href=\"coursePlayPage.jsp?mc="+courseSectionData.getmVideoUrl().substring(courseSectionData.getmVideoUrl().length()-30, courseSectionData.getmVideoUrl().length())+"&&course="+courseData.getmCourseid()+" \" style=\"color:gainsboro;text-decoration: none;;\">"+courseSectionData.getmSectionName()+"</a></li>";
						}else {
							System.out.println("测试输出详细内容页Servlet下的视频路径NULL时："+courseSectionData.getmVideoUrl());
							outputDetailCourseHtml = outputDetailCourseHtml + "<li style=\"color:gainsboro;margin-left:12px;padding:6px;\">"+numxxx+":<a href=\"coursePlayPage.jsp?mc=video.ogg&&course="+courseData.getmCourseid()+" \" style=\"color:gainsboro;text-decoration: none;;\">"+courseSectionData.getmSectionName()+"</a></li>";						
						}
						
					}
					
					outputDetailCourseHtml = outputDetailCourseHtml +"</ul>";//给一次完整的章节列表结尾ul
				}
				outputDetailCourseHtml = outputDetailCourseHtml + "</div>";
				//最后返回这个HTML
				out.println(outputDetailCourseHtml);
			
				
			}
			
		}	
	}
	
	
	
	//查询购买课程需要的课程信息（课程购买页）
	/*
	 * 发起dao查询获取返回结果输出页面就是了
	 */
	public void queryPayCourseMessage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取传来的课程id参数
		String courseid = request.getParameter("courseid");
		System.out.println("获取到的要购买的课程id:"+courseid);
		//执行DAO查询
		MoocExtendDao extendDao = new MoocExtendDao();
		ArrayList<MoocCourseData> courseList = extendDao.querySingleCourse(courseid);
		//有结果输出页面
		System.out.println("courseList的size:"+courseList.size());
		if(courseList.size()>0) {
			String outPutPayCourseHtml = "<h1>购买确定</h1><div id=\"payCourseMessageContainer\"><div id=\"payCourseMessageContainer\"><img src=\"img/courseImg.jpg\" style=\"max-width: 300px;border:1px solid orange;\"  />";
			PrintWriter out = response.getWriter();
			MoocCourseData courseData = new MoocCourseData();
			for(int i=0;i<courseList.size();i++) {
				courseData =courseList.get(i);
				//输出构造页面
				outPutPayCourseHtml = outPutPayCourseHtml + "<p>课程名称："+courseData.getmCourseName()
				+"</p><p>课程价格："+courseData.getCoursePrice()
				+"</p><p id=\"payCourseid\">"+courseData.getmCourseid()+"</p></div><div id=\"payCourseConfirmContainer\"><p><span>应付:</span><span id=\"payCoursePrice\">"+courseData.getCoursePrice()
				+"</span></p><button onclick=\"AjaxSend(6);\">确定购买</button></div>";
			}
		
			out.println(outPutPayCourseHtml);
		}
		
		
		
		
	}
	
	//执行课程购买操作（课程购买页）
	public void payCourse(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("执行课程购买操作（课程购买页）");
		
		//获取参数
		String userid = request.getParameter("userid");
		String courseid = request.getParameter("courseid");
		String coursePriceString = request.getParameter("courseprice");
		
		System.out.println("执行课程购买操作（课程购买页）"+userid+":"+courseid+":"+coursePriceString);
		int coursePrice = Integer.parseInt(coursePriceString);
		
		//执行dao 返回结果
		//MoocExtendDao extendDao = new MoocExtendDao();
		int result = MoocExtendDao.insertMoocPayRecord(userid,courseid,coursePrice);
		System.out.println("result:"+result);
		PrintWriter out = response.getWriter();
		if(result==1) {
			//输出返回结果
			out.println("{\"success\":1}");
		}else {
			out.println("{\"success\":0}");
			System.out.println("执行课程购买操作有误:"+result);
		}

	}
	
	
	
	
	//查询我开的课程（用户后台）
	/*
	 * 这里返回开课者的课程列表内容，直接输出构造好的课程列表表格
	 * 传入参数用户id，先查询是否有课程，无返回结果，有继续往下查询
	 */
	public void queryMyCourse(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String userid = request.getParameter("userid");
		//执行查询判断是否有课程
		
		if(userid==null) {
			
		}else {
			//没课程返回如下页面
			PrintWriter out = response.getWriter();
			out.println("<p>您还没有开课，赶紧开启老师之旅吧！<button onclick=\"showNewCourseDiv();\" style=\"border:1px solid #1CB177; background-color:#1CB177;color:white;width:60px;height:20px;\">点击开课</button></p>");
		}
		
	}
	
	//查询分类1级标签列表给上传课程的表单填写（用户后台）
	/*
	 * 执行dao构造页面输出返回
	 */
	public void queryTagOneListForUpCourse(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("查询分类1级标签列表给上传课程的表单填写Servlet");
		//执行DAO查询
		MoocExtendDao extendDao = new MoocExtendDao();
		ArrayList<MoocTagData> tagOneList = extendDao.queryClassOneTag();
		//有结果输出页面
		System.out.println("tagOneList的size:"+tagOneList.size());
		if(tagOneList.size()>0) {
			PrintWriter out = response.getWriter();
			String outPutPage = "<span>一级类选择</span><select id=\"classoneSelect\">";
			MoocTagData tagOneData = new MoocTagData();
			for(int i=0;i<tagOneList.size();i++) {
				tagOneData =tagOneList.get(i);
				//输出构造页面
				int num=i+1;
				outPutPage = outPutPage+"<option value=\"classone"+num+"\">"+tagOneData.getClassOneTag()+"</option>";
			}
			outPutPage = outPutPage +"<input type=\"button\" value=\"确定\" onclick=\"choiseTagOneSelect()\" style=\"border:1px solid #1CB177; background-color:#1CB177;color:white;width:60px;height:20px;\">"; 
			
			out.println(outPutPage);
		}
	}
	
	//查询分类2级标签列表给上传课程的表单填写（用户后台）
	/*
	 * 执行dao构造页面输出返回
	 */
	public void queryTagTwoListForUpCourse(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String tagOneName = request.getParameter("tagOneName");
		System.out.println("查询分类2级标签列表给上传课程的表单填写Servlet:"+tagOneName);
		//执行DAO查询
		MoocExtendDao extendDao = new MoocExtendDao();
		ArrayList<MoocTagData> tagTwoList = extendDao.queryClassTwoTag(tagOneName);
		//有结果输出页面
		System.out.println("tagTwoList的size:"+tagTwoList.size());
		if(tagTwoList.size()>0) {
			PrintWriter out = response.getWriter();
			String outPutPage = "<span>二级类选择</span><select id=\"classtwoSelect\">";
			MoocTagData tagTwoData = new MoocTagData();
			for(int i=0;i<tagTwoList.size();i++) {
				tagTwoData =tagTwoList.get(i);
				//输出构造页面
				int num=i+1;
				outPutPage = outPutPage+"<option value=\"classtwo"+num+"\">"+tagTwoData.getClassTwoTag()+"</option>";
			}
			outPutPage = outPutPage +"<input type=\"button\" value=\"确定\" onclick=\"choiseTagTwoSelect();\" style=\"border:1px solid #1CB177; background-color:#1CB177;color:white;width:60px;height:20px;\">"; 
			out.println(outPutPage);
			System.out.println(outPutPage);
		}
	}
	
	//上传的课程信息的数据库写入（用户后台）
	/*课程上传完跳转到这个Servlet进行	课程信息的数据库写入	并返回处理结果到后台页
	 * 就是在这里执行数据库写入课程的那些信息，
	 */
	public void CourseMessageHandle(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//测试
		PrintWriter out = response.getWriter();
		//out.println("课程上传完成！");
		
		//获取传递过来的课程名称，id，并执行课程写入的DAO操作
//		out.println("课程id:"+request.getAttribute("courseid"));
//		out.println("课程名称:"+request.getAttribute("courseName"));
		
		
		//获取传递过来的分类结果
//		out.println("课程1级类:"+request.getAttribute("classOneResult"));
//		out.println("课程2级类:"+request.getAttribute("classTwoResult"));
		
		
		//获取传递过来的课程价格，课程介绍，课程基础要求，课程专享服务
		System.out.println("课程价格:"+request.getAttribute("coursePrice"));
		System.out.println("课程介绍:"+request.getAttribute("courseIntroduce"));
		System.out.println("课程基础要求:"+request.getAttribute("courseRequire"));
		System.out.println("课程专享服务:"+request.getAttribute("exclusiveService"));
		
		//对课程价格进行类型转换
		int courseprice = Integer.parseInt((String)request.getAttribute("coursePrice"));
		out.println(courseprice);
		
		
		//创建扩展DAO的对象
		//MoocExtendDao courseInsertOperator = new MoocExtendDao();
		
		//执行插入课程DAO
		int insertCourseResult=MoocExtendDao.insertMoocFreeCourse((String)request.getAttribute("courseid"),(String)request.getAttribute("courseName"),(String)request.getAttribute("fixedPageUserid"),(String)request.getAttribute("classOneResult"),(String)request.getAttribute("classTwoResult"),courseprice,(String)request.getAttribute("courseRequire"),(String)request.getAttribute("courseIntroduce"),(String)request.getAttribute("exclusiveService"));
		System.out.println("课程插入执行结果："+insertCourseResult);
		
		//构造一个2层循环获取传递过来的章节小节，并执行DAO操作
		/*
		 * i为对章节的数标，j为对小节的数标
		 *先输出测试下
		 */
		String chapterid = "";	//这里chapterid还得全局变量下....小节的时候需要用到，每次章节一个循环替换一次
		
		for(int i=1;i<=8;i++) {
			if(request.getAttribute("chap"+i)!=null) {
				//out.println("章节"+i+":"+request.getAttribute("chap"+i));
				//生成章节id
				chapterid =  (String)request.getAttribute("courseid")+"chap"+i;
				//执行插入章节DAO
				int insertChapterResult=MoocExtendDao.insertMoocFreeChapter(chapterid, (String)request.getAttribute("chap"+i), (String)request.getAttribute("courseid"));
				System.out.println("执行插入章节"+i+"DAO返回结果："+insertChapterResult);
			}
			
			for(int j=1;j<=8;j++) {
				if(request.getAttribute("chap"+i+"sect"+j)!=null) {
					//out.println("小节"+j+":"+request.getAttribute("chap"+i+"sect"+j));
					//out.println("小节"+j+"视频路径:"+request.getAttribute("chap"+i+"chap"+i+"sect"+j));
					//小节名称
					String sectionName = (String)request.getAttribute("chap"+i+"sect"+j);
					//小节视频完整路径
					String VideoUrl = (String)request.getAttribute("chap"+i+"chap"+i+"sect"+j);
					//生成小节id
					String sectionid = (String)request.getAttribute("courseid")+"chap"+i+"sect"+j;
					//执行插入小节DAO
					int insertSectionResult=MoocExtendDao.insertMoocFreeSection(sectionid, chapterid,sectionName,VideoUrl);
					System.out.println("执行插入小节"+j+"DAO返回结果："+insertSectionResult);
				}
				
			}
		}//结束二层循环
		
		//返回结果给用户管理页
		//先输出上传课程成功等待n秒，重定向到用户管理页并携带某种参数使得后台管理页刷新后可以直接读取我开的课程列表并显示...
		//重定向到后台页
		ServletContext application = this.getServletContext();
		//路径怎么写？
		RequestDispatcher rd = application.getRequestDispatcher("/OnlineMooc/homePage.jsp");
		rd.forward(request,response);
		
		
	}
	
}
