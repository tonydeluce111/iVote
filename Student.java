package us.deluce.ivote;

import java.util.List;

public class Student {
	
	// following static variable to keep track of total number of student voters
	private static int numberStudents = 0;
	
	private String studentId;
	private List<String> studentSelections;
	
	
	public Student(String studentId) {
		this.studentId = studentId;
		numberStudents++;
	}
	
	public static void resetNumberStudents() {
		numberStudents = 0;
	}
	
	public static int getNumberStudents() {
		return numberStudents;
	}
	
	
	public String getStudentId() {
		return this.studentId;
	}
	
	public void recordStudentSelections(List<String> selections) {
		this.studentSelections = selections;		
	}
	
	public List<String> getStudentSelections() {
		return studentSelections;
	}
		

}
