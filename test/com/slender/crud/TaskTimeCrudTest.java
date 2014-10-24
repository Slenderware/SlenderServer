/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.crud;

import com.slender.app.factory.TaskTimeFactory;
import com.slender.domain.TaskTime;
import com.slender.service.crud.TaskTimeCrud;
import com.slender.service.crud.impl.TaskTimeCrudImpl;
import java.util.Date;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskTimeCrudTest {
    
    TaskTimeCrud taskTimeCrud = new TaskTimeCrudImpl();
    
    public TaskTimeCrudTest() {
    }
    
    @Test 
    public void persistTest(){
        TaskTimeFactory taskTimesFactory = new TaskTimeFactory();
        Date d = new Date();
        TaskTime taskTime = taskTimesFactory.getTaskTime(0, 0, d, 0);
        taskTimeCrud.persist(taskTime);
        Assert.assertNotNull(taskTime);
    } 
    
    @Test(dependsOnMethods ="persistTest")
    public void findAllTest(){
        List<TaskTime> taskTimes = taskTimeCrud.findAll();
        Assert.assertNotNull(taskTimes);
    }
    
    @Test(dependsOnMethods ="findAllTest")
    public void findByIdTest(){
        List<TaskTime> taskTimes = taskTimeCrud.findAll();
        TaskTime taskTime = taskTimes.get(0);
        Assert.assertNotNull(taskTimeCrud.findById(taskTime.getId()));
    }
    
    @Test(dependsOnMethods ="findByIdTest")
    public void countTest(){
        Assert.assertNotEquals(taskTimeCrud.count(), 0);
    }
    
    
    @Test(dependsOnMethods ="countTest")
    public void mergeTest(){
        Date d = new Date();
        TaskTime taskTime = taskTimeCrud.findAll().get(1);
        taskTime.setTimeSpent(4);
        taskTimeCrud.merge(taskTime);
        Assert.assertNotNull(taskTimeCrud.findAll().get(1).getTimeSpent());
    }
    
    @Test(dependsOnMethods ="mergeTest")
    public void removeTest(){
        TaskTime taskTime = taskTimeCrud.findAll().get(1);
        taskTimeCrud.remove(taskTime);
        taskTimeCrud.persist(taskTime);
        taskTimeCrud.removeById(taskTime.getId());
        Assert.assertNull(taskTimeCrud.getByPropertyName("timeSpent", 4));
    }
    
    @Test
    public void getByPropertyNameTest(){
    }
    
    @Test 
    public void getEntitiesByPropertyName(){
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