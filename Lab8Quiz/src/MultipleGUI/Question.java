package MultipleGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;

public class Question {
	
	private String questionText;
	private String[] answers = new String[4];
	private int correctAnswer;
	
	public Question(String question, String[] answersArray, int correctAnswerIndex) {
		questionText = question;
		answers = answersArray;
		correctAnswer = correctAnswerIndex;
	}
	
	public String getQuestionText() {
		return questionText;
	}
	
	public String getAnswerText(int index) {
		return answers[index];
	}
	
	public int getCorrectAnswer() {
		return correctAnswer;
	}
	
}