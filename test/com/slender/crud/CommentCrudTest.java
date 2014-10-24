/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.crud;

import com.slender.app.factory.CommentFactory;
import com.slender.domain.Comment;
import com.slender.service.crud.CommentCrud;
import com.slender.service.crud.impl.CommentCrudImpl;
import java.util.Date;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CommentCrudTest {
    
    CommentCrud commentCrud = new CommentCrudImpl();
    
    public CommentCrudTest() {
    }

    @Test
    public void persistTest(){
        CommentFactory commentsFactory = new CommentFactory();
        Comment comment = commentsFactory.getComment("Test", 0, -1, 0);
        commentCrud.persist(comment);
        Assert.assertNotNull(comment);
    } 
    
    @Test(dependsOnMethods ="persistTest")  
    public void findAllTest(){
        List<Comment> comments = commentCrud.findAll();
        Assert.assertNotNull(comments);
    }
    
    @Test(dependsOnMethods ="findAllTest") 
    public void findByIdTest(){
        List<Comment> comments = commentCrud.findAll();
        Comment comment = comments.get(0);
        Assert.assertNotNull(commentCrud.findById(comment.getId()));
    }
    
    @Test(dependsOnMethods ="findByIdTest") 
    public void countTest(){
        Assert.assertNotEquals(commentCrud.count(), 0);
    }
    
    @Test(dependsOnMethods ="countTest") 
    public void getByPropertyNameTest(){
        Assert.assertNotNull(commentCrud.getByPropertyName("comment", "Test"));
    }
    
    @Test(dependsOnMethods ="getByPropertyNameTest") 
    public void getEntitiesByPropertyName(){
        Assert.assertNotNull(commentCrud.getEntitiesByProperName("comment", "Test"));
        Assert.assertNotNull(commentCrud.getEntitiesByProperName("userId", 0));
    }
    
    @Test(dependsOnMethods ="getEntitiesByPropertyName") 
    public void mergeTest(){
        Date d = new Date();
        Comment comment = commentCrud.getByPropertyName("comment", "Test");
        comment.setCreateDate(d);
        commentCrud.merge(comment);
        Assert.assertNotNull(commentCrud.getByPropertyName("comment", "Test").getCreateDate());
    }
    
    @Test(dependsOnMethods ="mergeTest") 
    public void removeTest(){
        Comment comment = commentCrud.getByPropertyName("comment", "Test");
        commentCrud.remove(comment);
        commentCrud.persist(comment);
        commentCrud.removeById(comment.getId());
        Assert.assertNull(commentCrud.getByPropertyName("comment", "Test"));
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