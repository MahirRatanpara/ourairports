package com.mahir.ourairport;

import com.mahir.ourairport.exception.InvalidInputException;

import java.util.List;

public interface IAirportApplication {
    /**
     * Should it be 1 airport / or more than airport
     * @param str null|valid values lat/long, code, name
     * @return array of airport names if found else null
     * @exception  InvalidInputException is returned when you dont have a valid input
     */
    List<String> findAirportBy(String str) throws InvalidInputException;
}
