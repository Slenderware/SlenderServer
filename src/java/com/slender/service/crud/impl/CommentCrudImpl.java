/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.service.crud.impl;

import com.slender.domain.Comment;
import com.slender.domain.Comment;
import com.slender.hibernate.HibernateUtil;
import com.slender.service.crud.CommentCrud;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class CommentCrudImpl implements CommentCrud{

    private Session session;
    private Query query;

    @Override
    public Comment findById(Integer id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Comment comment = (Comment) session.get(Comment.class, id);
        session.close();
        return comment;
    }

    @Override
    public List<Comment> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        query = session.createQuery("from Comment");
        List<Comment> comments;
        comments = query.list();
        return comments;
    }

    @Override
    public Comment persist(Comment entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.flush();
        query = session.createSQLQuery("select last_insert_id() from Comments");
        int id = Integer.parseInt(query.list().get(0).toString());
        session.getTransaction().commit();
        session.close();
        return findById(id);
    }

    @Override
    public void merge(Comment entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void remove(Comment entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeById(int entityId) {
        session = HibernateUtil.getSessionFactory().openSession();
        Comment entity = new Comment();
        entity.setId(entityId);
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public int count() {
        session = HibernateUtil.getSessionFactory().openSession();
        query = session.createQuery("from Comment");
        List<Comment> comments = query.list();
        int count = comments.size();
        return count;
    }

    @Override
    public Comment getByPropertyName(String name, String value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Comment.class);
        Comment entity = (Comment) criteria.add(Restrictions.eq(name, value)).uniqueResult();
        session.close();
        return entity;
    }

    @Override
    public Comment getByPropertyName(String name, int value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Comment.class);
        Comment entity = (Comment) criteria.add(Restrictions.eq(name, value)).uniqueResult();
        session.close();
        return entity;
    }

    @Override
    public List<Comment> getEntitiesByProperName(String name, String value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Comment.class);
        List<Comment> entities = (List) criteria.add(Restrictions.eq(name, value)).list();
        session.close();
        return entities;
    }

    @Override
    public List<Comment> getEntitiesByProperName(String name, int value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Comment.class);
        List<Comment> entities = (List) criteria.add(Restrictions.eq(name, value)).list();
        session.close();
        return entities;
    }
}
