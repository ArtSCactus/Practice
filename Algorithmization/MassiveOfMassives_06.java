/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Scanner;

/**
 * Task condition: 6. Сформировать квадратную матрицу порядка n по заданному
 * образцу(n - четное): 1 1 1 ... 1 1 1 0 1 1 ... 1 1 0 0 0 1 ... 1 0 0 ... ...
 * ... 0 1 1 ... 1 1 0 1 1 1 ... 1 1 1
 *
 * @author ArtSCactus
 */
public class MassiveOfMassives_06 {

    public static void doTask() {
        // declaration of massive/variables and it's initialization
        Scanner in = new Scanner(System.in);
        System.out.println("Enter matrix order: ");
        int matrixOrder = in.nextInt();
        if (matrixOrder % 2 != 0) {
            System.out.println("Matrix order must be even!");
            return;
        }
        int[][] matrix = new int[matrixOrder][matrixOrder];
        // matrix filling
        int zeroPointStart = -1;
        int zeroPointEnd = matrixOrder;
        boolean reverseOrderOfFilling = false;
        for (int indexY = 0; indexY < matrixOrder; indexY++) {
            if (zeroPointEnd - zeroPointStart == 1) {
                reverseOrderOfFilling = true;
                zeroPointStart--;
                zeroPointEnd++;
            }
            for (int indexX = 0; indexX < matrixOrder; indexX++) {
                if (indexX <= zeroPointStart || indexX >= zeroPointEnd) {
                    matrix[indexX][indexY] = 0;
                } else {
                    matrix[indexX][indexY] = 1;
                }
            }
            if (reverseOrderOfFilling == false) {
                zeroPointStart++;
                zeroPointEnd--;
            } else {
                zeroPointStart--;
                zeroPointEnd++;
            }

        }
        // matrix output
        System.out.println("Your matrix: ");
        for (int indexY = 0; indexY < matrixOrder; indexY++) {
            for (int indexX = 0; indexX < matrixOrder; indexX++) {
                System.out.print(matrix[indexX][indexY] + " ");
            }
            System.out.println();
        }
    }
}
