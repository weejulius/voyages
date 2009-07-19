package com.wee.voyages.domain.model.voyage;

import com.wee.voyages.domain.model.customer.Customer;
import com.wee.voyages.domain.model.customer.CustomerLog;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

/**
 * User: weejulius
 * Date: 2009-7-10
 * Time: 15:12:09
 */
@Entity
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @Embedded
    private VoyageNum voyageNum;
    @Enumerated
    private Status status;
    @OneToOne(fetch = FetchType.LAZY)
    private Ship ship;
    @Temporal(value = TemporalType.DATE)
    private Date leaveTime;
    @Temporal(value = TemporalType.DATE)
    private Date arriveTime;
    @OneToMany(mappedBy = "voyage")
    // @JoinColumn(name = "VOYAGE_CUSTOMERLOG_ID")
    private Set<CustomerLog> customerLogs=new HashSet<CustomerLog>();

    //singleton.
    //TODO
    @Transient
    private OverCarryRule overCarryRule = new OverCarryRule(1.20f);


    public Voyage(VoyageNum voyageNum,Ship ship) {
        this.voyageNum=voyageNum;
        this.status = Status.Init;
        this.ship = ship;

    }

    public void start(Date leaveTime) {
        if (status == Status.Init) {
            status = Status.Started;
            this.leaveTime = leaveTime;
        } else {
            throw new RuntimeException();
        }
    }

    public void end(Date arriveTime) {
        if (status == Status.Started) {
            status = Status.End;
            this.arriveTime = arriveTime;
        } else {
            throw new RuntimeException();
        }
    }

    public CustomerLog carry(Customer customer) {
        CustomerLog log = null;
        if (status == Status.Started && notOverCarry()) {
            log = new CustomerLog(new Date(), this, customer);
            customerLogs.add(log);
        } else {
            throw new RuntimeException();
        }
        return log;
    }

    private boolean notOverCarry() {
        return overCarryRule.validate(this);
    }

    public Ship ship() {
        return ship;
    }

    public Set<CustomerLog> customerLogs() {
        return customerLogs;
    }

    public VoyageNum voyageNum(){
        return voyageNum;
    }

    public Voyage() {
    }
}
