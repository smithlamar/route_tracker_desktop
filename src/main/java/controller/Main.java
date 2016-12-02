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
package controller;

/**
 *
 * @author lsmith
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Controller controller = new Controller();
        controller.initBusLinesModel();
        controller.initAddedStopsModel();
        controller.initMyRoutesModel();
        controller.initHomeUI();
        controller.initAddRouteUI();
        
        // @TODO build TrainLinesModel
        // @TODO build home screen RouteDisplayModel
    }
}