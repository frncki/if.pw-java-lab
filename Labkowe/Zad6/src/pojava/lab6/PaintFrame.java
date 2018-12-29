package pojava.lab6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class PaintFrame extends JFrame implements ActionListener {



    private JPanel topPanel;
    private JPanel upPanel;
    private JPanel botPanel;
    private DrawPanel midPanel;

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem saveItem, addImgItem;

    //of upPanel
    private JButton lineButton;
    private JButton curveButton;
    private JButton emptyRectButton;
    private JButton filledRectButton;
    private JButton eraserButton;

    //of bottomPanel
    private JButton colorButton;
    private JSlider widthSlider;
    private JLabel sliderLabel;
    private JButton clearButton;

    //of midPanel


    //---------------------------------------------------
    private Color lineColor;
    private int lineWidth;

    static final int SLIDER_MIN = 1;
    static final int SLIDER_MAX = 15;
    static final int SLIDER_INIT = 2;

    private Color MINE_COLOR = new Color(51,51,51);

    public PaintFrame(String title) {
        super(title);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);

        lineColor = Color.BLACK;
        lineWidth = SLIDER_INIT;

        //of topPanel
        topPanel = new JPanel();
        topPanel.setBackground(MINE_COLOR);
        topPanel.setLayout(new BorderLayout());

        //Menu
        menuBar= new JMenuBar();
        menuBar.setBackground(MINE_COLOR);

        menu = new JMenu("Options");
        menuBar.add(menu);

        saveItem = new JMenuItem("Save");
        saveItem.setActionCommand("save");
        saveItem.addActionListener(this);
        menu.add(saveItem);

        addImgItem = new JMenuItem("Add image from file or URL");
        addImgItem.setActionCommand("add");
        addImgItem.addActionListener(this);
        menu.add(addImgItem);

        topPanel.add(menuBar, BorderLayout.NORTH);

        //of upPanel
        upPanel = new JPanel();
        upPanel.setBackground(MINE_COLOR);
        upPanel.setLayout(new FlowLayout());

        lineButton = new JButton("Line");
        curveButton = new JButton ("Curve");
        emptyRectButton = new JButton ("Empty Rectangle");
        filledRectButton = new JButton ("Empty Rectangle");
        eraserButton = new JButton ("Eraser");

        upPanel.add(lineButton);
        upPanel.add(curveButton);
        upPanel.add(emptyRectButton);
        upPanel.add(filledRectButton);
        upPanel.add(eraserButton);

        topPanel.add(upPanel, BorderLayout.SOUTH);

        //of bottomPanel
        botPanel = new JPanel();
        botPanel.setBackground(MINE_COLOR);
        botPanel.setLayout(new FlowLayout());

        colorButton = new JButton("Color Chooser");
        colorButton.addActionListener(this);

        widthSlider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT);
        widthSlider.addChangeListener(new changeListener());

        sliderLabel = new JLabel(String.format("%d", widthSlider.getValue()));
        sliderLabel.setForeground(Color.white);

        clearButton = new JButton ("Clear All");
        clearButton.addActionListener(this);

        botPanel.add(colorButton);
        botPanel.add(widthSlider);
        botPanel.add(sliderLabel);
        botPanel.add(clearButton);

        //of midPanel
        midPanel = new DrawPanel();




        this.add(topPanel, BorderLayout.NORTH);
        this.add(botPanel, BorderLayout.SOUTH);
        this.add(midPanel, BorderLayout.CENTER);
    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
        Object action = arg0.getSource();

        if (action == saveItem) {

        }

        if (action == addImgItem) {

        }

        if (action == lineButton) {

        }

        if (action == curveButton) {

        }

        if (action == emptyRectButton) {

        }

        if (action == filledRectButton) {

        }

        if (action == eraserButton) {

        }

        if (action == colorButton) {
            lineColor = JColorChooser.showDialog(null, "Line color", lineColor);;
        }

        if (action == clearButton) {
            PaintFrame.super.remove(midPanel);
            midPanel = new DrawPanel();
        }

    }

    public class changeListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent arg0) {
            lineWidth = widthSlider.getValue();
            sliderLabel.setText(String.format("%d", widthSlider.getValue()));
        }
    }
}
