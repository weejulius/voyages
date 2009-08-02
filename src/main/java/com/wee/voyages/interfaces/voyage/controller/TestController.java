package com.wee.voyages.interfaces.voyage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: weejulius
 * Date: 2009-7-30
 * Time: 16:47:30
 */
public class TestController extends HttpServlet {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        long startTime = System.currentTimeMillis();
        httpServletRequest.getRequestDispatcher("/voyages/voyages.ftl").forward(httpServletRequest, httpServletResponse);
        long endTime = System.currentTimeMillis();//calendar.getTimeInMillis();
        log.debug("start at:{} ,end at:{},cost about {} mis", new Long[]{startTime, endTime, (endTime - startTime)});
    }
}
