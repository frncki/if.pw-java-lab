package pojava.lab6;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {


    public DrawPanel() {
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Drawing"));
    }

}
