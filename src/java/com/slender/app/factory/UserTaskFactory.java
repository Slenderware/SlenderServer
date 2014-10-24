/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.app.factory;

import com.slender.domain.UserTask;

public class UserTaskFactory {
    public UserTask getUserTask(int userId, int taskId){
        UserTask userTask = new UserTask();
        userTask.setTaskId(taskId);
        userTask.setUserId(userId);
        return userTask;
    }
}
