package swing_demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AdminPanel {
	 AdminPanel(){
			
			JFrame f=new JFrame("Login Form");
			JTextField t4;
			JButton b1=new JButton("show users");
			
					
			
			
			JLabel l3=new JLabel("Admin Panel");
			JTable tb=new JTable(1,6);
			tb.setBounds(500,100,400,150);
			
			
			l3.setBounds(150, 100, 200, 30);
			b1.setBounds(50,150,200,30);
			f.add(l3);
			f.add(b1);
			f.add(tb);
			f.setSize(400, 900);
			f.setLayout(null);
			f.setVisible(true);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
			
			try{
				
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trimeals","root","");
			Statement smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
			ResultSet rs=smt.executeQuery("select * from user");
			//JOptionPane.showInputDialog(this, "Menu is Added Successfully");
			
			DefaultTableModel mo=(DefaultTableModel)tb.getModel();
			
			while(rs.next()){
				String id=rs.getString("id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				String password=rs.getString("password");
				String gender=rs.getString("gender");
				String country=rs.getString("country");
				
				

				
				
			
			mo.addRow(new Object[]{id,name,email,password,gender,country});
			}
			}catch(Exception re){System.out.println(re);}
			
				}
				});

		
	}
	
	
	

	public static void main(String[] args) {
	new AdminPanel();

	}

}
