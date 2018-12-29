package pw.java.wyk4.KomponentySwing;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class JEditorPaneDemo extends JFrame{

	  public JEditorPaneDemo() {
			super("JEditorPaneDemo");
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		    setLayout(new BorderLayout());
		    
		    JEditorPane edytor = new JEditorPane();
            edytor.setEditable(false);         
            try
            {       
            	//URL link = new URL( "http://docs.oracle.com/javase/tutorial/uiswing/components/editorpane.html"); 
            	URL link = new URL( "http://www.if.pw.edu.pl/~kperl/");
            	edytor.setPage(link);
            }
            catch(IOException e)
            {
                    edytor.setText("Wyjatek:"+e);
            }
            add(new JScrollPane(edytor));
						
		}

		public static void main(String args[]) 
		{
			JFrame f = new JEditorPaneDemo();
			f.setBounds(100, 100, 800, 800);
			f.setVisible(true);
		}
	}

