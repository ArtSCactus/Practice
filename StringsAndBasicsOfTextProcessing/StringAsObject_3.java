/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.StringsAndBasicsOfTextProcessing;

import java.util.Scanner;

/**
 * Task condition: 3. Проверить, является ли заданное слово палиндромом.
 *
 * @author ArtSCactus
 */
public class StringAsObject_3 {

    static void methodLauncher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a row: ");
        String row = in.nextLine();
        System.out.println("Result: " + isPalindrome(row));
    }

    /**
     * Returns true if given word are palindrome or false otherwise.
     *
     * @param givenWord
     * @return
     */
    static boolean isPalindrome(String givenWord) {
        if (givenWord.isEmpty()) {
            return false;
        }
        StringBuilder word = new StringBuilder(givenWord);
        for (int index = 0; index < word.length(); index++) {
            if (!word.substring(index, index + 1).equalsIgnoreCase(word.substring((word.length() - 1) - index, word.length() - index))) {
                return false;
            }
        }
        return true;
    }
}
