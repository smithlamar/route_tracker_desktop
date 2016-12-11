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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.AddedStopsModel;
import model.BusLine;
import model.BusLine.Direction;
import model.BusLine.Stop;
import model.BusLinesModel;
import model.MyRoutesModel;
import model.Route;
import model.RouteStop;
import view.AddRouteUI;
import view.HomeUI;

/**
 *
 * @author lsmith
 */
public class Controller implements ActionListener, ListSelectionListener, ItemListener {

    private BusLinesModel busLinesModel;
    private AddedStopsModel addedStops;
    private MyRoutesModel myRoutesModel;
    private HomeUI homeUI;
    private AddRouteUI addRouteUI;

    /**
     * Creates a BusLinesModel object and initializes with information on each
     * bus line provided by the CTA API.
     */
    public void initBusLinesModel() {
        busLinesModel = new BusLinesModel();
        busLinesModel.initBusLines();
    }

    /**
     * Creates an AddedStopsModel object to hold any train and bus stops added
     * to the added stops window in the AddRouteUI.
     */
    public void initAddedStopsModel() {
        addedStops = new AddedStopsModel();
    }

    /**
     * Creates an MyRoutesModel object to hold all routes saved in the added
     * stops window in the AddRouteUI.
     */
    public void initMyRoutesModel() {
        myRoutesModel = new MyRoutesModel();
        myRoutesModel.loadMyRoutes();

    }

    /**
     * Starts the HomeUI view.
     */
    public void initHomeUI() {
        homeUI = new HomeUI();
        homeUI.setVisible(true);
        homeUI.getLstRoutes().setModel(myRoutesModel.getMyRoutes());

        homeUI.addBtnAddRouteListener(this);
        homeUI.addLstRoutesListener(this);
        homeUI.addLstTimesListener(this);
    }

    /**
     * Initializes an AddRouteUI view and ties it to the HomeUI. The view does
     * not become visible until an appropriate event is fired by the HomeUI
     * view. The controller is added as a listener on the relevant components.
     *
     * @TODO (Maybe) Change listener registration to be on handlers made for
     * each related set of components.
     */
    public void initAddRouteUI() {
        /* Create the form */
        addRouteUI = new AddRouteUI(homeUI, true);

        // Bus Listeners
        addRouteUI.addCmbBusSelectorListener(this);
        addRouteUI.addCmbBusDirectionSelectorListener(this);
        addRouteUI.addCmbStopSelectorListener(this);
        addRouteUI.addBtnBusAddStopListener(this);

        // Train Listeneres
        addRouteUI.addCmbTrainSelectorListener(this);
        addRouteUI.addCmbStationSelectorListener(this);
        addRouteUI.addCmbTrainDirectionSelectorListener(this);
        addRouteUI.addBtnTrainAddStopListener(this);

        // Other Listeners
        addRouteUI.addTxtFieldRouteNameListener(this);
        addRouteUI.addBtnSaveRouteListener(this);

        // Set Bus names
        addRouteUI.getCmbBusSelector().setModel(new DefaultComboBoxModel<>(busLinesModel.getBusLines()));
        updateBusDirections();
        updateBusStops();
    }

    /**
     * Initialize the list of elements from each of the BusLinesModel properties
     * into their related selectors.
     */
    private void updateBusDirections() {
        addRouteUI.getCmbBusDirectionSelector().setModel(
                new DefaultComboBoxModel<>(
                        ((BusLine) addRouteUI.getCmbBusSelector().getModel().
                        getSelectedItem()).getDirections()
                )
        );
    }

    private void updateBusStops() {
        addRouteUI.getCmbStopSelector().setModel(
                new DefaultComboBoxModel<>(
                        ((Direction) addRouteUI.getCmbBusDirectionSelector().getModel().
                        getSelectedItem()).getStops()
                )
        );
    }

