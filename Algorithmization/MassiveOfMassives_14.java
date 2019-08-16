/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Scanner;

/**
 *Task condition:
 * 14. Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
единиц равно номеру столбца.
 * @author ArtSCactus
 */
public class MassiveOfMassives_14 {

    public static void doTask() {
        // declaration of massive/variables and it's initialization
        Scanner in = new Scanner(System.in);
        System.out.println("Enter matrix size by X: ");
        int sideSize = in.nextInt();
        System.out.println("Enter matrix size by Y: ");
        int downSize = in.nextInt();
        int[][] matrix = new int[sideSize][downSize];
        int oneCounter;
        for (int indexX = 0; indexX < sideSize; indexX++) {
            oneCounter=0;
            for (int indexY = 0; indexY < downSize; indexY++) {
                if (oneCounter == indexX) {
                    matrix[indexX][indexY] = 0;
                } else {
                    matrix[indexX][indexY] = 0 + (int) (Math.random() * 2);
                    if (matrix[indexX][indexY] == 1) {
                        oneCounter++;
                    }
                }
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
    }
}
