package us.deluce.ivote;

import java.util.HashMap;
import java.util.Map;

public class IVoteService {
	
	private Question question;
	private Map<String, String> studentSubmissions;
	private int numberCorrect;
	
	public IVoteService(Question question) {
		this.question = question;
		this.studentSubmissions = new HashMap<String, String>();
		this.numberCorrect = 0;
	}
	
	public void studentSubmission(String studentId, String submission) {	
		studentSubmissions.put(studentId, submission);
		if (question.correctAnswer.equals(submission)) numberCorrect++;
	}
	
	public int getNumberCorrect() {
		return numberCorrect;
	}
	
}
