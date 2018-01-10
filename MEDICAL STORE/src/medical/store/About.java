/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medical.store;
import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
    
    JFrame jf;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    About()
    {
        jf=new JFrame();
	jf.setLayout(null);

	l1 = new JLabel("Medicine Stock Manangement System");
	l1.setFont(new Font("Times New Roman",Font.BOLD,25));
	l1.setBounds(200,30,600,40);
        l1.setForeground(Color.blue);
	jf.add(l1);
        
        l2 = new JLabel("This System developed by,");
	l2.setBounds(100,150,600,40);
	jf.add(l2);

	l3 = new JLabel("Sfurti Shukla");
	l3.setFont(new Font("Times New Roman",Font.BOLD,18));
	l3.setBounds(300,200,400,40);
        l3.setForeground(Color.red);
	jf.add(l3);

	l4 = new JLabel("Under the guidance of Mr. Shailendra Kumar Sir.");
	l4.setFont(new Font("Times New Roman",Font.BOLD,18));
        l4.setForeground(Color.red);
	l4.setBounds(100,250,800,40);
	jf.add(l4);

	l5 = new JLabel("In this system we can add details of Medicines,Suppliers.");
	l5.setBounds(100,300,800,40);
	jf.add(l5);

	l6 = new JLabel("We can also upadte,delete & search the existing details.");
	l6.setBounds(100,350,800,40);
	jf.add(l6);

	l7 = new JLabel("It is helpfull for stock of Medicine & whrere we placed the medicine in store.");
	l7.setBounds(100,400,800,40);
	jf.add(l7);

        jf.setTitle("About System");
	jf.setSize(900,700);
	jf.setLocation(20,20);
	jf.setResizable(false);
	jf.getContentPane().setBackground(Color.cyan);
	jf.setVisible(true);
    }
    
    public static void main(String args[])
	{
          new About();

	}
}
