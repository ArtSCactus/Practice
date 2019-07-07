/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Arrays;
import java.util.Scanner;

/**
 *Task condition:
 * 1. Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
дополнительный массив.
 * @author ArtSCactus
 */
public class OneDimSorting_01 {

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
        System.out.print("\n0 - Auto filling\n1 - Manual filling\n==>");
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
        System.out.println("Enter a key number (available value between 0 and " + (firstMassive.length - 1) + "): ");
        int key;
        while (true) {
            key = in.nextInt();
            if (key < 0 || key > firstMassive.length) {
                System.out.println("Please, choose between 0 and " + (firstMassive.length - 1));
            } else {
                break;
            }
        }
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
        // output by task condition
        // extending old massive
        firstMassive = Arrays.copyOf(firstMassive, firstMassive.length + secondMassive.length);
        // moving elements from key number on secondSize (free space for second massive)
        try {
            for (int index = key + 1; index <= key + secondMassive.length; index++) {
                firstMassive[(index + secondMassive.length)] = firstMassive[index];
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            if (key == firstSize) {
                for (int index = firstSize; index <= key + secondMassive.length; index++) {
                    firstMassive[(index + secondMassive.length)] = firstMassive[index];
                }
            }
        }
        // inseting second massive into the first
        for (int index = key + 1, secondMassiveIndex = 0; index < firstMassive.length & secondMassiveIndex < secondMassive.length; index++, secondMassiveIndex++) {
            firstMassive[index] = secondMassive[secondMassiveIndex];
        }
        for (int index = 0; index < firstMassive.length; index++) {
            System.out.print(firstMassive[index] + " ");
        }
        System.out.println();
    }
}
