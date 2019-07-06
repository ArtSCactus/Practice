/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Task condition: 16. Написать программу, определяющую сумму n - значных чисел,
 * содержащих только нечетные цифры. Определить также, сколько четных цифр в
 * найденной сумме. Для решения задачи использовать декомпозицию.
 *
 * @author ArtSCactus
 */
public class Decomposition_16 {

    static void methodLauncher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of digits: ");
        int number = in.nextInt();
        System.out.println("Sum of elements: " + getSumOfNumbers(number));
    }

    /**
     * Returns true if all elements are odd. Returns false if massive length are
     * 0.
     *
     * @param massive
     * @return
     */
    static boolean isCorrect(int[] massive) {
        for (int number : massive) {
            if (number % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns sum of elements from a massive of numbers between 1 and numberK, where every number is
     * Armstrong number.
     *
     * @param numberK
     * @return
     */
    static int getSumOfNumbers(int numberOfDigits) {
        if (numberOfDigits == 0 || numberOfDigits <= 0) {
            System.out.println("You have entered the number of zero bit or this number is <0.");
            return 0;
        }
        int[] numerals;
        int[] result = new int[0];
        int bit;
        if (numberOfDigits == 1) {
            bit = 1;
        } else {
            bit = (int) Math.pow(10, numberOfDigits);
        }
        for (int number = bit; number < (bit * 10); number += 1) {
            numerals = splitOnNumerals(number);
            if (isCorrect(numerals) == true) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = number;
            }
        }
        int finalSum=0;
        for (int number : result)
            finalSum+=number;
        return finalSum;
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
