//Franciszek Mirecki

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoprawaFrame extends JFrame implements Runnable {

    private boolean active;
    private boolean write;
    private int ii;

    private JPanel upPanel, downPanel, rightPanel;
    private GraphPanel graphPanel;

    //-----------menu-------------
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem saveItem, clearItem;

    private JTextArea textArea;
    private JScrollPane scroll;

    private JButton addBtn, randBtn;

    private JTextField xField, yField;

    private JLabel xLabel, yLabel;

    private File file;

    private float x, y;


    public PoprawaFrame() {
        super("Kolokwium Franciszek Mirecki");
        this.setSize(1400, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);

        active = true;
        write = false;

        //------------------Menu
        this.setJMenuBar(menuBar= new JMenuBar());
        menu = new JMenu("Menu");
        menuBar.add(menu);

        saveItem = new JMenuItem("Zapisz");
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JFileChooser fileChooser = new JFileChooser();
                    int returnVal = fileChooser.showSaveDialog(null);
                    if (returnVal == JFileChooser.APPROVE_OPTION)
                    {
                        file = fileChooser.getSelectedFile();
                    }
                    if (!file.exists()) file.createNewFile();
                    graphPanel.saveGraph(file);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }

            }
        });
        menu.add(saveItem);

        clearItem = new JMenuItem("Wyczyść");
        clearItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Na pewno?", "Wyczyść", dialogButton);
                if(dialogResult == 0) {
                    textArea.setText("");
                    graphPanel.clearGraph();
                }
            }
        });
        menu.add(clearItem);

        //------------------Panele---------------
        upPanel = new JPanel();
        upPanel.setLayout(new FlowLayout());

        downPanel = new JPanel();
        downPanel.setLayout(new GridLayout(1, 2));

        graphPanel = new GraphPanel();

        rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout());

        //------------------textArea
        textArea = new JTextArea(30, 40);
        textArea.setText("Witamy w programie!");
        textArea.setEditable(false);
        scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        rightPanel.add(scroll);

        //------------------Buttons
        addBtn = new JButton("Dodaj punkt");
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    x = Float.parseFloat(xField.getText());
                    y = Float.parseFloat(yField.getText());
                    textArea.append("\nDodano punkt x = " + x + " y = " + y);
                    graphPanel.addPoint(x, y);
                } catch(NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Nieprawne dane", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        randBtn = new JButton("Losuj 10 punktow");
        randBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ii = 0;
                write = true;
            }
        });

        //---------------------------------
        xLabel = new JLabel("x: ");
        xField = new JTextField(10);

        yLabel = new JLabel("y: ");
        yField = new JTextField(10);

        upPanel.add(xLabel);
        upPanel.add(xField);
        upPanel.add(yLabel);
        upPanel.add(yField);
        upPanel.add(addBtn);
        upPanel.add(randBtn);

        downPanel.add(graphPanel);
        downPanel.add(rightPanel);

        this.add(upPanel, BorderLayout.NORTH);
        this.add(downPanel, BorderLayout.CENTER);
    }

    @Override
    public void run() {
        while (active) {
            if(write) {
                Random rand = new Random();
                float randX = rand.nextFloat();
                float randY = rand.nextFloat();
                graphPanel.addPoint(randX, randY);
                textArea.append("\nWylosowano punkt " + "x = " + randX + ", y = " + randY);
                ii++;
                if(ii > 9) write = false;
            } try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        PoprawaFrame frame = new PoprawaFrame();
        ExecutorService exec = Executors.newFixedThreadPool(1);
        exec.execute(frame);
        frame.setVisible(true);
    }

}
