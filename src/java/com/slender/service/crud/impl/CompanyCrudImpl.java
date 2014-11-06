/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.service.crud.impl;

import com.slender.domain.Company;
import com.slender.hibernate.HibernateUtil;
import com.slender.service.crud.CompanyCrud;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class CompanyCrudImpl implements CompanyCrud{
    private Session session;
    private Query query;

    @Override
    public Company findById(Integer id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Company company = (Company) session.get(Company.class, id);
        session.close();
        return company;
    }

    @Override
    public List<Company> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        query = session.createQuery("from Company");
        List<Company> companys;
        companys = query.list();
        return companys;
    }

    @Override
    public Company persist(Company entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.flush();
        query = session.createSQLQuery("select last_insert_id() from Company");
        int id = Integer.parseInt(query.list().get(0).toString());
        session.getTransaction().commit();
        session.close();
        return findById(id);
    }

    @Override
    public void merge(Company entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void remove(Company entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeById(int entityId) {
        session = HibernateUtil.getSessionFactory().openSession();
        Company entity = new Company();
        entity.setId(entityId);
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public int count() {
        session = HibernateUtil.getSessionFactory().openSession();
        query = session.createQuery("from Company");
        List<Company> companys = query.list();
        int count = companys.size();
        return count;
    }

    @Override
    public Company getByPropertyName(String name, String value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Company.class);
        Company entity = (Company) criteria.add(Restrictions.eq(name, value)).uniqueResult();
        session.close();
        return entity;
    }

    @Override
    public Company getByPropertyName(String name, int value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Company.class);
        Company entity = (Company) criteria.add(Restrictions.eq(name, value)).uniqueResult();
        session.close();
        return entity;
    }

    @Override
    public List<Company> getEntitiesByProperName(String name, String value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Company.class);
        List<Company> entities = (List) criteria.add(Restrictions.eq(name, value)).list();
        session.close();
        return entities;
    }

    @Override
    public List<Company> getEntitiesByProperName(String name, int value) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Company.class);
        List<Company> entities = (List) criteria.add(Restrictions.eq(name, value)).list();
        session.close();
        return entities;
    }
}
