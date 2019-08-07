/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Home_library.EmailSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ArtSCactus
 */
public class Mailbox {

    private File mailbox;
    private int userId;

    public Mailbox(File mailbox, int userId) {
        if (mailbox == null) {
            throw new NullPointerException("Mailbox cannot be null");
        }
        this.mailbox = mailbox;
        this.userId = userId;
    }

    public Mailbox(int userId) throws IOException {
        this.userId = userId;
        mailbox = new File("src\\Practice\\Home_library\\EmailSystem\\Emails\\" + userId + ".txt");
        mailbox.createNewFile();
    }

    public void showNewMessages() throws FileNotFoundException, IOException {
        FileReader fromFile = new FileReader(mailbox);
        BufferedReader scanner = new BufferedReader(fromFile);
        List<String> messages = new ArrayList<>();
        while (scanner.ready()) {
            messages.add(scanner.readLine());
        }
        fromFile.close();
        System.out.println("You have " + messages.size() + " new massages: ");
        for (String message : messages) {
            System.out.println(message);
        }
        FileWriter toFile = new FileWriter(mailbox, true);
        toFile.write("");
        toFile.close();
    }

    public void acceptMassage(String message) throws IOException {
        FileWriter toFile = new FileWriter(mailbox, true);
        toFile.append(message+"\n");
        toFile.close();
    }

    public int getId() {
        return userId;
    }

    public List<String> getEmails() throws FileNotFoundException, IOException {
        FileReader fromFile = new FileReader(mailbox);
        BufferedReader scanner = new BufferedReader(fromFile);
        List<String> messages = new ArrayList<>();
        while (scanner.ready()) {
            messages.add(scanner.readLine());
        }
        return messages;
    }
    public void clearMailbox() throws IOException{
        FileWriter clearFile = new FileWriter(mailbox);
        clearFile.close();
    }

    public void toCnsole() {
        System.out.println("Mailbox of user " + userId);
    }
}
