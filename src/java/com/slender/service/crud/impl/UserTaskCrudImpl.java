/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.service.crud.impl;

import com.slender.domain.UserTask;
import com.slender.hibernate.HibernateUtil;
import com.slender.service.crud.UserTaskCrud;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UserTaskCrudImpl implements UserTaskCrud{

    private Session session;
    private Query query;

    @Override
    public UserTask findById(Integer id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        UserTask task = (UserTask) session.get(UserTask.class, id);
        session.close();
        return task;
    }

    @Override
    public List<UserTask> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        query = session.createQuery("from UserTask");
        List<UserTask> tasks;
        tasks = query.list();
        return tasks;
    }

    @Override
    public UserTask persist(UserTask entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.flush();
        query = session.createSQLQuery("select last_insert_id() from jnct_user_task");
        int id = Integer.parseInt(query.list().get(0).toString());
        session.getTransaction().commit();
        session.close();
        return findById(id);
    }

    @Override
    public void merge(UserTask entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void remove(UserTask entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeById(int entityId) {
        session = HibernateUtil.getSessionFactory().openSession();
        UserTask entity = new UserTask();
        entity.setId(entityId);
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public int count() {
        session = HibernateUtil.getSessionFactory().openSession();
        query = session.createQuery("from UserTask");
        List<UserTask> tasks = query.list();
        int count = tasks.size();
        return count;
    }

    @Override
    public UserTask getByPropertyName(String name, String value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(UserTask.class);
        UserTask entity = (UserTask) criteria.add(Restrictions.eq(name, value)).uniqueResult();
        session.close();
        return entity;
    }

    @Override
    public UserTask getByPropertyName(String name, int value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(UserTask.class);
        UserTask entity = (UserTask) criteria.add(Restrictions.eq(name, value)).uniqueResult();
        session.close();
        return entity;
    }

    @Override
    public List<UserTask> getEntitiesByProperName(String name, String value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(UserTask.class);
        List<UserTask> entities = (List) criteria.add(Restrictions.eq(name, value)).list();
        session.close();
        return entities;
    }

    @Override
    public List<UserTask> getEntitiesByProperName(String name, int value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(UserTask.class);
        List<UserTask> entities = (List) criteria.add(Restrictions.eq(name, value)).list();
        session.close();
        return entities;
    }
    
}
