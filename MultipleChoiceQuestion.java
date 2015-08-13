package us.deluce.ivote;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceQuestion extends Question {
	
	public MultipleChoiceQuestion(String text, List<String> selections, List<String> answer) {
		
		super(text, selections, answer);
	}
	
	// check the answer of the submission ( Abstract Question class )
	public boolean checkAnswer(List<String> votersAnswers) { 
			boolean correctAnswer = true;
			final List<String> temp = new ArrayList<String>(votersAnswers);
			for (int i = 0; i < this.correctAnswers.size(); i++) {
				correctAnswer = temp.remove(this.correctAnswers.get(i));
				if (!correctAnswer) { break; }
			}
			if (correctAnswer) {
				return true;
			} else {
				return false;
			}
	}
	
}




