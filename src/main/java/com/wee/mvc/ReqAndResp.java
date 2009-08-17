package com.wee.mvc;

import com.wee.voyages.application.validatation.Objects;
import com.wee.voyages.application.validatation.Strings;
import com.wee.voyages.application.validatation.rule.InvalidRequestParameter;
import com.wee.voyages.application.validatation.rule.Throws;
import com.wee.voyages.application.validatation.validator.Reflects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * User: weejulius
 * Date: 2009-7-26
 * Time: 20:26:06
 */

//kill of null parameter.
public class ReqAndResp {
    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;
    private Map<String, String[]> params = new HashMap<String, String[]>();
    private Logger log = LoggerFactory.getLogger(this.getClass());


    public ReqAndResp(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        this.httpServletRequest = httpServletRequest;
        this.httpServletResponse = httpServletResponse;
        initial();
    }

    public HttpServletRequest request() {
        return httpServletRequest;
    }

    public HttpServletResponse response() {
        return httpServletResponse;
    }

    @SuppressWarnings(value = "unchecked")
    private void initial() {
        params.putAll(httpServletRequest.getParameterMap());
    }

    public Map<String, String[]> params() {
        return params;
    }

    public String get(String param) {
        String[] values = params.get(param);
        if (Objects.noSuch(values)) {
            Throws.noSuchRequestParameter("no such request parameter that is " + param);
        }
        return values[0];
    }


    public void parseRequestURI(URLMapping urlMapping) {
        urlMapping.parseRequestURI(this);
    }


    public void executeAction(Object obj, ReqAndResp reqAndResp)
            throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        String action = get("action");
        Reflects.invokeMethod(obj, action, reqAndResp);

    }

    public long getLong(String param) {
        String value = get(param);
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new InvalidRequestParameter("param " + param + " ,the value <" + value + "> is not a long format");
        }
    }

    public void putNotEmptyValueParameter(String key, String value) {
        if (Strings.notBlank(value)) {
            params.put(key, Strings.asArray(value));
        }
    }


    public int getInt(String param) {
        String value = get(param);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new InvalidRequestParameter("param " + param + " ,the value <" + value + "> is not a long format");
        }
    }
}
