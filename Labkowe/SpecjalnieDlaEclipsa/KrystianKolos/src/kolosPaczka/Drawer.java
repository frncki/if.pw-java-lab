package kolosPaczka;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

public class Drawer extends JPanel {
	int xPos;
	int yPos;
	Random random;
	Color color;
	public Drawer() {
		setBackground(color.WHITE);
	}
	
	public void paintComponent(Graphics g) {
		 Graphics2D g2d = (Graphics2D) g;
		 g2d.setColor(color);
		 random = new Random();
		 xPos = random.nextInt(400);
		 yPos = random.nextInt(400);
		 g2d.fillOval(xPos,yPos, 20, 20);
	}


	public void randPos(int n1, int n2) {
		xPos = n1;
		yPos = n2;
		
	}
	public void getColor(Color color) {
		this.color = color;
	}
	
}
