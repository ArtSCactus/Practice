/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ArtSCactus
 */
public class OneDim_04 {

    public static void doTask() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter massive size: ");
        double[] massive = new double[in.nextInt()];
        System.out.println("Input massive elements: ");
        for (int index = 0; index < massive.length; index++) {
                                    System.out.print("Element ["+index+"](double): ");
            massive[index] = in.nextDouble();
        }
        double theSmallest = massive[0];
        double theBiggest = 0;
        int theSmallestIndexSaver = 0;
        int theBiggestIndexSaver = 0;
        for (int index = 0; index < massive.length; index++) {
            if (massive[index] < theSmallest) {
                theSmallest = massive[index];
                theSmallestIndexSaver = index;
            }
            if (massive[index] > theBiggest) {
                theBiggest = massive[index];
                theBiggestIndexSaver = index;
            }
        }
        massive[theSmallestIndexSaver] = theBiggest;
        massive[theBiggestIndexSaver] = theSmallest;
        System.out.println("Massive: " + Arrays.toString(massive));
    }
}
