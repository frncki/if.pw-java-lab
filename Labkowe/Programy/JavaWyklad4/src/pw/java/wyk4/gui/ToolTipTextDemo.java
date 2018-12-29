package pw.java.wyk4.gui;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ToolTipTextDemo extends JFrame  {
	
	private static final long serialVersionUID = 945403068288031857L;

	public ToolTipTextDemo() throws HeadlessException {
		super();
		setSize(600,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,3));
		
		setLayout(new GridLayout(3,3,10,10));
		JButton guziki[] = new JButton[9];
		for (int i = 0; i<9; i++){ 
			guziki[i] = new JButton ("Przycisk" + i);
			guziki[i].setToolTipText("Podpowiedz przycisku nr " + i);
			add(guziki[i]);
		}
	}

	public static void main(String[] args) {
		JFrame f = new ToolTipTextDemo();
		f.setVisible(true);
	}
}
