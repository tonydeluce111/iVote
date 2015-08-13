package us.deluce.ivote;

import java.util.List;

public class SingleChoiceQuestion extends Question {
	
	public SingleChoiceQuestion(String text, List<String> selections, List<String> answer) {
		
		super(text, selections, answer);
	}
			
	// Check the answer of the submission ( Abstract Question class )
	public boolean checkAnswer(List<String> submittedAnswers) {
		if (this.correctAnswers.get(0).compareTo(submittedAnswers.get(0)) == 0)  {
			return true;
		} 
		else {
			return false;
		}		
	} 

}
