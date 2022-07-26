package com.mahir.airports;

import com.mahir.airports.exception.InvalidInputException;

import java.util.List;

/**
 * @author Mahir Ratanpara
 * @version 1.0
 * Contains all the function related to airport application
 */
public interface IAirportApplication {
    /**
     * Find all airport possibilities with the given string
     * @param string Should not be null Valid Values are only Strings and numbers
     * @return
     */
    List<Airport>  findAirportsByName(String string) throws InvalidInputException;
}
