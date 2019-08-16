/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Scanner;

/**
 *Task condition:
 * 2. Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
 * @author ArtSCactus
 */
public class MassiveOfMassives_02 {

    public static void doTask() {
        // declaration of massive/variables and it's initialization
        Scanner in = new Scanner(System.in);
        System.out.println("Enter matrix size: ");
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
        System.out.print("Diagonal elements: ");
        for (int index = 0; index < matrixSize; index++) {
            System.out.print(matrix[index][index] + " ");
        }
    }
}
