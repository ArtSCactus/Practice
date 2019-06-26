/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

/**
 *Task condition: 
 * 1. Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
натуральных чисел: НОК(А,В)= А*В/НОД(А,В)
 * @author ArtSCactus
 */
public class Decomposition_01 {
    /** Returns result of task computing.
     * 
     * @param numberA
     * @param numberB
     * @return 
     */
    static int doTask(int numberA, int numberB){
        return (numberA*numberB)/gcd(numberA, numberB);
    }
/** returns a GCD of number A and umber B
 * @param a
 * @param b
 * @return
 */
    static int gcd(int a, int b){
        int result=1;
        for (int divisior=1; divisior<10; divisior++){
            if (a%divisior==0 & b%divisior==0)result*=divisior;
        }
          return result;  
    }  
}
