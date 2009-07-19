package com.wee.voyages.domain.model.voyage;

import javax.persistence.*;
import java.util.Set;

/**
 * User: weejulius
 * Date: 2009-7-10
 * Time: 15:29:29
 */
@Entity
public class ShippingCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true,nullable = false)
    private String name;
    private String legalRepresentative;
    @OneToMany
    @JoinColumn(name = "SHIP_SHIPPINGCOMPANY_ID")
    private Set<Ship> ships;

    public ShippingCompany(String name, String legalRepresentative) {
        this.name = name;
        this.legalRepresentative = legalRepresentative;
    }

    public Set<Ship> ships() {
        return ships;
    }

    protected ShippingCompany() {
    }
}
