/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.crud;

import com.slender.app.factory.CompanyFactory;
import com.slender.domain.Company;
import com.slender.service.crud.CompanyCrud;
import com.slender.service.crud.impl.CompanyCrudImpl;
import java.util.Date;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompanyCrudTest {
    
    CompanyCrud companyCrud = new CompanyCrudImpl();
    
    public CompanyCrudTest() {
    }
    
    @Test 
    public void persistTest(){
        CompanyFactory companysFactory = new CompanyFactory();
        Company company = companysFactory.getCompany("Test", 0);
        companyCrud.persist(company);
        Assert.assertNotNull(company);
    } 
    
    @Test(dependsOnMethods ="persistTest") 
    public void findAllTest(){
        List<Company> companys = companyCrud.findAll();
        Assert.assertNotNull(companys);
    }
    
    @Test(dependsOnMethods ="findAllTest")
    public void findByIdTest(){
        List<Company> companys = companyCrud.findAll();
        Company company = companys.get(0);
        Assert.assertNotNull(companyCrud.findById(company.getId()));
    }
    
    @Test(dependsOnMethods ="findByIdTest")
    public void countTest(){
        Assert.assertNotEquals(companyCrud.count(), 0);
    }
    
    @Test(dependsOnMethods ="countTest")
    public void getByPropertyNameTest(){
        Assert.assertNotNull(companyCrud.getByPropertyName("companyName", "Test"));
    }
    
    @Test(dependsOnMethods ="getByPropertyNameTest") 
    public void getEntitiesByPropertyName(){
        Assert.assertNotNull(companyCrud.getEntitiesByProperName("companyName", "Test"));
        Assert.assertNotNull(companyCrud.getEntitiesByProperName("adminUser", 0));
    }
    
    @Test(dependsOnMethods ="getEntitiesByPropertyName")
    public void mergeTest(){
        Date d = new Date();
        Company company = companyCrud.getByPropertyName("companyName", "Test");
        company.setCreateDate(d);
        companyCrud.merge(company);
        Assert.assertNotNull(companyCrud.getByPropertyName("companyName", "Test").getCreateDate());
    }
    
    @Test(dependsOnMethods ="mergeTest")
    public void removeTest(){
        Company company = companyCrud.getByPropertyName("companyName", "Test");
        companyCrud.remove(company);
        companyCrud.persist(company);
        companyCrud.removeById(company.getId());
        Assert.assertNull(companyCrud.getByPropertyName("companyName", "Test"));
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