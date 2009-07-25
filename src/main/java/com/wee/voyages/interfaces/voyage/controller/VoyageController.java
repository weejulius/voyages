package com.wee.voyages.interfaces.voyage.controller;

import com.google.inject.*;
import com.wee.voyages.application.VoyageService;
import com.wee.voyages.domain.model.customer.Customer;
import com.wee.voyages.domain.model.customer.CustomerRepository;
import com.wee.voyages.domain.model.customer.IDCardNum;
import com.wee.voyages.domain.model.customer.Sex;
import com.wee.voyages.domain.model.voyage.Ship;
import com.wee.voyages.domain.model.voyage.Voyage;
import com.wee.voyages.domain.model.voyage.VoyageNum;
import com.wee.voyages.domain.model.voyage.VoyageRepository;
import com.wee.voyages.infrastructure.persistence.config.EntityManagerBinder;
import com.wee.voyages.infrastructure.persistence.config.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 20:45:24
 */
@Singleton
public class VoyageController extends HttpServlet {
    @Inject
    private VoyageService voyageService;
    @Inject
    private VoyageRepository voyageRepository;
    @Inject
    private CustomerRepository customerRepository;
    @Inject
    private EntityManagerBinder binder;

    private Logger log = LoggerFactory.getLogger(VoyageController.class);

    @Override
    public void init() throws ServletException {
        super.init();
        Injector injector = (Injector) getServletContext().getAttribute(Injector.class.getName());
        injector.injectMembers(this);
        Map<Key<?>, Binding<?>> bindings = injector.getBindings();
        for (Map.Entry<Key<?>, Binding<?>> binding : bindings.entrySet()) {
            log.debug("key:" + binding.getKey() + "    |      binding:" + binding.getValue());
        }
        // new SampleData().startup();

    }

    @Override
    @Transactional
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        String action = httpServletRequest.getParameter("action");
        String idcardNum = httpServletRequest.getParameter("idcardNum");
        VoyageNum voyageNum = new VoyageNum(httpServletRequest.getParameter("voyageNum"));
        log.debug("action is " + action);


        binder.begin();
        Voyage voyage = null;
        if ("new".equals(action)) {
            Ship ship = voyageRepository.findShip("Seewt");
            voyage = voyageService.newVoyage(voyageNum, ship);
            log.debug("voyage added.");
        } else if ("start".equals(action)) {
            voyage = voyageRepository.find(voyageNum);
            voyageService.start(voyage);
            log.debug("voyage " + voyage.voyageNum() + " started.");
        } else if ("end".equals(action)) {
            voyage = voyageRepository.find(voyageNum);
            voyageService.end(voyage);
            log.debug("voyage end.");
        }

        if (idcardNum != null) {
            log.debug("carry a model.");
            Customer customer = new Customer(new IDCardNum(idcardNum), Sex.female, null, null, null, null, null, null);
            customerRepository.store(customer);
            voyageService.carry(voyage, customer);
        }
        binder.close();


    }


}
