package com.militeev.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.militeev.entity.AbstractEntity;

public abstract class AbstractDAO<T extends AbstractEntity> {

    private Class<T> clazz;
    
    protected AbstractDAO(Class<T> clazz) {
        this.clazz = clazz;
    }
    
    @PersistenceContext
    protected EntityManager entityManager;

    public final void setClazz(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(final long id) {
        return entityManager.find(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    public T create(final T entity) {
        return entityManager.merge(entity);
    }

    public T update(final T entity) {
        return entityManager.merge(entity);
    }

    public void delete(final T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        delete(entity);
    }
    
    public void flush() {
        entityManager.flush();
    }
    
    public void beginTransaction() {
        entityManager.getTransaction().begin();
    }
    
    public void commitTransaction() {
        entityManager.getTransaction().commit();
    }
    
}