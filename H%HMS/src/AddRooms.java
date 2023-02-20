import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {

    JTextField roomn , roomp;
    JComboBox<String> roomr , cleanr , bedtr;
    JButton sub , csub;

    AddRooms(){
        setLayout(null);
        //frame 
        getContentPane().setBackground(new Color(247, 241, 200));
        setBounds(500,150,1200,570);
        setVisible(true);

        //heading
        JLabel hr = new JLabel("Add Rooms");
        hr.setBounds(250,20,230,30);
        hr.setForeground(Color.black);
        hr.setFont(new Font("lato" , Font.BOLD , 30));
        add(hr);

       
    //adding room no.
        JLabel nroom = new JLabel("Room No.");
        nroom.setBounds(20,100,150,30);
        nroom.setForeground(Color.black);
        nroom.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(nroom);

        // adding text field
        roomn = new JTextField();
        roomn.setBounds(150,100,250,30);
        roomn.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(roomn);

        // adding avail status  
        JLabel ravail = new JLabel("Avaibility");
        ravail.setBounds(20,170,150,30);
        ravail.setForeground(Color.black);
        ravail.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(ravail);

        String[] roomal = {"Available","Occupied"};
        roomr = new JComboBox<>(roomal);
        roomr.setBounds(150,170,300,30);
        roomr.setForeground(Color.black);
        roomr.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(roomr);

        //adding cleaning status
        JLabel rclean = new JLabel("Cleaning status");
        rclean.setBounds(20,240,200,30);
        rclean.setForeground(Color.black);
        rclean.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(rclean);

        String[] roomcl = {"Cleaned","still dirty"};
        cleanr = new JComboBox<>(roomcl);
        cleanr.setBounds(220,240,300,30);
        cleanr.setForeground(Color.black);
        cleanr.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(cleanr);

        //adding price
        JLabel proom = new JLabel("Price");
        proom.setBounds(20,310,150,30);
        proom.setForeground(Color.black);
        proom.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(proom);

        // adding text field
        roomp = new JTextField();
        roomp.setBounds(150,310,250,30);
        roomp.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(roomp);

        //adding bed types
        JLabel rbed = new JLabel("Bed Type");
        rbed.setBounds(20,380,200,30);
        rbed.setForeground(Color.black);
        rbed.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        add(rbed);

        String[] roombt = {"Single Bed","Delux Bed" , "Single Bed AC" , "Delux Bed AC"};
        bedtr = new JComboBox<>(roombt);
        bedtr.setBounds(150,380,300,30);
        bedtr.setForeground(Color.black);
        bedtr.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(bedtr);

        //submit button
        sub = new JButton("Submit");
        sub.setBounds(150,450,150,50);
        sub.setBackground(Color.blue);
        sub.setForeground(Color.white);
        sub.setFont(new Font("lato" , Font.PLAIN , 30));
        sub.addActionListener(this);
        add(sub);

        //cancel button
        csub = new JButton("Cancel");
        csub.setBounds(320,450,150,50);
        csub.setBackground(Color.black);
        csub.setForeground(Color.white);
        csub.setFont(new Font("lato" , Font.PLAIN , 30));
        csub.addActionListener(this);
        add(csub);

        // adding image
        ImageIcon ui1 = new ImageIcon(ClassLoader.getSystemResource("Icons/UI6.jpg"));
        // Image i1 = ui1.getImage().getScaledInstance(WIDTH, HEIGHT, DO_NOTHING_ON_CLOSE)
         JLabel UIimage = new JLabel(ui1);
         UIimage.setBounds(550,20,600,500);  // lengthX  lengthY UP Down
         add(UIimage);  
    }

    public static void main(String[] args) {
        new AddRooms();
    }

    public void actionPerformed(ActionEvent ae) {
        // TODO Auto-generated method stub
        if(ae.getSource() == sub){
            String Roomn = roomn.getText();
            String AvailRoom = (String)roomr.getSelectedItem();
            String CleanRoom = (String)cleanr.getSelectedItem();
            String RoomP = roomp.getText();
            String SelBed = (String)bedtr.getSelectedItem();

            try {
                JDBCconnection c = new JDBCconnection();

                String query = "insert into Room values('"+Roomn+"' , '"+AvailRoom+"' ,'"+CleanRoom+"' , '"+RoomP+"' , '"+SelBed+"')";
                
                c.s.executeUpdate(query); 

                JOptionPane.showMessageDialog(null, "Room added succesfully");
                setVisible(false);
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }

        else if(ae.getSource() == csub){
            setVisible(false);
        }

        
    }
    
}
