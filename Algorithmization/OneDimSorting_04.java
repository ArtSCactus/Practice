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
 */
public class OneDimSorting_04 {

    public static void doTask() {
        // declaration of massives/variables and it's initialization
        Scanner in = new Scanner(System.in);
        System.out.println("Enter massive size (enter 0 for random size between 1 and 100): ");
        int firstSize;
        while (true) {
            firstSize = in.nextInt();
            if (firstSize == 0) {
                firstSize = 1 + (int) (Math.random() * (100 + 1));
                break;
            } else if (firstSize < 0) {
                System.out.println("The massive size cannot be less then 0!");
            }
            else break;
        }
        int[] firstMassive = new int[firstSize];
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
        } else {
            System.out.println("Fill the massive:");
            for (int index = 0; index < firstMassive.length; index++) {
                System.out.print("Element [" + index + "]: ");
                firstMassive[index] = in.nextInt();
            }
        }
        //    Arrays.sort(firstMassive);

        //  source massives output
        System.out.println("Source first massive: ");
        for (int index = 0; index < firstSize; index++) {
            System.out.print(firstMassive[index] + " ");
        }
        System.out.println();

        // output by task condition
        int tempValueSaver = 0;
        boolean Sorted = false;
        // sorting new row
        while (Sorted != true) {
            Sorted=true;
            for (int indexOfMainWay = 0; indexOfMainWay < firstMassive.length - 1; indexOfMainWay++) {
                if (firstMassive[indexOfMainWay] > firstMassive[indexOfMainWay + 1]) {
                    Sorted = false;
                    tempValueSaver = firstMassive[indexOfMainWay];
                    firstMassive[indexOfMainWay] = firstMassive[indexOfMainWay + 1];
                    firstMassive[indexOfMainWay + 1] = tempValueSaver;
                }
            }
        }
        System.out.println("New row: ");
        for (int index = 0; index < firstMassive.length; index++) {
            System.out.print(firstMassive[index] + " ");
        }
        System.out.println();
    }
}
