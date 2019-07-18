/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author ArtSCactus
 */
public class SortByAmountOfEntrancesAlgorithm {
    
     static String sortByWordEntrance(String text, boolean ascendingOrder) {
        if (text.isEmpty()) {
            return "";
        }
        String[] paragraphs = text.split("\n");
        String[] sentences;
        String sentenceEndSaver;
        for (int parIndex = 0; parIndex < paragraphs.length; parIndex++) {
            sentences = paragraphs[parIndex].split("\b[\\.\\!\\?]");
            paragraphs[parIndex] = "";
            for (int sentIndex = 0; sentIndex < sentences.length; sentIndex++) {
                sentenceEndSaver = (sentences[sentIndex].substring(sentences[sentIndex].length() - 1));
                sentences[sentIndex] = sentences[sentIndex].replace(sentenceEndSaver, "");
                sentences[sentIndex] = sortSentenceByWordEntrance(sentences[sentIndex], ascendingOrder);
                sentences[sentIndex] += sentenceEndSaver;
                paragraphs[parIndex] += sentences[sentIndex] + " ";
            }
        }
        sentences = null;
        sentenceEndSaver = null;
        System.gc();
        text = "";
        for (String paragraph : paragraphs) {
            text += paragraph + "\n";
        }
        return text;
    }
     /**
     * Returns a given sentence but sorted in order of descending amount of word
     * entrance. If amount of word entrance are equals then sorting by alphabet.
     * Sorting by word amount of entrance is going in order of descending. 
     * Case is treated as a separate character. This
     * method was created accidentally.
     *
     * @param sentence
     * @return
     */
    public static String sortSentenceByWordEntrance(String sentence, boolean ascendingOrder) {
        // dividing the words by space regardless of its number
        String[] words = sentence.split("[ ]\\s*");
        Map<String, Integer> wordsEntrance = new HashMap<String, Integer>();
        for (String word : words) {
            if (wordsEntrance.containsKey(word)) {
                wordsEntrance.replace(word, wordsEntrance.get(word) + 1);
            } else {
                wordsEntrance.put(word, 1);
            }
        }
        boolean sorted = false;
        String temp;
        String[] sortBuffer = new String[2];
        // Sorting by amount of entrance
        while (sorted != true) {
            sorted = true;
            if (ascendingOrder==true){
            for (int index = 0; index != words.length - 1; index++) {
                if (wordsEntrance.get(words[index]) < wordsEntrance.get(words[index + 1])) {
                    sorted = false;
                    temp = words[index];
                    words[index] = words[index + 1];
                    words[index + 1] = temp;
                } else if (Objects.equals(wordsEntrance.get(words[index]), wordsEntrance.get(words[index + 1]))) {
                    sortBuffer[0] = words[index];
                    sortBuffer[1] = words[index + 1];
                    Arrays.sort(sortBuffer);
                    words[index] = sortBuffer[0];
                    words[index + 1] = sortBuffer[1];
                }
            }
        }
         else {
                 for (int index = 0; index != words.length - 1; index++) {
                if (wordsEntrance.get(words[index]) > wordsEntrance.get(words[index + 1])) {
                    sorted = false;
                    temp = words[index];
                    words[index] = words[index + 1];
                    words[index + 1] = temp;
                } else if (Objects.equals(wordsEntrance.get(words[index]), wordsEntrance.get(words[index + 1]))) {
                    sortBuffer[0] = words[index];
                    sortBuffer[1] = words[index + 1];
                    Arrays.sort(sortBuffer);
                    words[index+1] = sortBuffer[0];
                    words[index] = sortBuffer[1];
                }
            }
        }
        }
        // Preparing unnecessary variables to delete
        sortBuffer = null;
        temp = null;
        System.gc();
        // Building sorted sentence
        StringBuilder sortedSentence = new StringBuilder();
        for (int index = 0; index < words.length; index++) {
            if (index == words.length - 1) {
                sortedSentence.append(words[index]);
            } else {
                sortedSentence.append(words[index]).append(" ");
            }
        }
        return sortedSentence.toString();
    }
}
