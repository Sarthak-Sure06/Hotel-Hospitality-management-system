import javax.swing.*;
import java.sql.ResultSet;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class searchRoom extends JFrame implements ActionListener{

    
    JTable tb;
    JButton csub,sub;
    JComboBox<String> bedtr;
    JCheckBox cb;


    searchRoom(){
        setLayout(null);
        //frame 
        getContentPane().setBackground(new Color(247, 241, 200));
        setBounds(200,150,1500,650);
        setVisible(true);

         //heading
         JLabel hea = new JLabel("Search Room");
         hea.setBounds(250,20,230,30);
         hea.setForeground(Color.black);
         hea.setFont(new Font("lato" , Font.BOLD , 30));
         add(hea);

         //adding bed types
        JLabel rbed = new JLabel("Bed Type");
        rbed.setBounds(20,80,200,30);
        rbed.setForeground(Color.black);
        rbed.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(rbed);

        String[] roombt = {"Single Bed","Delux Bed" , "Single Bed AC" , "Delux Bed AC"};
        bedtr = new JComboBox<>(roombt);
        bedtr.setBounds(150,80,300,30);
        bedtr.setForeground(Color.black);
        bedtr.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(bedtr);

        //adding check box
        cb = new JCheckBox("Show Only Available");
        cb.setBounds(500,80,300,30);
        cb.setBackground(new Color(247, 241, 200));
        cb.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(cb);


        //adding lables
        JLabel he = new JLabel("Room No.");
        he.setBounds(10,150,150,30);
        he.setForeground(Color.black);
        he.setFont(new Font("lato" , Font.BOLD , 25));
        add(he);

        //adding lables
        JLabel av = new JLabel("Availability");
        av.setBounds(180,150,150,30);
        av.setForeground(Color.black);
        av.setFont(new Font("lato" , Font.BOLD , 25));
        add(av);

        //adding lables
        JLabel cl = new JLabel("Status");
        cl.setBounds(350,150,150,30);
        cl.setForeground(Color.black);
        cl.setFont(new Font("lato" , Font.BOLD , 25));
        add(cl);

        //adding lables
        JLabel pr = new JLabel("Price");
        pr.setBounds(500,150,120,30);
        pr.setForeground(Color.black);
        pr.setFont(new Font("lato" , Font.BOLD , 25));
        add(pr);

        //adding lables
        JLabel bt = new JLabel("Bed Type");
        bt.setBounds(660,150,150,30);
        bt.setForeground(Color.black);
        bt.setFont(new Font("lato" , Font.BOLD , 25));
        add(bt);

        //table object
        tb = new JTable();
        tb.setBounds(10,200,800,300);
        tb.setBackground(new Color(247, 241, 200));
        tb.setFont(new Font("sans" , Font.PLAIN , 25));
        tb.setRowHeight(tb.getRowHeight() + 20);
        add(tb);

        
        //submit button
        sub = new JButton("Submit");
        sub.setBounds(150,520,150,50);
        sub.setBackground(Color.blue);
        sub.setForeground(Color.white);
        sub.setFont(new Font("lato" , Font.PLAIN , 30));
        sub.addActionListener(this);
        add(sub);

        //cancel button
        csub = new JButton("Back");
        csub.setBounds(320,520,150,50);
        csub.setBackground(Color.black);
        csub.setForeground(Color.white);
        csub.setFont(new Font("lato" , Font.PLAIN , 30));
        csub.addActionListener(this);
        add(csub);

          // adding image
         ImageIcon ui1 = new ImageIcon(ClassLoader.getSystemResource("Icons/UI10.jpg"));
         // Image i1 = ui1.getImage().getScaledInstance(WIDTH, HEIGHT, DO_NOTHING_ON_CLOSE)
          JLabel UIimage = new JLabel(ui1);
          UIimage.setBounds(850,100,612,360);  // lengthX  lengthY UP Down
          add(UIimage);

    }
    public static void main(String[] args) {
        new searchRoom();
    }
    
    public void actionPerformed(ActionEvent ae) {
        // TODO Auto-generated method stub
        if(ae.getSource() == sub){

            try {
                JDBCconnection c = new JDBCconnection();
    
                String query2 = "select * from Room where RoomAvail = 'Available' AND  RoomBeds = '"+bedtr.getSelectedItem()+"'";
                String query1 = "select * from Room where RoomBeds = '"+bedtr.getSelectedItem()+"'";
                ResultSet rs;
                if(cb.isSelected()){
                    rs = c.s.executeQuery(query2);
                }
                else{
                    rs = c.s.executeQuery(query1);
                }
                tb.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
    
        }

        else{
            setVisible(false);
        new Reception();
        }
        

    }
    
}

