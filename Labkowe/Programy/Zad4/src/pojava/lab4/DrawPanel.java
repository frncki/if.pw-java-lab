package pojava.lab4;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {

    private int xPoints[];
    private int yPoints[];
    private int nPoints;
    private int lineWidth;
    Color lineColor;

    public void setXPoints(int[] points) {
        xPoints = points;
    }

    public void setYPoints(int[] points) {
        yPoints = points;
    }

    public void setNPoints(int n) {
        nPoints = n;
    }


    DrawPanel(int[] x, int[] y, int n, Color bColor, Color lColor, int lWidth) {
        xPoints = x;
        yPoints = y;
        nPoints = n;
        lineWidth = lWidth;
        this.setBackground(bColor);
        lineColor = lColor;
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Drawing"));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(lineColor);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke bs1 = new BasicStroke(lineWidth);
        g2d.setStroke(bs1);
        g2d.draw(new Polygon(xPoints, yPoints, nPoints));
    }
}
