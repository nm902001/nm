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

public class SearchSupplier extends JDialog implements ActionListener {

    //JFrame jf;
    JTextField t1;
    JLabel l1,l2;
    JButton b1,b2;
    Connection con;
    
    SearchSupplier(JFrame fr)
    {
        super(fr,"search Dialog",true);
        setLayout(new FlowLayout());
        setSize(250,150);
        setLocation(300,170);

        l2=new JLabel("Search Supplier");
	add(l2);
        
        l1= new JLabel("Enter supplier id *");
        add(l1);

	t1=new JTextField(20);
	add(t1);

        b1 = new JButton("Search",new ImageIcon("images//search.png"));
        add(b1);
        b1.addActionListener(this);

	b2 = new JButton("Clear",new ImageIcon("images//clear.png"));
	add(b2);
        b2.addActionListener(this);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
     
        if(ae.getActionCommand().equals("Search"))
        {
            try {
                String str=t1.getText()+" Exist Supplier Name: ";
                int flag=0;
                con=DriverManager.getConnection("jdbc:ucanaccess://E://db/medicalDB.accdb");
                PreparedStatement ps=con.prepareStatement("select S_Name from supplier where S_ID=(?)");
                ps.setString(1,t1.getText());
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                    flag=1;
                    str+=rs.getString(1)+" ";
                }
                
                if(flag!=0)
                {
                    JOptionPane.showMessageDialog(this,str,"success",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(this,"No record founds","fail",JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SearchSupplier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(ae.getActionCommand().equals("Clear")){
            t1.setText("");
        }
    }

}