/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.volodymyr.bereziuk.server.db.dao;

import com.volodymyr.bereziuk.server.dto.Device;
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
public class DeviceDAO {

    private Connection connection = null;
    private Statement statement = null;

    public DeviceDAO(Connection connection) {
        this.connection = connection;
        try {
            statement = this.connection.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public synchronized void insertDevice(Device device) {
        String sql
                = "INSERT INTO Device VALUES (" + device.getId() + ",'" + device.getName() + "','" + device.getInformation() + "'," + device.getIsMeasured() + "," + device.getIsEnable() + "," + device.getIdRoom() + "," + device.getIdDriver() + ")";
        try {
            int executeUpdate = this.statement.executeUpdate(sql);
            System.out.println(executeUpdate);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public synchronized boolean deleteDevice(Device device) {
        String sql
                = "DELETE FROM Device "
                + "WHERE id = " + device.getId();
        boolean result = false;
        try {
            result = this.statement.execute(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public synchronized Device selectDeviceById(int id) {
        Device device = null;
        ResultSet result = null;
        String sql
                = "SELECT id,name, information,isMeasured, isEnable , idRoom ,idDriver FROM Device WHERE id=" + id;
        try {
            result = this.statement.executeQuery(sql);
            while (result.next()) {
                device = new Device(result.getInt("id"), result.getString("name"), result.getString("information"),result.getInt("isMeasured"), result.getInt("isEnable"), result.getInt("idRoom"), result.getInt("idDriver"));
            }
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return device;
    }

    public synchronized List<Device> selectAllDevice() {
        List<Device> deviceList = new ArrayList<Device>();
        ResultSet result = null;
        String sql
                = "SELECT id,name, information,isMeasured, isEnable , idRoom ,idDriver FROM Device";
        try {
            result = this.statement.executeQuery(sql);
            while (result.next()) {
                Device device = new Device(result.getInt("id"), result.getString("name"), result.getString("information"),result.getInt("isMeasured"), result.getInt("isEnable"), result.getInt("idRoom"), result.getInt("idDriver"));
                deviceList.add(device);
            }
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return deviceList;
    }
}
