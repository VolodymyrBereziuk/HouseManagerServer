/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.volodymyr.bereziuk.server.db.dao;

import com.volodymyr.bereziuk.server.dto.Room;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vova
 */
public class RoomDAO {
    private Connection connection = null;
    private Statement statement = null;

    public RoomDAO(Connection connection) {
        this.connection = connection;
        try {
            statement = this.connection.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public synchronized void insertRoom(Room room) {
        String sql
                = "INSERT INTO Room VALUES (" + room.getId() + ",'" + room.getName() + "')";
        try {
            int executeUpdate = this.statement.executeUpdate(sql);
            System.out.println(executeUpdate);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public synchronized boolean deleteRoom(Room room) {
        String sql
                = "DELETE FROM Room "
                + "WHERE id = " + room.getId();
        boolean result = false;
        try {
            result = this.statement.execute(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public synchronized Room selectRoomById(int id) {
        Room room = null;
        ResultSet result = null;
        String sql
                = "SELECT id,name FROM Room WHERE id=" + id;
        try {
            result = this.statement.executeQuery(sql);
            while (result.next()) {
               room = new Room(result.getInt("id"), result.getString("name"));
            }
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return room;
    }

    public synchronized List<Room> selectAllRoom() {
        List<Room> roomList = new ArrayList<Room>();
        ResultSet result = null;
        String sql
                = "SELECT id,name FROM Room";
        try {
            result = this.statement.executeQuery(sql);
            while (result.next()) {
                Room room = new Room(result.getInt("id"), result.getString("name"));
                roomList.add(room);
            }
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return roomList;
    }
}
