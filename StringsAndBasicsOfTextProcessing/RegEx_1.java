/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.StringsAndBasicsOfTextProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * Task condition: 1. Cоздать приложение, разбирающее текст (текст хранится в
 * строке) и позволяющее выполнять с текстом три различных операции:
 * отсортировать абзацы по количеству предложений; в каждом предложении
 * отсортировать слова по длине; отсортировать лексемы в предложении по убыванию
 * количества вхождений заданного символа, а в случае равенства – по алфавиту.
 *
 * @author ArtSCactus
 */
public class RegEx_1 {

    static void launcher() throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String row;
        System.out.println("How to sort?\n0-sort by amount of sentences.\n1-sort each sentence by word length.\n2-sort by amount symbol entrance or alphabet.");
        int choose = in.nextInt();
        switch (choose) {
            case (0):
                System.out.println("Load ready test?\n1-Yes\n0-No");
                choose = in.nextInt();
                while (true) {
                    if (choose > 1 || choose < 0) {
                        System.out.println("Please, choose Yes(1) or No(0).");
                        choose = in.nextInt();
                    } else {
                        break;
                    }
                }
                if (choose == 1) {
                    System.out.println("Test1:\n\"Hello!\n I'm Nick Fury. I wonna invite you to our Avengers team.\n If you are interested, just let me know.");
                    row = "Hello!\n I'm Nick Fury. I wonna invite you to our Avengers team.\n If you are interested, just let me know.";
                    row = sortByAmountOfSentences(row, true);
                    System.out.println("Result: \n" + row);
                    System.out.println("Test2:\n\"this sentece are created created to test the function.");
                    row = sortByAmountOfSentences(row, true);
                    System.out.println("Result: \n" + row);
                } else {
                    System.out.println("Please, input your text: ");
                    row = br.readLine();
                    row = sortByAmountOfSentences(row, true);
                    System.out.println("Result: \n" + row);
                }
                break;
            case (1):
                System.out.println("Load ready test?\n1-Yes\n0-No");
                choose = in.nextInt();
                while (true) {
                    if (choose > 1 || choose < 0) {
                        System.out.println("Please, choose Yes(1) or No(0).");
                        choose = in.nextInt();
                    } else {
                        break;
                    }
                }
                if (choose == 1) {
                    System.out.println("Test1:\n\"Hello!\n I'm Nick Fury. I wonna invite you to our Avengers team.\n If you are interested, just let me know.");
                    row = "Hello!\n I'm Nick Fury. I wonna invite you to our Avengers team.\n If you are interested, just let me know.";
                    row = sortByWordLength(row, true);
                    System.out.println("Result: \n" + row);
                    System.out.println("Test2:\n\"this sentece are created created to test the function.");
                    row = sortByWordLength(row, true);
                    System.out.println("Result: \n" + row);
                } else {
                    System.out.println("Please, input your text: ");
                    row = br.readLine();
                    row = sortByWordLength(row, true);
                    System.out.println("Result: \n" + row);
                }
                break;
            case (2):
                System.out.println("Load ready test?\n1-Yes\n0-No");
                choose = in.nextInt();
                while (true) {
                    if (choose > 1 || choose < 0) {
                        System.out.println("Please, choose Yes(1) or No(0).");
                        choose = in.nextInt();
                    } else {
                        break;
                    }
                }
                if (choose == 1) {
                    System.out.println("Test1:\n\"Hello!\n I'm Nick Fury. I wonna invite you to our Avengers team.\n If you are interested, just let me know.");
                    row = "Hello!\n I'm Nick Fury. I wonna invite you to our Avengers team.\n If you are interested, just let me know.";
                    System.out.println("Please, choose the");
                    char symbol = in.next().charAt(0);
                    row = sortBySymbolEntrance(row, symbol);
                    System.out.println("Result: \n" + row);
                    System.out.println("Test2:\n\"this sentece are created created to test the function.");
                    row = sortBySymbolEntrance(row, symbol);
                    System.out.println("Result: \n" + row);
                } else {
                    System.out.println("Please, input your text: ");
                    row = br.readLine();
                    System.out.println("Please, choose the");
                    char symbol = in.next().charAt(0);
                    row = sortBySymbolEntrance(row, symbol);
                    System.out.println("Result: \n" + row);
                }
                break;

        }
        // prepared tests
        //"this sentece are created created to test the function.";
        //"Hello!\n I'm Nick Fury. I wonna invite you to our Avengers team.\n If you are interested, just let me know.";
    }

    /**
     * Returns a given text, but with sorted paragraphs by amount of sentences.
     * Put ascendingOrder=true to sort in ascending order, or put it fasle for
     * descending order.
     *
     * @param text
     * @param ascendingOrder
     * @return
     */
    static String sortByAmountOfSentences(String text, boolean ascendingOrder) {
        if (text.isEmpty()) {
            return "";
        }
        String[] paragraph = text.split("\n");
        int[] amountOfSentences = new int[paragraph.length];
        for (int index = 0; index < paragraph.length; index++) {
            amountOfSentences[index] = StringAsObject_10.countSentences(paragraph[index]);
        }
        boolean sorted = false;
        String tempString;
        int tempInt;
        if (ascendingOrder == true) {
            while (sorted != true) {
                sorted = true;
                for (int index = 0; index != paragraph.length - 1; index++) {
                    if (amountOfSentences[index] > amountOfSentences[index + 1]) {
                        sorted = false;
                        tempInt = amountOfSentences[index];
                        amountOfSentences[index] = amountOfSentences[index + 1];
                        amountOfSentences[index + 1] = tempInt;
                        tempString = paragraph[index];
                        paragraph[index] = paragraph[index + 1];
                        paragraph[index + 1] = tempString;
                    }
                }
            }
        } else {
            while (sorted != true) {
                sorted = true;
                for (int index = 0; index != paragraph.length - 1; index++) {
                    if (amountOfSentences[index] < amountOfSentences[index + 1]) {
                        sorted = false;
                        tempInt = amountOfSentences[index];
                        amountOfSentences[index] = amountOfSentences[index + 1];
                        amountOfSentences[index + 1] = tempInt;
                        tempString = paragraph[index];
                        paragraph[index] = paragraph[index + 1];
                        paragraph[index + 1] = tempString;
                    }
                }
            }
        }
        text = "";
        for (String textPart : paragraph) {
            text += textPart + "\n";
        }
        return text;
    }

    /**
     * Returns given text, where each sentence are sorted by word length. Put
     * ascendingOrder=true to sort by ascending order. False to descanding.
     *
     * @param text
     * @param ascendingOrder
     * @return
     */
    static String sortByWordLength(String text, boolean ascendingOrder) {
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
                sentences[sentIndex] = sortSentenceByWordLength(sentences[sentIndex], ascendingOrder);
                sentences[sentIndex] += sentenceEndSaver;
                paragraphs[parIndex] += sentences[sentIndex] + " ";
            }
        }
        text = "";
        for (String paragraph : paragraphs) {
            text += paragraph + "\n";
        }
        return text;
    }

    /**
     * Returns given row with sorted words by its length. Sorting are going by
     * the space between words. Put ascendingOrder true to sort in ascending
     * order, false to descending.
     *
     * @param sentence
     * @param ascendingOrder
     * @return
     */
    private static String sortSentenceByWordLength(String sentence, boolean ascendingOrder) {
        if (sentence.isEmpty()) {
            return "";
        }
        // dividing the words by space regardless of its number
        String[] words = sentence.split("[ ]\\s*");
        boolean sorted = false;
        String temp;
        if (ascendingOrder == true) {
            while (sorted != true) {
                sorted = true;
                for (int index = 0; index != words.length - 1; index++) {
                    if (words[index].length() > words[index + 1].length()) {
                        sorted = false;
                        temp = words[index];
                        words[index] = words[index + 1];
                        words[index + 1] = temp;
                    }
                }
            }
        } else {
            while (sorted != true) {
                sorted = true;
                for (int index = 0; index != words.length - 1; index++) {
                    if (words[index].length() < words[index + 1].length()) {
                        sorted = false;
                        temp = words[index];
                        words[index] = words[index + 1];
                        words[index + 1] = temp;
                    }
                }
            }
        }
        temp = null;
        System.gc();
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

    static String sortBySymbolEntrance(String text, char symbol) {
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
                sentences[sentIndex] = sortSentenceBySymbolEntrance(sentences[sentIndex], symbol);
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
     * Sorting by word amount of entrance is going in order of descending. This
     * method was created accidentally.
     *
     * @param sentence
     * @return
     */
    static String sortSentenceBySymbolEntrance(String sentence, char symbol) {
        if (sentence.isEmpty()) {
            return "";
        }
        // dividing the words by space regardless of its number
        String[] words = sentence.split("[ ]\\s*");
        Map<String, Integer> wordsEntrance = new HashMap<>();
        int symbolEntranceCounter;
        // Counting amount of symbol entrances in each word
        for (String word : words) {
            if (!wordsEntrance.containsKey(word)) {
                symbolEntranceCounter = 0;
                for (int index = 0; index < word.length(); index++) {
                    if (word.charAt(index) == symbol) {
                        symbolEntranceCounter++;
                    }
                }
                wordsEntrance.put(word, symbolEntranceCounter);
            }
        }
        boolean sorted = false;
        String temp;
        String[] sortBuffer = new String[2];
        // Sorting by amount of symbol entrance
        while (sorted != true) {
            sorted = true;
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
        // Preparing unnecessary variables to delete by GC. 
        sortBuffer = null;
        temp = null;
        System.gc();
        // Building sorted sentence from a words
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
