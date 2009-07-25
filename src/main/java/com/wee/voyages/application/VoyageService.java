package com.wee.voyages.application;

import com.wee.voyages.domain.model.voyage.Voyage;
import com.wee.voyages.domain.model.voyage.Ship;
import com.wee.voyages.domain.model.voyage.VoyageNum;
import com.wee.voyages.domain.model.customer.Customer;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 10:50:03
 */
public interface VoyageService {
     Voyage newVoyage(VoyageNum voyageNum,Ship ship);
     void start(Voyage voyage);
     void end(Voyage voyage);
     void carry(Voyage voyage,Customer customer);
}
