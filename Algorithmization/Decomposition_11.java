/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Task condition: 
 * 11. Написать метод(методы), определяющий, в каком из данных
 * двух чисел больше цифр.
 *
 * @author ArtSCactus
 */
public class Decomposition_11 {

    static void methodLauncher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int numberOne = in.nextInt();
        System.out.print("Enter the first number: ");
        int numberTwo = in.nextInt();
        System.out.println("The number with the biggest amount of numerals is: " + getLongestNumeralsNumber(numberOne, numberTwo));
    }
/** Returns a number, that contains more numerals.
 * 
 * @param numberOne
 * @param numberTwo
 * @return 
 */
    static int getLongestNumeralsNumber(int numberOne, int numberTwo) {
        int[] numeralsOfFirstNumber = splitOnNumerals(numberOne);
        int[] numeralsOfSecondNumber = splitOnNumerals(numberTwo);
        if (numeralsOfFirstNumber.length > numeralsOfSecondNumber.length) {
            return numberOne;
        } else {
            if (numeralsOfFirstNumber.length == numeralsOfSecondNumber.length) {
                System.out.println("They are equals.");
                return 0;
            } else {
                return numberTwo;
            }
        }
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
