/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Task condition: 10. Дан целочисленный массив с количеством элементов п. Сжать
 * массив, выбросив из него каждый второй элемент (освободившиеся элементы
 * заполнить нулями). Примечание. Дополнительный массив не использовать.
 *
 * @author ArtSCactus
 */
public class OneDim_10 {

    public static void doTask() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter massive size: ");
        int massiveSize = in.nextInt();
        int[] rowOfNumbers = new int[massiveSize];
        System.out.println("Input massive elements: ");
        for (int index = 0; index < rowOfNumbers.length; index++) {
            System.out.print("Element [" + index + "](int): ");
            rowOfNumbers[index] = in.nextInt();
        }
        System.out.println("Source massive: " + Arrays.toString(rowOfNumbers));
        for (int index = 0; index < rowOfNumbers.length; index++) {
            if (index % 2 != 0) {
                rowOfNumbers[index] = 0;
            }
        }
        System.out.println("Result: " + Arrays.toString(rowOfNumbers));
    }
}
