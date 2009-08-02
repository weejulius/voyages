package com.wee.voyages.interfaces.voyage.controller;

import com.wee.voyages.application.validatation.Strings;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: weejulius
 * Date: 2009-7-27
 * Time: 19:54:03
 */
public class MVC {
    private Model model;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private Logger log = LoggerFactory.getLogger(this.getClass());


    public MVC(ReqAndResp reqAndResp, Model model) {
        this.model = model;
        request = reqAndResp.request();
        response = reqAndResp.response();
    }

    public void redirect(String view) throws IOException, ServletException {
        installModelToSession();
        response.sendRedirect(view);
    }

    public void forward(String view) throws IOException, ServletException {
        installModelToRequest();
        if (Strings.nullOrBlank(view)) {
            view = "exception/404.ftl";
        }
        log.debug("view is {}",view);
        request.getRequestDispatcher("/" + view).forward(request, response);
    }

    private void installModelToSession(){
        Map<String, Object> models = model.models();
        for (Map.Entry<String, Object> attrs : models.entrySet()) {
            request.getSession(true).setAttribute(attrs.getKey(), attrs.getValue());
        }
    }
    private void installModelToRequest() {
        Map<String, Object> models = model.models();
        for (Map.Entry<String, Object> attrs : models.entrySet()) {
            request.setAttribute(attrs.getKey(), attrs.getValue());
        }
    }

    public void abortAndgoTo(String view) throws IOException, ServletException {
        log.debug("view is {}",view);
        forward(view);
    }

    public void goTo404() throws IOException, ServletException {
        forward("exception/404.ftl");
    }
}
