package pl.pw.edu.fizyka.java.lab9;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.orsonpdf.PDFDocument;
import com.orsonpdf.PDFGraphics2D;
import com.orsonpdf.Page;

public class pdfMaker {
	
	private XYSeries lnDataSet;
	private XYSeriesCollection xyDataSet;
	//private JFreeChart graph;
	
	private PDFDocument pdfDoc;
	
	pdfMaker() {
		lnDataSet = new XYSeries("ln");
		for (double i = 0.72; i < 32.3; i += 2.0) lnDataSet.add(i, Math.log(i));
		xyDataSet = new XYSeriesCollection(lnDataSet);
		JFreeChart graph = ChartFactory.createXYLineChart(
				"ln x",  						// Title 
                "X",           					// X-Axis label 
                "Y",           					// Y-Axis label 
                xyDataSet,          			// Dataset
                PlotOrientation.VERTICAL,       // Plot orientation 
                true,                			// show legend 
                true,               			// Show tooltips 
                false               			// url show 
               );
		
		pdfDoc = new PDFDocument();
        pdfDoc.setTitle("PDFChart");
        pdfDoc.setAuthor("ja");
        
        Page page1 = pdfDoc.createPage(new Rectangle(612, 468));
        PDFGraphics2D g2 = page1.getGraphics2D();
        graph.draw(g2, new Rectangle(0, 0, 612, 468));
        
        Page page2 = pdfDoc.createPage(new Rectangle(612, 468));
        g2 = page2.getGraphics2D();
        g2.setColor(Color.BLACK);
        g2.drawString("X:", 101, 40);
	    g2.drawString("Y:", 401, 40);
        for (int i = 0; i < lnDataSet.getItemCount(); i++) {
			g2.drawString(String.valueOf(lnDataSet.getX(i).doubleValue()), 100, 60 + i * 10);
		    g2.drawString(String.valueOf(lnDataSet.getY(i).doubleValue()), 400, 60 + i * 10);
		}
        
        Page page3 = pdfDoc.createPage(new Rectangle(612, 468));
        g2 = page3.getGraphics2D();
        g2.setColor(Color.PINK);
        for (int i = 50; i < 71; i += 10) {
        	g2.draw(new Ellipse2D.Float(i + i * 3, i, i, i));
        	g2.draw(new Line2D.Float(i + 20, i + i * 2, i + 200, i + 100));
        }
        BufferedImage im = null;
		try {
			im = ImageIO.read(new File("images/img.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g2.drawImage(im, 400, 50, null);
	}
	
	public void print() {
		pdfDoc.writeToFile(new File("lab9zad2.pdf"));
	}
	
	public static void main(String[] args) {
		pdfMaker PDF = new pdfMaker();
		PDF.print();
		System.out.println("dziala");
	}
}
