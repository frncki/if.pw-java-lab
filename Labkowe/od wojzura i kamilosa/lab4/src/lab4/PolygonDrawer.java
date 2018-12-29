package lab4;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


public class PolygonDrawer extends JFrame implements ActionListener {

    static final int SLIDER_MAX = 23;
    static final int SLIDER_INIT = 10;
    static final int SLIDER_MIN = 3;


    private JPanel topPanel, leftPanel, rightPanel, bottomPanel, numberPanel;
    private CentralPanel centerPanel;
    private JMenuBar menuBar;
    private JLabel numberLabel;
    private JSlider numberSlider;
    private JButton numberButton, backgroundButton, colorButton;
    private JMenu lineWidth;
    private JMenuItem px1, px2, px5, px10, px15;
    private JRadioButton regular, random;
    public Color backgroundColor, lineColor;
    private int lWidth;

    public ArrayList<JTextField> textFieldListX = new ArrayList<JTextField>();
    public ArrayList<JTextField> textFieldListY = new ArrayList<JTextField>();

    public void makeRightPanel(int size) {
        rightPanel = new JPanel(new GridLayout(size + 1, 2));
        rightPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Position"));
        rightPanel.add(new JLabel("      X      "));
        rightPanel.add(new JLabel("      Y      "));
        textFieldListX = new ArrayList<JTextField>();
        textFieldListY = new ArrayList<JTextField>();
        for (int i = 0; i < size; i++) {
            textFieldListX.add(new JTextField());
            textFieldListY.add(new JTextField());
            rightPanel.add(textFieldListX.get(i));
            rightPanel.add(textFieldListY.get(i));
        }
    }

    public void makeArray() {
        Random generator = new Random();
        int tmp[] = new int[numberSlider.getValue()];
        if (random.isSelected()) {
            for (int i = 0; i < numberSlider.getValue(); i++) {
                tmp[i] = (generator.nextInt() % 150) + 150;
                textFieldListX.get(i).setText(Integer.toString(tmp[i]));
                tmp[i] = (generator.nextInt() % 150) + 150;
                textFieldListY.get(i).setText(Integer.toString(tmp[i]));
            }
        } else {
            for (int i = 0; i < numberSlider.getValue(); i++) {
                tmp[i] = (int) (100 * Math.cos((3.14 / 2 + 2 * 3.14 * i) / numberSlider.getValue())) + 150;
                textFieldListX.get(i).setText(Integer.toString(tmp[i]));
                tmp[i] = (int) (100 * Math.sin((3.14 / 2 + 2 * 3.14 * i) / numberSlider.getValue())) + 150;
                textFieldListY.get(i).setText(Integer.toString(tmp[i]));
            }
        }

    }

    public int[] getArray(char c) {
        int tmp[] = new int[numberSlider.getValue()];
        if (c == 'x') {
            for (int i = 0; i < numberSlider.getValue(); i++) {
                tmp[i] = Integer.valueOf(textFieldListX.get(i).getText());
            }
        }
        if (c == 'y') {
            for (int i = 0; i < numberSlider.getValue(); i++) {
                tmp[i] = Integer.valueOf(textFieldListY.get(i).getText());
            }
        }
        return tmp;
    }


    PolygonDrawer() {
        super("Polygon Drawer 1.0.0.1");
        this.setSize(600, 500);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());

        topPanel = new JPanel(new BorderLayout());
        menuBar = new JMenuBar();
        lineWidth = new JMenu("Line width");
        px1 = new JMenuItem("1 px");
        px1.setActionCommand("1");
        px1.addActionListener(this);
        px2 = new JMenuItem("2 px");
        px2.setActionCommand("2");
        px2.addActionListener(this);
        px5 = new JMenuItem("5 px");
        px5.setActionCommand("5");
        px5.addActionListener(this);
        px10 = new JMenuItem("10 px");
        px10.setActionCommand("10");
        px10.addActionListener(this);
        px15 = new JMenuItem("15 px");
        px15.setActionCommand("15");
        px15.addActionListener(this);
        lineWidth.add(px1);
        lineWidth.add(px2);
        lineWidth.add(px5);
        lineWidth.add(px10);
        lineWidth.add(px15);
        menuBar.add(lineWidth);
        topPanel.add(BorderLayout.NORTH, menuBar);
        numberPanel = new JPanel(new FlowLayout());
        numberLabel = new JLabel("Number of vertices");
        numberSlider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT);
        numberSlider.setMajorTickSpacing(5);
        numberSlider.setMinorTickSpacing(1);
        numberSlider.setPaintTicks(true);
        numberSlider.setPaintLabels(true);
        numberSlider.addChangeListener(new SliderChangeListener());
        numberButton = new JButton("Draw");
        numberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PolygonDrawer.super.remove(centerPanel);
                centerPanel = new CentralPanel(getArray('x'), getArray('y'), numberSlider.getValue(), backgroundColor, lineColor, lWidth);
                PolygonDrawer.this.add(BorderLayout.CENTER, centerPanel);
                PolygonDrawer.this.setVisible(true);

            }
        });
        numberPanel.add(numberLabel);
        numberPanel.add(numberSlider);
        numberPanel.add(numberButton);


        topPanel.add(BorderLayout.SOUTH, numberPanel);

        leftPanel = new JPanel(new GridLayout(2, 1));
        leftPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Polygon"));
        regular = new JRadioButton("Regular");
        regular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeArray();
            }
        });
        random = new JRadioButton("Random");
        random.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeArray();
            }
        });
        leftPanel.add(regular);
        leftPanel.add(random);


        makeRightPanel(SLIDER_INIT);

        makeArray();

        backgroundColor = Color.WHITE;
        lineColor = Color.BLACK;
        centerPanel = new CentralPanel(getArray('x'), getArray('x'), numberSlider.getValue(), backgroundColor, lineColor, lWidth);
        bottomPanel = new JPanel(new FlowLayout());
        backgroundButton = new JButton("Background color");
        colorButton = new JButton("Line color");
        bottomPanel.add(backgroundButton);
        backgroundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                centerPanel.setBackground(backgroundColor = JColorChooser.showDialog(null, "Background color", backgroundColor));
            }
        });
        bottomPanel.add(colorButton);
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lineColor = JColorChooser.showDialog(null, "Line color", lineColor);

            }
        });

        this.add(BorderLayout.NORTH, topPanel);
        this.add(BorderLayout.WEST, leftPanel);
        this.add(BorderLayout.CENTER, centerPanel);
        this.add(BorderLayout.EAST, rightPanel);
        this.add(BorderLayout.SOUTH, bottomPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lWidth = Integer.parseInt(e.getActionCommand());
    }

    public class SliderChangeListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent arg0) {
            PolygonDrawer.this.remove(rightPanel);
            makeRightPanel(numberSlider.getValue());
            makeArray();
            PolygonDrawer.this.add(BorderLayout.EAST, rightPanel);
            PolygonDrawer.this.setVisible(true);
        }


    }


    public static void main(String[] args) {
        PolygonDrawer frame = new PolygonDrawer();
        frame.setVisible(true);
    }
}
