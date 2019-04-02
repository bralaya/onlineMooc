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
//end,这些我都没手写，只是把下面的继承写下上面就自动补充了HttpServlet,把doGet和doPost写下就自动补充了上面这些
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
		//测试
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html;charset  = UTF-8");
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset  = UTF-8");//这里不写会如何？
		//获取传递过来的方法选择参数
		String functionChoise = request.getParameter("functionChoise");
		//查询用户数据（后台管理）
		if (functionChoise.equals("queryUserInformationManage")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				
				queryUserInformationManage(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//查询课程数据（后台管理）
		if (functionChoise.equals("queryCourseInformationManage")) {
			//there (try..catch) i remember copy from teacher,didn't know why
			try {
				
				queryCourseInformationManage(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//批量创建测试课程数据（系统测试）
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
	
	//批量创建测试课程数据（系统测试）
	/*
	 * JS传来：批量创建几次，
	 * 这边生成课程id,章节id，小节id，后两个是构造出来的
	 */
	public void testCreateCourseData(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("创建测试课程数据（系统测试）");
		PrintWriter out = response.getWriter();
		
		//获取传来的N次批量操作
		String batchN = request.getParameter("courseChoise");
		int batchNum = Integer.parseInt(batchN);
		System.out.println("创建测试课程数据（系统测试）批量创建："+batchNum);
		
		String classOne = "后端开发";
		String classTwo = "java";
		
		int coursePrice = 0;
			
		String exclusiveService = "提供十次免费的付费问答机会";
		
		String courseIntroduce = "这是一个非常好的课程";
		
		String courseBasicRequire = "需要你会Java的基础";
		
		String teacherid = "26791e89-82a1-45c0-800f-f709f20f";
		
		//批量添加虚假课程无真实视频播放的课程
		for(int i=0;i<batchNum;i++) {
			
			String courseName = "教你实现一个在线慕课系统";
			courseName = courseName +"00"+i;
			//生成课程id
			String courseid = UUID.randomUUID().toString().substring(0,16);
			//执行插入课程DAO
			int insertCourseResult=MoocExtendDao.insertMoocFreeCourse(courseid,courseName,teacherid,classOne,classTwo,coursePrice,courseBasicRequire,courseIntroduce,exclusiveService);
			System.out.println("课程表插入执行结果："+insertCourseResult);
			
			if(insertCourseResult>0) {
				//继续插入章节小节
				
				//想创建几个章节小节？
				int createChapterNum = 3;
				int createSeciotnNum = 3;
				
				String chapterid = "";
				
				
				for(int chapteri=0;chapteri<createChapterNum;chapteri++) {
					
					int chapterNum = chapteri +1;
					
					//生成章节id
					chapterid = courseid+"chap"+chapterNum;
					
					String chapterName = "实战开发在线慕课系统";
					
					chapterName = chapterName +chapterNum;
					
					//执行插入章节DAO
					int insertChapterResult=MoocExtendDao.insertMoocFreeChapter(chapterid,chapterName, courseid);
					
					System.out.println("执行插入章节DAO返回结果："+insertChapterResult);
					
					if(insertChapterResult>0) {
						
						//继续插入小节表
						
						String sectionid = "";
						
						
						
						String VideoUrl = "";
						
						for(int sectioni=0;sectioni<createSeciotnNum;sectioni++) {
							
							int sectionNum = sectioni +1;
							
							//生成小节id
							sectionid = courseid+"chap"+chapterNum+"sect"+sectionNum;
							
							String sectionName = "实战开发在线慕课系统小节";
							
							sectionName = sectionName +sectionNum;
							
							//执行插入小节DAO
							int insertSectionResult=MoocExtendDao.insertMoocFreeSection(sectionid, chapterid,sectionName,VideoUrl);
							out.println("执行插入小节DAO返回结果："+insertSectionResult);
							
							if(insertSectionResult>0) {
								System.out.println("小节表插入成功");
							}else {
								System.out.println("小节表插入失败");
								//out.println("{\"success\":0}");
							}
						}
						
					}else {
						System.out.println("章节表插入失败");
						//out.println("{\"success\":0}");
					}
					
					
				}
				
			System.out.println("插入完一个课程："+batchNum);
				
			}else {
				System.out.println("课程表插入失败");
				///out.println("{\"success\":0}");
			}
	
		}
		
		//这里的话只能说明已经批量添加了几次，操作成功还是失败得在系统输出这边看了。
		out.println("{\"success\":3}");

	}
	
	//查询用户数据（后台管理）
	/*
	 * 执行查询DAO...只要查询用户列表就行
	 * 先按顺序....用户id,用户名，用户密码，用户手机，用户邮箱，是否为老师
	 */
	public void queryUserInformationManage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MoocExtendDao extendDao = new MoocExtendDao();
		ArrayList<MoocUserData> userList = extendDao.queryUserListForAdmin();
		//判断结果集开始构造json数据格式
		PrintWriter out = response.getWriter();
		MoocUserData userData = new MoocUserData();
		if(userList == null) {
			//System.out.println("DAO那边执行出错");
		}else if(userList.size()==0) {
			//数据库里没有课程
			//System.out.println("查询结果为空，未找到数据");
			out.println("{\"success\":0}");
			
		}else {
			//这边的构造最后是一行是不用逗号de 我可以价格success的在循环结束后这样就相当于添加了一个结尾
			String jsonResponse = "{";
			for(int i=0;i<userList.size();i++) {
				userData =(MoocUserData)userList.get(i);
				int num = i+1;
				jsonResponse = jsonResponse + "\"user"+num+"\":[";
				jsonResponse = jsonResponse + "\""+userData.getmUserid()+"\",";//用户id
				jsonResponse = jsonResponse + "\""+userData.getmUsername()+"\",";//用户名称
				jsonResponse = jsonResponse + "\""+userData.getmPasswd()+"\",";//用户密码
				jsonResponse = jsonResponse + "\""+userData.getmPhone()+"\",";//用户手机
				jsonResponse = jsonResponse + "\""+userData.getmEmail()+"\",";//用户邮箱
				//这里我表里是全为null的默认都是开课者
				jsonResponse = jsonResponse + "\""+"是"+"\"],";//是否为开课者
			}
			jsonResponse = jsonResponse + "\"success\":1,\"resultNum\":"+userList.size()+"}";
			System.out.println(jsonResponse);
			out.println(jsonResponse);
		}
		
	}
	
	//查询课程数据（后台管理）
	/*
	 * json:{"courseName":xx,"courseid":xxx,"teacherid":,
	 * "courseTagOne":ss,"courseTagTwo":xxx,"coursePtime":xxx,"coursePrice":ss,}
	 * 因为是列表数据，改进为二维数组
	 * *先按顺序吧...课程id,课程名称，课程1级标签，课程2级标签，课程价格，老师id，发布时间
	 *  json:{
	 * 		"course1":["","","","",""]
	 *  }
	 */
	public void queryCourseInformationManage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//执行查询DAO...只要查询课程表就行
		MoocExtendDao extendDao = new MoocExtendDao();
		ArrayList<MoocCourseData> courseList = extendDao.queryCourseListForAdmin();
		//判断结果集开始构造json数据格式
		PrintWriter out = response.getWriter();
		MoocCourseData courseData = new MoocCourseData();
		if(courseList == null) {
			//System.out.println("DAO那边执行出错");
		}else if(courseList.size()==0) {
			//数据库里没有课程
			//System.out.println("查询结果为空，未找到数据");
			out.println("{\"success\":0}");
			
		}else {
			//这边的构造最后是一行是不用逗号de 我可以价格success的在循环结束后这样就相当于添加了一个结尾
			String jsonResponse = "{";
			for(int i=0;i<courseList.size();i++) {
				courseData =(MoocCourseData)courseList.get(i);
				int num = i+1;
				jsonResponse = jsonResponse + "\"course"+num+"\":[";
				jsonResponse = jsonResponse + "\""+courseData.getmCourseid()+"\",";//课程id
				jsonResponse = jsonResponse + "\""+courseData.getmCourseName()+"\",";//课程名称
				jsonResponse = jsonResponse + "\""+courseData.getmCourseClass()+"\",";//课程1级目录
				jsonResponse = jsonResponse + "\""+courseData.getmCOurseClassTwo()+"\",";//课程2级目录
				jsonResponse = jsonResponse + "\""+courseData.getCoursePrice()+"\",";//课程价格
				jsonResponse = jsonResponse + "\""+courseData.getmUserid()+"\",";//老师id
				jsonResponse = jsonResponse + "\""+courseData.getmCoursePtime()+"\"],";//课程发布时间
				
			}
			jsonResponse = jsonResponse + "\"success\":1,\"resultNum\":"+courseList.size()+"}";
			System.out.println(jsonResponse);
			out.println(jsonResponse);
		}
		
	}
	
}