    /**
     * All button messages from the views this controller is registered with
     * flow through this method.
     *
     * @TODO Push each message to a separate handler that contains the static
     * utility methods needed to handle each action instead of having every
     * single action tested and handled within the main controller class.
     * @param e The action event object created by the caller.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        System.out.println("Action: " + action + " performed.");

        if (action.contains("Add Route")) {
            addRouteUI.setVisible(true);
        }

        if (action.contains("Add Bus Stop To Route")) {
            // Get the current UI selections for the components of the bus stop.
            BusLine selectedBus = (BusLine) addRouteUI.getCmbBusSelector().getModel().getSelectedItem();
            Direction selectedDirection = (Direction) addRouteUI.getCmbBusDirectionSelector().getModel().getSelectedItem();
            Stop selectedStop = (Stop) addRouteUI.getCmbStopSelector().getModel().getSelectedItem();

            /* 
            * Create a RouteStop object representing the bus line, direction,
            * and stop combination selected in the UI.
             */
            RouteStop rtstp = new RouteStop(selectedBus.toString(), selectedBus.getRouteColor(), selectedDirection, selectedStop);

            boolean isDuplicateStop = false;
            for (RouteStop routeStop : addedStops.toArray()) {
                if (rtstp.toString().equals(routeStop.toString())) {
                    isDuplicateStop = true;
                    break;
                }
            }
            if (!isDuplicateStop) {
                addedStops.getAddedStops().addElement(rtstp);
                addRouteUI.getLstStopsAdded().setModel((addedStops.getAddedStops()));
            } else {
                // @TODO turn this into a small message dialog.
                System.out.println("This stop has already been added to the route.");
            }
        }

        if (action.contains("Save Route")) {

            String routeName = addRouteUI.getTxtFieldRouteName().getText();

            // Check that stops have actually been added to the route.
            if (addedStops.getAddedStops().isEmpty()) {
                // @TODO Convert exception print to proper message window.
                System.out.println("Please add at least 1 stop to your route.");
            } else // Save new route if routeName is not empty.
             if (!routeName.isEmpty()) {
                    boolean isDuplicateRoute = false;
                    for (Route route : myRoutesModel.toArray()) {
                        if (route.toString().equals(routeName)) {
                            isDuplicateRoute = true;
                            break;
                        }
                    }
                    if (isDuplicateRoute) {
                        // @TODO turn this into a small message dialog.
                        System.out.println("A route with this name already exists.");
                    } else {

                        myRoutesModel.getMyRoutes().addElement(new Route(routeName, addedStops.toArray()));
                        try {
                            myRoutesModel.saveMyRoutes();
                        } catch (IOException ex) {
                            System.out.println("saveMYRoutes() Error saving myRoutes: " + ex);
                        }
                        // Update the HomeUI with the new route.
                        homeUI.getLstRoutes().setModel(myRoutesModel.getMyRoutes());

                        // Clean up and hide addRouteUI.
                        addedStops.getAddedStops().clear();
                        addRouteUI.getLstStopsAdded().setModel(addedStops.getAddedStops());
                        addRouteUI.dispose();
                    }
                } else {
                    // @TODO Convert exception print to proper message window.
                    System.out.println("Please give your new route a name.");
                }
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("List selection changed on: " + e.getSource().toString());

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("Item selection changed on: " + e.getSource().toString());

        // Update addRouteUI Directions Selector
        if (e.getSource().hashCode() == addRouteUI.getCmbBusSelector().hashCode()) {
            updateBusDirections();

            // Update addRouteUI Stops Selector
            updateBusStops();
        }
        if (e.getSource().hashCode() == addRouteUI.getCmbBusDirectionSelector().hashCode()) {
            updateBusStops();
        }
    }

    /**
     * @return the busLinesModel
     */
    public BusLinesModel getBusLinesModel() {
        return busLinesModel;
    }

    /**
     * @return the homeUI
     */
    public HomeUI getHomeUI() {
        return homeUI;
    }

    /**
     * @return the addRouteUI
     */
    public AddRouteUI getAddRouteUI() {
        return addRouteUI;
    }
}
