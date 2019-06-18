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
public class MassiveOfMassives_13 {
    public static void doTask(){
         // declaration of massive/variables and it's initialization
        Scanner in = new Scanner(System.in);
        System.out.println("Enter matrix size by X: ");
        int sideSize = in.nextInt();
        System.out.println("Enter mtrix size by Y: ");
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
        // bubble sort by ascending

        for (int index = 0; index < sideSize; index++) {
            boolean isSorted = false;
            int buf;
            while (!isSorted) {
                isSorted = true;
                for (int curElement = 0; curElement < downSize - 1; curElement++) {
                    if (matrix[index][curElement] > matrix[index][curElement + 1]) {
                        isSorted = false;
                        buf = matrix[index][curElement];
                        matrix[index][curElement] = matrix[index][curElement + 1];
                        matrix[index][curElement + 1] = buf;
                    }
                }
            }
        }
        System.out.println("Sorted by ascending: ");
        for (int indexY = 0; indexY < downSize; indexY++) {
            for (int indexX = 0; indexX < sideSize; indexX++) {
                System.out.print(matrix[indexX][indexY] + " ");
            }
            System.out.println();
        }
        // bubble sort by descending
      for (int index = 0; index < sideSize; index++) {
            boolean isSorted = false;
            int buf;
            while (!isSorted) {
                isSorted = true;
                for (int curElement = 0; curElement < downSize - 1; curElement++) {
                    if (matrix[index][curElement] < matrix[index][curElement + 1]) {
                        isSorted = false;
                        buf = matrix[index][curElement];
                        matrix[index][curElement] = matrix[index][curElement + 1];
                        matrix[index][curElement + 1] = buf;
                    }
                }
            }
        }
        System.out.println("Sorted by descending: ");
        for (int indexY = 0; indexY < downSize; indexY++) {
            for (int indexX = 0; indexX < sideSize; indexX++) {
                System.out.print(matrix[indexX][indexY] + " ");
            }
            System.out.println();
        }
    }
}
