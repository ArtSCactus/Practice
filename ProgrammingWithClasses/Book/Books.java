/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses.Book;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Task condition: 9. Создать класс Book, спецификация которого приведена ниже.
 * Определить конструкторы, set- и get- методы и метод toString(). Создать
 * второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
 * методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * Book: id, название, автор(ы), издательство, год издания, количество страниц,
 * цена, тип переплета. Найти и вывести: a) список книг заданного автора; b)
 * список книг, выпущенных заданным издательством; c) список книг, выпущенных
 * после заданного года.
 *
 * @author ArtSCactus
 */
public class Books {

    private Book[] books;

    public Books(Book... books) throws IllegalArgumentException {
        if (books == null) {
            throw new IllegalArgumentException("Array with null value");
        }
        this.books = books;
    }

    /**
     * Printing to console (by method <code>toString()</code>) information about
     * books with matched author.
     *
     * @param author
     */
    public void printBooksByAuthor(String author) {
        for (Book book : books) {
            for (String currentAuthor : book.getAuthors()) {
                if (currentAuthor.equals(author)) {
                    System.out.println("Match found: \n" + book.toString());
                }
            }
        }
    }

    /**
     * Printing to console (by method <code>toString()</code>) information about
     * books with matched publishingHouse.
     *
     * @param publishingHouse
     */
    public void printBooksByPublishingHouse(String publishingHouse) {
        for (Book book : books) {
            if (book.getPublishingHouse().equalsIgnoreCase(publishingHouse)) {
                System.out.println("Match found: \n" + book.toString());
            }
        }
    }

    /**
     * Printing to console (by method <code>toString()</code>) information about
     * books that has been published aftter given year of publishment.
     *
     * @param yearOfPublishment
     * @throws java.text.ParseException
     */
    public void printBooksAfterDate(String yearOfPublishment) throws ParseException {
        for (Book book : books) {
            if (book.getYearOfPublishment().after(new SimpleDateFormat("yyyy").parse(yearOfPublishment))) {
                System.out.println("Match found: \n" + book.toString());
            }
        }
    }
/**Method to test how class Books works.
 * 
 * @throws ParseException 
 */ 
    public static void testClass() throws ParseException {
        Books books = new Books(
                new Book(1, "Название", new String[]{"Васильев А.А."}, "Новый свет", "2015", 615, 54.5, "solid"),
                new Book(2, "Название", new String[]{"Глуховский Д.А."}, "А-медиа", "2016", 615, 54.5, "solid"),
                new Book(3, "Название", new String[]{"Азимов А."}, "Нова-медиа", "2017", 615, 54.5, "solid")
        );
        System.out.println("Books after 2016 year test: ");
        books.printBooksAfterDate("2016");
        System.out.println();
        System.out.println("----------------");
        System.out.println("Books by publishing house: ");
        books.printBooksByPublishingHouse("Нова-медиа");
        System.out.println("----------------");
        System.out.println("Books by author: ");
        books.printBooksByAuthor("Глуховский Д.А.");
        System.out.println("----------------");
    }
}
