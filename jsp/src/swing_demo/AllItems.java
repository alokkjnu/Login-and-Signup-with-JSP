package swing_demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AllItems {
	
	
	AllItems() throws Exception{
		
		
		
		JFrame f=new JFrame();
		JButton b=new JButton("Show Menu");
		JLabel l1,l2,l3,l4;
		JTextField t1,t2,t3,t4;
		l1=new JLabel("id");
		l1.setBounds(50,100,200,30);
		t1=new JTextField();
		t1.setBounds(200,100,200,30);
		l2=new JLabel("name");
		l2.setBounds(50,150,200,30);
		t2=new JTextField();
		t2.setBounds(200,150,200,30);
		l3=new JLabel("descriptions");
		l3.setBounds(50,200,200,30);
		t3=new JTextField();
		t3.setBounds(200,200,200,30);
		l4=new JLabel("price");
		l4.setBounds(50,250,200,30);
		t4=new JTextField();
		t4.setBounds(200,250,200,30);
		b.setBounds(100,300,100,30);
		
		JTable tb=new JTable(1,4);
		tb.setBounds(500,100,400,150);
		
		f.add(l1);
		f.add(t1);
		f.add(l2);
		f.add(t2);
		f.add(l3);
		f.add(t3);
		f.add(l4);
		f.add(t4);
		f.add(b);
		f.add(tb);
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
		
		try{
			String value1=t1.getText();
			// TODO Auto-generated method stub
			String id1=null;
			String name1=null;
			String descriptions1=null;
			String price1= null;
			
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trimeals","root","");
		Statement smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
		ResultSet rs=smt.executeQuery("select * from menus where id='"+value1+"'");
		//JOptionPane.showInputDialog(this, "Menu is Added Successfully");
		
		DefaultTableModel mo=(DefaultTableModel)tb.getModel();
		
		while(rs.next()){
			String id=rs.getString("id");
			String name=rs.getString("name");
			String descriptions=rs.getString("descriptions");
			String price=rs.getString("price");
			
			
			t1.setText(id);
			t2.setText(name);
			t3.setText(descriptions);
			t4.setText(price);
			
			id1=rs.getString("id");
			name1=rs.getString("name");
			descriptions1=rs.getString("descriptions");
			price1=rs.getString("price");
			
			
//			String name=rs.getString("name");
//			String desc=rs.getString("description");
//			String price=rs.getString("price");
			//System.out.println(rs.getString("id")+ ""+rs.getString("name")+" "+rs.getString("descriptions")+" "+rs.getString("price"));  
		}
		mo.addRow(new Object[]{id1,name1,descriptions1,price1});
		}catch(Exception re){System.out.println(re);}
		
			}
		});
	}
			
	

	public static void main(String[] args)throws Exception {
		new AllItems();
	}

}
