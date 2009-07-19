package com.wee.voyages.domain.model.customer;

import java.util.List;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 9:26:55
 */
public interface CustomerRepository {
     Customer find(IDCardNum idcardNum);
      void store(Customer customer);
}
