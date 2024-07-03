package com.cyx.Bottom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.cyx.Bottom.Bottom_stack_push.BtmStr;

public class btm {
    private String BtmStrPush;
    public  int Bottom_Firx=58;
    public  int Bottom_Firy=325;
    public  int Bottom_Movex=152;
    public  int Bottom_Movey=107;
    public  int Bottom_Width=120;
    public  int Bottom_height=80;

    public String getBtmStrPush() {
        return BtmStrPush;
    }

    public JButton[] MakeButton() {
        String[] button_names = {"M", "Π", "(", ")", "!", "退出", "%", "sin", "cos", "tan", "cot", "del", "sec", "7", "8",
                "9", "时间", "日期", "csc", "4", "5", "6", "X", "÷", "C", "1", "2", "3", "+", "-", "AC", "0", "00", ".", "="};//按钮内容
        JButton[] buttons = new JButton[button_names.length];

        for (int i = 0; i < button_names.length; i++) {

            JButton bt = new JButton(button_names[i]);//对象数组
            if(i!=button_names.length-1)
                bt.setBounds(Bottom_Firx+(i%6)*Bottom_Movex,Bottom_Firy+i/6*Bottom_Movey,Bottom_Width,Bottom_height);
            else  bt.setBounds(Bottom_Firx+(i%6)*Bottom_Movex,Bottom_Firy+i/6*Bottom_Movey,Bottom_Width+150,Bottom_height);
            // bt.setPreferredSize(new Dimension(Bottom_Width, Bottom_height));
            Font font = new Font("宋体", Font.BOLD, 40); // 这里可以自定义字体、样式和大小
            bt.setForeground(Color.WHITE);
            bt.setFont(font);
            bt.setBorderPainted(false);
            bt.setBackground(new Color(0, 0, 0, 0));
            bt.setOpaque(false);
            bt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    Date date=new Date();  //输出时间

                    btm w=new btm();
                    w.BtmStrPush = e.getActionCommand();
                    if(w.BtmStrPush.equals("时间")){
                        System.out.println(date);

                    } else if (w.BtmStrPush.equals("日期")) {

                        SimpleDateFormat dateFormat_min=new SimpleDateFormat();//设置当前时间的格式，为年-月-日 时-分-秒
                        System.out.println(dateFormat_min.format(date));
                        BtmStr="";
                        //输出日期
                    }else if(w.BtmStrPush.equals("X")){

                        w.BtmStrPush="*";
                        Bottom_stack_push a=new Bottom_stack_push();
                        a.pushStr(BtmStr,w);
                        System.out.println(BtmStr);
                    }else if (w.BtmStrPush.equals("÷")){

                        w.BtmStrPush="/";
                        Bottom_stack_push a=new Bottom_stack_push();
                        a.pushStr(BtmStr,w);
                        System.out.println(BtmStr);
                    }else if(w.BtmStrPush.equals("del")){

                        BtmStr = BtmStr.substring(0, BtmStr.length() - 1);
                    }

                }
            });
            buttons[i]=bt;
        }

        return buttons;
    }

}
