import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                JFrame f = new JFrame("Ortografia 2.0");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                OrtographyPanel panel = new OrtographyPanel();
                f.add(panel);
                f.setSize(panel.getPreferredSize());
                ExecutorService exec = Executors.newSingleThreadExecutor();
                exec.execute(panel);
                exec.shutdown();
                f.setVisible(true);
            }
        });

    }
}
