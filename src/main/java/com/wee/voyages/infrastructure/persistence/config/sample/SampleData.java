package com.wee.voyages.infrastructure.persistence.config.sample;

import com.google.inject.Inject;
import com.wee.voyages.domain.model.voyage.Ship;
import com.wee.voyages.domain.model.voyage.ShippingCompany;
import com.wee.voyages.infrastructure.persistence.config.EntityManagerBinder;

import java.util.ArrayList;
import java.util.List;

/**
 * User: weejulius
 * Date: 2009-7-15
 * Time: 12:05:36
 */
public class SampleData {
    private List<Ship> ships = new ArrayList<Ship>();
    private List<ShippingCompany> companys = new ArrayList<ShippingCompany>();    
    private EntityManagerBinder binder=new EntityManagerBinder();

    private void initialShippingComanys() {
        companys.add(new ShippingCompany("Zoerm", "yoouu"));
        companys.add(new ShippingCompany("KaSeil", "Bomeo"));
        companys.add(new ShippingCompany("Jeeei", "sophera"));
        companys.add(new ShippingCompany("Sujeen", "jozzn"));
    }

    private void initialShips() {
        ships.add(new Ship(100, "Tenicsam", companys.get(2)));
        ships.add(new Ship(200, "Ghoist", companys.get(2)));
        ships.add(new Ship(3, "Seewt", companys.get(1)));
        ships.add(new Ship(2, "Boanrr", companys.get(3)));
        ships.add(new Ship(1, "Zoddow", companys.get(0)));
        ships.add(new Ship(403, "Reock", companys.get(0)));
    }

    public void startup() {
        binder.begin();
        initialShippingComanys();
        initialShips();
        for (ShippingCompany company : companys) {
            binder.entityManager().persist(company);
        }
        for (Ship ship : ships) {
            binder.entityManager().persist(ship);
        }
        binder.close();
    }
}
