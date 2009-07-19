package com.wee.voyages.domain.model.inspecting;

import com.wee.voyages.domain.shared.Rule;
import com.wee.voyages.domain.model.customer.Customer;

/**
 * User: weejulius
 * Date: 2009-7-10
 * Time: 16:40:11
 */
public class ReEmbarkingRule implements Rule<Customer> {

    public boolean validate(Customer customer) {
        return true;
    }
}
