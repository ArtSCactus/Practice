/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package step1tasks.Practice;

/**
 *
 * @author ArtSCactus
 */
public class Task2_2 {
    public static int task2_2(int a, int b, int c, int d){
        int minAB=0;
        if(a<b) minAB=a;
        else minAB=b;
        int minCD=0;
        if (c<d) minCD=c;
        else minCD=d;
        if (minAB>minCD) return minAB;
        else return minCD;
    }
}
