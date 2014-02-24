// Assignment #: 12
//         Name: Maxx Rodriguez
//    StudentID: 1204885197
//      Lecture: MW 9 - 10:15
//  Description: Creates the whole gui and takes user input from the buttons and the slider.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ControlPanel extends JPanel
{
	private FanPanel fan1, fan2;
	private int width, height;
	JButton startRed, stopRed, reverseRed, startBlue, stopBlue, reverseBlue;
	JLabel redDisplay, blueDisplay;
	JPanel redPanel, bluePanel, rsub, bsub, rsub2, bsub2;
	JSlider redSlider, blueSlider;

	public ControlPanel(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.setLayout(new GridLayout(2,2));

		//create two fan panels, one with red, another with blue
		fan1 = new FanPanel(Color.red, width/2);
		fan2 = new FanPanel(Color.blue, width/2);

		//initialize eveything
		startRed = new JButton("Start Red");
		stopRed = new JButton("Stop Red");
		reverseRed = new JButton("Reverse Red");
		startBlue = new JButton("Start Blue");
		stopBlue = new JButton("Stop Blue");
		reverseBlue = new JButton("Reverse Blue");

		redDisplay = new JLabel("Red Fan Display");
		blueDisplay = new JLabel("Blue Fan Display");

		redPanel = new JPanel(new GridLayout(0,2));
		rsub = new JPanel(new GridLayout(3,1));
		rsub2 = new JPanel(new BorderLayout());

		bluePanel = new JPanel(new GridLayout(0,2));
		bsub = new JPanel(new GridLayout(3,1));
		bsub2 = new JPanel(new BorderLayout());

		redSlider = new JSlider(JSlider.VERTICAL);
		blueSlider = new JSlider(JSlider.VERTICAL);

		//set up the layout for the sliders
		redSlider.setMaximum(50);
		redSlider.setPaintLabels(true);
		redSlider.setPaintTicks(true);
		redSlider.setMajorTickSpacing(10);
		redSlider.setMinorTickSpacing(3);
		redSlider.setPaintTrack(true);
		redSlider.setValue(20);

		blueSlider.setMaximum(50);
		blueSlider.setPaintLabels(true);
		blueSlider.setPaintTicks(true);
		blueSlider.setMajorTickSpacing(10);
		blueSlider.setMinorTickSpacing(3);
		blueSlider.setPaintTrack(true);
		blueSlider.setValue(20);



		//add the buttons and sliders to the sub panels
		rsub.add(startRed);
		rsub.add(stopRed);
		rsub.add(reverseRed);
		bsub.add(startBlue);
		bsub.add(stopBlue);
		bsub.add(reverseBlue);

		rsub2.add(redDisplay, BorderLayout.NORTH);
		rsub2.add(redSlider, BorderLayout.CENTER);

		bsub2.add(blueDisplay, BorderLayout.NORTH);
		bsub2.add(blueSlider, BorderLayout.CENTER);

		//add sub panels to main panels
		redPanel.add(rsub);
		redPanel.add(rsub2);
		bluePanel.add(bsub);
		bluePanel.add(bsub2);

		//get input from the buttons and slider
		startRed.addActionListener(new ButtonListener());
		stopRed.addActionListener(new ButtonListener());
		reverseRed.addActionListener(new ButtonListener());
		startBlue.addActionListener(new ButtonListener());
		stopBlue.addActionListener(new ButtonListener());
		reverseBlue.addActionListener(new ButtonListener());

		redSlider.addChangeListener(new SliderListener());
		blueSlider.addChangeListener(new SliderListener());

		//set preferred size of this panel
		setPreferredSize(new Dimension(width,height));

		//add main panels to the main frame
		this.add(redPanel);
		this.add(bluePanel);
		this.add(fan1);
		this.add(fan2);
	}


	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource() == startRed)
			{
				fan1.resume();
			}
			else if(event.getSource() == stopRed)
			{
				fan1.suspend();
			}
			else if(event.getSource() == reverseRed)
			{
				fan1.reverse();
			}
			else if(event.getSource() == startBlue)
			{
				fan2.resume();
			}
			else if(event.getSource() == stopBlue)
			{
				fan2.suspend();
			}
			else if(event.getSource() == reverseBlue)
			{
				fan2.reverse();
			}
		}
	} //end of ButtonListener class

	private class SliderListener implements ChangeListener
	{
		public void stateChanged(ChangeEvent event)
		{

			if(event.getSource() == redSlider)
			{
				fan1.setDelay(redSlider.getValue());
			}
			else if(event.getSource() == blueSlider)
			{
				fan2.setDelay(blueSlider.getValue());
			}
		}
	} //end of SliderListener class

} //end of ControlPanel class
