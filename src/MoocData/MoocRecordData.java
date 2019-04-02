package MoocData;

public class MoocRecordData {
	
	//学习记录表数据
	private String studyRecordUserid;
	private String studyRecordCourseid;
	private String studyRecordBTime;
	
	
	//购买记录表数据
	private String payCourseid;
	private String payUserid;
	private String payPime;
	private int payPrice;
	public String getStudyRecordUserid() {
		return studyRecordUserid;
	}
	public void setStudyRecordUserid(String studyRecordUserid) {
		this.studyRecordUserid = studyRecordUserid;
	}
	public String getPayPime() {
		return payPime;
	}
	public void setPayPime(String payPime) {
		this.payPime = payPime;
	}
	public int getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(int payPrice) {
		this.payPrice = payPrice;
	}
	public String getStudyRecordBTime() {
		return studyRecordBTime;
	}
	public void setStudyRecordBTime(String studyRecordBTime) {
		this.studyRecordBTime = studyRecordBTime;
	}
	public String getStudyRecordCourseid() {
		return studyRecordCourseid;
	}
	public void setStudyRecordCourseid(String studyRecordCourseid) {
		this.studyRecordCourseid = studyRecordCourseid;
	}
	public String getPayCourseid() {
		return payCourseid;
	}
	public void setPayCourseid(String payCourseid) {
		this.payCourseid = payCourseid;
	}
	public String getPayUserid() {
		return payUserid;
	}
	public void setPayUserid(String payUserid) {
		this.payUserid = payUserid;
	}
	
	
}
