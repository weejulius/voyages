package com.wee.voyages.domain.model.voyage;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * User: weejulius
 * Date: 2009-7-15
 * Time: 13:23:33
 */
@Embeddable
public class VoyageNum {
    @Column(name = "VOYAGE_NUM", nullable = false, unique = true)
    private String num;

    public VoyageNum(String num) {

        this.num = num;
    }

    //TODO
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null && obj instanceof VoyageNum) {
            VoyageNum other = (VoyageNum) obj;
            result = voyageNum().equals(other.voyageNum());
        }
        return result;
    }

    public String voyageNum() {
        return num;
    }

    protected VoyageNum() {
    }


}
