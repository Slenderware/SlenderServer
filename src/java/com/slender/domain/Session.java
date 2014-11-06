/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Entity;

@Entity
@XmlRootElement
public class Session implements Serializable{
    private String id;
    private Integer userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
