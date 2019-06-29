/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Task condition: 10. Дано натуральное число N. Написать метод(методы) для
 * формирования массива, элементами которого являются цифры числа N.
 *
 * @author ArtSCactus
 */
public class Decomposition_10 {

    static void methodLauncher(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number to split on numerals: ");
        int number=in.nextInt();
        System.out.println("Numerals: "+Arrays.toString(splitOnNumerals(number)));
    }
    /** Returns a numerals  of given number in a massive.
     * 
     * @param number
     * @return 
     */
    static int[] splitOnNumerals(int number) {
        int numeralsCounter = 0;
        int temp=number;
        while (temp>0){
            numeralsCounter++;
            temp/=10;
        }
        int[] numerals = new int[numeralsCounter];
        numeralsCounter=0;
        while (number > 0) {
            numerals[numeralsCounter] = number % 10;
            numeralsCounter++;
            number /= 10;
            Arrays.copyOf(numerals, numeralsCounter);
        }
        return numerals;
    }
}
