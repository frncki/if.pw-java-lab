package pl.pw.edu.fizyka.java.zad9;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.function.LineFunction2D;
import org.jfree.data.function.PolynomialFunction2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Grapher extends JFrame {
	private static final long serialVersionUID = 872456303451658871L;
	
	private JPanel buttonsPanel;
	private ChartPanel chartPanel;
	private JButton sinButton, cosButton, lineButton, quadraticButton, lnButton;
	
	private XYSeries sinDataSet, cosDataSet, lnDataSet, lineFunction, quadraticFunction;
	private XYSeriesCollection xyDataSet;
	private JFreeChart graph;
	
	
	public Grapher() {
		this.setSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Mr. Grapher");
		
		Dimension dim =  Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
		
		//~~~~~~~~~~~~~~~~~~~~~~~~buttonsPanel~~~~~~~~~~~~~~~~~~~~~~~~
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout());
        Border whiteLine = BorderFactory.createLineBorder(Color.WHITE);
        buttonsPanel.setBorder(whiteLine);
        TitledBorder title = BorderFactory.createTitledBorder(whiteLine, "Functions");
        title.setTitleColor(Color.WHITE);
        buttonsPanel.setBorder(title);
        buttonsPanel.setBackground(new Color(51, 51, 51));
				
		//~~~~~~~~~~~~~~~~~~~~~~~~sin~~~~~~~~~~~~~~~~~~~~~~~~
		sinDataSet = new XYSeries("sin");
		for (double i = -32; i < 33; i += 0.1) sinDataSet.add(i, Math.sin(i));
		xyDataSet = new XYSeriesCollection();
		
		//chartPanel = new ChartPanel(graphIT(sinDataSet, "sin"));
		
		//~~~~~~~~~~~~~~~~~~~~~~~~cos~~~~~~~~~~~~~~~~~~~~~~~~
		cosDataSet = new XYSeries("cos");
		for (double i = -32; i < 33; i += 0.1) cosDataSet.add(i, Math.cos(i));
		
		//~~~~~~~~~~~~~~~~~~~~~~~~line~~~~~~~~~~~~~~~~~~~~~~~~
		lineFunction = new XYSeries("line");
		for (double i = -10; i < 11; i += 0.1) lineFunction.add(i, (0.1*i+0.1));
		//~~~~~~~~~~~~~~~~~~~~~~~~quadratic~~~~~~~~~~~~~~~~~~~~~~~~
		quadraticFunction = new XYSeries("quadratic");
		for (double i = -2; i < 2; i += 0.05) quadraticFunction.add(i, (0.5 * i * i + 0.1 * i + 0.05));
		
		//~~~~~~~~~~~~~~~~~~~~~~~~ln~~~~~~~~~~~~~~~~~~~~~~~~
		lnDataSet = new XYSeries("ln");
		for (double i = -0.5; i < 11; i += 0.1) lnDataSet.add(i, Math.log(i * 3));
		
		//~~~~~~~~~~~~~~~~~~~~~~~~buttons~~~~~~~~~~~~~~~~~~~~~~~~
		sinButton = new JButton("sin");
		sinButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					xyDataSet.addSeries(sinDataSet);
				} catch (IllegalArgumentException e) {
					xyDataSet.removeSeries(sinDataSet);
				}
				//chartPanel.setChart(graphIT(sinDataSet, "sin"));
			}
		});
		
		cosButton = new JButton("cos");
		cosButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					xyDataSet.addSeries(cosDataSet);
				} catch (IllegalArgumentException e) {
					xyDataSet.removeSeries(cosDataSet);
				}
				//chartPanel.setChart(graphIT(cosDataSet, "cos"));
			}
		});
		
		lineButton = new JButton("line");
		lineButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					xyDataSet.addSeries(lineFunction);
				} catch (IllegalArgumentException e) {
					xyDataSet.removeSeries(lineFunction);
				}
			}
		});
		
		quadraticButton = new JButton("quadratic");
		quadraticButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					xyDataSet.addSeries(quadraticFunction);
				} catch (IllegalArgumentException e) {
					xyDataSet.removeSeries(quadraticFunction);
				}

//				XYDataset quadraticDataSet = DatasetUtilities.sampleFunction2D(quadraticFunction, -24, 20, 25, "quadratic");
//				JFreeChart graph = ChartFactory.createXYLineChart(
//								"line",  						// Title 
//		                        "X",           					// X-Axis label 
//		                        "Y",           					// Y-Axis label 
//		                        quadraticDataSet,          			// Dataset 
//		                        PlotOrientation.VERTICAL,       // Plot orientation 
//		                        true,                			// show legend 
//		                        true,               			// Show tooltips 
//		                        false               			// url show 
//		                       );
//				chartPanel.setChart(graph);
			}
		});
		
		lnButton = new JButton("ln");
		lnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					xyDataSet.addSeries(lnDataSet);
				} catch (IllegalArgumentException e) {
					xyDataSet.removeSeries(lnDataSet);
				}
				
				//chartPanel.setChart(graphIT(lnDataSet, "ln"));
				
			}
		});
		
		JFreeChart graph = ChartFactory.createXYLineChart(
				"wykres",  						// Title 
                "X",           					// X-Axis label 
                "Y",           					// Y-Axis label 
                xyDataSet,          			// Dataset
                PlotOrientation.VERTICAL,       // Plot orientation 
                true,                			// show legend 
                true,               			// Show tooltips 
                false               			// url show 
               ); 
		chartPanel = new ChartPanel(graph);
		
		buttonsPanel.add(sinButton);
		buttonsPanel.add(cosButton);
		buttonsPanel.add(lineButton);
		buttonsPanel.add(quadraticButton);
		buttonsPanel.add(lnButton);
		
		this.add(buttonsPanel, BorderLayout.NORTH);
		this.getContentPane().add(chartPanel, BorderLayout.CENTER);	
	}
	
//	JFreeChart graphIT(XYSeries series, String title) {
//		XYSeriesCollection xyDataSet = new XYSeriesCollection(series);
//		JFreeChart graph = ChartFactory.createXYLineChart(
//						title,  						// Title 
//                        "X",           					// X-Axis label 
//                        "Y",           					// Y-Axis label 
//                        xyDataSet,          			// Dataset 
//                        PlotOrientation.VERTICAL,       // Plot orientation 
//                        true,                			// show legend 
//                        true,               			// Show tooltips 
//                        false               			// url show 
//                       ); 
//		return graph;
//	}
	
}
