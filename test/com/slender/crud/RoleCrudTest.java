/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.crud;

import com.slender.app.factory.RoleFactory;
import com.slender.domain.Role;
import com.slender.service.crud.RoleCrud;
import com.slender.service.crud.impl.RoleCrudImpl;
import java.util.Date;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RoleCrudTest {
    
    RoleCrud roleCrud = new RoleCrudImpl();
    
    public RoleCrudTest() {
    }
  
    @Test 
    public void persistTest(){
        RoleFactory rolesFactory = new RoleFactory();
        Role role = rolesFactory.getRole("Test");
        roleCrud.persist(role);
        Assert.assertNotNull(role);
    } 
    
    @Test(dependsOnMethods ="persistTest") 
    public void findAllTest(){
        List<Role> roles = roleCrud.findAll();
        Assert.assertNotNull(roles);
    }
    
    @Test(dependsOnMethods ="findAllTest")
    public void findByIdTest(){
        List<Role> roles = roleCrud.findAll();
        Role role = roles.get(0);
        Assert.assertNotNull(roleCrud.findById(role.getId()));
    }
    
    @Test(dependsOnMethods ="findByIdTest")
    public void countTest(){
        Assert.assertNotEquals(roleCrud.count(), 0);
    }
    
    @Test(dependsOnMethods ="countTest")
    public void getByPropertyNameTest(){
        Assert.assertNotNull(roleCrud.getByPropertyName("role", "Test"));
    }
    
    @Test(dependsOnMethods ="getByPropertyNameTest") 
    public void getEntitiesByPropertyName(){
        Assert.assertNotNull(roleCrud.getEntitiesByProperName("role", "Test"));
    }
    
    @Test(dependsOnMethods ="getEntitiesByPropertyName")
    public void mergeTest(){
        Role role = roleCrud.getByPropertyName("role", "Test");
        role.setRole("Tests");
        roleCrud.merge(role);
        Assert.assertNotNull(roleCrud.getByPropertyName("role", "Tests").getRole());
    }
    
    @Test(dependsOnMethods ="mergeTest")
    public void removeTest(){
        Role role = roleCrud.getByPropertyName("role", "Tests");
        roleCrud.remove(role);
        roleCrud.persist(role);
        roleCrud.removeById(role.getId());
        Assert.assertNull(roleCrud.getByPropertyName("role", "Tests"));
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