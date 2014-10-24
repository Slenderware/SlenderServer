/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.domain;

import org.hibernate.annotations.Entity;

@Entity
public class Status {
    private int id;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
