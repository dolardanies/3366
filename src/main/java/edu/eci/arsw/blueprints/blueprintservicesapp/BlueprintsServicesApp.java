/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.blueprintservicesapp;

import edu.eci.arsw.blueprints.services.BlueprintsServices;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author USER
 */

public class BlueprintsServicesApp {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices blueprintsServices = ac.getBean(BlueprintsServices.class);
        Point[] pts = new Point[]{new Point(0, 0), new Point(10, 10)};
        Blueprint bp = new Blueprint("john", "thepaint", pts);
        try {
            blueprintsServices.addNewBlueprint(bp);
            bp = new Blueprint("john", "Conceptual", pts);
            blueprintsServices.addNewBlueprint(bp);
            bp = new Blueprint("carl", "Xfiles", pts);
            blueprintsServices.addNewBlueprint(bp);
            System.out.println("Actually are " + blueprintsServices.getBlueprintsByAuthor("john").size() + " blueprints made by john.");
            for(Blueprint blueprint : blueprintsServices.getBlueprintsByAuthor("john")){
                System.out.println("---> " + blueprint.getName());
            }
            System.out.println("Actually are " + blueprintsServices.getBlueprintsByAuthor("carl").size() + " blueprints made by carl.");
            for(Blueprint blueprint : blueprintsServices.getBlueprintsByAuthor("carl")){
                System.out.println("---> " + blueprint.getName());
            }
        } catch (BlueprintPersistenceException | BlueprintNotFoundException e) {
            Logger.getLogger(BlueprintsServicesApp.class.getName()).log(Level.SEVERE, null, e);
        }
    }


}
