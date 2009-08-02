package com.wee.voyages.domain.model.voyage;

import javax.persistence.*;
import java.util.Set;

/**
 * User: weejulius
 * Date: 2009-7-10
 * Time: 15:26:33
 */
@Entity
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true,nullable = false)
    private String name;
    private int capacity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SHIPPINGCOMPANY_ID")
    private ShippingCompany company;
   

    public Ship(int capacity,String name, ShippingCompany company) {
        this.capacity = capacity;
        this.company = company;
        this.name=name;
    }


    public int capacity() {
        return capacity;
    }

    public String name(){
        return name;
    }

    public String id(){
        return ""+id;
    }

    protected Ship() {
    }


}
