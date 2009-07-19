package com.wee.voyages.infrastructure.persistence.jpa;

import com.wee.voyages.domain.model.customer.Customer;
import com.wee.voyages.domain.model.customer.CustomerLog;
import com.wee.voyages.domain.model.voyage.*;

import java.util.List;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 21:25:10
 */
public class VoyageRepositoryImpl extends AbstractRepository implements VoyageRepository {
    public CustomerLog findCustomerLog(Voyage voyage, Customer customer) {
        CustomerLog log = (CustomerLog) createQuery(
                "select log from CustomerLog log where log.customer =:customer and log.voyage =:voyage"
        ).setParameter(1, customer).setParameter(2, voyage).getSingleResult();
       // closeEntityManager();
        return log;
    }

    public List<CustomerLog> findCustomerLog(Customer customer) {
        List<CustomerLog> logs = createQuery(
                "select log from CustomerLog log where log.customer =:customer"
        ).setParameter(1, customer).getResultList();
     //   closeEntityManager();
        return logs;
    }

    public void store(Voyage voyage) {
       // beginTransaction();
        entityManager().persist(voyage);
     //   commitTransaction();
     //   closeEntityManager();
    }

    public void update(Voyage voyage) {
       //   beginTransaction();
        entityManager().merge(voyage);
     //   commitTransaction();
       // closeEntityManager();
    }

    public void storeCustomerLog(CustomerLog log) {
        //beginTransaction();
        entityManager().persist(log);
       // commitTransaction();
       // closeEntityManager();
    }

    public void storeShip(Ship ship) {
      //  beginTransaction();
        entityManager().persist(ship);
      //  commitTransaction();
       // closeEntityManager();
    }

    public void storeShippingCompany(ShippingCompany company) {
       // beginTransaction();
        entityManager().persist(company);
      //  commitTransaction();
      //  closeEntityManager();
    }

    public Ship findShip(String name) {
        Ship ship=(Ship)createQuery(
                "select ship from Ship ship where ship.name=:name"
        ).setParameter("name",name).getSingleResult();
      //  closeEntityManager();
        return ship;
    }

    public Voyage find(VoyageNum voyageNum) {
        Voyage voyage=(Voyage)createQuery(
                "select voyage from Voyage voyage where voyage.voyageNum=:voyageNum"
        ).setParameter("voyageNum",voyageNum).getSingleResult();
       // closeEntityManager();
        return voyage;
    }
}
