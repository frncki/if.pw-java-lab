package pl.pw.edu.fizyka.java.zad9dod;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jfree.chart.ChartFrame;

public class MainClass {

	public static void main(String[] args) {
		
		CookieChart ch = new CookieChart(50, 50);
		
		ExecutorService exec = Executors.newFixedThreadPool(1);

		exec.execute(ch);
		
		ChartFrame frame=new ChartFrame("Pie Chart3D", ch.getChart());
		
		frame.setVisible(true);
		frame.setSize(800, 600);
	}

}
