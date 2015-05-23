/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.volodymyr.bereziuk.server.db.dao;

import com.volodymyr.bereziuk.server.dto.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vova
 */
public class UserDAO {

    private Connection connection = null;
    private Statement statement = null;

    public UserDAO(Connection connection) {
        this.connection = connection;
        try {
            statement = this.connection.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    

    public synchronized void insertUser(User user) {

        
        String sql
                = "INSERT INTO User VALUES (" + user.getId() + ",'" + user.getLogin() + "','" + user.getPassword() + "'," + user.getIsSuperUser() + "," + user.getIsRootUser() +"," +temp()+","+")";
        try {
            int executeUpdate = this.statement.executeUpdate(sql);
            System.out.println(executeUpdate);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private FileInputStream temp()
    {
        FileInputStream fis = null;
        File file = new File("/dist/bart.png");
        try {
         fis = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fis;
    }
    
    
    public synchronized boolean deleteUser(User user) {
        boolean result = true;
        String sql
                = "DELETE FROM User "
                + "WHERE id = " + user.getId();
        try {
            result = this.statement.execute(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    public synchronized User selectUserById(int id) {
        User user = null;
        ResultSet result = null;
        String sql
                = "SELECT id, login, password, isSuperUser ,isRootUser FROM User Where id =" + id;
        try {
            result = this.statement.executeQuery(sql);
            while (result.next()) {
                user = new User(result.getInt("id"), result.getString("login"), result.getString("password"), result.getInt("isSuperUser"), result.getInt("isRootUser"));
            }
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public synchronized List<User> selectAllUser() {
        
        insertUser(new User(1));
        
        List<User> userList = new ArrayList<User>();
        ResultSet result = null;
        String sql
                = "SELECT id, login, password, isSuperUser ,isRootUser FROM User";
        try {
            result = this.statement.executeQuery(sql);
            while (result.next()) {
                User user = new User(result.getInt("id"), result.getString("login"), result.getString("password"), result.getInt("isSuperUser"), result.getInt("isRootUser"));
                userList.add(user);
            }
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userList;
    }

    public synchronized User exist(User user) {
        ResultSet result = null;
        User existUser = null;
        String sql = "SELECT id, login, password, isSuperUser ,isRootUser FROM User WHERE login ='" + user.getLogin() + "' and password ='" + user.getPassword() + "'";
        try {
            result = this.statement.executeQuery(sql);
            if (result.next()) {
                existUser = new User(result.getInt("id"), result.getString("login"), result.getString("password"), result.getInt("isSuperUser"), result.getInt("isRootUser"));
            } else {
                System.out.println("return null");
                return null;
            }
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return existUser;

    }
}
