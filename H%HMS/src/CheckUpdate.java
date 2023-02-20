import javax.swing.*;
import java.sql.ResultSet;
import java.awt.*;
import java.awt.event.*;
//import net.proteanit.sql.*;

public class CheckUpdate extends JFrame implements ActionListener{

    Choice cn;
    JTextField croom,cname,ctime,da,pa;
    JButton sub,csub,usub;

    CheckUpdate(){
        setLayout(null);
        //frame 
        getContentPane().setBackground(new Color(247, 241, 200));
        setBounds(200,150,1500,650);
        setVisible(true);

         //heading
         JLabel hea = new JLabel("UPDATE STATUS");
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
        JLabel deposite = new JLabel("Deposite");
        deposite.setBounds(20,360,200,30);
        deposite.setForeground(Color.black);
        deposite.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(deposite);

        // adding text field
        da = new JTextField();
        da.setBounds(150,360,250,30);
        da.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(da);

        //adding customer name
        JLabel pending = new JLabel("Pending");
        pending.setBounds(20,430,200,30);
        pending.setForeground(Color.black);
        pending.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(pending);

        // adding text field
        pa = new JTextField();
        pa.setBounds(150,430,250,30);
        pa.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(pa);

        //submit button
        sub = new JButton("Check");
        sub.setBounds(150,520,150,50);
        sub.setBackground(Color.black);
        sub.setForeground(Color.white);
        sub.setFont(new Font("lato" , Font.PLAIN , 30));
        sub.addActionListener(this);
        add(sub);

        //cancel button
        usub = new JButton("Update");
        usub.setBounds(320,520,150,50);
        usub.setBackground(Color.black);
        usub.setForeground(Color.white);
        usub.setFont(new Font("lato" , Font.PLAIN , 30));
        usub.addActionListener(this);
        add(usub);

        //cancel button
        csub = new JButton("Back");
        csub.setBounds(490,520,150,50);
        csub.setBackground(Color.black);
        csub.setForeground(Color.white);
        csub.setFont(new Font("lato" , Font.PLAIN , 30));
        csub.addActionListener(this);
        add(csub);

    }
    public static void main(String[] args) {
        new CheckUpdate();
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
                        da.setText(rs.getString("DepositeValue"));
                    }

                    String query2 = "select * from Room where RoomNumber = '"+croom.getText()+"'";
                    ResultSet rs2 = c.s.executeQuery(query2);
                    while(rs2.next()){
                        String price = rs2.getString("RoomPrice");
                        int amtpaid = Integer.parseInt(price) - Integer.parseInt(da.getText());
                        pa.setText(Integer.toString(amtpaid));
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                } 
            }

            else if(ae.getSource() == usub){

                 String name = cname.getText();
                 String checkin = ctime.getText();
                 String deposite = da.getText();

                try {
                    JDBCconnection c = new JDBCconnection();
                    String query = "update Customer set CustName = '"+name+"' , Checkin_time = '"+checkin+"' ,DepositeValue = '"+deposite+"'";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,"Data Updated Succesfully");

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
