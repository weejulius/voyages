package com.wee.mvc;

import com.wee.voyages.application.validatation.Objects;
import com.wee.voyages.application.validatation.Strings;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * User: weejulius
 * Date: 2009-7-31
 * Time: 15:55:28
 */

public class URLMapping {
    private Map<String, String> actions = new HashMap<String, String>();
    private Logger log= LoggerFactory.getLogger(this.getClass());

    public URLMapping() {

    }

    public void parseRequestURI(ReqAndResp reqAndResp) {
        String[] actionAndParameter = regexsCompile(reqAndResp);
        log.debug("after parse url: {}",actionAndParameter);
        putParsedAction(reqAndResp, actionAndParameter);
    }

    private void putParsedAction(ReqAndResp reqAndResp, String... strings) {
        reqAndResp.putNotEmptyValueParameter("action", strings[0]);
        reqAndResp.putNotEmptyValueParameter("id", strings[1]);
    }

    private String[] regexsCompile(ReqAndResp reqAndResp) {
        String url = url(reqAndResp);
        for (Map.Entry<String, String> action : actions.entrySet()) {
            String method = action.getKey();
            String regex = action.getValue();
            String result = compileRegex(regex, url);
            if (Objects.existSuchA(result)) {
                String[] actionAndParameter = new String[2];
                actionAndParameter[0] = method;
                actionAndParameter[1] = result;
                return actionAndParameter;
            }
        }
        throw new InvalidRequestURI(url + " is not a valid request url.");
    }

    private String url(ReqAndResp reqAndResp) {
        HttpServletRequest request = reqAndResp.request();
        return pathInfo(request) + queryString(reqAndResp);
    }

    private String pathInfo(HttpServletRequest request) {
        return Strings.nullToBlank(request.getPathInfo());
    }

    private String queryString(ReqAndResp reqAndResp) {
        String queryString = reqAndResp.request().getQueryString();
        return Objects.existSuchA(queryString) ? "?" + queryString : "";
    }

    private String compileRegex(String regex, String url) {
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()&&url.equals(matcher.group(0))) {
            log.debug("url :{} matched regex is {}",url,regex);
            return matcher.groupCount()>=1?matcher.group(1):"";
        }
        return Objects.failedInstance();
    }


    public void add(String action, String url) {
        actions.put(action, url);
    }
}
