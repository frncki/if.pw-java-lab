package pojava.zad2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClosableFrame extends JFrame {

	private static final long serialVersionUID = 7697979308227642719L;

	public ClosableFrame() throws HeadlessException {
		this.setSize(640,480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public ClosableFrame(GraphicsConfiguration gc) {
		super(gc);
		this.setSize(640,480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	public ClosableFrame(String title) throws HeadlessException {
		super(title);
		this.setSize(640,480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
	}

	public ClosableFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		this.setSize(640,480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {

		ClosableFrame frame = new ClosableFrame("tytul");
		frame.setLayout(new GridLayout(2,1));
		
		ThreeShapesPanel panel = new ThreeShapesPanel();
		panel.setBackground(Color.black);
		frame.add(panel);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.white);
		frame.add(panel2);
		
		JLabel label = new JLabel("To jest etykieta");
		panel2.add(label);
		
		JTextField field = new JTextField("A to pole tekstowe");
		panel2.add(field);
		
		JTextField field1 = new JTextField("A to pole tekstowe");
		panel2.add(field1);
		
		JButton button2 = new JButton("Przycisk 2");
		panel2.add(button2, BorderLayout.PAGE_END);
		panel2.setLayout(new GridLayout(4,1));
		
		frame.setVisible(true);

	}

}
