/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.app.factory;

import com.slender.domain.Role;

public class RoleFactory {
    public Role getRole(String rol){
        Role role = new Role();
        role.setRole(rol);
        return role;
    }
}
