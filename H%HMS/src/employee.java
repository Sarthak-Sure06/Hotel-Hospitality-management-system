import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class employee extends JFrame implements ActionListener{

    JTextField emepn , agef , salf ,phonef ,emailf;
    JRadioButton genm , genf;
    JComboBox<String> jobr;
    JButton sub,csub;

    employee(){

        setLayout(null);
        //frame 
        getContentPane().setBackground(new Color(247, 241, 200));
        setBounds(300,150,1500,700);
        setVisible(true);

        //heading
        JLabel he = new JLabel("Add Employee");
        he.setBounds(250,20,230,30);
        he.setForeground(Color.black);
        he.setFont(new Font("lato" , Font.BOLD , 30));
        add(he);

       
    //adding employee name
        JLabel ename = new JLabel("NAME");
        ename.setBounds(20,100,100,30);
        ename.setForeground(Color.black);
        ename.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(ename);

        // adding text field
        emepn = new JTextField();
        emepn.setBounds(130,100,250,30);
        emepn.setFont(new Font("Tahoma" , Font.PLAIN , 27));
        add(emepn);

    // adding gender 
        JLabel gen = new JLabel("GENDER");
        gen.setBounds(20,170,100,30);
        gen.setForeground(Color.black);
        gen.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(gen);
        
        // adding gender radio button
        //1. for male
        genm = new JRadioButton("Male");
        genm.setBounds(150,170,100,30);
        genm.setBackground(new Color(247, 241, 200));
        genm.setForeground(Color.black);
        genm.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(genm);
        //2. for female
        genf = new JRadioButton("Female");
        genf.setBounds(260,170,150,30);
        genf.setBackground(new Color(247, 241, 200));
        genf.setForeground(Color.black);
        genf.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(genf);
        //grouping both radio
        ButtonGroup bg = new ButtonGroup();
        bg.add(genm);
        bg.add(genf);
    
    //adding age
        JLabel age = new JLabel("AGE");
        age.setBounds(20,240,100,30);
        age.setForeground(Color.black);
        age.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(age);

        // adding text field
        agef = new JTextField();
        agef.setBounds(150,240,200,30);
        agef.setFont(new Font("Tahoma" , Font.PLAIN , 27));
        add(agef);

    // adding jobs   
        JLabel jobs = new JLabel("JOBS");
        jobs.setBounds(20,310,100,30);
        jobs.setForeground(Color.black);
        jobs.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(jobs);
        // adding jobs roles
        String[] js = {"Front Desk" , "HouseKeeping" , "Kitchen staff" ,"Waiter/Waitress" ,"Side Chef" , "Head Chef" , "Room Service" , "Accountant" , "Manager"};
        jobr = new JComboBox<>(js);
        jobr.setBounds(150,310,400,30);
        jobr.setForeground(Color.black);
        jobr.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(jobr);

    // adding salary
        JLabel sal = new JLabel("SALARY");
        sal.setBounds(20,380,100,30);
        sal.setForeground(Color.black);
        sal.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(sal);

        // adding text field
        salf = new JTextField();
        salf.setBounds(150,380,200,30);
        salf.setFont(new Font("Tahoma" , Font.PLAIN , 27));
        add(salf);    

    //adding phone 
        JLabel phone = new JLabel("CONTACT");
        phone.setBounds(20,450,150,30);
        phone.setForeground(Color.black);
        phone.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(phone);

        // adding text field
        phonef = new JTextField();
        phonef.setBounds(150,450,200,30);
        phonef.setFont(new Font("Tahoma" , Font.PLAIN , 27));
        add(phonef); 
        
    // adding email
        JLabel email = new JLabel("EMAIL");
        email.setBounds(20,520,100,30);
        email.setForeground(Color.black);
        email.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(email);

        // adding text field
        emailf = new JTextField();
        emailf.setBounds(150,520,200,30);
        emailf.setFont(new Font("Tahoma" , Font.PLAIN , 27));
        add(emailf);    
        
    // submit button
        sub = new JButton("Submit");
        sub.setBounds(180,580,150,50);
        sub.setBackground(Color.blue);
        sub.setForeground(Color.white);
        sub.setFont(new Font("lato" , Font.PLAIN , 30));
        sub.addActionListener(this);
        add(sub); 
        
        //cancel button
        csub = new JButton("Cancel");
        csub.setBounds(360,580,150,50);
        csub.setBackground(Color.black);
        csub.setForeground(Color.white);
        csub.setFont(new Font("lato" , Font.PLAIN , 30));
        add(csub);

    // adding image
         ImageIcon ui1 = new ImageIcon(ClassLoader.getSystemResource("Icons/UI5.jpg"));
       // Image i1 = ui1.getImage().getScaledInstance(WIDTH, HEIGHT, DO_NOTHING_ON_CLOSE)
        JLabel UIimage = new JLabel(ui1);
        UIimage.setBounds(650,20,800,560);  // lengthX  lengthY UP Down
        add(UIimage);    

    }

    public static void main(String[] args) {
        new employee();
    }

    public void actionPerformed(ActionEvent ae) {
        // TODO Auto-generated method stub
        String name = emepn.getText();
        String age = agef.getText();
        String salary = salf.getText();
        String phoneno = phonef.getText();
        String emailinfo = emailf.getText();

        String gender = null;
        if(genm.isSelected()) gender = "Male";
        else if(genf.isSelected()) gender = "Female";

        String jobrole = (String)jobr.getSelectedItem();

        try {

            JDBCconnection c = new JDBCconnection();

            String query = "insert into employee values('"+name+"' , '"+gender+"' ,'"+age+"' , '"+salary+"' , '"+phoneno+"' , '"+emailinfo+"' , '"+jobrole+"')";
            
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Emplopyee added succesfully");
            setVisible(false);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
    }
    
}
