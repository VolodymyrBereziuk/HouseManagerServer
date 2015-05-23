/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author Vova
 */
public class Device implements Serializable {

    private int id;
    private String name;
    private String information;
    private int isMeasured;
    private int isEnable;
    private int idRoom;
    private int idDriver;

    public Device(int id) {
        this.id = id;
    }

    public Device(int id, String name, String information, int isMeasured, int isEnable, int idRoom, int idDriver) {
        this.id = id;
        this.name = name;
        this.information = information;
        this.isMeasured = isMeasured;
        this.isEnable = isEnable;
        this.idRoom = idRoom;
        this.idDriver = idDriver;
    }

    public Device(String name, String information, int isEnable, int idRoom) {

        this.name = name;
        this.information = information;
        this.isEnable = isEnable;
        this.idRoom = idRoom;
    }

    public Device(int id, String name, String information, int isEnable, int idRoom) {
        this.id = id;
        this.name = name;
        this.information = information;
        this.isEnable = isEnable;
        this.idRoom = idRoom;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInformation() {
        return information;
    }

    public int getIsMeasured() {
        return isMeasured;
    }

    public int getIsEnable() {
        return isEnable;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public int getIdDriver() {
        return idDriver;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void setIsMeasured(int isMeasured) {
        this.isMeasured = isMeasured;
    }

    public void setIsEnable(int isEnable) {
        this.isEnable = isEnable;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public void setIdDevice(int idDriver) {
        this.idDriver = idDriver;
    }

    public void print() {
        System.out.println(getId() + " " + getName() + " " + getInformation() + " " + getIsEnable());
    }
}
