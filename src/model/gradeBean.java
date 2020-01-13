package model;

public class gradeBean {
	
	private String studentIc;
	private String subjectId;
	private String grade;
	private String subjectName;
	
	public boolean valid;

	public gradeBean() {
		// TODO Auto-generated constructor stub
	}
	public String getStudentIc() {
		return studentIc;
	}

	public void setStudentIc(String studentIc) {
		this.studentIc = studentIc;
	}
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}


}
