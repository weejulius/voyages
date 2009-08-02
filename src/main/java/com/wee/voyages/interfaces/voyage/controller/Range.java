package com.wee.voyages.interfaces.voyage.controller;

/**
 * User: weejulius
 * Date: Aug 2, 2009
 * Time: 9:02:03 PM
 */
public class Range {
    private int start;
    private int end;

    public Range(int i, int i1) {
        start = i;
        end = i1;
    }

    public int start() {
        return start;
    }

    public int end() {
        return end;
    }
}
