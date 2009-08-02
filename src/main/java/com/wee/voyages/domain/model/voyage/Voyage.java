package com.wee.voyages.domain.model.voyage;

import com.wee.voyages.domain.model.customer.Customer;
import com.wee.voyages.domain.model.customer.CustomerLog;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User: weejulius
 * Date: 2009-7-10
 * Time: 15:12:09
 */
@Entity
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Enumerated
    private Status status;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "SHIP_ID")
    private Ship ship;
    @Temporal(value = TemporalType.DATE)
    private Date leaveTime;
    @Temporal(value = TemporalType.DATE)
    private Date arriveTime;
    @OneToMany(mappedBy = "voyage")
    private Set<CustomerLog> customerLogs = new HashSet<CustomerLog>();

    //singleton.
    //TODO
    @Transient
    private OverCarryRule overCarryRule = new OverCarryRule(1.20f);


    public Voyage(Ship ship) {
        this.status = Status.Init;
        this.ship = ship;

    }

    public void start(Date leaveTime) {
        if (status == Status.Init) {
            status = Status.Started;
            this.leaveTime = leaveTime;
        } else {
            throw new DomainObjectBusinessError("voyage can not start due to it is not init status");
        }
    }

    public void end(Date arriveTime) {
        if (status == Status.Started) {
            status = Status.End;
            this.arriveTime = arriveTime;
        } else {
            throw new DomainObjectBusinessError("voyage can not end due to voyage has been ended or unstarted.");
        }
    }

    public CustomerLog carry(Customer customer) {
        CustomerLog log;
        if (status == Status.Started && notOverCarry()) {
            log = new CustomerLog(new Date(), this, customer);
            customerLogs.add(log);
        } else {
            throw new DomainObjectBusinessError("can not carry customer before start voyage.");
        }
        return log;
    }

    public String id() {
        return "" + id;
    }

    private boolean notOverCarry() {
        return overCarryRule.validate(this);
    }

    public Ship ship() {
        return ship;
    }

    public Status status() {
        return status;
    }

    public Set<CustomerLog> customerLogs() {
        return customerLogs;
    }

    protected Voyage() {
    }
}
