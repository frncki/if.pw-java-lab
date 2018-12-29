package pw.java.wyk4.ciekawostki;
import java.awt.*;

import javax.swing.*;


public class ProsteRysowanieGlass extends JFrame {

	private static final long serialVersionUID = 7527424660011380430L;
	PanelRysowaniaGlass panel;

	public ProsteRysowanieGlass() 
	{
		super();
		setBounds(100, 100, 300, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(2,3));
		add(new JButton("Przycisk 1"));
		add(new JButton("Przycisk 2"));
		add(new JButton("Przycisk 3"));
		add(new JButton("Przycisk 4"));
		add(new JButton("Przycisk 5"));
		add(new JButton("Przycisk 6"));
		
		panel = new PanelRysowaniaGlass();   
	
		//Turn off the opaque attribute of the panel  
		//This allows the controls to show through  
		panel.setOpaque(false);  
		//Set the glass pane in the JFrame  
		setGlassPane(panel);  		   
		//Display the panel  
		panel.setVisible(true); 
		
	
		
	}

	public static void main(String args[]) 
	{
		final JFrame f = new ProsteRysowanieGlass();
		f.setVisible(true);
		
	}
}


class PanelRysowaniaGlass extends JPanel 
{
	private static final long serialVersionUID = 5466712063749687065L;

	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
		
	      //Set the color to with red with a 10% alpha  
	      g.setColor(new Color(1, 0, 0, 0.1f));  	   
	      //Fill a rectangle with the 50% red color  
	      g.fillRect(10, 10, this.getWidth() - 20, this.getHeight() - 20); 
	}
}

