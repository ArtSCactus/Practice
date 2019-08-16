/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Task condition: 3. Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
положительных и нулевых элементов.
 *
 * @author ArtSCactus
 */
public class OneDim_03 {

    public static void doTask() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter massive size: ");
        double[] massive = new double[in.nextInt()];
        int posCounter = 0;
        int negCounter = 0;
        int zeroCounter = 0;
        System.out.println("Input massive elements: ");
        for (int index = 0; index < massive.length; index++) {
            System.out.print("Element [" + index + "](double): ");
            massive[index] = in.nextDouble();
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
        System.out.println("Massive: " + Arrays.toString(massive));
        System.out.println("Positive numbesr: " + posCounter);
        System.out.println("Negative numbesr: " + negCounter);
        System.out.println("Number of 0: " + zeroCounter);
    }
}
