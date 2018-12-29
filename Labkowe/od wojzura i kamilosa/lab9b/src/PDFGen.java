import com.orsonpdf.PDFDocument;
import com.orsonpdf.PDFGraphics2D;
import com.orsonpdf.Page;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StatisticalBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.jfree.ui.TextAnchor;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PDFGen extends JPanel{

    private static CategoryDataset createDataset() {
        DefaultStatisticalCategoryDataset dataset
                = new DefaultStatisticalCategoryDataset();
        dataset.add(10.0, 2.4, "Row 1", "Column 1");
        dataset.add(15.0, 4.4, "Row 1", "Column 2");
        dataset.add(13.0, 2.1, "Row 1", "Column 3");
        dataset.add(7.0, 1.3, "Row 1", "Column 4");
        dataset.add(22.0, 2.4, "Row 2", "Column 1");
        dataset.add(18.0, 4.4, "Row 2", "Column 2");
        dataset.add(28.0, 2.1, "Row 2", "Column 3");
        dataset.add(17.0, 1.3, "Row 2", "Column 4");
        return dataset;
    }

    /**
     * Creates a sample chart.
     *
     * @param dataset  a dataset.
     *
     * @return The chart.
     */
    private static JFreeChart createChart(CategoryDataset dataset) {

        // create the chart...
        JFreeChart chart = ChartFactory.createLineChart(
                "Statistical Bar Chart Demo 1", "Type", "Value", dataset,
                PlotOrientation.VERTICAL, true, false, false);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        // customise the range axis...
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(false);

        // customise the renderer...
        StatisticalBarRenderer renderer = new StatisticalBarRenderer();
        renderer.setDrawBarOutline(false);
        renderer.setErrorIndicatorPaint(Color.black);
        renderer.setIncludeBaseInRange(false);
        plot.setRenderer(renderer);

        // ensure the current theme is applied to the renderer just added
        ChartUtilities.applyCurrentTheme(chart);

        renderer.setBaseItemLabelGenerator(
                new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseItemLabelPaint(Color.yellow);
        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
                ItemLabelAnchor.INSIDE6, TextAnchor.BOTTOM_CENTER));

        // set up gradient paints for series...
        GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, Color.blue,
                0.0f, 0.0f, new Color(0, 0, 64));
        GradientPaint gp1 = new GradientPaint(0.0f, 0.0f, Color.green,
                0.0f, 0.0f, new Color(0, 64, 0));
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        return chart;
    }

    static Random r = new Random();

    public PDFGen ()
    {
        PDFDocument pdfDoc = new PDFDocument();


        pdfDoc.setTitle("Testowy PDF");
        pdfDoc.setAuthor("Wojciech Żurkowski");


        JFreeChart chart = createChart(createDataset());
        Page page1 = pdfDoc.createPage(new Rectangle(794, 1123));
        PDFGraphics2D g2c = page1.getGraphics2D();
        chart.draw(g2c, new Rectangle(0, 0, 794, 1123));

        Page page2 = pdfDoc.createPage(new Rectangle(794, 1123));



        Page page3 = pdfDoc.createPage(new Rectangle(794, 1123));
        PDFGraphics2D g2 = page3.getGraphics2D();

        List<LinePDF> lines = new ArrayList<LinePDF>();
        for (int i = 1; i<20 ; i++)
            lines.add( new LinePDF(r.nextInt(200),r.nextInt(300),r.nextInt(500),r.nextInt(600)));

        for (LinePDF l : lines) {
            try {
                l.paint(g2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File file = new File("ProstokatyDoPDF.pdf");
        // zapis do pliku zawartosci dodanej do obiektu pdfDoc
        pdfDoc.writeToFile(file);

        System.out.println("Prostokaty zapisano do pliku: " + file.getAbsolutePath());
    }

}
