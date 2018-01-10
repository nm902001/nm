/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medical.store;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MEDICALSTORE extends JFrame implements ActionListener {
    JFrame jf;
    JMenuBar mbar;
    JMenu m1,m2,m3,m4,m5;
    JMenuItem m1_1,m1_2,m2_1,m2_2,m2_3,m2_4,m3_1,m4_1,m5_1;
    JLabel l1;
    GridBagLayout gbl;
    
    public MEDICALSTORE()
    {
        jf=new JFrame();
        gbl=new GridBagLayout();
	jf.setLayout(gbl);
        l1= new JLabel("WELCOME TO STOCK MANAGEMENT SYSTEM");
        l1.setFont(new Font("Times New Roman",Font.BOLD,20));
        jf.add(l1);
        
        mbar= new JMenuBar();
        jf.setJMenuBar(mbar);
        
        m1=new JMenu("Supplier");
        mbar.add(m1);
        m1_1=new JMenuItem("Add New Supplier",new ImageIcon("images//addnew.png"));
        m1.add(m1_1);
        m1_2 = new JMenuItem("Search Supplier",new ImageIcon("images//search.png"));
	m1.add(m1_2);
        
        m2=new JMenu("Medicine");
        mbar.add(m2);
        m2_1 = new JMenuItem("Add New Medicine",new ImageIcon("images//addnew.png"));
	m2.add(m2_1);
	m2_2 = new JMenuItem("Search Medicine",new ImageIcon("images//search.png"));
	m2.add(m2_2);
	m2_3 = new JMenuItem("Update Medicine",new ImageIcon("images//update.png"));
	m2.add(m2_3);
	m2_4 = new JMenuItem("Delete Medicine",new ImageIcon("images//delete.png"));
	m2.add(m2_4);
	  
        m4=new JMenu("About");
        mbar.add(m4);
        m4_1 = new JMenuItem("About System",new ImageIcon("images//help.png"));
	m4.add(m4_1);
        
        m5=new JMenu("Exit");
	mbar.add(m5);
        m5_1 = new JMenuItem("Exit",new ImageIcon("images//exit.png"));
	m5.add(m5_1);
        
        m1_1.addActionListener(this);
        m1_2.addActionListener(this);

	m2_1.addActionListener(this);
	m2_2.addActionListener(this);
	m2_3.addActionListener(this);
	m2_4.addActionListener(this);
	
	m4_1.addActionListener(this);
        
	m5_1.addActionListener(this);
        
        jf.setTitle("MEDICAL STORE");
	jf.setLocation(20,20);
	jf.setSize(900,600);
	jf.setResizable(false);
	jf.getContentPane().setBackground(Color.CYAN);
	jf.setVisible(true);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       }
    
    public void actionPerformed(ActionEvent ae)
         {
             if(ae.getSource()==m1_1)
		{
		  new AddNewSupplier();
		}
                else if(ae.getSource()==m1_2)
		{
		 new SearchSupplier(this);
		}
      		else if(ae.getSource()==m2_1)
		{
			new AddNewMedicine();
		}
		else if(ae.getSource()==m2_2)
		{
			new SearchMedicine(this);
		}
		else if(ae.getSource()==m2_3)
		{
			new UpdateMedicine();
		}
		else if(ae.getSource()==m2_4)
		{
			new DeleteMedicine(this);
		}
		else if(ae.getSource()==m4_1)
		{
                    new About();
		}

		else if(ae.getSource()==m5_1)
		{
		  System.exit(0);
		}

         }
    
    public static void main(String[] args) {
        new MEDICALSTORE();
    }   
}