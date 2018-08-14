package database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
public class DBMain {
	
	public static void main(String[] args) {
		
		JDBC.accessDB();
		

		
		ArrayList<String> tests = new ArrayList<String>();
		
		tests.add("question_line_id");
		
		ArrayList<String> users = new ArrayList<String>();

		users.add("email");
		
		ArrayList<String> question = new ArrayList<String>();

		question.add("question_id");
		
		ArrayList<String> testQuestions = new ArrayList<String>();
		testQuestions.add("question");
		
		ArrayList<String> all = new ArrayList<String>();
		all.add("*");
		
		

	
	    
		Scanner sc = new Scanner(System.in);
	    
		String ID = null;
		String QL = null;
	    String topic = null;
	    String difficulty = null;
		String ans = "";
		String level = "";
		String email = "";
		
	    while(ans.equals("quit") == false) {
	    	
	    	System.out.println("Please enter your email address.");
	    	
	    	do {
	    	ans = sc.nextLine();
	    	
	    	
	    	if (JDBC.read(users, "user_details", "email", "=", "'" + ans + "'") == null) {
	    		
	    		System.out.println("Please enter a valid email address.");
	    	}
	    	else {
	    		
	    		email = ans;
	    	}
	    	}
	    	while (email.equals(""));

	    	do {
	    		System.out.println("Please choose a topic");
	    		ans = sc.nextLine();
	    		

	    		if (JDBC.read(all, "test", "topic", "=", "'" + ans + "'") == null) {

	    			System.out.println("Please enter a valid topic.");
	    		}
	    		else {
	    			
	    			topic = ans;
	    		}
	    	}
	    	while (topic.equals(""));

	    	System.out.println("Choose a difficulty");
	    	do {
	    		ans = sc.nextLine();
	    		difficulty = ans;

	    		if(ans.equals("hard") == false || ans.equals("medium") == false || ans.equals("easy") == false) {

	    			System.out.println("Please enter easy, medium or hard.");
	    		}
	    	}
	    	while(difficulty.equals(""));

	    	System.out.println("Choose the level: GCSE or A-level.");

	    	do {
	    		ans = sc.nextLine();

	    		if(ans.equals("GCSE")) {

	    			level = "GCSE";
	    	}
	    	
	    	else if (ans.equals("A-level")) {
	    		
	    		level = "A-level";
	    	}
	    	
	    	else {
	    		
	    		level = "Please enter a correct response";
	    	}
	    	} while (level.equals("Please enter a correct response"));
	    	
	    	ID = JDBC.read(tests, "test", "topic = " + "'" + topic +
	    			"' AND " + "difficulty = " + "'" + difficulty+"' AND "
	    			+ "level = " + "'" + level+"';", "", "").toString();
	    	
	    	int ID1 = Test.firstInt(ID);
	    	int score = 0;

	    	
	    	
	    	
	    	for (int i = 0; i < JDBC.getQuestions(ID1).length(); i++) {
	    	System.out.println(JDBC.getQuestions(ID1).getJSONObject(i).get("question"));
	    	ans = sc.nextLine();
	    	
	    	if (ans.equals(JDBC.getQuestions(ID1).getJSONObject(i).get("answer"))) {
	    		System.out.println("Correct");
	    		score++;
	    	}
	    	else {
	    		System.out.println("Incorrect");
	    	}
	    	
	    	}
	    	
	    	System.out.println("You achieved a score of " + score);
	    	break;
	    	

	    }
	    
	    sc.close();
	     
	     
		

		
        
	}
}
