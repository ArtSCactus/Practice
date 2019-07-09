/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.StringsAndBasicsOfTextProcessing;

import java.util.Scanner;

/**
 *Task condition:
 * 5. Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.
 * @author ArtSCactus
 */
public class StringAsObject_5 {
    
    static void methodLauncher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a row: ");
        String row = in.nextLine();
        System.out.println("Result: " + countLetter(row));
    }

    /**
     * Return amount of letter (latin) "a" in a given row.
     *
     * @param givenRow
     * @return
     */
    static int countLetter(String givenRow) {
        if (givenRow.isEmpty()) {
            return 0;
        }
        int counter=0;
        StringBuilder row = new StringBuilder(givenRow);
        for (int index=0; index<row.length(); index++)
            if (row.charAt(index)=='a') counter++; //latin a
        return counter;
    }
}
