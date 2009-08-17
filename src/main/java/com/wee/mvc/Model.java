package com.wee.mvc;

import java.util.HashMap;
import java.util.Map;

/**
 * User: weejulius
 * Date: 2009-7-26
 * Time: 21:37:43
 */
public class Model {
    private Map<String, Object> models = new HashMap<String, Object>();

    public Model() {
    }

    public Model(Object obj) {
        add(obj);
    }

    public Model(String name, Object obj) {
        add(name, obj);
    }

    public Map<String, Object> models() {
        return models;
    }

    public Model add(Object obj) {
        add(obj.getClass().getName(), obj);
        return this;
    }

    public Model add(String key, Object value) {
        models.put(key, value);
        return this;
    }
}
