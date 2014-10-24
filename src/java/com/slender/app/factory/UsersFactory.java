/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.app.factory;

import com.slender.domain.Users;

public class UsersFactory {
    public Users getUsers(String firstName, String lastName, String username, String email,
            String password, int roleId, int companyId){
        Users user = new Users();
        user.setCompanyId(companyId);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setRoleId(roleId);
        user.setUsername(username);
        return user;
    }
}
