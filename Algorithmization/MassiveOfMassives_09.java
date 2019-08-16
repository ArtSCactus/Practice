/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Scanner;

/**
 * Task condition: 9. Задана матрица неотрицательных чисел. Посчитать сумму
 * элементов в каждом столбце. Определить, какой столбец содержит максимальную
 * сумму.
 *
 * @author ArtSCactus
 */
public class MassiveOfMassives_09 {

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
        int columnSumm;
        int theBiggestSumm = Integer.MIN_VALUE;
        int columnNumberSaver = 0;
        // output by task condition
        for (int indexX = 0; indexX < sideSize; indexX++) {
            columnSumm = 0;
            for (int indexY = 0; indexY < downSize; indexY++) {
                columnSumm += matrix[indexX][indexY];
            }
            columnNumberSaver = columnSumm > theBiggestSumm ? indexX : columnNumberSaver;
            theBiggestSumm = columnSumm > theBiggestSumm ? columnSumm : theBiggestSumm;
            System.out.println("Summ of column " + indexX + ": " + columnSumm);
        }
        System.out.println("The biggest summ is in column №" + columnNumberSaver + ": " + theBiggestSumm);
    }
}
