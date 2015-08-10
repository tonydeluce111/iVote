package us.deluce.ivote;

import java.util.List;

/************************************************************
 * 
 * Implements abstract Question class for MultipleChoiceQuestions 
 * @version 1.0
 * @author Tony DeLuce
 *
 *************************************************************/


public class SingleChoiceQuestion extends Question {
	
public SingleChoiceQuestion(String text, List<String> selections, List<String> answers) {
		
		super(text, selections, answers);
	}
	
	public String checkAnswer(String votersAnswer) { 
				
		return "Returning a correct Single Choice Answer for debug purposes";
	};

}
