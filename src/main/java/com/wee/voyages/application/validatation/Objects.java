package com.wee.voyages.application.validatation;

import java.util.Collection;

/**
 * User: weejulius
 * Date: 2009-7-26
 * Time: 18:02:29
 */
public class Objects {
    public static <T> boolean noSuch(T obj) {
        if (null == obj) return true;
        if (obj instanceof Collection) {
            Collection collection = (Collection) obj;
            return collection.isEmpty();
        }
        return false;
    }

    public static <T> boolean existSuchA(T obj) {
       return !noSuch(obj);
    }

    public static <T> T failedInstance() {
        return null;
    }
}
