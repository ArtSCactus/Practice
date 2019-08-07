/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Home_library.Utill.BookTamplates;

/**
 *
 * @author ArtSCactus
 */
public class Paper implements Book {

    /**
     * Contains author's name of current book.
     *
     */
    private String author;
    /**
     * Contains name of current book.
     *
     */
    private String name;

    /**
     * Constructs new paper type book.
     *
     * @param author
     * @param name
     * @throws NullPointerException if author are null or name are null
     */
    public Paper(String author, String name) {
        if (author == null | name == null) {
            throw new NullPointerException("Author's name or book name cannot be null");
        }
        this.author = author;
        this.name = name;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    /**
     * Settings new author's name.
     *
     * @param author author name
     * @throws NullPointerException if author are null
     */
    @Override
    public void setAuthor(String author) {
        if (author == null) {
            throw new NullPointerException("Author cannot be null");
        }
        this.author = author;
    }

    /**
     * Returns book's name as String.
     *
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Settings new value to book name.
     *
     * @param name
     * @throws NullPointerException if name are null
     */
    @Override
    public void setName(String name) {
        if (name == null) {
            throw new NullPointerException("Book name cannot be null");
        }
        this.name = name;
    }

    /**
     * Returns row "paper" to show which type is this book.
     *
     * @return "paper"
     */
    @Override
    public String bookType() {
        return "paper";
    }

    @Override
    public String toString() {
        return "Book: "+name+"\nAuthor: "+author+"\nEdition: paper";
    }
   
}
