package MoocServlet;
//begin
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//end,��Щ�Ҷ�û��д��ֻ�ǰ�����ļ̳�д��������Զ�������HttpServlet,��doGet��doPostд�¾��Զ�������������Щ
import javax.servlet.http.HttpSession;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import MoocDAO.MoocExtendDao;
import MoocData.MoocCommentData;
import MoocData.MoocCourseData;
import MoocData.MoocPayQuestionCommunicateData;
import MoocData.MoocPayQuestionOrderData;
import MoocData.MoocRecordData;
import MoocData.MoocTagData;
import MoocData.MoocUserData;


@WebServlet("/MoocManageServlet")
public class MoocManageServlet extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		//����
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html;charset  = UTF-8");
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset  = UTF-8");//���ﲻд����Σ�
		//��ȡ���ݹ����ķ���ѡ�����
		String functionChoise = request.getParameter("functionChoise");
		//��ѯ�û����ݣ���̨����
		if (functionChoise.equals("queryUserInformationManage")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				
				queryUserInformationManage(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//��ѯ�γ����ݣ���̨����
		if (functionChoise.equals("queryCourseInformationManage")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				
				queryCourseInformationManage(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//�����������Կγ����ݣ�ϵͳ���ԣ�
		if (functionChoise.equals("testCreateCourseData")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				
				testCreateCourseData(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
	}//doPost
	
	//�����������Կγ����ݣ�ϵͳ���ԣ�
	/*
	 * JS�����������������Σ�
	 * ������ɿγ�id,�½�id��С��id���������ǹ��������
	 */
	public void testCreateCourseData(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("�������Կγ����ݣ�ϵͳ���ԣ�");
		PrintWriter out = response.getWriter();
		
		//��ȡ������N����������
		String batchN = request.getParameter("courseChoise");
		int batchNum = Integer.parseInt(batchN);
		System.out.println("�������Կγ����ݣ�ϵͳ���ԣ�����������"+batchNum);
		
		String classOne = "��˿���";
		String classTwo = "java";
		
		int coursePrice = 0;
			
		String exclusiveService = "�ṩʮ����ѵĸ����ʴ����";
		
		String courseIntroduce = "����һ���ǳ��õĿγ�";
		
		String courseBasicRequire = "��Ҫ���Java�Ļ���";
		
		String teacherid = "26791e89-82a1-45c0-800f-f709f20f";
		
		//���������ٿγ�����ʵ��Ƶ���ŵĿγ�
		for(int i=0;i<batchNum;i++) {
			
			String courseName = "����ʵ��һ������Ľ��ϵͳ";
			courseName = courseName +"00"+i;
			//���ɿγ�id
			String courseid = UUID.randomUUID().toString().substring(0,16);
			//ִ�в���γ�DAO
			int insertCourseResult=MoocExtendDao.insertMoocFreeCourse(courseid,courseName,teacherid,classOne,classTwo,coursePrice,courseBasicRequire,courseIntroduce,exclusiveService);
			System.out.println("�γ̱����ִ�н����"+insertCourseResult);
			
			if(insertCourseResult>0) {
				//���������½�С��
				
				//�봴�������½�С�ڣ�
				int createChapterNum = 3;
				int createSeciotnNum = 3;
				
				String chapterid = "";
				
				
				for(int chapteri=0;chapteri<createChapterNum;chapteri++) {
					
					int chapterNum = chapteri +1;
					
					//�����½�id
					chapterid = courseid+"chap"+chapterNum;
					
					String chapterName = "ʵս��������Ľ��ϵͳ";
					
					chapterName = chapterName +chapterNum;
					
					//ִ�в����½�DAO
					int insertChapterResult=MoocExtendDao.insertMoocFreeChapter(chapterid,chapterName, courseid);
					
					System.out.println("ִ�в����½�DAO���ؽ����"+insertChapterResult);
					
					if(insertChapterResult>0) {
						
						//��������С�ڱ�
						
						String sectionid = "";
						
						
						
						String VideoUrl = "";
						
						for(int sectioni=0;sectioni<createSeciotnNum;sectioni++) {
							
							int sectionNum = sectioni +1;
							
							//����С��id
							sectionid = courseid+"chap"+chapterNum+"sect"+sectionNum;
							
							String sectionName = "ʵս��������Ľ��ϵͳС��";
							
							sectionName = sectionName +sectionNum;
							
							//ִ�в���С��DAO
							int insertSectionResult=MoocExtendDao.insertMoocFreeSection(sectionid, chapterid,sectionName,VideoUrl);
							out.println("ִ�в���С��DAO���ؽ����"+insertSectionResult);
							
							if(insertSectionResult>0) {
								System.out.println("С�ڱ����ɹ�");
							}else {
								System.out.println("С�ڱ����ʧ��");
								//out.println("{\"success\":0}");
							}
						}
						
					}else {
						System.out.println("�½ڱ����ʧ��");
						//out.println("{\"success\":0}");
					}
					
					
				}
				
			System.out.println("������һ���γ̣�"+batchNum);
				
			}else {
				System.out.println("�γ̱����ʧ��");
				///out.println("{\"success\":0}");
			}
	
		}
		
		//����Ļ�ֻ��˵���Ѿ���������˼��Σ������ɹ�����ʧ�ܵ���ϵͳ�����߿��ˡ�
		out.println("{\"success\":3}");

	}
	
	//��ѯ�û����ݣ���̨����
	/*
	 * ִ�в�ѯDAO...ֻҪ��ѯ�û��б����
	 * �Ȱ�˳��....�û�id,�û������û����룬�û��ֻ����û����䣬�Ƿ�Ϊ��ʦ
	 */
	public void queryUserInformationManage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MoocExtendDao extendDao = new MoocExtendDao();
		ArrayList<MoocUserData> userList = extendDao.queryUserListForAdmin();
		//�жϽ������ʼ����json���ݸ�ʽ
		PrintWriter out = response.getWriter();
		MoocUserData userData = new MoocUserData();
		if(userList == null) {
			//System.out.println("DAO�Ǳ�ִ�г���");
		}else if(userList.size()==0) {
			//���ݿ���û�пγ�
			//System.out.println("��ѯ���Ϊ�գ�δ�ҵ�����");
			out.println("{\"success\":0}");
			
		}else {
			//��ߵĹ��������һ���ǲ��ö���de �ҿ��Լ۸�success����ѭ���������������൱�������һ����β
			String jsonResponse = "{";
			for(int i=0;i<userList.size();i++) {
				userData =(MoocUserData)userList.get(i);
				int num = i+1;
				jsonResponse = jsonResponse + "\"user"+num+"\":[";
				jsonResponse = jsonResponse + "\""+userData.getmUserid()+"\",";//�û�id
				jsonResponse = jsonResponse + "\""+userData.getmUsername()+"\",";//�û�����
				jsonResponse = jsonResponse + "\""+userData.getmPasswd()+"\",";//�û�����
				jsonResponse = jsonResponse + "\""+userData.getmPhone()+"\",";//�û��ֻ�
				jsonResponse = jsonResponse + "\""+userData.getmEmail()+"\",";//�û�����
				//�����ұ�����ȫΪnull��Ĭ�϶��ǿ�����
				jsonResponse = jsonResponse + "\""+"��"+"\"],";//�Ƿ�Ϊ������
			}
			jsonResponse = jsonResponse + "\"success\":1,\"resultNum\":"+userList.size()+"}";
			System.out.println(jsonResponse);
			out.println(jsonResponse);
		}
		
	}
	
	//��ѯ�γ����ݣ���̨����
	/*
	 * json:{"courseName":xx,"courseid":xxx,"teacherid":,
	 * "courseTagOne":ss,"courseTagTwo":xxx,"coursePtime":xxx,"coursePrice":ss,}
	 * ��Ϊ���б����ݣ��Ľ�Ϊ��ά����
	 * *�Ȱ�˳���...�γ�id,�γ����ƣ��γ�1����ǩ���γ�2����ǩ���γ̼۸���ʦid������ʱ��
	 *  json:{
	 * 		"course1":["","","","",""]
	 *  }
	 */
	public void queryCourseInformationManage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//ִ�в�ѯDAO...ֻҪ��ѯ�γ̱����
		MoocExtendDao extendDao = new MoocExtendDao();
		ArrayList<MoocCourseData> courseList = extendDao.queryCourseListForAdmin();
		//�жϽ������ʼ����json���ݸ�ʽ
		PrintWriter out = response.getWriter();
		MoocCourseData courseData = new MoocCourseData();
		if(courseList == null) {
			//System.out.println("DAO�Ǳ�ִ�г���");
		}else if(courseList.size()==0) {
			//���ݿ���û�пγ�
			//System.out.println("��ѯ���Ϊ�գ�δ�ҵ�����");
			out.println("{\"success\":0}");
			
		}else {
			//��ߵĹ��������һ���ǲ��ö���de �ҿ��Լ۸�success����ѭ���������������൱�������һ����β
			String jsonResponse = "{";
			for(int i=0;i<courseList.size();i++) {
				courseData =(MoocCourseData)courseList.get(i);
				int num = i+1;
				jsonResponse = jsonResponse + "\"course"+num+"\":[";
				jsonResponse = jsonResponse + "\""+courseData.getmCourseid()+"\",";//�γ�id
				jsonResponse = jsonResponse + "\""+courseData.getmCourseName()+"\",";//�γ�����
				jsonResponse = jsonResponse + "\""+courseData.getmCourseClass()+"\",";//�γ�1��Ŀ¼
				jsonResponse = jsonResponse + "\""+courseData.getmCOurseClassTwo()+"\",";//�γ�2��Ŀ¼
				jsonResponse = jsonResponse + "\""+courseData.getCoursePrice()+"\",";//�γ̼۸�
				jsonResponse = jsonResponse + "\""+courseData.getmUserid()+"\",";//��ʦid
				jsonResponse = jsonResponse + "\""+courseData.getmCoursePtime()+"\"],";//�γ̷���ʱ��
				
			}
			jsonResponse = jsonResponse + "\"success\":1,\"resultNum\":"+courseList.size()+"}";
			System.out.println(jsonResponse);
			out.println(jsonResponse);
		}
		
	}
	
}
