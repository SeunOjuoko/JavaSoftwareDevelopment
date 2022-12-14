package Buttons_Listeners;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

 class Calculator extends JFrame implements ActionListener {
	
	
	JButton clear, plus, minus, divide, multi;
	JTextField input;
	JLabel output;
	JPanel  outputPanel, inputPanel, btnPanel;
	double sum = 0;
	
	public Calculator() {
		
		setLayout(new GridLayout(3,1));
		 Font f = new Font("Sansserif", Font.BOLD, 18);
		 
		 outputPanel = new JPanel();
		 outputPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		 add(outputPanel);
		 
		 btnPanel = new JPanel();
		 btnPanel.setLayout(new GridLayout());
		 
		 inputPanel = new JPanel();
		 inputPanel.setLayout(new GridLayout());
		 
		
		
		 
		 output = new JLabel("0", JLabel.RIGHT);
		 output.setFont(f);
		 output.setOpaque(true);
		 outputPanel.add(output);
		
		 
		 input = new JTextField();
		 input.setFont(f);
		 input.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		 inputPanel.add(input);
		 
		 clear = setupButton("CLR");
		 plus = setupButton("+");
		 minus = setupButton("-");
		 divide = setupButton("/");
		 multi = setupButton("*");
		
		 add(outputPanel);
		 add(inputPanel);
		 add(btnPanel);
		 
	}
	
	private JButton setupButton(String s) {
		JButton b = new JButton(s);
		b.setFont(new Font("Sansserif", Font.BOLD, 18));
		b.setOpaque(true);
		b.addActionListener(this);
		btnPanel.add(b);
		
		return b;
	}
	
	 public void actionPerformed(ActionEvent e) {
		 try {
			 if (e.getSource() == clear) {
				 clear();
			 }
			 if (e.getSource() == plus) {
				 addNumbers();
			 }
			 if (e.getSource() == minus) {
				 subtractNumbers();
			 }
			 if (e.getSource() == divide) {
				 divideNumbers();
			 }
			 if (e.getSource() == multi) {
				 multiplyNumbers();
			 }
		 } catch (Exception err) {
			 System.out.println(err.getMessage());
			 input.requestFocus();
		 }
	 }
	 
	
	public void clear() {
		sum = 0;
		afterBtnPress();
	}
	
	 public void addNumbers() {
		 double currentVal = Double.parseDouble(input.getText());
		 sum += currentVal;
		 afterBtnPress();
	 }
	 
	 public void subtractNumbers() {
		 double currentVal = Double.parseDouble(input.getText());
		 if (sum == 0) {
			 sum = currentVal;
			 afterBtnPress();
		 } else {
			 sum -= currentVal;
			 afterBtnPress();
		 }
	 }
	 public void divideNumbers() {
		 double currentVal = Double.parseDouble(input.getText()); 
		 if (sum == 0) {
			 sum = currentVal;
			 afterBtnPress();
		 } else {
			 sum /= currentVal;
			 afterBtnPress();
		 }
	 }
	 
	 public void multiplyNumbers() {
		 double currentVal = Double.parseDouble(input.getText());
		 if (sum == 0) {
			 sum = currentVal;
			 afterBtnPress();
		 } else {
			 sum *= currentVal;
			 afterBtnPress();
		 }
	 }
	 public void afterBtnPress() {
		 output.setText(String.valueOf(sum));
		 input.setText("");
		 input.requestFocus();
	 }
	 


}

public class Calculating {
	
	 public static void main(String[] args) {
	 
		 Calculator calc = new Calculator();
		 calc.setSize(300, 200);
		 calc.setTitle("Calculator");
		 calc.setVisible(true);
		 calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}



