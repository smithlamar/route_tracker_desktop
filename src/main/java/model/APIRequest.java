/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.BusLine.Direction;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import model.BusLine.Stop;

/**
 *
 * @author lsmith
 */
public class APIRequest {

    // Request compnents

    /**
     *
     */
    public static final String API_KEY = "?key=***REMOVED***";

    /**
     *
     */
    public static final String BUSTIME_REQUEST_BASE = "http://ctabustracker.com/bustime/api/v2/";

    /**
     *
     */
    public static final String F_JSON = "&format=json";

    /**
     *
     */
    public static final String RT = "&rt=";

    /**
     *
     */
    public static final String DIR = "&dir=";

    // Request types

    /**
     *
     */
    public static final String GET_BUS_ROUTES = "getroutes";

    /**
     *
     */
    public static final String GET_BUS_DIRECTIONS = "getdirections";

    /**
     *
     */
    public static final String GET_BUS_STOPS = "getstops";

    // Properties
    private final URL request;
    private JsonObject responseBody;

    // Constructors

    /**
     *
     * @param requestType
     * @throws MalformedURLException
     */
    public APIRequest(String requestType) throws MalformedURLException {
        // Build the request.
        request = new URL(BUSTIME_REQUEST_BASE + requestType + API_KEY + F_JSON);
    }

    /**
     *
     * @param requestType
     * @param urlParameters
     * @throws MalformedURLException
     */
    public APIRequest(String requestType, String... urlParameters) throws MalformedURLException {
        // Add the ? paramater designator at the beginning of each paramater.
        // Build the request.
        request = new URL((BUSTIME_REQUEST_BASE + requestType + API_KEY
                + Arrays.toString(urlParameters) + F_JSON).replaceAll("\\[", "")
                .replaceAll("]", "").replaceAll(",", "").replaceAll(" ", ""));
        
        System.out.println("Api request: " + request.toString());
    }

    /**
     * A JsonParser converts the response returned from request stream into a
     * JsonObject that is stored in the responseBody member variable.
     *
     * @throws java.io.IOException
     */
    public void send() throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(request.openStream())
        )) {
            // Parse the response into a JsonObject
            responseBody = new JsonParser().parse(reader).getAsJsonObject();
        }

    }

    /*
    * Extract the routes element from the responseBody JsonObject. We have to
    * dig to get to the array containg the BusList objects using nested get
    * methods. This is because the "routes" element is two levels deep contained
    * witin the "bustime-response" root level property.
     */

    /**
     *
     * @return
     */

    public BusLine[] parseRoutes() {

        JsonElement routesElement = responseBody.getAsJsonObject("bustime-response").get("routes");

        Gson gson = new Gson(); // Used for operations on Json related objects.

        // We use gson to isolate the "routes" element as it's own Json file.
        gson.toJson(routesElement);

        /* In order to pull the converted routes element in as an array with
        * Gson, we use a TypeToken to get the correct Type name for an ArrayList
        * of Type BusRoute. 
         */
        Type routeListType = new TypeToken<BusLine[]>() {
        }.getType();

        BusLine[] routes = new Gson().fromJson(routesElement, routeListType);

        return routes;
    }

    /*
    * Extract the directions element from the responseBody. We have to dig to
    * get at the inner array of Direction objects using nested get methods.
    * This is because the "directions" array element is two levels deep
    * contained witin the "bustime-response" root level property.
     */

    /**
     *
     * @return
     */

    public Direction[] parseDirections() {
        JsonElement directionsElement = responseBody.getAsJsonObject("bustime-response").get("directions");

        // Convert the JsonElement object in to a Json string using gson.
        Gson gson = new Gson();
        gson.toJson(directionsElement);

        // Find the proper type name of the Direction array list;
        Type dirListType = new TypeToken<BusLine.Direction[]>() {
        }.getType();

        // Use gson to convert from Json to the array of Direction objects.
        return new Gson().fromJson(directionsElement, dirListType);
    }
    
    /**
     *
     * @return
     */
    public Stop[] parseStops() {
        JsonElement stopsElement = responseBody.getAsJsonObject("bustime-response").get("stops");

        // Convert the JsonElement object in to a Json string using gson.
        Gson gson = new Gson();
        gson.toJson(stopsElement);

        // Find the proper type name of the Direction array list;
        Type stopsListType = new TypeToken<Stop[]>() {
        }.getType();

        // Use gson to convert from Json to the array of Direction objects.
        return new Gson().fromJson(stopsElement, stopsListType);        
    }

    /**
     *
     * @return
     */
    public JsonObject getResponseBody() {
        return responseBody;
    }
}
