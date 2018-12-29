//Franciszek Mirecki

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import org.jfree.chart.*;
import org.jfree.data.xy.*;
import org.jfree.chart.plot.PlotOrientation;

public class GraphPanel extends JPanel {

    private ChartPanel chartPanel;
    private XYSeries lineFunction;
    private XYSeriesCollection xyDataSet;
    private JFreeChart graph;

    public GraphPanel() {

        lineFunction = new XYSeries("funkcja liniowa");

        xyDataSet = new XYSeriesCollection();
        xyDataSet.addSeries(lineFunction);

        graph = ChartFactory.createXYLineChart(
                    "Wykres", // Title
                    "X",           					    // X-Axis label
                    "Y",           					    // Y-Axis label
                    xyDataSet,          			    // Dataset
                    PlotOrientation.VERTICAL,           // Plot orientation
                    true,                			    // show legend
                    true,               			    // Show tooltips
                    false               			    // url show
        );
        chartPanel = new ChartPanel(graph);
        this.add(chartPanel, BorderLayout.CENTER);
        }

    void addPoint(float x, float y) {
        lineFunction.add(x, y);
    }

    void clearGraph() {
        lineFunction.clear();
    }

    void saveGraph(File file) {
        BufferedImage img = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        this.paint(img.getGraphics());
        try {
            ImageIO.write(img, "png", new File(file.getAbsolutePath() + ".png"));
            System.out.println("panel saved as image");

        } catch (Exception e) {
            System.out.println("panel not saved" + e.getMessage());
        }
    }
}


