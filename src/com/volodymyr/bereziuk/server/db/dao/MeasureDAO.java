/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.volodymyr.bereziuk.server.db.dao;

import com.volodymyr.bereziuk.server.dto.Measure;
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
public class MeasureDAO {

    private Connection connection = null;
    private Statement statement = null;

    public MeasureDAO(Connection connection) {
        this.connection = connection;
        try {
            statement = this.connection.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public synchronized void insertMeasure(Measure measure) {
        String sql
                = "INSERT INTO Measure VALUES (" + measure.getId() + "," + measure.getValue() + "," + measure.getPeriod() + "," + measure.getIdDevice() + ")";
        try {
            int executeUpdate = this.statement.executeUpdate(sql);
            System.out.println(executeUpdate);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public synchronized boolean deleteMeasure(Measure measure) {
        boolean result = false;
        String sql
                = "DELETE FROM Measure "
                + "WHERE id = " + measure.getId();
        try {
            result = this.statement.execute(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public synchronized Measure selectMeasureById(int id) {
        Measure measure = null;
        ResultSet result = null;
        String sql
                = "SELECT id,value, period, idDevice FROM Measure WHERE id=" + id;
        try {
            result = this.statement.executeQuery(sql);
            while (result.next()) {
                measure = new Measure(result.getInt("id"), result.getInt("value"), result.getInt("period"), result.getInt("idDevice"));
            }
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return measure;
    }

    public synchronized List<Measure> selectAllMeasure() {
        List<Measure> measureList = new ArrayList<Measure>();
        ResultSet result = null;
        String sql
                = "SELECT id,value,period,idDevice FROM Measure";
        try {
            result = this.statement.executeQuery(sql);
            while (result.next()) {
                Measure measure = new Measure(result.getInt("id"), result.getInt("value"), result.getInt("period"), result.getInt("idDevice"));
                measureList.add(measure);
            }
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return measureList;
    }
}
