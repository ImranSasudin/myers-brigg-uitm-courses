package model;

public class subjectBean {
	
	private String subjectId;
	private String subjectName;
	private String grade;
	
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public boolean valid;
	//private String password;
	
	
	/*public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean valid;
	
	public int getsubject_id() {
		return subject_id;
	}
	public void setsubject_id(int subject_id) {
		this.subject_id = subject_id;
	}*/
	

	public String getsubjectId() {
		return subjectId;
	}
	public void setsubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	
	public String getsubjectName() {
		return subjectName;
	}
	public void setsubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	/*public String getsubject_add() {
	return subject_add;
	}
	public void setsubject_add(String subject_add) {
		this.subject_add = subject_add;
	}
	public String getsubjectEmail() {
		return subjectEmail;
	}
	public void setsubjectEmail(String subjectEmail) {
		this.subjectEmail = subjectEmail;
	}
	public String getsubjectPhone() {
	}
	public void setsubjectPhone(String subjectPhone) {
		this.subjectPhone = subjectPhone;
	}*/
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}
