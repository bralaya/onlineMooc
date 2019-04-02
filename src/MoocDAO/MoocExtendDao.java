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
	//�������
	
	
	public static void main(String[] args) {
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
	
	//--------------��ֵ��ѯ-----------
	
	//��ѯ�����û���
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
			System.out.println("��ѯ�û���������");
		}
		return UserName;
	}
	
	//--------------���ϲ�ѯ-----------
	
	//��ѯ�û��б�
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
				//��ӵ�arraylist��
				userList.add(MoocUserData);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("��ѯ�û��б�������");
		}
		return userList;
	}
	
	//��ѯ�γ��б�
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
				//��ӵ�arraylist��
				courseList.add(MoocCourseData);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("��ѯ�γ��б�������");
		}
		return courseList;
	}
	
	
	//-------------�����ʴ��ѯ------------------
	
	//�����߲�ѯ [���������󶩵�]����
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
				//��ӵ�arraylist��
				askerList.add(MoocPayQuestionOrderData);
			}
			rs.close();
			return askerList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("DAOʧ��");
		return null;
	}
	
	//������ ��ѯ�����Ƿ���Ч ����
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
				//��ӵ�arraylist��
				orderEffective.add(MoocPayQuestionOrderData);
			}
			rs.close();
			return orderEffective;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("DAOʧ��");
		return null;
	}
	
	
	//�����ߣ������߲�ѯ �����¼�б� 
	/*
	 * �������Ϊ������id,������id,�γ�id
	 * ���в�ѯselect ���������ƣ����͵���Ϣ from xxx  where �γ�id= xxx �� ��������Ϊ������ ������Ϊ ������ �� ������Ϊ������ ������Ϊ�����ߣ�
	 */
	public ArrayList<MoocPayQuestionCommunicateData> queryMesageList(String payQuestionOrderid) throws Exception {
		String sql=null;
		sql = "select * from moocpayquestion where payQuestionOrderid='"+payQuestionOrderid+"'";
		System.out.println("ִ�в�ѯ�����¼��sql:"+sql);
		ResultSet rs = MoocBasicDao.executeQuery(sql);
		ArrayList<MoocPayQuestionCommunicateData> messageList = new ArrayList<MoocPayQuestionCommunicateData>();
		MoocPayQuestionCommunicateData MoocPayQuestionCommunicateData = null;
		try {
			while(rs.next()){
				MoocPayQuestionCommunicateData = new MoocPayQuestionCommunicateData();
				MoocPayQuestionCommunicateData.setCommunicationMessage(rs.getString("communicationMessage"));
				MoocPayQuestionCommunicateData.setMessageSenderName(rs.getString("messageSenderName"));
				//��ӵ�arraylist��
				messageList.add(MoocPayQuestionCommunicateData);
			}
			rs.close();
			return messageList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("DAOʧ��");
		return null;
	}
	
	
	
	
	//------------��ҳ��ѯ-----------------
	
	//------��ѯ�����ض������Ŀγ��б�------
	/*
	 * ��ѯǰ10������������ʱ������
	 * ���ؿγ�id���γ����ƣ�������id,
	 * �޸ģ�
	 * ��չΪ��ѯ�γ��б���ҳ�ĸ��ֲ�ѯ����ͨ�������ִ��
	 */
	public ArrayList<MoocCourseData> queryCourseList(int chose,String tagEdition) throws Exception {
		String sql=null;
		switch (chose) {
		case 1:sql = "select * from moocfreecourse where coursePrice=0 order by mCoursePtime limit 10";//Ϊʲô���ﲻ�üӷֺ�
			break;//������ѿγ̲�ѯ
		case 2:sql = "select * from moocfreecourse where coursePrice !=0 order by mCoursePtime limit 10";
			break;//���¸��ѿγ̲�ѯ
		case 3:sql = "select * from moocfreecourse where coursePrice=0 order by studyNum limit 10";
			break;//������ſγ̲�ѯ
		case 4:sql = "select * from moocfreecourse where coursePrice!=0 order by studyNum limit 10";
			break;//�������ſγ̲�ѯ
		case 5:sql = "select * from moocfreecourse where coursePrice!=0 and mCourseClass = '"+tagEdition+"'";
			break;//����γ�ҳ ���� ���1 ������ѯ���пγ�
		case 6:sql = "select * from moocfreecourse where coursePrice=0 and mCourseClass = '"+tagEdition+"'";
			break;//����γ�ҳ ��� ���1 ������ѯ���пγ�
		case 7:sql = "select * from moocfreecourse where coursePrice!=0 and mCourseClassTwo = '"+tagEdition+"'";
			break;//����γ�ҳ ���� ���2 ������ѯ���пγ�
		case 8:sql = "select * from moocfreecourse where coursePrice=0 and mCourseClassTwo = '"+tagEdition+"'";
			break;//����γ�ҳ ��� ���2 ������ѯ���пγ�
		case 9:sql = "select * from moocfreecourse where coursePrice=0 order by mCoursePtime limit 10";
			break;//���������ѿγ�...ʵ�����ﻹû��
		case 10:sql = "select * from moocfreecourse where coursePrice !=0 order by mCoursePtime limit 10";
			break;//������߸��ѿγ�...ʵ�����ﻹû��
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
				
				//��ӵ�arraylist��
				courseList.add(courseData);
			}
			rs.close();
			return courseList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("���null");
		return null;
	}
	
	//---------����γ�ҳ��ѯ------------
	
	//��ѯ1���ǩ
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
				//��ӵ�arraylist��
				classOneList.add(classOneData);
			}
			rs.close();
			return classOneList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("���null0");//???
		return null;
	}
	
	//��ѯ2���ǩ
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
				//��ӵ�arraylist��
				classTwoList.add(classTwoData);
			}
			rs.close();
			return classTwoList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("���null0");//???
		return null;
	}
	
	//----------��ϸ�γ�ҳ��ѯ--------------
	
	//��ѯ�����γ�
	/*
	 * ����о����Ժϲ��������Ǹ���ѯ��ѿγ����
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
				courseData.setmUserid(rs.getString("mUserid"));//����ǿ�����id
				courseData.setCoursePrice(rs.getInt("coursePrice"));
				//��ӵ�arraylist��
				courseList.add(courseData);
			}
			rs.close();
			return courseList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("���null0");//???
		return null;
	}
	//��ѯ�����γ̶�Ӧ���½�
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
				//��ӵ�arraylist��
				courseList.add(courseData);
			}
			rs.close();
			return courseList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("���null1");//???
		return null;
	}	
	
	//��ѯ�����γ̶�Ӧ��С��
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
				//��ӵ�arraylist��
				courseList.add(courseData);
			}
			rs.close();
			return courseList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("���null2");//???
		return null;
	}
	
	//��ѯ�γ̶�Ӧ����������
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
				//��ӵ�arraylist��
				commentList.add(commentData);
			}
			rs.close();
			return commentList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("���null2");//???
		return null;
	}
	
	//��ѯʵʱ�����ĸ����ʴ�����
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
				//��ӵ�arraylist��
				messageList.add(messageData);
			}
			rs.close();
			return messageList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("���null2");//???
		return null;
	}
	
	
	//��ѯ�γ�ѧϰ��¼���������ƥ��
	/*
	 * ��ѯ��ǰ����γ�id�Ƿ���ڣ�Ҫ������Ϊ��ǰ������û�id�͵�ǰ����γ�id
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
				//��ӵ�arraylist��
				recordList.add(recordData);
			}
			rs.close();
			return recordList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("���null2");//???
		return null;
	}
	
	//��ѯ�γ̹����¼���������ƥ��
	/*
	 * ��ѯ��ǰҳ��γ�id�Ƿ�����ڱ��Ҫ������Ϊ��ǰ������û�id�͵�ǰ�Ŀγ�id
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
				//��ӵ�arraylist��
				payRecordList.add(payRecordData);
			}
			rs.close();
			return payRecordList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("���null2");//???
		return null;
	}
	
	//------�û���̨����------
	
	
	//ִ�в�ѯһ����ǩ���ϴ��γ��õĲ���
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
				//��ӵ�arraylist��
				tagOneList.add(tagOne);
			}
			rs.close();
			return tagOneList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("���null2");//???
		return null;
	}
	
	//ִ�в�ѯ2����ǩ���ϴ��γ��õĲ���
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
					//��ӵ�arraylist��
					tagTwoList.add(tagTwoData);
				}
				rs.close();
				return tagTwoList;

			}catch (Exception e) {
				e.printStackTrace();
				
			}finally {
			}
			System.out.println("���null2");//???
			return null;
		}	
	
	//ִ�пγ���Ϣ�Ĳ������
	/*
	 * @�γ�id,�γ����ƣ��γ̴��࣬�γ�ϸ�࣬ʱ���Զ����ɲ��ù�
	 * @��Ӳ������γ̼۸񣬿γ̻���Ҫ�󣬿γ̽��ܣ��γ�ר�����
	 */
	public static int insertMoocFreeCourse(String courseid,String courseName,String userid,String classOne,String classTwo,int coursePrice,String courseRequire,String courseIntroduce,String exclusiveService ){
		String sql = "insert into moocfreecourse(mCourseid,mCourseName,mUserid,mCourseClass,mCourseClassTwo,coursePrice,courseRequire,courseIntroduce,exclusiveService)values"
				+"('" + courseid + "','" + courseName+ "','" + userid + "','"+classOne+"','"+classTwo+"','"+coursePrice+"','"+courseRequire+"','"+courseIntroduce+"','"+exclusiveService+"')";
		//����Ҿ��ò������ո��'ssss'��'ssss '���������?
		int i = MoocBasicDao.executeUpdate(sql);
		MoocBasicDao.close();
		return i;
	}
	
	//ִ���½���Ϣ�Ĳ������
	/*
	 * @�½�id���½����ƣ��γ�id
	 */
	public static int insertMoocFreeChapter(String chapterid,String chapterName,String courseid){
		String sql = "insert into moocfreechapter(mChapterid,mChapterName,mCourseid)values"
				+"('" + chapterid + "','" + chapterName + "','"+courseid+"')";
		
		int i = MoocBasicDao.executeUpdate(sql);
		MoocBasicDao.close();
		return i;
	}
	
	//ִ��С����Ϣ�Ĳ������
	/*
	 * @С��id,С�����ƣ��½�id
	 */
	public static int insertMoocFreeSection(String mSectionid,String mChapterid,String mSectionName,String mVideoUrl){
		String sql = "insert into moocfreesection(mSectionid,mChapterid,mSectionName,mVideoUrl)values"
				+"('" + mSectionid + "','" + mChapterid + "','"+mSectionName+"','"+mVideoUrl+"')";
		
		int i = MoocBasicDao.executeUpdate(sql);
		MoocBasicDao.close();
		return i;
	}
	
	//ִ�й���γ̲����¼
	public static int insertMoocPayRecord(String userid,String courseid,int courseprice){
		String sql = "insert into moocpayrecord(mPayUserid,mPayCourseid,coursePrice)values"
				+"('" + userid + "','" + courseid +"',"+courseprice+ ")";
		int i = MoocBasicDao.executeUpdate(sql);
		MoocBasicDao.close();
		return i;
	}
	
	//ִ�пγ�ѧϰ����+1�������
	/*
	 * 
	 * ���γ̱��studyNumֵ+1
	 */
	public static int addMoocStudyNum(String courseid){
		String sql = "update moocfreecourse set studyNum = studyNum +1 where mCourseid='"+courseid+"'";
		int i = MoocBasicDao.executeUpdate(sql);
		MoocBasicDao.close();
		return i;
	}
	
	//ִ������ѧϰ�γ̼�¼����
	/*
	 * ��ѧϰ�γ̼�¼�������γ�id���û�id������ʱ��
	 */
	public static int insertMoocStudyRecord(String userid,String courseid){
		String sql = "insert into moocstudyrecord(mStudyCourseid,mStudyUserid)values"
				+"('" + courseid +"','"+userid+ "')";
		int i = MoocBasicDao.executeUpdate(sql);
		MoocBasicDao.close();
		return i;
	}
	
	//ִ�в���	�����ʴ𶩵���¼��	����
	public static int insertPayQuestionOrderRecord(String payquestionOrderid,String askerid,String askerName,String courseid,String courseName,String teacherid,String teacherName,boolean orderEffective){
		String sql = "insert into payquestionOrderRecord(payquestionOrderid,courseid,courseName,askerid,askerName,answerUserid,answerName,orderEffective)values"
				+"('" + payquestionOrderid +"','"+courseid+"','"+courseName+"','"+askerid+"','"+askerName+"','"+teacherid+"','"+teacherName+"',"+orderEffective+ ")";
		int i = MoocBasicDao.executeUpdate(sql);
		MoocBasicDao.close();
		return i;
	}
	
	//ִ���޸�	�����ʴ𶩵���ЧֵΪ��Ч	����
	public static int makePayQuestionOrderEffective(String payquestionOrderid){
		String sql = "update payquestionOrderRecord set orderEffective=true where payquestionOrderid='"+payquestionOrderid+"'";
		int i = MoocBasicDao.executeUpdate(sql);
		MoocBasicDao.close();
		return i;
	}
	
	//ִ�в��� ��������Ϣ ����
	public static int insertSenderidMessage(String senderid,String senderName,String receiverid,String receiverName,String Message,String courseid,String payQuestionOrderid){
		String sql = "insert into moocpayquestion(communicationMessage,messageSenderid,messageSenderName,messageBelongCourseid,messageReciverid,messageReciverName,payQuestionOrderid)values"
				+"('" + Message +"','"+senderid+"','"+senderName+"','"+courseid+"','"+receiverid+"','"+receiverName+"','"+payQuestionOrderid+"')";
		int i = MoocBasicDao.executeUpdate(sql);
		MoocBasicDao.close();
		return i;
	}
	
	
	//--------------����ע��---------------
	
	//�ж��˻��Ƿ����
	
		
	//����У��
	/*
	 * ��Ϊ�ǿ����ֻ�/�������ģ����Ե�ʱ�Ǳߴ�����ʱҪ��һ������������֪�������������ֻ���������
	 * select xxx from xxxx where xx= xx=;
	 * Ȼ�󽫽�����أ�û�鵽����һ����ʶ��ʾ�ֻ����������
	 */
	public ArrayList<MoocUserData> LoginCheck(String account,String password,boolean isPhone) throws Exception {
		String sql=null;
		if(isPhone==true) {
			sql = "select * from moocuser where mPhone='" + account + "' and mPasswd ='" + password +"'";
			
		}else {
			sql = "select * from moocuser where mEmail='" + account + "' and mPasswd ='" + password +"'";
			
		}
		//������λ��������޸�
		ResultSet rs = MoocBasicDao.executeQuery(sql);
		ArrayList<MoocUserData> userList = new ArrayList<MoocUserData>();
		MoocUserData userData = null;
		try {
			while(rs.next()){
				userData = new MoocUserData();
				userData.setmUsername(rs.getString("mUserName"));
				userData.setmUserid(rs.getString("mUserid"));
				userData.setmPhone(rs.getString("mPhone"));
				//��ӵ�arraylist��
				userList.add(userData);
			}
			rs.close();
			return userList;

		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
		}
		System.out.println("���null");//???
		return null;
	}
	
	//ע��
	public static int insertMoocUserTable(String userid,String userName,String Phone,String Passwd){
		String sql = "insert into moocuser(mUserid,mUserName,mPasswd,mPhone)values"
				+"('" + userid +"','"+userName +"','"+Passwd +"','"+Phone+ "')";
		int i = MoocBasicDao.executeUpdate(sql);
		MoocBasicDao.close();
		return i;
	}
}
