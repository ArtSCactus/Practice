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
 * @author ArtSCactus
 */
public class OneDim_09 {

    public static void doTask() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter massive size: ");
        int massiveSize = in.nextInt();
        int[] rowOfNumbers = new int[massiveSize];
        int theMostCommon = 0;
        int amountOfMostCommonNumber = 0;
        System.out.println("Input massive elements: ");
        for (int index = 0; index < rowOfNumbers.length; index++) {
            System.out.print("Element [" + index + "](int): ");
            rowOfNumbers[index] = in.nextInt();
        }
        System.out.println("Source massive: " + Arrays.toString(rowOfNumbers));
        int currentElementCounter = 0;
        for (int currentElementIndex = 0; currentElementIndex < rowOfNumbers.length; currentElementIndex++) {
            if (amountOfMostCommonNumber < currentElementCounter) {                               //
                theMostCommon = rowOfNumbers[currentElementIndex];                                  // validation on most common element
                amountOfMostCommonNumber = currentElementCounter;                                //
                currentElementCounter = 0;
            } else if (amountOfMostCommonNumber == currentElementCounter) {
                if (theMostCommon > rowOfNumbers[currentElementIndex]) {
                    theMostCommon = rowOfNumbers[currentElementIndex];
                }
            }
            currentElementCounter = 0;
            for (int index = 0; index < rowOfNumbers.length; index++) {
                if (rowOfNumbers[currentElementIndex] == rowOfNumbers[index]) {
                    currentElementCounter++;
                }
            }
        }
        System.out.println("The most common number: " + theMostCommon);
    }
}
