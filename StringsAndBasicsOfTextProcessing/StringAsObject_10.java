/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.StringsAndBasicsOfTextProcessing;

import java.util.Scanner;

/**
 * Task condition: 10. Строка X состоит из нескольких предложений, каждое из
 * которых кончается точкой, восклицательным или вопросительным знаком.
 * Определить количество предложений в строке X.
 *
 * @author ArtSCactus
 */
public class StringAsObject_10 {

    static void methodLauncher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a row: ");
        String row = in.nextLine();
        System.out.println("Result: amount of sentences: " + countSentences(row));
    }

    /**
     * Returns amount of sentences in a given row.
     *
     * @param givenRow
     * @return
     */
    static int countSentences(String givenRow) {
        if (givenRow.isEmpty()) {
            return 0;
        }
        int amountOfSentences = 0;
        boolean sentenceStarted = true;
        for (int index = 0; index < givenRow.length(); index++) {
            if ((givenRow.charAt(index) == '!' || givenRow.charAt(index) == '?' || givenRow.charAt(index) == '.') & sentenceStarted == true) {
                amountOfSentences++;
            }
            switch (givenRow.charAt(index)) {
                case ('!'):
                    sentenceStarted = false;
                    break;
                case ('?'):
                    sentenceStarted = false;
                    break;
                case ('.'):
                    sentenceStarted = false;
                    break;
                default:
                    sentenceStarted = true;
            }
        }
        return amountOfSentences;
    }
}
