package com.wee.voyages.infrastructure.persistence.jpa;

import com.wee.voyages.application.validatation.Objects;
import com.wee.voyages.application.validatation.rule.NoSuchPersistentObject;
import com.wee.voyages.domain.model.customer.Customer;
import com.wee.voyages.domain.model.customer.CustomerLog;
import com.wee.voyages.domain.model.voyage.Ship;
import com.wee.voyages.domain.model.voyage.ShippingCompany;
import com.wee.voyages.domain.model.voyage.Voyage;
import com.wee.voyages.domain.model.voyage.VoyageRepository;

import java.util.List;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 21:25:10
 */
public class VoyageRepositoryImpl extends AbstractRepository implements VoyageRepository {
    public CustomerLog findCustomerLog(Voyage voyage, Customer customer) {
        return (CustomerLog) getSingleResult(createQuery(
                "select log from CustomerLog log where log.model =:model and log.voyage =:voyage"
        ).setParameter(1, customer).setParameter(2, voyage).getResultList(), "");
    }

    @SuppressWarnings("unchecked")
    public List<CustomerLog> findCustomerLog(Customer customer) {
        return createQuery(
                "select log from CustomerLog log where log.model =:model"
        ).setParameter(1, customer).getResultList();
    }

    public void store(Voyage voyage) {
        entityManager().persist(voyage);
    }

    public void update(Voyage voyage) {
        entityManager().merge(voyage);
    }

    public void storeCustomerLog(CustomerLog log) {
        entityManager().persist(log);
    }

    public void storeShip(Ship ship) {
        entityManager().persist(ship);
    }

    public void storeShippingCompany(ShippingCompany company) {
        entityManager().persist(company);
    }

    public Ship findShip(Long id) {
        return (Ship) returns(find(Ship.class, id), "there are no such voyage that id is " + id);
    }

    @SuppressWarnings(value = "unchecked")
    public List<Ship> listShip() {
        return createQuery(
                "select ship from Ship ship"
        ).getResultList();
    }

    @SuppressWarnings(value = "unchecked")
    public List<Voyage> list(int start,int end) {
        return (List<Voyage>) createQuery(
                "select voyage from Voyage voyage join fetch voyage.ship "
        ).setFirstResult(start).setMaxResults(end).getResultList();
    }

    public Number size() {
        return (Number)createQuery(
                "select count(voyage) from Voyage voyage"
        ).getSingleResult();
    }

    public Voyage find(Long voyageId) {
        return (Voyage) returns(find(Voyage.class, voyageId), "there are no such voyage that id is " + voyageId);
    }

    private Object returns(Object object, String message) {
        if (Objects.noSuch(object)) {
            throw new NoSuchPersistentObject(message);
        }
        return object;
    }

    private Object getSingleResult(List result, String message) {
        result = (List) returns(result, message);
        return result.get(0);
    }
}
