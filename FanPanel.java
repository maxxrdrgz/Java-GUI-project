// Assignment #: 12
//         Name: Maxx Rodriguez
//    StudentID: 1204885197
//      Lecture: MW 9 - 10:15
//  Description: sets up the fans and their delay speeds


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;


public class FanPanel extends JPanel
{
	private Color color;
	private int width;
	private Timer timer;
	private int delay;
	private int step;
	private int centerX;
	private int centerY;
	private int diameter;
	private int currentAngle;

	public FanPanel(Color color, int width)
	{
		this.color = color;
		this.width = width;
		this.setBackground(Color.white);

		delay = 20;
		centerX = width/2;
		centerY = width/2;
		diameter = (width)/2;
		currentAngle =0;
		step = 3;

		timer = new Timer(delay, new MoveListener());
		timer.start();
	}

	public void resume()
	{
		timer.start();
	}

	public void suspend()
	{
		timer.stop();
	}

	public void reverse()
	{
		delay *= -1;
		timer.start();
	}

	public void setDelay(int value)
	{
		if(delay < 0)
		{
			timer.setDelay(value);
		}
		else
		{
			timer.setDelay(value);
		}
	}

	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);

		page.drawOval(50, 50, 100, 100);

		page.setColor(color);

		page.fillArc(50, 50, 100, 100, 0 + currentAngle, 90);
		page.fillArc(50, 50, 100, 100, 180 + currentAngle, 90);
	}

	private class MoveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(delay < 0)
			{
				currentAngle -= 10;
			}
			else
			{
				currentAngle += 10;
			}
			repaint();
		}
	}
}