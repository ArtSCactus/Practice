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
public class MassiveOfMassives_10 {
    public static void doTask(){
           // declaration of massive/variables and it's initialization
        Scanner in = new Scanner(System.in);
        System.out.println("Enter matrix size by: ");
        int matrixSize = in.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        System.out.println("Type of cell call: cell[X][Y]");
        System.out.println("Input massive elements: ");
        for (int indexY = 0; indexY < matrixSize; indexY++) {
            for (int indexX = 0; indexX < matrixSize; indexX++) {
                System.out.print("Element [" + indexX + "][" + indexY + "](int): ");
                matrix[indexX][indexY] = in.nextInt();
            }
        }
        //  source matrix output
        System.out.println("Source matrix: ");
        for (int indexY = 0; indexY < matrixSize; indexY++) {
            for (int indexX = 0; indexX < matrixSize; indexX++) {
                System.out.print(matrix[indexX][indexY] + " ");
            }
            System.out.println();
        }
        // output by task condition
        System.out.print("Positive elements of main diagonal: ");
        for (int index = 0; index < matrixSize; index++) {
                if (matrix[index][index]>0) System.out.print(matrix[index][index]);
        }
        System.out.println();
    }
}
