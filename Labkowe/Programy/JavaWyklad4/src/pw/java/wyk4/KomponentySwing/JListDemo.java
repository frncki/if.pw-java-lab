package pw.java.wyk4.KomponentySwing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class JListDemo extends JFrame{

	String[] nazwyDruzyn = { "Legia Warszawa",  "Lech Poznan",  "Polonia Warszawa", 
			 "Slask Wroclaw",  "Gornik Zabrze",  "Lechia Gdansk", "Zaglebie Lubin", 
			 "Piast Gliwice",  "Wisla Krakow", "Jagiellonia Bialystok", "Korona Kielce", 
			 "Widzew Lodz", "Pogon Szczecin", "Ruch Chorzow",  
			 "Podbeskidzie Bielsko-Biala", "GKS Belchatow"};

	DefaultListModel listaElementy = new DefaultListModel();
	JList lista = new JList(listaElementy);
	
	JButton usunElementy = new JButton("Usun wybrane elementy");
	JTextField poleDodawania = new JTextField("Wpisz nowy element i wcisnij ENTER");
	
	ListSelectionListener listaListener = new ListSelectionListener() {
		
		public void valueChanged(ListSelectionEvent e) {
			if (e.getValueIsAdjusting()) return;
			System.out.println("Zaznaczone elementy listy:");
			for (Object wybrane : lista.getSelectedValuesList())
				System.out.println(wybrane);
		}
	};
	
	ActionListener usuwanieElementow = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			for (Object wybrane : lista.getSelectedValuesList())
				listaElementy.removeElement(wybrane);
			
		}
	};
	
	
	ActionListener dodawanieElementow = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			listaElementy.addElement(poleDodawania.getText());
			
		}
	};
	
	public JListDemo() throws HeadlessException {
		super("JTabbedPaneDemo");
		//setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		for (int i=0; i < nazwyDruzyn.length; i++)
			listaElementy.addElement(nazwyDruzyn[i]);
		
		lista.addListSelectionListener(listaListener);
		

		 lista.setVisibleRowCount(5);
	     
		 //Dodawanie JScrollPane:
		 JScrollPane listScrollPane = new JScrollPane(lista);
		 listScrollPane.setPreferredSize( new Dimension(300,100));
	     
	     JPanel panelPrzyciskow = new JPanel (new FlowLayout(FlowLayout.RIGHT));
	     
	     usunElementy.addActionListener(usuwanieElementow);
	     panelPrzyciskow.add(usunElementy);
	     poleDodawania.addActionListener(dodawanieElementow);
	     panelPrzyciskow.add(poleDodawania);
	 	
	     //add(lista, BorderLayout.CENTER);
	     add(listScrollPane, BorderLayout.CENTER);
	     add(panelPrzyciskow, BorderLayout.SOUTH);
	     
	     pack() ;		
	}

	public static void main(String[] args) {
		JFrame f = new JListDemo();
		f.setVisible(true);
	}
	
}