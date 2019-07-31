/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses.Book;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 *Task condition:
 * 9. Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и методами. Задать критерии выбора данных и вывести эти данные на консоль.
Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
Найти и вывести:
a) список книг заданного автора;
b) список книг, выпущенных заданным издательством;
c) список книг, выпущенных после заданного года.
 * @author ArtSCactus
 */
public class Book {
    private int id;
    private String title;
    private String[] authors;
    private String publishingHouse;
    private Date yearOfPublishment;
    private int amountOfPages;
    private double price;
    private String bindingType;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
    /**
     *
     * @param id
     * @param title
     * @param authors
     * @param publishingHouse
     * @param yearOfPublishment
     * @param amountOfPages
     * @param price
     * @param bindingType
     */
    public Book(int id, String title, String[] authors, String publishingHouse, String yearOfPublishment, int amountOfPages, double price, String bindingType) throws ParseException {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.publishingHouse = publishingHouse;
        this.yearOfPublishment = new SimpleDateFormat("yyyy").parse(yearOfPublishment);
        this.amountOfPages = amountOfPages;
        this.price = price;
        this.bindingType = bindingType;
    }
/** Returns books id.
 * 
 * @return 
 */
    public int getId() {
        return id;
    }
/** Settings new value to id field.
 * 
 * @param id 
 */
    public void setId(int id) {
        this.id = id;
    }
/** Returns books title.
 * 
 * @return 
 */
    public String getTitle() {
        return title;
    }
/** Settings new value to title field.
 * 
 * @param title 
 */
    public void setTitle(String title) {
        this.title = title;
    }
/** Returns books authors.
 * 
 * @return 
 */
    public String[] getAuthors() {
        return authors;
    }
/** Settings new value to authors field.
 * 
 * @param authors
 */
    public void setAuthors(String[] authors) {
        this.authors = authors;
    }
/** Returns books publishing house.
 * 
 * @return 
 */
    public String getPublishingHouse() {
        return publishingHouse;
    }
/** Settings new value to publishing house field.
 * 
 * @param publishingHouse
 */
    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }
/** Returns books year of publishment.
 * 
 * @return 
 */
    public Date getYearOfPublishment() {
        return yearOfPublishment;//dateFormat.format(yearOfPublishment);
    }
/** Settings new value to year of publishment field.
 * 
 * @param yearOfPublishment
     * @throws java.text.ParseException
 */
    public void setYearOfPublishment(String yearOfPublishment) throws ParseException {
        this.yearOfPublishment = new SimpleDateFormat("yyyy").parse(yearOfPublishment);
    }
/** Returns books amount of pages.
 * 
 * @return 
 */
    public int getAmountOfPages() {
        return amountOfPages;
    }
/** Settings new value to amount of pages field.
 * 
 * @param amountOfPages
 */
    public void setAmountOfPages(int amountOfPages) {
        this.amountOfPages = amountOfPages;
    }
/** Returns books price.
 * 
 * @return 
 */
    public double getPrice() {
        return price;
    }
/** Settings new value to price field.
 * 
 * @param price
 */
    public void setPrice(double price) {
        this.price = price;
    }
/** Returns books binding type.
 * 
 * @return 
 */
    public String getBindingType() {
        return bindingType;
    }
/** Settings new value to binding type field.
 * 
 * @param bindingType 
 */
    public void setBindingType(String bindingType) {
        this.bindingType = bindingType;
    }
/** Returns row with all variables.
 * 
 * @return 
 */
    @Override
    public String toString() {
        return "Book " + "id=" + id + "\nTitle=" + title + "\nAuthors=" + Arrays.toString(authors) + "\nPublishing House=" + publishingHouse + "\nYear Of publishment=" + new SimpleDateFormat("yyyy").format(yearOfPublishment) + "\nAmount Of pages=" + amountOfPages + "\nPrice=" + price + "\nBinding type=" + bindingType ;
    }
    
}
