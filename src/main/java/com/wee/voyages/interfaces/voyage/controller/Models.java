package com.wee.voyages.interfaces.voyage.controller;

/**
 * User: weejulius
 * Date: 2009-7-27
 * Time: 19:46:37
 */
public class Models {

    public static Model add(Object obj){
          return new Model(obj);
    }

    public static Model add(String name,Object obj){
          return new Model(name,obj);
    }
}
