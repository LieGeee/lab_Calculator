import com.cyx.Bottom.btm;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;


public class bkground {

    public bkground(){};


    public void show(){
        JFrame frame=new JFrame();
     frame.setLayout(null);
        frame.setBounds(50,50,980,1010);

        ImageIcon image=new ImageIcon("D:\\lab_school\\lab_Calculator\\calculator\\image\\bj.jpg");
        JLabel label=new JLabel(image);
        label.setBounds(-8,-15,980,1010);
        frame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));

        JPanel pan=(JPanel)frame.getContentPane();
        pan.setOpaque(false);
        pan.setLayout(null);

        btm logon=new btm();

        JButton jb[]=logon.MakeButton();
        //jb[2].setBounds(61,328,120,80);
       // pan.add(jb[2]);
        for(int i=0;i<jb.length;i++)
        {
            pan.add(jb[i]);
        }
        //  logon.setBounds(83,300,110,72);


        frame.setVisible(true);
        frame.setResizable(false);
        //C:\Users\58472\Desktop

    }

}
