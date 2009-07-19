package com.wee.voyages.infrastructure.persistence.config;

import javax.persistence.*;

/**
 * User: weejulius
 * Date: 2009-7-16
 * Time: 13:40:11
 */
public class EntityManagerBinder {
    private final static EntityManagerFactory ef = Persistence.createEntityManagerFactory("voyages");
    private final static ThreadLocal<EntityManager> emThreadLocal = new ThreadLocal<EntityManager>();

    public EntityManager entityManager() {
        EntityManager em = emThreadLocal.get();
        if (em == null || !em.isOpen()) {
            em = ef.createEntityManager();
            emThreadLocal.set(em);
        }
        return em;
    }

    public EntityTransaction transaction() {
        return entityManager().getTransaction();
    }

    public void rollback() {
        if (transaction().isActive())
            transaction().rollback();
    }

    public void closeEntityManager() {
        EntityManager em = emThreadLocal.get();
        emThreadLocal.set(null);
        if (em != null) {
            em.close();
        }
    }

    public void begin() {
        beginTransaction();
    }

    public void close() {
        commitTransaction();
        closeEntityManager();
    }

    public void beginTransaction() {
        if (!transaction().isActive())
            transaction().begin();
    }

    public void commitTransaction() {
        transaction().commit();
    }

    public Query createQuery(String query) {
        return entityManager().createQuery(query);
    }

   
}
