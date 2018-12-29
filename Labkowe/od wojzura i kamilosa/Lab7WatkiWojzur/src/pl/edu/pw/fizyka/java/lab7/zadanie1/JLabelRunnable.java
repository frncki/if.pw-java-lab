package pl.edu.pw.fizyka.java.lab7.zadanie1;

import javax.swing.*;
import java.awt.*;

public class JLabelRunnable extends JLabel implements Runnable
{
    String[] tekst = { "To", "jest", "animowany", "przycisk" };
    int pauza = 1000;
    boolean czynny = true;

    JLabelRunnable() {
        super();
    }

    JLabelRunnable(String[] arg1, int arg2) {
        tekst = arg1;
        pauza = arg2;
    }

    @Override
    public void run() {

        int i = 0;

        while (czynny) {

            if (i < tekst.length - 1)
                i++;
            else
                i = 0;

            setText(tekst[i]);
            setBackground(new Color((float)Math.random(),(float)Math.random(),(float)Math.random()));

            try {
                Thread.sleep(pauza);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
