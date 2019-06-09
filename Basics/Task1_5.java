/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basics;

/**
 *
 * @author ArtSCactus
 */
public class Task1_5 {
    public static String task1_5(int seconds){
    int hours=0;
    int minutes=0;
    while(seconds>=60)
    {
        seconds-=60;
        minutes++;
        hours= minutes==60? hours+1:hours;
        minutes=minutes==60? minutes-60: minutes;
    }
    String hh="";
    String mm="";
    String ss="";
    hh=hours<10? hh+"0"+hours: hh+hours;
        mm=minutes<10? mm+"0"+minutes: mm+minutes;
            ss=seconds<10? ss+"0"+seconds: ss+seconds;

    String result=hh+"ч:"+mm+"мин:"+ss+"с";
    return result;
}
}
