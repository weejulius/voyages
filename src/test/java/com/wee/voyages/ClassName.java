package com.wee.voyages;

import org.junit.Test;
import org.junit.Assert;

/**
 * User: weejulius
 * Date: 2009-7-26
 * Time: 22:47:23
 */
public class ClassName {
    @Test
    public void getClassName(){
        String a="new bee";
        Assert.assertEquals(a.getClass().getName(),className(a));
        System.out.println(a.getClass().getName()+":"+className(a));

    }

    public String className(Object obj){
        return obj.getClass().getName();
    }
}
