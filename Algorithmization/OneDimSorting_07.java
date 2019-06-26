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
public class OneDimSorting_07 {

    public static void doTask() {
        // declaration of massives/variables and it's initialization
        Scanner in = new Scanner(System.in);
        System.out.println("Enter first massive size (enter 0 for random size between 1 and 100): ");
        int firstSize;
        while (true) {
            firstSize = in.nextInt();
            if (firstSize == 0) {
                firstSize = 1 + (int) (Math.random() * (100 + 1));
                break;
            } else if (firstSize < 0) {
                System.out.println("The massive size cannot be less then 0!");
            } else break;
        }
        System.out.println("Enter second massive size (enter 0 for random size between 1 and 100): ");
        int secondSize;
        while (true) {
            secondSize = in.nextInt();
            if (secondSize == 0) {
                secondSize = 1 + (int) (Math.random() * (100 + 1));
                break;
            } else if (secondSize < 0) {
                System.out.println("The massive size cannot be less then 0!");
            } else break;
        }
        int[] firstMassive = new int[firstSize];
        int[] secondMassive = new int[secondSize];
        System.out.println("0 - Auto filling\n1 - Manual filling");
        int inputOption;
        while (true) {
            inputOption = in.nextInt();
            if (inputOption == 0 || inputOption == 1) {
                break;
            } else {
                System.out.println("Please, choose 0 or 1, that's important!");
            }
        }
        if (inputOption == 0) {
            for (int index = 0; index < firstMassive.length; index++) {
                firstMassive[index] = 0 + (int) (Math.random() * (100 + 1));
            }
            for (int index = 0; index < secondMassive.length; index++) {
                secondMassive[index] = 0 + (int) (Math.random() * (100 + 1));
            }
        } else {
            System.out.println("Fill the first massive:");
            for (int index = 0; index < firstMassive.length; index++) {
                System.out.print("Element [" + index + "]: ");
                firstMassive[index] = in.nextInt();
            }
            System.out.println("Fill the second massive:");
            for (int index = 0; index < secondMassive.length; index++) {
                System.out.print("Element [" + index + "]: ");
                secondMassive[index] = in.nextInt();
            }
        }
        Arrays.sort(firstMassive);
        Arrays.sort(secondMassive);
        //  source massives output
        System.out.println("Source first massive: ");
        for (int index = 0; index < firstSize; index++) {
            System.out.print(firstMassive[index] + " ");
        }
        System.out.println();
        System.out.println("Source second massive: ");
        for (int index = 0; index < secondSize; index++) {
            System.out.print(secondMassive[index] + " ");
        }
        System.out.println();
        // output by task condition (using binary search from OneDimSorting_05)
        int foundedPlace;
        for (int index = 0; index < secondMassive.length; index++) {
            foundedPlace=OneDimSorting_05.findPlaceForElement(firstMassive, secondMassive[index]);
            if (foundedPlace>secondMassive.length) foundedPlace--;
            if (secondMassive[index] >= firstMassive[foundedPlace]) {
                System.out.println("Element b[" + index + "]=" + secondMassive[index] + " you should place after element a"
                        + "[" + foundedPlace
                        + "]=" + firstMassive[foundedPlace]);
            }
            else {
                System.out.println("Element b[" + index + "]=" + secondMassive[index] + " you should place before element a"
                        + "[" + OneDimSorting_05.findPlaceForElement(firstMassive, secondMassive[index])
                        + "]=" + firstMassive[OneDimSorting_05.findPlaceForElement(firstMassive, secondMassive[index])]);
            }
        }
    }
}
