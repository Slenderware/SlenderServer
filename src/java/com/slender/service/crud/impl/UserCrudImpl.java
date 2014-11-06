/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.service.crud.impl;

import com.slender.domain.Users;
import com.slender.hibernate.HibernateUtil;
import com.slender.service.crud.UserCrud;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class UserCrudImpl implements UserCrud {
 
    private Session session;
    private Query query;

    @Override
    public Users findById(Integer id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Users user = (Users) session.get(Users.class, id);
        session.close();
        return user;
    }

    @Override
    public List<Users> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        query = session.createQuery("from Users");
        List<Users> users;
        users = query.list();
        return users;
    }

    @Override
    public Users persist(Users entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.flush();
        query = session.createSQLQuery("select last_insert_id() from Users");
        int id = Integer.parseInt(query.list().get(0).toString());
        session.getTransaction().commit();
        session.close();
        return findById(id);
    }

    @Override
    public void merge(Users entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void remove(Users entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeById(int entityId) {
        session = HibernateUtil.getSessionFactory().openSession();
        Users entity = new Users();
        entity.setId(entityId);
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public int count() {
        session = HibernateUtil.getSessionFactory().openSession();
        query = session.createQuery("from Users");
        List<Users> users = query.list();
        int count = users.size();
        return count;
    }

    @Override
    public Users getByPropertyName(String name, String value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Users.class);
        Users entity = (Users) criteria.add(Restrictions.eq(name, value)).uniqueResult();
        session.close();
        return entity;
    }
    
    @Override
    public Users getByPropertyName(String name, int value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Users.class);
        Users entity = (Users) criteria.add(Restrictions.eq(name, value)).uniqueResult();
        session.close();
        return entity;
    }

   
    @Override
    public List<Users> getEntitiesByProperName(String name, String value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Users.class);
        List<Users> entities = (List) criteria.add(Restrictions.eq(name, value)).list();
        session.close();
        return entities;
    }
    
    @Override
    public List<Users> getEntitiesByProperName(String name, int value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Users.class);
        List<Users> entities = (List) criteria.add(Restrictions.eq(name, value)).list();
        session.close();
        return entities;
    }
    
}
