package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Output class used for printing messages:
public class Output {
    public static void printPassengerArrived(int droneNo){
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(time + ": Passenger arrived to drone " + droneNo + ".");
    }

    public static void printDroneRequestToTakeOffDenied(int droneNo){
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(time + ": Drone " + droneNo + " requested flight clearance and was denied.");
    }

    public static void printDroneRequestToTakeOffApproved(int droneNo, int height){
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(time + ": Drone " + droneNo + " requested flight clearance and was approved. Height: " + height + ".");
    }

    public static void printDroneArrivedToDestination(int droneNo){
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(time + ": Drone " + droneNo + " arrived to destination.");
    }
}
