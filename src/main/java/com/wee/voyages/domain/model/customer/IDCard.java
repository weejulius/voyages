package com.wee.voyages.domain.model.customer;

import javax.persistence.*;

/**
 * User: weejulius
 * Date: 2009-7-10
 * Time: 15:32:41
 */
@Embeddable
public class IDCard {
   /* private IDCardNum idcardNum;


    public IDCard(IDCardNum idcardNum, Sex sex, Date birthday, Date beginningDate, Date expirationDate,
                  String nativePlace, String PSBLocation, String residentialAddress) {
        validate();
        this.idcardNum = idcardNum;
        this.sex = sex;
        this.birthday = birthday;
        this.beginningDate = beginningDate;
        this.expirationDate = expirationDate;
        this.nativePlace = nativePlace;
        this.PSBLocation = PSBLocation;
        this.residentialAddress = residentialAddress;
    }

    private void validate(){}

    public IDCardNum idcardNum(){
        return idcardNum;
    }

    public IDCard(){}

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }*/
}
