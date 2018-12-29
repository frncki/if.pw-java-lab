package pojava.zad2;

import java.awt.Graphics;
import java.awt.Color;
//import java.awt.LayoutManager;
import java.util.Random;
import javax.swing.JPanel;

public class ThreeShapesPanel extends JPanel {

	public ThreeShapesPanel() {
		rand = new Random();
		randC1 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		randC2 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		randC3 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
	}
/*
	public ThreeShapesPanel(LayoutManager arg0) {
		super(arg0);
		rand = new Random();
		randC1 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		randC2 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		randC3 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
	}

	public ThreeShapesPanel(boolean arg0) {
		super(arg0);
		rand = new Random();
		randC1 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		randC2 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		randC3 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
	}

	public ThreeShapesPanel(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		rand = new Random();
		randC1 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		randC2 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		randC3 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
	}
*/
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(randC1);
		g.fillRect(50, 50, 150, 100);

		g.setColor(randC2);
		g.fillOval(100, 100, 50, 50);

		g.setColor(randC3);
		g.fillOval(150, 150, 10, 100);
	}
	
	Random rand;
	Color randC1;
	Color randC2;
	Color randC3;
	

}
