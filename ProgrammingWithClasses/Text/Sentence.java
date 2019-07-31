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
public class Sentence {

    private StringBuilder sentence;

    /**
     *
     * @param words
     */
    public Sentence(Word ...words) {
        String sentenceBuilder="";
        for (Word word : words) {
            sentenceBuilder+=word.getWord()+" ";
        }
        sentence=new StringBuilder(sentenceBuilder);
    }

    /**
     *
     * @param word
     * @throws NullPointerException
     */
    public void appendWord(Word word) throws NullPointerException {
        if (word == null) {
            throw new NullPointerException("Given word are null");
        }
        sentence.append(word.getWord());
    }

    /**
     *
     */
    public void clearSentence() {
        sentence.delete(0, sentence.length());
    }

    /**
     *
     * @return
     */
    public StringBuilder getSentence() {
        return sentence;
    }

    @Override
    public String toString() {
        return sentence.toString();
    }
    
}
