package com.gridnine.testing.filter;

import com.gridnine.testing.Flight;

public class CheckPreArrivalDeparture implements FlightFilter{
    @Override
    public boolean check(Flight flight) {
        if (flight.getSegments().size() == 1) {
            if (flight.getSegments().get(0).getDepartureDate().isAfter(flight.getSegments().get(0).getArrivalDate())) {
                return false;
            }
        } else {
            for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                if (flight.getSegments().get(i).getDepartureDate().isAfter(flight.getSegments().get(i).getArrivalDate()) ||
                    flight.getSegments().get(i).getArrivalDate().isAfter(flight.getSegments().get(i + 1).getDepartureDate())) {
                    return false;
                }
            }
        }
        return true;
    }
}
