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
public class Measure implements Serializable {

    private int id;
    private int value;
    private int period;
    private int idDevice;

    public Measure(int id) {
        this.id = id;
    }

    public Measure(int id, int value, int period, int idDevice) {
        this.id = id;
        this.value = value;
        this.period = period;
        this.idDevice = idDevice;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public int getPeriod() {
        return period;
    }

    public int getIdDevice() {
        return idDevice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setIdDevice(int idDevice) {
        this.idDevice = idDevice;
    }
}
