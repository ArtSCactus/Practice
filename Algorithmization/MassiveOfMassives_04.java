/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Scanner;

/**
 * Task condition:
 *4. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 * 1  2   3  ... n
 * n n-1 n-2 ... 1
 * 1  2   3  ... n
 * n n-1 n-2 ... 1
 * ... ... ... ... ...
 * n n-1 n-2 ... 1
 * @author ArtSCactus
 */
public class MassiveOfMassives_04 {

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
        int element;
        for (int indexY = 0; indexY < matrixOrder; indexY++) {
            if (indexY % 2 == 0) {
                element = 1;
                for (int indexX = 0; indexX < matrixOrder; indexX++) {
                    matrix[indexX][indexY] = element;
                    element++;
                }
            } else {
                element = matrixOrder;
                for (int indexX = 0; indexX < matrixOrder; indexX++) {
                    matrix[indexX][indexY] = element;
                    element--;
                }
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
