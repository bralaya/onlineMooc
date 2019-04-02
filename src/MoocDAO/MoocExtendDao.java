package MoocDAO;

import java.sql.ResultSet;
import java.util.ArrayList;


import MoocDAO.MoocBasicDao;
import MoocData.MoocCommentData;
import MoocData.MoocCourseData;
import MoocData.MoocPayQuestionCommunicateData;
import MoocData.MoocPayQuestionOrderData;
import MoocData.MoocRecordData;
import MoocData.MoocTagData;
import MoocData.MoocUserData;


public class MoocExtendDao {
	//输出测试
	
	
	public static void main(String[] args) {
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
	
	//--------------单值查询-----------
	
	//查询单个用户名
	public String queryUserName(String userid) throws Exception{
		String UserName = "";
		String sql = "select mUserName from moocuser where mUserid='"+userid+"'";
		ResultSet rs = MoocBasicDao.executeQuery(sql);
		try {
			while(rs.next()){
				UserName=rs.getString("mUserName");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("查询用户名有问题");
		}
		return UserName;
	}
	
	//--------------集合查询-----------
	
	//查询用户列表
	public ArrayList<MoocUserData> queryUserListForAdmin() throws Exception{
		ArrayList<MoocUserData> userList = new ArrayList<MoocUserData>();
		MoocUserData MoocUserData = null;
		String sql = " select * from moocuser";
		ResultSet rs = MoocBasicDao.executeQuery(sql);
		try {
			while(rs.next()){
				MoocUserData = new MoocUserData();
				MoocUserData.setmUsername(rs.getString("mUserName"));
				MoocUserData.setmUserid(rs.getString("mUserid"));
				MoocUserData.setmPhone(rs.getString("mPhone"));
				MoocUserData.setmPasswd(rs.getString("mPasswd"));
				MoocUserData.setmEmail(rs.getString("mEmail"));
				//添加到arraylist里
				userList.add(MoocUserData);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("查询用户列表有问题");
		}
		return userList;
	}
	
	//查询课程列表
	public ArrayList<MoocCourseData> queryCourseListForAdmin() throws Exception{
		ArrayList<MoocCourseData> courseList = new ArrayList<MoocCourseData>();
		MoocCourseData MoocCourseData = null;
		String sql = "select * from moocfreecourse";
		ResultSet rs = MoocBasicDao.executeQuery(sql);
		try {
			while(rs.next()){
				MoocCourseData = new MoocCourseData();
				MoocCourseData.setmCourseName(rs.getString("mCourseName"));
				MoocCourseData.setmCourseid(rs.getString("mCourseid"));
				MoocCourseData.setCoursePrice(rs.getInt("coursePrice"));
				MoocCourseData.setmUserid(rs.getString("mUserid"));
				MoocCourseData.setmCourseClass(rs.getString("mCourseClass"));
				MoocCourseData.setmCOurseClassTwo(rs.getString("mCourseClassTwo"));
				MoocCourseData.setmCoursePtime(rs.getString("mCoursePtime"));
				//添加到arraylist里
				courseList.add(MoocCourseData);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("查询课程列表有问题");
		}
		return courseList;
	}
	
	
	//-------------付费问答查询------------------
	
	//开课者查询 [提问者请求订单]队列
	public ArrayList<MoocPayQuestionOrderData> queryAskerList(String askerid) throws Exception {
		String sql=null;
		sql = "select * from payquestionorderrecord where answerUserid = '"+askerid+"' and orderEffective=false order by askTime";
		ResultSet rs = MoocBasicDao.executeQuery(sql);
		ArrayList<MoocPayQuestionOrderData> askerList = new ArrayList<MoocPayQuestionOrderData>();
		MoocPayQuestionOrderData MoocPayQuestionOrderData = null;
		try {
			while(rs.next()){
				MoocPayQuestionOrderData = new MoocPayQuestionOrderData();
				MoocPayQuestionOrderData.setAskerid(rs.getString("askerid"));
				MoocPayQuestionOrderData.setAskTime(rs.getString("askTime"));
				MoocPayQuestionOrderData.setCourseid(rs.getString("courseid"));
				MoocPayQuestionOrderData.setAskerName(rs.getString("askerName"));
				MoocPayQuestionOrderData.setCourseName(rs.getString("courseName"));
				MoocPayQuestionOrderData.setPayQuestionOrderid(rs.getString("payQuestionOrderid"));
				//添加到arraylist里
				askerList.add(MoocPayQuestionOrderData);
			}
			rs.close();
			return askerList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("DAO失败");
		return null;
	}
	
	//提问者 查询订单是否生效 操作
	public ArrayList<MoocPayQuestionOrderData> queryOrderCondition(String payQuestionOrderid) throws Exception {
		String sql=null;
		sql = "select orderEffective from payquestionorderrecord where payQuestionOrderid = '"+payQuestionOrderid+"'";
		ResultSet rs = MoocBasicDao.executeQuery(sql);
		ArrayList<MoocPayQuestionOrderData> orderEffective = new ArrayList<MoocPayQuestionOrderData>();
		MoocPayQuestionOrderData MoocPayQuestionOrderData = null;
		try {
			while(rs.next()){
				MoocPayQuestionOrderData = new MoocPayQuestionOrderData();
				MoocPayQuestionOrderData.setOrderEffective(rs.getBoolean("orderEffective"));
				//添加到arraylist里
				orderEffective.add(MoocPayQuestionOrderData);
			}
			rs.close();
			return orderEffective;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("DAO失败");
		return null;
	}
	
	
	//开课者，提问者查询 聊天记录列表 
	/*
	 * 传入参数为提问者id,开课者id,课程id
	 * 进行查询select 发送者名称，发送的消息 from xxx  where 课程id= xxx 且 （发送者为提问者 接收者为 开课者 或 发送者为开课者 接收者为提问者）
	 */
	public ArrayList<MoocPayQuestionCommunicateData> queryMesageList(String payQuestionOrderid) throws Exception {
		String sql=null;
		sql = "select * from moocpayquestion where payQuestionOrderid='"+payQuestionOrderid+"'";
		System.out.println("执行查询聊天记录的sql:"+sql);
		ResultSet rs = MoocBasicDao.executeQuery(sql);
		ArrayList<MoocPayQuestionCommunicateData> messageList = new ArrayList<MoocPayQuestionCommunicateData>();
		MoocPayQuestionCommunicateData MoocPayQuestionCommunicateData = null;
		try {
			while(rs.next()){
				MoocPayQuestionCommunicateData = new MoocPayQuestionCommunicateData();
				MoocPayQuestionCommunicateData.setCommunicationMessage(rs.getString("communicationMessage"));
				MoocPayQuestionCommunicateData.setMessageSenderName(rs.getString("messageSenderName"));
				//添加到arraylist里
				messageList.add(MoocPayQuestionCommunicateData);
			}
			rs.close();
			return messageList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("DAO失败");
		return null;
	}
	
	
	
	
	//------------首页查询-----------------
	
	//------查询返回特定条件的课程列表------
	/*
	 * 查询前10条，按照最新时间排序
	 * 返回课程id，课程名称，开课者id,
	 * 修改：
	 * 扩展为查询课程列表，首页的各种查询请求都通过这个来执行
	 */
	public ArrayList<MoocCourseData> queryCourseList(int chose,String tagEdition) throws Exception {
		String sql=null;
		switch (chose) {
		case 1:sql = "select * from moocfreecourse where coursePrice=0 order by mCoursePtime limit 10";//为什么这里不用加分号
			break;//最新免费课程查询
		case 2:sql = "select * from moocfreecourse where coursePrice !=0 order by mCoursePtime limit 10";
			break;//最新付费课程查询
		case 3:sql = "select * from moocfreecourse where coursePrice=0 order by studyNum limit 10";
			break;//免费热门课程查询
		case 4:sql = "select * from moocfreecourse where coursePrice!=0 order by studyNum limit 10";
			break;//付费热门课程查询
		case 5:sql = "select * from moocfreecourse where coursePrice!=0 and mCourseClass = '"+tagEdition+"'";
			break;//更多课程页 付费 类别1 条件查询所有课程
		case 6:sql = "select * from moocfreecourse where coursePrice=0 and mCourseClass = '"+tagEdition+"'";
			break;//更多课程页 免费 类别1 条件查询所有课程
		case 7:sql = "select * from moocfreecourse where coursePrice!=0 and mCourseClassTwo = '"+tagEdition+"'";
			break;//更多课程页 付费 类别2 条件查询所有课程
		case 8:sql = "select * from moocfreecourse where coursePrice=0 and mCourseClassTwo = '"+tagEdition+"'";
			break;//更多课程页 免费 类别2 条件查询所有课程
		case 9:sql = "select * from moocfreecourse where coursePrice=0 order by mCoursePtime limit 10";
			break;//评价最高免费课程...实际这里还没做
		case 10:sql = "select * from moocfreecourse where coursePrice !=0 order by mCoursePtime limit 10";
			break;//评价最高付费课程...实际这里还没做
		default:
			break;
		}
		ResultSet rs = MoocBasicDao.executeQuery(sql);
		ArrayList<MoocCourseData> courseList = new ArrayList<MoocCourseData>();
		MoocCourseData courseData = null;
		try {
			while(rs.next()){
				courseData = new MoocCourseData();
				courseData.setmCourseid(rs.getString("mCourseid"));
				courseData.setmCourseName(rs.getString("mCourseName"));
				courseData.setmUserid(rs.getString("mUserid"));
				courseData.setCoursePrice(rs.getInt("coursePrice"));
				
				//添加到arraylist里
				courseList.add(courseData);
			}
			rs.close();
			return courseList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("输出null");
		return null;
	}
	
	//---------更多课程页查询------------
	
	//查询1类标签
	public ArrayList<MoocTagData> queryClassOneTag() throws Exception {
		String sql=null;
		sql = "select * from mooctagclassone";
		ResultSet rs = MoocBasicDao.executeQuery(sql);
		ArrayList<MoocTagData> classOneList = new ArrayList<MoocTagData>();
		MoocTagData classOneData = null;
		try {
			while(rs.next()){
				classOneData = new MoocTagData();
				classOneData.setClassOneTag(rs.getString("classOneTagName"));
				//添加到arraylist里
				classOneList.add(classOneData);
			}
			rs.close();
			return classOneList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("输出null0");//???
		return null;
	}
	
	//查询2类标签
	public ArrayList<MoocTagData> queryClassTwoTag(String classOneTagName) throws Exception {
		String sql=null;
		sql = "select * from mooctagclasstwo where classOneTagName = '"+classOneTagName+"';";
		ResultSet rs = MoocBasicDao.executeQuery(sql);
		ArrayList<MoocTagData> classTwoList = new ArrayList<MoocTagData>();
		MoocTagData classTwoData = null;
		try {
			while(rs.next()){
				classTwoData = new MoocTagData();
				classTwoData.setClassTwoTag(rs.getString("classTwoTagName"));
				//添加到arraylist里
				classTwoList.add(classTwoData);
			}
			rs.close();
			return classTwoList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("输出null0");//???
		return null;
	}
	
	//----------详细课程页查询--------------
	
	//查询单个课程
	/*
	 * 这个感觉可以合并到上面那个查询免费课程里的
	 */
	public ArrayList<MoocCourseData> querySingleCourse(String courseid) throws Exception {
		String sql=null;
		sql = "select * from moocfreecourse where mCourseid='"+courseid+"';";
		ResultSet rs = MoocBasicDao.executeQuery(sql);
		ArrayList<MoocCourseData> courseList = new ArrayList<MoocCourseData>();
		MoocCourseData courseData = null;
		try {
			while(rs.next()){
				courseData = new MoocCourseData();
				courseData.setmCourseid(rs.getString("mCourseid"));
				courseData.setmCourseName(rs.getString("mCourseName"));
				courseData.setmUserid(rs.getString("mUserid"));//这个是开课者id
				courseData.setCoursePrice(rs.getInt("coursePrice"));
				//添加到arraylist里
				courseList.add(courseData);
			}
			rs.close();
			return courseList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("输出null0");//???
		return null;
	}
	//查询单个课程对应的章节
	public ArrayList<MoocCourseData> queryCourseChapter(String courseid) throws Exception {
		String sql=null;
		sql = "select * from moocfreechapter where mCourseid='"+courseid+"';";
		ResultSet rs = MoocBasicDao.executeQuery(sql);
		ArrayList<MoocCourseData> courseList = new ArrayList<MoocCourseData>();
		MoocCourseData courseData = null;
		try {
			while(rs.next()){
				courseData = new MoocCourseData();
				courseData.setmChapterid(rs.getString("mChapterid"));
				courseData.setmChapterName(rs.getString("mChapterName"));
				//添加到arraylist里
				courseList.add(courseData);
			}
			rs.close();
			return courseList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("输出null1");//???
		return null;
	}	
	
	//查询单个课程对应的小节
	public ArrayList<MoocCourseData> queryCourseSection(String chapterid) throws Exception {
		String sql=null;
		sql = "select * from moocfreesection where mChapterid='"+chapterid+"';";
		ResultSet rs = MoocBasicDao.executeQuery(sql);
		ArrayList<MoocCourseData> courseList = new ArrayList<MoocCourseData>();
		MoocCourseData courseData = null;
		try {
			while(rs.next()){
				courseData = new MoocCourseData();
				courseData.setmSectionid(rs.getString("mSectionid"));
				courseData.setmSectionName(rs.getString("mSectionName"));
				courseData.setmVideoUrl(rs.getString("mVideoUrl"));
				//添加到arraylist里
				courseList.add(courseData);
			}
			rs.close();
			return courseList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("输出null2");//???
		return null;
	}
	
	//查询课程对应的所有评论
	public ArrayList<MoocCommentData> queryCourseComment(String courseid) throws Exception {
		String sql=null;
		sql = "select * from moocCourseComment where mCommentCourseid='"+courseid+"' order by mCommentPTime;";
		ResultSet rs = MoocBasicDao.executeQuery(sql);
		ArrayList<MoocCommentData> commentList = new ArrayList<MoocCommentData>();
		MoocCommentData commentData = null;
		try {
			while(rs.next()){
				commentData = new MoocCommentData();
				commentData.setmComment(rs.getString("mComment"));
				commentData.setmCommentUserid(rs.getString("mCommentUserid"));
				commentData.setmCommentPTime(rs.getString("mCommentPTime"));
				commentData.setmCommentUserName(rs.getString("mCommentUserName"));
				//添加到arraylist里
				commentList.add(commentData);
			}
			rs.close();
			return commentList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("输出null2");//???
		return null;
	}
	
	//查询实时交互的付费问答数据
	public ArrayList<MoocPayQuestionCommunicateData> queryPayCommunicateMessage(String userid) throws Exception {
		String sql=null;
		sql = "select * from moocpayquestion where messageSenderid='"+userid+"' or messageReciverid='"+userid+"' order by messageSendTime;";
		ResultSet rs = MoocBasicDao.executeQuery(sql);
		ArrayList<MoocPayQuestionCommunicateData> messageList = new ArrayList<MoocPayQuestionCommunicateData>();
		MoocPayQuestionCommunicateData messageData = null;
		try {
			while(rs.next()){
				messageData = new MoocPayQuestionCommunicateData();
				messageData.setCommunicationMessage(rs.getString("communicationMessage"));
				messageData.setMessageSenderid(rs.getString("messageSenderid"));
				messageData.setMessageSenderName(rs.getString("messageSenderName"));
				messageData.setMessageSendTime(rs.getString("messageSendTime"));
				//添加到arraylist里
				messageList.add(messageData);
			}
			rs.close();
			return messageList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("输出null2");//???
		return null;
	}
	
	
	//查询课程学习记录表里的数据匹配
	/*
	 * 查询当前这个课程id是否存在，要求条件为当前登入的用户id和当前这个课程id
	 */
	public ArrayList<MoocRecordData> queryStudyRecord(String userid,String courseid) throws Exception {
		String sql=null;
		sql = "select * from moocstudyrecord where mStudyUserid='"+userid+"' and mStudyCourseid='"+courseid+"';";
		ResultSet rs = MoocBasicDao.executeQuery(sql);
		ArrayList<MoocRecordData> recordList = new ArrayList<MoocRecordData>();
		MoocRecordData recordData = null;
		try {
			while(rs.next()){
				recordData = new MoocRecordData();
				recordData.setStudyRecordCourseid(rs.getString("mStudyCourseid"));
				recordData.setStudyRecordUserid(rs.getString("mStudyUserid"));
				//添加到arraylist里
				recordList.add(recordData);
			}
			rs.close();
			return recordList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("输出null2");//???
		return null;
	}
	
	//查询课程购买记录表里的数据匹配
	/*
	 * 查询当前页面课程id是否存在于表里，要求条件为当前登入的用户id和当前的课程id
	 * 
	 */
	public ArrayList<MoocRecordData> queryPayRecord(String userid,String courseid) throws Exception {
		String sql=null;
		
		sql = "select * from moocpayrecord where mPayCourseid='"+courseid+"' and mPayUserid='"+userid+"'";
		System.out.println(sql);
		ResultSet rs = MoocBasicDao.executeQuery(sql);
		ArrayList<MoocRecordData> payRecordList = new ArrayList<MoocRecordData>();
		MoocRecordData payRecordData = null;
		try {
			while(rs.next()){
				payRecordData = new MoocRecordData();
				payRecordData.setPayCourseid(rs.getString("mPayCourseid"));
				payRecordData.setPayUserid(rs.getString("mPayUserid"));
				//添加到arraylist里
				payRecordList.add(payRecordData);
			}
			rs.close();
			return payRecordList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("输出null2");//???
		return null;
	}
	
	//------用户后台操作------
	
	
	//执行查询一级标签给上传课程用的操作
	public ArrayList<MoocTagData> queryMoocTagClassOne(String userid,String courseid) throws Exception {
		String sql=null;
		
		sql = "select * from mooctagclassone ";
		ResultSet rs = MoocBasicDao.executeQuery(sql);
		ArrayList<MoocTagData> tagOneList = new ArrayList<MoocTagData>();
		MoocTagData tagOne = null;
		try {
			while(rs.next()){
				tagOne = new MoocTagData();
				tagOne.setClassOneTag(rs.getString("classOneTagName"));
				//添加到arraylist里
				tagOneList.add(tagOne);
			}
			rs.close();
			return tagOneList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("输出null2");//???
		return null;
	}
	
	//执行查询2级标签给上传课程用的操作
		public ArrayList<MoocTagData> queryMoocTagClassTwo(String tagOne) throws Exception {
			String sql=null;
			
			sql = "select * from mooctagclasstwo where classOneTagName='"+tagOne+"'";
			ResultSet rs = MoocBasicDao.executeQuery(sql);
			ArrayList<MoocTagData> tagTwoList = new ArrayList<MoocTagData>();
			MoocTagData tagTwoData = null;
			try {
				while(rs.next()){
					tagTwoData = new MoocTagData();
					tagTwoData.setClassTwoTag(rs.getString("classTwoTagName"));
					//添加到arraylist里
					tagTwoList.add(tagTwoData);
				}
				rs.close();
				return tagTwoList;

			}catch (Exception e) {
				e.printStackTrace();
				
			}finally {
			}
			System.out.println("输出null2");//???
			return null;
		}	
	
	//执行课程信息的插入操作
	/*
	 * @课程id,课程名称，课程大类，课程细类，时间自动生成不用管
	 * @添加参数：课程价格，课程基础要求，课程介绍，课程专享服务
	 */
	public static int insertMoocFreeCourse(String courseid,String courseName,String userid,String classOne,String classTwo,int coursePrice,String courseRequire,String courseIntroduce,String exclusiveService ){
		String sql = "insert into moocfreecourse(mCourseid,mCourseName,mUserid,mCourseClass,mCourseClassTwo,coursePrice,courseRequire,courseIntroduce,exclusiveService)values"
				+"('" + courseid + "','" + courseName+ "','" + userid + "','"+classOne+"','"+classTwo+"','"+coursePrice+"','"+courseRequire+"','"+courseIntroduce+"','"+exclusiveService+"')";
		//这边我觉得不能随便空格吧'ssss'和'ssss '是有区别的?
		int i = MoocBasicDao.executeUpdate(sql);
		MoocBasicDao.close();
		return i;
	}
	
	//执行章节信息的插入操作
	/*
	 * @章节id，章节名称，课程id
	 */
	public static int insertMoocFreeChapter(String chapterid,String chapterName,String courseid){
		String sql = "insert into moocfreechapter(mChapterid,mChapterName,mCourseid)values"
				+"('" + chapterid + "','" + chapterName + "','"+courseid+"')";
		
		int i = MoocBasicDao.executeUpdate(sql);
		MoocBasicDao.close();
		return i;
	}
	
	//执行小节信息的插入操作
	/*
	 * @小节id,小节名称，章节id
	 */
	public static int insertMoocFreeSection(String mSectionid,String mChapterid,String mSectionName,String mVideoUrl){
		String sql = "insert into moocfreesection(mSectionid,mChapterid,mSectionName,mVideoUrl)values"
				+"('" + mSectionid + "','" + mChapterid + "','"+mSectionName+"','"+mVideoUrl+"')";
		
		int i = MoocBasicDao.executeUpdate(sql);
		MoocBasicDao.close();
		return i;
	}
	
	//执行购买课程插入记录
	public static int insertMoocPayRecord(String userid,String courseid,int courseprice){
		String sql = "insert into moocpayrecord(mPayUserid,mPayCourseid,coursePrice)values"
				+"('" + userid + "','" + courseid +"',"+courseprice+ ")";
		int i = MoocBasicDao.executeUpdate(sql);
		MoocBasicDao.close();
		return i;
	}
	
	//执行课程学习人数+1插入操作
	/*
	 * 
	 * 给课程表的studyNum值+1
	 */
	public static int addMoocStudyNum(String courseid){
		String sql = "update moocfreecourse set studyNum = studyNum +1 where mCourseid='"+courseid+"'";
		int i = MoocBasicDao.executeUpdate(sql);
		MoocBasicDao.close();
		return i;
	}
	
	//执行立即学习课程记录操作
	/*
	 * 往学习课程记录表里插入课程id，用户id，自增时间
	 */
	public static int insertMoocStudyRecord(String userid,String courseid){
		String sql = "insert into moocstudyrecord(mStudyCourseid,mStudyUserid)values"
				+"('" + courseid +"','"+userid+ "')";
		int i = MoocBasicDao.executeUpdate(sql);
		MoocBasicDao.close();
		return i;
	}
	
	//执行插入	付费问答订单记录表	操作
	public static int insertPayQuestionOrderRecord(String payquestionOrderid,String askerid,String askerName,String courseid,String courseName,String teacherid,String teacherName,boolean orderEffective){
		String sql = "insert into payquestionOrderRecord(payquestionOrderid,courseid,courseName,askerid,askerName,answerUserid,answerName,orderEffective)values"
				+"('" + payquestionOrderid +"','"+courseid+"','"+courseName+"','"+askerid+"','"+askerName+"','"+teacherid+"','"+teacherName+"',"+orderEffective+ ")";
		int i = MoocBasicDao.executeUpdate(sql);
		MoocBasicDao.close();
		return i;
	}
	
	//执行修改	付费问答订单生效值为生效	操作
	public static int makePayQuestionOrderEffective(String payquestionOrderid){
		String sql = "update payquestionOrderRecord set orderEffective=true where payquestionOrderid='"+payquestionOrderid+"'";
		int i = MoocBasicDao.executeUpdate(sql);
		MoocBasicDao.close();
		return i;
	}
	
	//执行插入 发送者消息 操作
	public static int insertSenderidMessage(String senderid,String senderName,String receiverid,String receiverName,String Message,String courseid,String payQuestionOrderid){
		String sql = "insert into moocpayquestion(communicationMessage,messageSenderid,messageSenderName,messageBelongCourseid,messageReciverid,messageReciverName,payQuestionOrderid)values"
				+"('" + Message +"','"+senderid+"','"+senderName+"','"+courseid+"','"+receiverid+"','"+receiverName+"','"+payQuestionOrderid+"')";
		int i = MoocBasicDao.executeUpdate(sql);
		MoocBasicDao.close();
		return i;
	}
	
	
	//--------------登入注册---------------
	
	//判断账户是否存在
	
		
	//登入校验
	/*
	 * 因为是可以手机/邮箱登入的，所以到时那边传递来时要夹一个参数让这里知道传递来的是手机还是邮箱
	 * select xxx from xxxx where xx= xx=;
	 * 然后将结果返回，没查到返回一个标识表示手机或密码错误
	 */
	public ArrayList<MoocUserData> LoginCheck(String account,String password,boolean isPhone) throws Exception {
		String sql=null;
		if(isPhone==true) {
			sql = "select * from moocuser where mPhone='" + account + "' and mPasswd ='" + password +"'";
			
		}else {
			sql = "select * from moocuser where mEmail='" + account + "' and mPasswd ='" + password +"'";
			
		}
		//上面这段还可以再修改
		ResultSet rs = MoocBasicDao.executeQuery(sql);
		ArrayList<MoocUserData> userList = new ArrayList<MoocUserData>();
		MoocUserData userData = null;
		try {
			while(rs.next()){
				userData = new MoocUserData();
				userData.setmUsername(rs.getString("mUserName"));
				userData.setmUserid(rs.getString("mUserid"));
				userData.setmPhone(rs.getString("mPhone"));
				//添加到arraylist里
				userList.add(userData);
			}
			rs.close();
			return userList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("输出null");//???
		return null;
	}
	
	//注册
	public static int insertMoocUserTable(String userid,String userName,String Phone,String Passwd){
		String sql = "insert into moocuser(mUserid,mUserName,mPasswd,mPhone)values"
				+"('" + userid +"','"+userName +"','"+Passwd +"','"+Phone+ "')";
		int i = MoocBasicDao.executeUpdate(sql);
		MoocBasicDao.close();
		return i;
	}
}
