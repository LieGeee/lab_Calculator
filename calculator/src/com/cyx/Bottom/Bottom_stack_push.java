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
    public int cmp(String x)
    {

        if(x.equals("+")||x.equals("-"))return 1;
        if(x.equals("*")||x.equals("/"))return 2;
        if(x.equals("sin")||x.equals("cos")||x.equals("tan")||x.equals("cot")||x.equals("csc")||x.equals("sec")||x.equals("!"))return 3;
        return 0;
    }
    public void extract(String s)
    {
       // System.out.println(s);
        String[]s2=new String[1000];
        int j=0;

        for(int i=0;i<s.length();i++)
        {
            if(s2[j]==null)
                s2[j]="";
          if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)=='/'||s.charAt(i)=='!'||s.charAt(i)=='%'||s.charAt(i)==')'||s.charAt(i)=='(')
          {

                if(i!=0&&s.charAt(i-1)!='+'&&s.charAt(i-1)!='-'&&s.charAt(i-1)!='*'&&s.charAt(i-1)!='/'&&s.charAt(i-1)!='!'&&s.charAt(i-1)!='%'&&s.charAt(i-1)!='('&&s.charAt(i-1)!=')')
                    j+=1;
              if(s2[j]==null)
                  s2[j]="";
              s2[j]+=s.charAt(i);
              j+=1;
              continue;
          }else if(s.charAt(i)=='s'||s.charAt(i)=='c'||s.charAt(i)=='t')
          {

              if(i!=0&&s.charAt(i-1)!='+'&&s.charAt(i-1)!='-'&&s.charAt(i-1)!='*'&&s.charAt(i-1)!='/'&&s.charAt(i-1)!='!'&&s.charAt(i-1)!='%'&&s.charAt(i-1)!='('&&s.charAt(i)!=')')j+=1;
              if(s2[j]==null)s2[j]="";
              s2[j]+=s.charAt(i);
              s2[j]+=s.charAt(i+1);
              s2[j]+=s.charAt(i+2);
              i+=2;
              j+=1;
              continue;
          }
          s2[j]+=s.charAt(i);
        }
        if(s2[j]==null)j-=1;
//        for(int i=0;i<=j;i++)
//        {
//            System.out.printf(s2[i]+' ');
//
//        }
       // System.out.println();
        if(this.check(s2,j))
        {
            this.infix_suffix(s2,j);
            System.out.println("right");
        }else
        {
            System.out.println("error");
        }
    }
    public boolean check(String[] s1,int size)
    {

        for(int i=0;i<size;i++)
        {
          //  System.out.println(size);
            if(this.cmp(s1[i])==0)continue;
            else if(this.cmp(s1[i])==1||this.cmp(s1[i])==2)
            {
                if(this.cmp(s1[i+1])==1||this.cmp(s1[i+1])==2)
                {

                    return false;

                }
            }
            else if(this.cmp(s1[i])==3)
            {
                if(this.cmp(s1[i+1])==3)return false;
            }

        }
        return true;
    }

    public void infix_suffix (String[] s1,int size)
    {
        int index=0;
        String[]s2=new String[1000];
        Stack<String> st = new Stack<String>();
        //if(s2[i]=='Π')s2[i]=Math.PI;
//        for(int i=0;i<=size;i++)
//        {
//            System.out.printf(s1[i]+" ");
//        }
//        System.out.println();
        for(int i=0;i<=size;i++)
        {
            if(s1[i].equals("(")) {

                st.push(s1[i]);
            }
            else if(s1[i].equals(")"))
            {
                System.out.println();
                while(!st.peek().equals("("))
                {
                    System.out.println();
                    s2[index++]=st.peek();
                    st.pop();
                }
                st.pop();
            }
            else if(this.cmp(s1[i])==0)
            {
                //if(s1[i].equals(")"))System.out.println();
                s2[index++]=s1[i];
            }
            else if(this.cmp(s1[i])==1)
            {
                if(st.empty()||this.cmp(s1[i])>this.cmp(st.peek())||st.peek()=="(")
                {
                    st.push(s1[i]);
                }else
                {
                    s2[index++]= st.pop();;

                    st.push(s1[i]);
                }
            }
            else if(this.cmp(s1[i])==2)
            {
                if(st.empty()||this.cmp(s1[i])>this.cmp(st.peek())||st.peek()=="(")
                {
                    st.push(s1[i]);
                }else
                {
                    s2[index++]= st.pop();;
                    st.pop();
                    st.push(s1[i]);
                }
            }
            else if(this.cmp(s1[i])==3)
            {
                if(st.empty()||this.cmp(s1[i])>this.cmp(st.peek())||st.peek()=="(")
                {
                    st.push(s1[i]);
                }else
                {
                    s2[index++]= st.pop();;
                    st.pop();
                    st.push(s1[i]);
                }
            }
        }
        while(!st.empty())
        {
            s2[index++]=st.peek();
            st.pop();
        }
//        for(int i=0;i<index;i++)
//        {
//            System.out.printf(s2[i]+" ");
//        }
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
                if (stack.isEmpty()) {   //如果栈为空，没有左括号可以匹配                                                                                                        ;;
                    accumulatedLen = 0;
                } else {
                    int matchedPos = stack.pop(); //从最近的'('作为起点
                    int matchedLen = i - matchedPos + 1;	//计算两括号间的长度                                                                                       ;;

                    if (stack.isEmpty()) {			//如果栈为空，没有左括号可以匹配
                        accumulatedLen += matchedLen;
                        matchedLen = accumulatedLen;	//更新当前匹配括号序列长度                                                                                             ;
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
