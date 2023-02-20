import javax.swing.*;
import java.sql.ResultSet;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class AllEmployess extends JFrame implements ActionListener{

    
    JTable tb;
    JButton csub;

    AllEmployess(){
        setLayout(null);
        //frame 
        getContentPane().setBackground(new Color(247, 241, 200));
        setBounds(200,150,1200,650);
        setVisible(true);

        //adding lables
        JLabel he = new JLabel("Name");
        he.setBounds(10,20,150,30);
        he.setForeground(Color.black);
        he.setFont(new Font("lato" , Font.BOLD , 25));
        add(he);

        //adding lables
        JLabel av = new JLabel("Gender");
        av.setBounds(190,20,150,30);
        av.setForeground(Color.black);
        av.setFont(new Font("lato" , Font.BOLD , 25));
        add(av);

        //adding lables
        JLabel cl = new JLabel("Age");
        cl.setBounds(360,20,150,30);
        cl.setForeground(Color.black);
        cl.setFont(new Font("lato" , Font.BOLD , 25));
        add(cl);

        //adding lables
        JLabel pr = new JLabel("Salary");
        pr.setBounds(520,20,150,30);
        pr.setForeground(Color.black);
        pr.setFont(new Font("lato" , Font.BOLD , 25));
        add(pr);

        //adding lables
        JLabel bt = new JLabel("Contact");
        bt.setBounds(690,20,150,30);
        bt.setForeground(Color.black);
        bt.setFont(new Font("lato" , Font.BOLD , 25));
        add(bt);

        //adding lables
        JLabel em = new JLabel("Email");
        em.setBounds(860,20,150,30);
        em.setForeground(Color.black);
        em.setFont(new Font("lato" , Font.BOLD , 25));
        add(em);

        //adding lables
        JLabel jr = new JLabel("Job Role");
        jr.setBounds(1020,20,150,30);
        jr.setForeground(Color.black);
        jr.setFont(new Font("lato" , Font.BOLD , 25));
        add(jr);

        //table object
        tb = new JTable();
        tb.setBounds(10,80,1160,400);
        tb.setBackground(new Color(247, 241, 200));
        tb.setFont(new Font("sans" , Font.PLAIN , 16));
        tb.setRowHeight(tb.getRowHeight() + 20);
        add(tb);

        try {
            JDBCconnection c = new JDBCconnection();

            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            tb.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        //cancel button
        csub = new JButton("Back");
        csub.setBounds(500,520,150,50);
        csub.setBackground(Color.black);
        csub.setForeground(Color.white);
        csub.setFont(new Font("lato" , Font.PLAIN , 30));
        csub.addActionListener(this);
        add(csub);


    }
    public static void main(String[] args) {
        new AllEmployess();
    }

    
    public void actionPerformed(ActionEvent ae) {
        // TODO Auto-generated method stub
        setVisible(false);
        new Reception();

    }
    
}
