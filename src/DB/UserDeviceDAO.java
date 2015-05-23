/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import DTO.*;
import DTO.UserDevice;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Vova
 */
public class UserDeviceDAO {

    private Connection connection = null;
    private Statement statement = null;

    public UserDeviceDAO(Connection connection) {
        this.connection = connection;
        try {
            statement = this.connection.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public synchronized void insertUserDevice(UserDevice userDevice) {
         DateFormat dateFormat = new SimpleDateFormat("yyyy MM dd HH:mm:ss");  
         String startDate = dateFormat.format(userDevice.getStartTime());
         String finishDate = dateFormat.format(userDevice.getFinishTime());
           String sql  = "INSERT INTO UserDevice VALUES (" + userDevice.getUser().getId() + "," + userDevice.getDevice().getId() + ", '" + startDate + "', '" + finishDate + "' )";
        try {
            int executeUpdate = this.statement.executeUpdate(sql);
            System.out.println(executeUpdate);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public synchronized void deleteUserDevice(int userId ,int deviceId)
    {
         String sql
                ="DELETE FROM UserDevice " +
                   "WHERE idUser = "+userId+ " & idDevice = "+deviceId;
        try {
            this.statement.execute(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public synchronized List<UserDevice> selectAll(UserDAO userDAO, DeviceDAO deviceDAO) {
        List<UserDevice> userDeviceList = new ArrayList<UserDevice>();
        ResultSet result = null;

        String sql
                = "SELECT idUser, idDevice, startTime, finishTime  FROM UserDevice";
        try {
            result = this.statement.executeQuery(sql);
            while (result.next()) {
                int userId = result.getInt("idUser");
                int deviceId = result.getInt("idDevice");
           
                User user = userDAO.selectUserById(userId);
                Device device = deviceDAO.selectDeviceById(deviceId);
                
                DateFormat dateFormatStart = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
                DateFormat dateFormatFinish = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
                Date dateStart = new Date();
                Date dateFinish = new Date();
                try {
                       dateStart = dateFormatStart.parse(result.getString("startTime"));
                      dateFinish = dateFormatFinish.parse(result.getString("finishTime"));
                } catch (ParseException ex) {
                ex.printStackTrace();
                }
                             
                UserDevice userDevice = new UserDevice(user, device,dateStart,dateFinish );
                userDeviceList.add(userDevice);
            }
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return userDeviceList;
    }

}
