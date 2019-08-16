/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Scanner;

/**
 * Task condition: 7. Даны действительные числа a1,a2,...,an. Найти
 * max(a1,+a2n,a2+a2n-1,...,an+an+1).
 *
 * @author ArtSCactus
 */
// I understood this task like that (including a note from java0tutor): find max(a1, a2, a4, a8, a16, ..., an)
/*
java0tutor's note:
Java0Tutor @Java0Tutor Jun 10 12:30
Вопрос: Здравствуйте. в блоке одномерные массивы задание 7. дан массив n элементов. как искать а1 + a2n и т.д?
Ответ: В задании опечатка, от a_1 до a_2n.
 */
public class OneDim_07 {

    public static void doTask() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter massive size: ");
        double[] numbers = new double[in.nextInt()];
        System.out.println("Input massive elements: ");
        for (int index = 0; index < numbers.length; index++) {
            System.out.print("Element [" + index + "](double): ");
            numbers[index] = in.nextDouble();
        }
        double maxElement = numbers[0];
        for (int index = 1; index < numbers.length; index *= 2) {
            if (numbers[index] > maxElement) {
                maxElement = numbers[index];
            }
        }
        System.out.println("Result: " + maxElement);
    }
}
