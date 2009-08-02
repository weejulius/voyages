package com.wee.voyages.interfaces.voyage.controller;

import com.google.inject.Inject;
import com.wee.voyages.application.VoyageService;
import com.wee.voyages.application.validatation.rule.NoSuchRequestParameter;
import com.wee.voyages.domain.model.customer.CustomerRepository;
import com.wee.voyages.domain.model.voyage.Ship;
import com.wee.voyages.domain.model.voyage.Voyage;
import com.wee.voyages.domain.model.voyage.VoyageRepository;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * User: weejulius
 * Date: 2009-7-13
 * Time: 20:45:24
 */


public class VoyageController extends Controller {
    @Inject
    private VoyageService voyageService;
    @Inject
    private VoyageRepository voyageRepository;
    @Inject
    private CustomerRepository customerRepository;

    /**
     * As a user
     * I want to new a voyage
     *
     * @param reqAndResp request and response holder
     * @throws IOException
     * @throws ServletException
     */
   
    public void create(ReqAndResp reqAndResp) throws IOException, ServletException {
        try {
            final Long shipId = reqAndResp.getLong("ship");
            displayCreatedVoyage(reqAndResp, shipId);
        } catch (NoSuchRequestParameter e) {
            displayCreateForm(reqAndResp);
        }
    }

    /**
     * retrieve all the voayges.
     *
     * @param reqAndResp request and response holder
     * @throws IOException      io exception
     * @throws ServletException servlet exception
     */

    public void list(ReqAndResp reqAndResp) throws IOException, ServletException {
        transaction().begin();
        List<Voyage> voyages = voyageRepository.list();
        Controllers.load(reqAndResp, "voyages", voyages).forward(view("origin"));
        transaction().close();
    }


    public void start(ReqAndResp reqAndResp) throws IOException, ServletException {
        Long voyageId = reqAndResp.getLong("id");
        transaction().begin();
        voyageService.start(voyageId);
        transaction().close();
        Controllers.load(reqAndResp, "voyage", voyageId + " has started").redirect("/voyages/voyage/" + voyageId);
    }


    public void end(ReqAndResp reqAndResp) throws IOException, ServletException {
        Long voyageId = reqAndResp.getLong("id");
        transaction().begin();
        voyageService.end(voyageId);
        transaction().close();
        Controllers.load(reqAndResp, "voyage", voyageId + " has started").redirect("/voyages/voyage/" + voyageId);
    }

 
    public void index(ReqAndResp reqAndResp) throws IOException, ServletException {
        Long voyageId = reqAndResp.getLong("id");
        transaction().begin();
        Voyage voyage = voyageRepository.find(voyageId);
        Controllers.load(reqAndResp, "voyage", voyage).forward(view("index"));
        transaction().close();
    }

    private void displayCreateForm(ReqAndResp reqAndResp) throws IOException, ServletException {
        List<Ship> ships = ships();
        Controllers.load(reqAndResp, "ships", ships).forward(view("new"));
    }

    private void displayCreatedVoyage(ReqAndResp reqAndResp, Long shipId) throws IOException, ServletException {
        Voyage voyage = newVoyage(shipId);
        Controllers.load(reqAndResp, "voyage", voyage).redirect("/voyages/voyage/" + voyage.id());
    }

    private Voyage newVoyage(Long shipId) {
        transaction().begin();
        Voyage voyage = voyageService.newVoyage(shipId);
        transaction().close();
        return voyage;
    }

    private List<Ship> ships() {
        transaction().begin();
        List<Ship> ships = voyageRepository.listShip();
        transaction().close();
        return ships;
    }


}
