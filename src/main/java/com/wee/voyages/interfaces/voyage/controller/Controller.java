package com.wee.voyages.interfaces.voyage.controller;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.wee.voyages.infrastructure.persistence.config.EntityManagerBinder;
import com.wee.voyages.infrastructure.persistence.config.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * User: weejulius
 * Date: 2009-7-27
 * Time: 21:06:22
 */

public class Controller extends HttpServlet {

    @Inject
    private EntityManagerBinder binder;
    private Logger log = LoggerFactory.getLogger(this.getClass());
    private Map<String, String> views;
    private URLMapping urlMapping;

    public void initView() {
        URLMappingAndView URLMappingAndView = Views.view(this.getClass());
        views = URLMappingAndView.view();
        urlMapping = URLMappingAndView.urlMapping();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        Injector injector = (Injector) getServletContext().getAttribute(Injector.class.getName());
        injector.injectMembers(this);
        initView();
        startup();
    }

    protected void startup(){

    }

    protected String view(String viewName) {
        return views.get(viewName);
    }

    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        ReqAndResp reqAndResp = new ReqAndResp(httpServletRequest, httpServletResponse);
        try {
            reqAndResp.parseRequestURI(urlMapping);
            handleRequest(reqAndResp);
        } catch (InvalidRequestURI e) {
            log.warn("invalid request rui {}",e.getMessage());
            forwardExceptionView(reqAndResp, e, "serviceerror");
        }
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        doGet(httpServletRequest, httpServletResponse);
    }

    @Transactional
    protected void handleRequest(ReqAndResp reqAndResp)
            throws IOException, ServletException {
        try {
            reqAndResp.executeAction(this, reqAndResp);
        } catch (InvocationTargetException e) {
            log.warn("execute action exception: {}", e.getCause().getStackTrace());
            forwardExceptionView(reqAndResp, e.getCause(), "serviceerror");
        } catch (NoSuchMethodException e) {
            forwardExceptionView(reqAndResp, e, "service unavaliable");
        } catch (IllegalAccessException e) {
            forwardExceptionView(reqAndResp, e, "service unavaliable");
        }
    }

    private void forwardExceptionView(ReqAndResp reqAndResp, Throwable exception, String view) throws IOException, ServletException {
        Controllers.load(reqAndResp, "exception", exception).abortAndgoTo(view(view));
    }

    public EntityManagerBinder transaction() {
        return binder;
    }

    public Logger log() {
        return log;
    }

}

