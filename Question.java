package us.deluce.ivote;

import java.util.List;

/************************************************************
 * 
 * Abstract class for all type of question classes. 
 * 
 * @version 1.0
 * @author Tony DeLuce
 *
 *************************************************************/
public abstract class Question {
	
	protected String questionText;
	protected List<String> questionSelections;
	protected List<String> correctAnswers;
	
	public Question(String text, List<String> selections, List<String> answers) {
		this.questionText = text;
		this.questionSelections = selections;
		this.correctAnswers = answers;
	}
	
	public String getQuestion() {
		return this.questionText;
	}

	public List<String> getSelections() {
		return this.questionSelections;
	}
	
	public abstract String checkAnswer(String votersAnswer);
}
