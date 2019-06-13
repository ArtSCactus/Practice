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
public class OneDim_08 {

    public static void doTask() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter massive size: ");
        int massiveSize = in.nextInt();
        int[] numbers = new int[massiveSize];
        System.out.println("Input massive elements: ");
        for (int index = 0; index < numbers.length; index++) {
            System.out.print("Element [" + index + "](int): ");
            numbers[index] = in.nextInt();
        }
        System.out.println("Source massive: " + Arrays.toString(numbers));
        // search for min element
        int minElement = numbers[0];
        int counterOfMinElements =1;
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] < minElement) {
                minElement = numbers[index];
                counterOfMinElements = 1;
            } else if (numbers[index] == minElement) {
                counterOfMinElements++; // count amount of min elements to calculate size of new row 
            }
        }
        System.out.println("Minimal element: " + minElement);

        int[] newRow = new int[numbers.length - counterOfMinElements];
        int discrepancyOfIndexes = 0; // difference between index in newRow and numbers
        for (int index = 0; index < numbers.length; index++) {
            if (minElement == numbers[index]) {
                System.out.println("Element was deleted");
                discrepancyOfIndexes++;
            } else {
                newRow[index - +discrepancyOfIndexes] = numbers[index];
            }
        }
        System.out.println("Result: " + Arrays.toString(newRow));
    }
}
