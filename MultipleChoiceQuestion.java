package us.deluce.ivote;

import java.util.List;

public class MultipleChoiceQuestion extends Question {
	
	public MultipleChoiceQuestion(String text, List<String> selections, String answer) {
		
		super(text, selections, answer);
	}
	
	public String checkAnswer(String votersAnswer) { 
		
		return "Returning a correct Multiple Choice Answer for debug purposes";
	};

}
