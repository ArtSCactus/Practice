/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Home_library;

import Practice.Home_library.Data.Catalog.Library;
import Practice.Home_library.Utill.AccountManager.AccountManager;
import Practice.Home_library.Utill.AccountManager.User;
import Practice.Home_library.Utill.BookTamplates.Book;
import Practice.Home_library.Utill.BookTamplates.Digital;
import Practice.Home_library.Utill.BookTamplates.Paper;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ArtSCactus
 */
public class Menu {

    /**
     * Contains Library class object, which stores books and editing
     * Book_storage.txt file.
     *
     */
    private Library library;
    /**
     * Contains AccountManager class object, that consist all accounts list,
     * logs into accounts and various actions with themю
     *
     */
    private AccountManager accounts;
    /**
     * Scanner to read user input.
     *
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Initializing library and account manager with authorized user. Consist
     * user interface, with log in function.
     *
     * @throws IOException
     */
    private void logInMenu() throws IOException {
        library = new Library();
        accounts = new AccountManager();
        System.out.println("Hello! Who are you?");
        System.out.println("1-sign in\n2-sign up");
        int choice;
        while (true) {
            choice = scanner.nextInt();
            if (choice == 1 | choice == 2) {
                break;
            } else {
                System.out.println("Please choose the correct answer");
            }
        }
        switch (choice) {
            case (1):
                //Sign up interface
                String userName;
                String password;
                while (true) {
                    System.out.print("User name: ");
                    userName = scanner.next().trim();
                    if (scanner.hasNextLine()) {
                        userName += scanner.nextLine();
                    }
                    System.out.print("Password: ");
                    password = scanner.next().trim();
                    if (scanner.hasNextLine()) {
                        password += scanner.nextLine();
                    }
                    try {
                        library.signIn(accounts.logInUser(userName, password));
                        break;
                    } catch (NullPointerException ex) {
                        System.out.println("Wrong user name or password.");
                    }
                }
                break;
            case (2):
                System.out.print("Fill your name: ");
                userName = scanner.next().trim();
                if (scanner.hasNextLine()) {
                    userName += scanner.nextLine();
                }
                System.out.print("Create a password: ");
                password = scanner.next().trim();
                if (scanner.hasNextLine()) {
                    password += scanner.nextLine();
                }
                try {
                    accounts.addAccount(new User(userName, password, false));
                    library.signIn(accounts.logInUser(userName, password));
                    mainMenu();
                } catch (NullPointerException ex) {
                    System.out.println("Wrong user name or password.");
                }
        }

    }

    /**
     * Consists main menu interface, that runs different functions, like request
     * book or add book.
     *
     * @throws IOException
     */
    public void mainMenu() throws IOException {
        System.out.println("~~~~~~~~Main menu~~~~~~~~");
        if (library.getRightsStatus()) {
            System.out.println("1-Show books\n2-Find book\n3-Request book\n4-Email"
                    + "\n5-add book\n6-delete book\n7-exit");
        } else {
            System.out.println("1-Show books\n2-Find book\n3-Request book\n4-Email"
                    + "\n7-exit");
        }
        int choice; //Command number indicator
        String bookName; //Consist inputed book name
        String bookAuthor;//Consist inputed book author
        Book book; //Consist founded book
        while (true) {
            choice = scanner.nextInt();
            if (choice < 1 | choice > 7) {
                System.out.println("Wrong command number");
            } else {
                break;
            }
        }
        switch (choice) {
            case (1):
                //Print books
                System.out.flush();
                library.printByPage(10);// 10 here is amount of books on page
                break;
            case (2):
                //Find book
                System.out.flush();
                System.out.print("Enter a book name: ");
                bookName = scanner.nextLine();
                if (scanner.hasNextLine()) {
                    bookName = scanner.nextLine();
                }
                book = library.findBookByName(bookName);
                try {
                    System.out.println(book.toString());
                } catch (NullPointerException ex) {
                    System.out.println("No match found");
                }
                System.out.flush();
                break;
            case (3):
                //Request book 
                System.out.flush();
                System.out.print("Enter a book name: ");
                bookName = scanner.nextLine();
                if (scanner.hasNextLine()) {
                    bookName = scanner.nextLine();
                }
                System.out.print("Enter book author: ");
                bookAuthor = scanner.nextLine();
                if (scanner.hasNextLine()) {
                    bookAuthor = scanner.nextLine();
                }
                //Sending admins request, from current user to add book.
                accounts.sendAdmins("New request to add new book from user "
                        + library.getUserName() + " ID: " + library.getUserId()
                        + " Book: " + bookAuthor + " " + bookName);
                break;
            case (4):
                System.out.flush();
                //Runs mailbox interface
                accounts.showMailbox();
                break;
            case (5):
                /*
                Checks the rights of the current user in case of unauthorized access to administrator commands.
                 */
                if (!library.getRightsStatus()) {
                    break;
                }
                System.out.flush();
                System.out.print("Enter a book name: ");
                bookName = scanner.nextLine();
                if (scanner.hasNextLine()) {
                    bookName = scanner.nextLine();
                }
                System.out.print("Enter book author: ");
                bookAuthor = scanner.nextLine();
                System.out.println("Choose edition type:\n1-Digital\n2-Paper");
                choice = scanner.nextInt();
                if (choice == 1) {
                    book = new Paper(bookAuthor, bookName);
                    library.addBook(book);
                } else {
                    book = new Digital(bookAuthor, bookName);
                    library.addBook(book);
                }
                accounts.sendUser("New book has been added: " + book.getAuthor() + " " + book.getName());
                break;
            case (6):
                /* Delete book
                Checks the rights of the current user in case of unauthorized access to administrator commands.
                 */
                if (!library.getRightsStatus()) {
                    break;
                }
                System.out.flush();
                System.out.print("Enter a book name: ");
                bookName = scanner.nextLine();
                if (scanner.hasNextLine()) {
                    bookName = scanner.nextLine();
                }
                System.out.print("Enter book author: ");
                bookAuthor = scanner.nextLine();
                System.out.println("Which type of books should be deleted?"
                        + "\n1-All\n2-Only digital\n3-Only paper");
                while (true) {
                    choice = scanner.nextInt();
                    if (choice < 1 | choice > 3) {
                        System.out.println("Please choose from given variants.");
                    } else {
                        break;
                    }
                }
                switch (choice) {
                    case (1):
                        library.deleteBook(bookName, bookAuthor);
                        break;
                    case (2):
                        library.deleteBook(bookName, bookAuthor, "digiatl");
                        break;
                    case (3):
                        library.deleteBook(bookName, bookAuthor, "paper");
                        break;
                }
                break;
            case (7):
                System.exit(0);
            default:
                System.out.println("Wrong command number");
                break;
        }

    }

    /**
     * Constructs all user interface and runs console application.
     *
     * @throws IOException
     */
    public void run() throws IOException {
        logInMenu();
        while (true) {
            mainMenu();
        }
    }
}
