/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.StringsAndBasicsOfTextProcessing;

import java.util.Scanner;

/**
 * Task condition: 3. В строке найти количество цифр.
 *
 * @author ArtSCactus
 */
public class StringAsMassive_3 {

    static void methodLauncher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a row: ");
        String row = in.nextLine();
        System.out.println("Amount of numerals: " + countNumerals(row));
    }

    /**
     * Returns amount of numerals in a row.
     *
     * @param row
     * @return
     */
    static int countNumerals(String row) {
        char[] numerals = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] symbols = row.toCharArray();
        int counter = 0;
        for (char symbol : symbols) {
            for (char numeral : numerals) {
                if (symbol == numeral) {
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }
}
