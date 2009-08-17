package com.wee.mvc;

import com.wee.voyages.application.validatation.Strings;

import java.util.Map;

public class URLWrapper {
    private final ReqAndResp reqAndResp;
   // private final ActionInstaller actionInstaller = new ActionInstaller(this);

    public URLWrapper(ReqAndResp reqAndResp) {
        this.reqAndResp = reqAndResp;
    }

    public void parseRequestURI(URLPattern urlPattern) {
        //actionInstaller.parseRequestURI(urlPattern);
    }



    private void newParams(String newParam, String queryString) {
        Map<String, String[]> params = reqAndResp.params();
        boolean noQueryString = Strings.nullOrBlank(queryString);
        if (Strings.nullOrBlank(newParam) && noQueryString) {
            params.put("action", Strings.asArray("list"));
        } else if (Strings.isInt(newParam)) {
            params.put("id", Strings.asArray(newParam));
            if (noQueryString) {
                params.put("action", Strings.asArray("index"));
            }
        } else if ("new".equals(newParam)) {
            params.put("action", Strings.asArray("create"));
        }
    }

}