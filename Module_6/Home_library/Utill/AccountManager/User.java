/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Module_6.Home_library.Utill.AccountManager;

import Practice.Module_6.Home_library.EmailSystem.Mailbox;
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
    /**
     * Contains id of current user. Must be unique.
     *
     */
    private int id;
    /**
     * Contains mailbox of current user.
     *
     */
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
        mailbox = new Mailbox(id);

    }

    /**
     * Constructs user with given characeristics. Used to restore existing user.
     *
     *
     * @param userName
     * @param password
     * @param id
     * @param mailbox
     * @param admin
     * @throws NullPointerException if userName or password are null
     * @throws IllegalArgumentException if id less than 1 000 000 or bigger than
     * 10 000 000
     */
    public User(String userName, String password, int id, Mailbox mailbox, boolean admin) {
        if (userName == null | password == null) {
            throw new NullPointerException("User name or password cannot be null");
        }
        if (id < 1000000 | id > 10000000) {
            throw new IllegalArgumentException("Wrong id number");
        }

        this.userName = userName;
        this.password = password;
        this.admin = admin;
        this.id = id;
        this.mailbox = mailbox;

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

    /**
     * Returns user name.
     *
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Settings new name to the current user.
     *
     * @param userName
     */
    public void setUserName(String userName) throws NullPointerException {
        if (userName == null) {
            throw new NullPointerException("User name cannot be null");
        }
        this.userName = userName;
    }

    /**
     * Returns user password to check on matches.
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Settings new password to the current user.
     *
     * @param userName
     */
    public void setPassword(String password) throws NullPointerException {
        if (password == null) {
            throw new NullPointerException("User name cannot be null");
        }
        this.password = password;
    }

    /**
     * Returns true if current user are admin. False otherwise.
     *
     * @return true/false
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * Returns id of current user.
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Generats new user id from. This is number from 1 000 000 to 10 000 000.
     *
     */
    public void generateId() {
        id = ThreadLocalRandom.current().nextInt(1000000, 10000000);
    }

    /**
     * Settings new user id.
     *
     * @param id
     * @throws IllegalArgumentException if id less than 1 000 000 or bigger than
     * 10 000 000
     */
    public void setId(int id) throws IllegalArgumentException {
        if (id < 1000000 | id > 10000000) {
            throw new IllegalArgumentException("Wrong id number");
        }
        this.id = id;
    }

    /**
     * Sending message to the current user.
     *
     * @param message
     * @throws IOException
     * @throws NullPointerException if message are null
     */
    public void sendMessage(String message) throws IOException {
        if (message == null) {
            throw new NullPointerException("Message cannot be null");
        }
        mailbox.acceptMassage(message);
    }

    /**
     * Returns messages from mailbox as List.
     *
     * @return
     * @throws IOException
     */
    public List<String> showMailBox() throws IOException {
        return mailbox.getEmails();
    }

    /**
     * Clears mailbox of current user.
     *
     * @throws IOException
     */
    public void clearMailBox() throws IOException {
        mailbox.clearMailbox();
    }
}
