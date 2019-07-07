/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.StringsAndBasicsOfTextProcessing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Task condition: 2. Замените в строке все вхождения 'word' на 'letter'.
 *
 * @author ArtSCactus
 */
public class StringAsMassive_2 {

    static void methodLauncher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a row: ");
        String row = in.nextLine();
        System.out.println("Result: " + replaceWord(row));
    }

    /**
     * Replacing all "word" in a row.
     *
     * @param row
     * @return
     */
    static String replaceWord(String row) {
        row = row.replaceAll("word", "letter");
        return row;
    }
}
