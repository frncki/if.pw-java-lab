package pl.edu.pw.fizyka.java.lab7.zadanie2;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class PanelRysowania extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;
	List<Prostokat> prostakaty = new ArrayList<Prostokat>();


	public PanelRysowania() {
       // domyslny konstruktor
	}
	
	public void dodajLosowyProstokat(){
		Random r = new Random();
		
		Prostokat p = new Prostokat();
		p.setX(r.nextInt(550));
		p.setY(r.nextInt(550));
		p.setWidth(r.nextInt(80));
		p.setHeight(r.nextInt(80));
		p.setColor(new Color(r.nextInt(255), r.nextInt(255),
				r.nextInt(255), r.nextInt(255)));

		p.setvX(r.nextInt(20));
		p.setvY(r.nextInt(20));

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

	public void dodajProstokatZGrafika() throws IOException {
		Prostokat p = new Prostokat();
		p.setX(0);
		p.setY(0);
		p.setvX(5);
		p.setHeight(152);
		p.setWidth(240);
		p.setvY(10);
		List<BufferedImage> tmp = new ArrayList<BufferedImage>();
		tmp.add(ImageIO.read(new File("images/1.jpg")));
		tmp.add(ImageIO.read(new File("images/2.jpg")));
		tmp.add(ImageIO.read(new File("images/3.jpg")));
		tmp.add(ImageIO.read(new File("images/4.jpg")));
		tmp.add(ImageIO.read(new File("images/5.jpg")));
		tmp.add(ImageIO.read(new File("images/6.jpg")));
		tmp.add(ImageIO.read(new File("images/7.jpg")));
		tmp.add(ImageIO.read(new File("images/8.jpg")));
		p.setObrazy(tmp);

		prostakaty.add(p);

	}



	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (Prostokat pr : prostakaty) {
			pr.paint(g);
		}

	}
	
	public Dimension getPreferredSize() {
		return new Dimension(600, 600);
	}

	@Override
	public void run() {

		while (true) {


			for (Prostokat pr : prostakaty) {
				if(pr.getX() <= getPreferredSize().width && pr.getX() >= 0)
				{
					pr.setX(pr.getX()+pr.getvX());
				}
				else
				{
					pr.setvX(-pr.getvX());
					pr.setX(pr.getX()+pr.getvX());
				}
				if(pr.getY() <= getPreferredSize().height && pr.getY() >= 0)
				{
					pr.setY(pr.getY()+pr.getvY());
				}
				else
				{
					pr.setvY(-pr.getvY());
					pr.setY(pr.getY()+pr.getvY());
				}
			}

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.repaint();
		}

	}


}
