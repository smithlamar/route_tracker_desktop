/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.BusLine.Direction;
import model.BusLine.Stop;

/**
 *
 * @author Lamar
 */
public class RouteStop {
    private final String name;
    private final String color;
    private final Direction direction;
    private final Stop stop;

    /**
     *
     * @param name
     * @param color
     * @param direction
     * @param stop
     */
    public RouteStop(String name, String color, Direction direction, Stop stop) {
        this.name = name;
        this.color = color;
        this.direction = direction;
        this.stop = stop;
    }

    @Override
    public String toString() {
        return name + " " + direction + " | " + stop;
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
