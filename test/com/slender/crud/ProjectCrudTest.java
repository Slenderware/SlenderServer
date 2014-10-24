/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.crud;

import com.slender.app.factory.ProjectFactory;
import com.slender.domain.Project;
import com.slender.service.crud.ProjectCrud;
import com.slender.service.crud.impl.ProjectCrudImpl;
import java.util.Date;
import java.util.List;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectCrudTest {
    
    ProjectCrud projectCrud = new ProjectCrudImpl();
    
    public ProjectCrudTest() {
    }
   
    @Test
    public void persistTest(){
        ProjectFactory projectsFactory = new ProjectFactory();
        Date d = new Date();
        Project project = projectsFactory.getProject(0, 0, "Test", "Test", d, null);
        projectCrud.persist(project);
        Assert.assertNotNull(project);
    } 
    
    @Test(dependsOnMethods ="persistTest") 
    public void findAllTest(){
        List<Project> projects = projectCrud.findAll();
        Assert.assertNotNull(projects);
    }
    
    @Test(dependsOnMethods ="findAllTest")
    public void findByIdTest(){
        List<Project> projects = projectCrud.findAll();
        Project project = projects.get(0);
        Assert.assertNotNull(projectCrud.findById(project.getId()));
    }
    
    @Test(dependsOnMethods ="findByIdTest")
    public void countTest(){
        Assert.assertNotEquals(projectCrud.count(), 0);
    }
    
    @Test(dependsOnMethods ="countTest")
    public void getByPropertyNameTest(){
        Assert.assertNotNull(projectCrud.getByPropertyName("projectName", "Test"));
    }
    
    @Test(dependsOnMethods ="getByPropertyNameTest") 
    public void getEntitiesByPropertyName(){
        Assert.assertNotNull(projectCrud.getEntitiesByProperName("projectName", "Test"));
        Assert.assertNotNull(projectCrud.getEntitiesByProperName("statusId", 1));
    }
    
    @Test(dependsOnMethods ="getEntitiesByPropertyName")
    public void mergeTest(){
        Date d = new Date();
        Project project = projectCrud.getByPropertyName("projectName", "Test");
        project.setEndDate(d);
        projectCrud.merge(project);
        Assert.assertNotNull(projectCrud.getByPropertyName("projectName", "Test").getEndDate());
    }
    
    @Test(dependsOnMethods ="mergeTest")
    public void removeTest(){
        Project project = projectCrud.getByPropertyName("projectName", "Test");
        projectCrud.remove(project);
        projectCrud.persist(project);
        projectCrud.removeById(project.getId());
        Assert.assertNull(projectCrud.getByPropertyName("projectName", "Test"));
    }
 
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}