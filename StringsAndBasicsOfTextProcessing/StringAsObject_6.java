/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.StringsAndBasicsOfTextProcessing;

import java.util.Scanner;

/**
 * Task condition: 6. Из заданной строки получить новую, повторив каждый символ
 * дважды.
 *
 * @author ArtSCactus
 */
public class StringAsObject_6 {

    static void methodLauncher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a row: ");
        String row = in.nextLine();
        System.out.println("Result: " + duplicateSymbols(row));
    }

    /**
     * Duplicates every symbol in a row twice.
     *
     * @param givenRow
     * @return
     */
    static String duplicateSymbols(String givenRow) {
        if (givenRow.isEmpty()) {
            return givenRow;
        }
        StringBuilder row = new StringBuilder(givenRow);
        for (int index = 0; index < row.length(); index += 3) {
            row.insert(index + 1, row.charAt(index));
            row.insert(index + 2, row.charAt(index));
        }
        return row.toString();
    }
}
