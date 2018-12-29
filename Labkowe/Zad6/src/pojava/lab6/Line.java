package pojava.lab6;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;

public class Line {

    private List<Integer> xList;  // Lista współrzędnych x
    private List<Integer> yList;  // Lista współrzędnych y
    private Color lineColor;
    private int lineWidth;

    public Line(int lineWidth, Color lineColor) {
        xList = new ArrayList<Integer>();
        yList = new ArrayList<Integer>();
        this.lineColor = lineColor;
        this.lineWidth = lineWidth;
    }

    // Dodawanie punktów do linii
    public void addPoint(int x, int y) {
        xList.add(x);
        yList.add(y);
    }

    // Metoda pozwalająca linii na rysowanie siebie samej, jeżeli będzie miała dostęp do Graphics2D/Graphics
    public void draw(Graphics2D g2d) {
        g2d.setColor(lineColor);
        BasicStroke bs1 = new BasicStroke(lineWidth);
        g2d.setStroke(bs1);
        for (int i = 0; i < xList.size() - 1; ++i)
        {
            g2d.drawLine(xList.get(i), yList.get(i), xList.get(i + 1), yList.get(i + 1));
        }
    }

}
