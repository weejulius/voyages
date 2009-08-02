package com.wee.voyages.domain.model.voyage;

import com.wee.voyages.domain.model.customer.IDCardNum;
import com.wee.voyages.domain.model.customer.Customer;
import com.wee.voyages.domain.model.customer.CustomerLog;

import java.util.List;

/**
 * User: weejulius
 * Date: 2009-7-10
 * Time: 15:17:50
 */
public interface VoyageRepository {

    public CustomerLog findCustomerLog(Voyage voyage,Customer customer);

    public List<CustomerLog> findCustomerLog(Customer customer);

    public void store(Voyage voyage);

    public void update(Voyage voyage);

    public void storeCustomerLog(CustomerLog log);

    public void storeShip(Ship ship);

    public void storeShippingCompany(ShippingCompany company);

    public Ship findShip(Long id);

    public List<Ship> listShip();

    public Voyage find(Long voyageId);

    public List<Voyage> list();
}
