package com.wee.voyages.interfaces.config;

import com.google.inject.Injector;
import com.google.inject.Guice;
import com.google.inject.servlet.GuiceServletContextListener;
import com.wee.voyages.application.config.ServiceModule;
import com.wee.voyages.infrastructure.persistence.config.RepositoryModule;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 22:24:14
 */
public class ServletConfig extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new RepositoryModule(),new ServiceModule(),new ServletsModule());
    }
}
