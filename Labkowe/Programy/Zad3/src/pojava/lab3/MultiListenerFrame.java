package pojava.lab3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MultiListenerFrame extends JFrame implements ActionListener {
	
	static final int SLIDER_MIN = -100;
	static final int SLIDER_MAX = 100;
	static final int SLIDER_INIT = 0;

	JSlider slider;
	JLabel label;
	

	static final String[] COLOR_NAMES = {"czerwony", "zielony", "niebieski"};
	static final Color[] COLORS = {Color.red, Color.green, Color.blue};
	static final Color INIT_COLOR = COLORS[0];
	
	JRadioButton radioButton1;
	JRadioButton radioButton2;
	JRadioButton radioButton3;

	public MultiListenerFrame() throws HeadlessException {
		this.setSize(800,150);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new FlowLayout());
		//slider
		slider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT);
		this.add(slider, BorderLayout.PAGE_START);
		
		label = new JLabel(String.format("%d", slider.getValue()));
		this.add(label);
		
		slider.addChangeListener(new SliderChangeListener());
		
		
		//combobox
		String[] colors = {"czerwony", "zielony", "niebieski"};
		JComboBox<String> colorList = new JComboBox<String>(colors);
		this.add(colorList, BorderLayout.PAGE_END);
        this.getContentPane().setBackground(Color.red);

		colorList.addItemListener(new ComboBoxItemListener((JPanel)this.getContentPane()));

		//checkboxy
        this.getContentPane().setBackground(INIT_COLOR);
				
		radioButton1 = new JRadioButton(COLOR_NAMES[0]);
		radioButton1.setActionCommand("0");
		radioButton1.setBackground(INIT_COLOR);
		radioButton1.addActionListener(this);
		radioButton1.setSelected(true);
		this.add(radioButton1);
		
		radioButton2 = new JRadioButton(COLOR_NAMES[1]);
		radioButton2.setActionCommand("1");
		radioButton2.setBackground(INIT_COLOR);
		radioButton2.addActionListener(this);
		this.add(radioButton2);
		
		radioButton3 = new JRadioButton(COLOR_NAMES[2]);
		radioButton3.setActionCommand("2");
		radioButton3.setBackground(INIT_COLOR);
		radioButton3.addActionListener(this);
		this.add(radioButton3);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radioButton1);
		group.add(radioButton2);
		group.add(radioButton3);
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Color newColor;
		int colorNumber = Integer.parseInt(arg0.getActionCommand());
		this.getContentPane().setBackground(COLORS[colorNumber]);
		radioButton1.setBackground(COLORS[colorNumber]);
		radioButton2.setBackground(COLORS[colorNumber]);
		radioButton3.setBackground(COLORS[colorNumber]);
	}

	public class SliderChangeListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent arg0) {
			String value = String.format("%d", slider.getValue());
			label.setText(value);
		}

	}

	public static void main(String[] args) {
		MultiListenerFrame frame = new MultiListenerFrame();
		frame.setVisible(true);

	}

}
