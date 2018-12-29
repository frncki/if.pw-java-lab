package pl.edu.pw.fizyka.java.lab7.zadanie1;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class JButtonRunnable extends JButton implements Runnable {

	String[] tekst = { "To", "jest", "animowany", "przycisk" };
	int pauza = 1000;
	boolean czynny = true;

	JButtonRunnable() {
		super();
	}

	JButtonRunnable(String[] arg1, int arg2) {
		tekst = arg1;
		pauza = arg2;
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
			setBackground(new Color((float)Math.random(),(float)Math.random(),(float)Math.random()));

			try {
				Thread.sleep(pauza);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("mie");

	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame f = new JFrame();
				java.util.Timer timer = new Timer(true);
				timer.scheduleAtFixedRate(new TimerTask() {
					@Override
					public void run() {
						SwingUtilities.invokeLater(new Runnable() {  //InvokeLater
							@Override
							public void run() {
								System.exit(0);
							}
						});
					}
				}, 20000, 10 );
				f.setLayout(new GridLayout(3, 1));
				f.setSize(200, 300);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JButtonRunnable b1 = new JButtonRunnable();
				String [] tekst1 = {"A","L","A"," ","M","A"," ","K","O","T","A"," ", "-"," "};

				JLabelRunnable b3 = new JLabelRunnable(tekst1,200);

				f.add(b1);
				f.add(b3);
				String[] innyTekst = { "inny", "tekst", "do", "animowanego",
						"przycisku" };
				// wykorzystanie drugiego konstruktora pozwalajacego zmienic
				// tekst i szybkosc:
				JButtonRunnable b2 = new JButtonRunnable(innyTekst, 100);
				f.add(b2);

				ExecutorService exec = Executors.newFixedThreadPool(3);
				// Executors.newSingleThreadExecutor();

				exec.execute(b1);
				exec.execute(b2);
				exec.execute(b3);

				exec.shutdown();

				f.setVisible(true);
			}
		});

	}

}
