package swing_demo;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login {
		
		Login(){
			
		JFrame f=new JFrame("Login Form");
		JTextField t4;
		JPasswordField t5;
		String users[]={"Admin","Employee"};
		JComboBox cb=new JComboBox(users);
		JLabel l1=new JLabel("Email");
		JLabel l2=new JLabel("Password");
		JLabel l3=new JLabel("Login Page");
		l1.setBounds(30, 100, 100, 30);
		f.add(l1);
		l2.setBounds(30,150,100,20);
		f.add(l2);
		l3.setBounds(150, 10, 100, 30);
		f.add(l3);
		t4=new JTextField();
		t5=new JPasswordField();
		JButton b1=new JButton("Login");
		f.add(t4);
		t4.setBounds(100,100,200,30);
		f.add(t5);
		t5.setBounds(100,150,200,30);
		f.add(b1);
		b1.setBounds(100,200,200,30);
		cb.setBounds(100,50,200,30);
		f.add(cb);
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String value1=t4.getText();
				String value2=t5.getText();
				String user1="";
				String pass1="";
				String v1=cb.getSelectedItem().toString();
				if(v1=="Admin"){
					try{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trimeals","root","");
						PreparedStatement ps=con.prepareStatement("select * from admin where email='"+value1+"' and password ='"+value2+"'");
						ResultSet rs=ps.executeQuery();
						
						while(rs.next()){
							user1=rs.getString("email");
							pass1=rs.getString("password");
						}
					
					
					if(value1.equals(user1) && value2.equals(pass1)){
						new AdminPanel();
					}
					}catch(Exception re){System.out.println(re);}
					
				}
							
				else if(v1=="Employee")
					
				{
					try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trimeals","root","");
					PreparedStatement ps=con.prepareStatement("select * from user where email='"+value1+"' and password='"+value2+"'");
					ResultSet rs=ps.executeQuery();
							
					while(rs.next()){
						user1=rs.getString("email");
						pass1=rs.getString("password");
					}
					
					
					if(value1.equals(user1) && value2.equals(pass1)){
						new Welcome();
					}
					else{
						JOptionPane.showInputDialog(this, "incorrect details");
					}
				}
		
					catch(Exception re){System.out.println(re);}
			}
			}
		});
		
		}
		public static void main(String[] args) {
			new Login();
		}
	}


