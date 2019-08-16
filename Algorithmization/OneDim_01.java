/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Scanner;

/**
 * Task condition: 1. В массив A [N] занесены натуральные числа. Найти сумму тех
 * элементов, которые кратны данному К.
 *
 * @author ArtSCactus
 */
public class OneDim_01 {

    public static void doTask() {
        Scanner in = new Scanner(System.in);
        System.out.println("Input massive size [N]: ");
        int massiveSize = in.nextInt();
        System.out.println("Enter element K:");
        int elementK = in.nextInt();
        int result = 0;
        int[] massiveA = new int[massiveSize];
        for (int index = 0; index < massiveSize; index++) {
            System.out.println("Enter number [" + index + "]: ");
            massiveA[index] = in.nextInt();
        }
        for (int currentElement : massiveA) {
            if (currentElement % elementK == 0) {
                result += currentElement;
            }
        }
        System.out.println("final amount: " + result);
    }
}
