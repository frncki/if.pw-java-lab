package pl.pw.edu.fizyka.java.zad9dod;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class CookieChart implements Runnable { // Cookie bo Pie hehehhe
	
	private boolean active = true;
	private double a = 0.1;
	
	private DefaultPieDataset data;
	private double valueOne, valueTwo;
	private JFreeChart chart;
	private PiePlot plot;
	
	public CookieChart(double valueOne, double valueTwo) {
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;
		
		data = new DefaultPieDataset();
		data.setValue("Dynamic Value One", this.valueOne);
		data.setValue("Dynamic Value Two", this.valueTwo);
		
		chart = ChartFactory.createPieChart3D
				("Dynamic 3D Pie Chart", // Tytul wykresu
				data, // dane typu PieDataset 
				true, // legenda
				true, // tooltips
				false // Configure chart to generate URLs?
				);
		
		plot = (PiePlot) chart.getPlot();
		plot.setForegroundAlpha(0.7f);
	}
	
	public JFreeChart getChart() {
		return chart;
	}
	
	@Override
	public void run() {
		while(active) {
			
			data.setValue("Dynamic Value One", valueOne * (Math.sin(a) + 1.51));
			data.setValue("Dynamic Value Two", valueTwo * (Math.sin(-a) + 1.51));
			a += 0.1;
			
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
