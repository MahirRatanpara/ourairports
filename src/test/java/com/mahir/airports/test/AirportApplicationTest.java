package com.mahir.airports.test;

import com.mahir.airports.AirportApplication;
import com.mahir.airports.IAirportApplication;
import com.mahir.airports.exception.AirportNotFoundException;
import com.mahir.airports.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit Test
 * 1. Gives me gurantee what i deliver is what was asked
 * 2. I can refactor change and validate my code as required
 * 3. Test first allows me to get guaranteed  result as it will validated all the requirements
 * 4. If there is a defect its faster to find because i a specific test will fail
 * 5. impact analysis is easier to find as changes will break test and we can find the impacts
 * 6. percentage completion of work is possible when we deliver the code as number test case passed identifies the compltion
 * 7. if you write test cases you will also get coverage report
 * 8. Test cases are undestanding of your requirement which proves you understood what has to be delivered
 */
public class AirportApplicationTest {
    IAirportApplication app;

    @Test
    void testFindAirportsByNameInvalidInput() throws Exception {
        IAirportApplication app = new AirportApplication();
        assertThrows(InvalidInputException.class, () -> {
            app.findAirportsByName(null);
        });
    }

    @Test
    void testFindAirportsByNameValidInputChars() throws Exception {
        String regex = "[A-Z a-z 0-9]";
        // regex
        // this method sh\ould throw exception
        // when you call this method it should throws InvalidInputException if
        // the input is null
        //  app.findAirportsByName(null);
        assertTrue(Pattern.matches("", ""));
    }

    @Test
    void testFindAirportsByNameAirportFound() throws Exception {
        IAirportApplication app = new AirportApplication();
        assertTrue(app.findAirportsByName("Shivaji").size() > 0);
    }

    @Test
    void testFindAirportByNameAirportNotFound() {
        IAirportApplication app = new AirportApplication();
        assertThrows(AirportNotFoundException.class, () -> {
            app.findAirportsByName("93809820938adhlkjzhkjahfdska");
        });
    }
}

