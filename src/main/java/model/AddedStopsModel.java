/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Enumeration;
import javax.swing.DefaultListModel;

/**
 *
 * @author Lamar
 */
public class AddedStopsModel {

    private final DefaultListModel<RouteStop> addedStops;

    /**
     * Default constructor.
     */
    public AddedStopsModel() {
        addedStops = new DefaultListModel<>();
    }

    /**
     * @return the addedStops
     */
    public DefaultListModel<RouteStop> getAddedStops() {
        return addedStops;
    }


    /**
     *
     * @return
     */
    public RouteStop[] toArray() {        
        RouteStop[] routeArray = new RouteStop[addedStops.size()];
        
        int count = 0;
        for (Enumeration<RouteStop> e = addedStops.elements(); e.hasMoreElements();) {
            routeArray[count++] = e.nextElement();
        }        
        return routeArray;
    }
}
