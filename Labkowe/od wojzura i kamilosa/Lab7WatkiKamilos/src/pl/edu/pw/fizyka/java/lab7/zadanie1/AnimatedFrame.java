package pl.edu.pw.fizyka.java.lab7.zadanie1;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import pl.edu.pw.fizyka.java.lab7.przyklady.JButtonRunnable;

import java.awt.GridLayout;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class AnimatedFrame extends JButton implements Runnable {

	String[] tekst = { "Ala", "ma", "kota"};
	int pauza = 1000;
	boolean czynny = true;
	JPanel panel;

	AnimatedFrame() {
		super();
	}

	AnimatedFrame(String[] tekst, int pauza, JPanel panel) {
		this.tekst = tekst;
		this.pauza = pauza;
		this.panel = panel;
	}

	AnimatedFrame (String[] tekst, int pauza) {
		this.tekst = tekst;
		this.pauza = pauza;
	}

	@Override
	public void run() {

		int i = 0;

		while (czynny) {

			if (i < tekst.length - 1)
				i++;
			else
				i = 0;

			setText(tekst[i]);
			panel.setBackground(new Color((float)Math.random(),(float)Math.random(),(float)Math.random()));
			

			try {
				Thread.sleep(pauza);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	static Runnable r = new Runnable() {
		int i=0;
		@Override
		public void run() {
			System.out.println(i++);
			
		}
	};


	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame f = new JFrame();
				f.setLayout(new GridLayout(3, 1));
				f.setSize(500, 500);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JPanel panel = new JPanel(new GridLayout(3, 1));
				f.add(panel = new JPanel(), BorderLayout.PAGE_START);
				JPanel panel1 = new JPanel();
				f.add(panel1 = new JPanel(), BorderLayout.PAGE_END);
				JPanel panel2 = new JPanel();
				f.add(panel2 = new JPanel(), BorderLayout.CENTER);

				
				String[] innyTekst = { "Ala", "ma", "kota", "psa", "i", "mysz"};
				AnimatedFrame b1 = new AnimatedFrame(innyTekst, 1000, panel);
				panel.add(b1);
				String[] jeszczeInnyTeskt = {"tak", "szybki", "tekst", "ze", "nie", "mozna","go", "przeczytac"};
				AnimatedFrame b2 = new AnimatedFrame(innyTekst, 100,panel1);
				panel1.add(b2);
				AnimatedFrame b3 = new AnimatedFrame(jeszczeInnyTeskt, 200,panel2);
				panel2.add(b3);
				ExecutorService exec = Executors.newFixedThreadPool(3);

				exec.execute(b1);
				exec.execute(b2);
				exec.execute(b3);

				exec.shutdown();
				final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
				scheduler.scheduleAtFixedRate(r, 0, 1, SECONDS);

				scheduler.schedule(new Runnable() {
					                @Override
									public void run() {
					                	System.out.println("Koniec programu po 15 sekundach");
					                	scheduler.shutdownNow();
					                	System.exit(0);}
					            }, 20, SECONDS);

				f.setVisible(true);
			}
		});

	}

}
