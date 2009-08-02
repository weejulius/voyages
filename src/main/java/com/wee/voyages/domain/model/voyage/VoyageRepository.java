package com.wee.voyages.domain.model.voyage;

import com.wee.voyages.domain.model.customer.Customer;
import com.wee.voyages.domain.model.customer.CustomerLog;

import java.util.List;

/**
 * User: weejulius
 * Date: 2009-7-10
 * Time: 15:17:50
 */
public interface VoyageRepository {

    CustomerLog findCustomerLog(Voyage voyage, Customer customer);

    List<CustomerLog> findCustomerLog(Customer customer);

    void store(Voyage voyage);

    void update(Voyage voyage);

    void storeCustomerLog(CustomerLog log);

    void storeShip(Ship ship);

    void storeShippingCompany(ShippingCompany company);

    Ship findShip(Long id);

    List<Ship> listShip();

    Voyage find(Long voyageId);

    public List<Voyage> list(int start, int end);

    Number size();
}
