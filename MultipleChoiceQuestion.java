package us.deluce.ivote;

import java.util.List;

public class MultipleChoiceQuestion extends Question {
	
	public MultipleChoiceQuestion(String text, List<String> selections, List<String> answers) {
		
		super(text, selections, answers);
	}
	
	public String checkAnswer(String votersAnswer) { 
		
		return "Returning a correct Multiple Choice Answer for debug purposes";
	};

}
