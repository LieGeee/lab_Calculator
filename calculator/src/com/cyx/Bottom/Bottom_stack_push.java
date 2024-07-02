package com.cyx.Bottom;

import java.util.Stack;

public class Bottom_stack_push extends btm{
    private final boolean[][] BtmK =new boolean[1000][1000];
    private String BtmStr;
    public Stack<String> BtmStk = new Stack<>();
    private int pos;
    public Bottom_stack_push(String title) {
        super(title);
    }

    public String getBtmStr() {
        return BtmStr;
    }

    public void setBtmStr(String BtmStr) {
        this.BtmStr = BtmStr;
    }
    public void pushStr(char BtmStrPush,String BtmStr) {
        if( BtmStrPush=='(' || BtmStrPush==')'){
            BtmStr = BtmStr + BtmStrPush;
            pos++;
        }
        BtmStk.push(this.BtmStr);
    }
    public Boolean checkds

}
