package com.gridnine.testing.filter;

import com.gridnine.testing.Flight;

import java.time.temporal.ChronoUnit;

public class CheckLessTwoHoursGroundTime implements FlightFilter {

    @Override
    public boolean check(Flight flight) {
        long groundTime = 0;
        for (int i = 0; i < flight.getSegments().size() - 1; i++) {
            groundTime += flight.getSegments().get(i).getArrivalDate().until(flight.getSegments().get(i + 1).getDepartureDate(), ChronoUnit.MINUTES);
        }
        return groundTime < 120;
    }
}
