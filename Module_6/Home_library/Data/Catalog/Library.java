/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Module_6.Home_library.Data.Catalog;

import Practice.Home_library.Utill.BookTamplates.Book;
import Practice.Home_library.Utill.BookTamplates.Digital;
import Practice.Home_library.Utill.BookTamplates.Paper;
import Practice.Module_6.Home_library.Utill.AccountManager.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ArtSCactus
 */
public class Library {

    private List<Book> bookList;
    private File bookStorage;
    private FileReader fromFile;
    private FileWriter toFile;
    private BufferedReader scanner;
    private User currentUser;
    private boolean isAdminAuthorized;

    public Library(String bookStoragePath) throws FileNotFoundException, IOException {
        bookList = new ArrayList<>();
        bookStorage = new File(bookStoragePath+"\\Book storage.txt");
        if (bookStorage.exists()) {
            String[] buffer = new String[3];
            fromFile = new FileReader(bookStorage);
            scanner = new BufferedReader(fromFile);
            while (scanner.ready()) {
                buffer = scanner.readLine().split("\\|");
                if (buffer[2].equals("digital")) {
                    bookList.add(new Digital(buffer[0], buffer[1]));
                }
                if (buffer[2].equals("paper")) {
                    bookList.add(new Paper(buffer[0], buffer[1]));
                }
            }
            fromFile.close();
        } else {
            bookStorage.createNewFile();
        }
    }

    /**
     * Return book by author and name. If no such book founded returns null
     *
     * @param author
     * @param name
     * @return
     */
    public Book findBook(String author, String name) {
        for (Book book : bookList) {
            if (book.getAuthor().equalsIgnoreCase(author) & book.getName().equalsIgnoreCase(name)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Returns book by author. If no such book founded returns null
     *
     * @param author
     * @return
     */
    public Book findBook(String author) {
        for (Book book : bookList) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Returns first meeted book by it's name. If no such book founded returns
     * null
     *
     * @param name
     * @return
     */
    public Book findBookByName(String name) {
        for (Book book : bookList) {
            if (book.getName().equalsIgnoreCase(name)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Adds new book to the booList.
     *
     * @param book
     * @throws IOException
     */
    public void addBook(Book book) throws IOException {
        if (!currentUser.isAdmin()) {
            System.out.println("You don't have enough right to modify the library."
                    + "\nPlease, contact with administrator.");
            return;
        }
        bookList.add(book);
        saveCatalog();
    }

    /**
     * Removes all books with given characteristics.
     *
     * @param bookName
     * @param bookAuthor
     * @throws NullPointerException if bookName or bookAuthor are null.
     * @throws IOException
     */
    public void deleteBook(String bookName, String bookAuthor) throws IOException {
        if (bookName == null | bookAuthor == null) {
            throw new NullPointerException("Book name or author are null");
        }
        boolean success = false;
        for (int index = 0; index < bookList.size(); index++) {
            if (bookList.get(index).getName().equals(bookName) & bookList.get(index).getAuthor().equalsIgnoreCase(bookAuthor)) {
                bookList.remove(index);
                index--;
                success = true;
            }
        }
        if (success) {
            System.out.println("Successfully deleted");
        } else {
            System.out.println("No such book");
        }
        saveCatalog();
    }

    /**
     * Removes books of chosed type (paper or digital) with given
     * characteristics.
     *
     * @param bookName
     * @param bookAuthor
     * @throws NullPointerException if bookName or bookAuthor are null.
     * @throws IOException
     */
    public void deleteBook(String bookName, String bookAuthor, String bookType) throws IOException {
        if (bookName == null | bookAuthor == null) {
            throw new NullPointerException("Book name or author are null");
        }
        boolean success = false;
        for (int index = 0; index < bookList.size(); index++) {
            if (bookList.get(index).getName().equals(bookName) & bookList.get(index).getAuthor().equalsIgnoreCase(bookAuthor) & bookList.get(index).bookType().equals(bookType)) {
                bookList.remove(index);
                index--;
                success = true;
            }
        }
        if (success) {
            System.out.println("Successfully deleted");
        } else {
            System.out.println("No such book");
        }
        saveCatalog();
    }

    /**
     * Writes bookList to the file.
     *
     * @throws IOException
     */
    public void saveCatalog() throws IOException {
        toFile = new FileWriter(bookStorage);
        for (int index = 0; index < bookList.size(); index++) {
            toFile.write(bookList.get(index).getAuthor() + "|" + bookList.get(index).getName() + "|" + bookList.get(index).bookType() + "\n");
        }
        toFile.close();
    }

    /**
     * Initializes current user, that working at this moment.
     *
     * @param currentUser
     * @throws NullPointerException if currentUser are null
     */
    public void signIn(User currentUser) throws NullPointerException {
        if (currentUser == null) {
            throw new NullPointerException("Current user cannot be null");
        } else {
            this.currentUser = currentUser;
            if (currentUser.isAdmin()) {
                isAdminAuthorized = true;
                System.out.println("Successfully signed in as " + this.currentUser.getUserName() + " (administrator)");
            } else {
                System.out.println("Successfully signed in as " + this.currentUser.getUserName());
            }
        }
    }
/**Prints to console information (by calling <code>toString()</code> method) for each book.
 * 
 */
    public void printAllBooks() {
        for (Book book : bookList) {
            System.out.println(book.toString());
            System.out.flush();
        }
    }

    /**
     * Calculates amount of pages by given amount of notes on page. Then asking
     * user on which page he want's to go. After that calculates page start and
     * page end and prints all books between calculated borders.
     *
     *
     * @param notesOnPage
     * @throws IOException
     */
    public void printByPage(int notesOnPage) throws IOException {
        if (bookList.size() == 0) {
            System.out.println("No any book in library at this moment");
            return;
        }
        int rowsCounter = 0;
        int amountOfPages = 0;
        for (int index = 0; index < bookList.size(); index++) {
            if (rowsCounter == notesOnPage - 1) {
                amountOfPages++;
                rowsCounter = 0;
            } else {
                rowsCounter++;
            }
        }
        if (rowsCounter > 0) {
            amountOfPages++;
        }
        System.out.println(amountOfPages + " pages available, which one will you choose?(Starts from 0)");
        int pageNumber = 0;
        Scanner scan = new Scanner(System.in);
        while (true) {
            pageNumber = scan.nextInt();
            if (pageNumber < 0 | pageNumber > amountOfPages) {
                System.out.print("Please, choose between 0 and " + (amountOfPages - 1));
            } else {
                break;
            }
        }
        int currentPageStart = 0;
        int currentPageEnd = 0;
        currentPageStart += notesOnPage * pageNumber;
        currentPageEnd += pageNumber == 0 ? notesOnPage : notesOnPage * pageNumber;
        if (currentPageEnd > bookList.size()) {
            currentPageEnd = bookList.size();
        }
        System.out.flush();
        for (int index = currentPageStart; index < currentPageEnd; index++) {
            System.out.println(bookList.get(index).toString() + "\n");
        }
    }

    /**
     * Returns true if current user does have admin right.
     *
     * @return
     */
    public boolean getRightsStatus() {
        return isAdminAuthorized;
    }

    /**
     * Returns name of current authorized user.
     *
     * @return currentUser.getUserName()
     */
    public String getUserName() {
        return currentUser.getUserName();
    }

    /**
     * Returns id of current authorized user.
     *
     * @return currentUser.getId()
     */
    public int getUserId() {
        return currentUser.getId();
    }
}
