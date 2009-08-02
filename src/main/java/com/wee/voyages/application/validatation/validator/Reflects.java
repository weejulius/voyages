package com.wee.voyages.application.validatation.validator;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * User: weejulius
 * Date: 2009-7-27
 * Time: 16:17:20
 */
public class Reflects {
    public static <T> Object fieldValue(T entity, String fieldName)
            throws NoSuchFieldException, IllegalAccessException {
        Field field = entity.getClass().getField(fieldName);
        return field.get(entity);
    }

    public static void invokeMethod(Object obj, String action, Object arg)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = obj.getClass().getMethod(action, arg.getClass());
        method.invoke(obj, arg);
    }
}
