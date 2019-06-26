/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

/**
 *Task conditions:
 * 2. Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.
 * @author ArtSCactus
 */
public class Decomposition_02 {
    /** Returns a gcd (greatest common divisior) of 4 number.
     * 
     * @param a
     * @param b
     * @param c
     * @param d
     * @return 
     */
    static int gcd(int a, int b, int c, int d){
               int result=1;
        for (int divisior=1; divisior<10; divisior++){
            if (a%divisior==0 & b%divisior==0 & c%divisior==0 & d%divisior==0)result*=divisior;
        }
          return result;  
    }
}
