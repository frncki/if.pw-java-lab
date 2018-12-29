package pojava.zad2;

import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ThreeButtonFrame extends JFrame {

	public ThreeButtonFrame() throws HeadlessException {
		this.setSize(640,480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JButton button1 = new JButton("Zakoncz");
		ActionListener exitListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
						
			}	
		};
		button1.addActionListener(exitListener);
		add(button1);
		
		JButton button2 = new JButton("Zmien tytul");
		ActionListener titleListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setTitle("Zmieniono tytul");
						
			}	
		};
		button2.addActionListener(titleListener);
		add(button2);
		
		final JButton button3 = new JButton("Zmien kolor");
		ActionListener colorListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				button3.setBackground(Color.black);
				button3.setForeground(Color.cyan);
				
			}	
		};
		button3.addActionListener(colorListener);
		add(button3);
	}

	public ThreeButtonFrame(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ThreeButtonFrame(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ThreeButtonFrame(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		ThreeButtonFrame frame = new ThreeButtonFrame();
		frame.setLayout(new GridLayout(3,1));
		frame.setVisible(true);
	}

}
