package database;



public class DBMain {

	public static void main(String[] args) {
		
		JDBC.accessDB();

		OnlineTest test = new OnlineTest();
		test.setDifficulty("medium");
		test.setLevel("gcse");
		test.setTopic("trigonometry");
		
		System.out.println(test.getQuestion(1).toString());
		
	


	}
}


