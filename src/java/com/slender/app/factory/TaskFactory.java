/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.app.factory;

import com.slender.domain.Task;
import java.util.Date;

public class TaskFactory {
    public Task getTask(int projectId, String taskName, String taskDesc, Date plannedStartDate,
            Date plannedEndDate, Date startDate, Date endDate, int timeAllocation,
            int priorityId){
        Task task = new Task();
        task.setProjectId(projectId);
        task.setTaskName(taskName);
        task.setTaskDesc(taskDesc);
        task.setPlannedEndDate(plannedEndDate);
        task.setPlannedStartDate(plannedStartDate);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setTimeAllocation(timeAllocation);
        task.setPriorityId(priorityId);
        task.setStatusId(1);
        return task;
    }
}
