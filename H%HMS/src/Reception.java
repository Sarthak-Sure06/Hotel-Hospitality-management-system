import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
    JButton addcust , rooms , allemp , custinfo , checkout ; 
    JButton updateS , updateRS , searchR , mangInfo , departM , logout;

    Reception(){
        setLayout(null);
        //frame 
        getContentPane().setBackground(new Color(247, 241, 200));
        setBounds(500,150,1000,620);
        setVisible(true);

        //adding new customer button
        addcust = new JButton("New Customer Form");
        addcust.setBounds(20,20,200,40);
        addcust.setBackground(Color.black);
        addcust.setForeground(Color.white);
        addcust.setFont(new Font("lato" , Font.PLAIN , 18));
        addcust.addActionListener(this);
        add(addcust);

        //adding rooms
        rooms = new JButton("Rooms");
        rooms.setBounds(20,70,200,40);
        rooms.setBackground(Color.black);
        rooms.setForeground(Color.white);
        rooms.setFont(new Font("lato" , Font.PLAIN , 18));
        rooms.addActionListener(this);
        add(rooms);
        
        //adding department
        departM = new JButton("Department");
        departM.setBounds(20,120,200,40);
        departM.setBackground(Color.black);
        departM.setForeground(Color.white);
        departM.setFont(new Font("lato" , Font.PLAIN , 18));
        addcust.addActionListener(this);
        add(departM);

        // adding employyes
        allemp = new JButton("All Employees");
        allemp.setBounds(20,170,200,40);
        allemp.setBackground(Color.black);
        allemp.setForeground(Color.white);
        allemp.setFont(new Font("lato" , Font.PLAIN , 18));
        allemp.addActionListener(this);
        add(allemp);

        //adding cust-info
        custinfo = new JButton("Customer-Info");
        custinfo.setBounds(20,220,200,40);
        custinfo.setBackground(Color.black);
        custinfo.setForeground(Color.white);
        custinfo.setFont(new Font("lato" , Font.PLAIN , 18));
        custinfo.addActionListener(this);
        add(custinfo);

        //adding manager-info
        mangInfo = new JButton("Manager-Info");
        mangInfo.setBounds(20,270,200,40);
        mangInfo.setBackground(Color.black);
        mangInfo.setForeground(Color.white);
        mangInfo.setFont(new Font("lato" , Font.PLAIN , 18));
        mangInfo.addActionListener(this);
        add(mangInfo);

        //adding checkout
        checkout = new JButton("Checkout");
        checkout.setBounds(20,320,200,40);
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.setFont(new Font("lato" , Font.PLAIN , 18));
        checkout.addActionListener(this);
        add(checkout);

        // update status
        updateS = new JButton("Update Status");
        updateS.setBounds(20,370,200,40);
        updateS.setBackground(Color.black);
        updateS.setForeground(Color.white);
        updateS.setFont(new Font("lato" , Font.PLAIN , 18));
        updateS.addActionListener(this);
        add(updateS);

        // update room status
        updateRS = new JButton("Update Room Status");
        updateRS.setBounds(20,420,200,40);
        updateRS.setBackground(Color.black);
        updateRS.setForeground(Color.white);
        updateRS.setFont(new Font("lato" , Font.PLAIN , 18));
        updateRS.addActionListener(this);
        add(updateRS);

        // room search
        searchR = new JButton("Search Room");
        searchR.setBounds(20,470,200,40);
        searchR.setBackground(Color.black);
        searchR.setForeground(Color.white);
        searchR.setFont(new Font("lato" , Font.PLAIN , 18));
        searchR.addActionListener(this);
        add(searchR);

        //logout
        logout = new JButton("Logout");
        logout.setBounds(20,520,200,40);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.setFont(new Font("lato" , Font.PLAIN , 18));
        logout.addActionListener(this);
        add(logout);

        // adding image
        ImageIcon ui1 = new ImageIcon(ClassLoader.getSystemResource("Icons/UI7.jpeg"));
        // Image i1 = ui1.getImage().getScaledInstance(WIDTH, HEIGHT, DO_NOTHING_ON_CLOSE)
         JLabel UIimage = new JLabel(ui1);
         UIimage.setBounds(0,20,1000,500);  // lengthX  lengthY UP Down
         add(UIimage); 
    }

    public static void main(String[] args) {
        new Reception();
    }

    public void actionPerformed(ActionEvent ae) {
        // TODO Auto-generated method stub
        if(ae.getSource() == addcust){
            setVisible(false);
            new AddCust();
        }

        else if(ae.getSource() == rooms){
            setVisible(false);
            new Rooms();
        }

        else if(ae.getSource() == departM){
            setVisible(false);
            new Department();
        }
        else if(ae.getSource() == allemp){
            setVisible(false);
            new AllEmployess();
        }
        
        else if(ae.getSource() == custinfo){
            setVisible(false);
            new CustInfo();
        }

        else if(ae.getSource() == mangInfo){
            setVisible(false);
            new managerInfo();
        }

        else if(ae.getSource() == updateS){
            setVisible(false);
            new CheckUpdate();
        }
        else if(ae.getSource() == searchR){
            setVisible(false);
            new searchRoom();
        }
        else if(ae.getSource() == updateRS){
            setVisible(false);
            new Updateclean();
        }
        else if(ae.getSource() == checkout){
            setVisible(false);
            new checkout();
        }
        else if(ae.getSource() == logout){
            setVisible(false);
            new dashboard();
        }
        
    }
    
}
