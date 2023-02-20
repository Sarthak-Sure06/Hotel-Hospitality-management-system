import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class dashboard extends JFrame implements ActionListener {

    JMenuItem recep,addem,room;
    dashboard(){

        //making frame
        setBounds(100,20,1700,1000);

        setLayout(null);

        //adding image to frame
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("Icons/UI4.jpeg"));
        Image im1 = ic1.getImage().getScaledInstance(1700, 1000, Image.SCALE_DEFAULT);
        ImageIcon ic3 = new ImageIcon(im1);
        JLabel img1 = new JLabel(ic3);
        img1.setBounds(0,0,1700,1000);
        add(img1);

        //adding menubar
        JMenuBar jmb = new JMenuBar();
        jmb.setBounds(0,0,1700,44);
        img1.add(jmb);

        //adding items in menu bar
        //1.
        JMenu hotelM = new JMenu("Management ");
        hotelM.setForeground(new Color(219, 35, 72));
        hotelM.setFont(new Font("Times New Roman" , Font.BOLD , 30));
        jmb.add(hotelM);

        //2.
        JMenu hotelA = new JMenu("Manager");
        hotelA.setForeground(new Color(23, 173, 232));
        hotelA.setFont(new Font("Times New Roman" , Font.BOLD , 30));
        jmb.add(hotelA);

        //adding menulists
        //1.
        recep = new JMenuItem("Receiption");
        recep.setFont(new Font("Times New Roman" , Font.PLAIN , 25));
        recep.addActionListener(this);
        hotelM.add(recep);

        //2.
        addem = new JMenuItem("Add Employees");
        addem.setFont(new Font("Times New Roman" , Font.PLAIN , 25));
        addem.addActionListener(this);
        hotelA.add(addem);

        //3.
        room = new JMenuItem("Add Rooms");
        room.setFont(new Font("Times New Roman" , Font.PLAIN , 25));
        room.addActionListener(this);
        hotelA.add(room);
        
        setVisible(true);

    }
    public static void main(String[] args) {
        new dashboard();
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        // TODO Auto-generated method stub
        if(ae.getActionCommand().equals("Add Employees")){
            new employee();
        }
        else if(ae.getActionCommand().equals("Add Rooms")){
            new AddRooms();
        }
        else if(ae.getActionCommand().equals("Receiption")){
            new Reception();
        }
        

        
    }
}
