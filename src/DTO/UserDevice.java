/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Vova
 */
public class UserDevice implements Serializable {

    private User user;
    private Device device;
    private Date startTime;
    private Date finishTime;
    private int isOwned;

    public UserDevice(User user, Device device, Date startTime, Date finishTime, int isOwned) {
        this.user = user;
        this.device = device;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.isOwned = isOwned;
    }

    public UserDevice(User user, Device device, Date startTime, Date finishTime) {
        this.user = user;
        this.device = device;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public User getUser() {
        return user;
    }

    public Device getDevice() {
        return device;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public int getIsOwned() {
        return isOwned;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public void setIsOwned(int isOwned) {
        this.isOwned = isOwned;
    }

    public void print() {
        System.out.println(user.getId() + " " + device.getId() + " " + startTime.toString() + " " + finishTime.toString());

    }

}
