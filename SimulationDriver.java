package us.deluce.ivote;

import java.util.ArrayList;
import java.util.List;

public class SimulationDriver {

	public static void main(String[] args) {
				
		Question myMultipleChoiceQuestion;
		Question mySingleChoiceQuestion;
		
		Student firstStudent = new Student("001"); 
		Student secondStudent = new Student("002");
		Student thirdStudent = new Student("003");
			
		List<String> multipleChoiceInputs = new ArrayList<String>();
		List<String> singleChoiceInputs = new ArrayList<String>();

		multipleChoiceInputs.add("A");	
		multipleChoiceInputs.add("B");	
		multipleChoiceInputs.add("C");	
		multipleChoiceInputs.add("D");	
		String multipleChoiceAnswer = "B";
		
		myMultipleChoiceQuestion = new MultipleChoiceQuestion("My multiQuestion", multipleChoiceInputs, multipleChoiceAnswer);
		
		IVoteService myVoteService1 = new IVoteService(myMultipleChoiceQuestion);
		
		firstStudent.recordStudentSelection("B");
		myVoteService1.studentSubmission(firstStudent.getStudentId(), firstStudent.getStudentSelection());
		secondStudent.recordStudentSelection("C");
		myVoteService1.studentSubmission(secondStudent.getStudentId(), secondStudent.getStudentSelection());
		thirdStudent.recordStudentSelection("B");
		myVoteService1.studentSubmission(thirdStudent.getStudentId(), thirdStudent.getStudentSelection());
			
		System.out.println("The number correct were:" + myVoteService1.getNumberCorrect());
		
				
		singleChoiceInputs.add("Right");
		singleChoiceInputs.add("Wrong");
		String singleChoiceAnswer = "Right";
		
		mySingleChoiceQuestion = new SingleChoiceQuestion("My singleQuestion", singleChoiceInputs, singleChoiceAnswer);
		
		IVoteService myVoteService2 = new IVoteService(mySingleChoiceQuestion);
		
		firstStudent.recordStudentSelection("Right");
		myVoteService2.studentSubmission(firstStudent.getStudentId(), firstStudent.getStudentSelection());
		secondStudent.recordStudentSelection("Wrong");
		myVoteService2.studentSubmission(secondStudent.getStudentId(), secondStudent.getStudentSelection());
		thirdStudent.recordStudentSelection("Wrong");
		myVoteService2.studentSubmission(thirdStudent.getStudentId(), thirdStudent.getStudentSelection());
				
		System.out.println("The number correct were:" + myVoteService2.getNumberCorrect());
			

	}

}
