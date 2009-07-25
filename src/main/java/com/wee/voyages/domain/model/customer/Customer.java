package com.wee.voyages.domain.model.customer;

import com.wee.voyages.domain.model.voyage.Voyage;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * User: weejulius
 * Date: 2009-7-10
 * Time: 15:30:54
 */
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Embedded
    private IDCardNum idcardNum;
    @Enumerated
    private Sex sex;
    @Temporal(value = TemporalType.DATE)
    private Date birthday;
    @Temporal(value = TemporalType.DATE)
    private Date beginningDate;
    @Temporal(value = TemporalType.DATE)
    private Date expirationDate;
    private String nativePlace;
    private String PSBString;//public security Bureau
    private String residentialAddress;
    @OneToMany(mappedBy = "customer")
  //  @JoinColumn(name = "CUSTOMER_CUSTOMERLOG_ID")
    private Set<CustomerLog> customerLogs=new HashSet<CustomerLog>();

    public Customer(IDCardNum idcardNum, Sex sex,
                    Date birthday, Date beginningDate, Date expirationDate,
                    String nativePlace, String PSBString, String residentialAddress) {

        this.idcardNum = idcardNum;
        this.sex = sex;
        this.birthday = birthday;
        this.beginningDate = beginningDate;
        this.expirationDate = expirationDate;
        this.nativePlace = nativePlace;
        this.PSBString = PSBString;
        this.residentialAddress = residentialAddress;
    }

    private void validate() {

    }

    public void embark(Voyage voyage, Date embarkingDate) {
        customerLogs.add(new CustomerLog(embarkingDate, voyage, this));
        voyage.carry(this);
    }


    public Set<CustomerLog> customerLogs() {
        return customerLogs;
    }

    public IDCardNum idcardNum(){
        return idcardNum;
    }

    protected Customer() {
    }
}
