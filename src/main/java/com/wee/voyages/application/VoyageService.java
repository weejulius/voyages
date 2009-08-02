package com.wee.voyages.application;

import com.wee.voyages.domain.model.customer.IDCardNum;
import com.wee.voyages.domain.model.voyage.Voyage;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 10:50:03
 */
public interface VoyageService {
    Voyage newVoyage(Long shipId);

    void start(Long voyageId);

    void end(Long voyageId);

    void carry(Long voyageId, IDCardNum idcardNum);
}
