package main.drone;

import main.Constants;

import java.util.Random;

public class DroneState {
    private boolean inAir = false;
    private int height = -1;
    private int timeToPassengerArrival;
    private int timeToDestination = -1;

    public DroneState() {
        timeToPassengerArrival = new Random().nextInt(1, Constants.MAX_BOUND_FOR_PASSENGER_ARRIVAL + 1); // Initialize random time for passenger arrival
    }

    public boolean isInAir() {
        return inAir;
    }

    public void setInAir(boolean inAir) {
        this.inAir = inAir;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getTimeToPassengerArrival() {
        return timeToPassengerArrival;
    }

    public void setTimeToPassengerArrival(int timeToPassengerArrival) {
        this.timeToPassengerArrival = timeToPassengerArrival;
    }

    public int getTimeToDestination() {
        return timeToDestination;
    }

    public void setTimeToDestination(int timeToDestination) {
        this.timeToDestination = timeToDestination;
    }
}
