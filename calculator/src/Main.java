import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame=new JFrame();
//        frame.setLayout(new FlowLayout());
        frame.setBounds(0,0,900,930);

        ImageIcon image=new ImageIcon("D:/jsq/11.jpg");
        JLabel label=new JLabel(image);
        label.setBounds(0,0,900,900);
        frame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));

        JPanel pan=(JPanel)frame.getContentPane();
        pan.setOpaque(false);
        pan.setLayout(null);

        btm logon=new btm("按钮");
        logon.setBounds(63,300,110,72);
      //  logon.setBounds(83,300,110,72);
        pan.add(logon);

        frame.setVisible(true);
        frame.setResizable(false);
       //C:\Users\58472\Desktop
        }
    }
