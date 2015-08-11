package us.deluce.ivote;

import java.util.List;

public abstract class Question {
	
	protected String questionText;
	protected List<String> questionSelections;
	protected String correctAnswer;
	
	public Question(String text, List<String> selections, String answer) {
		this.questionText = text;
		this.questionSelections = selections;
		this.correctAnswer = answer;
	}
	
	public String getQuestion() {
		return this.questionText;
	}

	public List<String> getSelections() {
		return this.questionSelections;
	}
	
	public abstract String checkAnswer(String votersAnswer);
}
