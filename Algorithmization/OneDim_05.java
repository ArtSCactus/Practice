/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Scanner;

/**
 * Task condition: 5. Даны целые числа а1 ,а2 ,..., аn . Вывести на печать
 * только те числа, для которых аi > i.
 *
 * @author ArtSCactus
 */
public class OneDim_05 {

    public static void doTask() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter massive size: ");
        int[] numbers = new int[in.nextInt()];
        System.out.println("Input massive elements: ");
        for (int index = 0; index < numbers.length; index++) {
            System.out.print("Element [" + index + "]: ");
            numbers[index] = in.nextInt();
        }
        System.out.println("Output: ");
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] > index) {
                System.out.print(numbers[index] + " ");
            }
        }
    }
}
