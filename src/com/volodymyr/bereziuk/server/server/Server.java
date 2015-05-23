/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.volodymyr.bereziuk.server.server;

import com.volodymyr.bereziuk.server.db.dao.DAOMaker;
import java.io.IOException;
import java.net.*;
import DB.*;


/**
 *
 * @author Vova
 */
public class Server {

    private static final int PORT = 6666;
    
    private DAOMaker makerDAO = null;
    private ServerSocket server = null;
    private Socket socket = null;
    private boolean run = true;
    
   
    public Server(DAOMaker makerDAO) {
        this.makerDAO = makerDAO;
    }
    public void start() {
        try {
            server = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // server start work, wait until client connect 
        while (run) {
            try {
                socket = server.accept();
                System.out.println("client " + socket.getInetAddress() + " accepted");
            } catch (IOException e) {
                e.printStackTrace();
            }
            // client connected and new thread for this client stert work
            if (socket != null) {
                ServerHandler serverHandler = new ServerHandler(socket,makerDAO);
                Thread t = new Thread(serverHandler);
                t.start();
            }
        }
    }

}
