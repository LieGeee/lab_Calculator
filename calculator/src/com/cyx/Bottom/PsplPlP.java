package com.cyx.Bottom;
import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

import static com.cyx.Bottom.Bottom_stack_push.BtmStr;

public class PsplPlP {

    //获取字符串,把字符串放到队列里,队列控制元素个数,

    /*
    数字大小:PspSz
    显示长度(队列长度):PspLs
    显示的队列名字:PspQue
    计算位置:PspSz
    */
    //textfield /lable
    private  final int PspSz=8;       //后续根据使用情况更改
    private  final int PspLs=18;      //后续根据需求更改
    private  final int PLocX=121;          //开始的x坐标
    private  final int PLocY=121;         //开始的y坐标




    public void PspCac(int PLocX,int PLocY,int PspSz,int PspLs){
        PLocX =this.PLocX;
        PLocY =this.PLocY;
        PspLs =this.PspLs;
        PspSz =this.PspSz;
        String PspBtr;          //子串
        if(PspLs>=BtmStr.length()){
            PspBtr=BtmStr;
            //      PLocX-BtmStr.length()*PspSz,PLocY;      //位置,输出PspBtr
        }
        else {

            PspBtr=BtmStr.substring(BtmStr.length()-PspLs);     //从这里开始截取长度
            //      PLocX-BtmStr.length()*PspSz,PLocY;      //位置,输出PspBtr
        }
    }
    public static void main(String[] args) {
        JTextField textField = new JTextField();
        textField.setText(BtmStr);
    }



}
