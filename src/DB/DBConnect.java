/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Vova
 */
public class DBConnect {

    private String jdbcDriver = "com.mysql.jdbc.Driver";
    private String dbUrl = "jdbc:mysql://localhost/smartHouse";
    private String user = "root";
    private String password = "root";
    private static Connection connection = null;

    public DBConnect(String jdbcDriver, String dbUrl, String user, String password) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.user = user;
        this.password = password;

        initialization();
    }

    public DBConnect() {
        initialization();
    }

    public void initialization() {
        try {
            //Register JDBC driver
            Class.forName(jdbcDriver);
            //Open a connection

            connection = DriverManager.getConnection(dbUrl,user,password);
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }//end try
       
    }
    
    public Connection getConnection()
    {
        return connection;
    }
}
