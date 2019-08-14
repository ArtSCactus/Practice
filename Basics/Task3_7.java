/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Basics;

/**
 * Task condition: 7. Для каждого натурального числа в промежутке от m до n
 * вывести все делители, кроме единицы и самого числа. m и n вводятся с
 * клавиатуры.
 *
 * @author ArtSCactus
 */
public class Task3_7 {

    public static void task3_7(int rowStart, int rowEnd) {
        for (int index = rowStart; index != rowEnd; index++) {
            System.out.print("Dividers for " + index + ": ");
            for (int divider = 2; divider < index; divider++) {
                if (index % divider == 0) {
                    System.out.print(divider + " ");
                }
            }
            System.out.println();
        }

    }
}
