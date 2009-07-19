package com.wee.voyages.infrastructure.persistence.config.transaction;

/**
 * User: weejulius
 * Date: 2009-7-16
 * Time: 14:10:21
 */
public enum Propagation {
    Required,
    Mandatory,
    RequiresNew,
    Supports,
    NotSupported,
    Never;


}
