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
public interface Book {

    /**
     * Should return author's name of current book.
     *
     * @return
     */
    public String getAuthor();

    /**
     * Should allows to set new value to the authors name.
     *
     * @param author
     */
    public void setAuthor(String author);

    /**
     * Should returns book name.
     *
     * @return
     */
    public String getName();

    /**
     * Should allows to set new value to the book name.
     *
     * @param name
     */
    public void setName(String name);

    /**
     * Should return "digital" or "paper".
     *
     * @return
     */
    public String bookType();

    /**
     * Should return in row all information about current book.
     *
     * @return
     */
    @Override
    public String toString();
}
