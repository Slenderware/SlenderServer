/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.crud;

import com.slender.app.factory.UserTaskFactory;
import com.slender.domain.UserTask;
import com.slender.service.crud.UserTaskCrud;
import com.slender.service.crud.impl.UserTaskCrudImpl;
import java.util.Date;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserTaskCrudTest {
    
    UserTaskCrud roleCrud = new UserTaskCrudImpl();
    
    public UserTaskCrudTest() {
    }
    
    @Test
    public void hello() {}
    
    @Test 
    public void persistTest(){
        UserTaskFactory rolesFactory = new UserTaskFactory();
        UserTask role = rolesFactory.getUserTask(0, 0);
        roleCrud.persist(role);
        Assert.assertNotNull(role);
    } 
    
    @Test(dependsOnMethods ="persistTest" )
    public void findAllTest(){
        List<UserTask> roles = roleCrud.findAll();
        Assert.assertNotNull(roles);
    }
    
    @Test(dependsOnMethods ="findAllTest" )
    public void findByIdTest(){
        List<UserTask> roles = roleCrud.findAll();
        UserTask role = roles.get(0);
        Assert.assertNotNull(roleCrud.findById(role.getId()));
    }
    
    @Test(dependsOnMethods ="findByIdTest" )
    public void countTest(){
        Assert.assertNotEquals(roleCrud.count(), 0);
    }
    
    @Test(dependsOnMethods ="countTest" )
    public void getByPropertyNameTest(){
        //Assert.assertNotNull(roleCrud.getByPropertyName("userId", 0));
    }
    
    @Test(dependsOnMethods ="getByPropertyNameTest" ) 
    public void getEntitiesByPropertyName(){
        Assert.assertNotNull(roleCrud.getEntitiesByProperName("userId", 0));
    }
    
    
    @Test(dependsOnMethods ="getEntitiesByPropertyName" )
    public void removeTest(){
        UserTask role = roleCrud.findAll().get(1);
        roleCrud.remove(role);
        roleCrud.persist(role);
        roleCrud.removeById(role.getId());
        Assert.assertNull(roleCrud.getByPropertyName("userId", -1));
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