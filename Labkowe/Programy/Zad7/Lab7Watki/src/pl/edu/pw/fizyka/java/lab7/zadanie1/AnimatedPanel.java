package pl.edu.pw.fizyka.java.lab7.zadanie1;

import javax.swing.*;
import java.awt.*;

public class AnimatedPanel extends JPanel implements Runnable {

    private int pause = 1000;
    private boolean active = true;

    AnimatedPanel(int pauza) {
        this.pause = pauza;
    }

    @Override
    public void run() {

        while (active) {

            this.setBackground(new Color((float)Math.random(),(float)Math.random(),(float)Math.random()));

            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
