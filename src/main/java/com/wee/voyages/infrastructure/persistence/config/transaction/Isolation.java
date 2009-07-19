package com.wee.voyages.infrastructure.persistence.config.transaction;

/**
 * User: weejulius
 * Date: 2009-7-16
 * Time: 14:07:19
 */
public enum Isolation {
    READ_UNCOMMITTED,
    READ_COMMITTED,
    REPEATABLE_READ,
    SERIALIZABLE;
}
