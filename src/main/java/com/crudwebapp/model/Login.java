package com.crudwebapp.model;

/**
 *
 * @author nikesh.maharjan
 */
public class Login {

    private String username, password;
    private int id;

    public Login() {
    }

    public Login(String user, String pass) {
        this.username = user;
        this.password = pass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User Info: ID - " + this.id + ", USERNAME - " + this.username + ", PASSWORD - " + this.password;
    }

}
