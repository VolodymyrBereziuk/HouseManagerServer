/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;

/**
 *
 * @author Vova
 */
public class DAOMaker {

    private Connection connection = null;

    private DeviceDAO deviceDAO = null;
    private UserDAO userDAO = null;
    private MeasureDAO measureDAO = null;
    private UserDeviceDAO userDeviceDAO = null;
    private RoomDAO roomDAO = null;

    public DAOMaker(Connection connection) {
        this.connection = connection;

        this.deviceDAO = new DeviceDAO(connection);
        this.userDAO = new UserDAO(connection);
        this.userDeviceDAO = new UserDeviceDAO(connection);
        this.measureDAO = new MeasureDAO(connection);
        this.roomDAO = new RoomDAO(connection);
    }

    public UserDAO useUserDAO() {
        return userDAO;
    }

    public DeviceDAO useDeviceDAO() {
        return deviceDAO;
    }

    public MeasureDAO useMeasureDAO() {
        return measureDAO;
    }

    public UserDeviceDAO useUserDeviceDAO() {
        return userDeviceDAO;
    }

    public RoomDAO useRoomDAO() {
        return roomDAO;
    }
}
