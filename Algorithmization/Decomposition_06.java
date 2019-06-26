/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Scanner;

/**
 * Task condition:
 * 6. Написать метод(методы), проверяющий, являются ли данные три числа взаимно
 * простыми.
 *
 * @author ArtSCactus
 */
public class Decomposition_06 {

    static void methodLauncher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number A: ");
        int numberA = in.nextInt();
        System.out.print("Enter the number B: ");
        int numberB = in.nextInt();
        System.out.print("Enter the number C: ");
        int numberC = in.nextInt();
        System.out.println("They are mutually simple: " + isMutuallySimple(numberA, numberB, numberC));
    }
    /** Returns true if given 3 elements are mutuallySimple, using gcd from class Decomposition_01.
     * 
     * @param a
     * @param b
     * @param c
     * @return 
     */
    static boolean isMutuallySimple(int a, int b, int c) {
        if (Decomposition_01.gcd(a, b) == 1 & Decomposition_01.gcd(a, c) == 1 & Decomposition_01.gcd(b, c) == 1) {
            return true;
        } else {
            return false;
        }
    }
}
