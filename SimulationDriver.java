package us.deluce.ivote;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* This SimulationDriver is simply to test the iVote package classes. The intention is to replace this SimulationDriver with
 * a Web Client to capture input and update iVote. Because of this intention, no effort has been made to make this SimulationDriver
 *  user friendly.
 */

public class SimulationDriver {

	public static void main(String[] args) {
		
		//**************************************************************************************************************************
		//****************************  First round question is a MultipleChoiceQuestion *******************************************
		//*************************************************************************************************************************
				
		Question myMultipleChoiceQuestion; // create reference to an MultipleChoiceQuestion object
		
		// create multipleChoiceInputs and set to possible candidate answers - in this case A, B, C, D
		List<String> multipleChoiceInputs = new ArrayList<String>();	
		multipleChoiceInputs.add("A");	
		multipleChoiceInputs.add("B");	
		multipleChoiceInputs.add("C");	
		multipleChoiceInputs.add("D");	
		
		// create multipleChoiceAnswer object and set to correct answers - in following case 'B'
		List<String> multipleChoiceAnswer = new ArrayList<String>();
		multipleChoiceAnswer.add(multipleChoiceInputs.get(1));  //************** Correct answer is B *********************************
		
		// create MultipleChoiceObject and initialize the Question with name, inputs, and correct answers
		myMultipleChoiceQuestion = new MultipleChoiceQuestion("My multiQuestion", multipleChoiceInputs, multipleChoiceAnswer);
		
		// configuring the myVoteService with the myMultipleChoice Question created above
		IVoteService myVoteService1 = new IVoteService(myMultipleChoiceQuestion);
		
		// generating a random number between 5 and 50 for a random number of students
		Random r = new Random();
		int low = 5;
		int high = 100;
		int R = r.nextInt(high-low) + low;
		
		// create the R (random determined above) number of students and set their studentID to string equivalence of the corresponding integer
		Student[] myStudents = new Student[R];
		for(int i=0; i < R; i++) {
			String studentId = String.valueOf(i);
			myStudents[i] = new Student(studentId);
		}
		
		System.out.println("\nNumber of Students: " + Student.getNumberStudents());  // print out number of students to compare with total submissions
		
		// Randomly select answers for each student based on available multipleChoiceInputs
		ArrayList<String> studentAnswers = new ArrayList<String>();
		for(int i=0; i < Student.getNumberStudents(); i++) {
			Random m = new Random();
			int lowM = 0;
			int highM = multipleChoiceInputs.size();
			int M = m.nextInt(highM-lowM) + lowM;
			studentAnswers.add(multipleChoiceInputs.get(M));
			myStudents[i].recordStudentSelections(studentAnswers);
			myVoteService1.submit(myStudents[i].getStudentId(), myStudents[i].getStudentSelections());
			studentAnswers.remove(multipleChoiceInputs.get(M));
		}
		
		// following students decide to resubmit answers - if this works total submissions should equal number of students
		studentAnswers.add(multipleChoiceInputs.get(0));
		myStudents[0].recordStudentSelections(studentAnswers);
		myVoteService1.submit(myStudents[0].getStudentId(), myStudents[0].getStudentSelections());
		myStudents[1].recordStudentSelections(studentAnswers);
		myVoteService1.submit(myStudents[1].getStudentId(), myStudents[1].getStudentSelections());
		
		// Print out the statss from multiChoiceQuestion round
		myVoteService1.printStats();	
		
	
		//*********************************************************************************************************************
		//************** Now start new round with SingleChoiceQuestion ********************************************************
		//*********************************************************************************************************************
		Question mySingleChoiceQuestion; // create reference to a SingleChoiceQuestion object
		
		// create singleChoiceInputs and set to possible candidate answers - in this case RIGHT and WRONG
		List<String> singleChoiceInputs = new ArrayList<String>();
		singleChoiceInputs.add("RIGHT");
		singleChoiceInputs.add("WRONG");
		
		// create singleChoiceAnswer and set to correct answer - in this case it is WRONG
		List<String> singleChoiceAnswer = new ArrayList<String>();
		singleChoiceAnswer.add(singleChoiceInputs.get(1));  //*********** Correct answer is WRONG *********************
		
	    // create SingleChoiceObject and initialize the Question with name, inputs and correct answers.
		mySingleChoiceQuestion = new SingleChoiceQuestion("My singleQuestion", singleChoiceInputs, singleChoiceAnswer);
				
		// configuring the myVoteService with the mySingleChoice Question created above
		IVoteService myVoteService2 = new IVoteService(mySingleChoiceQuestion);
				
		System.out.println("\nNumber of Students: " + Student.getNumberStudents());  //print out number of students to compare with total submissions
				
		// Randomly select answers for each student based on available singleChoiceInputs
		for(int i=0; i < Student.getNumberStudents(); i++) {
				Random m = new Random();
				int lowM = 0;
				int highM = singleChoiceInputs.size();
				int M = m.nextInt(highM-lowM) + lowM;
				studentAnswers.add(singleChoiceInputs.get(M));
				myStudents[i].recordStudentSelections(studentAnswers);
				myVoteService2.submit(myStudents[i].getStudentId(), myStudents[i].getStudentSelections());
				studentAnswers.remove(singleChoiceInputs.get(M));				
		}
		
		// Print out the stats from singleChoiceQuestion round
		myVoteService2.printStats();	
	
	}


}
	
	
