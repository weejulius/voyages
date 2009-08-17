package com.wee.mvc;

import com.wee.voyages.application.validatation.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class ActionInstaller {
    private final URLMapping urlMapping;
    private final static String ACTION_KEY = "action";
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public ActionInstaller(URLMapping urlMapping) {
        this.urlMapping = urlMapping;
    }

    

    private void indexOrNew(ReqAndResp reqAndResp, String str) {
        if (Strings.isInt(str)) {
            putAction(reqAndResp, "index");
            putParameter(reqAndResp, "id", str);
        } else {
            putAction(reqAndResp, "create");
        }
    }

    private void putParameter(ReqAndResp reqAndResp, String key, String value) {
        reqAndResp.putNotEmptyValueParameter(key, value);
    }

    private void putAction(ReqAndResp reqAndResp, String action) {
        putParameter(reqAndResp, ACTION_KEY, action);
    }

    private void installAction(ReqAndResp reqAndResp, Set<String> set) {
        int length = set.size();
        String[] els = new String[length];
        els = set.toArray(els);
        log.debug("action els length is {}, and is {}", length, els);
        switchAction(reqAndResp, length, els);
    }

    private void switchAction(ReqAndResp reqAndResp, int length, String[] els) {
        switch (length) {
            case 0:
                putAction(reqAndResp, "list");
                break;
            case 1:
                indexOrNew(reqAndResp, els[0]);
                break;
            case 2:
                update(reqAndResp, els);
                break;
        }
    }

    private void update(ReqAndResp reqAndResp, String... els) {
        for (String el : els) {
            if (Strings.isInt(el)) {
                putParameter(reqAndResp, "id", el);
            } else {
                putAction(reqAndResp, el);
            }
        }
    }

    private String actionURL(ReqAndResp reqAndResp) {
        String pathInfo = reqAndResp.request().getPathInfo();
        String queryString = reqAndResp.request().getQueryString();
        return Strings.nullToBlank(pathInfo) + Strings.nullToBlank(queryString);
    }
}