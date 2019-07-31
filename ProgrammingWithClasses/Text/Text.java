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
public class Text {

    private StringBuilder text;
    private String title;

    public Text(String text, String title) {
        this.text = new StringBuilder(text);
        this.title = title;
    }

    public Text() {
        text = new StringBuilder("");
        title = "Unnamed text";
    }

    public void appendSentence(Sentence sentence) {
        text.append(sentence.toString());
    }

    public void toConsole() {
        System.out.println(title);
        System.out.println(text.toString());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public static void testClass(){
        Text text = new Text();
        text.appendSentence(new Sentence(new Word("Hello"), new Word("world!")));
        text.setTitle("Class test");
        text.toConsole();
    }
}
