package pw.java.wyk4.gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class LookAndFeelChooser extends JFrame{
   
	
	public LookAndFeelChooser() throws HeadlessException {
        JPanel chooseLFPanel = new JPanel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        chooseLFPanel.setLayout(new FlowLayout());
        
        final UIManager.LookAndFeelInfo[] installedLF = UIManager.getInstalledLookAndFeels();
        
        String[] installedLookandFeelsNames = new String[installedLF.length];
    	      for (int i=0;i<installedLF.length;i++) {
    	    	installedLookandFeelsNames[i] = installedLF[i].getName();  
    	        System.out.println("  " + installedLF[i].getClassName() );
    	      }   	      
    	       
        final JComboBox chooseLFComboBox = new JComboBox(installedLookandFeelsNames);
        chooseLFComboBox.setSelectedItem(UIManager.getLookAndFeel().getName());
        chooseLFComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{          
                	int selectedLFIndex = chooseLFComboBox.getSelectedIndex();
                	UIManager.setLookAndFeel (installedLF[selectedLFIndex].getClassName());
                    SwingUtilities.updateComponentTreeUI(LookAndFeelChooser.this);
                    LookAndFeelChooser.this.pack();
                }catch (Exception e1){
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(LookAndFeelChooser.this, "Blad podczas zmiany LF");
                }
            }
        });
        add(chooseLFComboBox, BorderLayout.NORTH);
        JPanel componentPanel = new JPanel();
        componentPanel.add(new JButton("JButton"));
        componentPanel.add(new JTextField("JTextField"));
        componentPanel.add(new JCheckBox("JCheckBox"));
        componentPanel.add(new JRadioButton("JRadioButton"));
        componentPanel.add(new JLabel("JLabel"));
        componentPanel.add(new JList(new String[]{"JList, poz. 1", "JList, poz. 2", "JList, poz. 3"}));
        componentPanel.add(new JScrollBar(SwingConstants.HORIZONTAL));
        add(componentPanel);
    }
	
    public static void main(String[] args) throws Exception{
        LookAndFeelChooser chooser = new LookAndFeelChooser();
        chooser.setSize(640, 480);
        chooser.setVisible(true);
    }
}

















