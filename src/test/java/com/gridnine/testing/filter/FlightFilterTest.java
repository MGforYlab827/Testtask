package com.gridnine.testing.filter;

import com.gridnine.testing.Flight;
import com.gridnine.testing.FlightBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FlightFilterTest {

    List<Flight> flights = FlightBuilder.createFlights();

    @Test
    @DisplayName("checkDepartingDate")
    public void testCheckDepartingDate() {
        FlightFilter checkDepartingDate = new CheckDepartingDate();
        long act = flights.stream().filter(checkDepartingDate::check).count();
        long exc = flights.size() - 1;
        Assertions.assertEquals(exc, act);
    }

    @Test
    @DisplayName("checkPreArrivalDeparture")
    public void testCheckPreArrivalDeparture() {
        FlightFilter checkPreArrivalDeparture = new CheckPreArrivalDeparture();
        long act = flights.stream().filter(checkPreArrivalDeparture::check).count();
        long exc = flights.size() - 1;
        Assertions.assertEquals(exc, act);
    }

    @Test
    @DisplayName("checkLessTwoHoursGroundTime")
    public void testCheckLessTwoHoursGroundTime() {
        FlightFilter checkLessTwoHoursGroundTime = new CheckLessTwoHoursGroundTime();
        long act = flights.stream().filter(checkLessTwoHoursGroundTime::check).count();
        long exc = flights.size() - 2;
        Assertions.assertEquals(exc, act);
    }
}
