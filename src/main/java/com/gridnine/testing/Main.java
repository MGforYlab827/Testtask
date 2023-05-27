package com.gridnine.testing;

import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.filter.FlightFilterFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilterFactory filters = FlightFilterFactory.getInstance();
        List<Flight> flightsCheckedDepartingDate = getFilterFlights(flights, filters.getFilters().get(0));
        System.out.println(filters.getFilters().get(0).getClass().getName() + "\n" + flightsCheckedDepartingDate);
        List<Flight> flightsCheckedPreArrivalDeparture = getFilterFlights(flights, filters.getFilters().get(1));
        System.out.println(filters.getFilters().get(1).getClass().getName() + "\n" + flightsCheckedPreArrivalDeparture);
        List<Flight> flightsCheckedLessTwoHourGroup = getFilterFlights(flights, filters.getFilters().get(2));
        System.out.println(filters.getFilters().get(2).getClass().getName() + "\n" + flightsCheckedLessTwoHourGroup);
        System.out.println("List checked all filters");
        System.out.println(getFilterFlights(flights, filters));
    }

    public static List<Flight> getFilterFlights(List<Flight> flights, FlightFilter filter) {
        List<Flight> filterFlights = new ArrayList<>();
        for (Flight flight: flights) {
            if (filter.check(flight)) {
                filterFlights.add(flight);
            }
        }
        return filterFlights;
    }

    public static List<Flight> getFilterFlights(List<Flight> flights, FlightFilterFactory flightFilterFactory) {
        List<Flight> filterFlights = new ArrayList<>();
        boolean add = true;
        for (Flight flight : flights) {
            for (FlightFilter flightFilter : flightFilterFactory.getFilters()) {
                if (!flightFilter.check(flight)) {
                    add = false;
                    break;
                }
            }
            if (add) {
                filterFlights.add(flight);
            }
            add = true;
        }
        return filterFlights;
    }
}
