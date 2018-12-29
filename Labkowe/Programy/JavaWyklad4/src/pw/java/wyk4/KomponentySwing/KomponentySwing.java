package pw.java.wyk4.KomponentySwing;

import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

@SuppressWarnings("serial")
public class KomponentySwing extends JFrame {

	public KomponentySwing() throws HeadlessException {
		super();
		
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		add (new JButton("JButton"));
		add (new JToggleButton("JToggleButton"));
		add (new JLabel ("JLabel"));
		add (new JCheckBox("JCheckBox"));
		add (new JRadioButton("RadioButton"));
		add (new JComboBox<>());
		add (new JSpinner());
		add (new JSlider());
		add (new JProgressBar());
		add (new JTextField("JTextField"));
		add (new JTextArea("JTextArea\nJTextArea\nJTextArea"));
		add (new JPasswordField("JPasswordField"));
		add (new JScrollBar(JScrollBar.HORIZONTAL));	
		
	
	}	// TODO Auto-generated constructor stub

	public static void main(String[] args) {
		KomponentySwing okno = new KomponentySwing();
		okno.setVisible(true);
	}

}
