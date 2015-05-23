/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.volodymyr.bereziuk.server.dto;

import java.io.Serializable;

/**
 *
 * @author Vova
 */
public class Room implements Serializable {

    private int id;
    private String name;

    public Room(int id) {
        this.id = id;
    }

    public Room(String name) {
        this.name = name;
    }

    public Room(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
