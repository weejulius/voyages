package com.wee.voyages.domain.service;

import com.wee.voyages.domain.model.customer.Customer;
import com.wee.voyages.domain.model.voyage.Voyage;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 8:05:42
 */
public interface InspectingService {
    public boolean isNationry(Customer customer);

    public boolean isReembarking(Voyage voyage,Customer customer);

    public boolean isOldCustomer(Customer customer);
}
