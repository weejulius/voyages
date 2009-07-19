package com.wee.voyages.infrastructure.persistence.jpa;

import com.google.inject.Inject;
import com.wee.voyages.infrastructure.persistence.config.EntityManagerBinder;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 10:22:41
 */
public class AbstractRepository {
    @Inject
    private EntityManagerBinder emb;

    public EntityManager entityManager() {
        return emb.entityManager();
    }

    public void closeEntityManager() {
        emb.closeEntityManager();
    }

    public void beginTransaction() {
        emb.beginTransaction();
    }

    public void commitTransaction() {
        emb.commitTransaction();
    }

    public Query createQuery(String query) {
        return emb.createQuery(query);
    }

}