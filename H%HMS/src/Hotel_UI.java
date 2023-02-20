import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Hotel_UI extends JFrame implements ActionListener{

    Hotel_UI(){

        // Creating Frame 
           /*setSize(1125,750);
           setLocation(400,150);*/

        setBounds(400,150,1125,750); // lengthX  lengthY UP Down

        //Adding image in UI frame
        ImageIcon ui1 = new ImageIcon(ClassLoader.getSystemResource("Icons/UI2.jpeg"));
        JLabel UIimage = new JLabel(ui1);
        UIimage.setBounds(0,0,1125,750);  // lengthX  lengthY UP Down
        add(UIimage);

        //Adding test in UI
        //1.
        JLabel text1 = new JLabel("H&H MANAGEMENT SYSTEM");
        text1.setBounds(10,330,700,100);
        text1.setForeground(Color.white);
        text1.setFont(new Font("serif" , Font.BOLD , 45));
        UIimage.add(text1);

        //2.
        JLabel text2 = new JLabel("Welcome to");
        text2.setBounds(150,290,700,100);
        text2.setForeground(Color.white);
        text2.setFont(new Font("serif" , Font.PLAIN , 40));
        UIimage.add(text2);

        //maaking next button
        JButton next = new JButton("Next");
        next.setBounds(980,630,100,50);
        next.setBackground(Color.white);
        next.setForeground(Color.black);
        next.addActionListener(this);
        next.setFont(new Font("lato" , Font.PLAIN , 30));
        UIimage.add(next);

        // making frame visible
        setVisible(true);

        //adding flickering function
        /*while(true){
            text1.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            text1.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }*/
    }

    public void actionPerformed(ActionEvent ee) {
        // TODO Auto-generated method stub
        setVisible(false);
        new login();
        
    }

    public static void main(String[] args) {
        new Hotel_UI();
    }
}
