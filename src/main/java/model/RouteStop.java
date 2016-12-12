/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.net.MalformedURLException;
import model.BusLine.Direction;
import model.BusLine.Stop;

/**
 * RouteStop represents a stop assigned to a saved route. It encompasses the
 * busLine related to the stop, the direction of the busLine and the stop itself.
 * @author Lamar
 */
public class RouteStop {
    private final String rt;
    private final String name;
    private final String color;
    private final Direction direction;
    private final Stop stop;

    /**
     * @param rt The route number for this stop.
     * @param name The stop name.
     * @param color
     * @param direction
     * @param stop
     */
    public RouteStop(String rt, String name, String color, Direction direction, Stop stop) {
        this.rt = rt;
        this.name = name;
        this.color = color;
        this.direction = direction;
        this.stop = stop;
    }
    
    public Prediction[] getTimes()throws MalformedURLException, IOException {
        APIRequest request = new APIRequest(APIRequest.GET_BUS_PREDICTIONS, APIRequest.RT + rt, APIRequest.STPID + stop.getStpid() + APIRequest.TOP + 2);
        request.send();
        return request.parsePredictions();
    }
    
    @Override
    public String toString() {
        return name + " " + direction + " | " + stop;
    }
    
    /**
     * @return the route number
     */
    public String getRt() {
        return rt;
    }   
 
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @return the stop
     */
    public Stop getStop() {
        return stop;
    }
}
