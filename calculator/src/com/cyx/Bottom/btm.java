package com.cyx.Bottom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class btm {
    public  int Bottom_Firx=61;
    public  int Bottom_Firy=328;
    public  int Bottom_Movex=150;
    public  int Bottom_Movey=105;
    public  int Bottom_Width=120;
    public  int Bottom_height=80;
    public JButton[] MakeButton() {
        String[] button_names = {"m", "p", "(", ")", "!", "t", "%", "sin", "cos", "tan", "cot", "del", "sec", "7", "8",
                "9", "sj", "rq", "csc", "4", "5", "6", "*", "/", "c", "1", "2", "3", "+", "-", "ac", "0", "00", ".", "="};
        JButton[] buttons = new JButton[button_names.length];
        for (int i = 0; i < button_names.length; i++) {

            JButton bt = new JButton(button_names[i]);
            if(i!=button_names.length-1)
            bt.setBounds(Bottom_Firx+(i%6)*Bottom_Movex,Bottom_Firy+i/6*Bottom_Movey,Bottom_Width,Bottom_height);
            else  bt.setBounds(Bottom_Firx+(i%6)*Bottom_Movex,Bottom_Firy+i/6*Bottom_Movey,Bottom_Width+150,Bottom_height);
            // bt.setPreferredSize(new Dimension(Bottom_Width, Bottom_height));

            bt.setBorderPainted(false);
            bt.setBackground(new Color(0, 0, 0, 0));
            bt.setOpaque(false);
            bt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    System.out.println(command);
                }
            });


            buttons[i]=bt;
        }

        return buttons;
    }

    }
