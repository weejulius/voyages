package com.wee.voyages.domain.model.inspecting;

import com.wee.voyages.domain.model.customer.Customer;
import com.wee.voyages.domain.shared.Rule;

/**
 * User: weejulius
 * Date: 2009-7-12
 * Time: 20:22:43
 */
public class OldCustomerInspectingRule implements Rule<Customer> {
    public boolean validate(Customer customer) {
        return true;
    }
}
