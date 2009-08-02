package com.wee.voyages.interfaces.config; /**
 *
 * User: weejulius
 * Date: 2009-7-16
 * Time: 22:15:11
 *
 */

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.wee.voyages.infrastructure.persistence.config.RepositoryModule;
import com.wee.voyages.infrastructure.persistence.config.sample.SampleData;
import com.wee.voyages.application.config.ServiceModule;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class ContextListener implements ServletContextListener{
    private final static String INJECTOR_NAME=Injector.class.getName();

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector=Guice.createInjector(new RepositoryModule(),new ServiceModule());
        ServletContext context= servletContextEvent.getServletContext();
        context.setAttribute(INJECTOR_NAME,injector);
         new SampleData().startup();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
       ServletContext context=servletContextEvent.getServletContext();
       context.removeAttribute(INJECTOR_NAME);
    }
}
