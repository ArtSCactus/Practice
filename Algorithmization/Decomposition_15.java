/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Task condition: 15. Найти все натуральные n-значные числа, цифры в которых
 * образуют строго возрастающую последовательность (например, 1234, 5789). Для
 * решения задачи использовать декомпозицию.
 *
 * @author ArtSCactus
 */
public class Decomposition_15 {

    static void methodLauncher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of digits: ");
        int number = in.nextInt();
        System.out.println("Here your numbers: " + Arrays.toString(getNumbers(number)));
    }

    /**
     * Returns true if massive is a numbers with order i, i+1 (12345).
     * Returns false if massive length are 0.
     *
     * @param massive
     * @return
     */
    static boolean isCorrect(int[] massive) {
        if (massive.length == 0) {
            return false;
        }
        if (massive.length == 1) {
            return true;
        }
        for (int index = massive.length - 1; index > 0; index--) {
            if (massive[index - 1] != massive[index] + 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a massive of numbers between 1 and numberK, where every number is
     * Armstrong number.
     *
     * @param numberK
     * @return
     */
    static int[] getNumbers(int numberOfDigits) {
        if (numberOfDigits == 0 || numberOfDigits <= 0) {
            System.out.println("You have entered the number of zero bit or this number is <0.");
            return null;
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
