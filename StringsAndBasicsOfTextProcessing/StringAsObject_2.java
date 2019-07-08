/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.StringsAndBasicsOfTextProcessing;

import java.util.Scanner;

/**
 * Task condition: 2. В строке вставить после каждого символа 'a' символ 'b'.
 *
 * @author ArtSCactus
 */
public class StringAsObject_2 {

    static void methodLauncher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a row: ");
        String row = in.nextLine();
        System.out.println("Result:" + insertLetter(row));
    }

    /**
     * Insirting symbol "b" after every symbol "a".
     *
     * @param row
     * @return
     */
    static String insertLetter(String row) {
        if (row.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder(row);
        for (int index = 0; index < sb.length(); index++) {
            if (sb.charAt(index) == 'a') {
                if (index + 1 > sb.length() - 1) {
                    sb.append("b");
                } else {
                    sb.insert(index + 1, 'b');
                }
            }
        }
        return sb.toString();
    }
}
