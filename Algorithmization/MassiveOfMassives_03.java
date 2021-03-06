/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Scanner;

/**
 *Task condition:
 * 3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
 * @author ArtSCactus
 */
public class MassiveOfMassives_03 {

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
        System.out.print("Enter a row number: ");
        int rowNumber = in.nextInt();
        System.out.print("Enter a column number: ");
        int columnNumber = in.nextInt();
        System.out.println("Good, here's your row №" + rowNumber + " and column №" + columnNumber + ": ");
        System.out.print("Row: ");
        for (int index = 0; index < sideSize; index++) {
            System.out.print(matrix[index][rowNumber] + " ");
        }
        System.out.println();
        System.out.println("Column: ");
        for (int index = 0; index < downSize; index++) {
            System.out.println(matrix[columnNumber][index] + " ");
        }
    }
}
