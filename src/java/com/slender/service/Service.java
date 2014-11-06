
package com.slender.service;

import java.util.List;

public interface Service <T, ID>{
    public T findById(final ID id);

    public List<T> findAll();

    public T persist(final T entity);

    public void merge(final T entity);

    public void remove(final T entity);

    public void removeById(final int entityId);

    public int count();

    public T getByPropertyName(String name, String value);
    
    public T getByPropertyName(String name, int value);

    public List<T> getEntitiesByProperName(String name, String value);
    
    public List<T> getEntitiesByProperName(String name, int value);
}
