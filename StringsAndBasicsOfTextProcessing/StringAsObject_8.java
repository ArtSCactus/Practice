/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.StringsAndBasicsOfTextProcessing;

import java.util.Scanner;

/**
 * Task condition: 8. Вводится строка слов, разделенных пробелами. Найти самое
 * длинное слово и вывести его на экран. Случай, когда самых длинных слов может
 * быть несколько, не обрабатывать.
 *
 * @author ArtSCactus
 */
public class StringAsObject_8 {

    static void methodLauncher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a row: ");
        String row = in.nextLine();
        System.out.println("Result: " + findLongestWord(row));
        System.out.println("By void function: ");
        printLongestWord(row);
    }

    /**
     * Returns the biggest word in a current row.
     *
     * @param givenRow
     * @return
     */
    static String findLongestWord(String givenRow) {
        if (givenRow.isEmpty()) {
            return null;
        }
        String[] words = givenRow.split(" ");
        String longestWord="";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    /**
     * Printing to console the biggest word and its length from a given row.
     *
     * @param givenRow
     * @return
     */
    static void printLongestWord(String givenRow) {
        if (givenRow.isEmpty()) {
            return;
        }
        String[] words = givenRow.split(" ");
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        System.out.println("The biggest word with length "+longestWord.length()+": "+longestWord);
    }
}
