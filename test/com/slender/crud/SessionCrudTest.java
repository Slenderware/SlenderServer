/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.crud;

import com.slender.app.factory.SessionFactory;
import com.slender.domain.Session;
import com.slender.service.crud.SessionCrud;
import com.slender.service.crud.impl.SessionCrudImpl;
import java.util.Date;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SessionCrudTest {
    
    SessionCrudImpl sessCrud = new SessionCrudImpl();
    
    public SessionCrudTest() {
    }

    @Test 
    public void persistTest(){
        SessionFactory sessFactory = new SessionFactory();
        Session sess = sessFactory.getSession("Test",0);
        sessCrud.persist(sess);
        Assert.assertNotNull(sess);
    } 
    
    @Test(dependsOnMethods ="persistTest")  
    public void findAllTest(){
        List<Session> sess = sessCrud.findAll();
        Assert.assertNotNull(sess);
    }
    
    @Test(dependsOnMethods ="findAllTest" )
    public void findByIdTest(){
        Assert.assertNotNull(sessCrud.findById("Test"));
    }
    
    @Test(dependsOnMethods ="findByIdTest" )
    public void countTest(){
        Assert.assertNotEquals(sessCrud.count(), 0);
    }
    
    @Test(dependsOnMethods ="countTest" )
    public void getByPropertyNameTest(){
        Assert.assertNotNull(sessCrud.getByPropertyName("id", "Test"));
    }
    
    @Test(dependsOnMethods ="getByPropertyNameTest" ) 
    public void getEntitiesByPropertyName(){
        Assert.assertNotNull(sessCrud.getEntitiesByProperName("id", "Test"));
        Assert.assertNotNull(sessCrud.getEntitiesByProperName("userId", 0));
    }
    
    @Test(dependsOnMethods ="getEntitiesByPropertyName" )
    public void mergeTest(){
        Session sess = sessCrud.getByPropertyName("id", "Test");
        sessCrud.merge(sess);
        Assert.assertNotNull(sessCrud.getByPropertyName("id", "Test"));
    }
    
    @Test(dependsOnMethods ="mergeTest" )
    public void removeTest(){
        Session sess = sessCrud.getByPropertyName("id", "Test");
        sessCrud.remove(sess);
        sessCrud.persist(sess);
        sessCrud.removeById(sess.getId());
        Assert.assertNull(sessCrud.getByPropertyName("id", "Test"));
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