package pw.java.wyk4.rysowanie;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;

public class RysowanieMysz2 {
    
    public static void main(String[] args) {
    	JFrame f = new JFrame("Kilka obiektow MyPanel() wyswietlanych jednoczesnie");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(3,3,10,10));
        
        // klasa MyPanel zediniowana w przykladzie RysowanieMysz
        // jest dostepna rowniez w tym przykladzie (jak i w calym pakiecie)
        // mozna utowrzyc kilka obiektow tej klasy i kazdy bedzie dzialac niezaleznie
        
        MyPanel[] panele = new MyPanel[9];  // Tablica elementow MyPanel
        
        for (int i=0; i<9; i++){
        	panele[i] = new MyPanel();
        	panele[i].setBackground(new Color(i*12,0,0));
        	f.add(panele[i]);
        }
             
        f.pack();
        f.setVisible(true);    	
    }
}

