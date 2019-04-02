package MoocData;

public class MoocCourseData {
	
	//课程表的
	private String mCourseid;
	private String mCourseName;
	private String mCourseClass;
	private String mCOurseClassTwo;
	private String mCoursePtime;
	private String mUserid;
	
	//课程表扩展新字段
	private int coursePrice;
	private String courseIntroduce;
	private String courseRequire;
	private String exclusiveService;
	private int studyNum;
	
	
	//下面的有重复到上面的，没关系，反正都是一样的，比如用户id，
	
	//章节表的
	private String mChapterid;
	private String mChapterName;
	
	//小节表的
	private String mSectionid;
	private String mSectionName;
	private String mVideoUrl;
	
	
	public String getmCourseid() {
		return mCourseid;
	}
	public void setmCourseid(String mCourseid) {
		this.mCourseid = mCourseid;
	}
	public String getmCourseName() {
		return mCourseName;
	}
	public void setmCourseName(String mCourseName) {
		this.mCourseName = mCourseName;
	}
	public String getmCourseClass() {
		return mCourseClass;
	}
	public void setmCourseClass(String mCourseClass) {
		this.mCourseClass = mCourseClass;
	}
	public String getmCOurseClassTwo() {
		return mCOurseClassTwo;
	}
	public void setmCOurseClassTwo(String mCOurseClassTwo) {
		this.mCOurseClassTwo = mCOurseClassTwo;
	}
	public String getmCoursePtime() {
		return mCoursePtime;
	}
	public void setmCoursePtime(String mCoursePtime) {
		this.mCoursePtime = mCoursePtime;
	}
	public String getmUserid() {
		return mUserid;
	}
	public void setmUserid(String mUserid) {
		this.mUserid = mUserid;
	}
	public String getmChapterid() {
		return mChapterid;
	}
	public void setmChapterid(String mChapterid) {
		this.mChapterid = mChapterid;
	}
	public String getmChapterName() {
		return mChapterName;
	}
	public void setmChapterName(String mChapterName) {
		this.mChapterName = mChapterName;
	}
	public String getmSectionid() {
		return mSectionid;
	}
	public void setmSectionid(String mSectionid) {
		this.mSectionid = mSectionid;
	}
	public String getmSectionName() {
		return mSectionName;
	}
	public void setmSectionName(String mSectionName) {
		this.mSectionName = mSectionName;
	}
	public String getmVideoUrl() {
		return mVideoUrl;
	}
	public void setmVideoUrl(String mVideoUrl) {
		this.mVideoUrl = mVideoUrl;
	}
	public int getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(int coursePrice) {
		this.coursePrice = coursePrice;
	}
	public String getCourseIntroduce() {
		return courseIntroduce;
	}
	public void setCourseIntroduce(String courseIntroduce) {
		this.courseIntroduce = courseIntroduce;
	}
	public String getCourseRequire() {
		return courseRequire;
	}
	public void setCourseRequire(String courseRequire) {
		this.courseRequire = courseRequire;
	}
	public String getExclusiveService() {
		return exclusiveService;
	}
	public void setExclusiveService(String exclusiveService) {
		this.exclusiveService = exclusiveService;
	}
	public int getStudyNum() {
		return studyNum;
	}
	public void setStudyNum(int studyNum) {
		this.studyNum = studyNum;
	}
	
}
