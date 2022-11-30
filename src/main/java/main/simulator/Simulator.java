package main.simulator;

import main.utils.Constants;
import main.drone.Drone;
import main.ground.control.GroundControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Simulator {
    private final List<Drone> droneList;
    private int ticker;
    private final Timer timer;

    public Simulator() {
        GroundControl groundControl = new GroundControl();
        this.droneList = new ArrayList<>(Constants.DRONES_AMOUNT);
        for (int i = 0; i < Constants.DRONES_AMOUNT; i++) {
            droneList.add(new Drone(i + 1, groundControl));
        }
        this.ticker = 0;
        this.timer = new Timer();
    }

    public void startSimulation() {
        System.out.println("\n==================\n");
        System.out.println("Simulation Started:");
        System.out.println("\n==================\n");

        beginTimer();
    }

    private void beginTimer() {
        long period = 1000L * Constants.SECONDS_FOR_RATE; // Note: for faster simulations: lower the SECONDS_FOR_RATE constant.
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (ticker == Constants.DURATION) { // Finished time duration
                    this.cancel();
                    finishSimulation();
                } else {
                    droneList.forEach(Drone::update); // Update drone status each tick.
                    ticker++;
                }
            }
        }, 0, period);
    }

    private void finishSimulation() {
        timer.cancel();
        System.out.println("\n==================\n");
        System.out.println("Simulation Ended");
        System.out.println("\n==================\n");
    }


}