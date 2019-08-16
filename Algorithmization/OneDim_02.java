/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Task condition: 2. Дана последовательность действительных чисел а1 ,а2 ,..., ап. Заменить все ее члены, большие данного Z, этим
числом. Подсчитать количество замен.
 *
 * @author ArtSCactus
 */
public class OneDim_02 {

    public static void doTask() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number Z: ");
        int numberZ = in.nextInt();
        System.out.println("Enter the row size: ");
        double[] row = new double[in.nextInt()];
        for (int index = 0; index < row.length; index++) {
            System.out.println("Enter element [" + index + "] (double):");
            row[index] = in.nextDouble();
        }
        for (int index = 0; index < row.length; index++) {
            if (row[index] > numberZ) {
                row[index] = numberZ;
            }
        }
        System.out.print("New row:");
        System.out.println(Arrays.toString(row));

    }
}
