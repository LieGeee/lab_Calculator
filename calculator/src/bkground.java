import com.cyx.Bottom.btm;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;


public class bkground {

    public bkground(){};


    public void show(){
        btm frame=new btm();
     frame.setLayout(null);
        frame.setBounds(50,50,980,1010);

        ImageIcon image=new ImageIcon("D:\\lab_school\\lab_Calculator\\calculator\\image\\BJ.jpg");
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

        btm q = new btm();
//        q.setTitle("Calculator");
//        q.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        q.setVisible(true);

//        JButton[] buttons = q.MakeButton();
//        for (JButton button : buttons) {
//            q.add(button); // 确保所有按钮添加到JFrame

        frame.setVisible(true);
        frame.setResizable(false);
        //C:\Users\58472\Desktop



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
