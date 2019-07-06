/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Task condition: 14. Натуральное число, в записи которого n цифр, называется
 * числом Армстронга, если сумма его цифр, возведенная в степень n, равна самому
 * числу. Найти все числа Армстронга от 1 до k. Для решения задачи использовать
 * декомпозицию.
 *
 * @author ArtSCactus
 */
public class Decomposition_14 {

    static void methodLauncher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the seria's end: ");
        int number = in.nextInt();
        System.out.println("The Armstrong numbers: " + Arrays.toString(getArmstrongNumbers(number)));
    }

    /**
     * Returns a massive of numbers between 1 and numberK, where every number is
     * Armstrong number.
     *
     * @param numberK
     * @return
     */
    static int[] getArmstrongNumbers(int numberK) {
        if (numberK < 1) {
            return null;
        }
        int[] armstrongNumbers = new int[0];
        if (numberK == 1) {
            armstrongNumbers = Arrays.copyOf(armstrongNumbers, 1);
            armstrongNumbers[armstrongNumbers.length - 1] = 1;
            return armstrongNumbers;
        }
        for (int number = 1; number <= numberK; number++) {
            if (isArmstrongNumber(number) == true) {
                armstrongNumbers = Arrays.copyOf(armstrongNumbers, armstrongNumbers.length + 1);
                armstrongNumbers[armstrongNumbers.length - 1] = number;
            }
        }
        return armstrongNumbers;
    }

    /**
     * Returns true if the sum of numerals of a given number, raised to a
     * exponent that equal to the number of numerals, is equal to this number.
     *
     * @param number
     * @return
     */
    static boolean isArmstrongNumber(int number) {
        int[] numerals = splitOnNumerals(number);
        int sumOfNumerals = 0;
        for (int numeral : numerals) {
            sumOfNumerals += Math.pow(numeral, numerals.length);
        }
        if (sumOfNumerals == number) {
            return true;
        } else {
            return false;
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
