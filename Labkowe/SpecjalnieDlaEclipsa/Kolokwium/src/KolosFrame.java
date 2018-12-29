import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KolosFrame extends JFrame implements Runnable {

    private boolean active;
    private boolean write;

    private JPanel upPanel, downPanel;
    //private KolosPanel kPanel;

    //-----------menu-------------
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem saveItem, exitItem;

    JTextArea textArea;

    private JButton eqBtn, valBtn, graphBtn;

    private JTextField aField, bField;

    private JLabel aLabel, bLabel;

    private File file;

    public KolosFrame() {
        super("Kolokwium Franciszek Mirecki");
        this.setSize(800, 600);
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

        saveItem = new JMenuItem("zapisz");
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String textFromPane = textArea.getText();


                    JFileChooser fileChooser = new JFileChooser("out/");
                    int returnVal = fileChooser.showSaveDialog(null);
                    if (returnVal == JFileChooser.APPROVE_OPTION)
                    {
                        file = fileChooser.getSelectedFile();
                    }

                    if (!file.exists()) file.createNewFile();
                    FileWriter out = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(out);
                    bw.write(textFromPane);
                    bw.close();
                    System.out.println("file saved");

                } catch (IOException e2) {
                    e2.printStackTrace();
                }

            }
        });
        menu.add(saveItem);

        exitItem = new JMenuItem("Zamknij");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(exitItem);

        //------------------Panele---------------
        upPanel = new JPanel();
        upPanel.setLayout(new FlowLayout());
        //upPanel.setBackground(Color.BLACK);

        downPanel = new JPanel();
        downPanel.setLayout(new FlowLayout());
        downPanel.setBackground(Color.DARK_GRAY);

        //------------------textArea
        textArea = new JTextArea(30, 60);
        textArea.setText("dziala");
        upPanel.add(textArea);

        //------------------Buttons
        eqBtn = new JButton("Wypisz rownanie");
        eqBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textArea.setText("Rownanie y = " + aField.getText() + " * x + " + bField.getText());
                } catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, "Nieprawne dane", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        valBtn = new JButton("Wypisz wartosci");
        valBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                write = true;
            }
        });

        graphBtn = new JButton("Rysuj wykres");
        graphBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //GraphFrame gFrame = new GraphFrame(Float.parseFloat(aField.getText()), Float.parseFloat(bField.getText()));
                //gFrame.setVisible(true);
            }
        });

        //---------------------------------
        aLabel = new JLabel("a: ");
        aField = new JTextField(10);

        bLabel = new JLabel("b: ");
        bField = new JTextField(10);


        downPanel.add(eqBtn);
        downPanel.add(valBtn);
        downPanel.add(graphBtn);
        downPanel.add(aLabel);
        downPanel.add(aField);
        downPanel.add(bLabel);
        downPanel.add(bField);

        this.add(upPanel, BorderLayout.NORTH);
        this.add(downPanel, BorderLayout.SOUTH);
    }

    @Override
    public void run() {

        while (active) {
            if(write) {
                for (float i = -10; i < 10.1; i += 0.1) {
                    float y = Float.parseFloat(aField.getText()) * i + Float.parseFloat(bField.getText());
                    textArea.setText("x = " + i + ", y = " + y);
                }
            }

            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        KolosFrame frame = new KolosFrame();
        ExecutorService exec = Executors.newFixedThreadPool(1);
        exec.execute(frame);

        frame.setVisible(true);
    }

}
