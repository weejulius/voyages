package com.wee.voyages.domain.model.inspecting;

import com.wee.voyages.domain.model.customer.Customer;
import com.wee.voyages.domain.shared.Rule;

/**
 * User: weejulius
 * Date: 2009-7-10
 * Time: 16:45:34
 */
public class CriminalRecordInspectingRule implements Rule<Customer> {
    public boolean validate(Customer customer) {
        return true;
    }
}
