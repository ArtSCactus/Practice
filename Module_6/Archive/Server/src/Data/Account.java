/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;

/**
 *
 * @author ArtSCactus
 */
public class Account implements Serializable {

    private String login;
    private String password;
    private boolean admin;
//Для абсолютно нового пользователя

    public Account(String login, String password, boolean admin) {
        if (login == null | password == null) {
            throw new NullPointerException("Login or password cannot be null");
        }
        this.login = login;
        this.password = password;
        this.admin = admin;
    }
//Для передачи через сокет

    public Account(String login, String password) {
        if (login == null | password == null) {
            throw new NullPointerException("Login or password cannot be null");
        }
        this.login = login;
        this.password = password;
        admin = false;
    }
    //Для сборки в парсере

    public Account() {
        login = null;
        password = null;
        admin = false;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login == null) {
            throw new NullPointerException("Login cannot be null");
        }
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null) {
            throw new NullPointerException("Password cannot be null");
        }
        this.password = password;
    }

    public void setRightsStatus(boolean admin) {
        this.admin = admin;
    }

    public boolean getRightsStatus() {
        return admin;
    }

    public boolean logIn(String login, String password) {
        if (login.equals(this.login) & password.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        if (admin) {
            return login + "|" + password + "|admin";
        } else {
            return login + "|" + password + "|user";
        }

    }

}
