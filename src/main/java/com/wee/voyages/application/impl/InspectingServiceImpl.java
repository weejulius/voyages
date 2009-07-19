package com.wee.voyages.application.impl;

import com.wee.voyages.domain.model.customer.Customer;
import com.wee.voyages.domain.model.customer.CustomerRepository;
import com.wee.voyages.domain.model.customer.CustomerLog;
import com.wee.voyages.domain.model.nationry.NationryRepository;
import com.wee.voyages.domain.model.voyage.VoyageRepository;
import com.wee.voyages.domain.model.voyage.Voyage;
import com.wee.voyages.domain.service.InspectingService;
import com.google.inject.Inject;

import java.util.List;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 9:26:03
 */

public class InspectingServiceImpl implements InspectingService {
    @Inject
    private CustomerRepository customerRepository;
    @Inject
    private NationryRepository nationryRepository;
    @Inject
    private VoyageRepository voyageRepository;

    public boolean isNationry(Customer customer) {
        return nationryRepository.find(customer.idcardNum()) != null;
    }

    public boolean isReembarking( Voyage voyage,Customer customer) {
        return voyageRepository.findCustomerLog(voyage,customer) != null;
    }

    public boolean isOldCustomer(Customer customer) {
        boolean result = false;
        List<CustomerLog> logs = voyageRepository.findCustomerLog(customer);
        if (logs.size() >= 1) {
            result = true;
        }
        return result;
    }
}
