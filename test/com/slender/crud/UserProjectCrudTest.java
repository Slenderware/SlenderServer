/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.crud;

import com.slender.app.factory.UserProjectFactory;
import com.slender.domain.UserProject;
import com.slender.service.crud.UserProjectCrud;
import com.slender.service.crud.impl.UserProjectCrudImpl;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserProjectCrudTest {
    
    UserProjectCrud roleCrud = new UserProjectCrudImpl();
    
    public UserProjectCrudTest() {
    }
    
    @Test
    public void persistTest(){
        UserProjectFactory rolesFactory = new UserProjectFactory();
        UserProject role = rolesFactory.getUserProject(0, 0);
        roleCrud.persist(role);
        Assert.assertNotNull(role);
    } 
    
    @Test(dependsOnMethods ="persistTest") 
    public void findAllTest(){
        List<UserProject> roles = roleCrud.findAll();
        Assert.assertNotNull(roles);
    }
    
    @Test(dependsOnMethods ="findAllTest")
    public void findByIdTest(){
        List<UserProject> roles = roleCrud.findAll();
        UserProject role = roles.get(0);
        Assert.assertNotNull(roleCrud.findById(role.getId()));
    }
    
    @Test(dependsOnMethods ="findByIdTest")
    public void countTest(){
        Assert.assertNotEquals(roleCrud.count(), 0);
    }
    
    @Test(dependsOnMethods ="countTest")
    public void getByPropertyNameTest(){
    }
    
    @Test(dependsOnMethods ="getByPropertyNameTest") 
    public void getEntitiesByPropertyName(){
        Assert.assertNotNull(roleCrud.getEntitiesByProperName("userId", 0));
    }
    
    @Test(dependsOnMethods ="getEntitiesByPropertyName")
    public void removeTest(){
        UserProject role = roleCrud.findAll().get(1);
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