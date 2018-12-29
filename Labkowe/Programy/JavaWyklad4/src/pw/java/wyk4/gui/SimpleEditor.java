package pw.java.wyk4.gui;

import javax.swing.*;    

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;  

public class SimpleEditor extends JFrame implements ActionListener{    
   
	JMenuBar menuBar;    
	JMenu file,edit,help;    
	JMenuItem cut,copy,paste,selectAll;    
	JEditorPane textEditor;  
	
	SimpleEditor(){    
		super("Okno z menu");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 400);
		
		
		//--------Simple Menu--------------------
		
		menuBar = new JMenuBar();
		file = new JMenu("File");
				
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);	
			}
			
		});
		file.add(exit);
		menuBar.add(file);
		//----------------------------
		
		//-----JEditorPane------------------------
		textEditor = new JEditorPane();
		edit = new JMenu("Edit");
		cut = new JMenuItem("cut");
		copy = new JMenuItem("copy");
		paste = new JMenuItem("paste");
		selectAll = new JMenuItem("selectAll");
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		selectAll.addActionListener(this);
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.addSeparator();
		edit.add(selectAll);
		menuBar.add(edit);
		//------------------------------------------
		
		//------------ Dialog Box----------------
		help = new JMenu("Help");
		JMenuItem info = new JMenuItem("Info");
		info.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
					    "To jest program do modyfikacji tekstu.", "Info",JOptionPane.QUESTION_MESSAGE);
				
			}
			
		});
		help.add(info);
		menuBar.add(help);
		//-----------------------------------------
	
		
		//------------ JColorChooser----------------
		JButton button = new JButton("Color");
	
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				  Color newColor = JColorChooser.showDialog(
		                     null,
		                     "Choose Background Color",
		                     textEditor.getForeground());
				  textEditor.setForeground(newColor);
			}
			
		});
		this.add(button,BorderLayout.SOUTH);
		//-----------------------------------------
		
		
		
		this.add(menuBar);
		this.add(textEditor);
		this.setJMenuBar(menuBar);
		
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cut)
			textEditor.cut();
		if (e.getSource() == paste)
			textEditor.paste();
		if (e.getSource() == copy)
			textEditor.copy();
		if (e.getSource() == selectAll)
			textEditor.selectAll();
	}

	public static void main(String[] args) {
		SimpleEditor menu = new SimpleEditor();
	}
	
	
	
}