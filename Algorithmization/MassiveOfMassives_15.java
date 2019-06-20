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
public class MassiveOfMassives_15 {

    public static void doTask() {
        // declaration of massive/variables and it's initialization
        Scanner in = new Scanner(System.in);
        System.out.println("Enter matrix size by X: ");
        int sideSize = in.nextInt();
        System.out.println("Enter matrix size by Y: ");
        int downSize = in.nextInt();
        int[][] matrix = new int[sideSize][downSize];
        System.out.println("Type of cell call: cell[X][Y]");
        System.out.println("Input massive elements: ");
        for (int indexY = 0; indexY < downSize; indexY++) {
            for (int indexX = 0; indexX < sideSize; indexX++) {
                System.out.print("Element [" + indexX + "][" + indexY + "](int): ");
                matrix[indexX][indexY] = in.nextInt();
            }
        }
        //  source matrix output
        System.out.println("Source matrix: ");
        for (int indexY = 0; indexY < downSize; indexY++) {
            for (int indexX = 0; indexX < sideSize; indexX++) {
                System.out.print(matrix[indexX][indexY] + " ");
            }
            System.out.println();
        }
        // output by task condition
        int theBiggestElement = Integer.MIN_VALUE;
        for (int indexY = 0; indexY < downSize; indexY++) {
            for (int indexX = 0; indexX < sideSize; indexX++) {
                if (matrix[indexX][indexY] > theBiggestElement) {
                    theBiggestElement = matrix[indexX][indexY];
                }
            }
        }
        for (int indexY = 0; indexY < downSize; indexY++) {
            for (int indexX = 0; indexX < sideSize; indexX++) {
                if (matrix[indexX][indexY] % 2 != 0) {
                    matrix[indexX][indexY] = theBiggestElement;
                }
            }
        }
        System.out.println("The biggest element: "+theBiggestElement);
         System.out.println("New matrix: ");
        for (int indexY = 0; indexY < downSize; indexY++) {
            for (int indexX = 0; indexX < sideSize; indexX++) {
                System.out.print(matrix[indexX][indexY] + " ");
            }
            System.out.println();
        }
    }
}
