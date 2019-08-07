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
    /**Contains file with user's mailbox.
     * 
     */ 
    private File mailbox;
    /**Contains id of this mailbox owner.
     * 
     */
    private int userId;
/**Constructs mailbox object with given file and id.
 * 
 * @param mailbox
 * @param userId 
 * @throws NullPointerException if mailbox are null.
 */
    public Mailbox(File mailbox, int userId) {
        if (mailbox == null) {
            throw new NullPointerException("Mailbox cannot be null");
        }
        this.mailbox = mailbox;
        this.userId = userId;
    }
/**Creating new mailbox with given id.
 * 
 * @param userId
 * @throws IOException 
 */
    public Mailbox(int userId) throws IOException {
        this.userId = userId;
        mailbox = new File("src\\Practice\\Home_library\\EmailSystem\\Emails\\" + userId + ".txt");
        mailbox.createNewFile();
    }
/**Prints to console file(mailbox) content(messages).
 * 
 * @throws FileNotFoundException
 * @throws IOException 
 */
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
/**Adds new message to the end of file (the mailbox).
 * 
 * @param message
 * @throws IOException 
 */
    public void acceptMassage(String message) throws IOException {
        FileWriter toFile = new FileWriter(mailbox, true);
        toFile.append(message+"\n");
        toFile.close();
    }
/**Returns id of this mailbox(owner's id).
 * 
 * @return 
 */
    public int getId() {
        return userId;
    }
/**Returns file(mailbox) content as List.
 * 
 * @return <code>List<String>=new ArrayList<>();</code>
 * @throws FileNotFoundException
 * @throws IOException 
 */
    public List<String> getEmails() throws FileNotFoundException, IOException {
        FileReader fromFile = new FileReader(mailbox);
        BufferedReader scanner = new BufferedReader(fromFile);
        List<String> messages = new ArrayList<>();
        while (scanner.ready()) {
            messages.add(scanner.readLine());
        }
        return messages;
    }
    /**Clears file(mailbox).
     * 
     * @throws IOException 
     */
    public void clearMailbox() throws IOException{
        FileWriter clearFile = new FileWriter(mailbox);
        clearFile.close();
    }
}
