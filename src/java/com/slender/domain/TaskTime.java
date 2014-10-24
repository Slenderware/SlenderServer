/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.domain;

import java.util.Date;
import org.hibernate.annotations.Entity;

@Entity
public class TaskTime {
    private int id;
    private int taskId;
    private int userId;
    private Date createDate;
    private int timeSpent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }
    
}
