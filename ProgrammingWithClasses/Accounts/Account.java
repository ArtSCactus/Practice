/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses.Accounts;

/**
 *
 * @author ArtSCactus
 */
public class Account {

    private final int id;
    private String userName;
    private int balance;
    private boolean accountBlocked;

    public Account(int id, String userName, int balance, boolean accountBlocked) {
        if (id < 0) {
            throw new IllegalArgumentException("Account id cannot be less than 0");
        }
        if (userName == null) {
            throw new NullPointerException("User name cannot be null");
        }
        this.id = id;
        this.userName = userName;
        this.balance = balance;
        this.accountBlocked = accountBlocked;
    }

    public int getID() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if (accountBlocked) {
            System.out.println("Access denied. Cause: account blocked.");
        }
        else {
        if (userName == null) {
            throw new NullPointerException("User name cannot be null");
        }
        this.userName = userName;
        }
    }

    public int getBalance() {
        if (accountBlocked) {
            System.out.println("Access denied. Cause: account blocked.");
            return 0;
        } else {
            return balance;
        }

    }

    public void setBalance(int balance) {
        if (accountBlocked) {
            System.out.println("Access denied. Cause: account blocked.");
        } else {
            this.balance = balance;
        }
    }

    public boolean isAccountBlocked() {
        return accountBlocked;
    }

    public void blockAccount(boolean accountBlocked) {
        this.accountBlocked = accountBlocked;
    }

    @Override
    public String toString() {
        return "Account " + "ID:" + id + "\nUser name: " + userName + "\n Balance: " + balance + "\n Account blocked: " + accountBlocked;
    }
}
