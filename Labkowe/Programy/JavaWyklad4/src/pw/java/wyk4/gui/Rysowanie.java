package pw.java.wyk4.gui;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;

public class Rysowanie {
    
    public static void main(String[] args) {
    	JFrame f = new JFrame("Rysowanie");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.add(new MojPanel());
        f.pack();
        f.setVisible(true);    	
    }
}


class MojPanel extends JPanel {

    private int squareX = 100;
    private int squareY = 20;
    private int squareW = 100;
    private int squareH = 100;
  
    public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);       
        g.setColor(Color.YELLOW);
        g.fillRect(squareX,squareY,squareW,squareH);
        g.setColor(Color.BLACK);
        g.drawRect(squareX,squareY,squareW,squareH);
    }  
}