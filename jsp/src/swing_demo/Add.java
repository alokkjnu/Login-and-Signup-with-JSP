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
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Add {
	
	Add(){
		JFrame f=new JFrame();
		JButton b=new JButton("Add");
		JLabel l1,l2,l3;
		JTextField t1,t2,t3;
		l1=new JLabel("name");
		l1.setBounds(50,100,200,30);
		t1=new JTextField();
		t1.setBounds(100,100,200,30);
		l2=new JLabel("desc");
		l2.setBounds(50,150,200,30);
		t2=new JTextField();
		t2.setBounds(100,150,200,30);
		l3=new JLabel("price");
		l3.setBounds(50,200,200,30);
		t3=new JTextField();
		t3.setBounds(100,200,200,30);
		b.setBounds(100,250,100,30);
		
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(t1);
		f.add(t2);
		f.add(t3);
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
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trimeals","root","");
					Statement smt=con.createStatement();
					smt.executeUpdate("insert into menus(name,descriptions,price) values('"+value1+"','"+value2+"','"+value3+"')");
					JOptionPane.showInputDialog(this, "Menu is Added Successfully");
				
				}catch(Exception re){System.out.println(re);}
				
			}
		});
		
	}

	public static void main(String[] args) {
		new Add();

	}

}
