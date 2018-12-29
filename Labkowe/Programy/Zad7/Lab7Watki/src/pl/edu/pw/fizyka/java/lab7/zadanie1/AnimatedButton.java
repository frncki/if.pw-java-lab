package pl.edu.pw.fizyka.java.lab7.zadanie1;


import javax.swing.JPanel;
import javax.swing.JButton;

public class AnimatedButton extends JButton implements Runnable {

    private String[] text = { "Can't", "touch", "this", "yeah!" };
    private int pause = 1000;
    private boolean active = true;
    private JPanel panel;

    AnimatedButton() {
        super();
    }

    AnimatedButton(int pauza, JPanel panel) {
        this.pause = pauza;
        this.panel = panel;
    }

    AnimatedButton(String[] tekst, int pauza, JPanel panel) {
        this.text = tekst;
        this.pause = pauza;
        this.panel = panel;
    }

    AnimatedButton (String[] tekst, int pauza) {
        this.text = tekst;
        this.pause = pauza;
    }

    @Override
    public void run() {

        int i = 0;

        while (active) {

            if (i < text.length - 1)
                i++;
            else
                i = 0;

            setText(text[i]);


            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



}