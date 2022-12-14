package Windows;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class Blackwhite extends JFrame
{  
	public Blackwhite()
	{  
		getContentPane().setBackground(Color.black);  }

	private void pause(long millisecs)
	{  
		long startTime = Calendar.getInstance().getTimeInMillis();
		while(Calendar.getInstance().getTimeInMillis()-startTime<millisecs);
	}

	public void flash()
	{  
		while(true)
		{  
			pause(500);
			getContentPane().setBackground(Color.white);
			pause(500);
			getContentPane().setBackground(Color.black);
		}
	}
}

class TestBlackwhite
{  
	public static void main(String [] args)
	{  
		Blackwhite b;
		b = new Blackwhite();
		b.setSize(200,220);
		b.setTitle("Black and white");
		b.setVisible(true);
		b.addWindowListener
		(new WindowAdapter()
		{  
			public void windowClosing(WindowEvent e)
			{  System.exit(0); }
		});
		b.flash();
	}
}
