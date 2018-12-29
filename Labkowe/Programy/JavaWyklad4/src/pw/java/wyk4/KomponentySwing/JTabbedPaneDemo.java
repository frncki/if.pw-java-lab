package pw.java.wyk4.KomponentySwing;

import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class JTabbedPaneDemo extends JFrame{

	public JTabbedPaneDemo() throws HeadlessException {
		super("JTabbedPaneDemo");
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	       JTabbedPane tabbedPane = new JTabbedPane();
	       
	       JPanel panel1 = new JPanel(new FlowLayout());
	       JPanel panel2 = new JPanel(new FlowLayout());
	       JPanel panel3 = new JPanel(new FlowLayout());
	       
	       for (int i = 1; i< 10; i++) {
	    	   panel1.add(new JButton("JButton"));
	    	   panel2.add(new JRadioButton("JRadioButton"));
	    	   panel3.add(new JCheckBox("JCheckBox"));
	       }
	       
	       tabbedPane.addTab("Tytul 1", panel1);
	       tabbedPane.addTab("Tytul 2", panel2);
	       tabbedPane.addTab("Tytul 3", panel3);
	  
	       //    tabbedPane.remove(panel2);
	       
	      add(tabbedPane);
	  
	}

	public static void main(String[] args) {
		JFrame f = new JTabbedPaneDemo();
		f.setVisible(true);
	}
	
}