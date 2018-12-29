package pw.java.wyk4.KomponentySwing;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class JCheckBoxDemo extends JFrame {

	  JTextArea t = new JTextArea();
	  JCheckBox
	    cb1 = new JCheckBox("Pole wyboru 1"),
	    cb2 = new JCheckBox("Pole wyboru 2"),
	    cb3 = new JCheckBox("Pole wyboru 3");	
	
	
	  ActionListener cbListener = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) 
		{
		      Object obj = e.getSource();
		      
		      if (obj == cb1) 
		        if (cb1.isSelected()) t.append("Pole 1 ustawione\n");
		          else t.append("Pole 1 wyczyszczone\n");
		        
		      if (obj == cb2)  
		        if (cb2.isSelected()) t.append("Pole 2 ustawione\n");
		          else t.append("Pole 2 wyczyszczone\n");
		      
		      if (obj == cb3)
		        if (cb3.isSelected()) t.append("Pole 3 ustawione\n");
		          else t.append("Pole 3 wyczyszczone\n");
		        
		}
	};
	  
	  public JCheckBoxDemo() {
		super("JCheckBoxDemo");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setLayout(new BorderLayout());
		cb1.addActionListener(cbListener);
	    cb2.addActionListener(cbListener);
	    cb3.addActionListener(cbListener);
	   
	    JPanel panelCheckBox = new JPanel();
	    panelCheckBox.setLayout(new FlowLayout(FlowLayout.LEFT));
	  	    
	    panelCheckBox.add(cb1);
	    panelCheckBox.add(cb2);
	    panelCheckBox.add(cb3);
	    
	    add(BorderLayout.NORTH, panelCheckBox);
	    
		//add(BorderLayout.CENTER, t);
		add(BorderLayout.CENTER,  new JScrollPane(t));

		
	}

	public static void main(String args[]) 
	{
		JFrame f = new JCheckBoxDemo();
		f.setBounds(100, 100, 400, 200);
		f.setVisible(true);
	}

}