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
public class MassiveOfMassives_05 {
    public static void  doTask(){
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
        int element=0;
        int zeroPoint=matrixOrder;
        for (int indexY = 0; indexY < matrixOrder; indexY++) {
                element++;
                for (int indexX = 0; indexX < matrixOrder; indexX++) {
                    if (indexX>=zeroPoint) matrix[indexX][indexY] = 0;
                    else  matrix[indexX][indexY] = element;
                }
       zeroPoint--;
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
