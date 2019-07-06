/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Task condition: 17. Из заданного числа вычли сумму его цифр. Из результата
 * вновь вычли сумму его цифр и т.д. Сколько таких действий надо произвести,
 * чтобы получился нуль? Для решения задачи использовать декомпозицию.
 *
 * @author ArtSCactus
 */
public class Decomposition_17 {

    static void methodLauncher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of digits: ");
        int number = in.nextInt();
        System.out.println("Sum of elements: " + getAmountOfSteps(number));
    }

    /**
     * Returns the required number of steps to subtract the sum of digits from a
     * number, then from the result, etc. until the amount is zero.
     *
     * @param number
     * @return
     */
    static int getAmountOfSteps(int number) {
        int counter = 0;
        int sum = 0;
        int[] numerals = splitOnNumerals(number);
        for (int numeral : numerals) {
            sum += numeral;
        }
        int temp = number;
        while (temp != 0) {
            temp -= sum;
            counter++;
        }
        return counter;
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
