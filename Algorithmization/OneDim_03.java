/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Scanner;

/**
 *
 * @author ArtSCactus
 */
public class OneDim_03 {

    public static void doTask() {
        Scanner in = new Scanner("System.in");
        System.out.println("Enter massive size: ");
        int[] massive = new int[in.nextInt()];
        int posCounter = 0;
        int negCounter = 0;
        int zeroCounter = 0;
        for (int index = 0; index < massive.length; index++) {
            massive[index] = in.nextInt();
            if (massive[index] > 0) {
                posCounter++;
            } else {
                if (massive[index] == 0) {
                    zeroCounter++;
                } else {
                    negCounter++;
                }
            }
        }
        System.out.println("Positive numbesr: " + posCounter);
        System.out.println("Negative numbesr: " + negCounter);
        System.out.println("Number of 0: " + zeroCounter);
    }
}
