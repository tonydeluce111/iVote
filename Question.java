package us.deluce.ivote;

import java.util.List;

public abstract class Question {
	
	protected String questionText;
	protected List<String> questionSelections;
	protected List<String> correctAnswers;
	
	public Question(String text, List<String> selections, List<String> answers) {
		this.questionText = text;
		this.questionSelections = selections;
		this.correctAnswers = answers;
	}
	
	public String getQuestionText() {
		return this.questionText;
	}

	public List<String> getQuestionSelections() {
		return this.questionSelections;
	}
	
	public List<String> getCorrectAnswers() {
		return this.getCorrectAnswers();
	}
	
	public boolean inQuestionSelections(String submission) {
	return this.questionSelections.contains(submission);
	}
	
	public abstract boolean checkAnswer(List<String> votersAnswers);
	
}
