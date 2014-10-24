/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.crud;

import com.slender.app.factory.PriorityFactory;
import com.slender.domain.Priority;
import com.slender.service.crud.PriorityCrud;
import com.slender.service.crud.impl.PriorityCrudImpl;
import java.util.Date;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PriorityCrudTest {
    
    PriorityCrud priorityCrud = new PriorityCrudImpl();
    
    public PriorityCrudTest() {
    }
    
    @Test 
    public void persistTest(){
        PriorityFactory prioritysFactory = new PriorityFactory();
        Priority priority = prioritysFactory.getPriority("Test");
        priorityCrud.persist(priority);
        Assert.assertNotNull(priority);
    } 
    
    @Test(dependsOnMethods ="persistTest") 
    public void findAllTest(){
        List<Priority> prioritys = priorityCrud.findAll();
        Assert.assertNotNull(prioritys);
    }
    
    @Test(dependsOnMethods ="findAllTest")
    public void findByIdTest(){
        List<Priority> prioritys = priorityCrud.findAll();
        Priority priority = prioritys.get(0);
        Assert.assertNotNull(priorityCrud.findById(priority.getId()));
    }
    
    @Test(dependsOnMethods ="findByIdTest")
    public void countTest(){
        Assert.assertNotEquals(priorityCrud.count(), 0);
    }
    
    @Test(dependsOnMethods ="countTest")
    public void getByPropertyNameTest(){
        Assert.assertNotNull(priorityCrud.getByPropertyName("priority", "Test"));
    }
    
    @Test(dependsOnMethods ="getByPropertyNameTest") 
    public void getEntitiesByPropertyName(){
        Assert.assertNotNull(priorityCrud.getEntitiesByProperName("priority", "Test"));
    }
    
    @Test(dependsOnMethods ="getEntitiesByPropertyName")
    public void mergeTest(){
        Priority priority = priorityCrud.getByPropertyName("priority", "Test");
        priority.setPriority("Tests");
        priorityCrud.merge(priority);
        Assert.assertNotNull(priorityCrud.getByPropertyName("priority", "Tests").getPriority());
    }
    
    @Test(dependsOnMethods ="mergeTest")
    public void removeTest(){
        Priority priority = priorityCrud.getByPropertyName("priority", "Tests");
        priorityCrud.remove(priority);
        priorityCrud.persist(priority);
        priorityCrud.removeById(priority.getId());
        Assert.assertNull(priorityCrud.getByPropertyName("priority", "Tests"));
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