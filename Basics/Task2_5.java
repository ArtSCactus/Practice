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
public class Task2_5 {
    public static int task2_5(int x){
        int result=0;
        if (x==3) result=x*x-3*x+9;
        else result=1/(x*x*x+6);
        return result;
    }
}
