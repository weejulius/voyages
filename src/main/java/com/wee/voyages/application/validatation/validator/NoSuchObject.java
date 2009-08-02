package com.wee.voyages.application.validatation.validator;

import com.wee.voyages.domain.model.voyage.Voyage;
import com.wee.voyages.domain.model.voyage.VoyageNum;

/**
 * User: weejulius
 * Date: 2009-7-26
 * Time: 18:39:03
 */
public class NoSuchObject extends RuntimeException {
    public NoSuchObject(String message) {   
    }
}
