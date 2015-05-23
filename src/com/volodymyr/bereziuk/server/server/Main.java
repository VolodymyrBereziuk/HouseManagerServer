/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.volodymyr.bereziuk.server.server;

import com.volodymyr.bereziuk.server.db.dao.DAOMaker;
import com.volodymyr.bereziuk.server.db.DBConnect;
import java.sql.Connection;


/**
 *
 * @author Vova
 */
public class Main {

  
    public static void main(String[] args) {
        // create db connection
        DBConnect connect = new DBConnect();
        System.out.println("Connected to db already.");
        // get connection 
        Connection connection = connect.getConnection();
        //create facade for DAO lavel
        DAOMaker makerDAO = new DAOMaker(connection);
        System.out.println("Make DAO already.");
        // create server object 
        Server server = new Server(makerDAO);
        // start server 
        System.out.println("Server start already.");
        server.start();
        
    }
}
