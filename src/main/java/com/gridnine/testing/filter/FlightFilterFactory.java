package com.gridnine.testing.filter;

import java.util.ArrayList;
import java.util.List;

public class FlightFilterFactory {

    private static FlightFilterFactory flightFilterFactory = null;
    private List <FlightFilter> filters;
    private FlightFilterFactory() {
        filters = new ArrayList<>();
        filters.add(new CheckDepartingDate());
        filters.add(new CheckPreArrivalDeparture());
        filters.add(new CheckLessTwoHoursGroundTime());
    }

    public static FlightFilterFactory getInstance() {
        if (flightFilterFactory == null) {
            flightFilterFactory = new FlightFilterFactory();
        }
        return flightFilterFactory;
    }

    public List<FlightFilter> getFilters() {
        return filters;
    }
}
