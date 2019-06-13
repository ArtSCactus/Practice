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
public class MassiveOfMassives_07 {
    public static void doTask(){
          // declaration of massive/variables and it's initialization
        Scanner in = new Scanner(System.in);
        System.out.println("Enter matrix order: ");
        int matrixOrder = in.nextInt();
        if (matrixOrder % 2 != 0) {
            System.out.println("Matrix order must be even!");
            return;
        }
        double[][] matrix = new double[matrixOrder][matrixOrder];
        int positiveNumberCounter=0;
        // matrix filling
        for (int indexY = 0; indexY < matrixOrder; indexY++) {
            for (int indexX = 0; indexX < matrixOrder; indexX++) {
                    matrix[indexX][indexY] = Math.sin((indexX*indexX-indexY*indexY)/matrixOrder);
                    positiveNumberCounter= matrix[indexX][indexY]>0? positiveNumberCounter+1:positiveNumberCounter;
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
        System.out.println("Amount of positive numbers: "+ positiveNumberCounter);
    }
}
