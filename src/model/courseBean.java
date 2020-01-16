package model;

public class courseBean {

	private String courseId;
	private String courseName;
	//private String student_add;
	private String courseFaculty;

	public boolean valid;

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseFaculty() {
		return courseFaculty;
	}

	public void setCourseFaculty(String courseFaculty) {
		this.courseFaculty = courseFaculty;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	
}
