/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.crud;

import com.slender.app.factory.UsersFactory;
import com.slender.domain.Users;
import com.slender.service.crud.UserCrud;
import com.slender.service.crud.impl.UserCrudImpl;
import java.util.Date;
import java.util.List;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserCrudTest {
    
    UserCrud userCrud = new UserCrudImpl();
    
    public UserCrudTest() {
    }

    @Test 
    public void persistTest(){
        UsersFactory usersFactory = new UsersFactory();
        Users user = usersFactory.getUsers("Boniface", "Kabaso","kabaso","kabaso@cput.co.za","boniface",2,1);
        userCrud.persist(user);
        Assert.assertNotNull(user);
    } 
    
    @Test(dependsOnMethods ="persistTest" ) 
    public void findAllTest(){
        List<Users> users = userCrud.findAll();
        Assert.assertNotNull(users);
    }
    
    @Test(dependsOnMethods ="findAllTest" )
    public void findByIdTest(){
        List<Users> users = userCrud.findAll();
        Users user = users.get(0);
        Assert.assertNotNull(userCrud.findById(user.getId()));
    }
    
    @Test(dependsOnMethods ="findByIdTest" )
    public void countTest(){
        Assert.assertNotEquals(userCrud.count(), 0);
    }
    
    @Test(dependsOnMethods ="countTest" )
    public void getByPropertyNameTest(){
        Assert.assertNotNull(userCrud.getByPropertyName("lastName", "Kabaso"));
        Assert.assertNotNull(userCrud.getByPropertyName("roleId", 2));
    }
    
    @Test(dependsOnMethods ="getByPropertyNameTest" ) 
    public void getEntitiesByPropertyName(){
        Assert.assertNotNull(userCrud.getEntitiesByProperName("firstName", "Boniface"));
        Assert.assertNotNull(userCrud.getEntitiesByProperName("roleId", 1));
    }
    
    @Test(dependsOnMethods ="getEntitiesByPropertyName" )
    public void mergeTest(){
        Date d = new Date();
        Users user = userCrud.getByPropertyName("firstName", "Boniface");
        user.setLastSeen(d);
        userCrud.merge(user);
        Assert.assertNotNull(userCrud.getByPropertyName("firstName", "Boniface").getLastSeen());
    }
    
    @Test(dependsOnMethods ="mergeTest" )
    public void removeTest(){
        Users user = userCrud.getByPropertyName("firstName", "Boniface");
        userCrud.remove(user);
        userCrud.persist(user);
        userCrud.removeById(user.getId());
        Assert.assertNull(userCrud.getByPropertyName("firstName", "Boniface"));
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