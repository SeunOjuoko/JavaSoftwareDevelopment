package Windows;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class Blackwhite extends JFrame
{  
	Color [] rainbow =
		{
				Color.red, Color.orange, Color.yellow, Color.green, Color.blue, Color.magenta
		};
	public int count;
	
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
		count = 0;
		Scanner sc = new Scanner(System.in);
		while(true)
		//{  
		//		pause(1000);
		//		getContentPane().setBackground(rainbow [count++]);
		//		if (count > 5)
		//				count = 0;
		//}
		{
			sc.nextLine();
			getContentPane().setBackground(rainbow [count++]);
			count = count % rainbow.length;
			System.out.println(count);;
		}
	}
}

public class TestWhiteBlack {
	
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
