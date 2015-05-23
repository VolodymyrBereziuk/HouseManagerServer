/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.volodymyr.bereziuk.server.dto;

import java.io.Serializable;

/**
 *
 * @author Vova
 */
public class User implements Serializable {

    private int id;
    private String login;
    private String password;
    private int isSuperUser;
    private int isRootUser;

    public User(int id) {
        this.id = id;
    }

    public User(int id, String login, String password, int isSuperUser, int isRootUser) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.isSuperUser = isSuperUser;
        this.isRootUser = isRootUser;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getIsSuperUser() {
        return isSuperUser;
    }

    public int getIsRootUser() {
        return isRootUser;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String name) {
        this.login = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIsSuperUser(int isSuperUser) {
        this.isSuperUser = isSuperUser;
    }

    public void setIsRootUser(int isRootUser) {
        this.isRootUser = isRootUser;
    }

    public void print() {
        System.out.println(getId() + " " + getLogin() + " " + getPassword() + " " + getIsSuperUser() + " " + getIsRootUser());

    }
}
