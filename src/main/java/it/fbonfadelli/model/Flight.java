package it.fbonfadelli.model;

import java.util.HashSet;

public class Flight {
    private int flightId;
    private Legs legs = new Legs();

    public Flight() {
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    int getFlightId() {
        return flightId;
    }

    public void setLegs(Legs legs) {
        this.legs = legs;
    }

    private Legs getLegs() {
        return legs;
    }

    public boolean isOneWay() {
        return legs.size() == 1;
    }

    public Leg getFirstLeg() {
        return getLegs().get(0);
    }

    public HashSet<String> getAirlineIds() {
        HashSet<String> airlineIds = new HashSet<>();

        for (Leg leg : getLegs()) {
            airlineIds.addAll(leg.getAirlineIds());
        }

        return airlineIds;
    }

    Leg getOutboundLeg() {
        return getFirstLeg();
    }

    Leg getReturnLeg() {
        if (isOneWay()) {
            throw new ReturnDataNotAvailableForOneWayException();
        }

        return getLegs().get(1);
    }
}