package com.wee.voyages.infrastructure.persistence.jpa;

import com.wee.voyages.domain.model.nationry.NationryRepository;
import com.wee.voyages.domain.model.nationry.Nationry;
import com.wee.voyages.domain.model.customer.IDCardNum;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 21:57:00
 */
public class NationryRepositoryImpl extends AbstractRepository implements NationryRepository{
    public Nationry find(IDCardNum idcardNum) {
        return (Nationry)createQuery(
                "select nationry from Nationry nationry where nationry.idcardNum =:idcardNum"
        ).setParameter(1,idcardNum).getSingleResult();
    }
}
