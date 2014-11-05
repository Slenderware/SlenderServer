/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.app.factory;

import com.slender.domain.Session;

public class SessionFactory {
    public Session getSession(String id, Integer userId){
        Session session = new Session();
        session.setId(id);
        session.setUserId(userId);
        return session;
    }
}
