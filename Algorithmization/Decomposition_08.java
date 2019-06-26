/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Scanner;

/**
 * Task condition: 8. Задан массив D. Определить следующие суммы: D[l] + D[2] +
 * D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6]. Пояснение. Составить
 * метод(методы) для вычисления суммы трех последовательно расположенных
 * элементов массива с номерами от k до m.
 *
 * @author ArtSCactus
 */
public class Decomposition_08 {

    static void launcherForMethod() {
        // declaration of massives/variables and it's initialization
        Scanner in = new Scanner(System.in);
        System.out.println("Enter amount of points (enter 0 for random amount between 1 and 30): ");
        int size;
        while (true) {
            size = in.nextInt();
            if (size == 0) {
                size = 1 + (int) (Math.random() * (30 + 1));
                size *= 2;
                break;
            } else if (size < 0) {
                System.out.println("The massive size cannot be less then 0!");
            } else {
                size *= 2;
                break;
            }
        }
        int[] array = new int[size];
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
            for (int index = 0; index < array.length; index++) {
                array[index] = 0 + (int) (Math.random() * (100 + 1));
            }
        } else {
            System.out.println("Fill the array:");
            for (int index = 0; index < array.length; index += 2) {
                System.out.print("Element[" + index + "]: ");
                array[index] = in.nextInt();
            }
        }
        //  source massives output
        System.out.println("Source array: ");
        for (int index = 0; index < array.length; index += 2) {
            System.out.print(array[index] + " ");
        }
        System.out.println("\nSum of elements from 1 to 3: " + findSum(1, 3, array));
        System.out.println("Sum of elements from 3 to 5: " + findSum(3, 5, array));
        System.out.println("Sum of elements from 4 to 6: " + findSum(4, 6, array));
        System.out.println("Error test: " + findSum(-1, 3, array));
        System.out.println("Error test: " + findSum(1, 4, array));
        System.out.println("Error test: " + findSum(array.length - 1, array.length + 1, array));

    }

    static int findSum(int start, int end, int[] array) {
        if (end - 2 == start || start - 2 == end) {
            if (start < 0 || end > array.length) {
                System.out.println("Start or end placed out of massive bounds.");
                return 0;
            } else if (start == end) {
                System.out.println("You have inputed indexes of 2 numbers, but needs 3.");
                return 0;
            }
            int result = 0;
            if (start > end) {
                result += array[end];
                result += array[end - 1];
                result += array[start];
            } else {
                result += array[start];
                result += array[end - 1];
                result += array[end];
            }
            return result;
        } else {
            System.out.println("Items is not aligned.");
            return 0;
        }
    }
}
