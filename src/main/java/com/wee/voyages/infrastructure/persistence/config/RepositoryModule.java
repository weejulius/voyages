package com.wee.voyages.infrastructure.persistence.config;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.wee.voyages.domain.model.customer.CustomerRepository;
import com.wee.voyages.domain.model.nationry.NationryRepository;
import com.wee.voyages.domain.model.voyage.VoyageRepository;
import com.wee.voyages.infrastructure.persistence.jpa.CustomerRepositoryImpl;
import com.wee.voyages.infrastructure.persistence.jpa.NationryRepositoryImpl;
import com.wee.voyages.infrastructure.persistence.jpa.VoyageRepositoryImpl;
import com.wee.voyages.infrastructure.persistence.config.EntityManagerBinder;
import com.wee.voyages.infrastructure.persistence.config.transaction.Transactional;
import com.wee.voyages.infrastructure.persistence.config.transaction.TransactionMethodInterceptor;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 22:12:45
 */
public class RepositoryModule extends AbstractModule {
    @Override
    protected void configure() {

        bind(EntityManagerBinder.class);//.toInstance(new EntityManagerBinder());
        TransactionMethodInterceptor transactionMethodInterceptor= new TransactionMethodInterceptor();
        requestInjection(transactionMethodInterceptor);
        bindInterceptor(Matchers.any(),Matchers.annotatedWith(Transactional.class),transactionMethodInterceptor);
        bind(CustomerRepository.class).to(CustomerRepositoryImpl.class);
        bind(VoyageRepository.class).to(VoyageRepositoryImpl.class);
        bind(NationryRepository.class).to(NationryRepositoryImpl.class);
    }
}
