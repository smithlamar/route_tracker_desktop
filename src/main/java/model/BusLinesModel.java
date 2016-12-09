/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.util.Date;

/**
 *
 * @author lsmith
 */
public class BusLinesModel {

    // Constants
    /**
     * Path to a JSON where downloaded bus lines are stored. This is rebuilt
     * automatically should the file be deleted. It also updated every 2 weeks
     * (roughly).
     */
    public static final File BUS_LINES_PATH = new File("bus_lines.json");

    /**
     * Proper type name to pass to Gson when building or grabbing a Json file.
     */
    public static final Type BUS_LINES_TYPE = new TypeToken<BusLine[]>() {
    }.getType();

    // Properties
    private BusLine[] busLines;

    /**
     *
     */
    public void initBusLines() {
        long date = new Date().getTime();
        if (BUS_LINES_PATH.exists() && (BUS_LINES_PATH.lastModified() - date) < 12500) {
            try {
                loadBusLines();
            } catch (FileNotFoundException ex) {
                System.out.println("loadBusLines() Could not find" + BUS_LINES_PATH + "Attempting download: " + ex);
            } catch (IOException ex) {
                System.out.println("loadBusLines() IOException: " + ex);
            }
        } else {
            try {
                refreshBusLines();
            } catch (MalformedURLException ex) {
                System.out.println("refreshBusLines() bad URL: " + ex);
            } catch (IOException ex) {
                System.out.println("refreshBusLines() Could not download new bus list: " + ex);
            }
        }
    }

    /**
     *
     * @return
     */
    public BusLine[] getBusLines() {
        return this.busLines;
    }

    /**
     * Initializes the busLines property with a list of bus lines downloaded
     * from the CTA Bus Tracker API. This list is also stored locally in a JSON
     * file to prevent the need for unnecessary API requests every time the
     * model needs to get the list, such as when the app has restarted.
     *
     * @throws MalformedURLException
     * @throws IOException
     */
    public void refreshBusLines() throws MalformedURLException, IOException {
        APIRequest request = new APIRequest(APIRequest.GET_BUS_ROUTES);
        request.send();
        busLines = request.parseRoutes();
        refreshDirectionsAndStops();
        saveBusLines();
    }

    /**
     * Loads the bus lines from the local JSON file.
     *
     * @throws FileNotFoundException
     */
    public void loadBusLines() throws FileNotFoundException, IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(BUS_LINES_PATH))) {
            busLines = new Gson().fromJson(in, BUS_LINES_TYPE);
        }
    }

    /**
     *
     * @throws IOException
     */
    public void refreshDirectionsAndStops() throws IOException {
        for (BusLine line : busLines) {
            line.refreshDirections();
            line.refreshStops();
        }
    }

    private void saveBusLines() throws IOException {
        System.out.println("saveBusLines() Saving buslines...");
        try {
            Files.deleteIfExists(BUS_LINES_PATH.toPath());
        } catch (IOException e) {
            System.out.println("saveBusLines() Failed to delete " + BUS_LINES_PATH + " prior to saving: " + e);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BUS_LINES_PATH))) {
            writer.append(new Gson().toJson(busLines, BUS_LINES_TYPE));
        }
    }
}
