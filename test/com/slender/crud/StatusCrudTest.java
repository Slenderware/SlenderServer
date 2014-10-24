/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.crud;

import com.slender.app.factory.StatusFactory;
import com.slender.domain.Status;
import com.slender.service.crud.StatusCrud;
import com.slender.service.crud.impl.StatusCrudImpl;
import java.util.Date;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StatusCrudTest {
    
    StatusCrud statusCrud = new StatusCrudImpl();
    
    public StatusCrudTest() {
    }
  
    @Test 
    public void persistTest(){
        StatusFactory statussFactory = new StatusFactory();
        Status status = statussFactory.getStatus("Test");
        statusCrud.persist(status);
        Assert.assertNotNull(status);
    } 
    
    @Test(dependsOnMethods ="persistTest") 
    public void findAllTest(){
        List<Status> statuss = statusCrud.findAll();
        Assert.assertNotNull(statuss);
    }
    
    @Test(dependsOnMethods ="findAllTest")
    public void findByIdTest(){
        List<Status> statuss = statusCrud.findAll();
        Status status = statuss.get(0);
        Assert.assertNotNull(statusCrud.findById(status.getId()));
    }
    
    @Test(dependsOnMethods ="findByIdTest")
    public void countTest(){
        Assert.assertNotEquals(statusCrud.count(), 0);
    }
    
    @Test(dependsOnMethods ="countTest")
    public void getByPropertyNameTest(){
        Assert.assertNotNull(statusCrud.getByPropertyName("status", "Test"));
    }
    
    @Test(dependsOnMethods ="getByPropertyNameTest") 
    public void getEntitiesByPropertyName(){
        Assert.assertNotNull(statusCrud.getEntitiesByProperName("status", "Test"));
    }
    
    @Test(dependsOnMethods ="getEntitiesByPropertyName")
    public void mergeTest(){
        Status status = statusCrud.getByPropertyName("status", "Test");
        status.setStatus("Tests");
        statusCrud.merge(status);
        Assert.assertNotNull(statusCrud.getByPropertyName("status", "Tests").getStatus());
    }
    
    @Test(dependsOnMethods ="mergeTest")
    public void removeTest(){
        Status status = statusCrud.getByPropertyName("status", "Tests");
        statusCrud.remove(status);
        statusCrud.persist(status);
        statusCrud.removeById(status.getId());
        Assert.assertNull(statusCrud.getByPropertyName("status", "Tests"));
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