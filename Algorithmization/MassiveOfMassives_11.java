/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

/**
 *
 * @author ArtSCactus
 */
public class MassiveOfMassives_11 {

    public static void doTask() {
        // declaration of massive/variables and it's initialization
        int[][] matrix = new int[10][20];
        int fiveCounter;
        for (int indexY = 0; indexY < 20; indexY++) {
            for (int indexX = 0; indexX < 10; indexX++) {
                matrix[indexX][indexY] = 0 + (int) (Math.random() * 15);
            }
        }
        //  source matrix output
        System.out.println("Source matrix: ");
        for (int indexY = 0; indexY < 20; indexY++) {
                        System.out.print("Row №"+indexY+" ");
            for (int indexX = 0; indexX < 10; indexX++) {
                System.out.print(matrix[indexX][indexY] + " ");
            }
            System.out.println();
        }
        // output by task condition
        System.out.print("Number of rows, that consist number 5 three and more times: ");
        for (int indexY = 0; indexY < 20; indexY++) {
            fiveCounter=0;
            for (int indexX = 0; indexX < 10; indexX++) {
                if (matrix[indexX][indexY] == 5) {
                    fiveCounter++;
                }
                if (fiveCounter == 3) {
                    System.out.print(indexY+ ",  ");
                    fiveCounter = 0;
                    break;
                }
            }
        }
        System.out.println();
    }
}
