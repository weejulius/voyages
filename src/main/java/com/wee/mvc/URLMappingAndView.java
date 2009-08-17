package com.wee.mvc;

import java.util.HashMap;
import java.util.Map;

/**
 * User: weejulius
 * Date: 2009-7-26
 * Time: 20:25:21
 */
public class URLMappingAndView {

    private Map<String, String> views = new HashMap<String, String>();
    private URLMapping urlMapping=new URLMapping();

    public URLMappingAndView() {

    }

    public URLMapping urlMapping() {
        return urlMapping;
    }


    public URLMappingAndView addView(String viewName, String target) {
        views.put(viewName, target);
        return this;
    }

    public Map<String, String> view() {
        return views;
    }

    public URLMappingAndView addURLMapping(String action,String url) {
        urlMapping.add(action,url);
        return this;
    }
}
