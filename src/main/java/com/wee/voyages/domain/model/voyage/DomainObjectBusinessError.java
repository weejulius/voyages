package com.wee.voyages.domain.model.voyage;

/**
 * User: weejulius
 * Date: 2009-7-31
 * Time: 9:53:37
 */
public class DomainObjectBusinessError extends RuntimeException {
    public DomainObjectBusinessError(String message) {
        super(message);
    }
}
