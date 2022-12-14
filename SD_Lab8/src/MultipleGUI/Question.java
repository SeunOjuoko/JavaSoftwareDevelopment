package MultipleGUI;

public class Question {
	
	String question;
	String[] answers = new String[4];
	String correctanswer;
	
	public Question(String[] details) {
		question = details[0];
		for (int i =0;i<4;i++) {
			answers[i] = details[i+1];
		}
		correctanswer = details[5];
	}

	public String getCorrectanswer() {
		return correctanswer;
	}

	public String getQuestion() {
		return question;
	}
	
}
