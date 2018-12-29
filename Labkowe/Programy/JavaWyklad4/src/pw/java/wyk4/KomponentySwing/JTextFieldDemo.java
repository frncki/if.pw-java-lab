package pw.java.wyk4.KomponentySwing;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class JTextFieldDemo extends JFrame {

	  JTextField pole1 = new JTextField("wpisz cos i wcisnij Enter");
	  
	  JTextField pole2 = new JTextField(20);
	  
	  JTextField pole3 = new JTextField("zmien ten tekst");
	  
	  JTextField pole4 = new JTextField(20);
	
	  ActionListener pole1Listener = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) 
		{
		      pole2.setText( pole1.getText()) ;     
		}
   	};
   	
    KeyListener pole3Listener = new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {
			pole4.setText( pole3.getText()) ;
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			// wywolana w momencie wcisnieniecia klawisza - wpisany znak sie nie skopiuje
			//pole4.setText( pole3.getText()) ; 
		}
	};
	
	
	// Jesli nie wszystkie metody z KeyListener sa wykorzystane
	// bardziej przejrzystej jest korzystanie z KeyAdaptera
	// implementujacego wybrane metody:
	KeyListener pole3Adapter = new KeyAdapter() {
		public void keyReleased(KeyEvent e) {
			pole4.setText( pole3.getText()) ;
		}
	};
	
	  
	  public JTextFieldDemo() {
		super("JTextFieldDemo");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setLayout(new GridLayout(2,2, 10,10));
		pole1.addActionListener(pole1Listener);
		//pole3.addKeyListener(pole3Listener);
		pole3.addKeyListener(pole3Adapter);
	    add(pole1);
	    add(pole2);
	    add(pole3);
	    add(pole4);
		
	}

	public static void main(String args[]) 
	{
		JFrame f = new JTextFieldDemo();
		f.setBounds(100, 100, 300, 150);
		f.setVisible(true);
	}

}