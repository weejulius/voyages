package com.wee.voyages.interfaces.config;

import com.google.inject.Singleton;
import freemarker.ext.servlet.FreemarkerServlet;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: weejulius
 * Date: 2009-7-29
 * Time: 12:03:13
 */
@Singleton
public class CFreemarkerServlet extends FreemarkerServlet {
    private final String BASE_PATH = "base";


    private String getBasePath(HttpServletRequest request) {
        String path = request.getContextPath();
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    }

    @Override
    protected boolean preTemplateProcess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Template template, TemplateModel templateModel) throws ServletException, IOException {
        ((SimpleHash) templateModel).put(BASE_PATH, getBasePath(httpServletRequest));
        return true;
    }


}
