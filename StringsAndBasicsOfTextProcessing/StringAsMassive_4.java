/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.StringsAndBasicsOfTextProcessing;

import java.util.Scanner;

/**
 * Task condition: 4. В строке найти количество чисел.
 *
 * @author ArtSCactus
 */
public class StringAsMassive_4 {

    static void methodLauncher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a row: ");
        String row = in.nextLine();
        System.out.println("Amount of numbers: " + countNumbers(row));
    }

    /**
     * Returns amount of numbers in a current row.
     *
     * @param row
     * @return
     */
    static int countNumbers(String row) {
        if (row.isEmpty()) return 0;
        char[] symbols = row.toCharArray();
        boolean numberStarted = false; // Flag to recognize numbers
        int counter = 0;
        // if number started, the counter are passing all the numerals, 
        //that are going after the first meeting numeral until it meet a not numeral and flag numerStarted will go false.
        for (char symbol : symbols) {
            if (isNumeral(symbol) == true & numberStarted == false) {
                numberStarted = true;
                counter++;
            } else if (isNumeral(symbol) == false) {
                numberStarted = false;
            }

        }
        return counter;
    }

    /**
     * Returns true if incomming char is a numeral. false if otherwise.
     *
     * @param symbol
     * @return
     */
    static boolean isNumeral(char symbol) {
        char[] numerals = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (char numeral : numerals) {
            if (symbol == numeral) {
                return true;
            }
        }
        return false;
    }
}
