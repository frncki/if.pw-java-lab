package pw.java.wyk4.KomponentySwing;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class JRadioButtonDemo extends JFrame {
	  
	
	JLabel etykieta = new JLabel();
	
	ButtonGroup grupa = new ButtonGroup();
	JRadioButton
	  rb1 = new JRadioButton("jeden", false),
	  rb2 = new JRadioButton("dwa", false),
	  rb3 = new JRadioButton("trzy", false);
	ActionListener listener = new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
		 etykieta.setText("Przycisk wyboru " +
	      ((JRadioButton) e.getSource()).getText());
	  }
	};
	  	  
	public JRadioButtonDemo() {
		super("JRadioButtonDemo");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());
	    // Grupowanie obektow JRadioButton do ButtonGroup - tylko jeden moze byc zaznaczony
		grupa.add(rb1); grupa.add(rb2); grupa.add(rb3);
		rb1.addActionListener(listener);
		rb2.addActionListener(listener);
		rb3.addActionListener(listener);
		
		add(rb1); add(rb2); add(rb3);
		
		add(etykieta);
	}

	public static void main(String args[]) 
	{
		final JFrame f = new JRadioButtonDemo();
		f.setBounds(100, 100, 300, 200);
		f.setVisible(true);

		
	}

}
	