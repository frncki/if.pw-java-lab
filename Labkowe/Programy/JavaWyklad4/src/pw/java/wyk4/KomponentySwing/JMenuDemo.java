package pw.java.wyk4.KomponentySwing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class JMenuDemo extends JFrame{

	JLabel etykieta = new JLabel("Wybierz pozycje menu");
	
	public JMenuDemo(){
		super("JMenuDemo");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		add(etykieta);
    	setJMenuBar( createMenu() );
	    
	}

	
	public JMenuBar createMenu(){
		
		JMenuBar menuBar;
		JMenu menu;
		
		JMenuItem menuItem;
		final JRadioButtonMenuItem rbMenuItem;
		final JCheckBoxMenuItem cbMenuItem;

	    // Tworzenie paska menu
		menuBar = new JMenuBar();
	    
		//Dodawanie menu:
		menu = new JMenu("Menu glowne");
		menuBar.add(menu);

	
		menuItem = new JMenuItem("Pierwsza pozycja");
		menu.add(menuItem);
		
		menu.addSeparator();
	
		rbMenuItem = new JRadioButtonMenuItem("Pozycja menu z JRadioButton");
		rbMenuItem.setSelected(true);
		menu.add(rbMenuItem);
		
		menu.addSeparator();
		cbMenuItem = new JCheckBoxMenuItem("Pozycja menu z JCheckBoox");
		menu.add(cbMenuItem);				
		
		// dodawanie akcji do elementow menu analogicznie jak dla komponentow:
		
		menuItem.addActionListener(new ActionListener() {
			// 	Przyklad wykorzystania html w etykiecieJLabel
			public void actionPerformed(ActionEvent e) {
				etykieta.setText( 
						"<html>\n" +
								"Wybrano pierwsza pozycje menu " +
		                        "<ul>\n" +
		                        "<li><font color=red>Stan JRadioButton'a: </font>\n" + rbMenuItem.isSelected() +
		                        "<li><font color=blue>Stan JCheckBox'a: </font>\n" +	cbMenuItem.isSelected()	+                        
		                        "</ul>\n"+
		                        "W tej etykiecie JLabel wykorzystano kod HTML"+
		                        " &PI; &#54596;;"+
		                        "</html>");
			}
		});


		menu.addSeparator();
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);	
			}
			
		});
		menu.add(exit);
		
		rbMenuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				etykieta.setText( "Zmieniono stan JRadioButton'a: " + rbMenuItem.isSelected() );
				
			}
		});
		
		cbMenuItem.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				etykieta.setText( "Zmieniono stan JCheckBox'a: " + cbMenuItem.isSelected() );
				
			}
		});
		
		return menuBar;
	}
	
	
	public static void main(String[] args) {
		JFrame f = new JMenuDemo();
		f.setBounds(100, 100, 400, 200);
			f.setVisible(true);
	}

}
