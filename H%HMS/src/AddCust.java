import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.*;

public class AddCust extends JFrame implements ActionListener {

    JTextField cname , cnum , depi;
    JRadioButton genm,genf;
    JComboBox<String> ID;
    Choice nroom;
    JLabel checkint;
    JButton sub , csub;

    AddCust(){
        setLayout(null);
        //frame 
        getContentPane().setBackground(new Color(247, 241, 200));
        setBounds(500,150,1000,650);
        setVisible(true);

        //heading
        JLabel he = new JLabel("New Form");
        he.setBounds(250,20,230,30);
        he.setForeground(Color.black);
        he.setFont(new Font("lato" , Font.BOLD , 30));
        add(he);

        //adding customer name
        JLabel namec = new JLabel("NAME");
        namec.setBounds(20,100,100,30);
        namec.setForeground(Color.black);
        namec.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(namec);

        // adding text field
        cname = new JTextField();
        cname.setBounds(150,100,250,30);
        cname.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(cname);

        // adding gender 
        JLabel gen = new JLabel("GENDER");
        gen.setBounds(20,160,100,30);
        gen.setForeground(Color.black);
        gen.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(gen);
        
        // adding gender radio button
        //1. for male
        genm = new JRadioButton("Male");
        genm.setBounds(150,160,100,30);
        genm.setBackground(new Color(247, 241, 200));
        genm.setForeground(Color.black);
        genm.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(genm);
        //2. for female
        genf = new JRadioButton("Female");
        genf.setBounds(260,160,150,30);
        genf.setBackground(new Color(247, 241, 200));
        genf.setForeground(Color.black);
        genf.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(genf);
        //grouping both radio
        ButtonGroup bg = new ButtonGroup();
        bg.add(genm);
        bg.add(genf);

        // adding ID  
        JLabel IDT = new JLabel("ID type");
        IDT.setBounds(20,220,100,30);
        IDT.setForeground(Color.black);
        IDT.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(IDT);
        // adding jobs roles
        String[] js = {"Aadhar Card" , "Passport" , "Driving License"};
        ID = new JComboBox<>(js);
        ID.setBounds(150,220,250,30);
        ID.setForeground(Color.black);
        ID.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(ID);

        //adding ID num
        JLabel numc = new JLabel("ID No.");
        numc.setBounds(20,280,100,30);
        numc.setForeground(Color.black);
        numc.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(numc);

        // adding text field
        cnum = new JTextField();
        cnum.setBounds(150,280,250,30);
        cnum.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(cnum);

        //adding room no.
        JLabel roomn = new JLabel("Room No.");
        roomn.setBounds(20,340,120,30);
        roomn.setForeground(Color.black);
        roomn.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(roomn);

        //adding room choice
        nroom = new Choice();

        try {
            JDBCconnection c = new JDBCconnection();
            String query = "select * from Room where RoomAvail = 'Available'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                nroom.add(rs.getString("RoomNumber"));
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        nroom.setBounds(150,340,250,30);
        nroom.setForeground(Color.black);
        nroom.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(nroom);

        //adding room no.
        JLabel checkin = new JLabel("Check-in");
        checkin.setBounds(20,400,150,30);
        checkin.setForeground(Color.black);
        checkin.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(checkin);

        //adding value fixed
        Date d = new Date();
        checkint = new JLabel("" + d);
        checkint.setBounds(150,400,280,30);
        checkint.setForeground(Color.black);
        checkint.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(checkint);

        //adding initial deposite
        JLabel idep = new JLabel("Deposite");
        idep.setBounds(20,460,100,30);
        idep.setForeground(Color.black);
        idep.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(idep);

        // adding text field
        depi = new JTextField();
        depi.setBounds(150,460,250,30);
        depi.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(depi);

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
        ImageIcon ui1 = new ImageIcon(ClassLoader.getSystemResource("Icons/UI8.jpg"));
        // Image i1 = ui1.getImage().getScaledInstance(WIDTH, HEIGHT, DO_NOTHING_ON_CLOSE)
         JLabel UIimage = new JLabel(ui1);
         UIimage.setBounds(500,100,360,360);  // lengthX  lengthY UP Down
         add(UIimage);

    }

    public static void main(String[] args) {
        new AddCust();
    }

    public void actionPerformed(ActionEvent ae) {
        // TODO Auto-generated method stub
        if(ae.getSource() == sub){
            String namec = cname.getText();
            String gender = null;
            if(genm.isSelected()) gender = "Male";
            else if(genf.isSelected()) gender = "Female";
            String DI = (String)ID.getSelectedItem();
            String IDnum = cnum.getText();
            String Roomn = nroom.getSelectedItem();
            String CHECKT = checkint.getText();
            String Deposite = depi.getText();

            try {
                JDBCconnection c = new JDBCconnection();

                String query = "insert into Customer values('"+namec+"' , '"+gender+"' ,'"+DI+"' , '"+IDnum+"' , '"+Roomn+"' , '"+CHECKT+"' , '"+Deposite+"')";
                String query2 = "update Room set RoomAvail = 'Occupied' where RoomNumber = '"+Roomn+"'";
                c.s.executeUpdate(query); 
                c.s.executeUpdate(query2); 

                JOptionPane.showMessageDialog(null, "Customer added succesfully");
                setVisible(false);
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }

        else if(ae.getSource() == csub){
            setVisible(false);
            new Reception();
        }
        
    }
    
}
