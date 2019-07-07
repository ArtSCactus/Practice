/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.StringsAndBasicsOfTextProcessing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Task condition: 5. Удалить в строке все лишние пробелы, то есть серии подряд
 * идущих пробелов заменить на одиночные пробелы. Крайние пробелы в строке
 * удалить.
 *
 * @author ArtSCactus
 */
public class StringAsMassive_5 {

    static void methodLauncher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a row: ");
        String row = in.nextLine();
        System.out.println("Result:" + deleteExtraSpace(row));
    }

    /**
     * Returns a string without extra spaces. In place of multiple spaces, only
     * 1 space remains. At the beginning and at the end of the spaces are
     * removed.
     *
     * @param row
     * @return
     */
    static String deleteExtraSpace(String row) {
        char[] symbols = row.toCharArray();
        boolean extraSpaceStarted = false;
        for (int index = 0; index < symbols.length - 1; index++) {
            if (symbols[index] == ' ' & extraSpaceStarted == false) {
                extraSpaceStarted = true;
            } else {
                if (symbols[index] == ' ' & extraSpaceStarted == true) {
                    symbols = deleteChar(symbols, index);
                    index--;
                } else if (symbols[index] != ' ') {
                    extraSpaceStarted = false;
                }
            }
        }
        if (symbols[0] == ' ') {
            symbols = deleteChar(symbols, 0);
        }
        if (symbols[symbols.length - 1] == ' ') {
            symbols = deleteChar(symbols, symbols.length);
        }
        return row = new String(symbols);
    }

    /**
     * Delets one char from a char massive by it's position.
     *
     * @param massive
     * @param pos
     * @return
     */
    static char[] deleteChar(char[] massive, int pos) {
        for (int index = pos; index < massive.length - 1; index++) {
            massive[index] = massive[index + 1];
        }
        massive = Arrays.copyOf(massive, massive.length - 1);
        return massive;
    }
}
