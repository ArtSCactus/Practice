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
 * This method of constructing a magic square was developed by me, without using third-party formulas and methods. 
 * It is based on equalizing the sum of the elements (through splitting the difference between the principal sum and the sum
 * in each row / column / diagonal into numbers) on the zero row.
 * How is going  the alignment:
 * 1. We are taking sum is in the current row / column / diagonal.
 * 2. Calculating the difference between the sum in the current row / column / diagonal.
 * 3. This difference is divided into numbers, which, when added, give this very difference, then these numbers are added / 
 * subtracted according to each element in this row / column / diagonal.
 *
 * 
 */
public class MassiveOfMassives_16 {

    /**
     * Returns a massive of elements, that in summ will give number.
     * numberOfItems - number of times, that you need get, after number dividing
     *
     * @param number;
     * @param numberOfItems;
     * @return theTerms (int[]);
     */
    private static int[] splitNumber(int number, int numberOfItems) {
        int[] theTerms = new int[numberOfItems];
        int summOfElements = 0;
        for (int index = 0; index < theTerms.length; index++) {
            theTerms[index] = 1;
        }
        for (int index = 0; index < theTerms.length; index++) {
            summOfElements += theTerms[index];
        }
        if (summOfElements > number) {
            System.out.println("Exception! " + number + " cannot be divided on " + numberOfItems + " (int) items. Please, check the summ of massive.");
            System.out.println("Trying to solve it.");
            boolean summReached=false; // flag signals, that current summ of elements is now equals *number*;
            int summBeforeZeroPoint=0;
            for (int index=0; index<theTerms.length; index++){
                if (summBeforeZeroPoint== number) theTerms[index]=0;
                else summBeforeZeroPoint+=theTerms[index];
            }
            // Validation if the Exception resolved
             summOfElements=0;
                   for (int index = 0; index < theTerms.length; index++) {
            summOfElements += theTerms[index];
        }
                    if (summOfElements==number){
                        System.out.println("Exception successfully resolved.");
                    }
                    else  {System.out.println("Exception resolving are failed. Return null"); return null;}

        } else if (summOfElements == number) {
            return theTerms;
        }
        int currentElementNumber = 0;
        while (true) {
            summOfElements = 0;
            for (int index = 0; index < theTerms.length; index++) {
                summOfElements += theTerms[index];
            }
            if (summOfElements == number) {
                break;
            } else {
                theTerms[currentElementNumber]++;
                if (currentElementNumber == theTerms.length - 1) {
                    currentElementNumber = 0;
                } else {
                    currentElementNumber++;
                }
            }
        }
        return theTerms;
    }

    public static void doTask() {
        // declaration of massive/variables and it's initialization
        Scanner in = new Scanner(System.in);
        System.out.println("Enter matrix order: ");
        int matrixOrder = in.nextInt();
        int[][] matrix = new int[matrixOrder][matrixOrder];
        // matrix filling
        for (int indexY = 0; indexY < matrixOrder; indexY++) {
            for (int indexX = 0; indexX < matrixOrder; indexX++) {
                matrix[indexX][indexY] = 1 + (int) (Math.random() * (matrixOrder * matrixOrder) + 1);
            }
        }
        int sourceSum = 0;
        int[] dividedDifference;
        int bufferSum;
        for (int indexX = 0; indexX < matrixOrder; indexX++) {
            sourceSum += matrix[indexX][0];
        }
        System.out.println("Source sum "+sourceSum);
        boolean done =false;
        int[] dividedDif;
/*while (true){
     int buffer=0;
    for (int indexX=0; indexX<matrixOrder; indexX++){
       buffer=0;
        for (int indexY=0; indexY<matrixOrder; indexY++){
            buffer+=matrix[indexX][indexY];
        }
        if (buffer!=sourceSum){
            if (buffer>sourceSum) {
                dividedDif=splitNumber(buffer-sourceSum,matrixOrder);
            }
        }
    }
}*/
        // matrix output
        System.out.println("Source matrix: ");
        for (int indexY = 0; indexY < matrixOrder; indexY++) {
            for (int indexX = 0; indexX < matrixOrder; indexX++) {
                System.out.print(matrix[indexX][indexY] + " ");
            }
            System.out.println();
        }
    }
}
