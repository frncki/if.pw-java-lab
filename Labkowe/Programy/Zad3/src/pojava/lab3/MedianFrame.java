package pojava.lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class MedianFrame extends JFrame {

    public JPanel upPanel, downPanel;
    public List<Double> realNumbers;// = new ArrayList<Double>();
    public JTextField field;
    public JLabel outcomeLabel, numbersLabel;
    public JButton addButton, medianButton;
    public double outcome;
    Color MINE_GRAY = new Color(51,51,51);

    public MedianFrame() throws HeadlessException {
        this.setSize(400, 100);
        this.setResizable(false);
        this.setTitle("Median calculator");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);



        //upper Panel
        upPanel = new JPanel();
        upPanel.setLayout(new FlowLayout());
        upPanel.setBackground(MINE_GRAY);
        this.add(upPanel, BorderLayout.NORTH);

        Dimension dim =  Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);


        realNumbers = new ArrayList<Double>();

        field = new JTextField(5);
        upPanel.add(field);

        addButton = new JButton("Add");
        addButton.addActionListener(new ButtonListener());
        upPanel.add(addButton);

        medianButton = new JButton("Median");
        medianButton.addActionListener(new ButtonListener());
        upPanel.add(medianButton);

        outcomeLabel = new JLabel();
        outcomeLabel.setForeground(Color.white);
        outcomeLabel.setFont(outcomeLabel.getFont().deriveFont(outcomeLabel.getFont().getStyle() ^ Font.BOLD));
        upPanel.add(outcomeLabel);

        //bottom Panel
        downPanel = new JPanel();
        downPanel.setLayout(new FlowLayout());
        downPanel.setBackground(MINE_GRAY);
        this.add(downPanel, BorderLayout.CENTER);

        numbersLabel = new JLabel("Numbers: ");
        numbersLabel.setForeground(Color.white);
        downPanel.add(numbersLabel);

    }
    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object action = e.getSource();

            if (action == addButton) {
                Double number = null;
                try {
                    number = Double.parseDouble(field.getText());
                } catch (NumberFormatException exception) {
                    System.out.println("Wrong number format!");
                }
                if(number != null) {
                    realNumbers.add(number);
                    numbersLabel.setText("Numbers: " + realNumbers);
                }

            } else if (action == medianButton) {
                double length = realNumbers.size();
                Collections.sort(realNumbers);
                numbersLabel.setText("Numbers: " + realNumbers);
                if ((length % 2) == 0) {
                    outcome = (realNumbers.get((int)(length/2)) + realNumbers.get((int)(length/2 + 1)))/2;
                } else {
                    outcome = realNumbers.get((int)(Math.floor(length/2)));
                }
                outcomeLabel.setText("   Median: " + outcome);
            }
        }
    }


    public static void main(String[] args) {
        MedianFrame frame = new MedianFrame();
        frame.setVisible(true);
    }

}
