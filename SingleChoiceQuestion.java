package us.deluce.ivote;

import java.util.List;

public class SingleChoiceQuestion extends Question {
	
public SingleChoiceQuestion(String text, List<String> selections, String answer) {
		
		super(text, selections, answer);
	}
	
	public String checkAnswer(String votersAnswer) { 
				
		return "Returning a correct Single Choice Answer for debug purposes";
	};

}
