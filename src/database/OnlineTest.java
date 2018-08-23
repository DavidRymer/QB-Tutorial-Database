package database;

import java.util.ArrayList;

import org.json.JSONObject;

public class OnlineTest {
	
	private String topic;
	private String difficulty;
	private String level;
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	public JSONObject getQuestion(int questionNumber) {
		ArrayList<String> fields = new ArrayList<String>();
		fields.add("question_line_id");
		
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("question_id");
		
		String questionLine = JDBC.read(fields, "test", "topic = " + "'" + topic + "' AND " + "difficulty = " + "'" + difficulty+"' AND " + "level = " + "'" + level+"';", "", "").toString();
		int questionLineId = FirstInt.firstInt(questionLine);
		
		return JDBC.getQuestions(questionLineId).getJSONObject(questionNumber);
		
	}
	


}
