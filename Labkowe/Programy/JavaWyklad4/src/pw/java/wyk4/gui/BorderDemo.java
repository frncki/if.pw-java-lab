package pw.java.wyk4.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderDemo extends JFrame  {
	
	private static final long serialVersionUID = 945403068288031857L;

	public BorderDemo() throws HeadlessException {
		super();
		setSize(600,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,3));
		
		setLayout(new GridLayout(3,3,10,10));
		JPanel panele[] = new JPanel[9];
		for (int i = 0; i<9; i++){ 
			panele[i] = new JPanel ();
			panele[i].setBorder(BorderFactory.createLineBorder(new Color(i*1,i*20,i*10)));
			//panele[i].setBorder(BorderFactory.createBevelBorder(i%2));
			add(panele[i]);
		}
	}

	public static void main(String[] args) {
		JFrame f = new BorderDemo();
		f.setVisible(true);
	}
}
