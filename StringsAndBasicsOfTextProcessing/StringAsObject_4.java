/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.StringsAndBasicsOfTextProcessing;

/**
 * Task condition: 4. С помощью функции копирования и операции конкатенации
 * составить из частей слова “информатика” слово “торт”.
 *
 * @author ArtSCactus
 */
public class StringAsObject_4 {

    static void methodLauncher() {
        System.setProperty("console.encoding", "Cp866");
        System.out.println("Result: " + makeCake("инфмаика"));
    }

    /**
     * Returns a word "торт" in case if givenWord consist substring (Cyrillic) "т" and "ор".
     *
     * @param givenWord
     * @return
     */
    static String makeCake(String givenWord) {
        StringBuilder word = new StringBuilder(givenWord);
        if (word.indexOf("т") == -1) {
            return givenWord;
        }
        if (word.indexOf("ор") == -1) {
            return givenWord;
        }
        StringBuilder cake = new StringBuilder();
        cake.append(word.substring(word.indexOf("т"), word.indexOf("т") + 1)); // Cyrillic т
        cake.append(word.substring(word.indexOf("ор"), word.indexOf("ор") + 2));// Cyrillic ор
        cake.append(word.substring(word.indexOf("т"), word.indexOf("т") + 1));// Cyrillic т
        return cake.toString();
    }
}
