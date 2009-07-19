package com.wee.voyages.application.impl;

import com.google.inject.Inject;
import com.wee.voyages.application.VoyageService;
import com.wee.voyages.domain.model.customer.Customer;
import com.wee.voyages.domain.model.customer.CustomerLog;
import com.wee.voyages.domain.model.voyage.Ship;
import com.wee.voyages.domain.model.voyage.Voyage;
import com.wee.voyages.domain.model.voyage.VoyageNum;
import com.wee.voyages.domain.model.voyage.VoyageRepository;
import com.wee.voyages.infrastructure.persistence.config.transaction.Transactional;

import java.util.Date;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 15:59:27
 */
public class VoyageServiceImpl implements VoyageService {
    @Inject
    private VoyageRepository voyageRepository;

    @Transactional
    public Voyage newVoyage(VoyageNum voyageNum, Ship ship) {
        Voyage voyage = new Voyage(voyageNum, ship);
        voyageRepository.store(voyage);
        return voyage;
    }

    @Transactional
    public void start(Voyage voyage) {
        voyage.start(new Date());
        voyageRepository.update(voyage);
    }

    @Transactional
    public void end(Voyage voyage) {
        voyage.end(new Date());
        voyageRepository.update(voyage);
    }

    @Transactional
    public void carry(Voyage voyage, Customer customer) {
        CustomerLog log = voyage.carry(customer);
        voyageRepository.storeCustomerLog(log);
    }
}
