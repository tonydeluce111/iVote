package us.deluce.ivote;


import java.util.ArrayList;
import java.util.List;

/********************************************************************************
 * 
 * This class is the simulation driver for the iVote project
 * Currently it is simply testing the Question based classes
 * @author Tony DeLuce
 * @version 1.0
 *
 *******************************************************************************/

public class SimulationDriver {

	public static void main(String[] args) {
		
		Question myMultipleChoiceQuestion;
		Question mySingleChoiceQuestion;
		
		List<String> multipleChoiceInputs = new ArrayList<String>();
		List<String> singleChoiceInputs = new ArrayList<String>();
		List<String> multipleChoiceAnswer = new ArrayList<String>();
		List<String> singleChoiceAnswer = new ArrayList<String>();

		multipleChoiceInputs.add("A");	
		multipleChoiceInputs.add("B");	
		multipleChoiceInputs.add("C");	
		multipleChoiceInputs.add("D");	
		multipleChoiceAnswer.add(multipleChoiceInputs.get(1));
		
		
		singleChoiceInputs.add("Right");
		singleChoiceInputs.add("Wrong");
		singleChoiceAnswer.add(singleChoiceInputs.get(1));
		
		myMultipleChoiceQuestion = new MultipleChoiceQuestion("My multiQuestion", multipleChoiceInputs, multipleChoiceAnswer);
		mySingleChoiceQuestion = new SingleChoiceQuestion("My singleQuestion", singleChoiceInputs, singleChoiceAnswer);
	
				System.out.println("The student answered:" + myMultipleChoiceQuestion.checkAnswer("Checking answer"));
		System.out.println("The student answered:" + mySingleChoiceQuestion.checkAnswer("Checking answer"));
			

	}

}
