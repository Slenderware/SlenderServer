/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.domain;

import org.hibernate.annotations.Entity;

@Entity
public class UserTask {
    private int id;
    private int userId;
    private int taskId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    
}
