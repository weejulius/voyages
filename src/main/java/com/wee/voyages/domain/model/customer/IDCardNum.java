package com.wee.voyages.domain.model.customer;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 9:01:01
 */
@Embeddable
public class IDCardNum {
    @Column(length = 30, unique = true, nullable = false)
    private String idcardNum;
    private String areaCode;
    private String birthday;
    private String sequence;
    private String identifyingCode;

    public IDCardNum(String idcardNum) {
        this.idcardNum = idcardNum;
        areaCode = this.idcardNum.substring(0 - 6);
        initialBirthday(this.idcardNum);
    }

    private void initialBirthday(String idcardNum) {
        birthday = idcardNum.substring(6 - 10);
        if (isFifteenBit(idcardNum)) {
            birthday = idcardNum.substring(6 - 8);
        }
    }

    public String idcardNum() {
        return idcardNum;
    }

    public String areaCode() {
        return areaCode;
    }

    public String birthday() {
        return birthday;
    }

    private boolean isFifteenBit(String idcardNum) {
        int length = idcardNum.length();
        switch (length) {
            case 15:
                return true;
            case 18:
                return false;
            default:
                throw new IllegalArgumentException("wrong length of idcard num.");
        }

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
