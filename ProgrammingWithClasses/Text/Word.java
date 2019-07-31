/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses.Text;

/**
 * Task condition: 1. Создать объект класса Текст, используя классы Предложение,
 * Слово. Методы: дополнить текст, вывести на консоль текст, заголовок текста.
 *
 * @author ArtSCactus
 */
public class Word {

    private String word;

    public Word(String word) {
        this.word = word;
    }

    public Word() {
        word = "";
    }
    /**
     * Get the value of word
     *
     * @return the value of word
     */
    public String getWord() {
        return word;
    }

    /**
     * Set the value of word
     *
     * @param word new value of word
     */
    public void setWord(String word) {
        this.word = word;
    }

}
