package pojava.lab4;


import java.awt.*;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class PolyGone extends JFrame implements ActionListener {

	private static final long serialVersionUID = 109197841765991629L;


	//---------------------------------------
    public PolyGone(String arg0) {
        super(arg0);
        this.setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        upPanel = new JPanel();
        upperPanel = new JPanel();
        leftPanel = new JPanel();
        downPanel = new JPanel(new FlowLayout());

        upPanel.setBackground(Color.red);
        upPanel.setLayout(new GridLayout(2, 1));
        this.add(upPanel, BorderLayout.PAGE_START);

        //menu
        menuBar = new JMenuBar();

        menu = new JMenu("Line width");
        menuBar.add(menu);

        menuItem1 = new JMenuItem("1 px");
        menuItem1.setActionCommand("1");
        menuItem1.addActionListener(this);
        menu.add(menuItem1);

        menuItem2 = new JMenuItem("5 px");
        menuItem2.setActionCommand("5");
        menuItem2.addActionListener(this);
        menu.add(menuItem2);
        upPanel.add(menuBar);

        //--------------------------------------------
        upperPanel.setBackground(Color.white);
        upPanel.add(upperPanel);
        upperPanel.setLayout(new FlowLayout());

        leftPanel.setBackground(Color.white);
        this.add(leftPanel, BorderLayout.LINE_START);
        leftPanel.setLayout(new GridLayout(3, 1));




        downPanel.setBackground(Color.white);
        this.add(downPanel, BorderLayout.PAGE_END);
        downPanel.setLayout(new FlowLayout());

        //of upperPanel
        numOfV = new JLabel("Number of apices");
        upperPanel.add(numOfV);

        slider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT);
        slider.setBackground(INIT_COLOR);
        upperPanel.add(slider, BorderLayout.CENTER);

        sliderNum = new JLabel(String.format("%d", slider.getValue()));
        upperPanel.add(sliderNum);
        slider.addChangeListener(new changeListener());

        drawButton = new JButton("Draw");
        upperPanel.add(drawButton);

        //of leftPanel
        leftLabel = new JLabel("Polygon");
        leftPanel.add(leftLabel);

        regularRButton = new JRadioButton("Regular");
        regularRButton.setSelected(true);
        regularRButton.setBackground(INIT_COLOR);
        leftPanel.add(regularRButton);

        randomRButton = new JRadioButton("Random");
        randomRButton.setBackground(INIT_COLOR);
        leftPanel.add(randomRButton);

        ButtonGroup group = new ButtonGroup();
        randomRButton.setSelected(false);
        regularRButton.setSelected(true);
        group.add(regularRButton);
        group.add(randomRButton);

        //of RightPanel

        makeRightPanel(SLIDER_INIT);

        makeArray();

        midPanel = new DrawPanel(getArray('x'), getArray('y'), slider.getValue(), Color.white, lineColor, lineWidth);

        rightPanel.setBackground(Color.white);
        this.add(rightPanel, BorderLayout.LINE_END);
        rightPanel.setLayout(new GridLayout(4, 2));

        //of DownPanel
        lineColor = Color.BLACK;
        backgroundColor = Color.WHITE;

        colorButton = new JButton("Line Color");
        backgroundButton = new JButton("Background Color");
        downPanel.add(colorButton);
        downPanel.add(backgroundButton);
        this.add(downPanel, BorderLayout.PAGE_END);

        drawButton.addActionListener(this);
        randomRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeArray();
            }
        });
        regularRButton.addActionListener(this);
        colorButton.addActionListener(this);
        backgroundButton.addActionListener(this);

    }

    //------------------------------------------------------------

    //------------------------------------------------------------

    @Override
    public void actionPerformed(ActionEvent arg0) {
        Object action = arg0.getSource();

        if (action == menuItem1 || action == menuItem2) {
            lineWidth = Integer.parseInt(arg0.getActionCommand());
        }

        if (action == drawButton) {
            PolyGone.super.remove(midPanel);
            midPanel = new DrawPanel(getArray('x'), getArray('y'), slider.getValue(), Color.white, lineColor, lineWidth);
            PolyGone.this.add(BorderLayout.CENTER, midPanel);
            PolyGone.this.setVisible(true);
        }

        if (action == regularRButton) {
            makeArray();
        }

        if (action == colorButton) {
            lineColor = JColorChooser.showDialog(null, "Line color", lineColor);;
        }

        if (action == backgroundButton) {
            midPanel.setBackground(backgroundColor = JColorChooser.showDialog(null, "Background color", backgroundColor));
        }
    }

    //------------------------------------------------------------
	public class changeListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent arg0) {
		    String value = String.format("%d", slider.getValue());
            PolyGone.this.remove(rightPanel);
            makeRightPanel(slider.getValue());
            makeArray();
            PolyGone.this.add(BorderLayout.EAST, rightPanel);
            PolyGone.this.setVisible(true);
		    sliderNum.setText(value);
		}
	}


    public void makeArray() {
        Random generator = new Random();
        int tmp[] = new int[slider.getValue()];
        if (randomRButton.isSelected()) {
            for (int i = 0; i < slider.getValue(); i++) {
                tmp[i] = (generator.nextInt() % 150) + 150;
                textFieldListX.get(i).setText(Integer.toString(tmp[i]));
                tmp[i] = (generator.nextInt() % 150) + 150;
                textFieldListY.get(i).setText(Integer.toString(tmp[i]));
            }
        } else {
            for (int i = 0; i < slider.getValue(); i++) {
                tmp[i] = (int) (100 * Math.cos((Math.PI / 2 + 2 * Math.PI * i) / slider.getValue())) + 200;
                textFieldListX.get(i).setText(Integer.toString(tmp[i]));
                tmp[i] = (int) (100 * Math.sin((Math.PI / 2 + 2 * Math.PI * i) / slider.getValue())) + 200;
                textFieldListY.get(i).setText(Integer.toString(tmp[i]));
            }
        }

    }

    public int[] getArray(char c) {
        int tmp[] = new int[slider.getValue()];
        if (c == 'x') {
            for (int i = 0; i < slider.getValue(); i++) {
                tmp[i] = Integer.valueOf(textFieldListX.get(i).getText());
            }
        }
        if (c == 'y') {
            for (int i = 0; i < slider.getValue(); i++) {
                tmp[i] = Integer.valueOf(textFieldListY.get(i).getText());
            }
        }
        return tmp;
    }


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

    //---------------------------------------
	static final int SLIDER_MIN = 3;
	static final int SLIDER_MAX = 30;
	static final int SLIDER_INIT = 3;
	static final Color INIT_COLOR = Color.white;


    JPanel upPanel;
	JPanel upperPanel;
	JPanel leftPanel;
	DrawPanel midPanel;
	JPanel rightPanel;
	JPanel downPanel;
	
	//of upperPanel
	JLabel numOfV;
	JSlider slider;
	JLabel sliderNum;
	JButton drawButton;
	
	//of leftPanel
	JLabel leftLabel;
	JRadioButton regularRButton;
	JRadioButton randomRButton;
	
	//of downPanel
    JButton colorButton, backgroundButton;

	//menu
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem1;
    JMenuItem menuItem2;

    Color lineColor;
    Color backgroundColor;
    private int lineWidth;

    public ArrayList<JTextField> textFieldListX = new ArrayList<JTextField>();
    public ArrayList<JTextField> textFieldListY = new ArrayList<JTextField>();

}
