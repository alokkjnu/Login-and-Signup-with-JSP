package swing_demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Update {
	
	Update(){
		JFrame f=new JFrame();
		JButton b=new JButton("Update");
		JLabel l1,l2,l3,l4;
		JTextField t1,t2,t3,t4;
		l1=new JLabel("id");
		l1.setBounds(50,100,200,30);
		t1=new JTextField();
		t1.setBounds(100,100,200,30);
		l2=new JLabel("name");
		l2.setBounds(50,150,200,30);
		t2=new JTextField();
		t2.setBounds(100,150,200,30);
		l3=new JLabel("desc");
		l3.setBounds(50,200,200,30);
		t3=new JTextField();
		t3.setBounds(100,200,200,30);
		l4=new JLabel("price");
		l4.setBounds(50,250,200,30);
		t4=new JTextField();
		t4.setBounds(100,250,200,30);
		b.setBounds(100,300,100,30);
		
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(l4);
		f.add(t4);
		f.add(b);
		
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(600, 600);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String value1 = t1.getText();
				String value2 = t2.getText();
				String value3=t3.getText();
				String value4=t4.getText();
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trimeals","root","");
					Statement smt=con.createStatement();
					smt.executeUpdate("UPDATE menus set name='"+value2+"', descriptions='"+value3+"', price='"+value4+"' where id='"+value1+"'");
					//smt.executeUpdate("insert into menus(name,descriptions,price) values('"+value1+"','"+value2+"','"+value3+"')");
					JOptionPane.showInputDialog(this, "Menu updated Successfully");
				
				}catch(Exception re){System.out.println(re);}
				
			}
		});
		
		
		
		
	}

	public static void main(String[] args) {
		new Update();
	}

}
