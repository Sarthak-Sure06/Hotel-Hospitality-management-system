import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class login extends JFrame implements ActionListener{
    JTextField usern;
    JTextField passn;
    JButton sub;
    login(){
        //frame details
        getContentPane().setBackground(new Color(240, 223, 225));
        setLayout(null);

        //making login
        JLabel log = new JLabel("Login");
        log.setBounds(200,20,100,100);
        log.setForeground(Color.black);
        log.setFont(new Font("lato" , Font.BOLD , 30));
        add(log);

        //making username
        JLabel user = new JLabel("Username : ");
        user.setBounds(40,60,200,200);
        user.setForeground(Color.black);
        user.setFont(new Font("serif" , Font.PLAIN , 30));
        add(user);
        //making username box
        usern = new JTextField();
        usern.setBounds(180,140,250,40);
        usern.setFont(new Font("lato" , Font.PLAIN , 20));
        add(usern);

        //making password
        JLabel pass = new JLabel("Password : ");
        pass.setBounds(40,160,200,200);
        pass.setForeground(Color.black);
        pass.setFont(new Font("serif" , Font.PLAIN , 30));
        add(pass);
        //making password box
        passn = new JTextField();
        passn.setBounds(180,240,250,40);
        passn.setFont(new Font("lato" , Font.PLAIN , 20));
        add(passn);

        //submit button
        sub = new JButton("Submit");
        sub.setBounds(150,300,150,60);
        sub.setBackground(Color.blue);
        sub.setForeground(Color.white);
        sub.setFont(new Font("lato" , Font.PLAIN , 30));
        sub.addActionListener(this);
        add(sub);


        //frame 
        setBounds(800,150,500,700);
        setVisible(true);
    }

    public static void main(String[] args) {
        new login();
    }


    public void actionPerformed(ActionEvent ee) {
        if(ee.getSource() == sub){
            String ur = usern.getText();
            String ps = passn.getText();

            try {

            JDBCconnection cs = new JDBCconnection();

            String query = "select * from logicc where username = '" + ur + "' and password = '" + ps + "'";

            ResultSet rs = cs.s.executeQuery(query);

            if(rs.next()){
                setVisible(false);
                new dashboard();
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid username ans Password");
            }
                
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        // TODO Auto-generated method stub
        
    }

    
}
