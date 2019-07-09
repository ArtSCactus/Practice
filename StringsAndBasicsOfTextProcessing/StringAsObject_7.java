/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.StringsAndBasicsOfTextProcessing;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Task condition: 7. Вводится строка. Требуется удалить из нее повторяющиеся
 * символы и все пробелы. Например, если было введено "abc cde def", то должно
 * быть выведено "abcdef".
 *
 * @author ArtSCactus
 */
public class StringAsObject_7 {

    static void methodLauncher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a row: ");
        String row = in.nextLine();
        System.out.println("Result: " + deleteSpaceAndDuplicates(row));
    }

    /**
     * Returns a row without any space and duplicate symbol.
     *
     * @param givenRow
     * @return
     */
    static String deleteSpaceAndDuplicates(String givenRow) {
        if (givenRow.isEmpty()) {
            return givenRow;
        }
        StringBuilder row = new StringBuilder(givenRow);
        HashSet<Character> symbols = new HashSet();
        for (int index = 0; index < row.length(); index++) {
            if (row.charAt(index) == ' ') {
                row.deleteCharAt(index);
                index--;
            } else {
            if (!symbols.contains(row.charAt(index))) {
                symbols.add(row.charAt(index));
            } else {
                row.deleteCharAt(index);
                index--;
            }
            }
        }
        return row.toString();
    }
}
