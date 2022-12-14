package Windows;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class White extends JFrame
{ 
	public White()
	{  
		getContentPane().setBackground(Color.white);  
	}
}

class TestWhite
{  
	public static void main(String [] args)
	{  
		White w;
		w = new White();
		w.setSize(200,220);
		w.setTitle("White");
		w.setVisible(true);
		w.addWindowListener
		(new WindowAdapter()
		{  
			public void windowClosing(WindowEvent e)
			{  System.exit(0); }
		});
	}
}

