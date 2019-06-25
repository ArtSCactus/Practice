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
public class OneDimSorting_05 {

    /**
     * Shifts the massive array on 1 element next to free space for new element
     * (when you are using binary search). Algorithm going from the end of row
     * (endPosition) to the start of row (startPosition) and setting the element
     * array[index -1] on place of current element. In short, the function are
     * element array[startPosition] and shifting array to insert new element.
     *
     * @param array
     * @param startPosition
     * @param endPosition
     */
    public static void shiftMassive(int[] array, int startPosition, int endPosition) {
        if (startPosition < 0 || endPosition > array.length) {
            System.out.println("Error. Start position or end position cannot be less then 0 or more then length of array.");
            return;
        } else if (startPosition == endPosition) {
            return;
        }
        for (int index = endPosition; index > startPosition; index--) {
            if (index == startPosition) {
                break;
            } else {
                array[index] = array[index - 1];
            }
        }
    }

    /**
     * Returns index of place, where we need to place this element(binary
     * search)
     *
     * @param array
     * @param key
     * @return
     */
    public static int findPlaceForElement(int[] array, int key) {
        int left = 0;
        int right = array.length;
        int mid;

        while (!(left >= right)) {
            mid = left + (right - left) / 2;

            if (array[mid] == key) {
                return mid;
            }

            if ((array[mid] > key)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return (1 + left) - 1;
    }

    /**
     * Returns index of place, where we need to place this element(binary
     * search) in interval between startPosition and endPosition
     *
     *
     * @param array
     * @param key
     * @param startPosition
     * @param endPosition
     * @return
     */
    public static int findPlaceForElement(int[] array, int key, int startPosition, int endPosition) {
        int left = startPosition;
        int right = endPosition;
        int mid;

        while (!(left >= right)) {
            mid = left + (right - left) / 2;

            if (array[mid] == key) {
                return mid;
            }

            if ((array[mid] > key)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return (1 + left) - 1;
    }

    public static void doTask() {
        // declaration of massives/variables and it's initialization
        Scanner in = new Scanner(System.in);
        System.out.println("Enter massive size (enter 0 for random size between 1 and 100): ");
        int firstSize = in.nextInt();
        while (true) {
            if (firstSize == 0) {
                firstSize = 1 + (int) (Math.random() * (100 + 1));
                break;
            } else if (firstSize < 0) {
                System.out.println("The massive size cannot be less then 0!");
            } else {
                break;
            }
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

        //  source massives output
        System.out.println("Source first massive: ");
        for (int index = 0; index < firstSize; index++) {
            System.out.print(firstMassive[index] + " ");
        }
        System.out.println();

        // output by task condition
        int tempIndexMemory; // to save number of place in massive, where we should place the element
        int tempValueSaver; // to save value of current element before shift
        System.out.println("Generated length: " + firstMassive.length);
        // sorting
        for (int index = 0; index < firstMassive.length; index++) {
            tempIndexMemory = findPlaceForElement(firstMassive, firstMassive[index], 0, index);
            tempValueSaver = firstMassive[index];
            shiftMassive(firstMassive, tempIndexMemory, index);
            firstMassive[tempIndexMemory] = tempValueSaver;
        }
        System.out.println("New row: ");
        for (int index = 0; index < firstMassive.length; index++) {
            System.out.print(firstMassive[index] + " ");
        }
        System.out.println();
    }
}
