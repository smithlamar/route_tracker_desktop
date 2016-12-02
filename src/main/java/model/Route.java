/*
 * Copyright (C) 2016 Lamar J. Smith
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package model;

/**
 *
 * @author lsmith
 */
public class Route {
    String name;
    RouteStop[] routeStops;

    public Route(String name, RouteStop[] routeStops) {
        this.name = name;
        this.routeStops = routeStops;
    }

    @Override
    public String toString() {
        return name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RouteStop[] getRouteStops() {
        return routeStops;
    }

    public void setRouteStops(RouteStop[] routeStops) {
        this.routeStops = routeStops;
    }
    
    
    
    
           
}
