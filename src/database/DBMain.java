package database;

import java.util.ArrayList;
import java.util.Scanner;

public class DBMain {
	
	public static void main(String[] args) {
		
		JDBC.accessDB();
		
		ArrayList<String> tutors = new ArrayList<>();
		tutors.add("tutor_id");
		tutors.add("first_name");
		tutors.add("last_name");
		tutors.add("speciality");
		
		
		ArrayList<String> tests = new ArrayList<>();
		
		tests.add("test_id");
		
		ArrayList<String> questionLine = new ArrayList<>();

		questionLine.add("question_line_id");
		
		ArrayList<String> question = new ArrayList<>();

		question.add("question_id");
		
		ArrayList<String> testQuestions = new ArrayList<>();
		testQuestions.add("question");
		
		
		




		JDBC.read(tests, "test", "topic = " + "'" + "addition" + "' AND " + "difficulty = " + "'" + "hard" +"' AND " + "level = " + "'" + "GCSE"+"';", "", "");
	
		
		Scanner sc = new Scanner(System.in);
	    
		String ID = null;
	    String topic = null;
	    String difficulty = null;
		String ans = "";
		String level = "";
		
	    while(ans.equals("quit") == false) {
	    	
	    	System.out.println("Choose a topic: Addition or Multiplication");
	    	ans = sc.nextLine();
	    	
	    	if (ans.equals("Addition")) {
	    		
	    		topic = "addition";
	    	}
	    	
	    	System.out.println("Choose a difficulty");
	    	ans = sc.nextLine();
	    	
	    	if(ans.equals("hard")) {
	    		
	    		difficulty = "hard";
	    	}
	    	
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
	    	
	    	ID = JDBC.read(tests, "test", "topic = " + "'" + topic + "' AND " + "difficulty = " + "'" + difficulty+"' AND " + "level = " + "'" + level+"';", "", "");
	    	int ID1 = Test.firstInt(ID);
	    	String ID2 = Integer.toString(ID1);

	    	System.out.println(ID2);
	    	
	    	String QL = JDBC.read(questionLine, "test", "test_id", "=", ID2);
	    	int QL1 = Test.firstInt(ID);
	    	String QL2 = Integer.toString(ID1);
	    	

	    	
	    	
	    }
	     
	     
		

		
        
	}
}


