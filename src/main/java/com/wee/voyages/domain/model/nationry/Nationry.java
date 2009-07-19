package com.wee.voyages.domain.model.nationry;

import com.wee.voyages.domain.model.customer.IDCardNum;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Embedded;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 8:16:56
 */
@Entity
public class Nationry {
    @Id
    private long rybh;
    @Embedded
    private IDCardNum idcardNum;

}
