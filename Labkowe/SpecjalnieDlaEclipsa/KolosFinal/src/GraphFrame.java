import javax.swing.*;
import java.awt.*;
import org.jfree.chart.*;
import org.jfree.data.xy.*;
import org.jfree.chart.plot.PlotOrientation;

public class GraphFrame extends JFrame {

    private ChartPanel chartPanel;
    private XYSeries lineFunction;
    private XYSeriesCollection xyDataSet;
    private JFreeChart graph;

    public GraphFrame(float a, float b) {
        this.setSize(600, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        lineFunction = new XYSeries("Wykres: y = " + a + " * x + " + b);

        xyDataSet = new XYSeriesCollection();
        try {
            for (double i = -10; i < 10.1; i += 0.1) lineFunction.add(i, (a * i + b));
            xyDataSet.addSeries(lineFunction);
        } catch (IllegalArgumentException e) {
            xyDataSet.removeSeries(lineFunction);
        }

        graph = ChartFactory.createXYLineChart(
                "Wykres: y = " + a + "x + " + b, // Title
                "X",           					    // X-Axis label
                "Y",           					    // Y-Axis label
                xyDataSet,          			    // Dataset
                PlotOrientation.VERTICAL,           // Plot orientation
                true,                			    // show legend
                true,               			    // Show tooltips
                false               			    // url show
        );
        chartPanel = new ChartPanel(graph);
        this.getContentPane().add(chartPanel, BorderLayout.CENTER);
    }
}
