/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Scanner;

/**
 * Task condition: 
 *5. Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число,
которое меньше максимального элемента массива, но больше всех других элементов).
 * @author ArtSCactus
 */
public class Decomposition_05 {
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
                System.out.print("Element[" + index+ "]: ");
                array[index] = in.nextInt();
            }
        }
        //  source massives output
        System.out.println("Source array: ");
        for (int index = 0; index < array.length; index += 2) {
            System.out.print( array[index] + " ");
        }
        System.out.println("\nMethods output: " + findSecondMaxElement(array));
        System.out.print("Maximal element: ");
        int maxElement=Integer.MIN_VALUE;
        for (int index=0; index<array.length; index++)
            if (array[index]>maxElement) maxElement=array[index];
        System.out.println(maxElement);
    }

    /**
     * Returns the maximal distance between two point from gived massive.
     *
     * @param array
     * @return
     */
    static int findSecondMaxElement(int[] array) {
        if (array.length== 0) {
            System.out.println("Error. Massive are empty.");
            return 0;
        }
        int secondBiggestNumber=Integer.MIN_VALUE;
        int theBiggestNumber=Integer.MIN_VALUE;
        for (int index=0; index<array.length; index++)
        {
            if (array[index]>theBiggestNumber){
                secondBiggestNumber=theBiggestNumber;
                theBiggestNumber=array[index];
            }
        }
        return secondBiggestNumber;
    }
}
