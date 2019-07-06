/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Arrays;
import java.util.Scanner;

/**
 *Task condition: 
 * 12. Даны натуральные числа К и N. Написать метод(методы) формирования массива А, 
 * элементами которого являются числа, сумма цифр которых равна К и которые не большее N.
 * @author ArtSCactus
 */
public class Decomposition_12 {
    
    static void methodLauncher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int numberOne = in.nextInt();
        System.out.print("Enter the first number: ");
        int numberTwo = in.nextInt();
        System.out.println("The method output: " + Arrays.toString(getNumbers(numberOne, numberTwo)));
    }
/** Returns a massive of numbers, wich less, then numberN 
 * and sum of numerals will give numberK.
 * 
 * @param numberK
 * @param numberN
 * @return 
 */
    static int[] getNumbers(int numberK, int numberN) {
        int[] result = new int[0];
        int[] tempNumerals;
        int tempSum=0;
        for (int number=1; number<numberN; number++){
            tempSum=0;
              tempNumerals=splitOnNumerals(number);
              for (int numeral : tempNumerals)
                  tempSum+=numeral;
              if (tempSum==numberK & tempSum<numberN) {
                  result=Arrays.copyOf(result, result.length+1);
                  result[result.length-1]=number;
              }
        }
      return result;
    }

    /**
     * Returns a numerals of given number in a massive.
     *
     * @param number
     * @return
     */
    static int[] splitOnNumerals(int number) {
        int numeralsCounter = 0;
        int temp = number;
        while (temp > 0) {
            numeralsCounter++;
            temp /= 10;
        }
        int[] numerals = new int[numeralsCounter];
        numeralsCounter = 0;
        while (number > 0) {
            numerals[numeralsCounter] = number % 10;
            numeralsCounter++;
            number /= 10;
            Arrays.copyOf(numerals, numeralsCounter);
        }
        return numerals;
    }
}
