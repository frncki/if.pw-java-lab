package pl.edu.pw.fizyka.java.lab7.zadanie2;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class PanelRysowania extends JPanel implements Runnable {

	private boolean active = true;
	private static final long serialVersionUID = 1L;
	List<Prostokat> prostakaty = new ArrayList<Prostokat>();




	public PanelRysowania() {

	}
	
	public void dodajLosowyProstokat(){
		Random r = new Random();
		
		Prostokat p = new Prostokat();
		p.setX(r.nextInt(550));
		p.setY(r.nextInt(550));
		p.setWidth(r.nextInt(80));
		p.setHeight(r.nextInt(80));
		p.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255), r.nextInt(255)));

		prostakaty.add(p);		
	}
	
	public void dodajProstokat(int x, int y, int width, int height, Color c){
		Prostokat p = new Prostokat();
		p.setX(x);
		p.setY(y);
		p.setWidth(width);
		p.setHeight(height);
		p.setColor(c);

		prostakaty.add(p);		
		
	}

	public void dodajAnimowanyProstokat() throws IOException {
		Prostokat p = new Prostokat();
		p.setX(this.getWidth()/2);
		p.setY(this.getHeight()/2);
		p.setVx(3);
		p.setHeight(365);
		p.setWidth(165);
		p.setVy(5);
		List<BufferedImage> tmp = new ArrayList<BufferedImage>();
		for (int i = 1; i < 6; i ++) {
			tmp.add(ImageIO.read(new File("img/" + i + ".png")));
		}
		p.setImages(tmp);

		prostakaty.add(p);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (Prostokat p : prostakaty) {
			p.paint(g);
		}

	}

	public Dimension getPreferredSize() {
		return new Dimension(600, 600);
	}


	@Override
	public void run() {

		while (active) {

			for (Prostokat p : prostakaty) {

				p.update();
				p.bounce(this);

				repaint();
			}

			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
