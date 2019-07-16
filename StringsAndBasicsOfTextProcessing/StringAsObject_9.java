/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.StringsAndBasicsOfTextProcessing;

import java.util.Scanner;

/**
 * Task condition: 9. Посчитать количество строчных (маленьких) и прописных
 * (больших) букв в введенной строке. Учитывать только английские буквы.
 *
 * @author ArtSCactus
 */
public class StringAsObject_9 {

    static void methodLauncher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a row: ");
        String row = in.nextLine();
        System.out.println("Result: ");
        countLetters(row);
    }

    /**
     * Printring amount of uppercase and lowercase english letters in a given row.
     *
     * @param givenRow
     * @return
     */
    static void countLetters(String givenRow) {
        if (givenRow.isEmpty()) {
            return;
        }
        int lowerCounter = 0;
        int upperCounter = 0;
        for (int index = 0; index < givenRow.length(); index++) {
            //check for belonging to the English language
            if (((givenRow.charAt(index) >= 'a') && (givenRow.charAt(index) <= 'z')) || ((givenRow.charAt(index) >= 'A') && (givenRow.charAt(index) <= 'Z'))) {
                if (givenRow.charAt(index) != ' ') {
                    if (Character.isUpperCase(givenRow.charAt(index))) {
                        upperCounter++;
                    } else {
                        lowerCounter++;
                    }
                }
            }
        }
        System.out.println("In uppercase: " + upperCounter + " letters\nIn lowercase: " + lowerCounter + " lowerCounter");
    }
}
