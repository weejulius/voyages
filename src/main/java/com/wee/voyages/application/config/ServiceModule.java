package com.wee.voyages.application.config;

import com.google.inject.AbstractModule;
import com.wee.voyages.application.VoyageService;
import com.wee.voyages.application.impl.InspectingServiceImpl;
import com.wee.voyages.application.impl.VoyageServiceImpl;
import com.wee.voyages.domain.service.InspectingService;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 22:09:19
 */
public class ServiceModule extends AbstractModule {
    @Override
    final protected void configure() {
        bind(VoyageService.class).to(VoyageServiceImpl.class);
        bind(InspectingService.class).to(InspectingServiceImpl.class);
    }
}
