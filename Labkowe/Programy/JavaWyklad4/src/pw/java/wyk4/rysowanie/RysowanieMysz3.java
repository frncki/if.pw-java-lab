package pw.java.wyk4.rysowanie;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RysowanieMysz3 {
    
    public static void main(String[] args) {
    	JFrame f = new JFrame("Kliknij mysza...");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.add(new MyPanel3());
        f.pack();
        f.setVisible(true);    	
    }
}


class MyPanel3 extends JPanel {

    private int MAKSYMALNA_LICZBA_ELEMENTOW = 5;
	private int[] x = new int [MAKSYMALNA_LICZBA_ELEMENTOW];
	private int[] y = new int [MAKSYMALNA_LICZBA_ELEMENTOW];	
	private int licznikKlikniec = 0;
    
    public MyPanel3() {
        
    	addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	if (licznikKlikniec < MAKSYMALNA_LICZBA_ELEMENTOW){
            		x[licznikKlikniec] = e.getX();
            		y[licznikKlikniec] = e.getY();
            		licznikKlikniec++;
            		repaint();            		
            	}
            	
            	else{
            		//Przekroczona dopuszczalna ilosc klikniec...
            		getGraphics().drawString("Elementy przechowywane w tablicy o maksymalnej liczbie elementow: " + MAKSYMALNA_LICZBA_ELEMENTOW, 20, 20);
            		getGraphics().drawString("Komentarz ten dodano metoda JPanel.getGraphics().drawString(\"...\")", 20, 35);
            		getGraphics().drawString("Zmien rozmiar okna - komentarz zniknie, wywietli sie tylko grafika z metody paintComponent", 20, 50);
            	}
                
            if (e.getButton() == MouseEvent.BUTTON3) wyczyscElementy();
            }          
           
        });
           
    }
   
    public Dimension getPreferredSize() {
        return new Dimension(550,300);
    }
    
    public void wyczyscElementy(){
    	licznikKlikniec = 0;
    	repaint();
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);               
       for (int i = 0; i<licznikKlikniec; i++){
    	    g.fillOval(x[i], y[i], 40, 40);    	  
    	    g.drawString(""+i, x[i], y[i]);
        }
    }  
    
}