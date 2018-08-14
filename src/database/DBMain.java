package database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;

public class DBMain {

	public static void main(String[] args) {

		JDBC.accessDB();



		ArrayList<String> tests = new ArrayList<>();

		tests.add("test_id");

		ArrayList<String> questionLine = new ArrayList<>();

		questionLine.add("question_line_id");

		ArrayList<String> question = new ArrayList<>();

		question.add("question_id");

		ArrayList<String> testQuestions = new ArrayList<>();
		testQuestions.add("question");

		ArrayList<String> users = new ArrayList<>();
		users.add("email");



		Scanner sc = new Scanner(System.in);

		String ID = null;
		String topic = null;
		String difficulty = null;
		String ans = "";
		String level = "";
		String email = "";

		while(ans.equals("quit") == false) {

			System.out.println("Please enter you email address");

			do {
				ans = sc.nextLine();
				if (JDBC.read(users, "user_details", "email", "=", ans).getJSONObject(0).get("email").equals(ans)) {

					email = ans;
				}
				else {

					System.out.println("Please enter a valid email address.");
				} 
			} while(email.equals(""));

			System.out.println("Choose a topic");
			

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

			ID = JDBC.read(tests, "test", "topic = " + "'" + topic + "' AND " + "difficulty = " + "'" + difficulty+"' AND " + "level = " + "'" + level+"';", "", "").toString();
			int ID1 = Test.firstInt(ID);
			String ID2 = Integer.toString(ID1);

			int QL1 = Test.firstInt(ID);
			int score = 0;

			for (int i = 0; i < JDBC.getQuestions(QL1).length(); i++) {
				System.out.println(JDBC.getQuestions(QL1).getJSONObject(i).get("question"));
				ans = sc.nextLine();

				if (ans.equals(JDBC.getQuestions(QL1).getJSONObject(i).get("answer"))) {
					System.out.println("Correct");
					score++;
				}
				else {
					System.out.println("Incorrect");
				}

			}

			System.out.println("You received a score of " + score);
			break;


		}

		sc.close();






	}
}


