package pl.edu.pw.fizyka.java.lab7.zadanie2;

import java.awt.Color;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainClass{

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				JFrame f = new JFrame("Prostokaty");
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				PanelRysowania panel = new PanelRysowania();
				
				panel.dodajProstokat(100, 100, 80, 160, Color.BLUE);
				try {
					panel.dodajProstokatZGrafika();
				} catch (IOException e) {
					e.printStackTrace();
				}

				for (int i = 1; i<20 ; i++) panel.dodajLosowyProstokat();
				
				f.add(panel);
				f.setSize(panel.getPreferredSize());
				ExecutorService exec = Executors.newSingleThreadExecutor();
				exec.execute(panel);
				exec.shutdown();
				f.setVisible(true);



			}
		});

	}

}

