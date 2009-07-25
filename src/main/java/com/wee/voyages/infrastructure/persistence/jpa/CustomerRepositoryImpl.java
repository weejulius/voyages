package com.wee.voyages.infrastructure.persistence.jpa;

import com.wee.voyages.domain.model.customer.Customer;
import com.wee.voyages.domain.model.customer.CustomerRepository;
import com.wee.voyages.domain.model.customer.IDCardNum;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 10:20:03
 */
public class CustomerRepositoryImpl extends AbstractRepository implements CustomerRepository {
    public Customer find(IDCardNum idcardNum) {
        Customer customer = (Customer)
                createQuery(
                        "select model from Customer model where model.idcardNum =:idcardNum")
                        .setParameter("idcardNum", idcardNum).getSingleResult();
       // closeEntityManager();
        return customer;
    }

    public void store(Customer customer) {
       // beginTransaction();
        entityManager().persist(customer);
       // commitTransaction();
       // closeEntityManager();
    }
}
