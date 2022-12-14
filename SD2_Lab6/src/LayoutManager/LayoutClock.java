package LayoutManager;

import java.awt.*;
import java.util.Calendar;

import javax.swing.*;


public class LayoutClock extends JFrame {

	// creating fields
	private JLabel clockDay;
	JLabel hours, minutes, seconds;

	// initializing constructor for the window
	public LayoutClock() {
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// creating the size of the window
		setSize(200, 200);
		setLayout(new GridLayout(2, 1));
		JPanel panel = new JPanel();

		// setting the font for the window
		Font displayFont = new Font("Serif", Font.ITALIC, 36);

		clockDay = new JLabel("Clock", SwingConstants.CENTER);
		clockDay.setFont(displayFont);

		// creating the label for the hours minutes and seconds
		// adding them to the panel
		// setting the font and visibility for the hours minutes and seconds
		hours = new JLabel("hour");
		panel.add(hours, JFrame.CENTER_ALIGNMENT);
		hours.setFont(displayFont);
		hours.setVisible(true);

		minutes = new JLabel("minutes");
		panel.add(minutes);
		minutes.setFont(displayFont);
		minutes.setVisible(true);

		seconds = new JLabel("seconds");
		panel.add(seconds);
		seconds.setFont(displayFont);
		seconds.setVisible(true);

		// adding the panel and the frame to the window
		add(panel);
		add(clockDay);

		// making the panel and the frame visible in the window
		panel.setVisible(true);
		clockDay.setVisible(true);
		setVisible(true);
	}

	public static void main(String[] args) {

		// creating new instance
		LayoutClock displayClock = new LayoutClock();
		Calendar clockTime;

		do {
			// to get the time from calendar which gets systems current time
			clockTime = Calendar.getInstance();

			// to put 0 infront of the values
			//IF statements to change the values of the hours, minutes and seconds
			
			if (clockTime.get(Calendar.HOUR) < 10) {
				displayClock.hours.setText(String.valueOf("0" + clockTime.get(Calendar.HOUR) + ":"));
			} else {
				displayClock.hours.setText(String.valueOf(clockTime.get(Calendar.HOUR) + ":"));
			}

			if (clockTime.get(Calendar.MINUTE) < 10) {
				displayClock.minutes.setText(String.valueOf("0" + clockTime.get(Calendar.MINUTE) + ":"));
			} else {
				displayClock.minutes.setText(String.valueOf(clockTime.get(Calendar.MINUTE) + ":"));
			}

			if (clockTime.get(Calendar.SECOND) < 10) {
				displayClock.seconds.setText(String.valueOf("0" + clockTime.get(Calendar.SECOND) + ""));
			} else {
				displayClock.seconds.setText(String.valueOf(clockTime.get(Calendar.SECOND) + ""));
			}
			
			//IF statement to change label to AM or PM dependent on the time of day
			if (clockTime.get(Calendar.AM_PM) == Calendar.PM) {
				displayClock.clockDay.setText("PM");
			} else {
				displayClock.clockDay.setText("AM");
			}
		} while (true);
	}
}