/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.service.crud.impl;

import com.slender.domain.UserProject;
import com.slender.hibernate.HibernateUtil;
import com.slender.service.crud.UserProjectCrud;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UserProjectCrudImpl implements UserProjectCrud{

    private Session session;
    private Query query;

    @Override
    public UserProject findById(Integer id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        UserProject task = (UserProject) session.get(UserProject.class, id);
        session.close();
        return task;
    }

    @Override
    public List<UserProject> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        query = session.createQuery("from UserProject");
        List<UserProject> tasks;
        tasks = query.list();
        return tasks;
    }

    @Override
    public UserProject persist(UserProject entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.flush();
        query = session.createSQLQuery("select last_insert_id() from jnct_user_project");
        int id = Integer.parseInt(query.list().get(0).toString());
        session.getTransaction().commit();
        session.close();
        return findById(id);
    }

    @Override
    public void merge(UserProject entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void remove(UserProject entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeById(int entityId) {
        session = HibernateUtil.getSessionFactory().openSession();
        UserProject entity = new UserProject();
        entity.setId(entityId);
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public int count() {
        session = HibernateUtil.getSessionFactory().openSession();
        query = session.createQuery("from UserProject");
        List<UserProject> tasks = query.list();
        int count = tasks.size();
        return count;
    }

    @Override
    public UserProject getByPropertyName(String name, String value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(UserProject.class);
        UserProject entity = (UserProject) criteria.add(Restrictions.eq(name, value)).uniqueResult();
        session.close();
        return entity;
    }

    @Override
    public UserProject getByPropertyName(String name, int value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(UserProject.class);
        UserProject entity = (UserProject) criteria.add(Restrictions.eq(name, value)).uniqueResult();
        session.close();
        return entity;
    }

    @Override
    public List<UserProject> getEntitiesByProperName(String name, String value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(UserProject.class);
        List<UserProject> entities = (List) criteria.add(Restrictions.eq(name, value)).list();
        session.close();
        return entities;
    }

    @Override
    public List<UserProject> getEntitiesByProperName(String name, int value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(UserProject.class);
        List<UserProject> entities = (List) criteria.add(Restrictions.eq(name, value)).list();
        session.close();
        return entities;
    }
    
}
