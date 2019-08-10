/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Module_6.Home_library.Utill.AccountManager;

import Practice.Module_6.Home_library.EmailSystem.EmailSystem;
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
public class AccountManager {

    /**
     * Consist file with accounts list.
     *
     */
    private File userDataBase;
    /**
     * Consist file with users passwords and their id.
     *
     */
    private File confidentionalInformation;
    /**
     * Contains methods to change the contents of files.
     *
     */
    private FileWriter toFile;
    /**
     * Contains methods to get the contents of files.
     *
     */
    private FileReader fromFile;
    /**
     * List of accounts. Initializing with constructor. Contains accounts, that
     * has been readed from file and constructs.
     *
     */
    private List<User> accountList;
    /**
     * Consist passwords of users. Also initializing with constructor by reading
     * from file.
     *
     */
    private List<String> passwords;
    /**
     * Scanner tor read files content.
     *
     */
    private BufferedReader scanner;
    /**
     * Email system to malboxes of users.
     *
     */
    private EmailSystem emails;
    /**
     * Contains index in accountList of authorized user.
     *
     */
    private int activeUserIndex;

    /**
     * Constructs Account manager object and reading files, that consist users
     * list and their passwords, then filling the lists. Warning: given
     * emailStoragePath and accountStoragePath must be a path to folder. In this
     * folder will be created folder "Users" and 2 files: account storage and
     * passwordStorage.
     *
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public AccountManager(String emailStoragePath, String accountStoragePath) throws FileNotFoundException, IOException {
        emails = new EmailSystem(emailStoragePath);
        userDataBase = new File(accountStoragePath + "\\Users\\Account storage.txt");
        confidentionalInformation = new File(accountStoragePath + "\\Users\\Stash.hl");
        if (!confidentionalInformation.exists()) {
            confidentionalInformation.createNewFile();
        }
        if (userDataBase.exists()) {
            String[] buffer;//Needs to store splited row with information about user
            String[] passwordBuffer;//Needs to store splited row with user's password and id
            fromFile = new FileReader(userDataBase);
            FileReader passwordReader = new FileReader(confidentionalInformation);
            BufferedReader passwordScanner = new BufferedReader(passwordReader);
            scanner = new BufferedReader(fromFile);
            //Checking on existance file with passwords
            if (!confidentionalInformation.exists()) {
                confidentionalInformation.createNewFile();
            }
            accountList = new ArrayList<>();
            passwords = new ArrayList<>();
            while (scanner.ready()) {
                buffer = scanner.readLine().split("\\|");
                passwordBuffer = passwordScanner.readLine().split("\\|");
                passwords.add(passwordBuffer[0]);
                //Recognizes user type by special mark
                if (buffer[2].equals("admin")) {
                    accountList.add(new User(buffer[0], passwordBuffer[0],
                            Integer.parseInt(buffer[1]), emails.getMailboxById(Integer.parseInt(buffer[1])), true));
                } else if (buffer[2].equals("user")) {
                    accountList.add(new User(buffer[0], passwordBuffer[0],
                            Integer.parseInt(buffer[1]), emails.getMailboxById(Integer.parseInt(buffer[1])), false));
                }
            }
            fromFile.close();
        } else {
            //If there is no user list file creating such file and initializng lists
            //Also checking on existance file with passwords
            userDataBase.createNewFile();
            accountList = new ArrayList<>();
            passwords = new ArrayList<>();
            if (!confidentionalInformation.exists()) {
                confidentionalInformation.createNewFile();
            }

        }
    }

    /**
     * Writing current users and passwords list to files.
     *
     * @throws IOException
     */
    public void saveList() throws IOException {
        toFile = new FileWriter(userDataBase);
        for (int index = 0; index < accountList.size(); index++) {
            if (accountList.get(index).isAdmin()) {
                toFile.write(accountList.get(index).getUserName() + "|" + accountList.get(index).getId() + "|admin\n");
            } else {
                toFile.write(accountList.get(index).getUserName() + "|" + accountList.get(index).getId() + "|user\n");
            }

        }
        toFile.close();
        toFile = new FileWriter(confidentionalInformation);
        for (int index = 0; index < accountList.size(); index++) {
            toFile.write(accountList.get(index).getPassword() + "|" + accountList.get(index).getId() + "\n");
        }
        toFile.close();
    }

    /**
     * Adds new account to the list and saving it to file.
     *
     * @param account
     * @throws IOException
     * @throws NullPointerException if account are null
     */
    public void addAccount(User account) throws IOException {
        if (account == null) {
            throw new NullPointerException("Account cannot be null");
        }
        while (checkIdOnMatch(account.getId())) {
            account.generateId();
        }
        accountList.add(account);
        passwords.add(account.getPassword());
        saveList();
    }

    /**
     * Prints to console all users in list as it saved in file. This method was
     * needed in developing processs, but i think it is useful and can be useв
     * in case of such method needs.
     *
     */
    public void printUserList() {
        for (User user : accountList) {
            if (user.isAdmin()) {
                System.out.println(user.getUserName() + "|" + user.getPassword() + "|admin");
            } else {
                System.out.println(user.getUserName() + "|" + user.getPassword() + "|user");
            }
        }
    }

    /**
     * Matches inputed user name and password with existing users.
     *
     * @param userName
     * @param password
     * @return User with such name and password. Null otherwise.
     */
    public User logInUser(String userName, String password) {
        int counter = 0;
        for (int index = 0; index < accountList.size(); index++, counter++) {
            if (accountList.get(index).logIn(userName, password)) {
                activeUserIndex = counter;
                return accountList.get(index);
            }
        }
        return null;
    }

    /**
     * Idmust be unique for each user, because it links with is email address.
     * This method checking given id on matches with id of other users
     *
     * @param id
     * @return true if match was found, false otherwise.
     */
    public boolean checkIdOnMatch(int id) {
        for (User user : accountList) {
            if (user.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sending message to all administrators email address by calling method
     * <code>sendMessage()</code> for each administrator.
     *
     * @param message
     * @throws IOException
     */
    public void sendAdmins(String message) throws IOException {
        for (User user : accountList) {
            if (user.isAdmin()) {
                user.sendMessage(message);
            }
        }
    }

    /**
     * Sending message to all users(not administrators) email address by calling
     * method <code>sendMessage()</code> for each user.
     *
     * @param message
     * @throws IOException
     */
    public void sendUser(String message) throws IOException {
        for (User user : accountList) {
            if (!user.isAdmin()) {
                user.sendMessage(message);
            }
        }
    }

    /**
     * Runs mailbox interface with possibility to show all messages and clear
     * mailbox.
     *
     * @throws IOException
     */
    public void showMailbox() throws IOException {
        List<String> messages = new ArrayList<>();
        System.out.println("~~~~~~~~~Mailbox~~~~~~~~~\n1-show mailbox\n2-clear mailbox");
        int choice; //contains command number inputed by user
        Scanner scan = new Scanner(System.in);
        while (true) {
            choice = scan.nextInt();
            if (choice < 1 | choice > 2) {
                System.out.println("Wrong command number");
            } else {
                break;
            }
        }
        switch (choice) {
            case (1):
                //Shows all messages
                messages = accountList.get(activeUserIndex).showMailBox();
                if (messages.size() > 1) {
                    System.out.println("You have " + messages.size() + " new messages");
                } else {
                    System.out.println("You have " + messages.size() + " new message");
                }
                for (String message : messages) {
                    System.out.println(message);
                }
                break;
            case (2):
                //Clearing mailbox
                accountList.get(activeUserIndex).clearMailBox();
                break;
        }
    }
}
