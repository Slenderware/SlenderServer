/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.app.factory;

import com.slender.domain.UserProject;

public class UserProjectFactory {
    public UserProject getUserProject(int userId, int porjectId){
        UserProject userProject = new UserProject();
        userProject.setProjectId(porjectId);
        userProject.setUserId(userId);
        return userProject;
    }
}
