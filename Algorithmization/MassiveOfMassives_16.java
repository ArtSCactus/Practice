/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ArtSCactus This method of constructing a magic square was developed
 * by me, without using third-party formulas and methods. It is based on
 * equalizing the sum of the elements (through splitting the difference between
 * the principal sum and the sum in each row / column / diagonal into numbers)
 * on the zero row. How is the alignment: 1. The sum is in the current row /
 * column / diagonal. 2. Calculates the difference between the sum in the
 * current row / column / diagonal. 3. This difference is divided into numbers,
 * which, when added, give this very difference, then these numbers are added /
 * subtracted according to each element in this row / column / diagonal.
 *
 * At the moment, my method has the following disadvantage (solved): when
 * aligning the sums of the matrix, negative numbers may appear in it.
 */
public class MassiveOfMassives_16 {

    public static void doTask() {
        int n = 0, square[][];
        System.out.print("Enter matrixOrder: ");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        in.close();
        System.out.println();
        if (n % 4 == 0) {
            square = magicSquareDoublyEven(n);
        } else if (n % 2 != 0) {
            square = magicSquareOdd(n);
        } else {
            square = magicSquareSinglyEven(n);
        }
        displaySquare(square);
        System.out.println();
        //System.out.println("The magic number is: "+(n*(n*n+1))/2);
    }

    static int[][] magicSquareOdd(int n) {
        int num = 1, row, col;
        int[][] square = new int[n][n];
        row = n / 2;
        col = n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                square[i][j] = 0;
            }
        }
        while (num <= n * n) {

            if (row < 0 && col >= n) {
                row = 0;
                col = n - 2;
            } else {
                if (row < 0) {
                    row = row + n;
                } else if (col >= 0) {
                    col = col % n;
                }

            }
            if (square[row][col] != 0) {
                row = row + 1;
                col = col - 2;
                continue;
            } else {
                square[row][col] = num++;
            }
            row = row - 1;
            col = col + 1;
        }
        return square;
    }

    static int[][] magicSquareDoublyEven(int n) {
        int[][] square = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                square[i][j] = 4 * i + j + 1;
            }
        }
        for (int i = 0; i < n / 4; i++) {
            for (int j = 0; j < n / 4; j++) {
                square[i][j] = n * n + 1 - square[i][j];
            }
        }
        for (int i = 0; i < n / 4; i++) {
            for (int j = 3 * n / 4; j < n; j++) {
                square[i][j] = n * n + 1 - square[i][j];
            }
        }
        for (int i = 3 * n / 4; i < n; i++) {
            for (int j = 0; j < n / 4; j++) {
                square[i][j] = n * n + 1 - square[i][j];
            }
        }
        for (int i = 3 * n / 4; i < n; i++) {
            for (int j = 3 * n / 4; j < n; j++) {
                square[i][j] = n * n + 1 - square[i][j];
            }
        }
        for (int i = n / 4; i < 3 * n / 4; i++) {
            for (int j = n / 4; j < 3 * n / 4; j++) {
                square[i][j] = n * n + 1 - square[i][j];
            }
        }
        return square;
    }

    static void displaySquare(int[][] square) {
        int n = square.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(square[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    static int[][] magicSquareSinglyEven(int n) {
        if (n == 2) {
            System.out.println("No normal magic square of order 2 exists!");
            //System.exit(0);
            int number = 1 + (int) (Math.random() * (n * n) + 1);
                    int[][] square = new int[n][n];
                    for (int indexX=0; indexX<n; indexX++)
                        for (int indexY=0; indexY<n; indexY++)
                        square[indexX][indexY] = number;
                    return square;
        }
        int[][] square = new int[n][n];
        int[][] quarter;
        quarter = magicSquareOdd(n / 2);

        //for top left quarter square
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                square[i][j] = quarter[i][j];
                square[n / 2 + i][n / 2 + j] = quarter[i][j] + (n * n) / 4;
                square[i][n / 2 + j] = quarter[i][j] + (n * n) / 2;
                square[n / 2 + i][j] = quarter[i][j] + 3 * (n * n) / 4;
            }
        }
        int k = (n - 1) / 4;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = square[j][i];
                square[j][i] = square[j + n / 2][i];
                square[j + n / 2][i] = temp;
                if ((i + 1) < k) {
                    temp = square[j][n - i - 1];
                    square[j][n - i - 1] = square[j + n / 2][n - i - 1];
                    square[j + n / 2][n - i - 1] = temp;
                }
            }
        }

        //undo the unneccessary swap
        int temp = square[n / 4][k - 1];
        square[n / 4][k - 1] = square[3 * n / 4][k - 1];
        square[3 * n / 4][k - 1] = temp;

        //swap the diagonal elements
        temp = square[n / 4][k];
        square[n / 4][k] = square[3 * n / 4][k];
        square[3 * n / 4][k] = temp;

        return square;
    }

    public static void main(String args[]) {

    }
}