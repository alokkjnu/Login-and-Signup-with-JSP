package swing_demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Welcome extends JFrame {
	
	   Welcome(){
		JFrame f =new JFrame();
		JButton b=new JButton("Add");
		b.setBounds(50,100,200,30);
		JButton b1=new JButton("Update");
		b1.setBounds(50,150,200,30);
		JButton b2=new JButton("Delete");
		b2.setBounds(50,200,200,30);
		JButton b3=new JButton("All Items");
		b3.setBounds(50,250,200,30);
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(500,500);
		f.add(b);
		f.add(b1);
		f.add(b2);
		f.add(b3);
	
	    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	    setTitle("Welcome");
	     setSize(500, 500);
	     b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Add();
				
			}
		});
	     b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new Update();
					
				}
			});
	     b2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new Delete();
					
				}
			});
	     b3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						new AllItems();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
	     
	     
	     
	  }
	   public static void main(String[] args) {
		new Welcome();
	}
	 }
