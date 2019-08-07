/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Home_library.Utill.AccountManager;

import Practice.Home_library.EmailSystem.Mailbox;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author ArtSCactus
 */
public class User {

    /**
     * Contains user's name. Cannot be null.
     */
    private String userName;
    /**
     * Contains user's password. Can be null. If it null, that means this user
     * account are without password.
     *
     */
    private String password;
    /**
     * Flag that gives administration rights.
     *
     */
    private boolean admin = false;
    private int id;
    private Mailbox mailbox;

    /**
     * Constructs new User object.
     *
     * @param userName - user name
     * @param password - user's password. Set null to construct account without
     * password.
     * @throws NullPointerException if userName are null
     */
    public User(String userName, String password, boolean admin) throws IOException {
        if (userName == null) {
            throw new NullPointerException("User name cannot be null");
        }
        this.userName = userName;
        this.password = password;
        this.admin = admin;
        id = ThreadLocalRandom.current().nextInt(1000000, 10000000);
        mailbox=new Mailbox(id);

    }
        public User(String userName, String password,int id, Mailbox mailbox, boolean admin) {
        if (userName == null) {
            throw new NullPointerException("User name cannot be null");
        }
        this.userName = userName;
        this.password = password;
        this.admin = admin;
        this.id = id;
        this.mailbox=mailbox;

    }

    /**
     * Checks given user name and password. If it correct returns true,returns
     * false otherwise.
     *
     * @param userName
     * @param password
     * @return true/false
     */
    public boolean logIn(String userName, String password) {
        if (this.userName.equals(userName) & this.password.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public int getId() {
        return id;
    }

    public void generateId() {
        id = ThreadLocalRandom.current().nextInt(1000000, 10000000);
    }

    public void setId(int id) {
        this.id = id;
    }
    public void sendMessage(String message) throws IOException{
        mailbox.acceptMassage(message);
    }
    public List<String> showMailBox() throws IOException{
        return mailbox.getEmails();
    }
    public void clearMailBox() throws IOException{
        mailbox.clearMailbox();
    }
}
