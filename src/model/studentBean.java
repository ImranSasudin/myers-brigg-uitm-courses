package model;

public class studentBean {
	//private int student;
	private String studentIc;
	private String studentName;
	//private String student_add;
	private String studentEmail;
	private String studentPhone;
	
	public boolean valid;
	//private String password;
	/*public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean valid;
	
	public int getstudent_id() {
		return student_id;
	}
	public void setstudent_id(int student_id) {
		this.student_id = student_id;
	}*/
	

	public String getstudentIc() {
		return studentIc;
	}
	public void setstudentIc(String studentIc) {
		this.studentIc = studentIc;
	}
	
	public String getstudentName() {
		return studentName;
	}
	public void setstudentName(String studentName) {
		this.studentName = studentName;
	}
	/*public String getstudent_add() {
	return student_add;
	}
	public void setstudent_add(String student_add) {
		this.student_add = student_add;
	}*/
	public String getstudentEmail() {
		return studentEmail;
	}
	public void setstudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getstudentPhone() {
		return studentPhone;
	}
	public void setstudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}
