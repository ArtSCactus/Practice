/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Home_library.Utill.AccountManager;

import Practice.Home_library.EmailSystem.EmailSystem;
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

    private File userDataBase;
    private File confidentionalInformation;
    private FileWriter toFile;
    private FileReader fromFile;
    private List<User> accountList;
    private List<String> passwords;
    private BufferedReader scanner;
    private EmailSystem emails;
    private int activeUserIndex;

    public AccountManager() throws FileNotFoundException, IOException {
        emails = new EmailSystem();
        userDataBase = new File("src\\Practice\\Home_library\\Utill\\AccountManager\\Users\\Account storage.txt");
        confidentionalInformation = new File("src\\Practice\\Home_library\\Utill\\AccountManager\\Users\\Stash.hl");
        if (!confidentionalInformation.exists()) {
            confidentionalInformation.createNewFile();
        }
        if (userDataBase.exists()) {
            String[] buffer;
            String[] passwordBuffer;
            fromFile = new FileReader(userDataBase);
            FileReader passwordReader = new FileReader(confidentionalInformation);
            BufferedReader passwordScanner = new BufferedReader(passwordReader);
            scanner = new BufferedReader(fromFile);
            accountList = new ArrayList<>();
            passwords = new ArrayList<>();
            while (scanner.ready()) {
                buffer = scanner.readLine().split("\\|");
                passwordBuffer = passwordScanner.readLine().split("\\|");
                passwords.add(passwordBuffer[0]);
                if (buffer[2].equals("admin")) {
                    accountList.add(new User(buffer[0], passwordBuffer[0], Integer.parseInt(buffer[1]), emails.getMailboxById(Integer.parseInt(buffer[1])), true));
                } else if (buffer[2].equals("user")) {
                    accountList.add(new User(buffer[0], passwordBuffer[0], Integer.parseInt(buffer[1]), emails.getMailboxById(Integer.parseInt(buffer[1])), false));
                }
            }
            fromFile.close();
        } else {
            userDataBase.createNewFile();
            accountList = new ArrayList<>();
        }
    }

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

    public void printUserList() {
        for (User user : accountList) {
            if (user.isAdmin()) {
                System.out.println(user.getUserName() + "|" + user.getPassword() + "|admin");
            } else {
                System.out.println(user.getUserName() + "|" + user.getPassword() + "|user");
            }
        }
    }

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

    public boolean checkIdOnMatch(int id) {
        for (User user : accountList) {
            if (user.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void sendAdmins(String message) throws IOException {
        for (User user : accountList) {
            if (user.isAdmin()) {
                user.sendMessage(message);
            }
        }
    }

    public void sendUser(String message) throws IOException {
        for (User user : accountList) {
            if (!user.isAdmin()) {
                user.sendMessage(message);
            }
        }
    }

    public void showMailbox() throws IOException {
        List<String> messages = new ArrayList<>();
        System.out.println("~~~~~~~~~Mailbox~~~~~~~~~\n1-show mailbox\n2-clear mailbox");
        int choice=1;
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
                accountList.get(activeUserIndex).clearMailBox();
                break;
        }
    }
}
