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
//end,��Щ�Ҷ�û��д��ֻ�ǰ�����ļ̳�д��������Զ�������HttpServlet,��doGet��doPostд�¾��Զ�������������Щ
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
		//����
		MoocExtendDao extendDao = new MoocExtendDao();
		try {
			//Ϊʲô�������true�������Ҫ����try catch������򱨴�?
			ArrayList<MoocUserData> userList = extendDao.LoginCheck("22222222222", "ddddd",true);
			if(userList==null) {
				System.out.println("û�в�ѯ�����");
			}
			else {
				System.out.println("��ѯ�����Ϊ:"+userList.size()+":"+userList.get(0).getmUsername());
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
		response.setContentType("text/html;charset  = UTF-8");//���ﲻд����Σ�
		//��ȡ���ݹ����ķ���ѡ�����
		String functionChoise = request.getParameter("functionChoise");
		//ִ�е���У�鷽��
		if (functionChoise.equals("moocEnterCheck")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				
				moocEnterCheck(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//ִ���˳����뷽��
		if (functionChoise.equals("moocUserQuit")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				moocUserQuit(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		//ִ��ע������
		if (functionChoise.equals("moocRegister")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				moocRegister(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//ִ�в�ѯ�γ���ϸ���ݷ���(�γ���ϸ����ҳ)
		if (functionChoise.equals("queryCourseDetail")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				queryCourseDetail(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		//ִ�в�ѯ�γ̶�Ӧ���������ۣ��γ���ϸ����ҳ��
		if (functionChoise.equals("queryCourseComment")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				queryCourseComment(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		//����ʼѧϰ���󣨿γ���ϸ����ҳ��
		if (functionChoise.equals("studyBeginRecord")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				studyBeginRecord(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//��ѯ�γ����飨�γ̲���ҳ��
		if (functionChoise.equals("queryCourseDetailForPlayPage")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				queryCourseDetailForPlayPage(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		//��ѯ1����ǩ�б���γ��ϴ����û���̨��
		if (functionChoise.equals("queryTagOneListForUpCourse")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				queryTagOneListForUpCourse(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//��ѯ2����ǩ�б���γ��ϴ����û���̨��
		if (functionChoise.equals("queryTagTwoListForUpCourse")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				queryTagTwoListForUpCourse(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//��ѯ�ҿ��Ŀγ̣��û���̨��
		if (functionChoise.equals("queryMyCourse")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				
				queryMyCourse(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//�γ��ϴ�����ת�����Servlet�������ݿ�д�벢���ش���������̨ҳ���û���̨��
		if (functionChoise.equals("CourseMessageHandle")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				
				CourseMessageHandle(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//��ѯ��ѿγ��б�Ľ����ҳ��
		if (functionChoise.equals("queryCourseList")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				
				queryCourseList(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//��ѯ��ʾ����ǩ��ť������γ�ҳ��
		if (functionChoise.equals("queryClassOneTag")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				
				queryClassOneTag(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//��ѯ��ʾ����ǩ��ť������γ�ҳ��
				if (functionChoise.equals("queryClassTwoTag")) {
					//there (try..catch) i remember copy from teacher,didn't know why
					try {
						
						queryClassTwoTag(request, response);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
		//��ѯ�ض������Ŀγ��б�����γ�ҳ��
		if (functionChoise.equals("queryMoreCourseList")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				
				queryMoreCourseList(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//��ѯ����γ���Ҫ�Ŀγ���Ϣ���γ̹���ҳ��
		if (functionChoise.equals("queryPayCourseMessage")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				
				queryPayCourseMessage(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		//ִ�й���γ����󣨹���γ�ҳ��
		if (functionChoise.equals("payCourse")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				payCourse(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//ִ��ѧϰ�߷����������󣨸����ʴ�
		if (functionChoise.equals("questionAsk")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				questionAsk(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//ִ�������߷��������������б��ѯ�������ʴ�
		if (functionChoise.equals("queryAskerList")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				queryAskerList(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//ִ�������� ���ն��� ���󣨸����ʴ�
		if (functionChoise.equals("acceptOrder")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				acceptOrder(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//ִ�� ������|������ ������Ϣ��ʾ ���� �������ʴ�
		if (functionChoise.equals("queryUpToDataMessage")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				queryUpToDataMessage(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//�����߷�����Ϣ���󣨸����ʴ�
		if (functionChoise.equals("payQuestionTeacherSendMessage")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				payQuestionTeacherSendMessage(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//�����߷�����Ϣ���󣨸����ʴ�
		if (functionChoise.equals("payQuestionAskerSendMessage")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				payQuestionAskerSendMessage(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//������ ��ѯ�������Ƿ�ӵ��˵����󣨸����ʴ�
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
	
	
	
	//function need to write out there ��and don't know why should write (HttpServletRequest request, HttpServletResponse response)
	//����У�鷽��
	public void moocEnterCheck(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//session����
		HttpSession session = request.getSession();
		
		//��ȡ����Ĳ���:�˺�,����,�Ƿ�Ϊ�ֻ���
		String accountParameter = request.getParameter("phone");
		String passwdParameter = request.getParameter("passwd");
		String isPhoneParameter = request.getParameter("isPhone");
		boolean isPhone = false;
		//if(isPhoneParameter=="true") {
			isPhone = true;
		//}
		System.out.println("����isPhoneParameter:"+isPhoneParameter);
		//����DAO�����ж�
		MoocExtendDao extendDao = new MoocExtendDao();
		
		//�ȼ���˺��Ƿ���ڣ��ټ�������Ƿ���ȷ
		/*
		 * ��ʵ����ֱ�Ӽ���˺ź������Ƿ��У�û�о�����������˺��Ƿ���ڿ�����ǰajax���߽�����
		 */
		ArrayList<MoocUserData> userList = extendDao.LoginCheck(accountParameter,passwdParameter,isPhone);
		
		//�ó���������أ����ﲻʹ���ض�����תֱ����������Ȼ��js�Ǳ߻�ȡ��������ת������ʾ������Ϣ
		/*
		 * 
		 */
		PrintWriter out = response.getWriter();
		MoocUserData userData = new MoocUserData();
		if(userList == null) {
			//System.out.println("DAO�Ǳ�ִ�г���");
		}else if(userList.size()==0) {
			//δ�ҵ���˵�����������json��ʽ����
			//System.out.println("��ѯ���Ϊ�գ�δ�ҵ�����");
			out.println("{\"success\":0}");
			
		}else {
			//�ҵ��ˣ���������{"success":1,"mUserName":"andy","mUserid":"aaad"}��ӡ��鲢��json��ʽ����
			for(int i = 0; i < userList.size(); i++) {
				userData =(MoocUserData)userList.get(i);
				//������ʵ�����״�ģ���������json�����Ҳ�����⡣
				out.println("{\"success\":1,\"mUserName\":\""+userData.getmUsername()+"\",\"mUserid\":\""+userData.getmUserid()+"\"}");
				//out.println("{\"success\":1,\"mUserName\":\"andy\",\"mUserid\":\"aaad\"}");
			}
			//��ӵ�session
			session.setAttribute("userList",userList);
			
		}
	}
	
	//ע�Ṧ��
	public void moocRegister(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//session����
		HttpSession session = request.getSession();
		
		//��ȡ����Ĳ���:ע����˺�,ע�������,�Ƿ�Ϊ�ֻ���
		String accountParameter = request.getParameter("registerPhone");
		String passwdParameter = request.getParameter("registerPasswd");
		String isPhoneParameter = request.getParameter("isPhone");
		boolean isPhone = false;
		//if(isPhoneParameter=="true") {
			isPhone = true;
		//}
		System.out.println("����isPhoneParameter:"+isPhoneParameter);
		
		//�����û�id
		String userid = UUID.randomUUID().toString().substring(0,32);
		//�����û���
		String userName = "MJ"+userid.substring(0,4);
		System.out.println("����userid:userName:"+userid+":"+userName);
		
		//����DAO�����ж�
		MoocExtendDao extendDao = new MoocExtendDao();
		//ֱ�ӽ���ע�ᣬ�߽�����ǰ�����
		int result = extendDao.insertMoocUserTable(userid, userName, accountParameter, passwdParameter);
		PrintWriter out = response.getWriter();
		if(result>0) {
			out.println("{\"success\":1}");
			//ֱ����ӵ�session
			//����û��
			
			
		}else {
			out.println("{\"success\":0}");
		}
	}
	
	//��ȫ�˳�����
	public void moocUserQuit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//���session
		HttpSession session = request.getSession();
		session.invalidate();
		//����json����
		PrintWriter out = response.getWriter();
		out.println("{\"success\":1}");
	}
	
	//ѧϰ�߷��� �������󣨸����ʴ�
	public void questionAsk(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//��ȡ�����Ĳ���
		System.out.println("ѧϰ�߷��� �������󣨸����ʴ�");
		String askerid = request.getParameter("askerid");
		String askerName = request.getParameter("askerName");
		System.out.println("askerName:"+askerName);
		String teacherid = request.getParameter("teacherid");
		String teacherName = request.getParameter("teacherName");
		String courseName = request.getParameter("courseName");
		String courseid = request.getParameter("courseid");
		//���ɶ���id,,,��Ū18��
		String orderid = UUID.randomUUID().toString().substring(0,18);
		//�����Ƿ񱻽�ʦ�ӵ���
		boolean orderEffective = false;
		//ִ�в���DAO
		int i = MoocExtendDao.insertPayQuestionOrderRecord(orderid, askerid,askerName, courseid, courseName,teacherid,teacherName,orderEffective);
		PrintWriter out = response.getWriter();
		if(i>0) {
			out.println("{\"success\":1,\"orderid\":\""+orderid+"\"}");
		}else {
			out.println("��������ʧ�ܣ�");
		}
	}
	
	//�����߷����ѯ  [�����������б�]   ���󣨸����ʴ�
	/*
	 * ��ȡ��Կ��������������id��Ȼ��ȥ��ѯ�������п�����id����������
	 * Ȼ���ÿ�����idȥ��ѯ�γ�id��Ȼ����ʾ����ǰ�е��������������
	 */
	public void queryAskerList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String teacherid = request.getParameter("teacherid");
		System.out.println("��ѯ�����������б�:"+teacherid);
		MoocExtendDao extendDao = new MoocExtendDao();
		ArrayList<MoocPayQuestionOrderData> askerList = extendDao.queryAskerList(teacherid);
		PrintWriter out = response.getWriter();
		if(askerList == null) {
			//System.out.println("DAO�Ǳ�ִ�г���");
		}else if(askerList.size()==0) {
			//���ݿ���û�пγ�
			//System.out.println("��ѯ���Ϊ�գ�δ�ҵ�����");
			out.println("��ʱû�˷��𸶷����ʣ�");
			
		}else {
			//�ҵ��ˣ�����������div�ṹ�����html
			MoocPayQuestionOrderData MoocPayQuestionOrderData = new MoocPayQuestionOrderData();
			String outputPage = "";
			for(int i=0;i<askerList.size();i++) {
				MoocPayQuestionOrderData = (MoocPayQuestionOrderData)askerList.get(i);
				//ÿ��������
				int num = i+1;
				outputPage = outputPage + "<div id=\"asker"+num+"\" style=\"border:1px solid grey;width:400px;overflow: hidden;\">"
						+"<span>����id:<span id=\"askerListOrderid\">"+MoocPayQuestionOrderData.getPayQuestionOrderid()+"</span></span><br>"
						+"<span>���������ƣ�<span id=\"questionAskerName"+num+"\">"+MoocPayQuestionOrderData.getAskerName()+"</span></span><br>"
						+"<span>������id��<span id=\"questionAskerid"+num+"\">"+MoocPayQuestionOrderData.getAskerid()+"</span></span><br>"
						+"<span>���ʵĿγ̣�<span>"+MoocPayQuestionOrderData.getCourseName()+"</span></span><br>"
						+"<span>���ʵĿγ�id��<span id=\"questionCourseid"+num+"\">"+MoocPayQuestionOrderData.getCourseid()+"</span></span><br>"
						+"<span>����ʱ��</span><br>"
						+"<span>"+MoocPayQuestionOrderData.getAskTime()+"</span>"
						+"<button onclick=\"AjaxSend(15,'"+MoocPayQuestionOrderData.getPayQuestionOrderid()+"',"+num+");\" style=\"float:right;margin: 10px;padding: 10px;\">�ӵ�</button>"
						+"</div>";
			}
			out.println(outputPage);
			
		}
	}
	
	//�����߲�ѯ [�����Ƿ���Ч] ���󣨸����ʴ�
	/*
	 * ���붩��ֵ����dao��ѯ���ؽ����js�Ǳ߻�ȡ���Ϊtrue��ת���������
	 */
	public void queryOrderCondition(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String payquestionOrderid = request.getParameter("payquestionOrderid");
		System.out.println("�����������߲�ѯ [�����Ƿ���Ч] �����servlet");
		MoocExtendDao extendDao = new MoocExtendDao();
		PrintWriter out = response.getWriter();
		MoocPayQuestionOrderData MoocPayQuestionOrderData = new MoocPayQuestionOrderData();
		ArrayList<MoocPayQuestionOrderData> orderCondition = extendDao.queryOrderCondition(payquestionOrderid);
		if(orderCondition == null) {
			//System.out.println("DAO�Ǳ�ִ�г���");
		}else if(orderCondition.size()==0) {
			//���ݿ���û�пγ�
			//System.out.println("��ѯ���Ϊ�գ�δ�ҵ�����");
			out.println("{\"success\":0}");
			
		}else {
			
			MoocPayQuestionOrderData = orderCondition.get(0);
			System.out.println("������Чֵ��"+MoocPayQuestionOrderData.isOrderEffective());
			if(MoocPayQuestionOrderData.isOrderEffective()==true) {
				out.println("{\"success\":1}");
			}else {
				out.println("{\"success\":3}");
			}
		}
		
		
	}
	
	//������ [������Ϣ] ���󣨸����ʴ�
	/*
	 * ��ȡ�����Ĳ�����������(�����ߣ�
	 * 
	 */
	public void payQuestionAskerSendMessage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("���������߷�����ϢServlet");
		
		String senderid = request.getParameter("senderid");
		String senderName = request.getParameter("senderName");
		String receiverid = request.getParameter("receiverid");
		String receiverName = request.getParameter("receiverName");
		String message = request.getParameter("message");
		String courseid = request.getParameter("courseid");
		
		//��ȡ����id
		String payQuestionOrderid = request.getParameter("payQuestionOrderid");
		
		int i =  MoocExtendDao.insertSenderidMessage(senderid, senderName, receiverid, receiverName, message, courseid,payQuestionOrderid);
		PrintWriter out = response.getWriter();
		if(i>0) {
			out.println("{\"success\":1}");
			System.out.println("�ɹ�����һ����Ϣ");
		}else {
			out.println("{\"success\":0}");
			System.out.println("����һ����Ϣʧ��");
		}
		
	}
	//������ [������Ϣ] ���󣨸����ʴ�
	/*
	 * ��ȡ�����Ĳ����������ߣ�������)id�����������ƣ�������������������id,�γ�id
	 * �����ߵ���������dao���ѯ�£�Ȼ��ִ�в���dao
	 * 
	 */
	public void payQuestionTeacherSendMessage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("���루�����ߣ������߷�����ϢServlet");
		
		String senderid = request.getParameter("senderid");
		String receiverid = request.getParameter("receiverid");
		
		//��ѯ�����ߣ�������������
		MoocExtendDao extendDao =  new MoocExtendDao();
		String senderName = extendDao.queryUserName(senderid);
		System.out.println("��ѯ�����Ŀ�����������"+senderName);
		
		String receiverName = request.getParameter("receiverName");
		String message = request.getParameter("message");
		String courseid = request.getParameter("courseid");
		
		//��ȡ����id
		String payQuestionOrderid = request.getParameter("payQuestionOrderid");
		
		
		
		int i =  MoocExtendDao.insertSenderidMessage(senderid, senderName, receiverid, receiverName, message,courseid,payQuestionOrderid);
		PrintWriter out = response.getWriter();
		if(i>0) {
			out.println("{\"success\":1}");
			System.out.println("�ɹ�����һ����Ϣ");
		}else {
			out.println("{\"success\":0}");
			System.out.println("����һ����Ϣʧ��");
		}
		
	}	
	
	//�����ߣ������߷��� [��ǰ���������¼] ��ѯ�������ʴ�
	/*
	 * ���������������id,������id,�γ�id
	 * �������������������Ϣ
	 * ���ﴫ�붼��������������Ȼ��ִ���߼���ѯ�����忴DAO�Ǳ߽���
	 */
	public void queryUpToDataMessage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("������|�����߷��� [��ǰ���������¼] ��ѯ�������ʴ�");
		
		//��������id
		String payQuestionOrderid = request.getParameter("thisTimeOrderid");
		System.out.println("����id��"+payQuestionOrderid);
		
		if(payQuestionOrderid!=null) {
			
			
			MoocExtendDao extendDao = new MoocExtendDao();
			ArrayList<MoocPayQuestionCommunicateData> messageList = extendDao.queryMesageList(payQuestionOrderid);
			PrintWriter out = response.getWriter();
			MoocPayQuestionCommunicateData MoocPayQuestionCommunicateData = new MoocPayQuestionCommunicateData();
			if(messageList == null) {
				//System.out.println("DAO�Ǳ�ִ�г���");
			}else if(messageList.size()==0) {
				//���ݿ���û�пγ�
				//System.out.println("��ѯ���Ϊ�գ�δ�ҵ�����");
				out.println("��û���죬�Ͻ���ʼ��");
				
			}else {
				//�������ҳ��...�ܼ�
				//�������ǳƣ���Ϣ
				String outputPage = "";
				for(int i=0;i<messageList.size();i++) {
					MoocPayQuestionCommunicateData = messageList.get(i);
					int Number = i+1;
					outputPage = outputPage + "<div id=\"message"+Number+"\">"
							+"<p>"+MoocPayQuestionCommunicateData.getMessageSenderName()+"˵��<span>"+MoocPayQuestionCommunicateData.getCommunicationMessage()
							+"</span></p></div>";
				}
				out.println(outputPage);
				
			}
		}else {
			System.out.println("δ��ȡ������id");
		}
		
		
		
		
		
	}
	
	//�����߷��� ���ܶ��� ����(�����ʴ�)
	/*
	 * ��ȡ�����Ĳ����ҵ�����������Ȼ���޸�ֵΪtrue����ʾ������Ч��Ȼ�󷵻�success:1Ȼ������������
	 * ����:����id
	 */
	public void acceptOrder(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String payquestionOrderid = request.getParameter("payquestionOrderid");
		//ִ���޸�DAO
		int i = MoocExtendDao.makePayQuestionOrderEffective(payquestionOrderid);
		PrintWriter out = response.getWriter();
		if(i>0) {
			out.println("{\"success\":1}");
		}else {
			out.println("���ܶ���ʧ�ܣ�");
		}
		
	}
	
	//��ѯ�����ض������Ŀγ��б��γ���ҳ��
	/*
	 * ����Ҫ��ѯǰ20����������Ȼ����Ϊhtmlҳ�����
	 * �м������ݾ��������div������ҳ��д���ģ��������
	 * ���ݷ��ص����������div
	 * ���ﹹ�����һ��ѭ������һ��div��������
	 * ���ﵱ�γ���������5��ʱ����Ū����div������5Ū����div����ϸ��ģ��ҳ�ṹ
	 * ���ﵽʱ�ٿ����ܷ��Ż���������ѭ������һ�н����󣬵�����ѭ��������ڶ��У����û��>5�Ͳ���ִ�ж���ѭ��
	 */
	public void queryCourseList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//��ȡ�������Ĳ���ѡ��
		String courseTypeChoise = request.getParameter("courseTypeChoise");
		int courseTypeChoiseInt = Integer.parseInt(courseTypeChoise);
		//���ò�ѯdao
		MoocExtendDao extendDao = new MoocExtendDao();
		ArrayList<MoocCourseData> courseList = extendDao.queryCourseList(courseTypeChoiseInt,null);
		String courseType = "<h1>������ѿγ�</h1>";
		switch(courseTypeChoiseInt) {
			case 1:courseType = "<div><h2 style=\"margin:0px;padding: 10px;margin-left: 100px;background-color:#F9F9F9 ;margin-right: 110px;font-weight: 400;\">������ѿγ�</h2></div>";
				break;
			case 2:courseType ="<div><h2 style=\"margin:0px;padding: 10px;margin-left: 100px;background-color:#F9F9F9 ;margin-right: 110px;font-weight: 400;\">���¸��ѿγ�</h2></div>";
				break;
			case 3:courseType = "<div><h2 style=\"margin:0px;padding: 10px;margin-left: 100px;background-color:#F9F9F9 ;margin-right: 110px;font-weight: 400;\">������ſγ�</h2></div>";
				break;
			case 4:courseType = "<div><h2 style=\"margin:0px;padding: 10px;margin-left: 100px;background-color:#F9F9F9 ;margin-right: 110px;font-weight: 400;\">�������ſγ�</h2></div>";
				break;
			//5,6,7,8������γ�ҳռ���ˡ�
			case 9:courseType = "<div><h2 style=\"margin:0px;padding: 10px;margin-left: 100px;background-color:#F9F9F9 ;margin-right: 110px;font-weight: 400;\">���������ѿγ�</h2></div>";
				break;
			case 10:courseType = "<div><h2 style=\"margin:0px;padding: 10px;margin-left: 100px;background-color:#F9F9F9 ;margin-right: 110px;font-weight: 400;\">������߸��ѿγ�</h2></div>";
				break;
		
		}
		
		//�жϷ��ؽ��������β���
		PrintWriter out = response.getWriter();
		MoocCourseData courseData = new MoocCourseData();
		if(courseList == null) {
			//System.out.println("DAO�Ǳ�ִ�г���");
		}else if(courseList.size()==0) {
			//���ݿ���û�пγ�
			//System.out.println("��ѯ���Ϊ�գ�δ�ҵ�����");
			out.println("{\"success\":0}");
			
		}else {
			//�ҵ��ˣ�����ṹ�����html
			
			//������div
			String outputFreeCourseHtml = courseType;
			//��һ��div
			outputFreeCourseHtml = outputFreeCourseHtml + "<div id=\"\" style=\"border:1px solid white;margin-left: 100px;margin-right:110px;border:1px solid white;background-color:white;overflow: hidden;\" >";
			for(int i = 0; i < courseList.size(); i++) {
				courseData =(MoocCourseData)courseList.get(i);
				if(courseList.size()==5) {
					//�ȸ���һ�н�β
					outputFreeCourseHtml = outputFreeCourseHtml +"</div>";
					//����ڶ��е�div����
					outputFreeCourseHtml = outputFreeCourseHtml + "<div id=\"\" style=\"border:1px solid white;margin-left: 100px;margin-right:110px;border:1px solid white;background-color:white;overflow: hidden;\" >";
				}
				if(courseList.size()>=5) {
					//�γ���>5,����ڶ������ÿ��
					outputFreeCourseHtml = outputFreeCourseHtml + "<div style=\"width:200px;float:left;margin-left: 20px;background-color: white;margin-top: 20px;\" onclick=\"window.location.replace(\'/OnlineMooc/courseContentPage.jsp?course="+courseData.getmCourseid()+"\');\" >";
					outputFreeCourseHtml = outputFreeCourseHtml + "<img src=\"img/courseImg.jpg\" style=\"max-width: 100%;\" />";
					outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"font-weight: 500;\">"+courseData.getmCourseName()+"</span><br>";
					outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"font-size: small;\">ѧϰ������2000��</span><br>";
					outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"font-size: small;\">�γ���������</span><br>";
					if(courseData.getCoursePrice()==0) {
						outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"color:red;\">���</span></div>";
					}else {
						outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"color:red;\">��"+courseData.getCoursePrice()+"</span></div>";
					}
					
					
				}else {
					//���������һ�����5��
					outputFreeCourseHtml = outputFreeCourseHtml + "<div style=\"width:200px;float:left;margin-left: 20px;background-color: white;margin-top: 20px;\" onclick=\"window.location.replace(\'/OnlineMooc/courseContentPage.jsp?course="+courseData.getmCourseid()+"\');\" >";
					outputFreeCourseHtml = outputFreeCourseHtml + "<img src=\"img/courseImg.jpg\" style=\"max-width: 100%;\" />";
					outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"font-weight: 500;\">"+courseData.getmCourseName()+"</span><br>";
					outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"font-size: small;\">ѧϰ������2000��</span><br>";
					outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"font-size: small;\">�γ���������</span><br>";
					System.out.println("�۸�"+courseData.getCoursePrice());
					if(courseData.getCoursePrice()==0) {
						outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"color:red;\">���</span></div>";
					}else {
						outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"color:red;\">��"+courseData.getCoursePrice()+"</span></div>";
					}
				}
				
				
				
				
//				System.out.println(courseData.getmUserid());
//				System.out.println(courseData.getmCourseName());
//				System.out.println(courseData.getmCourseid());
				
				
				
				
			}
			//������4�У������½�β,�����bug�����ֻ��1���γ���Ҳ�ﲻ��...
			if(courseList.size()<=4) {
				outputFreeCourseHtml = outputFreeCourseHtml +"</div>";
			}
			
			//��������У������ѭ����������ڶ�������������β��div
			if(courseList.size()>=5) {
				outputFreeCourseHtml = outputFreeCourseHtml + "</div>";
			}
			out.println(outputFreeCourseHtml);
			
		}
		
	}
	
	//��ѯ�γ̶�Ӧ���������ۣ��γ���ϸ����ҳ��
	/*
	 * �����ȡ����Userid���Ի���Ҫ����ʱ�����ѯ��ѯ��UserName
	 */
	public void queryCourseComment(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//��ȡ�γ�id
		String courseid = request.getParameter("courseid");
		MoocExtendDao extendDao = new MoocExtendDao();
		MoocCommentData commentData = new MoocCommentData();
		ArrayList<MoocCommentData> commentList = extendDao.queryCourseComment(courseid);
		PrintWriter out = response.getWriter();
		if(commentList.size()>0) {
			//��ʼ����ҳ��
			String outputCommentContent = "";
			for(int i=0;i<commentList.size();i++) {
				commentData = commentList.get(i);
				
				outputCommentContent = "<div><p><span style=\"font-size: larger;color:cornflowerblue\">"+commentData.getmCommentUserName()+"</span><span>��"+commentData.getmComment()+"</p>\r\n" + 
						"				<p>"+commentData.getmCommentPTime()+"</p>\r\n" + 
						"			</div>\r\n" + 
						"			<hr>";
				
			}
			
			out.println(outputCommentContent);
		}else {
			out.println("��ѯ���Ϊ�գ�û�в鵽����");
		}	
		
		
	}
	
	//����γ�����1���ǩ��ʾ������γ�ҳ��
	/*
	 * ��ʾ�����ǩ
	 * ֱ�ӷ���dao��ѯȻ�������ҳ��Ȼ�����
	 * 
	 */
	public void queryClassOneTag(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MoocExtendDao extendDao = new MoocExtendDao();
		MoocTagData tagData = new MoocTagData();
		ArrayList<MoocTagData> tagList = extendDao.queryClassOneTag();
		if(tagList.size()>0) {
			String outputTagOneHTML = "<ul style=\"list-style: none;\"><li style=\"float:left;margin-left: 120px;\">����</li>";
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
	
	//����γ�����2���ǩ��ʾ������γ�ҳ��
	/*
	 * ��ʾ�����ǩ
	 * ֱ�ӷ���dao��ѯȻ�������ҳ��Ȼ�����
	 * 
	 */
	public void queryClassTwoTag(HttpServletRequest request, HttpServletResponse response)
			throws Exception {	
		//��ȡ���ݹ�����1���ǩ����
		//System.out.println("sb");
		String classOneTagGet = request.getParameter("classOneTag");
		System.out.println("��ȡ����classOneTag��"+classOneTagGet);
		//��ѯdao���ؽ���������ҳ��
		MoocExtendDao extendDao = new MoocExtendDao();
		MoocTagData tagData = new MoocTagData();
		ArrayList<MoocTagData> tagList = extendDao.queryClassTwoTag(classOneTagGet);
		if(tagList.size()>0) {
			String outputTagOneHTML = "<div id=\"\" style=\"border:1px solid white;overflow: hidden;\"><ul style=\"list-style: none;\"><li style=\"float:left;margin-left: 150px;\">���ࣺ</li>";
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
	
	//����γ����� �ض� �γ��б�����γ�ҳ��
	/*
	 * ���մ����������������ѣ�Java)����ѯ�γ��б�
	 */
	public void queryMoreCourseList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//��ȡ���ݹ����ĸ��ѻ�����Ѳ���
		String payOrFree = request.getParameter("payOrFree");
		System.out.println(payOrFree);
		//��ȡ���ݹ��������ǩ����
		String tagName = request.getParameter("tagName");
		System.out.println(tagName);
		//��ȡ���ݹ���������жϲ���
		String isTagOne = request.getParameter("isTagOne");
		System.out.println(isTagOne);
		
		//dao��ѯ��ȡ���ؼ�����Ҫ�ж�����
		MoocExtendDao extendDao = new MoocExtendDao();
		ArrayList<MoocCourseData> courseList = null;
		//����Ǹ��ѵ�
		if(payOrFree.equals("pay")) {
			//��������1
			if(isTagOne.equals("true")) {
				//���ѣ����1
				courseList = extendDao.queryCourseList(5,tagName);
			}else {
				//���ѣ����2
				courseList = extendDao.queryCourseList(7,tagName);
			}
		}else {
			
			//��������1
			if(isTagOne.equals("true")) {
				//��ѣ����1
				courseList = extendDao.queryCourseList(6,tagName);
			}else {
				//��ѣ����2
				courseList = extendDao.queryCourseList(8,tagName);
			}
		}
		//��ʼ�������ҳ��
		PrintWriter out = response.getWriter();
		MoocCourseData courseData = new MoocCourseData();
		if(courseList == null) {
			//System.out.println("DAO�Ǳ�ִ�г���");
		}else if(courseList.size()==0) {
			//���ݿ���û�пγ�
			System.out.println("��ѯ���Ϊ�գ�δ�ҵ�����");
			//out.println("��ѯ���Ϊ�գ�û�в鵽����");
			
		}else {
			//�ҵ��ˣ�����ṹ�����html
			String outputFreeCourseHtml = "";
			//����ֱ��������У�����Ҫ1��5��
			//��div����ʵ���Բ�Ҫ
			outputFreeCourseHtml = outputFreeCourseHtml + "<div style=\"border:1px solid white;margin-top:20px;\">";
			for(int i = 0; i < courseList.size(); i++) {
				courseData =(MoocCourseData)courseList.get(i);
				//���������һ�����5��
				outputFreeCourseHtml = outputFreeCourseHtml + "<div style=\"width:200px;float:left;margin-left: 20px;\" onclick=\"window.open(\'/OnlineMooc/courseContentPage.jsp?course="+courseData.getmCourseid()+"\');\" >";
				outputFreeCourseHtml = outputFreeCourseHtml + "<img src=\"img/courseImg.jpg\" style=\"max-width: 100%;\" />";
				outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"font-weight: 500;\">"+courseData.getmCourseName()+"</span><br>";
				outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"font-size: small;\">ѧϰ������2000��</span><br>";
				outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"font-size: small;\">�γ���������</span><br>";
				//System.out.println("�۸�"+courseData.getCoursePrice());
				if(courseData.getCoursePrice()==0) {
					outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"color:red;\">���</span></div>";
				}else {
					outputFreeCourseHtml = outputFreeCourseHtml + "<span style=\"color:red;\">��"+courseData.getCoursePrice()+"</span></div>";
				}
				outputFreeCourseHtml = outputFreeCourseHtml + "</div>";
			}
			//���н�β��/div
			outputFreeCourseHtml = outputFreeCourseHtml + "</div>";
			out.println(outputFreeCourseHtml);	
		}
	}
	
	//�γ���ϸ���ݲ�ѯ���γ���ϸ����ҳ��
	/*
	 * ���Ǵ����ݿ����ȡ����Ӧ����ϢȻ����Ϊjson��ʽ���ݻ�ȥ
	 * ��γ̱����ĳ���γ̣��½ڱ����ĳЩ�½ڣ�С�ڱ����ĳЩС��
	 * ����ṹ��ѯ��
	 * 
	 * 
	 *
	 *  
	 * ֲ��γ�ѧϰ״�����жϣ�Ҫ���ݲ������û�id��
	 * �ж��û��Ƿ������
	 * û����ģ����ѿγ���ʾ����ť����ѿγ���ʾ����ѧϰ
	 * �Ѿ����룬�ж�ѧϰ��¼�������û����Ŀγ�id�Ƿ�����ҳ��Ŀγ�idƥ�䣬ƥ����˵���Ѿ����������ѧϰ�����޸İ�ťΪ����ѧϰ
	 * �����жϸ��ѿγ̻�����ѿγ̣���ѵ�ֱ����ʾ����ѧϰ
	 * ���ѵ�
	 * �жϹ����¼��������û��Ŀγ�id�Ƿ�����ҳ��Ŀγ�idƥ�䣬ƥ����˵���Ѿ������ˣ����ǻ�δѧϰ��ֱ����ʾ����ѧϰ��ť��������ʾ����γ̰�ť		
	 */
	public void queryCourseDetail(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//����dao��ѯ��ȡ���ؽ��
		MoocExtendDao extendDao = new MoocExtendDao();
		
		//���ؽ���洢�ַ���
		//String chapterid = null;
		
		//��ȡ�����Ŀγ�id����
		String courseid = request.getParameter("courseid");
		System.out.println("��ȡ���Ŀγ�id:"+courseid);
		//��ȡ�γ̱�ģ��еĻ�������ȡ�½ڱ�
		//�жϷ��ؽ��������β���
		ArrayList<MoocCourseData> courseList = extendDao.querySingleCourse(courseid);
		PrintWriter out = response.getWriter();
		MoocCourseData courseData = new MoocCourseData();
		if(courseList == null) {
			System.out.println("DAO�Ǳ�ִ�г���");
		}else if(courseList.size()==0) {
			//���ݿ���û�в鵽��Ӧ�γ̵�id
			System.out.println("��ѯ���Ϊ�գ�δ�ҵ�����");
			out.println("{\"success\":0}");
			
		}else {
			//�鵽�˿γ̱��ȡ������������������½ڱ��ѯ.....����ֱ�ӵ���֮ǰ����arraylist�����ˡ�
			MoocCourseData courseChapterData = new MoocCourseData();
			ArrayList<MoocCourseData> courseChapterList = extendDao.queryCourseChapter(courseid);
			if(courseChapterList == null) {
				//System.out.println("DAO�Ǳ�ִ�г���");
			}else if(courseChapterList.size()==0) {
				//�½ڱ���û�в鵽�γ�id��Ӧ������
				//System.out.println("��ѯ���Ϊ�գ�δ�ҵ�����");
				out.println("{\"success\":-1}");
				
			}else {
				//��ȡ�˿γ̵������½ڿ�ʼ�������
				//����ѭ����������½ڱ��ٲ�ѯ�½ڶ�Ӧ��С��Ȼ�������
				//��ȡС�ڱ��������...Ȼ��ʼ�������ҳ�����ݵ���ϸ�γ�����ҳ
				MoocCourseData courseSectionData = new MoocCourseData();
				ArrayList<MoocCourseData> courseSectionList = null;
				String outputDetailCourseHtml = "";
				
				//����γ̵�����
				courseData =(MoocCourseData)courseList.get(0);
				outputDetailCourseHtml = outputDetailCourseHtml + "<div id=\"courseDetailNavContainer\" style=\"border:1px solid black;background-color:black;overflow: hidden;\">";
				
				//<!-- �γ�ͷ������div -->
				outputDetailCourseHtml = outputDetailCourseHtml + "<div style=\"float:left;border: 1px solid black;width: 100%;height: 150px;margin: 20px;\">";
				
				//�������Ŀ¼
				
				//�γ����ƺͿγ�id(����)
				outputDetailCourseHtml = outputDetailCourseHtml + "<h1 style=\"margin-top: 30px;margin-left: 30px;color:white;\">�γ�����&nbsp;" +courseData.getmCourseName()+ "</h1><h1 id=\"toPayPageCourseid\" style=\"display:none;\" >"+courseData.getmCourseid()+"</h1>";
				
				//��ʦ���ƻ�ȡ�������ҳ��
				String teacherid = courseData.getmUserid();
				String teacherName = extendDao.queryUserName(teacherid);
				
				outputDetailCourseHtml = outputDetailCourseHtml + "<div id=\"\" style=\"margin: 20px;padding: 10px;\">";
				
				//�����ǩ
				outputDetailCourseHtml = outputDetailCourseHtml + "<span style=\"border:0px solid palegreen;color:darkgrey;\">		<span >��˿���&nbsp;|&nbsp;</span>		<span >Java&nbsp;&nbsp;</span></span>";
				//��ʦ��ѧϰ����
				outputDetailCourseHtml = outputDetailCourseHtml + "<span style=\"border:0px solid palegreen;color:darkgrey\">��ʦ��"+teacherName+"&nbsp;</span>";
				outputDetailCourseHtml = outputDetailCourseHtml +"<span style=\"border:0px solid palegreen;color:darkgrey\">ѧϰ������"+courseData.getStudyNum()+"&nbsp;</span>";
				outputDetailCourseHtml = outputDetailCourseHtml +"<span style=\"border:0px solid palegreen;color:darkgrey\">�γ����ۣ���ʱ�޿ɿ�����</span>&nbsp;";
				//�γ������γ̼۸�
				
				
				
				//�γ̼۸��״���ж�
				/*
				 * ��������γ�Ϊ���ѵĻ�����ʾ�۸�xxxԪ��������ʾ�۸����
				 * Ȼ���ж��û��Ƿ�����ˣ������˼���������жϣ�δ���븶�ѿγ���ʾ����γ̣���ѿγ���ʾ��ʼѧϰ
				 * 
				 */
				String isFreeOrPay = "���";	
				if(courseData.getCoursePrice()!=0) {
					isFreeOrPay = Integer.toString(courseData.getCoursePrice());
				}
				
				//session����
				HttpSession session = request.getSession();
				ArrayList userMessage = (ArrayList)session.getAttribute("userList");
				
				//��ť����ʾѡ��
				if(userMessage!=null){
					//˵���Ѿ����룬��ʼ������߼��ж�
					System.out.println("�û��Ѿ�����");
					MoocUserData userData = new MoocUserData();
					userData = (MoocUserData)userMessage.get(0);//����Ϊʲô��Ҫǿ��ת��ΪVO��
					String userid = userData.getmUserid();
					System.out.println("������û���:"+userData.getmUsername());
					System.out.println("������û�id:"+userData.getmUserid());
					//�ж��Ƿ��Ѿ�ѧϰ�ÿγ�,ѧϰ����ʾ����ѧϰ��ûѧ�����ж�
					
					MoocRecordData studyRecordData = new MoocRecordData();
					ArrayList<MoocRecordData> studyRecordList = extendDao.queryStudyRecord(userid, courseid);
					
					if(studyRecordList.size()>0) {
						
						//˵����ѯ�����ݣ��Ѿ���¼������û�ѧϰ������γ̣����԰�ťΪ����ѧϰ							
						outputDetailCourseHtml = outputDetailCourseHtml + "<span style=\"border:0px solid palegreen;color:darkgrey\">�۸�"+isFreeOrPay+"</span>&nbsp;<button style=\"border:1px solid #1CB177;background-color:#1CB177;color:white;padding: 8px;\">�û��Ѿ����룬����ѧϰ</button></div></div></div>";
					
					}else {
						//�����жϸ��ѿγ�/��ѿγ�
						if(courseData.getCoursePrice()==0) {
							
							//��ѿγ�ֱ����ʾ����ѧϰ
							outputDetailCourseHtml = outputDetailCourseHtml + "<span style=\"border:0px solid palegreen;color:darkgrey\">�۸����</span>&nbsp;<button onclick=\"AjaxSend(23);\" style=\"border:1px solid #1CB177;background-color:#1CB177;color:white;padding: 8px;\">�û��Ѿ����룬����ѧϰ</button></div></div></div>";
						}else {
							//���ѿγ̼����ж�,,�ж��Ƿ��Ѿ�����ÿγ̣�������ʾ���ѹ���������ʼѧϰ����δ������ʾ����δ������������
							MoocRecordData payRecordData = new MoocRecordData();
							ArrayList<MoocRecordData> payRecordList = extendDao.queryPayRecord(userid, courseid);
							
							if(payRecordList.size()>0) {
								//˵��������ڹ����¼������û��Ѿ�����������԰�ťΪ����ѧϰ
								outputDetailCourseHtml = outputDetailCourseHtml + "<span style=\"border:0px solid palegreen;color:darkgrey\">�۸�"+isFreeOrPay+"</span>&nbsp;<button onclick=\"AjaxSend(23);\" style=\"border:1px solid #1CB177;background-color:#1CB177;color:white;padding: 8px;\">���ѹ���������ʼѧϰ��</button></div></div></div>";
								
							}else {
								//�����ڣ���δ����
								outputDetailCourseHtml = outputDetailCourseHtml + "<span style=\"border:0px solid palegreen;color:darkgrey\">�۸�"+isFreeOrPay+"</span>&nbsp;<button onclick=\"toPayPage();\" style=\"border:1px solid #1CB177;background-color:#1CB177;color:white;padding: 8px;\">����δ������������</button></div></div></div>";
								
							}
						}
					}
					
				}else {
					System.out.println("�û�δ����");
					//δ���룬����������ռ۸���ʾ�İ�ť
					if(courseData.getCoursePrice()==0) {
						
						outputDetailCourseHtml = outputDetailCourseHtml + "<span style=\"border:0px solid palegreen;color:darkgrey\">�۸����</span>&nbsp;<button onclick=\"AjaxSend(23);\" style=\"border:1px solid #1CB177;background-color:#1CB177;color:white;padding: 8px;\">δ�����µĿ�ʼѧϰ</button></div></div></div>";
					}else {
						outputDetailCourseHtml = outputDetailCourseHtml + "<span style=\"border:0px solid palegreen;color:darkgrey\">�۸�"+courseData.getCoursePrice()+"</span>&nbsp;<button onclick=\"toPayPage()\" style=\"border:1px solid #1CB177;background-color:#1CB177;color:white;padding: 8px;\">δ�����µĹ���γ�</button></div></div></div>";
					}	
				}
		
				
				//����γ���������
				outputDetailCourseHtml = outputDetailCourseHtml + "<div id=\"courseDetailContentContainer\"><div id=\"courseDetailLeftContainer \" style=\"border:1px solid black;float:left;width:70%;\"><div id=\"courseChapSectListContainer\">";
				//����ȡ�½�
				for(int i=0;i<courseChapterList.size();i++) {
					courseChapterData =(MoocCourseData)courseChapterList.get(i);
					outputDetailCourseHtml = outputDetailCourseHtml + "<h3 style=\"margin-top: 30px;margin-left: 30px;color:black;\">"+courseChapterData.getmChapterName()+"</h3><ul style=\"list-style: none;margin-left:40px;\">";
					//�ڲ��ȡ��Ӧ��С��
					courseSectionList = extendDao.queryCourseSection(courseChapterData.getmChapterid());
					for(int j=0;j<courseSectionList.size();j++) {
						//��Ϊ���ѿγ̲����a href��ǩ
						courseSectionData =(MoocCourseData)courseSectionList.get(j);
						int numxxx = j+1;
						
						
						//����Ƶ��������ݿ���Ľ������ж��Ƿ�Ϊ ��
						if(courseSectionData.getmVideoUrl().length()>5) {
							System.out.println("���������ϸ����ҳServlet�µ���Ƶ·����"+courseSectionData.getmVideoUrl());
							outputDetailCourseHtml = outputDetailCourseHtml + "<li style=\"padding: 8px;color:black;\">С��"+numxxx+":<a href=\"coursePlayPage.jsp?mc="+courseSectionData.getmVideoUrl().substring(courseSectionData.getmVideoUrl().length()-30, courseSectionData.getmVideoUrl().length())+"&&course="+courseData.getmCourseid()+" \" style=\"text-decoration: none;color:black\">"+courseSectionData.getmSectionName()+"</a></li>";
						}else {
							System.out.println("���������ϸ����ҳServlet�µ���Ƶ·��NULLʱ��"+courseSectionData.getmVideoUrl());
							outputDetailCourseHtml = outputDetailCourseHtml + "<li style=\"padding: 8px;color:black;\">С��"+numxxx+":<a href=\"coursePlayPage.jsp?mc=video.ogg&&course="+courseData.getmCourseid()+" \" style=\"text-decoration: none;color:black\">"+courseSectionData.getmSectionName()+"</a></li>";						
						}
						
						
					}
					outputDetailCourseHtml = outputDetailCourseHtml +"</ul>";
				}
				outputDetailCourseHtml = outputDetailCourseHtml + "</div></div>";
				
				
				//�γ��Ҳർ��������
				outputDetailCourseHtml = outputDetailCourseHtml + "<div id=\"courseDetailRightNavContainer\"  style=\"border:1px solid white;float:left;width:29%;\">";
				//<!-- �γ�Ҫ����� --><!-- �γ̽�ѧ��ʲô -->
				outputDetailCourseHtml = outputDetailCourseHtml + "<div style=\"margin: 10px;;\"><p style=\"font-weight: bold;\">�γ�Ҫ�����</p><p>����</p></div><div style=\"margin: 10px;;\">";
				outputDetailCourseHtml = outputDetailCourseHtml + "<p style=\"font-weight: bold;\">�γ̽�ѧ��ʲô</p><p>����</p></div></div>";

				//��β��courseDetailContentContainer
				outputDetailCourseHtml = outputDetailCourseHtml + "</div>";
				
				
				//������Щ������Ҫ���γ���ϸ����ҳ�ϵ�һ��div�ģ�Ȼ�������ٷ�Ϊ����������ݿ�
				
				
				
				
				//��󷵻����HTML
				out.println(outputDetailCourseHtml);
			
				
			}
			
		}
	}
	
	//����ʼѧϰ���󣨿γ���ϸ����ҳ��
	/*
	 * ��ȡ���γ�id���û�id��Ȼ��ͨ��dao���뵽���ݿ�����ű��γ̱�ѧϰ�����ֶ�+1��ѧϰ��¼��xxxx
	 */
	public void studyBeginRecord(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("����ʼѧϰ���󣨿γ���ϸ����ҳ��");
		String courseid = request.getParameter("courseid");
		String userid = request.getParameter("userid");
		System.out.println("�������ķ���ѧϰ��:"+courseid+":"+userid);
		//dao����ִ�пγ̱�ѧϰ�����ֶ�+1
		int i  = MoocExtendDao.addMoocStudyNum(courseid);
		System.out.println("�γ�ѧϰ����+1ִ�н����"+i);
		PrintWriter out = response.getWriter();
		if(i>0) {
			
			//dao����ѧϰ��¼�����������ѧϰ��¼
			int j = MoocExtendDao.insertMoocStudyRecord(userid, courseid);
			System.out.println("����γ�ѧϰ��¼ִ�н����"+j);
			
			if(j>0) {
				
				System.out.println("����γ�ѧϰ��¼��ִ�н���ɹ�"+"{\"success\":1}");
				out.println("{\"success\":1}");
				
			}else {
				
				System.out.println("����γ�ѧϰ��¼��ִ�н��ʧ�ܣ�"+i);
			}
		}else {
			out.println("{\"success\":0}");
			System.out.println("�γ�ѧϰ����+1ִ�н��ʧ�ܣ�"+i);
		}
		

		
		
		
	}
	
	//ִ�пγ������ѯ���󣨿γ̲���ҳ��
	/*
	 * 
	 */
	public void queryCourseDetailForPlayPage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//����dao��ѯ��ȡ���ؽ��
		MoocExtendDao extendDao = new MoocExtendDao();
		
		//���ؽ���洢�ַ���
		//String chapterid = null;
		
		//��ȡ�����Ŀγ�id����
		String courseid = request.getParameter("courseid");
		System.out.println("��ȡ���Ŀγ�id:"+courseid);
		//��ȡ�γ̱�ģ��еĻ�������ȡ�½ڱ�
		//�жϷ��ؽ��������β���
		ArrayList<MoocCourseData> courseList = extendDao.querySingleCourse(courseid);
		PrintWriter out = response.getWriter();
		MoocCourseData courseData = new MoocCourseData();
		if(courseList == null) {
			System.out.println("DAO�Ǳ�ִ�г���");
		}else if(courseList.size()==0) {
			//���ݿ���û�в鵽��Ӧ�γ̵�id
			//System.out.println("��ѯ���Ϊ�գ�δ�ҵ�����");
			out.println("{\"success\":0}");
			
		}else {
			//�鵽�˿γ̱��ȡ������������������½ڱ��ѯ.....����ֱ�ӵ���֮ǰ����arraylist�����ˡ�
			MoocCourseData courseChapterData = new MoocCourseData();
			ArrayList<MoocCourseData> courseChapterList = extendDao.queryCourseChapter(courseid);
			if(courseChapterList == null) {
				//System.out.println("DAO�Ǳ�ִ�г���");
			}else if(courseChapterList.size()==0) {
				//�½ڱ���û�в鵽�γ�id��Ӧ������
				//System.out.println("��ѯ���Ϊ�գ�δ�ҵ�����");
				out.println("{\"success\":-1}");
				
			}else {
				//��ȡ�˿γ̵������½ڿ�ʼ�������
				//����ѭ����������½ڱ��ٲ�ѯ�½ڶ�Ӧ��С��Ȼ�������
				//��ȡС�ڱ��������...Ȼ��ʼ�������ҳ�����ݵ���ϸ�γ�����ҳ
				MoocCourseData courseSectionData = new MoocCourseData();
				ArrayList<MoocCourseData> courseSectionList = null;
				String outputDetailCourseHtml = "";
				
				//����γ�-�γ̻�����Ϣ
				courseData =(MoocCourseData)courseList.get(0);
				outputDetailCourseHtml = outputDetailCourseHtml + "<div id=\"courseBasicInformationForPlayContainer\" style=\"display: none;\">";
				outputDetailCourseHtml = outputDetailCourseHtml + "<span>�γ�id:</span><span id=\"playPageCourseid\">"+courseData.getmCourseid()+"</span><br>";
				outputDetailCourseHtml = outputDetailCourseHtml + "<span>�γ�����</span><span id=\"playPageCourseName\">"+courseData.getmCourseName()+"</span><br>";
				//ͨ���γ����userid��ѯ��Ӧ���û��������ʦ��
				
				String UserName = extendDao.queryUserName(courseData.getmUserid());
				outputDetailCourseHtml = outputDetailCourseHtml + "<span>��ʦ��<span id=\"playPageTeacherName\">"+UserName+"</span></span><br>";
				outputDetailCourseHtml = outputDetailCourseHtml + "<span>��ʦid��</span><span></span><span id=\"playPageTeacherid\">"+courseData.getmUserid()+"</span><br></div>";
				//����γ�Ŀ¼
				outputDetailCourseHtml = outputDetailCourseHtml + "<div id=\"courseListForPlayContainer\">";
				//����ȡ�½�
				for(int i=0;i<courseChapterList.size();i++) {
					courseChapterData =(MoocCourseData)courseChapterList.get(i);
					
					outputDetailCourseHtml = outputDetailCourseHtml + "<ul style=\"list-style: none;margin-top: 24px;\">";
					outputDetailCourseHtml = outputDetailCourseHtml + "<li style=\"color:white;margin-left: 12px;;\">"+courseChapterData.getmChapterName()+"</li><ul style=\"list-style: none;\">";
					//�ڲ��ȡ��Ӧ��С��
					courseSectionList = extendDao.queryCourseSection(courseChapterData.getmChapterid());
					for(int j=0;j<courseSectionList.size();j++) {
						//��Ϊ���ѿγ̲����a href��ǩ????û�жϰ�
						courseSectionData =(MoocCourseData)courseSectionList.get(j);
						int numxxx = j+1;
						//outputDetailCourseHtml = outputDetailCourseHtml + "<li>С��"+numxxx+":<a href=\"coursePlayPage.jsp?mc="+courseSectionData.getmVideoUrl().substring(courseSectionData.getmVideoUrl().length()-30, courseSectionData.getmVideoUrl().length())+"&&course="+courseData.getmCourseid()+" \">"+courseSectionData.getmSectionName()+"</a></li>";
						//System.out.println(courseSectionData.getmVideoUrl().substring(courseSectionData.getmVideoUrl().length()-30, courseSectionData.getmVideoUrl().length()));
						
						//����Ƶ��������ݿ���Ľ������ж��Ƿ�Ϊ ��
						if(courseSectionData.getmVideoUrl().length()>5) {
							System.out.println("���������ϸ����ҳServlet�µ���Ƶ·����"+courseSectionData.getmVideoUrl());
							outputDetailCourseHtml = outputDetailCourseHtml + "<li style=\"color:gainsboro;margin-left:12px;padding:8px;\">"+numxxx+":<a href=\"coursePlayPage.jsp?mc="+courseSectionData.getmVideoUrl().substring(courseSectionData.getmVideoUrl().length()-30, courseSectionData.getmVideoUrl().length())+"&&course="+courseData.getmCourseid()+" \" style=\"color:gainsboro;text-decoration: none;;\">"+courseSectionData.getmSectionName()+"</a></li>";
						}else {
							System.out.println("���������ϸ����ҳServlet�µ���Ƶ·��NULLʱ��"+courseSectionData.getmVideoUrl());
							outputDetailCourseHtml = outputDetailCourseHtml + "<li style=\"color:gainsboro;margin-left:12px;padding:6px;\">"+numxxx+":<a href=\"coursePlayPage.jsp?mc=video.ogg&&course="+courseData.getmCourseid()+" \" style=\"color:gainsboro;text-decoration: none;;\">"+courseSectionData.getmSectionName()+"</a></li>";						
						}
						
					}
					
					outputDetailCourseHtml = outputDetailCourseHtml +"</ul>";//��һ���������½��б��βul
				}
				outputDetailCourseHtml = outputDetailCourseHtml + "</div>";
				//��󷵻����HTML
				out.println(outputDetailCourseHtml);
			
				
			}
			
		}	
	}
	
	
	
	//��ѯ����γ���Ҫ�Ŀγ���Ϣ���γ̹���ҳ��
	/*
	 * ����dao��ѯ��ȡ���ؽ�����ҳ�������
	 */
	public void queryPayCourseMessage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//��ȡ�����Ŀγ�id����
		String courseid = request.getParameter("courseid");
		System.out.println("��ȡ����Ҫ����Ŀγ�id:"+courseid);
		//ִ��DAO��ѯ
		MoocExtendDao extendDao = new MoocExtendDao();
		ArrayList<MoocCourseData> courseList = extendDao.querySingleCourse(courseid);
		//�н�����ҳ��
		System.out.println("courseList��size:"+courseList.size());
		if(courseList.size()>0) {
			String outPutPayCourseHtml = "<h1>����ȷ��</h1><div id=\"payCourseMessageContainer\"><div id=\"payCourseMessageContainer\"><img src=\"img/courseImg.jpg\" style=\"max-width: 300px;border:1px solid orange;\"  />";
			PrintWriter out = response.getWriter();
			MoocCourseData courseData = new MoocCourseData();
			for(int i=0;i<courseList.size();i++) {
				courseData =courseList.get(i);
				//�������ҳ��
				outPutPayCourseHtml = outPutPayCourseHtml + "<p>�γ����ƣ�"+courseData.getmCourseName()
				+"</p><p>�γ̼۸�"+courseData.getCoursePrice()
				+"</p><p id=\"payCourseid\">"+courseData.getmCourseid()+"</p></div><div id=\"payCourseConfirmContainer\"><p><span>Ӧ��:</span><span id=\"payCoursePrice\">"+courseData.getCoursePrice()
				+"</span></p><button onclick=\"AjaxSend(6);\">ȷ������</button></div>";
			}
		
			out.println(outPutPayCourseHtml);
		}
		
		
		
		
	}
	
	//ִ�пγ̹���������γ̹���ҳ��
	public void payCourse(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("ִ�пγ̹���������γ̹���ҳ��");
		
		//��ȡ����
		String userid = request.getParameter("userid");
		String courseid = request.getParameter("courseid");
		String coursePriceString = request.getParameter("courseprice");
		
		System.out.println("ִ�пγ̹���������γ̹���ҳ��"+userid+":"+courseid+":"+coursePriceString);
		int coursePrice = Integer.parseInt(coursePriceString);
		
		//ִ��dao ���ؽ��
		//MoocExtendDao extendDao = new MoocExtendDao();
		int result = MoocExtendDao.insertMoocPayRecord(userid,courseid,coursePrice);
		System.out.println("result:"+result);
		PrintWriter out = response.getWriter();
		if(result==1) {
			//������ؽ��
			out.println("{\"success\":1}");
		}else {
			out.println("{\"success\":0}");
			System.out.println("ִ�пγ̹����������:"+result);
		}

	}
	
	
	
	
	//��ѯ�ҿ��Ŀγ̣��û���̨��
	/*
	 * ���ﷵ�ؿ����ߵĿγ��б����ݣ�ֱ���������õĿγ��б���
	 * ��������û�id���Ȳ�ѯ�Ƿ��пγ̣��޷��ؽ�����м������²�ѯ
	 */
	public void queryMyCourse(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String userid = request.getParameter("userid");
		//ִ�в�ѯ�ж��Ƿ��пγ�
		
		if(userid==null) {
			
		}else {
			//û�γ̷�������ҳ��
			PrintWriter out = response.getWriter();
			out.println("<p>����û�п��Σ��Ͻ�������ʦ֮�ðɣ�<button onclick=\"showNewCourseDiv();\" style=\"border:1px solid #1CB177; background-color:#1CB177;color:white;width:60px;height:20px;\">�������</button></p>");
		}
		
	}
	
	//��ѯ����1����ǩ�б���ϴ��γ̵ı���д���û���̨��
	/*
	 * ִ��dao����ҳ���������
	 */
	public void queryTagOneListForUpCourse(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("��ѯ����1����ǩ�б���ϴ��γ̵ı���дServlet");
		//ִ��DAO��ѯ
		MoocExtendDao extendDao = new MoocExtendDao();
		ArrayList<MoocTagData> tagOneList = extendDao.queryClassOneTag();
		//�н�����ҳ��
		System.out.println("tagOneList��size:"+tagOneList.size());
		if(tagOneList.size()>0) {
			PrintWriter out = response.getWriter();
			String outPutPage = "<span>һ����ѡ��</span><select id=\"classoneSelect\">";
			MoocTagData tagOneData = new MoocTagData();
			for(int i=0;i<tagOneList.size();i++) {
				tagOneData =tagOneList.get(i);
				//�������ҳ��
				int num=i+1;
				outPutPage = outPutPage+"<option value=\"classone"+num+"\">"+tagOneData.getClassOneTag()+"</option>";
			}
			outPutPage = outPutPage +"<input type=\"button\" value=\"ȷ��\" onclick=\"choiseTagOneSelect()\" style=\"border:1px solid #1CB177; background-color:#1CB177;color:white;width:60px;height:20px;\">"; 
			
			out.println(outPutPage);
		}
	}
	
	//��ѯ����2����ǩ�б���ϴ��γ̵ı���д���û���̨��
	/*
	 * ִ��dao����ҳ���������
	 */
	public void queryTagTwoListForUpCourse(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String tagOneName = request.getParameter("tagOneName");
		System.out.println("��ѯ����2����ǩ�б���ϴ��γ̵ı���дServlet:"+tagOneName);
		//ִ��DAO��ѯ
		MoocExtendDao extendDao = new MoocExtendDao();
		ArrayList<MoocTagData> tagTwoList = extendDao.queryClassTwoTag(tagOneName);
		//�н�����ҳ��
		System.out.println("tagTwoList��size:"+tagTwoList.size());
		if(tagTwoList.size()>0) {
			PrintWriter out = response.getWriter();
			String outPutPage = "<span>������ѡ��</span><select id=\"classtwoSelect\">";
			MoocTagData tagTwoData = new MoocTagData();
			for(int i=0;i<tagTwoList.size();i++) {
				tagTwoData =tagTwoList.get(i);
				//�������ҳ��
				int num=i+1;
				outPutPage = outPutPage+"<option value=\"classtwo"+num+"\">"+tagTwoData.getClassTwoTag()+"</option>";
			}
			outPutPage = outPutPage +"<input type=\"button\" value=\"ȷ��\" onclick=\"choiseTagTwoSelect();\" style=\"border:1px solid #1CB177; background-color:#1CB177;color:white;width:60px;height:20px;\">"; 
			out.println(outPutPage);
			System.out.println(outPutPage);
		}
	}
	
	//�ϴ��Ŀγ���Ϣ�����ݿ�д�루�û���̨��
	/*�γ��ϴ�����ת�����Servlet����	�γ���Ϣ�����ݿ�д��	�����ش���������̨ҳ
	 * ����������ִ�����ݿ�д��γ̵���Щ��Ϣ��
	 */
	public void CourseMessageHandle(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//����
		PrintWriter out = response.getWriter();
		//out.println("�γ��ϴ���ɣ�");
		
		//��ȡ���ݹ����Ŀγ����ƣ�id����ִ�пγ�д���DAO����
//		out.println("�γ�id:"+request.getAttribute("courseid"));
//		out.println("�γ�����:"+request.getAttribute("courseName"));
		
		
		//��ȡ���ݹ����ķ�����
//		out.println("�γ�1����:"+request.getAttribute("classOneResult"));
//		out.println("�γ�2����:"+request.getAttribute("classTwoResult"));
		
		
		//��ȡ���ݹ����Ŀγ̼۸񣬿γ̽��ܣ��γ̻���Ҫ�󣬿γ�ר�����
		System.out.println("�γ̼۸�:"+request.getAttribute("coursePrice"));
		System.out.println("�γ̽���:"+request.getAttribute("courseIntroduce"));
		System.out.println("�γ̻���Ҫ��:"+request.getAttribute("courseRequire"));
		System.out.println("�γ�ר�����:"+request.getAttribute("exclusiveService"));
		
		//�Կγ̼۸��������ת��
		int courseprice = Integer.parseInt((String)request.getAttribute("coursePrice"));
		out.println(courseprice);
		
		
		//������չDAO�Ķ���
		//MoocExtendDao courseInsertOperator = new MoocExtendDao();
		
		//ִ�в���γ�DAO
		int insertCourseResult=MoocExtendDao.insertMoocFreeCourse((String)request.getAttribute("courseid"),(String)request.getAttribute("courseName"),(String)request.getAttribute("fixedPageUserid"),(String)request.getAttribute("classOneResult"),(String)request.getAttribute("classTwoResult"),courseprice,(String)request.getAttribute("courseRequire"),(String)request.getAttribute("courseIntroduce"),(String)request.getAttribute("exclusiveService"));
		System.out.println("�γ̲���ִ�н����"+insertCourseResult);
		
		//����һ��2��ѭ����ȡ���ݹ������½�С�ڣ���ִ��DAO����
		/*
		 * iΪ���½ڵ����꣬jΪ��С�ڵ�����
		 *�����������
		 */
		String chapterid = "";	//����chapterid����ȫ�ֱ�����....С�ڵ�ʱ����Ҫ�õ���ÿ���½�һ��ѭ���滻һ��
		
		for(int i=1;i<=8;i++) {
			if(request.getAttribute("chap"+i)!=null) {
				//out.println("�½�"+i+":"+request.getAttribute("chap"+i));
				//�����½�id
				chapterid =  (String)request.getAttribute("courseid")+"chap"+i;
				//ִ�в����½�DAO
				int insertChapterResult=MoocExtendDao.insertMoocFreeChapter(chapterid, (String)request.getAttribute("chap"+i), (String)request.getAttribute("courseid"));
				System.out.println("ִ�в����½�"+i+"DAO���ؽ����"+insertChapterResult);
			}
			
			for(int j=1;j<=8;j++) {
				if(request.getAttribute("chap"+i+"sect"+j)!=null) {
					//out.println("С��"+j+":"+request.getAttribute("chap"+i+"sect"+j));
					//out.println("С��"+j+"��Ƶ·��:"+request.getAttribute("chap"+i+"chap"+i+"sect"+j));
					//С������
					String sectionName = (String)request.getAttribute("chap"+i+"sect"+j);
					//С����Ƶ����·��
					String VideoUrl = (String)request.getAttribute("chap"+i+"chap"+i+"sect"+j);
					//����С��id
					String sectionid = (String)request.getAttribute("courseid")+"chap"+i+"sect"+j;
					//ִ�в���С��DAO
					int insertSectionResult=MoocExtendDao.insertMoocFreeSection(sectionid, chapterid,sectionName,VideoUrl);
					System.out.println("ִ�в���С��"+j+"DAO���ؽ����"+insertSectionResult);
				}
				
			}
		}//��������ѭ��
		
		//���ؽ�����û�����ҳ
		//������ϴ��γ̳ɹ��ȴ�n�룬�ض����û�����ҳ��Я��ĳ�ֲ���ʹ�ú�̨����ҳˢ�º����ֱ�Ӷ�ȡ�ҿ��Ŀγ��б���ʾ...
		//�ض��򵽺�̨ҳ
		ServletContext application = this.getServletContext();
		//·����ôд��
		RequestDispatcher rd = application.getRequestDispatcher("/OnlineMooc/homePage.jsp");
		rd.forward(request,response);
		
		
	}
	
}
