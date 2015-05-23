 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.volodymyr.bereziuk.server.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.volodymyr.bereziuk.server.transmit.TransmitObject;
import com.volodymyr.bereziuk.server.db.dao.DAOMaker;
import com.volodymyr.bereziuk.server.dto.Device;
import com.volodymyr.bereziuk.server.dto.Room;
import com.volodymyr.bereziuk.server.dto.User;
import com.volodymyr.bereziuk.server.dto.Measure;
import java.util.List;

/**
 *
 * @author Vova
 */
public class ServerHandler implements Runnable {

    private boolean work = true;
    private ObjectInputStream in = null;
    private ObjectOutputStream out = null;
    private Socket socket = null;
    private DAOMaker makerDAO = null;

    public ServerHandler(Socket socket, DAOMaker makerDAO) {
        this.socket = socket;
        this.makerDAO = makerDAO;
    }

    @Override
    public void run() {
        //Open streams
        try {
            //Out streams must stay at the first possition
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

        } catch (IOException e1) {
            e1.printStackTrace();
        }
        //handle event
        handle(out, in);
        //close server sockets after work 
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void handle(ObjectOutputStream out, ObjectInputStream in) {
        TransmitObject receivedObject = null;
        while (work) {
            try {
                    receivedObject = (TransmitObject) in.readObject();

                switch (receivedObject.getCommand()) {

                    case USEREXIST: {
                        System.out.println("UserExist");
                        User user = makerDAO.useUserDAO().exist((User) receivedObject.getObject());
                        out.writeObject(user);
                        break;
                    }

                    case ADDDEVICE: {
                        System.out.println("AddDevice");
                        makerDAO.useDeviceDAO().insertDevice((Device) receivedObject.getObject());
                        out.writeObject(true);
                        break;
                    }

                    case SHOWALLDEVICES: {
                        System.out.println("Show all devices");
                        List<Device> deviceList = makerDAO.useDeviceDAO().selectAllDevice();
                        out.writeObject(deviceList);
                        break;
                    }

                    case DELETEDEVICE: {
                        System.out.println("Delete device");
                        boolean result = makerDAO.useDeviceDAO().deleteDevice((Device) receivedObject.getObject());
                        out.writeObject(result);
                        break;
                    }

                    case ADDROOM: {
                        System.out.println("Add Room");
                        makerDAO.useRoomDAO().insertRoom((Room) receivedObject.getObject());
                        out.writeObject(true);
                        break;
                    }

                    case SHOWALLROOM: {
                        System.out.println("Show all rooms");
                        List<Room> roomList = makerDAO.useRoomDAO().selectAllRoom();
                        out.writeObject(roomList);
                        break;
                    }

                    case DELETEROOM: {
                        System.out.println("Delete room");
                        boolean result = makerDAO.useRoomDAO().deleteRoom((Room) receivedObject.getObject());
                        out.writeObject(result);
                        break;
                    }
                    
                      case SHOWALLUSER: {
                        System.out.println("Show all user");
                        List<User> userList = makerDAO.useUserDAO().selectAllUser();
                        out.writeObject(userList);
                        break;
                    }

                    case DELETEUSER: {
                        System.out.println("Delete user");
                        boolean result = makerDAO.useUserDAO().deleteUser((User) receivedObject.getObject());
                        out.writeObject(result);
                        break;
                    }
                    
                     case SHOWALLMEASURE: {
                        System.out.println("Show all measure");
                        List<Measure> measureList = makerDAO.useMeasureDAO().selectAllMeasure();
                        out.writeObject(measureList);
                        break;
                    }

                    case DELETEMEASURE: {
                        System.out.println("Delete measure");
                        boolean result = makerDAO.useMeasureDAO().deleteMeasure((Measure) receivedObject.getObject());
                        out.writeObject(result);
                        break;
                    }

                    case INITIALIZATION: {
                        System.out.println("Initialization");
                        User user = makerDAO.useUserDAO().exist((User) receivedObject.getObject());
                        out.writeObject(user);
                        break;
                    }
                    case CONFIRM: {
                        System.out.println("Confirm");
                        break;
                    }
                    case END: {
                        System.out.println("End");
                        work = false;
                        break;
                    }
                }

            } catch (ClassNotFoundException | IOException e) {
                receivedObject = null;
                e.printStackTrace();

            }
            receivedObject = null;
        }

    }
}
