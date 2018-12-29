package kolosPaczka;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

public class RandomCircleFrame extends JFrame {
	JPanel leftPanel;
	JMenuBar menuBar;
	JSlider slider1 , slider2 ,slider3;
	JButton btn1, btn2;
	JRadioButton rbtn1,rbtn2,rbtn3;
	
	Drawer rightPanel;
	Random random;
	
	public RandomCircleFrame() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(600, 500);
		setLayout(new BorderLayout());
		
		//---leftPanel
		add(leftPanel = new JPanel(), BorderLayout.WEST);
		leftPanel.setLayout (new GridLayout(11,1));
		leftPanel.add(btn1 = new JButton("RANDOM"));
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Color col = new Color(slider1.getValue(),slider2.getValue(),slider3.getValue());
				rightPanel.getColor(col);
				 random = new Random();
				 int n1 = random.nextInt(400);
				 int n2 = random.nextInt(400);
				 rightPanel.randPos(n1,n2);
				 rightPanel.repaint();
				
			}
			
		});
		leftPanel.add(rbtn1 = new JRadioButton("kwadrat"));
		leftPanel.add(rbtn2 = new JRadioButton("kolo"));
		leftPanel.add(rbtn3 = new JRadioButton("elipsa"));
		slider1 = new JSlider(0,255,127);
		slider2 = new JSlider(0,255,127);
		slider3 = new JSlider(0,255,127);
		leftPanel.add(new JLabel("R"));
		leftPanel.add(slider1);
		leftPanel.add(new JLabel("G"));
		leftPanel.add(slider2);
		leftPanel.add(new JLabel("B"));
		leftPanel.add(slider3);
		leftPanel.add(btn2 = new JButton("Anuluj"));
		
		//---Menu
		this.setJMenuBar(menuBar = new JMenuBar());
		JMenu fileMenu1 = new JMenu("Plik");
		JMenu fileMenu2 = new JMenu("Pomoc");
		JMenuItem menuItem1 = new JMenuItem("wczytaj");
		JMenuItem menuItem2 = new JMenuItem("wyjdz");
		menuItem2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
		});
//		JMenuItem menuItem3 = new JMenuItem("zapisz jako");
		JMenuItem menuItem4 = new JMenuItem("Autor");
		menuItem4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFrame();
				f.setVisible(true);
				f.setSize(200, 100);
				f.add(new JLabel("TWOJE IMIE"));
				
			}
			
		});
		JMenu submenu = new JMenu("zapisz jako");
		JMenuItem menuItem5 = new JMenuItem("text");
		JMenuItem menuItem6 = new JMenuItem("PNG");
		menuBar.add(fileMenu1);
		fileMenu1.add(menuItem1);
		fileMenu1.add(menuItem2);
		fileMenu1.add(submenu);
		submenu.add(menuItem5);
		submenu.add(menuItem6);
		menuBar.add(fileMenu2);
		fileMenu2.add(menuItem4);
		
		//---rightPanel
		add(rightPanel = new Drawer(),BorderLayout.CENTER);
		
	}
	
	public static void main(String[] args) {
		RandomCircleFrame frame = new RandomCircleFrame();
		frame.setVisible(true);

	}
}
