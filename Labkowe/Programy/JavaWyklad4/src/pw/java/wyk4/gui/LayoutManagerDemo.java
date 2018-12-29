package pw.java.wyk4.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class LayoutManagerDemo extends JFrame {
	
	private static final long serialVersionUID = 185723979423401295L;

	public LayoutManagerDemo() throws HeadlessException {
		super();
		setSize(600,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();

	   add(BorderLayout.WEST, p1);
	   add(BorderLayout.NORTH, p2);
	   add(BorderLayout.CENTER, p3);
	   
/*	   p1.setBackground(Color.GREEN);
	   p2.setBackground(new Color(0,0,200));
	   p3.setBackground(new Color(250,255, 255));*/
	   
	   p1.setLayout(new GridLayout(4,1));
	   p1.add(new JLabel("Panel 1"));
	   p1.add(new JButton("Przycisk 1"));
	   p1.add(new JButton("Przycisk 2"));
	   p1.add(new JButton("Przycisk 3"));
	   
	   p2.setLayout(new FlowLayout());
	   p2.add(new JLabel("Panel 2"));
	   p2.add(new JCheckBox("Kontrolka 1"));
	   p2.add(new JCheckBox("Kontrolka 1"));
	   p2.add(new JCheckBox("Kontrolka 1"));
	   
	   p3.setLayout(new BorderLayout());
	   p3.add(new JTextArea("Panel 3"));
	   
	 //  setResizable(false);
	}

	public static void main(String[] args) {
		JFrame f = new LayoutManagerDemo();
		f.setVisible(true);
	}

}
