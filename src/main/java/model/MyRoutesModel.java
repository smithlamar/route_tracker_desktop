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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Enumeration;
import javax.swing.DefaultListModel;

/**
 *
 * @author lsmith
 */
public class MyRoutesModel {

    // Constants
    /**
     * Path to a JSON where downloaded bus lines are stored. This is rebuilt
     * automatically should the file be deleted. It also updated every 2 weeks
     * (roughly).
     */
    public static final File MY_ROUTES_PATH = new File("my_routes.json");

    /**
     * Proper type name to pass to Gson when building or grabbing a Json file.
     */
    public static final Type MY_ROUTES_TYPE = new TypeToken<DefaultListModel<Route>>() {
    }.getType();

    // Properties
    private DefaultListModel<Route> myRoutes;

    // Constructor
    public MyRoutesModel() {
        myRoutes = new DefaultListModel<>();
    }

    public Route[] toArray() {

        Route[] routeArray = new Route[myRoutes.size()];

        int count = 0;
        for (Enumeration<Route> e = myRoutes.elements(); e.hasMoreElements();) {
            routeArray[count++] = e.nextElement();
        }
        return routeArray;
    }

    /**
     *
     * @throws IOException if there is an issue writing to file.
     */
    public void saveMyRoutes() throws IOException {
        File temp = new File("temp.json");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(temp))) {
            writer.append(new Gson().toJson(myRoutes, MY_ROUTES_TYPE));
        } catch (IOException e) {
            System.out.println("Route not saved. Could not save file to " + temp + ": " + e);
        }
        Files.move(temp.toPath(), MY_ROUTES_PATH.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    public void loadMyRoutes() {
        try (BufferedReader in = new BufferedReader(new FileReader(MY_ROUTES_PATH))) {
            myRoutes = new Gson().fromJson(in, MY_ROUTES_TYPE);
        } catch (IOException ex) {
            System.out.println("loadMyRoutes() No my routes file present - exception: " + ex);
            System.out.println(MY_ROUTES_PATH + " will be rebuilt when a new route is created.");
        }
    }

    /**
     * Get the value of myRoutes
     *
     * @return the value of myRoutes
     */
    public DefaultListModel<Route> getMyRoutes() {
        return myRoutes;
    }

}
