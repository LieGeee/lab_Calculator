package com.cyx.Bottom;

import javax.swing.*;
import java.awt.*;

public class btm {

    public JButton[] MakeButton() {
        String[] button_names = {"m", "p", "(", ")", "!", "t", "%", "sin", "cos", "tan", "cot", "del", "sec", "7", "8",
                "9", "sj", "rq", "csc", "4", "5", "6", "*", "/", "c", "1", "2", "3", "+", "-", "ac", "0", "00", ".", "="};
        JButton[] buttons = new JButton[button_names.length];
        for (int i = 0; i < button_names.length; i++) {
            JButton bt = new JButton(button_names[i]);
            bt.setPreferredSize(new Dimension(120, 80));
            buttons[i]=bt;
        }
        return buttons;
    }

    }
