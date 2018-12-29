package pw.java.wyk4.KomponentySwing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JOptionPaneDemo extends JFrame{

	  JLabel etykieta = new JLabel();
	  
	  JButton b1 = new JButton("Dialog Tak/Nie/Anuluj");
	  JButton b2 = new JButton("Komunikat bledu");
	  JButton b3 = new JButton("Dialog z wlasnymi opisem");
	  JButton b4 = new JButton("Dialog z wyborem");
	  JButton b5 = new JButton("Ostrzezenie");
	  JButton b6 = new JButton("Dialog z wprowadzaniem");
	  JButton b7 = new JButton("Zamknij");
	  	
	  static JFrame f = new JOptionPaneDemo();
	  
	  public JOptionPaneDemo() {
			super("JOptionPaneDemo");
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		    setLayout(new FlowLayout());
		    
		    add(b1);
		    add(b2);
		    add(b3);
		    add(b4);
		    add(b5);
		    add(b6);
		    add(b7);
		    add(etykieta);
					
		    b1.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					 int n = JOptionPane.showConfirmDialog(
	                            getParent(), "Tresc pytania?",
	                            "Tytul okna z pytaniem",
	                            JOptionPane.YES_NO_OPTION);
					 
					 if (n == JOptionPane.YES_OPTION) {
						 etykieta.setText("Wybrano TAK");} 
					 else if (n == JOptionPane.NO_OPTION) {
						 etykieta.setText("Wybrano NIE");
	                  } 
					 else {
	                	  etykieta.setText("Nic nie wybrano - zamknieto okno");
	                 }
				}
			});
		    
		    
		    b2.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					 JOptionPane.showMessageDialog(
	                            f, "Komunikat bledu!",
	                            "Tytul okna z komunikatem bledu",
	                            JOptionPane.ERROR_MESSAGE);
					
				}
			});
		    
		    
		    b3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Object[] options = {"Oczywiscie",
                            "Zdecydowanie nie",
                            "Innym razem..."};
			        int n = JOptionPane.showOptionDialog(f,
			                        "Pytanie z opcjami wyboru Tak/Nie/Anuluj "
			                        + "z wlasnym opisem przyciskow",
			                        "Tytul okna z pytaniem...",
			                        JOptionPane.YES_NO_CANCEL_OPTION,
			                        JOptionPane.QUESTION_MESSAGE,
			                        null,
			                        options,
			                        options[2]);
			        if (n == JOptionPane.YES_OPTION) {
			        	etykieta.setText("Wybrano: Oczywiscie");
			        } else if (n == JOptionPane.NO_OPTION) {
			        	etykieta.setText("Wybreano: Zdecydowanie nie");
			        } else if (n == JOptionPane.CANCEL_OPTION) {
			        	etykieta.setText("Wybrano: Innym razem...");
			        } else {
			        	etykieta.setText("Nic nie wybrano");
			        }	
								
				}
			});
		    
		    
		    b4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					Object[] wartosciWyboru = { "Opcja1", "Opcja2", "Opcja3" };
					Object selectedValue = JOptionPane.showInputDialog( JOptionPaneDemo.this, 
							"Wybierz jedna opcje:", 
							"Tytul okno wprowadzania",
							JOptionPane.INFORMATION_MESSAGE, null,
							wartosciWyboru, wartosciWyboru[0]);
					
					etykieta.setText((String)selectedValue);
				}
			});
		    
		    
		    b5.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					 JOptionPane.showMessageDialog(null,
                             "Komunikat okna z ostrzezeniem" +
                              "\n\n Podobnie jak pozostale okna" +
                              " moze zawierac kilka linii... " ,
                             "Tytul ostrzezenia",
                             JOptionPane.WARNING_MESSAGE);					
				}
			});
		    
		    
		    b6.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					String s = (String)JOptionPane.showInputDialog(
                            f,
                            "Wpisz jakis tekst:\n",
                            "Tytul okna...",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            null,
                            "tekst domyslny");
					
					JOptionPane.showMessageDialog(f, "Wpisales: \n" + s);
					 
				}
			});
		    
		    b7.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					int n = JOptionPane.showConfirmDialog(
                            f, "Na pewno zakonczyc?",
                            "Potwierdzenie zakonczenia programu",
                            JOptionPane.YES_NO_OPTION);
		
					if (n == JOptionPane.YES_OPTION) 
			        	dispose();	
				}
			});
		    
		}

		public static void main(String args[]) 
		{
			
			f.setBounds(100, 100, 400, 200);
			f.setVisible(true);
		}
	}

