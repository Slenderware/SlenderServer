/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.app.factory;

import com.slender.domain.Project;
import java.util.Date;

public class ProjectFactory {
    public Project getProject(int creator, int manager, String name, String desc,
            Date startDate, Date endDate){
        Project project = new Project();
        project.setProjectCreator(creator);
        project.setProjectManager(manager);
        project.setProjectName(name);
        project.setProjectDescription(desc);
        project.setStartDate(startDate);
        project.setEndDate(endDate);
        project.setStatusId(1);
        return project;
    }
}
