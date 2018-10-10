/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.blueprintservicesapp;

import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class BlueprintsServicesApp {

    private BlueprintsServices blueprintsServices;

    @Autowired
    public void setBlueprintsServices(BlueprintsServices blueprintsServices) {
        this.blueprintsServices = blueprintsServices;
    }

    public BlueprintsServices getBlueprintsServices() {
        return blueprintsServices;
    }


}
