package MultipleGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.util.Calendar;

public class Quiz extends JFrame implements ActionListener {
	
	private Question question;
	private Question[] questions = new Question[4];
	private int questionIndex = -1;
	private int score = 0;
	
	private Font f = new Font("Arial", Font.PLAIN, 30);
	private JButton finishButton = new JButton("Finish");
	private JLabel questionLabel = new JLabel("Question", JLabel.CENTER);
	private JButton[] answerArray = new JButton[4];
	private JLabel messageLabel = new JLabel("", JLabel.CENTER);
	private JButton nextButton = new JButton("Next");
	
	public Quiz() {
		
		initialiseQuestions();
		
		setLayout(new GridLayout(7,1));
		
		add(messageLabel);
		
		add(questionLabel);
		
		JButton b;
		for (int i=0; i<4; i++) {
			b = new JButton("possible answer"+(i+1));
			answerArray[i] = b;
			add(b);
		}
		
		add(nextButton);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if (source == answerArray[0]) {
			submit(0);
		} else if (source == answerArray[1]) {
			submit(1);
		} else if (source == answerArray[2]) {
			submit(2);
		} else if (source == answerArray[3]) {
			submit(3);
		} else if (source == nextButton) {
			if (questionIndex < 3) {
				nextQuestion();
			} else if (questionIndex == 3) {
				end();
			} else {
				this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			}
		}
		
	}
	
	public void begin() {
		nextQuestion();
	}
	
	public void nextQuestion() {
		questionIndex++;
		question = questions[questionIndex];
		// updates GUI question text
		questionLabel.setText("Question "+(questionIndex)+": "+question.getQuestionText());
		// updates each answer button
		JButton b;
		for (int index=0; index<4; index++) {
			b = answerArray[index];
			b.setText(question.getAnswerText(index));
			b.setBackground(Color.WHITE);
		}
		
		// updates current question
		enableButtons(answerArray);
		disableButton(nextButton);
	}
	
	public void submit(int answerIndex) {
		
		int correctAnswerIndex = question.getCorrectAnswer();
		
		for (JButton button : answerArray) {
			button.setBackground(Color.RED);
		}
		answerArray[correctAnswerIndex].setBackground(Color.GREEN);
		
		if (answerIndex == correctAnswerIndex) {
			score++;
			message("Correct - "+score+"/"+(questionIndex+1));
		} else {
			message("Incorrect - "+score+"/"+(questionIndex+1));
		}
		
		waitUntilNextQuestion();
	}
	
	private void waitUntilNextQuestion() {
		disableButtons(answerArray);
		enableButton(nextButton);
	}
	
	public void initialiseQuestions() {
		try {
			FileReader fileReader = new FileReader("/home/ce1/zo12/workspace/Lab8Quiz/src/MultipleGUI/Quiz.txt");
			BufferedReader bf = new BufferedReader(fileReader);
			String next;
			String questionText;
			int readCorrectAnswer;
			for (int q=0; q<4; q++) {
				String[] readAnswers = new String[4];
				questionText = bf.readLine();
				for (int a=0; a<4; a++) {
					readAnswers[a] = bf.readLine();
				}
				readCorrectAnswer = Integer.parseInt(bf.readLine());
				questions[q] = new Question(questionText, readAnswers, readCorrectAnswer);
			}
			bf.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void message(String message) {
		messageLabel.setText(message);
	}
	
	private void end() {
		questionIndex++;
		for (JButton button : answerArray) {
			remove(button);
		}
		nextButton.setText("Close");
		remove(questionLabel);
		message("Quiz complete - Score: "+score+"/4");
	}
	
	private void disableButtons(JButton[] buttons) {
		for (JButton button : buttons) {
			button.removeActionListener(this);
		}
	}
	
	private void disableButton(JButton button) {
		button.removeActionListener(this);
	}
	
	private void enableButtons(JButton[] buttons) {
		for (JButton button : buttons) {
			button.addActionListener(this);
		}
	}
	
	private void enableButton(JButton button) {
		button.addActionListener(this);
	}
	
	private void pause(long millis) {
		long start = Calendar.getInstance().getTimeInMillis();
		while (Calendar.getInstance().getTimeInMillis() - start < millis);
	}
	
	public static void main(String[] args) {
		Quiz quiz = new Quiz();
		quiz.setSize(400,500);
		quiz.setTitle("Multiple Choice Quiz");
		quiz.setVisible(true);
		quiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quiz.begin();
	}
	
}