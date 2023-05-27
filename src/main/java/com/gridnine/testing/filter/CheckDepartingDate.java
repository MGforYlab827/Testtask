package com.gridnine.testing.filter;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.time.LocalDateTime;

public class CheckDepartingDate implements FlightFilter {
    @Override
    public boolean check(Flight flight) {
        LocalDateTime now = LocalDateTime.now();
        for (Segment segment : flight.getSegments()) {
            if (segment.getDepartureDate().isBefore(now)) {
                return false;
            }
        }
        return true;
    }
}
