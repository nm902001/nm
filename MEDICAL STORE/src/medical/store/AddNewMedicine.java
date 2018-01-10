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
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField.AbstractFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
import org.jdatepicker.impl.UtilDateModel;

public class AddNewMedicine extends JFrame implements ActionListener {

    JFrame jf;
    JTextField t1,t2,t3,t4,t5,t6,t8,t9,t10;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JButton b1,b2;
    JComboBox msname,tabtype;
    Connection con;
    JDatePickerImpl datePicker ,datePicker1;
    AddNewMedicine()
	{
		jf=new JFrame();
                jf.setLayout(null);
        try {
            con=DriverManager.getConnection("jdbc:ucanaccess://E://db/medicalDB.accdb");
        } catch (SQLException ex) {
            Logger.getLogger(AddNewMedicine.class.getName()).log(Level.SEVERE, null, ex);
        }
                    l12=new JLabel("New Medicine details");
                    l12.setFont(new Font("Times New Roman",Font.BOLD,25));
                    l12.setForeground(Color.blue);
                    l12.setBounds(300,30,400,40);
                    jf.add(l12);

                    l1 = new JLabel("Medicine Batch no*");
                    l1.setBounds(50,100,200,25);
                    jf.add(l1);

                    t1 = new JTextField(20);
                    t1.setBounds(250,100,100,25);
                    jf.add(t1);

                    l2 = new JLabel("Medicine name*");
                    l2.setBounds(50,140,200,25);
                    jf.add(l2);

                    t2 = new JTextField(20);
                    t2.setBounds(250,140,200,25);
                    jf.add(t2);

                    l3 = new JLabel("Medicine company*");
                    l3.setBounds(50,180,200,25);
                    jf.add(l3);

                    t3 = new JTextField(20);
                    t3.setBounds(250,180,200,25);
                    jf.add(t3);

                    l4 = new JLabel("Medicine quantity*");
                    l4.setBounds(50,220,200,25);
                    jf.add(l4);

                    t4= new JTextField(20);
                    t4.setBounds(250,220,100,25);
                    jf.add(t4);

                    l5= new JLabel("Med expiry date*");
                    l5.setBounds(50,260,250,25);
                    jf.add(l5);

                    SqlDateModel model = new SqlDateModel();
                    JDatePanelImpl datePanel = new JDatePanelImpl(model,new Properties());
                    datePicker = new JDatePickerImpl(datePanel,new DateLabelFormatter());
                    datePicker.setBounds(250,260,200,25);
                    jf.add(datePicker);
                    
                    l6= new JLabel("Med purchase date*");
                    l6.setBounds(50,300,260,25);
                    jf.add(l6);
                    
                    SqlDateModel model1 = new SqlDateModel();
                    JDatePanelImpl datePanel1 = new JDatePanelImpl(model1,new Properties());
                    datePicker1 = new JDatePickerImpl(datePanel1,new DateLabelFormatter());
                    
                    datePicker1.setBounds(250,300,200,25);
                    jf.add(datePicker1);
                    
                    l7 = new JLabel("Medicine type*");
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
                    
                    l8= new JLabel("Medicine purchase price*");
                    l8.setBounds(470,140,220,25);
                    jf.add(l8);

                    t8 = new JTextField(20);
                    t8.setBounds(720,140,100,25);
                    jf.add(t8);

                    l9 = new JLabel("Medicine sale price*");
                    l9.setBounds(470,180,200,25);
                    jf.add(l9);

                    t9 = new JTextField(20);
                    t9.setBounds(720,180,100,25);
                    jf.add(t9);

                    l10 = new JLabel("Medicine rack no*");		
                    l10.setBounds(470,220,200,25);
                    jf.add(l10);

                    t10 = new JTextField(20);
                    t10.setBounds(720,220,100,25);
                    jf.add(t10);

                    l11 = new JLabel("Supplier Id*");
                    l11.setBounds(470,260,250,25);
                    jf.add(l11);


                    msname=new JComboBox();
                    msname.setBounds(720,260,130,25);
                    makeComboBox(msname);
                    jf.add(msname);
                    
                    b1 = new JButton("Save",new ImageIcon("images//save.png"));
                    b1.setBounds(300,390,110,35);
                    jf.add(b1);
                    b1.addActionListener(this);

                    b2 = new JButton("Clear",new ImageIcon("images//clear.png"));
                    b2.setBounds(450,390,110,35);
                    jf.add(b2);
                    b2.addActionListener(this);

                    jf.setTitle("Add New Medicine ");
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
                      String d1=datePicker.getModel().getValue().toString();
            String d2=datePicker1.getModel().getValue().toString();
                con=DriverManager.getConnection("jdbc:ucanaccess://E://db/medicalDB.accdb");
                PreparedStatement ps = con.prepareStatement("insert into medicine values(?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(11,t1.getText());
                ps.setString(1,msname.getSelectedItem().toString());
                ps.setString(2,t2.getText());
                ps.setString(3,t3.getText());
                ps.setString(4,t4.getText());
                ps.setString(9,d1);
                ps.setString(10,d2);
                ps.setString(5,tabtype.getSelectedItem().toString());
                ps.setString(6,t8.getText());
                ps.setString(7,t9.getText());
                ps.setString(8,t10.getText());
                if(ps.executeUpdate()==1){
                    JOptionPane.showMessageDialog(this,"Record have been succesfully added","success",JOptionPane.INFORMATION_MESSAGE);
        
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,ex.getMessage(),"Inane error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(ae.getActionCommand().equals("Clear")){
        t1.setText("");
       msname.setSelectedIndex(0);
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t8.setText("");
        t9.setText("");
        t10.setText("");
        tabtype.setSelectedIndex(0);
        }       
        }
      
        private void makeComboBox(JComboBox msname)
        {
        try {
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery("select s_id from supplier");
            while(rs.next())
            {
                msname.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            
        }
        public static void main(String args[])
	{
	      new AddNewMedicine();
	}
     }
class DateLabelFormatter extends AbstractFormatter {
 
    private String datePattern = "MM-dd-yyyy";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
     
    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }
 
    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }
         
        return "";
    }
 
}