package com.mahir.airports;

import com.mahir.airports.exception.AirportNotFoundException;
import com.mahir.airports.exception.InvalidInputException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Airport Application interfaces
 * @author Mahir Ratanpara
 * @version 1.0
 * Contains all functions related to airport app.
 */
public class AirportApplication implements IAirportApplication {
    List<Airport> myAirports = null;

    public AirportApplication() {
        // to read the Airports.csv and Populate the data in the myAirports
        loadAirports();
    }

    /**
     * This loadAirports will get called when the application is loaded For time
     * as the call is from the constructor
     * This will read the file and has to parse file and then after parsing the file
     * convert it to airport class (Model)
     */
    private void loadAirports() {
        try {
            List<String> linesOfCSV = Files.readAllLines(Path.of("d:\\workspaces\\database\\airports.csv"));
            List<Airport> listAirports = linesOfCSV.stream().skip(1).map(eachLine -> {
                Airport airport = new Airport();
                String[] splitColumns = eachLine.split(",");
                airport.setName(splitColumns[3].replaceAll("\"", ""));
                airport.setType(splitColumns[2].replaceAll("\"", ""));
                return airport;
            }).collect(Collectors.toList());
            myAirports = listAirports;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Override
    /**
     * Where is my airports
     */
    public List<Airport> findAirportsByName(String searchString) throws InvalidInputException {
        if(searchString == null || searchString.length() == 0){
            throw new InvalidInputException();
        }
        List<Airport> filtered = myAirports.stream().filter(e -> e.getName().contains(searchString)).collect(Collectors.toList());
        /**
         * Throw a exception of no airports found if the string does match to any airport
         */
        if(filtered == null || filtered.size() == 0){
            throw new AirportNotFoundException();
        }
        return filtered;
    }

    public static void main(String[] args) {
        IAirportApplication app = new AirportApplication();
        try {
            List<Airport> searchResult = app.findAirportsByName("Newark ");
            for (Airport airport : searchResult) {
                System.out.println(airport.getName());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
