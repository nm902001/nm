/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medical.store;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddNewSupplier extends JFrame implements ActionListener{

    JFrame jf;
    JTextField t1,t2,t3,t4,t5;
    JLabel l1,l2,l3,l4,l5,l6;
    JButton b1,b2;
    Connection con;
    AddNewSupplier()
    {
        jf=new JFrame();
	jf.setLayout(null);

	l5=new JLabel("New Supplier details");
	l5.setFont(new Font("Times New Roman",Font.BOLD,25));
	l5.setBounds(250,50,300,40);
        l5.setForeground(Color.blue);
	jf.add(l5);
        
        l6=new JLabel("Supplier ID");
        l6.setBounds(150,120,170,25);
        jf.add(l6);
        t5=new JTextField(20);
        t5.setBounds(320,120,200,25);
        jf.add(t5);
        l1 = new JLabel("Supplier name*");
        l1.setBounds(150,160,170,25);
	jf.add(l1);
        
        t1=new JTextField(20);
	t1.setBounds(320,160,200,25);
	jf.add(t1);

	l2 = new JLabel("Supplier address*");
        l2.setBounds(150,200,170,25);
	jf.add(l2);

	t2=new JTextField(20);
	t2.setBounds(320,200,250,25);
	jf.add(t2);

	l3 = new JLabel("Supplier phone no*");
        l3.setBounds(150,240,170,25);
	jf.add(l3);

	t3=new JTextField(20);
	t3.setBounds(320,240,100,25);
	jf.add(t3);

	l4 = new JLabel("Supplier email id*");
        l4.setBounds(150,280,170,25);
	jf.add(l4);

	t4=new JTextField(20);
	t4.setBounds(320,280,200,25);
	jf.add(t4);

	b1 = new JButton("Save",new ImageIcon("images//save.png"));
        b1.setBounds(150,330,110,35);
	jf.add(b1);
        b1.addActionListener(this);

	b2 = new JButton("Clear",new ImageIcon("images//clear.png"));
	b2.setBounds(300,330,110,35);
	jf.add(b2); 
        b2.addActionListener(this);
        
         jf.setTitle("Add New Supplier");
	 jf.setSize(900,700);
	 jf.setLocation(20,20);
	 jf.setResizable(false);
	 jf.getContentPane().setBackground(Color.cyan);
	 jf.setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("Save")){
            try {
                con=DriverManager.getConnection("jdbc:ucanaccess://E://db/medicalDB.accdb");
                PreparedStatement ps = con.prepareStatement("insert into supplier values(?,?,?,?,?)");
                ps.setString(1,t1.getText());
                ps.setString(2,t2.getText());
                ps.setString(3,t3.getText());
                ps.setString(4,t4.getText());
                ps.setString(5,t5.getText());
                if(ps.executeUpdate()==1){
                    JOptionPane.showMessageDialog(this,"Record have been succesfully added","success",JOptionPane.INFORMATION_MESSAGE);
                    resetAll();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,ex.getMessage(),"Inane error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(ae.getActionCommand().equals("Clear")){
            resetAll();
        }
    }
    private void resetAll()
    {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
    }
    public static void main(String args[])
	{
          new AddNewSupplier();

	}
}
