/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Task condition: 13. Два простых числа называются «близнецами», если они
 * отличаются друг от друга на 2 (например, 41 и 43). Найти и напечатать все
 * пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше
 * 2. Для решения задачи использовать декомпозицию.
 *
 * @author ArtSCactus
 */
public class Decomposition_13 {

    static void methodLauncher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the seria start: ");
        int numberN = in.nextInt();
        System.out.println("The 'twins' numbers is: " + Arrays.toString(getPairs(numberN)));
    }

    /**
     *  Returns a massive of numbers, wich less, than numberN and sum of numerals
     * will give numberK.
     * Number n must be not less, than 2.
     *
     * @param numberK
     * @param numberN
     * @return
     */
    static int[] getPairs(int n) {
        if (n < 2) {
            System.out.println("Number n are less than 2.");
            return null;
        }
                int[] pairs = new int[0];
        for (int mainNumber = n; mainNumber < 2 * n; mainNumber++) {
            for (int number = n; number + 1 < 2 * n; number++) {
                if (isTwins(mainNumber, number) == true) {
                    pairs = Arrays.copyOf(pairs, pairs.length + 2);
                    pairs[pairs.length - 2] = mainNumber;
                    pairs[pairs.length - 1] = number;
                }
            }
        }
        return pairs;
    }

    /**
     * Returns true if difference between two numbers are 2 or -2, if not,
     * returns false.
     *
     * @param numberA
     * @param numberB
     * @return
     */
    static boolean isTwins(int numberA, int numberB) {
        if (numberB - numberA == 2 || numberB - numberA == -2) {
            return true;
        } else {
            return false;
        }
    }
}
