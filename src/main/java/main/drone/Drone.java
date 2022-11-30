package main.drone;

import main.utils.Constants;
import main.ground.control.GroundControl;
import main.utils.Output;

import java.util.Random;

public class Drone {
    private final int serialNo;
    private final DroneState state;
    private final GroundControl groundControl;

    public Drone(int serialNo, GroundControl groundControl) {
        this.serialNo = serialNo;
        this.state = new DroneState();
        this.groundControl = groundControl;
    }

    // Updates Drone status. Prints relevant messages if needed.
    public void update() {
        Random rnd = new Random();
        if (state.isInAir()) { // Drone is in flight.
            state.setTimeToDestination(state.getTimeToDestination() - 1); // Decrement time to destination.
            if (state.getTimeToDestination() == 0) { // Drone arrived
                Output.printDroneArrivedToDestination(this.serialNo);
                state.setInAir(false);
                groundControl.declareLanding(state.getHeight());
                state.setTimeToPassengerArrival(rnd.nextInt(1, Constants.MAX_TIME_FOR_PASSENGER_ARRIVAL + 1)); // Set random time to passenger arrival.
            }
        } else { // Drone is on the ground
            state.setTimeToPassengerArrival(state.getTimeToPassengerArrival() - 1); // Decrement time to passenger arrival.
            if (state.getTimeToPassengerArrival() <= 0) { // passenger arrived
                if(state.getTimeToPassengerArrival() == 0){ // if passenger arrived now - print message:
                    Output.printPassengerArrived(serialNo);
                }
                state.setHeight(groundControl.askForPermission()); // request for unused height
                if(state.getHeight() != -1) { // if height == -1 then request for flight was denied (no available heights):
                    Output.printDroneRequestToTakeOffApproved(serialNo, state.getHeight());
                    state.setInAir(true);
                    int distance = rnd.nextInt(1, Constants.MAX_DISTANCE + 1);
                    state.setTimeToDestination(distance); // Set random distance (=time) to destination.
                } else {
                    Output.printDroneRequestToTakeOffDenied(serialNo);
                }
            }
        }
    }
}
