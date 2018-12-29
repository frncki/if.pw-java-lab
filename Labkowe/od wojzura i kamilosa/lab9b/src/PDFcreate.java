import com.orsonpdf.PDFDocument;
import com.orsonpdf.PDFGraphics2D;
import com.orsonpdf.Page;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class PDFcreate {

	public PDFcreate() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				PDFDocument pdfDoc = new PDFDocument();
				 pdfDoc.setTitle("plik PDF");
			        pdfDoc.setAuthor("JZ");
				 
				 Page page1 = pdfDoc.createPage(new Rectangle(794, 1123));
				 
				 PDFGraphics2D g2 = page1.getGraphics2D();	
				 
				 
				 XYSeries series = new XYSeries("Seria 1");
					
			        Scanner scan;
			        double data1,data2;
			        File file1 = new File("images/dane.txt");
			        try {
			            scan = new Scanner(file1);
			            int i=0;
			            g2.setColor(Color.BLACK);
			            g2.drawString("X:", 40, 40);
			            g2.drawString("Y:", 150, 40);
			            while(scan.hasNextDouble())
			            {
			            	String s1, s2;
			                data1=scan.nextDouble();
			                data2=scan.nextDouble();
			                s1=Double.toString(data1);
			                s2=Double.toString(data2);
			                series.add(data1, data2);
			                g2.drawString(s1,40,55+i*10);
			                g2.drawString(s2,150,55+i*10);
			                i=i+1;
			            }

			        } catch (FileNotFoundException e1) {
			                e1.printStackTrace();
			        }
			        
			        
			        XYSeriesCollection dataset = new XYSeriesCollection();
					dataset.addSeries(series);
					
					JFreeChart chart = ChartFactory.createXYLineChart(
							"Wykres XY",//Tytul
							"X", // opisy osi
							"Y", 
							dataset, // Dane 
							PlotOrientation.VERTICAL, // Orientacja wykresu /HORIZONTAL
							true, // legenda
							true, // tooltips
							false
						);
					
					Page page2 = pdfDoc.createPage(new Rectangle(794, 1123));
					g2 = page2.getGraphics2D();		
					chart.draw(g2, new Rectangle(0, 0, 612, 468));
				 
				 Page page3 = pdfDoc.createPage(new Rectangle(794, 1123));
				 g2 = page3.getGraphics2D();
				 g2.setColor(Color.BLACK);
				 g2.draw(new Ellipse2D.Float(20, 20, 10, 5));
				 g2.draw(new Ellipse2D.Float(42, 42, 42, 42));
				 g2.draw(new Ellipse2D.Float(500, 500, 64, 56));
				 g2.draw(new Line2D.Float(10, 10, 700, 1100));
				 g2.draw(new Line2D.Float(100, 1000, 20, 200));
				 g2.draw(new RoundRectangle2D.Float(225, 225, 100, 200, 1, 2));	
				BufferedImage im = null;
				try {
					im = ImageIO.read(new File("images/duck.jpg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				g2.drawImage(im, 100, 800, null);

				 
				 File file2 = new File("plik PDF.pdf");
					// zapis do pliku zawartosci dodanej do obiektu pdfDoc
					pdfDoc.writeToFile(file2);
					System.out.println("ZAKONCZONO");
			}
	});}
	

}//klasa
