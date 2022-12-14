package LayoutManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckingProgress extends JFrame{
	
	public static void main(String[] args) {
 		CheckingProgress p = new CheckingProgress();
 		p.changeProgressBar();
 	}
	
	JLabel[] progressBar = new JLabel[10];
	JLabel overallProgress;
	
	int percentageCompletion = 0;
	
	public CheckingProgress() {
		
		//setting the sizes and the layout for the progress bar
		setBounds(300, 500, 1500, 150);
		setLayout(new GridLayout(1, 10));
		
		//setting the font
		Font displayFont = new Font("Serif", Font.BOLD, 16);
		
		//setting all the labels in the bar to red
		
		//FOR loop through the progressBar array
		for(int counter = 0; counter < progressBar.length; counter++) {
			
			//sets the label to have no value
			progressBar[counter] = new JLabel("");
			
			//set the label for each counter to have the displayFont
			progressBar[counter].setFont(displayFont);
			
			//set the background colour to red
			progressBar[counter].setBackground(Color.RED);
			
			//set opaqueness to true
			progressBar[counter].setOpaque(true);
			
			//add each label from the counter
			add(progressBar[counter]);
		}
		
		overallProgress = new JLabel(percentageCompletion + "%", JLabel.CENTER);
		setFont(displayFont);
		add(overallProgress);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//method to change the label boxes from red to green
	public void changeProgressBar() {
		
		//setting the font
		Font displayFont = new Font("Serif", Font.BOLD, 16);
		
		// scanner to allow user to enter
		Scanner scan = new Scanner(System.in);

		// FOR loop to loop through progressBar array
		for (int counter2 = 0; counter2 < progressBar.length; counter2++) {

			System.out.println("Type in anything you want to change colour");

			String changeColour = scan.nextLine();

			if (changeColour.equals("")) {

				// changes the colour from red to green for each index
				progressBar[counter2].setBackground(Color.GREEN);

				// increments up by 10
				percentageCompletion += 10;

				// changes text stored in overallProgress
				overallProgress.setText(percentageCompletion + "%");
			}
		}
	}
}
	