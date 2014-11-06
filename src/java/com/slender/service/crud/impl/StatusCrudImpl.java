/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.service.crud.impl;

import com.slender.domain.Status;
import com.slender.hibernate.HibernateUtil;
import com.slender.service.crud.StatusCrud;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class StatusCrudImpl implements StatusCrud{
    private Session session;
    private Query query;

    @Override
    public Status findById(Integer id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Status status = (Status) session.get(Status.class, id);
        session.close();
        return status;
    }

    @Override
    public List<Status> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        query = session.createQuery("from Status");
        List<Status> statuss;
        statuss = query.list();
        return statuss;
    }

     @Override
    public Status persist(Status entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.flush();
        query = session.createSQLQuery("select last_insert_id() from Status");
        int id = Integer.parseInt(query.list().get(0).toString());
        session.getTransaction().commit();
        session.close();
        return findById(id);
    }

    @Override
    public void merge(Status entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void remove(Status entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeById(int entityId) {
        session = HibernateUtil.getSessionFactory().openSession();
        Status entity = new Status();
        entity.setId(entityId);
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public int count() {
        session = HibernateUtil.getSessionFactory().openSession();
        query = session.createQuery("from Status");
        List<Status> statuss = query.list();
        int count = statuss.size();
        return count;
    }

    @Override
    public Status getByPropertyName(String name, String value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Status.class);
        Status entity = (Status) criteria.add(Restrictions.eq(name, value)).uniqueResult();
        session.close();
        return entity;
    }

    @Override
    public Status getByPropertyName(String name, int value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Status.class);
        Status entity = (Status) criteria.add(Restrictions.eq(name, value)).uniqueResult();
        session.close();
        return entity;
    }

    @Override
    public List<Status> getEntitiesByProperName(String name, String value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Status.class);
        List<Status> entities = (List) criteria.add(Restrictions.eq(name, value)).list();
        session.close();
        return entities;
    }

    @Override
    public List<Status> getEntitiesByProperName(String name, int value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Status.class);
        List<Status> entities = (List) criteria.add(Restrictions.eq(name, value)).list();
        session.close();
        return entities;
    }
}
