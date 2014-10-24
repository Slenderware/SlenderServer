/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.crud;

import com.slender.app.factory.TaskFactory;
import com.slender.domain.Task;
import com.slender.service.crud.TaskCrud;
import com.slender.service.crud.impl.TaskCrudImpl;
import java.util.Date;
import java.util.List;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskCrudTest {
    
    TaskCrud taskCrud = new TaskCrudImpl();
    
    public TaskCrudTest() {
    }
    
    @Test 
    public void persistTest(){
        TaskFactory tasksFactory = new TaskFactory();
        Date d = new Date();
        Task task = tasksFactory.getTask(0, "Test", "Test", d, d, null, null, 5, 1);
        taskCrud.persist(task);
        Assert.assertNotNull(task);
    } 
    
    @Test(dependsOnMethods ="persistTest")  
    public void findAllTest(){
        List<Task> tasks = taskCrud.findAll();
        Assert.assertNotNull(tasks);
    }
    
    @Test(dependsOnMethods ="findAllTest") 
    public void findByIdTest(){
        List<Task> tasks = taskCrud.findAll();
        Task task = tasks.get(0);
        Assert.assertNotNull(taskCrud.findById(task.getId()));
    }
    
    @Test(dependsOnMethods ="findByIdTest") 
    public void countTest(){
        Assert.assertNotEquals(taskCrud.count(), 0);
    }
    
    @Test(dependsOnMethods ="countTest") 
    public void getByPropertyNameTest(){
        Assert.assertNotNull(taskCrud.getByPropertyName("taskName", "Test"));
    }
    
    @Test(dependsOnMethods ="getByPropertyNameTest")  
    public void getEntitiesByPropertyName(){
        Assert.assertNotNull(taskCrud.getEntitiesByProperName("taskName", "Test"));
        Assert.assertNotNull(taskCrud.getEntitiesByProperName("statusId", 1));
    }
    
    @Test(dependsOnMethods ="getEntitiesByPropertyName") 
    public void mergeTest(){
        Date d = new Date();
        Task task = taskCrud.getByPropertyName("taskName", "Test");
        task.setStartDate(d);
        taskCrud.merge(task);
        Assert.assertNotNull(taskCrud.getByPropertyName("taskName", "Test").getStartDate());
    }
    
    @Test(dependsOnMethods ="mergeTest") 
    public void removeTest(){
        Task task = taskCrud.getByPropertyName("taskName", "Test");
        taskCrud.remove(task);
        taskCrud.persist(task);
        taskCrud.removeById(task.getId());
        Assert.assertNull(taskCrud.getByPropertyName("taskName", "Test"));
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