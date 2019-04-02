package MoocData;

public class MoocPayQuestionOrderData {
	private String teacherid;
	private String askerid;
	private String courseid;
	private String askerName;
	private String courseName;
	private String payQuestionOrderid;
	private String askTime;
	private String answerTime;
	
	private boolean orderEffective;
	
	public String getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}
	public String getAskerid() {
		return askerid;
	}
	public void setAskerid(String askerid) {
		this.askerid = askerid;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getPayQuestionOrderid() {
		return payQuestionOrderid;
	}
	public void setPayQuestionOrderid(String payQuestionOrderid) {
		this.payQuestionOrderid = payQuestionOrderid;
	}
	public String getAskTime() {
		return askTime;
	}
	public void setAskTime(String askTime) {
		this.askTime = askTime;
	}
	public String getAnswerTime() {
		return answerTime;
	}
	public void setAnswerTime(String answerTime) {
		this.answerTime = answerTime;
	}
	public boolean isOrderEffective() {
		return orderEffective;
	}
	public void setOrderEffective(boolean orderEffective) {
		this.orderEffective = orderEffective;
	}
	public String getAskerName() {
		return askerName;
	}
	public void setAskerName(String askerName) {
		this.askerName = askerName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
}
