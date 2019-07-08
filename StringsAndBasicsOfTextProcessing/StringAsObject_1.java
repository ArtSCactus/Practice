/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.StringsAndBasicsOfTextProcessing;

import java.util.Scanner;

/**
 * Task condition: 1. Дан текст (строка). Найдите наибольшее количество подряд
 * идущих пробелов в нем.
 *
 * @author ArtSCactus
 */
public class StringAsObject_1 {

    static void methodLauncher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a row: ");
        String row = in.nextLine();
        System.out.println("Result:" + countMaximalSpaceInLine(row));
    }

    /**
     * Returns the maximal amount of space in a line, that consist the current
     * row.
     *
     * @param row
     * @return
     */
    static int countMaximalSpaceInLine(String row) {
        if (row.isEmpty()) {
            return 0;
        }
        StringBuilder sb = new StringBuilder(row);
        int currentSpaceCounter = 0;
        int theBiggestAmountOfSpace = 0;
        for (int index = 0; index < sb.length(); index++) {
            if (sb.charAt(index) == ' ') {
                currentSpaceCounter++;
            } else if (sb.charAt(index) != ' ') {
                if (theBiggestAmountOfSpace < currentSpaceCounter) {
                    theBiggestAmountOfSpace = currentSpaceCounter;
                    currentSpaceCounter = 0;
                } else {
                    currentSpaceCounter = 0;
                }
            }
        }
        return theBiggestAmountOfSpace;
    }
}
