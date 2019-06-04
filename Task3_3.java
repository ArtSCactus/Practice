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
public class Task3_3 {
    public static int  task3_3(){
        int counter=0;
        int summ=0;
        while (counter<100){
            summ+=counter*counter;
            counter++;
        }
        return summ;
    }
}
