package com.wee.voyages.domain.model.inspecting;

import com.wee.voyages.domain.model.customer.Customer;
import com.wee.voyages.domain.shared.Rule;

import java.util.List;

/**
 * User: weejulius
 * Date: 2009-7-10
 * Time: 15:33:23
 */
public interface Inspecting {
      public boolean inspect(List<Rule> rules, Customer customer);
}
