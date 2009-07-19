package com.wee.voyages.interfaces.config;

import com.google.inject.servlet.ServletModule;
import com.wee.voyages.interfaces.voyage.controller.VoyageController;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 22:28:09
 */
public class ServletsModule extends ServletModule {
    @Override
    protected void configureServlets() {
        //super.configureServlets();
        serve("/voyage").with(VoyageController.class);

    }
}
