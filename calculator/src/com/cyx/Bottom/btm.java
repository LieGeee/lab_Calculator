package com.cyx.Bottom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.cyx.Bottom.Bottom_stack_push.BtmStr;

public class btm extends JFrame {
    private String BtmStrPush;
    private JTextArea tf; // 定义JTextArea为类的成员变量
    public int Bottom_Firx = 58;
    public int Bottom_Firy = 325;
    public int Bottom_Movex = 152;
    public int Bottom_Movey = 107;
    public int Bottom_Width = 120;
    public int Bottom_height = 80;
    public static int timee=1;
    public static int datee=2;
    public static int fucc=3;

    public btm() {
        // 初始化JTextArea并添加到窗口
        tf = new JTextArea();
        tf.setBounds(50, 50, 900, 200);
        tf.setBackground(Color.black);
        tf.setForeground(Color.white);
        tf.setFont(new Font("宋体", Font.PLAIN, 30));
        tf.setLineWrap(true); // 自动换行
        tf.setWrapStyleWord(true); // 换行不断字
        add(tf); // 确保JTextArea添加到JFrame

        // 设置窗口布局为null以使用绝对布局
        setLayout(null);
    }

    public String getBtmStrPush() {
        return BtmStrPush;
    }

    public JButton[] MakeButton() {
        String[] button_names = {"M", "Π", "(", ")", "!", "退出", "%", "sin", "cos", "tan", "cot", "del", "sec", "7", "8",
                "9", "时间", "日期", "csc", "4", "5", "6", "X", "÷", "C", "1", "2", "3", "+", "-", "AC", "0", "00", ".", "="};
        JButton[] buttons = new JButton[button_names.length];

        for (int i = 0; i < button_names.length; i++) {
            JButton bt = new JButton(button_names[i]);
            if (i != button_names.length - 1)
                bt.setBounds(Bottom_Firx + (i % 6) * Bottom_Movex, Bottom_Firy + i / 6 * Bottom_Movey, Bottom_Width, Bottom_height);
            else
                bt.setBounds(Bottom_Firx + (i % 6) * Bottom_Movex, Bottom_Firy + i / 6 * Bottom_Movey, Bottom_Width + 150, Bottom_height);

            Font font = new Font("宋体", Font.BOLD, 40);
            bt.setForeground(Color.WHITE);
            bt.setFont(font);
            bt.setBorderPainted(false);
            bt.setBackground(new Color(0, 0, 0, 0));
            bt.setOpaque(false);
            bt.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    BtmStrPush = e.getActionCommand();
                    handleButtonPress(BtmStrPush);
                }
            });
            buttons[i] = bt;
            add(bt); // 确保按钮添加到JFrame
        }

        return buttons;
    }

    private void handleButtonPress(String command) {

        Date date = new Date();
        int k=0;
        if (command.equals("时间")) {
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            tf.append(timeFormat.format(date) + "\n"); // 添加换行符
            BtmStr = "";
            k=timee;
        } else if (command.equals("日期")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            tf.append(dateFormat.format(date) + "\n");
            BtmStr = "";
            k=datee;
        } else if (command.equals("X")) {
            command = "*";
        } else if (command.equals("÷")) {
            command = "/";
        } else if (command.equals("del")) {
            if (BtmStr.length() > 0) {
                BtmStr = BtmStr.substring(0, BtmStr.length() - 1);
            }
        } else if (command.equals("=")) {
            Bottom_stack_push a = new Bottom_stack_push();
            a.extract(BtmStr);          //把 字符串传入
            BtmStr = "";
            k=fucc;
        } else if (command.equals("AC") ||command.equals("C")) {
            BtmStr = "";
            k=fucc;
        }

        Bottom_stack_push a = new Bottom_stack_push();
       if(k!=fucc) {
           btm w = new btm();
           w.BtmStrPush = command;

           a.pushStr(BtmStr, w);
           // System.out.println(BtmStr);
       }
        switch (k){
            case 0: case 3:tf.setText(BtmStr);
            break;
            case 1:  SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                tf.append(dateFormat.format(date) + "\n");
                tf.setText(dateFormat.format(date) + "\n");
                BtmStr = "";
                break;
            case 2:  SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            tf.append(dateFormat1.format(date) + "\n");
            BtmStr = "";
            tf.setText(dateFormat1.format(date) + "\n");
            break;
        }
        k=0;


    }

    public static void main(String[] args) {
        btm frame = new btm();
        frame.setTitle("Calculator");
        //frame.setSize(1000, 800);
        frame.setBounds(50,50,980,1010);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JButton[] buttons = frame.MakeButton();
        for (JButton button : buttons) {
            frame.add(button); // 确保所有按钮添加到JFrame
        }
    }
}
