package main;

import main.simulator.Simulator;

public class Main {
    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        simulator.startSimulation(Constants.DURATION);
    }
}