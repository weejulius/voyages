package com.wee.voyages.domain.model.customer;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 9:01:01
 */
@Embeddable
public class IDCardNum {    
    @Column(length = 30, unique = true, nullable = false)
    private String idcardNum;

    public IDCardNum(String idcardNum) {
        this.idcardNum = idcardNum;
    }

    public String idcardNum() {
        return idcardNum;
    }

    //TODO 
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null && obj instanceof IDCardNum) {
            IDCardNum other = (IDCardNum) obj;
            result = idcardNum().equals(other.idcardNum());
        }
        return result;
    }

    public IDCardNum() {
    }
}
