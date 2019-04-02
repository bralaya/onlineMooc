package MoocData;

public class MoocTagData {
	//1级类
	private String classOneTag;
	private String oneTagCreateTime;//时间要用什么？
	
	
	//2级类
	private String classTwoTag;
	private String classTwoTagBelong;
	private String twoTagCreateTime;
	
	public String getClassOneTag() {
		return classOneTag;
	}
	
	public void setClassOneTag(String classOneTag) {
		this.classOneTag = classOneTag;
	}
	public String getClassTwoTagBelong() {
		return classTwoTagBelong;
	}
	public void setClassTwoTagBelong(String classTwoTagBelong) {
		this.classTwoTagBelong = classTwoTagBelong;
	}
	public String getClassTwoTag() {
		return classTwoTag;
	}
	public void setClassTwoTag(String classTwoTag) {
		this.classTwoTag = classTwoTag;
	}
	public String getOneTagCreateTime() {
		return oneTagCreateTime;
	}
	public void setOneTagCreateTime(String oneTagCreateTime) {
		this.oneTagCreateTime = oneTagCreateTime;
	}
	public String getTwoTagCreateTime() {
		return twoTagCreateTime;
	}
	public void setTwoTagCreateTime(String twoTagCreateTime) {
		this.twoTagCreateTime = twoTagCreateTime;
	}


}
