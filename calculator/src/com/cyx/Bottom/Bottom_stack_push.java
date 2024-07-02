package com.cyx.Bottom;

import com.cyx.Bottom.btm;
import java.util.Stack;

public class Bottom_stack_push {
    public static Integer[] BtmK =new Integer[1000];
    public static String BtmStr = "";
    public static int PosPushStr=0;
    public Stack<String> BtmStk = new Stack<>();

/*
    public String getBtmStr() {
        return BtmStr;
    }
*/

  /*  public void setBtmStr(String BtmStr) {
        this.BtmStr = BtmStr;
    }*/
    public void pushStr(String BtmStrPush,btm a) {
        BtmStrPush=a.getBtmStrPush();
        if(BtmStrPush.equals("(")){
            BtmK[PosPushStr] =0;
            PosPushStr++;
        } else if (BtmStrPush.equals(")")) {
            BtmK[PosPushStr] =1;
            PosPushStr++;
        }
        BtmStr = BtmStr + BtmStrPush;
        BtmStk.push(BtmStrPush);
    }


//    public String PsplPlP(String a) {
//       String k=getBtmStrPush();
//
//    }
    public void Calculate(String s)
    {
        Stack<String> st = new Stack< >();


    }


    public int CkBks(String s) {
        s=BtmStr;
        if (s == null) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int maxLen = 0;
        int accumulatedLen = 0;

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {   //如果栈为空，没有左括号可以匹配
                    accumulatedLen = 0;
                } else {
                    int matchedPos = stack.pop(); //从最近的'('作为起点
                    int matchedLen = i - matchedPos + 1;	//计算两括号间的长度

                    if (stack.isEmpty()) {			//如果栈为空，没有左括号可以匹配
                        accumulatedLen += matchedLen;
                        matchedLen = accumulatedLen;	//更新当前匹配括号序列长度
                    } else {
                        matchedLen = i - stack.peek();
                    }
                    maxLen = Math.max(maxLen, matchedLen);
                }
            }
        }
        return maxLen;
}

}
