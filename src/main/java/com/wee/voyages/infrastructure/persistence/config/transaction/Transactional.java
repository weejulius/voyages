package com.wee.voyages.infrastructure.persistence.config.transaction;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

/**
 * User: weejulius
 * Date: 2009-7-14
 * Time: 21:22:43
 */
@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.METHOD)
public @interface Transactional {
     Isolation isolation() default Isolation.REPEATABLE_READ;
     Propagation propagation() default Propagation.Required;
     long timeout() default -1;
     Class rollback() default Throwable.class;

}
