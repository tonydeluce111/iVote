package us.deluce.ivote;

import java.util.ArrayList; 
import java.util.HashSet; 
import java.util.Hashtable; 
import java.util.List; 
import java.util.Map.Entry; 
import java.util.Set; 

public class IVoteService implements Statistical { 

 
   private Hashtable<String, List<String>> submissions; 
   private Question question;  
   private int numberCorrect; 

   public IVoteService(Question question) { 
         this.question = question; 
         this.submissions = new Hashtable<String, List<String>>(); 
         this.numberCorrect = 0; 
    } 

   // submits each student submission by studentID into Hashtable 
   public boolean submit(String studentId, List<String> sub) { 
	    final Set<String> temp = new HashSet<String>(sub); 
        final List<String> uniqueSubmission = new ArrayList<String>(); 
        uniqueSubmission.addAll(temp); 
	    final List<String> validSubmission = new ArrayList<String>(); 
        for (String submission : uniqueSubmission) { 
            if (this.question.inQuestionSelections(submission)) { 
                validSubmission.add(submission); 
             } 
         } 
        this.submissions.put(studentId, validSubmission); 
        return true; 
     } 
   
   // returns total number of submissions ( Statistical interface )
   public Integer totalSubmissions() { 
       return this.submissions.size(); 
   } 
 
 
   // Print out statistics for this iVote instance ( Statistical interface )
     public void printStats() { 
    	 this.numberCorrect = 0;  // initial number correct to zero
      	 for (Entry<String, List<String>> entry : submissions.entrySet()) { 
               if (question.checkAnswer(entry.getValue())) { 
                   this.numberCorrect++; 
               }   
         }   
         System.out.println("Question: " + this.question.getQuestionText());
         List<String> choices = this.question.getQuestionSelections(); 
         for (String choice : choices) { 
            Integer numChoice = 0; 
             for (String uuid : submissions.keySet()) { 
                 if (this.submissions.get(uuid).contains(choice)) { 
                     numChoice++; 
                } 
            } 
             System.out.println(choice + ": " + numChoice); 
         }
         
         System.out.println("Total Submissions: " + this.totalSubmissions().toString());
         System.out.println("Total Correct: " + this.numberCorrect);
     } 
 
 } 
