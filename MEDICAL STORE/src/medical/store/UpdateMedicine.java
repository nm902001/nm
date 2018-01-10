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
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateMedicine extends JFrame implements ActionListener {
    
    JFrame jf;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JButton b0,b1,b2;
    JComboBox msname,tabtype;
    Connection con;
    UpdateMedicine()
    {
        jf=new JFrame();
        jf.setLayout(null);
        
        
        l13=new JLabel("Update Medicine");
	l13.setFont(new Font("Times New Roman",Font.BOLD,25));
	l13.setForeground(Color.blue);
	l13.setBounds(300,30,300,40);
	jf.add(l13);

        l1 = new JLabel("Medicine Batch no*");
        l1.setBounds(50,100,200,25);
	jf.add(l1);

	t1 = new JTextField(20);
	t1.setBounds(250,100,100,25);
	jf.add(t1);

	l2 = new JLabel("Medicine name");
        l2.setBounds(50,140,200,25);
	jf.add(l2);

    	t2 = new JTextField(20);
	t2.setBounds(250,140,200,25);
	jf.add(t2);

	l3 = new JLabel("Medicine company");
        l3.setBounds(50,180,200,25);
	jf.add(l3);

     	t3 = new JTextField(20);
	t3.setBounds(250,180,200,25);
	jf.add(t3);

	l4 = new JLabel("Medicine quantity");
        l4.setBounds(50,220,200,25);
    	jf.add(l4);

        t4= new JTextField(20);
	t4.setBounds(250,220,100,25);
	jf.add(t4);

	l5= new JLabel("Med expiry date");
        l5.setBounds(50,260,250,25);
	jf.add(l5);

	t5= new JTextField(20);
	t5.setBounds(250,260,100,25);
	jf.add(t5);

	l6= new JLabel("Med purchase date");
        l6.setBounds(50,300,260,25);
    	jf.add(l6);

        t6= new JTextField(20);
	t6.setBounds(250,300,100,25);
	jf.add(t6);

	l7 = new JLabel("Medicine type");
        l7.setBounds(470,100,200,25);
    	jf.add(l7);

    	tabtype=new JComboBox();
        tabtype.addItem("--type--");
	tabtype.addItem("Tablet");
	tabtype.addItem("Capsule");
	tabtype.addItem("Syrup");
	tabtype.addItem("Insulin");
	tabtype.addItem("Cream");
	tabtype.addItem("Balm");
	tabtype.addItem("Drop");
	tabtype.addItem("Granul");
	tabtype.addItem("Oil");
	tabtype.addItem("Powder");
	tabtype.setBounds(720,100,100,25);
	jf.add(tabtype);
		
	l8= new JLabel("Medicine purchase price");
        l8.setBounds(470,140,220,25);
    	jf.add(l8);

        t8 = new JTextField(20);
	t8.setBounds(720,140,100,25);
	jf.add(t8);

	l9 = new JLabel("Medicine sale price");
        l9.setBounds(470,180,200,25);
    	jf.add(l9);

        t9 = new JTextField(20);
	t9.setBounds(720,180,100,25);
	jf.add(t9);

	l10 = new JLabel("Medicine rack no");
        l10.setBounds(470,220,200,25);
    	jf.add(l10);

        t10 = new JTextField(20);
	t10.setBounds(720,220,100,25);
	jf.add(t10);

	l12 = new JLabel("Supplier id");
	l12.setBounds(470,260,180,25);
    	jf.add(l12);

    	t12 = new JTextField(20);
	t12.setBounds(720,260,100,25);
	jf.add(t12);
        
        b0 = new JButton("Open",new ImageIcon("images//open.png"));
        b0.setBounds(150,330,110,35);
	jf.add(b0);
        b0.addActionListener(this);
        
	b1 = new JButton("Update",new ImageIcon("images//update.png"));
	b1.setBounds(300,330,110,35);
	jf.add(b1); 
        b1.addActionListener(this);

        b2= new JButton("Clear",new ImageIcon("images//clear.png"));
	b2.setBounds(450,330,110,35);
	jf.add(b2); 
        b2.addActionListener(this);
        
        jf.setTitle("Update Medicine");
	jf.setSize(900,700);
        jf.setLocation(20,20);
	jf.setResizable(false);
	jf.getContentPane().setBackground(Color.cyan);
	jf.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("Open"))
        {
            if(((t1.getText()).equals("")))
	        {
		    JOptionPane.showMessageDialog(this,"Medicine is not available !","Warning!!!",JOptionPane.WARNING_MESSAGE);
	        }
            else
          {
            try {
                int flag=0;
                con=DriverManager.getConnection("jdbc:ucanaccess://E://db/medicalDB.accdb");
                PreparedStatement ps=con.prepareStatement("select * from medicine where M_BatchNo=(?)");
                ps.setString(1,t1.getText());
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                    t2.setText(rs.getString(2));
                    t3.setText(rs.getString(3));
                    t4.setText(rs.getString(4));
		    tabtype.setSelectedItem(rs.getString(5));
		    t8.setText(rs.getString(6));
                    t9.setText(rs.getString(7));
                    t10.setText(rs.getString(8));
                    t5.setText(rs.getString(9));
		    t6.setText(rs.getString(10));
		    t12.setText(rs.getString(1));
                    
                    flag=1;
                    t1.setEditable(false);
                    
                }
                if(flag==0)
                {
                    JOptionPane.showMessageDialog(null,"Record is not available","Dialogs",JOptionPane.WARNING_MESSAGE);
                    
                }
                
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SearchMedicine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       }
       
        else if(ae.getActionCommand().equals("Update"))
        {
            if(((t1.getText()).equals("")))
	        {
		    JOptionPane.showMessageDialog(this,"Medicine is not available !","Warning!!!",JOptionPane.WARNING_MESSAGE);
	        }
            else
          {
           try
           {
               con=DriverManager.getConnection("jdbc:ucanaccess://E://db/medicalDB.accdb");
               PreparedStatement ps=con.prepareStatement("update medicine set M_SupplierID=(?),M_Name=(?),M_Company=(?),M_Quantity=(?),M_ExpiryDate=(?),M_PurchaseDate=(?),M_Type=(?),M_PurchasePrice=(?),M_SalePrice=(?),M_RackNO=(?) where M_BatchNo=(?)");
               ps.setString(1,t12.getText());
               ps.setString(2,t2.getText());
               ps.setString(3,t3.getText());
               ps.setString(4,t4.getText()); 
               ps.setString(5,t5.getText());
               ps.setString(6,t6.getText());
               ps.setString(7,tabtype.getSelectedItem().toString());
               ps.setString(8,t8.getText());
               ps.setString(9,t9.getText());
               ps.setString(10,t10.getText());
               ps.setString(11,t1.getText());
               if(ps.executeUpdate()==1){
                    JOptionPane.showMessageDialog(this,"Record have been succesfully updated","success",JOptionPane.INFORMATION_MESSAGE);
                    //resetAll();
                }
           }catch(SQLException se)
                {
                    System.out.println(se);
                    JOptionPane.showMessageDialog(null,"SQL Error:"+se);
                }    
          }
        }
        else if(ae.getActionCommand().equals("Clear"))
        {
            t1.setEditable(true);
            t12.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");            
            t5.setText("");
            t6.setText("");
            tabtype.setSelectedIndex(0);
            t8.setText("");
            t9.setText("");
            t10.setText("");
            t1.setText("");
            
        }
    }
    
    public static void main(String args[])
    {
	      new UpdateMedicine();
    }
}
