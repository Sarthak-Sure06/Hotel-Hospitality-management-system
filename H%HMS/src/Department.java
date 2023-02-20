import javax.swing.*;
import java.sql.ResultSet;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener{

    
    JTable tb;
    JButton csub;

    Department(){
        setLayout(null);
        //frame 
        getContentPane().setBackground(new Color(247, 241, 200));
        setBounds(200,150,1500,650);
        setVisible(true);

        //adding lables
        JLabel he = new JLabel("Department");
        he.setBounds(10,20,150,30);
        he.setForeground(Color.black);
        he.setFont(new Font("lato" , Font.BOLD , 25));
        add(he);

        //adding lables
        JLabel av = new JLabel("Budget");
        av.setBounds(450,20,150,30);
        av.setForeground(Color.black);
        av.setFont(new Font("lato" , Font.BOLD , 25));
        add(av);

        //table object
        tb = new JTable();
        tb.setBounds(10,80,800,400);
        tb.setBackground(new Color(247, 241, 200));
        tb.setFont(new Font("sans" , Font.PLAIN , 25));
        tb.setRowHeight(tb.getRowHeight() + 20);
        add(tb);

        try {
            JDBCconnection c = new JDBCconnection();

            String query = "select * from department";
            ResultSet rs = c.s.executeQuery(query);
            tb.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

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
        new Department();
    }

    
    public void actionPerformed(ActionEvent ae) {
        // TODO Auto-generated method stub
        setVisible(false);
        new Reception();

    }
    
}
