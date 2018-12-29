package pl.edu.pw.fizyka.java.lab10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class H2localClientFrame extends JFrame {
	
	private static final long serialVersionUID = 3210051246365873821L;
	
	JPanel panel;
	JTextField queryTextField;
	JButton queryButton;
	JTextArea outcomeTextArea;
	JScrollPane scroll;
	String query;
	
	public H2localClientFrame() {
		
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Data Base CLient");
		
		Dimension dim =  Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
		
		//----------------------------------------------
		panel = new JPanel();
		Border whiteLine = BorderFactory.createLineBorder(Color.WHITE);
		panel.setBorder(whiteLine);
        TitledBorder title = BorderFactory.createTitledBorder(whiteLine, "Query");
        title.setTitleColor(Color.WHITE);
        panel.setBorder(title);
        panel.setBackground(new Color(51, 51, 51));
        panel.setLayout(new FlowLayout());
        
        queryTextField = new JTextField(50);
        
        outcomeTextArea = new JTextArea();
        outcomeTextArea.setEditable(false);
        
        scroll = new JScrollPane(outcomeTextArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        
        queryButton = new JButton("ask");
        queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				query = queryTextField.getText();
				Connection conn = null;
				try {
					conn = DriverManager.getConnection(	"jdbc:h2:./data/nazwabazy", "sa", "");
					Statement statement = conn.createStatement();
					statement.execute(query);
							
					ResultSet rs = statement.getResultSet();
							
					ResultSetMetaData md  = rs.getMetaData();
					
					for (int ii = 1; ii <= md.getColumnCount(); ii++){
						String buff = outcomeTextArea.getText();
						outcomeTextArea.setText(buff+ md.getColumnName(ii)+ " | ");
								
					}
					
					String buff1 = outcomeTextArea.getText();
					outcomeTextArea.setText(buff1 + "\n");
					
					while (rs.next()) {
						for (int ii = 1; ii <= md.getColumnCount(); ii++){
							String buff = outcomeTextArea.getText();
							outcomeTextArea.setText(buff + rs.getObject(ii) + " | ");
						}
						String buff2 = outcomeTextArea.getText();
						outcomeTextArea.setText(buff2 + "\n");
								
					}
					
				} catch (SQLException e) {
					if (conn!= null){
						try {
							conn.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
        });
        
        panel.add(queryTextField);
        panel.add(queryButton);
        
        this.add(panel, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER);
	}

	public static void main(String[] args) throws SQLException {
			H2localClientFrame f = new H2localClientFrame();
			f.setVisible(true);
	}

}
