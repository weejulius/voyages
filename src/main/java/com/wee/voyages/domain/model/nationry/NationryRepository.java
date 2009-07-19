package com.wee.voyages.domain.model.nationry;

import com.wee.voyages.domain.model.customer.IDCardNum;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 9:35:23
 */
public interface NationryRepository {
    Nationry find(IDCardNum idcardNum);
}
