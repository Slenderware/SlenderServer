/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.app.factory;

import com.slender.domain.Status;

public class StatusFactory {
    public Status getStatus(String stat){
        Status status = new Status();
        status.setStatus(stat);
        return status;
    }
}
