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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteMedicine extends JDialog implements ActionListener {
         
    JTextField t1;
    JLabel l1;
    JButton b0,b1;
    Connection con; 
    
   public DeleteMedicine(JFrame fr)
    {
        super(fr,"delete Dialog",true);
        
        setLayout(new FlowLayout());
        setSize(250,150);
        setLocation(300,170);
                
        l1 = new JLabel("Medicine Batch no*");
        add(l1);
	t1 = new JTextField(20);
	add(t1);

	b0 = new JButton("Delete",new ImageIcon("images//update.png"));
	add(b0); 
        b0.addActionListener(this);

        b1= new JButton("Clear",new ImageIcon("images//clear.png"));
	add(b1); 
        b1.addActionListener(this);
        setVisible(true);
    }
   
    public void actionPerformed(ActionEvent ae)
    {
     
        if(ae.getActionCommand().equals("Delete"))
        {
            try {
                con=DriverManager.getConnection("jdbc:ucanaccess://E://db/medicalDB.accdb");
                PreparedStatement ps=con.prepareStatement("delete from medicine where M_BatchNo=(?)");
                ps.setString(1,t1.getText());
                ps.executeUpdate();
                
                JOptionPane.showMessageDialog(null,"Record is deleted.");
                t1.setText("");
            } catch(SQLException se)
		{
		System.out.println(se);
	     JOptionPane.showMessageDialog(null,"SQL Error:"+se);
                }
        }
        else if(ae.getActionCommand().equals("Clear")){
            t1.setText("");
    }
   }
}