package Buttons_Listeners;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FontSizes extends JFrame implements ActionListener {
	
	int fSize = 18;
	JLabel letter, size;
	JButton in, de;
	
	public FontSizes() {
		
		JPanel t = new JPanel(new GridLayout(1,2));
		JPanel b = new JPanel();
		
		letter = new JLabel("X", JLabel.RIGHT);
		letter.setFont(new Font("Sansserif", Font.PLAIN, fSize));
		t.add(letter);
		
		size = new JLabel(Integer.toString(fSize), JLabel.LEFT);
		size.setFont(new Font("Sansserif", Font.PLAIN, 18));
		t.add(size);
		
		in = new JButton("Increase");
		de = new JButton("Decrease");
		b.add(in); b.add(de);
		in.addActionListener(this);
		de.addActionListener(this);
		
		add(t, BorderLayout.CENTER);
		add(b, BorderLayout.SOUTH);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == in) {
			fSize++;
		} else if(e.getSource() == de) {
			fSize--;
		}
		size.setText(Integer.toString(fSize));
		letter.setFont(new Font("Sansserif", Font.PLAIN, fSize));
	}
	
}

public class FontSize {
	
	public static void main(String[] args) {
		FontSizes f = new FontSizes();
		f.setSize(250,200);
		f.setTitle("Font Size");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
}
