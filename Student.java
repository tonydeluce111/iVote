package us.deluce.ivote;

public class Student {
	
	/* following static variable to keep track of total number of voters */
	private static int numberStudents = 0;
	
	private String studentId;
	private String studentSelection;
	
	
	public Student(String studentId) {
		this.studentId = studentId;
		numberStudents++;
	}
	
	public int getNumberStudents() {
		return numberStudents;
	}
	
	public String getStudentId() {
		return this.studentId;
	}
	
	public void recordStudentSelection(String selection) {
		this.studentSelection = selection;		
	}
		
	public String getStudentSelection() {
		return studentSelection;	
	}

}
