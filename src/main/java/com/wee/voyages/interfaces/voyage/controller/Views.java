package com.wee.voyages.interfaces.voyage.controller;

import com.wee.voyages.application.validatation.Objects;

import java.util.HashMap;
import java.util.Map;

/**
 * User: weejulius
 * Date: 2009-7-26
 * Time: 20:27:42
 */
public class Views {
    private final static Map<Class, URLMappingAndView> viewsMap = new HashMap<Class, URLMappingAndView>();

    static {
        initial();
    }

    public static URLMappingAndView view(Class clazz) {
        URLMappingAndView views = viewsMap.get(clazz);
        if (Objects.noSuch(views)) {
            return Objects.failedInstance();
        }
        return views;
    }
    /*"create:/voyages/new",
                        "list:/voyages/page/{id}",
                        "start:/voyages/{id}/start",
                        "end:/voyages/{id}/end",
                        "index:/voyages/{id}"*/

    private static void initial() {
        registry(VoyageController.class,
                new URLMappingAndView()
                        .addURLMapping("create","/new")
                        .addURLMapping("list","/page/(\\d+)")
                        .addURLMapping("start","/(\\d+)/start")
                        .addURLMapping("end","/(\\d+)/end")
                        .addURLMapping("index","/(\\d+)")
                        .addView("origin", "voyages/voyages.ftl")
                        .addView("new", "voyages/new.ftl")
                        .addView("index", "voyages/index.ftl")
                        .addView("NoSuchObject", "exception/nosuchobject.ftl")
                        .addView("ParameterException", "exception/parametererror.ftl")
                        .addView("BrokenRuleException", "exception/brokenrule.ftl")
                        .addView("serviceerror", "exception/serviceerror.ftl"));

    }

    private static void registry(Class controller, URLMappingAndView URLMappingAndView) {
        viewsMap.put(controller, URLMappingAndView);
    }


}
