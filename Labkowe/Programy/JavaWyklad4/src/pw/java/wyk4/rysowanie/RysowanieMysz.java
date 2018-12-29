package pw.java.wyk4.rysowanie;

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

public class RysowanieMysz {
    
    public static void main(String[] args) {
    	JFrame f = new JFrame("Kliknij i przeciagnij");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.add(new MyPanel());
        f.pack();
        f.setVisible(true);    	
    }
}


class MyPanel extends JPanel {

    private int squareX = 0;
    private int squareY = 0;
    private int squareW = 0;
    private int squareH = 0;

    public MyPanel() {

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                squareX = e.getX();
                squareY = e.getY();   
               
            }
            
            public void mouseReleased(MouseEvent e) {
				if (e.getX() > squareX) squareW = e.getX() - squareX; 
					else {
						squareW = squareX - e.getX(); 
						squareX = e.getX();
					}
				
				if (e.getY() > squareY) squareH = e.getY() - squareY; 
				else {
					squareH = squareY - e.getY(); 
					squareY = e.getY();
				}
				
			    repaint();
			}
        });
           
    }
   
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