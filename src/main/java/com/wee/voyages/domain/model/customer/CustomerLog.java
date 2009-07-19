package com.wee.voyages.domain.model.customer;

import com.wee.voyages.domain.model.voyage.Voyage;

import javax.persistence.*;
import java.util.Date;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 11:55:46
 */
@Entity
public class CustomerLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Temporal(value = TemporalType.DATE)
    private Date embarkingDate;
    @ManyToOne
   // @JoinColumn(name="VOYAGE_CUSTOMERLOG_ID",nullable = false,
    //updatable = false,insertable = false)
    private Voyage voyage;
    @ManyToOne
   // @JoinColumn(name="CUSTOMER_CUSTOMERLOG_ID",nullable = false,
  //          updatable = false,insertable = false
   // )
    private Customer customer;

    public CustomerLog(Date embarkingDate, Voyage voyage,Customer customer) {
        this.embarkingDate = embarkingDate;
        this.voyage = voyage;
        this.customer=customer;
    }

    public CustomerLog(){}
}
