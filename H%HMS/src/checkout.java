import javax.swing.*;
import java.sql.ResultSet;
import java.awt.*;
import java.util.Date;
import java.awt.event.*;
//import net.proteanit.sql.*;

public class checkout extends JFrame implements ActionListener{

    Choice cn;
    JTextField croom,cname,ctime,da,pa;
    JButton sub,csub,usub;
    JLabel checkoutt;

    checkout(){
        setLayout(null);
        //frame 
        getContentPane().setBackground(new Color(247, 241, 200));
        setBounds(200,150,1500,650);
        setVisible(true);

         //heading
         JLabel hea = new JLabel("CHECKOUT");
         hea.setBounds(250,20,300,30);
         hea.setForeground(Color.black);
         hea.setFont(new Font("lato" , Font.BOLD , 30));
         add(hea);

         //jlabel
        JLabel rbed = new JLabel("Cust ID");
        rbed.setBounds(20,80,100,30);
        rbed.setForeground(Color.black);
        rbed.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(rbed);

        //adding choice
        cn = new Choice();
        cn.setBounds(150,80,250,25);
        cn.setForeground(Color.black);
        cn.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(cn);

        try {
            JDBCconnection c = new JDBCconnection();

            String query = "select * from Customer";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                cn.add(rs.getString("ID_NUM"));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        //adding customer name
        JLabel roomc = new JLabel("ROOM No.");
        roomc.setBounds(20,150,200,30);
        roomc.setForeground(Color.black);
        roomc.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(roomc);

        // adding text field
        croom = new JTextField();
        croom.setBounds(150,150,250,30);
        croom.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(croom);

        //adding customer name
        JLabel namec = new JLabel("Name");
        namec.setBounds(20,220,200,30);
        namec.setForeground(Color.black);
        namec.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(namec);

        // adding text field
        cname = new JTextField();
        cname.setBounds(150,220,250,30);
        cname.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(cname);

        //adding customer name
        JLabel checkintime = new JLabel("Checkin");
        checkintime.setBounds(20,290,200,30);
        checkintime.setForeground(Color.black);
        checkintime.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(checkintime);

        // adding text field
        ctime = new JTextField();
        ctime.setBounds(150,290,250,30);
        ctime.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(ctime);

        //adding customer name
        JLabel checkouttime = new JLabel("Checkout");
        checkouttime.setBounds(20,360,200,30);
        checkouttime.setForeground(Color.black);
        checkouttime.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(checkouttime);

        //adding value fixed
        Date d = new Date();
        checkoutt = new JLabel("" + d);
        checkoutt.setBounds(150,360,280,30);
        checkoutt.setForeground(Color.black);
        checkoutt.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(checkoutt);

        //submit button
        sub = new JButton("Check");
        sub.setBounds(150,520,150,50);
        sub.setBackground(Color.black);
        sub.setForeground(Color.white);
        sub.setFont(new Font("lato" , Font.PLAIN , 30));
        sub.addActionListener(this);
        add(sub);

        //cancel button
        usub = new JButton("Checkout");
        usub.setBounds(320,520,200,50);
        usub.setBackground(Color.black);
        usub.setForeground(Color.white);
        usub.setFont(new Font("lato" , Font.PLAIN , 30));
        usub.addActionListener(this);
        add(usub);

        //cancel button
        csub = new JButton("Back");
        csub.setBounds(540,520,150,50);
        csub.setBackground(Color.black);
        csub.setForeground(Color.white);
        csub.setFont(new Font("lato" , Font.PLAIN , 30));
        csub.addActionListener(this);
        add(csub);

    }
    public static void main(String[] args) {
        new checkout();
    }
    public void actionPerformed(ActionEvent ae) {
        // TODO Auto-generated method stub

        try {

            if(ae.getSource() == sub){
                String id = cn.getSelectedItem();
                String query = "select * from Customer where ID_NUM = '"+id+"'";
                try {
                    JDBCconnection c = new JDBCconnection();
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        croom.setText(rs.getString("RoomNum"));
                        cname.setText(rs.getString("CustName"));
                        ctime.setText(rs.getString("Checkin_time"));
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                } 
            }

            else if(ae.getSource() == usub){

                 String query1 = "delete from Customer where ID_NUM = '"+cn.getSelectedItem()+"'";
                 String query2 = "update Room set RoomAvail = 'Available' where RoomNumber = '"+croom.getText()+"'";

                try {
                    JDBCconnection c = new JDBCconnection();
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"CheckOut Done");

                    setVisible(false);
                    new Reception();
                    
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }

            else if(ae.getSource() == csub){
                setVisible(false);
                new Reception();
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
    }
}
