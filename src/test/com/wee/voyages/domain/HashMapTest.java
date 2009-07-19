package com.wee.voyages.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * User: weejulius
 * Date: 2009-7-17
 * Time: 9:54:21
 */
public class HashMapTest {
    private Map littleMap = new HashMap();
    private Map bigMap = new HashMap();

    @Before
    public void startup() {
        littleMap.put("a", "a");
        for (int i = 0; i < 100000; i++) {
            bigMap.put(i, i);
        }
        bigMap.put("a", "a");
        for (int i = 100000; i < 200000; i++) {
            bigMap.put(i, i);
        }
    }

    @Test
    public void whichFast() {
        long headL = System.currentTimeMillis();
        littleMap.get("a");
        long afterL = System.currentTimeMillis();
        long headB=System.currentTimeMillis();
        bigMap.get("a");
        long afterB=System.currentTimeMillis();
        long br=afterB-headB;
        long lr=afterL-headL;
      //  Assert.assertTrue(br<lr);
        System.out.println("br(size:"+bigMap.size()+"):"+br+"   |   lr: "+lr);
    }
}
