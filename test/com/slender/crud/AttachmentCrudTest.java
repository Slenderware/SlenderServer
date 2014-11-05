/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.crud;

import com.slender.app.factory.AttachmentFactory;
import com.slender.domain.Attachment;
import com.slender.service.crud.AttachmentCrud;
import com.slender.service.crud.impl.AttachmentCrudImpl;
import java.util.Date;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AttachmentCrudTest {
    
    AttachmentCrud attachmentCrud = new AttachmentCrudImpl();
    
    public AttachmentCrudTest() {
    }

    @Test 
    public void persistTest(){
        AttachmentFactory attachmentsFactory = new AttachmentFactory();
        Attachment attachment = attachmentsFactory.getAttachment("Test", "Test", null, 0, 0);
        attachmentCrud.persist(attachment);
        Assert.assertNotNull(attachment);
    } 
    
    @Test(dependsOnMethods ="persistTest")  
    public void findAllTest(){
        List<Attachment> attachments = attachmentCrud.findAll();
        Assert.assertNotNull(attachments);
    }
    
    @Test(dependsOnMethods ="findAllTest" )
    public void findByIdTest(){
        List<Attachment> attachments = attachmentCrud.findAll();
        Attachment attachment = attachments.get(0);
        Assert.assertNotNull(attachmentCrud.findById(attachment.getId()));
    }
    
    @Test(dependsOnMethods ="findByIdTest" )
    public void countTest(){
        Assert.assertNotEquals(attachmentCrud.count(), 0);
    }
    
    @Test(dependsOnMethods ="countTest" )
    public void getByPropertyNameTest(){
        Assert.assertNotNull(attachmentCrud.getByPropertyName("attachmentName", "Test"));
    }
    
    @Test(dependsOnMethods ="getByPropertyNameTest" ) 
    public void getEntitiesByPropertyName(){
        Assert.assertNotNull(attachmentCrud.getEntitiesByProperName("attachmentName", "Test"));
        Assert.assertNotNull(attachmentCrud.getEntitiesByProperName("userId", 1));
    }
    
    @Test(dependsOnMethods ="getEntitiesByPropertyName" )
    public void mergeTest(){
        Date d = new Date();
        Attachment attachment = attachmentCrud.getByPropertyName("attachmentName", "Test");
        attachment.setCreateDate(d);
        attachmentCrud.merge(attachment);
        Assert.assertNotNull(attachmentCrud.getByPropertyName("attachmentName", "Test").getCreateDate());
    }
    
    @Test(dependsOnMethods ="mergeTest" )
    public void removeTest(){
        Attachment attachment = attachmentCrud.getByPropertyName("attachmentName", "Test");
        attachmentCrud.remove(attachment);
        attachmentCrud.persist(attachment);
        attachmentCrud.removeById(attachment.getId());
        Assert.assertNull(attachmentCrud.getByPropertyName("attachmentName", "Test"));
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