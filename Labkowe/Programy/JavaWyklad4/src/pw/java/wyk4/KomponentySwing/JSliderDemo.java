package pw.java.wyk4.KomponentySwing;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;

public class JSliderDemo extends JFrame {

	  JSlider redSlider,greenSlider,blueSlider;
	  JPanel panel = new JPanel();
	  
	  
	  ChangeListener slidersListener = new ChangeListener() {
		
		@Override
		public void stateChanged(ChangeEvent e) {
			int red = redSlider.getValue();
			int green = greenSlider.getValue();
			int blue = blueSlider.getValue();
			panel.setBackground(new Color(red, green, blue));
		}
	};
		  
	  public JSliderDemo() {
		super("JCheckBoxDemo");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setLayout(new FlowLayout());

	    redSlider = new JSlider();
	    redSlider.setMinimum(0);
	    redSlider.setMaximum(255);
	    redSlider.setValue(127);
	  
	    greenSlider = new JSlider(0,255,127);
	    blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 127);
	    
	    redSlider.addChangeListener(slidersListener);
	    greenSlider.addChangeListener(slidersListener);
	    blueSlider.addChangeListener(slidersListener);
	    
	    add(new JLabel("Red:")); 
	    add(redSlider); 
	    add(new JLabel("Green:")); 
	    add(greenSlider); 
	    add(new JLabel("Blue:")); 
	    add(blueSlider); 
	    
	    panel.setPreferredSize(new Dimension( 150, 75 ));
	    add(panel);
	    
	}

	public static void main(String args[]) 
	{
		JFrame f = new JSliderDemo();
		f.setBounds(100, 100, 250, 250);
		f.setVisible(true);
	}

}