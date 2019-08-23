/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Scanner;

/**
 *Task condition:
 * 16. Магическим квадратом порядка matrixOrder называется квадратная матрица размера nxn, составленная из чисел 1, 2, 3,
..., 2 matrixOrder так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между
собой. Построить такой квадрат. Пример магического квадрата порядка 3:
6 1 8
7 5 3
2 9 4
 * @author ArtSCactus
 */
public class MassiveOfMassives_16 {

    public static void doTask() {
        int matrixOrder = 0, matrix[][];
        System.out.print("Enter matrix Order: ");
        Scanner in = new Scanner(System.in);
        matrixOrder = in.nextInt();
        in.close();
        System.out.println();
        if (matrixOrder % 4 == 0) {
            matrix = magicSquareDoublyEven(matrixOrder);
        } else if (matrixOrder % 2 != 0) {
            matrix = magicSquareOdd(matrixOrder);
        } else {
            matrix = magicSquareSinglyEven(matrixOrder);
        }
        displaySquare(matrix);
        System.out.println();
    }

    static int[][] magicSquareOdd(int matrixOrder) {
        int num = 1, row, col;
        int[][] matrix = new int[matrixOrder][matrixOrder];
        row = matrixOrder / 2;
        col = matrixOrder - 1;
        for (int rowIndex = 0; rowIndex < matrixOrder; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrixOrder; columnIndex++) {
                matrix[rowIndex][columnIndex] = 0;
            }
        }
        while (num <= matrixOrder * matrixOrder) {
            if (row < 0 && col >= matrixOrder) {
                row = 0;
                col = matrixOrder - 2;
            } else {
                if (row < 0) {
                    row = row + matrixOrder;
                } else if (col >= 0) {
                    col = col % matrixOrder;
                }

            }
            if (matrix[row][col] != 0) {
                row = row + 1;
                col = col - 2;
                continue;
            } else {
                matrix[row][col] = num++;
            }
            row = row - 1;
            col = col + 1;
        }
        return matrix;
    }

    static int[][] magicSquareDoublyEven(int matrixOrder) {
        int[][] matrix = new int[matrixOrder][matrixOrder];
        for (int rowIndex = 0; rowIndex < matrixOrder; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrixOrder; columnIndex++) {
                matrix[rowIndex][columnIndex] = 4 * rowIndex + columnIndex + 1;
            }
        }
        for (int rowIndex = 0; rowIndex < matrixOrder / 4; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrixOrder / 4; columnIndex++) {
                matrix[rowIndex][columnIndex] = matrixOrder * matrixOrder + 1 - matrix[rowIndex][columnIndex];
            }
        }
        for (int rowIndex = 0; rowIndex < matrixOrder / 4; rowIndex++) {
            for (int columnIndex = 3 * matrixOrder / 4; columnIndex < matrixOrder; columnIndex++) {
                matrix[rowIndex][columnIndex] = matrixOrder * matrixOrder + 1 - matrix[rowIndex][columnIndex];
            }
        }
        for (int rowIndex = 3 * matrixOrder / 4; rowIndex < matrixOrder; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrixOrder / 4; columnIndex++) {
                matrix[rowIndex][columnIndex] = matrixOrder * matrixOrder + 1 - matrix[rowIndex][columnIndex];
            }
        }
        for (int rowIndex = 3 * matrixOrder / 4; rowIndex < matrixOrder; rowIndex++) {
            for (int columnIndex = 3 * matrixOrder / 4; columnIndex < matrixOrder; columnIndex++) {
                matrix[rowIndex][columnIndex] = matrixOrder * matrixOrder + 1 - matrix[rowIndex][columnIndex];
            }
        }
        for (int rowIndex = matrixOrder / 4; rowIndex < 3 * matrixOrder / 4; rowIndex++) {
            for (int columnIndex = matrixOrder / 4; columnIndex < 3 * matrixOrder / 4; columnIndex++) {
                matrix[rowIndex][columnIndex] = matrixOrder * matrixOrder + 1 - matrix[rowIndex][columnIndex];
            }
        }
        return matrix;
    }

    static void displaySquare(int[][] matrix) {
        int matrixOrder = matrix.length;
        for (int rowIndex = 0; rowIndex < matrixOrder; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrixOrder; columnIndex++) {
                System.out.print(matrix[rowIndex][columnIndex] + "\t");
            }
            System.out.println("\n");
        }
    }

    static int[][] magicSquareSinglyEven(int matrixOrder) {
        if (matrixOrder == 2) {
            System.out.println("No normal magic matrix of order 2 exists!");
            //System.exit(0);
            int number = 1 + (int) (Math.random() * (matrixOrder * matrixOrder) + 1);
                    int[][] matrix = new int[matrixOrder][matrixOrder];
                    for (int indexX=0; indexX<matrixOrder; indexX++)
                        for (int indexY=0; indexY<matrixOrder; indexY++)
                        matrix[indexX][indexY] = number;
                    return matrix;
        }
        int[][] matrix = new int[matrixOrder][matrixOrder];
        int[][] quarter;
        quarter = magicSquareOdd(matrixOrder / 2);

        //for top left quarter matrix
        for (int rowIndex = 0; rowIndex < matrixOrder / 2; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrixOrder / 2; columnIndex++) {
                matrix[rowIndex][columnIndex] = quarter[rowIndex][columnIndex];
                matrix[matrixOrder / 2 + rowIndex][matrixOrder / 2 + columnIndex] = quarter[rowIndex][columnIndex] + (matrixOrder * matrixOrder) / 4;
                matrix[rowIndex][matrixOrder / 2 + columnIndex] = quarter[rowIndex][columnIndex] + (matrixOrder * matrixOrder) / 2;
                matrix[matrixOrder / 2 + rowIndex][columnIndex] = quarter[rowIndex][columnIndex] + 3 * (matrixOrder * matrixOrder) / 4;
            }
        }
        int k = (matrixOrder - 1) / 4;

        for (int rowIndex = 0; rowIndex < k; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrixOrder / 2; columnIndex++) {
                int temp = matrix[columnIndex][rowIndex];
                matrix[columnIndex][rowIndex] = matrix[columnIndex + matrixOrder / 2][rowIndex];
                matrix[columnIndex + matrixOrder / 2][rowIndex] = temp;
                if ((rowIndex + 1) < k) {
                    temp = matrix[columnIndex][matrixOrder - rowIndex - 1];
                    matrix[columnIndex][matrixOrder - rowIndex - 1] = matrix[columnIndex + matrixOrder / 2][matrixOrder - rowIndex - 1];
                    matrix[columnIndex + matrixOrder / 2][matrixOrder - rowIndex - 1] = temp;
                }
            }
        }

        //undo the unneccessary swap
        int temp = matrix[matrixOrder / 4][k - 1];
        matrix[matrixOrder / 4][k - 1] = matrix[3 * matrixOrder / 4][k - 1];
        matrix[3 * matrixOrder / 4][k - 1] = temp;

        //swap the diagonal elements
        temp = matrix[matrixOrder / 4][k];
        matrix[matrixOrder / 4][k] = matrix[3 * matrixOrder / 4][k];
        matrix[3 * matrixOrder / 4][k] = temp;

        return matrix;
    }
}
