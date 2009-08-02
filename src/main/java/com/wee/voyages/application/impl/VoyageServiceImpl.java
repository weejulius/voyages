package com.wee.voyages.application.impl;

import com.google.inject.Inject;
import com.wee.voyages.application.VoyageService;
import com.wee.voyages.application.validatation.Objects;
import com.wee.voyages.application.validatation.rule.Throws;
import com.wee.voyages.domain.model.customer.Customer;
import com.wee.voyages.domain.model.customer.CustomerLog;
import com.wee.voyages.domain.model.customer.CustomerRepository;
import com.wee.voyages.domain.model.customer.IDCardNum;
import com.wee.voyages.domain.model.voyage.Ship;
import com.wee.voyages.domain.model.voyage.Voyage;
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
    @Inject
    private CustomerRepository customerRepository;

    @Transactional
    public Voyage newVoyage(Long shipId) {
        Ship ship = voyageRepository.findShip(shipId);
        if(Objects.noSuch(ship)){
            Throws.noSuchPersistentObject("can not find ship by id when new a voyage.");
        }
        Voyage voyage = new Voyage(ship);
        voyageRepository.store(voyage);
        return voyage;
    }

    @Transactional
    public void start(Long voyageId) {
        Voyage voyage = findVoyageByNum(voyageId);
        voyage.start(new Date());
        voyageRepository.update(voyage);
    }

    @Transactional
    public void end(Long voyageId) {
        Voyage voyage = findVoyageByNum(voyageId);
        voyage.end(new Date());
        voyageRepository.update(voyage);


    }

    private Voyage findVoyageByNum(Long voyageId) {
        return voyageRepository.find(voyageId);
    }


    @Transactional
    public void carry(Long voyageId, IDCardNum idcardNum) {
        Voyage voyage = findVoyageByNum(voyageId);
        Customer customer = findCustomerByIDCardNum(idcardNum);

        CustomerLog log = voyage.carry(customer);
        voyageRepository.storeCustomerLog(log);
    }

    private Customer findCustomerByIDCardNum(IDCardNum idcardNum) {
        return customerRepository.find(idcardNum);
    }
}
