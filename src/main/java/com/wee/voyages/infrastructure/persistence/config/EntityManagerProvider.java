package com.wee.voyages.infrastructure.persistence.config;

import com.google.inject.Provider;
import com.google.inject.Provides;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 15:10:43
 */

public class EntityManagerProvider implements Provider<EntityManagerBinder>{

    public EntityManagerBinder get() {
        return new EntityManagerBinder();
    }
}
